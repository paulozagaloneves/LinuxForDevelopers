# Tutorial: Debian 13 Cloud no Windows com QEMU + cloud-init

## Índice

- [1) Pré-requisitos](#1-pré-requisitos)
- [O que é o QEMU e para que serve](#o-que-é-o-qemu-e-para-que-serve)
    - [Conceitos técnicos importantes](#conceitos-técnicos-importantes)
- [2) Instalar QEMU no Windows](#2-instalar-qemu-no-windows)
- [3) Preparar diretório de trabalho](#3-preparar-diretório-de-trabalho)
- [4) Downlaod da imagem Debian 13 Cloud (qcow2)](#4-downlaod-da-imagem-debian-13-cloud-qcow2)
- [5) Criar ficheiros cloud-init](#5-criar-ficheiros-cloud-init)
    - [O que é o cloud-init e para que serve](#o-que-é-o-cloud-init-e-para-que-serve)
- [6) Servir cloud-init por HTTP (NoCloud-Net)](#6-servir-cloud-init-por-http-nocloud-net)
- [7) Executar a VM](#7-executar-a-vm)
- [8) Aceder via SSH](#8-aceder-via-ssh)
- [9) Verificações dentro da VM](#9-verificações-dentro-da-vm)




## 1) Pré-requisitos

- Windows 10/11
- PowerShell
- Virtualização ativada (Intel VT-x/AMD-V)
- Python 3 (para servir ficheiros cloud-init via HTTP)

---

## O que é o QEMU e para que serve

O **QEMU (Quick Emulator)** é uma plataforma de **emulação** e **virtualização** de máquinas. Permite executar sistemas operativos convidados (guest) num host, simulando CPU, memória, disco, rede e dispositivos virtuais.

No contexto deste tutorial, o QEMU é usado para:

- executar a imagem Debian Cloud (`.qcow2`) localmente no Windows;
- criar um disco de trabalho em **overlay** (`qemu-img create -b`), preservando a imagem base;
- expor a rede da VM com `hostfwd` para acesso por SSH (`127.0.0.1:2222 -> guest:22`);
- injetar configuração inicial com **cloud-init** via `NoCloud-Net` (`meta-data`/`user-data` por HTTP).

### Conceitos técnicos importantes

- **Emulação vs virtualização:**
    - emulação reproduz outra arquitetura (ex.: ARM em x86), com maior custo de desempenho;
    - virtualização executa a mesma arquitetura do host com aceleração por hardware (melhor desempenho).
- **Formato QCOW2:** suporta snapshots, thin provisioning e overlays.
- **Virtio:** paravirtualização de disco/rede para melhor desempenho em guests Linux.
- **Aceleração:** sem acelerador, o QEMU usa `tcg` (emulação por software). Em Linux, normalmente usa-se `KVM` para desempenho próximo do nativo.

---

## 2) Instalar QEMU no Windows

[QEMU](https://www.qemu.org/)
[QEMU Windows Install](https://qemu.weilnetz.de/w64/qemu-w64-setup-20251217.exe)



```powershell
winget install qemu.qemu
```

ou instalar o ficheiro [qemu-w64-setup-20251217.exe](https://qemu.weilnetz.de/w64/qemu-w64-setup-20251217.exe)

Feche e abra o terminal. Valide:

```powershell
C: >  qemu-system-x86_64 --version
QEMU emulator version 10.2.0 (v10.2.0-12105-g0f12d445bd)
Copyright (c) 2003-2025 Fabrice Bellard and the QEMU Project developers

C: > ❯ qemu-img --version
qemu-img version 10.2.0 (v10.2.0-12105-g0f12d445bd)
Copyright (c) 2003-2025 Fabrice Bellard and the QEMU Project developers
```

---

## 3) Preparar diretório de trabalho

```powershell
mkdir C:\lab\debian13-cloud
cd C:\lab\debian13-cloud
mkdir cloud-init
```

---

## 4) Downlaod da imagem Debian 13 Cloud (qcow2)

> Ajuste a URL se o nome do ficheiro mudar no repositório oficial.

```powershell
curl.exe -L -o debian13-cloud.qcow2 https://cloud.debian.org/images/cloud/trixie/latest/debian-13-genericcloud-amd64.qcow2
```

Criar um disco (formato overlay) para a nova VM:

```powershell
qemu-img create -f qcow2 -b debian13-cloud.qcow2 debian13-vm.qcow2 20G
```

> **O que é o overlay?**
>
> O ficheiro `debian13-vm.qcow2` funciona como um disco *filho* da imagem base `debian13-cloud.qcow2`.
> A imagem base mantém-se inalterada e todas as alterações da VM (instalações, ficheiros e configurações)
> são gravadas no overlay. Isto reduz consumo de espaço e facilita criar/recriar VMs a partir da mesma base.



---





## 5) Criar ficheiros cloud-init

### O que é o cloud-init e para que serve

O **cloud-init** é o mecanismo de configuração inicial automática de máquinas virtuais em imagens cloud.
No primeiro arranque, lê dados como `user-data` e `meta-data` a partir de uma fonte de dados
(por exemplo, `NoCloud`, `NoCloud-Net`, ISO ou serviço de metadata) e aplica tarefas de bootstrap.

No contexto deste laboratório, o cloud-init é usado para:

- definir o `hostname`;
- criar e configurar o utilizador `debian`;
- configurar autenticação SSH;
- instalar pacotes (ex.: `qemu-guest-agent`);
- executar comandos finais via `runcmd`.


### `cloud-init\user-data`
```yaml
#cloud-config
hostname: debian13
bootcmd:
  - [ growpart, /dev/vda, 1 ]
resize_rootfs: true
users:
    - name: debian
        groups: [sudo]
        shell: /bin/bash
        sudo: ALL=(ALL) NOPASSWD:ALL
        lock_passwd: false
        passwd: "$6$UgyWksT12MxjgIZh$nRFp41TBismnC7aXLoV8r7E7mqqvMgANfc8HU2UudOHPZVwMzPQICKMZy16Zgaid.THuHXaEPaH791uN8AdlK/"

ssh_pwauth: true
chpasswd:
    expire: false

package_update: true
packages:
    - qemu-guest-agent

runcmd:
    - systemctl enable --now qemu-guest-agent
```

> Palavra-passe do utilizador `debian`: `debian.2026` (hash já aplicado no ficheiro).

> Para gerar uma password diferente use o comando abaixo no powershell:

```powershell
C: > openssl passwd -6
Password:

Verifying - Password:

$6$iD.kZ6gha/hEFaOI$ifPPCEfIkOKf2DZW7T0KXCzLoZE8VawBeqYF1QpxiZNbIMfPe/7UC/2N52bZecec5Ttav9cMXE.7pvw6A3Q1b0
```

### `cloud-init\meta-data`
```yaml
instance-id: debian13-01
local-hostname: debian13
```

---

## 6) Servir cloud-init por HTTP (NoCloud-Net)

No diretório `C:\lab\debian13-cloud\cloud-init`:

```powershell
cd C:\lab\debian13-cloud\cloud-init
python -m http.server 8000
```

Deixe esta janela aberta.

---

## 7) Executar a VM

Noutro terminal (em `C:\lab\debian13-cloud`):

```powershell
cd C:\lab\debian13-cloud

qemu-system-x86_64 `
    -machine q35,accel=tcg `
    -m 2048 `
    -smp 2 `
    -drive file=debian13-vm.qcow2,if=virtio,format=qcow2 `
    -nic user,hostfwd=tcp::2222-:22 `
    -smbios type=1,serial=ds=nocloud-net;s=http://10.0.2.2:8000/ `
    -nographic
```

> Se `-nographic` não for desejado, remova esse parâmetro para abrir janela gráfica.

---

## 8) Aceder via SSH

Após boot (~1–2 min):

```powershell
ssh debian@127.0.0.1 -p 2222
```

Palavra-passe: `debian.2026`

---

## 9) Verificações dentro da VM

```bash
$ cloud-init status --wait
$ id
$ hostnamectl
```

Se `status: done`, o provisionamento cloud-init foi aplicado com sucesso.
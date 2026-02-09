# Manual de Instalação do Ubuntu 24.04 Desktop

## Índice

- [Manual de Instalação do Ubuntu 24.04 Desktop](#manual-de-instalação-do-ubuntu-2404-desktop)
  - [Índice](#índice)
  - [Requisitos do Sistema](#requisitos-do-sistema)
    - [Requisitos Mínimos](#requisitos-mínimos)
    - [Requisitos Recomendados](#requisitos-recomendados)
  - [Videos](#videos)
  - [Preparação](#preparação)
    - [1. Transferência da ISO](#1-transferência-da-iso)
    - [2. Criar Mídia de Instalação](#2-criar-mídia-de-instalação)
      - [No Windows](#no-windows)
      - [No Linux](#no-linux)
  - [Processo de Instalação](#processo-de-instalação)
    - [1. Arranque](#1-arranque)
    - [2. Ecrã de Boas-vindas](#2-ecrã-de-boas-vindas)
    - [3. Configurações Iniciais](#3-configurações-iniciais)
      - [Teclado](#teclado)
      - [Actualizações e Software](#actualizações-e-software)
    - [4. Tipo de Instalação](#4-tipo-de-instalação)
      - [Opção 1: Apagar disco e instalar Ubuntu (Recomendado para principiantes)](#opção-1-apagar-disco-e-instalar-ubuntu-recomendado-para-principiantes)
      - [Opção 2: Dual Boot (Manter outro sistema operativo)](#opção-2-dual-boot-manter-outro-sistema-operativo)
      - [Opção 3: Particionamento Manual (Utilizadores avançados)](#opção-3-particionamento-manual-utilizadores-avançados)
    - [5. Criação de Utilizador](#5-criação-de-utilizador)
    - [6. Localização](#6-localização)
    - [7. Instalação](#7-instalação)
    - [8. Conclusão](#8-conclusão)
  - [Configurações Pós-Instalação](#configurações-pós-instalação)
    - [1. Primeiro Arranque](#1-primeiro-arranque)
    - [2. Actualizar o Sistema](#2-actualizar-o-sistema)
    - [3. Instalar Controladores Adicionais](#3-instalar-controladores-adicionais)
    - [4. Instalar Software Essencial](#4-instalar-software-essencial)
    - [5. Configurar Firewall](#5-configurar-firewall)
  - [Resolução de Problemas Comuns](#resolução-de-problemas-comuns)
    - [Arranque não encontra o Ubuntu](#arranque-não-encontra-o-ubuntu)
    - [Problemas com Wi-Fi](#problemas-com-wi-fi)
    - [Ecrã preto após instalação](#ecrã-preto-após-instalação)
    - [Dual Boot não mostra Windows](#dual-boot-não-mostra-windows)
  - [Recursos Úteis](#recursos-úteis)
  - [Comandos Úteis Pós-Instalação](#comandos-úteis-pós-instalação)
  - [Conclusão](#conclusão)

## Requisitos do Sistema

### Requisitos Mínimos

- **Processador**: 2 GHz dual core
- **Memória RAM**: 4 GB
- **Espaço em disco**: 25 GB
- **Resolução de ecrã**: 1024 x 768

### Requisitos Recomendados

- **Processador**: 3 GHz dual core ou superior
- **Memória RAM**: 8 GB ou mais
- **Espaço em disco**: 50 GB ou mais
- **Resolução de ecrã**: 1920 x 1080 ou superior

## Videos

1. [Learn Linux TV - How to Install Ubuntu 24.04 Desktop: Complete Beginner's Guide](https://www.youtube.com/watch?v=zE7OYNkuQ1w)
2. [Nerd on the Street - How to Install Ubuntu 24.04 LTS](https://www.youtube.com/watch?v=WiW4KN2rNZY)
3. [Luba Linux - Como Baixar e Instalar o Ubuntu 24.04](https://www.youtube.com/watch?v=ehn8sgyH8mo)            # PT-BR
4. [Learn Linux TV - How to Deploy Ubuntu 24.04 LTS: Step-by-Step Installation Overview](https://www.youtube.com/watch?v=pln-tglFxwg)  # Install on Proxmox

## Preparação

### 1. Transferência da ISO

1. Aceda ao sítio oficial: [https://ubuntu.com/download/desktop](https://ubuntu.com/download/desktop)
2. Descarregue o Ubuntu 24.04 LTS Desktop (ficheiro .iso)
3. Verifique a integridade da transferência utilizando o checksum SHA256

### 2. Criar Mídia de Instalação

#### No Windows

1. Descarregue o **[Rufus](https://rufus.ie/en/)**, **[balenaEtcher](https://etcher.balena.io/)** ou **[Ventoy](https://www.ventoy.net/en/index.html)**
2. Insira uma pen USB (mínimo 4 GB)
3. Abra o Rufus/Etcher/Ventoy e seleccione a ISO do Ubuntu
4. Seleccione a pen USB como destino
5. Clique em "Iniciar" e aguarde a conclusão

#### No Linux

```bash
# Identifique o dispositivo USB
lsblk

# Crie a pen USB de arranque (substitua /dev/sdX pelo seu dispositivo)
sudo dd if=ubuntu-24.04-desktop-amd64.iso of=/dev/sdX bs=4M status=progress && sync
```

## Processo de Instalação

### 1. Arranque

1. Insira a pen USB no computador
2. Reinicie o computador
3. Entre no menu de arranque (geralmente F12, F2, ESC ou DEL)
4. Seleccione a pen USB como dispositivo de arranque

### 2. Ecrã de Boas-vindas

1. Aguarde o carregamento do Ubuntu

![Iniciar instalação](../images/install_ubuntu_desktop_005.png)
2. Seleccione o idioma (Português)
3. Clique em **"Instalar Ubuntu"** ou **"Experimentar Ubuntu"** (para testar sem instalar)

![Ecrã de instalação do Ubuntu Desktop](../images/install_ubuntu_desktop_001.png)

### 3. Configurações Iniciais

#### Teclado

1. Seleccione a disposição do teclado: **Português**
2. Teste a escrita no campo fornecido
3. Clique em **"Continuar"**

![Conectar na internet](../images/install_ubuntu_desktop_002.png)

**Atualização do instalador** 
![Atualização do Instalador](../images/install_ubuntu_desktop_003.png)
![Finalizar atuaização do Instalador](../images/install_ubuntu_desktop_004.png)
![Reiniciar instalador](../images/install_ubuntu_desktop_005.png)

![Instalação Interativativa](../images/install_ubuntu_desktop_006.png)

#### Actualizações e Software

1. Escolha entre:
   - **Instalação normal**: Navegador, utilitários, jogos, suite de escritório
   - **Instalação mínima**: Apenas navegador e utilitários básicos
2. Opções adicionais:
   - ✓ Descarregar actualizações durante a instalação
   - ✓ Instalar software de terceiros (controladores de Wi-Fi, gráficos, etc.)
3. Clique em **"Continuar"**

![Instalação normal](../images/install_ubuntu_desktop_007.png)

![Instalação third-party Software](../images/install_ubuntu_desktop_008.png)

### 4. Tipo de Instalação

#### Opção 1: Apagar disco e instalar Ubuntu (Recomendado para principiantes)

- Remove tudo do disco e instala apenas o Ubuntu
- Mais simples e directo

![Apagar disco](../images/install_ubuntu_desktop_009.png)

#### Opção 2: Dual Boot (Manter outro sistema operativo)

- Permite ter Ubuntu e Windows no mesmo computador
- O instalador redimensionará as partições automaticamente
- Seleccione quanto espaço deseja alocar para cada sistema

#### Opção 3: Particionamento Manual (Utilizadores avançados)

- Controlo total sobre partições
- Configuração típica:
  - `/boot/efi` - 512 MB (FAT32) - para sistemas UEFI
  - `/` (raiz) - 30-50 GB (ext4)
  - `swap` - Igual à RAM ou 2x RAM (para hibernação)
  - `/home` - Restante do disco (ext4)

### 5. Criação de Utilizador

1. **O seu nome**: Escreva o seu nome completo
2. **Nome do computador**: Nome que identificará o PC na rede
3. **Nome de utilizador**: Início de sessão do sistema (utilize minúsculas, sem espaços)
4. **Palavra-passe**: Crie uma palavra-passe forte
5. **Confirme a palavra-passe**: Escreva novamente
6. Escolha:
   - Início de sessão automático (menos seguro, mais conveniente)
   - Requerer palavra-passe para início de sessão (recomendado)
7. Clique em **"Continuar"**

![Criar Utilizador](../images/install_ubuntu_desktop_010.png)

### 6. Localização

1. Seleccione a sua localização no mapa ou escreva: **Lisboa** (ou a sua cidade)
2. Isto configura o fuso horário
3. Clique em **"Continuar"**

![Criar Utilizador](../images/install_ubuntu_desktop_011.png)

### 7. Instalação

1. Aguarde a instalação dos ficheiros (pode demorar 10-30 minutos)
2. Durante o processo, verá diapositivos sobre o Ubuntu
3. Não remova a pen USB até ver a mensagem final

![Detalhes da Instalação](../images/install_ubuntu_desktop_012.png)

### 8. Conclusão

1. Quando aparecer a mensagem "Instalação concluída"
2. Clique em **"Reiniciar agora"**
3. Remova a pen USB quando solicitado
4. Prima ENTER

![Conclusão](../images/install_ubuntu_desktop_013.png)

## Configurações Pós-Instalação

### 1. Primeiro Arranque

1. Inicie sessão com o seu utilizador e palavra-passe
2. Siga o assistente de configuração inicial:
   - Ligue as suas contas online (opcional)
   - Configure o Livepatch (actualizações de segurança automáticas)
   - Ajude a melhorar o Ubuntu enviando informações do sistema (opcional)

### 2. Actualizar o Sistema

```bash
# Actualize a lista de pacotes
sudo apt update

# Actualize todos os pacotes instalados
sudo apt upgrade -y

# Remova pacotes desnecessários
sudo apt autoremove -y
```

### 3. Instalar Controladores Adicionais

1. Abra **Software e Actualizações**
2. Vá para o separador **Controladores Adicionais**
3. Seleccione os controladores recomendados (NVIDIA, Wi-Fi, etc.)
4. Clique em **"Aplicar Alterações"**

### 4. Instalar Software Essencial

```bash
# Codecs multimédia
sudo apt install ubuntu-restricted-extras -y

# Ferramentas úteis
sudo apt install git curl wget vim htop -y

# Suporte a compactação
sudo apt install zip unzip rar unrar -y
```

### 5. Configurar Firewall 

```bash
# Activar a firewall
sudo ufw enable

# Verificar estado
sudo ufw status
```

## Resolução de Problemas Comuns

### Arranque não encontra o Ubuntu

- Verifique a ordem de arranque na BIOS/UEFI
- Desactive o Secure Boot se necessário
- Certifique-se de que o modo UEFI/Legacy está correcto

### Problemas com Wi-Fi

```bash
# Instale os controladores adicionais
sudo ubuntu-drivers autoinstall
```

### Ecrã preto após instalação

- Prima Ctrl+Alt+F2 para aceder ao terminal
- Instale controladores de vídeo adequados

```bash
sudo ubuntu-drivers autoinstall
sudo reboot
```

### Dual Boot não mostra Windows

```bash
# Actualize o GRUB
sudo update-grub
sudo reboot
```

## Recursos Úteis

- **Documentação Oficial**: [https://help.ubuntu.com](https://help.ubuntu.com)
- **Fórum Ubuntu Portugal**: [https://ubuntuforum-pt.org](https://ubuntuforum-pt.org)
- **Ask Ubuntu**: [https://askubuntu.com](https://askubuntu.com)
- **Ubuntu Wiki**: [https://wiki.ubuntu.com](https://wiki.ubuntu.com)
- **OMG Ubuntu**: [https://www.omgubuntu.co.uk/](https://www.omgubuntu.co.uk/)

## Comandos Úteis Pós-Instalação

Abra um terminal de comandos localmente ou conecte-se via SSH ao sistema já instalado.

```bash
# Verificar versão do Ubuntu
$ lsb_release -a
No LSB modules are available.
Distributor ID: Ubuntu
Description:    Ubuntu 24.04.4 LTS
Release:        24.04
Codename:       noble


# Informações do sistema
$ uname -a
Linux linux-lab-ubuntu 6.8.0-90-generic #91-Ubuntu SMP PREEMPT_DYNAMIC Tue Nov 18 14:14:30 UTC 2025 x86_64 x86_64 x86_64 GNU/Linux


# Utilização de disco
$ df -h
Filesystem      Size  Used Avail Use% Mounted on
tmpfs           392M  1.2M  391M   1% /run
/dev/vda1        19G  2.3G   17G  13% /
tmpfs           2.0G     0  2.0G   0% /dev/shm
tmpfs           5.0M     0  5.0M   0% /run/lock
/dev/vda16      881M  117M  703M  15% /boot
/dev/vda15      105M  6.2M   99M   6% /boot/efi
tmpfs           392M   12K  392M   1% /run/user/1000


# Utilização de memória
$ free -h
               total        used        free      shared  buff/cache   available
Mem:           3.8Gi       480Mi       2.4Gi       5.0Mi       1.2Gi       3.4Gi
Swap:             0B          0B          0B

# Processos em execução
# para sair clicar q (quit)
$ top

# Processos em execução (interface melhorada)
# para sair clicar q (quit)
$ htop

# Informações de hardware
$ sudo lshw -short
H/W path             Device      Class          Description
===========================================================
                                 system         Standard PC (Q35 + ICH9, 2009)
/0                               bus            Motherboard
/0/0                             memory         96KiB BIOS
/0/400                           processor      AMD Ryzen 7 255 w/ Radeon 780M Graphics
/0/401                           processor      AMD Ryzen 7 255 w/ Radeon 780M Graphics
/0/402                           processor      AMD Ryzen 7 255 w/ Radeon 780M Graphics
/0/403                           processor      AMD Ryzen 7 255 w/ Radeon 780M Graphics
/0/1000                          memory         4GiB System Memory
/0/1000/0                        memory         4GiB DIMM RAM
/0/100                           bridge         82G33/G31/P35/P31 Express DRAM Controller
/0/100/1             /dev/fb0    display        Virtio 1.0 GPU
/0/100/1/0                       generic        Virtual I/O device
/0/100/2                         bridge         QEMU PCIe Root port
/0/100/2/0                       network        Virtio 1.0 network device
/0/100/2/0/0         enp1s0      network        Ethernet interface
/0/100/2.1                       bridge         QEMU PCIe Root port
/0/100/2.1/0                     bus            QEMU XHCI Host Controller
/0/100/2.1/0/0       usb1        bus            xHCI Host Controller
/0/100/2.1/0/0/1     input4      input          QEMU QEMU USB Tablet
/0/100/2.1/0/1       usb2        bus            xHCI Host Controller
/0/100/2.2                       bridge         QEMU PCIe Root port
/0/100/2.2/0                     communication  Virtio 1.0 console
/0/100/2.2/0/0                   generic        Virtual I/O device
/0/100/2.3                       bridge         QEMU PCIe Root port
/0/100/2.3/0                     storage        Virtio 1.0 block device
/0/100/2.3/0/0       /dev/vda    disk           21GB Virtual I/O device
/0/100/2.3/0/0/1     /dev/vda1   volume         18GiB EXT4 volume
/0/100/2.3/0/0/e     /dev/vda14  volume         4095KiB BIOS Boot partition
/0/100/2.3/0/0/f     /dev/vda15  volume         105MiB Windows FAT volume
/0/100/2.3/0/0/10    /dev/vda16  volume         913MiB EXT4 volume
/0/100/2.4                       bridge         QEMU PCIe Root port
/0/100/2.4/0                     generic        Virtio 1.0 memory balloon
/0/100/2.4/0/0                   generic        Virtual I/O device
/0/100/2.5                       bridge         QEMU PCIe Root port
/0/100/2.5/0                     generic        Virtio 1.0 RNG
/0/100/2.5/0/0                   generic        Virtual I/O device
/0/100/2.6                       bridge         QEMU PCIe Root port
/0/100/2.7                       bridge         QEMU PCIe Root port
/0/100/3                         bridge         QEMU PCIe Root port
/0/100/3.1                       bridge         QEMU PCIe Root port
/0/100/3.2                       bridge         QEMU PCIe Root port
/0/100/3.3                       bridge         QEMU PCIe Root port
/0/100/3.4                       bridge         QEMU PCIe Root port
/0/100/3.5                       bridge         QEMU PCIe Root port
/0/100/1b                        multimedia     82801I (ICH9 Family) HD Audio Controller
/0/100/1f                        bridge         82801IB (ICH9) LPC Interface Controller
/0/100/1f/0                      communication  PnP device PNP0501
/0/100/1f/1                      input          PnP device PNP0303
/0/100/1f/2                      input          PnP device PNP0f13
/0/100/1f/3                      system         PnP device PNP0b00
/0/100/1f/4                      system         PnP device PNP0c01
/0/100/1f.2          scsi0       storage        82801IR/IO/IH (ICH9R/DO/DH) 6 port SATA Controller [AHCI mode]
/0/100/1f.2/0.0.0    /dev/cdrom  disk           QEMU DVD-ROM
/0/100/1f.2/0.0.0/0  /dev/cdrom  disk           
/0/100/1f.3                      bus            82801I (ICH9 Family) SMBus Controller
/1                   input0      input          Power Button
/2                   input1      input          AT Translated Set 2 keyboard
/3                   input3      input          ImExPS/2 Generic Explorer Mouse



# Informações da CPU
$ lscpu
Architecture:             x86_64
  CPU op-mode(s):         32-bit, 64-bit
  Address sizes:          48 bits physical, 48 bits virtual
  Byte Order:             Little Endian
CPU(s):                   4
  On-line CPU(s) list:    0-3
Vendor ID:                AuthenticAMD
  Model name:             AMD Ryzen 7 255 w/ Radeon 780M Graphics
    CPU family:           25
    Model:                117
    Thread(s) per core:   1
    Core(s) per socket:   1
    Socket(s):            4
    Stepping:             2
    BogoMIPS:             7585.75
    Flags:                fpu vme de pse tsc msr pae mce cx8 apic sep mtrr pge mca cmov pat pse36 clflush mmx fxsr sse sse2 syscall nx mmxext fxsr_opt pdpe1gb rdtscp lm rep_good nopl cpuid extd_apicid tsc_known_f
                          req pni pclmulqdq ssse3 fma cx16 sse4_1 sse4_2 x2apic movbe popcnt tsc_deadline_timer aes xsave avx f16c rdrand hypervisor lahf_lm cmp_legacy svm cr8_legacy abm sse4a misalignsse 3dnowpr
                          efetch osvw perfctr_core ssbd perfmon_v2 ibrs ibpb stibp ibrs_enhanced vmmcall fsgsbase tsc_adjust bmi1 avx2 smep bmi2 erms invpcid avx512f avx512dq rdseed adx smap avx512ifma clflushopt
                           clwb avx512cd sha_ni avx512bw avx512vl xsaveopt xsavec xgetbv1 xsaves avx512_bf16 clzero xsaveerptr wbnoinvd arat npt lbrv nrip_save tsc_scale vmcb_clean flushbyasid pausefilter pfthres
                          hold vgif vnmi avx512vbmi umip pku ospke avx512_vbmi2 gfni vaes vpclmulqdq avx512_vnni avx512_bitalg avx512_vpopcntdq rdpid overflow_recov succor fsrm flush_l1d arch_capabilities
Virtualization features:  
  Virtualization:         AMD-V
  Hypervisor vendor:      KVM
  Virtualization type:    full
Caches (sum of all):      
  L1d:                    256 KiB (4 instances)
  L1i:                    256 KiB (4 instances)
  L2:                     2 MiB (4 instances)
  L3:                     64 MiB (4 instances)
NUMA:                     
  NUMA node(s):           1
  NUMA node0 CPU(s):      0-3
Vulnerabilities:          
  Gather data sampling:   Not affected
  Itlb multihit:          Not affected
  L1tf:                   Not affected
  Mds:                    Not affected
  Meltdown:               Not affected
  Mmio stale data:        Not affected
  Reg file data sampling: Not affected
  Retbleed:               Not affected
  Spec rstack overflow:   Mitigation; Safe RET
  Spec store bypass:      Mitigation; Speculative Store Bypass disabled via prctl
  Spectre v1:             Mitigation; usercopy/swapgs barriers and __user pointer sanitization
  Spectre v2:             Mitigation; Enhanced / Automatic IBRS; IBPB conditional; STIBP disabled; RSB filling; PBRSB-eIBRS Not affected; BHI Not affected
  Srbds:                  Not affected
  Tsx async abort:        Not affected
  Vmscape:                Not affected


# Atualizar sistema
# Verificação de atualizações pendentes
$ sudo apt update
Hit:1 http://archive.ubuntu.com/ubuntu noble InRelease
Hit:2 http://security.ubuntu.com/ubuntu noble-security InRelease
Hit:3 http://archive.ubuntu.com/ubuntu noble-updates InRelease
Hit:4 http://archive.ubuntu.com/ubuntu noble-backports InRelease
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
3 packages can be upgraded. Run 'apt list --upgradable' to see them.

# Atualização de pacotes
$ sudo apt upgrade
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
Calculating upgrade... Done
The following upgrades have been deferred due to phasing:
  initramfs-tools initramfs-tools-bin initramfs-tools-core
0 upgraded, 0 newly installed, 0 to remove and 3 not upgraded.

# Limpar cache de pacotes
sudo apt clean
```

## Conclusão

Parabéns! Você instalou com sucesso o Ubuntu 24.04 Desktop. Aproveite seu novo sistema operacional Linux!

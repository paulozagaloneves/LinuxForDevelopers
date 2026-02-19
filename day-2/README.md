# Linux para Developers - Dia 2

## Índice

- [Linux para Developers - Dia 2](#linux-para-developers---dia-2)
  - [Índice](#índice)
  - [Objetivos Dia 2](#objetivos-dia-2)
  - [Exercícios Práticos](#exercícios-práticos)
    - [Preparação](#preparação)
    - [Exercícios](#exercícios)
  - [O Despertar do Terminal](#o-despertar-do-terminal)
    - [Videos](#videos)
    - [Mapa de Sobrevivência: Comandos Essenciais](#mapa-de-sobrevivência-comandos-essenciais)
    - [Raio-X do Sistema: Conhecendo a Máquina com Neofetch](#raio-x-do-sistema-conhecendo-a-máquina-com-neofetch)
    - [Poder Elevado: Usando o Sudo](#poder-elevado-usando-o-sudo)
    - [O Ecossistema de Pacotes: Atualizações e Instalações com APT](#o-ecossistema-de-pacotes-atualizações-e-instalações-com-apt)
      - [Videos](#videos-1)
    - [Localizando a Máquina na Rede: Descobrindo o IP do Servidor](#localizando-a-máquina-na-rede-descobrindo-o-ip-do-servidor)
    - [Identidade Digital: Gerenciando o Hostname da Máquina](#identidade-digital-gerenciando-o-hostname-da-máquina)
  - [Além das Fronteiras: Acesso Remoto com SSH](#além-das-fronteiras-acesso-remoto-com-ssh)
    - [Configuração de SSH](#configuração-de-ssh)
      - [Instalar servidor ssh (Openssh)](#instalar-servidor-ssh-openssh)
    - [Acesso remoto ao linux sem senha](#acesso-remoto-ao-linux-sem-senha)
      - [Videos](#videos-2)
  - [A Arquitetura do Sistema: Entendendo o FHS](#a-arquitetura-do-sistema-entendendo-o-fhs)
    - [Videos](#videos-3)
    - [Configuração do Sistema: Explorando o /etc](#configuração-do-sistema-explorando-o-etc)
    - [Telemetria do Sistema: Extraindo Dados do /proc](#telemetria-do-sistema-extraindo-dados-do-proc)
    - [Início do Sistema: Decodificando o /boot](#início-do-sistema-decodificando-o-boot)
  - [Explorando o Território: Navegação e Listagem no Sistema de Arquivos](#explorando-o-território-navegação-e-listagem-no-sistema-de-arquivos)
    - [Videos](#videos-4)
    - [Comandos de Navegação](#comandos-de-navegação)
    - [Comandos de Listagem](#comandos-de-listagem)
      - [Exemplo prático:](#exemplo-prático)
  - [Construindo e Remodelando: Manipulação de Ficheiros e Diretórios](#construindo-e-remodelando-manipulação-de-ficheiros-e-diretórios)
    - [Videos](#videos-5)
      - [Exemplo prático:](#exemplo-prático-1)
  - [Memória do Shell: Produtividade e Eficiência com History](#memória-do-shell-produtividade-e-eficiência-com-history)
    - [Videos](#videos-6)
      - [Exemplo prático:](#exemplo-prático-2)
  - [Estética e Poder: Transformando o Terminal com Oh-My-Zsh](#estética-e-poder-transformando-o-terminal-com-oh-my-zsh)
    - [Instalação do Zsh e Oh-My-Zsh (Ubuntu 24.04)](#instalação-do-zsh-e-oh-my-zsh-ubuntu-2404)
    - [Exemplo prático:](#exemplo-prático-3)
    - [Vídeos recomendados](#vídeos-recomendados)

## Objetivos Dia 2


## Exercícios Práticos



### Preparação

Para a realização dos exercicios pode usar:

1. (Preferencialmente) Linux instalado da aula 1 em computador ou VM.
2. Usar [KillerCoda - Playground Ubuntu Linux](https://killercoda.com/playgrounds/scenario/ubuntu)
3. Usar [Iximiuz Labs - Ubuntu 24.04](https://labs.iximiuz.com/playgrounds?category=linux)

### Exercícios

1. Configurar o acesso ssh para aceder de forma segura sem senha;
2. Configurar as permissões sudo do utilizador de testes para não pedir senha;
3. 


## O Despertar do Terminal

Comandos essenciais para começar a usar Linux logo após a instalação (Ubuntu/Debian).

### Videos

- [Getting Started with Linux CLI: Must-Know Commands | Linux Basics](https://www.youtube.com/watch?v=eafVBUh5-pQ)


### Mapa de Sobrevivência: Comandos Essenciais

| Comando | Descrição                                           | Exemplo                      |
| ------- | --------------------------------------------------- | ---------------------------- |
| `clear` | Limpa o ecrã do terminal                            | `clear`                      |
| `pwd`   | Mostra a diretoria atual                            | `pwd`                        |
| `ls`    | Lista ficheiros e pastas                            | `ls -la`                     |
| `cd`    | Muda de diretoria                                   | `cd /etc`                    |
| `mkdir` | Cria uma nova pasta                                 | `mkdir projetos`             |
| `rm`    | Remove ficheiros (ou pastas com `-r`)               | `rm ficheiro.txt`            |
| `rmdir` | Remove pasta vazia                                  | `rmdir pasta-vazia`          |
| `touch` | Cria ficheiro vazio ou atualiza data de modificação | `touch notas.txt`            |
| `cat`   | Mostra conteúdo de ficheiro                         | `cat notas.txt`              |
| `less`  | Visualiza ficheiro página a página (navegação)      | `less /var/log/syslog`       |
| `more`  | Visualiza ficheiro página a página (simples)        | `more notas.txt`             |
| `tail`  | Mostra linhas finais de ficheiro                    | `tail -n 20 /var/log/syslog` |
| `head`  | Mostra linhas iniciais de ficheiro                  | `head -n 20 /var/log/syslog` |
| `mv`    | Move ou renomeia ficheiros/pastas                   | `mv antigo.txt novo.txt`     |
| `cp`    | Copia ficheiros/pastas                              | `cp ficheiro.txt copia.txt`  |
| `sudo`  | Executa comando com privilégios administrativos     | `sudo apt update`            |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | -------------------- |
| `command` | Comando interno do shell para verificar como um comando será resolvido (builtin, alias, função ou executável). Muito usado com `-v` para mostrar o caminho/comando encontrado. | `command -v python3` |
| `which`   | Mostra o caminho do executável encontrado no `PATH` (normalmente para comandos externos).                                                                                      | `which python3`      |

Exemplo:

```bash
$ pwd
/home/paulo/workspace/ITSector/LinuxForDevelopers
$
$ ls -la                                                                                                                                                                                                 2 ↵
total 76
drwxrwxr-x  7 paulo paulo  4096 fev 17 18:36 .
drwxr-xr-x 21 paulo paulo  4096 fev 17 16:56 ..
drwxrwxr-x  2 paulo paulo  4096 fev 17 16:56 day-1
drwxrwxr-x  3 paulo paulo  4096 fev 17 16:56 day-2
-rw-rw-r--  1 paulo paulo   568 fev 18 17:21 Estrutura.md
drwxrwxr-x  2 paulo paulo  4096 fev 17 16:56 general
drwxrwxr-x  9 paulo paulo  4096 fev 17 19:03 .git
drwxrwxr-x  2 paulo paulo  4096 fev 17 16:56 images
-rw-rw-r--  1 paulo paulo 35149 fev 17 16:56 LICENSE
-rw-rw-r--  1 paulo paulo  7282 fev 18 17:23 README.md
$
$ head -n 10 README.md
# Linux For Developers

## Trilha de Treinamento

### 📅 [Dia 1 - Setup](day-1/README.md)

- **Objetivos Dia 1**
- Exercício Prático
- **Introdução ao Linux**
  - História e evolução do Linux 
$
$ $ tail -n 10 README.md
- Administrar utilizadores, grupos e permissões de segurança
- Utilizar redirecionamento de I/O e criar pipelines eficientes
- Desenvolver scripts shell para automatizar tarefas

## 📚 Recursos Adicionais

- Documentação oficial das distribuições
- Man pages (`man <comando>`)
- [Linux Command Line Basics](https://www.linux.org)
- Comunidades e fóruns de suporte% 
$ 
$ sudo apt update
$
$ command -v python3
/usr/bin/python3
$ which python3
/usr/bin/python3
$
```

### Raio-X do Sistema: Conhecendo a Máquina com Neofetch

Obter informações básicas do sistema

```bash
$ sudo apt install neofetch -y
$ neofetch
$ neofetch
            .-/+oossssoo+/-.               paulo@Ubuntu-Lab
        `:+ssssssssssssssssss+:`           ----------------
      -+ssssssssssssssssssyyssss+-         OS: Ubuntu 24.04.4 LTS x86_64
    .ossssssssssssssssssdMMMNysssso.       Host: VMware Virtual Platform None
   /ssssssssssshdmmNNmmyNMMMMhssssss/      Kernel: 6.17.0-14-generic
  +ssssssssshmydMMMMMMMNddddyssssssss+     Uptime: 3 hours, 34 mins
 /sssssssshNMMMyhhyyyyhmNMMMNhssssssss/    Packages: 1542 (dpkg), 10 (snap)
.ssssssssdMMMNhsssssssssshNMMMdssssssss.   Shell: bash 5.2.21
+sssshhhyNMMNyssssssssssssyNMMMysssssss+   Resolution: 3638x2000
ossyNMMMNyMMhsssssssssssssshmmmhssssssso   Terminal: /dev/pts/1
ossyNMMMNyMMhsssssssssssssshmmmhssssssso   CPU: 13th Gen Intel i7-13700H (2) @ 2.918GHz
+sssshhhyNMMNyssssssssssssyNMMMysssssss+   GPU: 00:0f.0 VMware SVGA II Adapter
.ssssssssdMMMNhsssssssssshNMMMdssssssss.   Memory: 1430MiB / 3867MiB
 /sssssssshNMMMyhhyyyyhdNMMMNhssssssss/
  +sssssssssdmydMMMMMMMMddddyssssssss+
   /ssssssssssshdmNNNNmyNMMMMhssssss/
    .ossssssssssssssssssdMMMNysssso.
      -+sssssssssssssssssyyyssss+-
        `:+ssssssssssssssssss+:`
            .-/+oossssoo+/-.

```

### Poder Elevado: Usando o Sudo

O `sudo` (superuser do) permite executar comandos com privilégios administrativos de forma temporária, sem precisar iniciar sessão como root. É usado para tarefas que exigem permissões elevadas, como instalar software ou alterar configurações do sistema.

**Exemplo:**

```bash
sudo apt install -y git
```

### O Ecossistema de Pacotes: Atualizações e Instalações com APT

O APT (Advanced Package Tool) é o gestor de pacotes e aplicações do Debian/Ubuntu, usado para atualizar, instalar, pesquisar e remover software a partir dos repositórios.
No windows temos o comando WinGet que possui uma funcionalidade similar.

#### Videos

1. [Linux Crash Course - The apt Command](https://www.youtube.com/watch?v=1kicKTbK768&list=PLT98CRl2KxKHKd_tH3ssq0HPrThx2hESW&index=82)

| Comando     | Descrição                               | Exemplo                         |
| ----------- | --------------------------------------- | ------------------------------- |
| apt update  | atualizar bd de pacotes                 | sudo apt update                 |
| apt install | instalar um pacote ou siftware          | sudo apt install openssh-server |
| apt search  | procurar um pacote ou software          | apt search openjdk              | grep 25 |
| apt remove  | remove/desinstala um pacote ou software | sudo apt remove openjdk-25-jdk  |

|

**Nota:** pode adicionar o parâmetro `-y` aos comandos para que sejam executados automaticamente, sem pedir confirmação.

```bash
$ sudo apt update
$ sudo apt upgrade -y

$ sudo apt install -y <pacote>
$ sudo apt search <termo>
$ sudo apt remove <pacote>
```

**Exemplo:**

```bash
$ sudo apt install -y curl vim git
```

### Localizando a Máquina na Rede: Descobrindo o IP do Servidor

Para descobrir o IP da máquina:

**Para mais detalhes:**

1. [How to Use the ip Command in Linux: A Beginner’s Guide](https://www.youtube.com/watch?v=wHfIFZlDxtU&list=PLT98CRl2KxKHKd_tH3ssq0HPrThx2hESW&index=12)
2. [Guia Prático do Comando ip no Linux](https://labs.iximiuz.com/playgrounds?category=linux)

```bash
$ ip address
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host noprefixroute
       valid_lft forever preferred_lft forever
2: ens33: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc fq_codel state UP group default qlen 1000
    link/ether 00:0c:29:7c:ee:d7 brd ff:ff:ff:ff:ff:ff
    altname enp2s1
    inet 192.168.231.128/24 brd 192.168.231.255 scope global dynamic noprefixroute ens33
       valid_lft 1731sec preferred_lft 1731sec
    inet6 fe80::20c:29ff:fe7c:eed7/64 scope link
       valid_lft forever preferred_lft forever
```

Neste exemplo a interface de rede é **ens33** e o IP **192.168.231.128**

Outra forma de obter o endereço IP

```bash
$ hostname -I
192.168.231.128
```


### Identidade Digital: Gerenciando o Hostname da Máquina

**Videos**

1. [Linux Crash Course - Setting the Hostname of your Linux Workstation or Server](https://www.youtube.com/watch?v=91dNq4C6260)

Os dois comandos mostram (e podem alterar) o nome da máquina, mas com objetivos diferentes:

| Comando       | Para quê                                                              | Persistência           |
| ------------- | --------------------------------------------------------------------- | ---------------------- |
| `hostname`    | Ver o hostname atual e, em alguns sistemas, alterar de forma rápida   | Normalmente temporária |
| `hostnamectl` | Ver detalhes do sistema e definir hostname de forma moderna (systemd) | Persistente            |

**Exemplos:**

```bash
# Ver hostname atual
$ hostname

# Definir hostname (pode ser temporário)
$ sudo hostname servidor-dev

# Ver informações completas (hostname, OS, kernel, etc.)
$ hostnamectl

# Definir hostname persistente
$ sudo hostnamectl set-hostname servidor-dev

# Mostrar apenas o hostname estático
$ hostnamectl --static
```

Opcionalmente, atualize o ficheiro /etc/hosts para manter consistência:

```bash
$ sudo nano /etc/hosts
```

**Para sair do editor nano use CTRL+X**



## Além das Fronteiras: Acesso Remoto com SSH

O acesso SSH (Secure Shell) é um protocolo que permite ligar-se de forma segura a um servidor remoto, normalmente via linha de comandos, para administrar o sistema, transferir ficheiros e executar comandos. A ligação é encriptada, protegendo dados e credenciais contra interceptação.

Distingue-se de outros tipos de acesso ao servidor, como:

**Telnet:** Não encripta a comunicação, tornando-a vulnerável a ataques.

**FTP:** Usado para transferência de ficheiros, mas sem encriptação (a menos que seja FTPS/SFTP).

**Acesso físico/local:** Requer estar junto ao servidor, sem ligação remota.

**RDP/VNC:** Proporciona acesso gráfico ao desktop, mas pode ser menos seguro e mais pesado.

SSH é preferido para administração remota, por ser seguro, flexível e permitir automação (via scripts e chaves).

### Configuração de SSH

#### Instalar servidor ssh (Openssh)

No servidor linux deve primeiro instalar OpenSSH e habilitar serviço ssh.

```bash 
$ sudo apt update                               # atualiza a bd de pacotes
$ sudo apt install -y openssh-server            # instalar o servidor openssh
# Em debian e ubuntu mais recenets não necessita dos comandos abaixo
$ sudo systemctl enable --now ssh               # habilita o serviço ssh. Em distribuições mais recentes o ssh já fica habilitado após instalação
$ sudo systemctl status ssh                     # verifica o estado do serviço ssh
```

Agora já consegue aceder remotamente ao linux.

- Acesso remoto ao linux com utlizador e senha

```powershell
c: > ssh utilizador@ip-do-servidor
```

**Exemplo:**

```powershell
c: > ssh ubuntu@192.168.1.101
ubuntu@192.168.1.101's password: 
Welcome to Ubuntu 24.04.4 LTS (GNU/Linux 6.8.0-90-generic x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/pro

 System information as of Mon Feb  9 18:56:55 WET 2026

  System load:             0.0
  Usage of /:              10.9% of 18.33GB
  Memory usage:            8%
  Swap usage:              0%
  Processes:               160
  Users logged in:         0
  IPv4 address for enp1s0: 192.168.1.101
  IPv6 address for enp1s0: 2a12:26c0:270a:a400:5054:ff:feac:5039


Expanded Security Maintenance for Applications is not enabled.

0 updates can be applied immediately.

Enable ESM Apps to receive additional future security updates.
See https://ubuntu.com/esm or run: sudo pro status


*** System restart required ***
Last login: Mon Feb  9 18:47:38 2026 from 192.168.1.205
ubuntu@linux-lab-ubuntu:~$ 
```

### Acesso remoto ao linux sem senha

Para se poder aceder remotamente ao linux sem senha é necessário criar um par de chaves publica/privada e configurar o linux com a chave pública.

#### Videos

1. [Linux Crash Course - Public Key Authentication](https://www.youtube.com/watch?v=bfwfRCCFTVI&list=PLT98CRl2KxKHKd_tH3ssq0HPrThx2hESW&index=67)
2. [Domine o OpenSSH: Acesso Remoto Seguro para Servidores Linux.](https://www.youtube.com/watch?v=rxJaC59d9sc)

**Configurar acesso SSH por chave**

Configurar o acesso SSH por chave no Linux é um processo direto que aumenta drasticamente a segurança do teu servidor. 
Passo a passo: 

1. Gerar o par de chaves (na tua máquina local)

No teu computador (Linux, macOS ou Windows com PowerShell), executa o comando para criar as chaves: 

```powershell
C:> ssh-keygen -t ed25519
```

**Dica:** O algoritmo ed25519 é atualmente o mais recomendado por ser mais seguro e rápido que o RSA tradicional.

2. Copiar a chave pública para o servidor

Usa o utilitário ssh-copy-id para automatizar a transferência: 

```powershell
C:> ssh-copy-id utilizador@ip-do-servidor
```

Este comando pede a tua senha atual uma última vez e adiciona a tua chave pública ao ficheiro ~/.ssh/authorized_keys no servidor.

3. Abre outra janela do powershell e testa o acesso ssh agora

```powershell
C:> ssh utilizador@ip-do-servidor
```

## A Arquitetura do Sistema: Entendendo o FHS

### Videos

- [Linux Directories Explained in 100 Seconds](https://youtu.be/42iQKuQodW4?si=3hrV5VA4AlbJCpCt)
- [Linux File System Structure Explained: From / to /usr | Linux Basics](https://www.youtube.com/watch?v=ISJ44S5sZu8)
- [Como Dominar o Terminal e Aprender Linux de Verdade em 2026.](https://www.youtube.com/watch?v=9XZUSXidaFY)
- [Aula 2 – Shell e diretórios Linux | Curso Linux para Computação Científica](https://www.youtube.com/watch?v=heWlrsf6BIw)

O FHS (Filesystem Hierarchy Standard) é um padrão que define a estrutura e a organização dos diretórios principais em sistemas Linux e Unix-like. Este especifica onde devem estar localizados os ficheiros e diretórios importantes, facilitando a padronização, manutenção e portabilidade de aplicações entre diferentes distribuições.

Principais diretórios definidos pelo FHS:

  - `/` - Diretório raiz: ponto de partida de toda a hierarquia.
  - `/bin` - Binários essenciais do sistema, comandos básicos disponíveis para todos os utilizadores.
  - `/boot` - Ficheiros necessários para a inicialização do sistema, como o kernel e o GRUB.
  - `/dev` - Ficheiros de dispositivos (devices), representando hardware e periféricos.
  - `/etc` - Ficheiros de configuração do sistema.
  - `/home` - Diretórios pessoais dos utilizadores.
  - `/lib` - Bibliotecas partilhadas essenciais para os programas em /bin e /sbin.
  - `/mnt` - Pontos de montagem temporários para sistemas de ficheiros.
  - `/opt` - Pacotes de software opcionais.
  - `/proc` - Sistema de ficheiros virtual com informações sobre processos e kernel.
  - `/root` - Diretório pessoal do superutilizador (root).
  - `/sbin` - Binários do sistema, geralmente para administração e uso do root.
  - `/srv` - Dados de serviços fornecidos pelo sistema.
  - `/tmp` - Ficheiros temporários, apagados periodicamente.
  - `/usr` - Hierarquia secundária para programas, bibliotecas e documentação de utilizadores.
  - `/var` - Dados variáveis, como logs, cache e filas de impressão.
  

O FHS garante que utilizadores e administradores encontrem ficheiros e programas em locais previsíveis, tornando a gestão do sistema mais eficiente.


### Configuração do Sistema: Explorando o /etc

O diretório /etc contém ficheiros de configuração essenciais do sistema. Eis alguns exemplos úteis:

- /etc/passwd — Contém informações sobre as contas de utilizador do sistema.
- /etc/group — Define os grupos de utilizadores.
- /etc/hostname — Define o nome da máquina.
- /etc/hosts — Mapeia nomes de hosts para endereços IP.
- resolv.conf — Configura os servidores DNS.
- /etc/fstab — Define os sistemas de ficheiros a montar automaticamente no arranque.
- /etc/ssh/sshd_config — Configuração do servidor SSH.
- /etc/network/interfaces ou /etc/netplan/ — Configuração de interfaces de rede (dependendo da distribuição).
- /etc/apt - Diretório onde se encontram as configurações e listas de repositórios do gestor de pacotes APT (Debian/Ubuntu), como o ficheiro sources.list e as definições de repositórios adicionais.


Exemplo prático: adicionar um mapeamento ao /etc/hosts

```bash
$ echo "192.168.1.100 servidor-local" | sudo tee -a /etc/hosts
```


### Telemetria do Sistema: Extraindo Dados do /proc

- Ver informações sobre a CPU:
  
```bash
$ cat /proc/cpuinfo                         
processor       : 0
vendor_id       : AuthenticAMD
cpu family      : 25
model           : 117
model name      : AMD Ryzen 7 255 w/ Radeon 780M Graphics
stepping        : 2
microcode       : 0xa70520a
cpu MHz         : 1395.800
cache size      : 1024 KB
physical id     : 0
siblings        : 16
core id         : 0
cpu cores       : 8
apicid          : 0
initial apicid  : 0
fpu             : yes
fpu_exception   : yes
cpuid level     : 16
wp              : yes
flags           : fpu vme de pse tsc msr pae mce cx8 apic sep mtrr pge mca cmov pat pse36 clflush mmx fxsr sse sse2 ht syscall nx mmxext fxsr_opt pdpe1gb rdtscp lm constant_tsc rep_good amd_lbr_v2 nopl xtopology nonstop_tsc cpuid extd_apicid aperfmperf rapl pni pclmulqdq monitor ssse3 fma cx16 sse4_1 sse4_2 x2apic movbe popcnt aes xsave avx f16c rdrand lahf_lm cmp_legacy svm extapic cr8_legacy abm sse4a misalignsse 3dnowprefetch osvw ibs skinit wdt tce topoext perfctr_core perfctr_nb bpext perfctr_llc mwaitx cpb cat_l3 cdp_l3 hw_pstate ssbd mba perfmon_v2 ibrs ibpb stibp ibrs_enhanced vmmcall fsgsbase bmi1 avx2 smep bmi2 erms invpcid cqm rdt_a avx512f avx512dq rdseed adx smap avx512ifma clflushopt clwb avx512cd sha_ni avx512bw avx512vl xsaveopt xsavec xgetbv1 xsaves cqm_llc cqm_occup_llc cqm_mbm_total cqm_mbm_local user_shstk avx512_bf16 clzero irperf xsaveerptr rdpru wbnoinvd cppc arat npt lbrv svm_lock nrip_save tsc_scale vmcb_clean flushbyasid decodeassists pausefilter pfthreshold vgif x2avic v_spec_ctrl vnmi avx512vbmi umip pku ospke avx512_vbmi2 gfni vaes vpclmulqdq avx512_vnni avx512_bitalg avx512_vpopcntdq rdpid overflow_recov succor smca fsrm flush_l1d amd_lbr_pmc_freeze
bugs            : sysret_ss_attrs spectre_v1 spectre_v2 spec_store_bypass srso tsa vmscape
bogomips        : 7585.45
TLB size        : 3584 4K pages
clflush size    : 64
cache_alignment : 64
address sizes   : 48 bits physical, 48 bits virtual
power management: ts ttp tm hwpstate cpb eff_freq_ro [13] [14] [15]
```

- Verificar a versão do kernel:
  
```bash
$ cat /proc/version
Linux version 6.12.69+deb13-amd64 (debian-kernel@lists.debian.org) (x86_64-linux-gnu-gcc-14 (Debian 14.2.0-19) 14.2.0, GNU ld (GNU Binutils for Debian) 2.44) #1 SMP PREEMPT_DYNAMIC Debian 6.12.69-1 (2026-02-08)
```

- Verificar a quantidade de memória RAM disponível e usada:

```bash
$ cat /proc/meminfo
MemTotal:       28483520 kB
MemFree:        13438688 kB
MemAvailable:   19976488 kB
Buffers:          209028 kB
Cached:          6691904 kB
SwapCached:            0 kB
Active:         10407460 kB
Inactive:        3295836 kB
Active(anon):    7003992 kB
Inactive(anon):        0 kB
Active(file):    3403468 kB
Inactive(file):  3295836 kB
Unevictable:          48 kB
Mlocked:              48 kB
SwapTotal:      32768308 kB
SwapFree:       32768308 kB
Zswap:                 0 kB
Zswapped:              0 kB
Dirty:               248 kB
Writeback:             0 kB
AnonPages:       6572408 kB
Mapped:          2116132 kB
Shmem:            214232 kB
KReclaimable:     272240 kB
Slab:             515072 kB
SReclaimable:     272240 kB
SUnreclaim:       242832 kB
KernelStack:       36768 kB
PageTables:        81536 kB
SecPageTables:      4960 kB
NFS_Unstable:          0 kB
Bounce:                0 kB
WritebackTmp:          0 kB
CommitLimit:    47010068 kB
Committed_AS:   32973812 kB
VmallocTotal:   34359738367 kB
VmallocUsed:      138140 kB
VmallocChunk:          0 kB
Percpu:            20672 kB
HardwareCorrupted:     0 kB
AnonHugePages:   2906112 kB
ShmemHugePages:        0 kB
ShmemPmdMapped:        0 kB
FileHugePages:         0 kB
FilePmdMapped:         0 kB
Unaccepted:            0 kB
HugePages_Total:       0
HugePages_Free:        0
HugePages_Rsvd:        0
HugePages_Surp:        0
Hugepagesize:       2048 kB
Hugetlb:               0 kB
DirectMap4k:      845540 kB
DirectMap2M:    17776640 kB
DirectMap1G:    11534336 kB
```


- Consultar o tempo de atividade do sistema:

```bash
$ cat /proc/uptime
4987.85 77056.54
# O primeiro valor (4987.85) indica o tempo, em segundos, desde que o sistema foi iniciado (uptime).
# O segundo valor (77056.54) mostra o tempo total, em segundos, em que todos os processadores estiveram inactivos (idle) desde o arranque.

# Converter o tempo de uptime em horas minuts segundos
$ awk '{print int($1/3600)"h "int(($1%3600)/60)"m "int($1%60)"s"}' /proc/uptime
1h 24m 8s
# Converter o tempo de inatividade de todos os processadores em horas minuts segundos
$ awk '{print int($2/3600)"h "int(($2%3600)/60)"m "int($2%60)"s"}' /proc/uptime
22h 10m 29s
```

- Obter informações sobre dispositivos de bloco:

```bash
$ cat /proc/partitions
major minor  #blocks  name

 259        0  976762584 nvme0n1
 259        1     102400 nvme0n1p1
 259        2      16384 nvme0n1p2
 259        3    1024000 nvme0n1p3
 259        4  310018759 nvme0n1p4
 259        5  204800000 nvme0n1p5
 259        6    2097152 nvme0n1p6
 259        7   32768312 nvme0n1p7
 259        8  204800000 nvme0n1p8
```

- Ver o estado da rede:

```bash
$ cat /proc/net/dev | column -t
Inter-|           Receive    |        Transmit                                                                                                            
face              |bytes     packets  errs      drop   fifo  frame  compressed  multicast|bytes  packets   errs   drop  fifo  colls  carrier  compressed  
lo:               53998      479      0         0      0     0      0           0                53998     479    0     0     0      0        0           0
eno1:             438441225  365369   0         4      0     0      0           32708            20707254  55736  0     2     0      0        0           0
wlp2s0:           0          0        0         0      0     0      0           0                0         0      0     2     0      0        0           0
br0:              420361135  115723   0         29680  0     0      0           32707            20375750  50696  0     18    0      0        0           0
virbr0:           0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-322468ea0106:  0          0        0         0      0     0      0           0                0         0      0     27    0      0        0           0
br-461bf010e726:  0          0        0         0      0     0      0           0                0         0      0     27    0      0        0           0
br-4910c0cdee5d:  0          0        0         0      0     0      0           0                0         0      0     27    0      0        0           0
br-4c7342555ce8:  4268       69       0         0      0     0      0           19               7026      45     0     7     0      0        0           0
br-88094d7468ee:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-befb430168c3:  84         3        0         0      0     0      0           0                7848      55     0     6     0      0        0           0
br-ca477001efb8:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-010e8c61f7d0:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-433e00e6b8c2:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-866d69256e97:  252        9        0         0      0     0      0           0                7854      55     0     6     0      0        0           0
br-bccde02cd069:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-e51c722cc9df:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-2c1064bdfb30:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-477ee3a421d7:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-5b5bfc5c604f:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
br-83efec861006:  0          0        0         0      0     0      0           0                0         0      0     25    0      0        0           0
docker0:          2744       98       0         0      0     0      0           0                20934     126    0     139   0      0        0           0
br-8a217d0ccf9d:  0          0        0         0      0     0      0           0                0         0      0     8     0      0        0           0
br-902e39ce27c3:  84         3        0         0      0     0      0           0                5219      33     0     2     0      0        0           0
br-1213e605a4dc:  0          0        0         0      0     0      0           0                0         0      0     6     0      0        0           0
veth90adde7:      126        3        0         0      0     0      0           0                12148     84     0     0     0      0        0           0
veth56b0500:      126        3        0         0      0     0      0           0                12406     90     0     0     0      0        0           0
veth44405bb:      5234       69       0         0      0     0      0           0                11326     74     0     0     0      0        0           0
vethc9aabdd:      126        3        0         0      0     0      0           0                9519      62     0     0     0      0        0           0
veth18eb8bf:      126        3        0         0      0     0      0           0                12364     89     0     0     0      0        0           0
veth91a9723:      126        3        0         0      0     0      0           0                12322     88     0     0     0      0        0           0
```



### Início do Sistema: Decodificando o /boot

O diretório `/boot` contém todos os ficheiros essenciais para o arranque do sistema operativo. Qualquer alteração ou eliminação indevida de ficheiros neste diretório pode impedir o sistema de arrancar corretamente.

Principais ficheiros e diretórios encontrados em `/boot`:

- **vmlinuz-*** — Imagem comprimida do kernel Linux. Exemplo: `vmlinuz-6.1.0-18-amd64`
- **initrd.img-*** ou **initramfs-*** — Imagem de disco temporária carregada na memória durante o arranque, usada para preparar o ambiente antes de montar o sistema de ficheiros principal. Exemplo: `initrd.img-6.1.0-18-amd64`
- **grub/** — Diretório com os ficheiros de configuração e módulos do gestor de arranque GRUB (Grand Unified Bootloader), como `grub.cfg`.
- **config-*** — Ficheiro de configuração do kernel compilado. Exemplo: `config-6.1.0-18-amd64`
- **System.map-*** — Mapa de símbolos do kernel, útil para depuração. Exemplo: `System.map-6.1.0-18-amd64`
- **efi/** — Diretório presente em sistemas com UEFI, contendo ficheiros de arranque EFI.

Exemplo de listagem de `/boot` num sistema típico:

```bash
$ ls /boot
config-6.1.0-18-amd64     initrd.img-6.1.0-18-amd64  vmlinuz-6.1.0-18-amd64
grub/                     System.map-6.1.0-18-amd64   efi/
```

Resumo dos principais elementos:
- **vmlinuz**: o kernel propriamente dito.
- **initrd/initramfs**: sistema de ficheiros temporário para o arranque.
- **grub/**: gestor de arranque e respetiva configuração.
- **config** e **System.map**: ficheiros auxiliares para depuração e configuração.

Alterações neste diretório devem ser feitas com extremo cuidado, normalmente apenas por processos de atualização do kernel ou do gestor de arranque.



## Explorando o Território: Navegação e Listagem no Sistema de Arquivos

### Videos

- [Linux Crash Course: Navigating the Linux Filesystem](https://youtu.be/BNL3qBN9pP0?si=MRQ2kQ31DMF_pyhp)
- [Aula 3 – Primeiros comandos: man, cd, ls e pwd | Curso Linux para Computação Científica](https://youtu.be/FgfwdUl3i-s?si=UdW-q95xLoYpkH1K)

Navegar e listar ficheiros e diretórios é fundamental para trabalhar eficientemente no Linux. Abaixo estão comandos essenciais e exemplos práticos num sistema Ubuntu 24.04.

### Comandos de Navegação

| Comando         | Descrição                                 | Exemplo                  |
|-----------------|-------------------------------------------|--------------------------|
| `pwd`           | Mostra a diretoria atual                  | `pwd`                    |
| `cd`            | Muda de diretoria                         | `cd /etc`                |
| `cd ~`          | Vai para a home do utilizador             | `cd ~`                   |
| `cd ..`         | Sobe um nível na hierarquia               | `cd ..`                  |
| `cd -`          | Volta à diretoria anterior                | `cd -`                   |

### Comandos de Listagem

| Comando         | Descrição                                 | Exemplo                  |
|-----------------|-------------------------------------------|--------------------------|
| `ls`            | Lista ficheiros e pastas                  | `ls`                     |
| `ls -l`         | Lista detalhada (permissões, datas, etc.) | `ls -l /etc`             |
| `ls -a`         | Mostra ficheiros ocultos                  | `ls -a`                  |
| `ls -lh`        | Lista detalhada com tamanhos legíveis      | `ls -lh /var/log`        |
| `tree`          | Mostra a estrutura em árvore (requer instalação) | `tree /etc`         |

#### Exemplo prático:

```bash
$ pwd
/home/paulo

$ cd /etc
$ ls -lh
-rw-r--r-- 1 root root  296 fev 18 10:12 adduser.conf
-rw-r--r-- 1 root root 1,1K fev 18 10:12 aliases
...
$ cd ~
$ ls -a
.  ..  .bashrc  .profile  Documentos  Imagens
```

Para instalar o comando `tree`:
```bash
$ sudo apt update && sudo apt install tree -y
```


## Construindo e Remodelando: Manipulação de Ficheiros e Diretórios

### Videos

- [Aula 4 – Primeiros comandos: mkdir, rmdir, touch, rm e cp | Curso Linux para Computação Científica](https://www.youtube.com/watch?v=7Zl1yXe-MB8)

Manipular ficheiros e diretórios é uma tarefa diária no Linux. Veja os comandos mais usados e exemplos práticos:

| Comando                  | Descrição                                         | Exemplo                                 |
|--------------------------|---------------------------------------------------|-----------------------------------------|
| `touch`                  | Cria ficheiro vazio                               | `touch notas.txt`                       |
| `mkdir`                  | Cria diretoria                                    | `mkdir projetos`                        |
| `cp`                     | Copia ficheiro                                    | `cp notas.txt copia.txt`                |
| `cp -r`                  | Copia diretoria recursivamente                    | `cp -r projetos projetos_backup`        |
| `mv`                     | Move ou renomeia ficheiro/diretoria               | `mv notas.txt notas_antigas.txt`        |
| `rm`                     | Remove ficheiro                                   | `rm copia.txt`                          |
| `rm -r`                  | Remove diretoria e conteúdo                       | `rm -r projetos_backup`                 |
| `rmdir`                  | Remove diretoria vazia                            | `rmdir pasta_vazia`                     |

#### Exemplo prático:

```bash
$ mkdir exemplo
$ cd exemplo
$ touch ficheiro1.txt
$ echo "Conteúdo de teste" > ficheiro1.txt
$ cp ficheiro1.txt copia.txt
$ mv copia.txt ficheiro2.txt
$ ls
ficheiro1.txt  ficheiro2.txt
$ rm ficheiro2.txt
$ cd ..
$ rm -r exemplo
```


## Memória do Shell: Produtividade e Eficiência com History

### Videos

- [Linux Crash Course - Bash History](https://www.youtube.com/watch?v=Odo6leOY5Fw)
- [Como aumentar a sua performance no Linux? Hacks que irão te ajudar!](https://youtu.be/X0fRA_MSkx4?si=meN7XN-Z320X8u46)

O shell guarda um histórico dos comandos executados, permitindo repetir ou pesquisar comandos anteriores facilmente.

| Comando            | Descrição                                         | Exemplo                  |
|--------------------|---------------------------------------------------|--------------------------|
| `history`          | Mostra o histórico de comandos                    | `history`                |
| `!n`               | Executa o comando número n do histórico           | `!42`                    |
| `!!`               | Repete o último comando                           | `!!`                     |
| `!palavra`         | Executa o último comando que começa por 'palavra' | `!sudo`                  |
| `Ctrl+R`           | Pesquisa interativa no histórico                  | (pressione Ctrl+R e digite parte do comando) |

#### Exemplo prático:

```bash
$ history
  1  pwd
  2  cd /etc
  3  ls -lh
  4  cd ~
  5  ls -a
  6  sudo apt update
  7  sudo apt install tree -y
  8  tree /etc

$ !6
sudo apt update

$ !!
sudo apt update

# Pesquisa rápida no histórico
# (pressione Ctrl+R e digite 'tree' para encontrar o comando relacionado)
```

Estes comandos aumentam a produtividade e facilitam a repetição de tarefas no terminal.


## Estética e Poder: Transformando o Terminal com Oh-My-Zsh

O Oh-My-Zsh é uma framework open source para gerir configurações do Zsh, tornando o terminal mais bonito, funcional e produtivo. Permite personalizar o prompt, adicionar plugins e temas facilmente.

### Instalação do Zsh e Oh-My-Zsh (Ubuntu 24.04)

1. **Instalar o Zsh:**
  ```bash
  $ sudo apt update
  $ sudo apt install zsh -y
  ```

2. **Definir o Zsh como shell padrão:**
  ```bash
  $ chsh -s $(which zsh)
  # Terá de terminar sessão e voltar a entrar para ativar.
  ```

3. **Instalar o Oh-My-Zsh:**
  ```bash
  $ sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
  # Ou, se preferir usar wget:
  $ sh -c "$(wget https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh -O -)"
  ```

4. **Mudar de tema (opcional):**
  - Edite o ficheiro `~/.zshrc` e altere a linha `ZSH_THEME="robbyrussell"` para outro tema, por exemplo:
    ```bash
    ZSH_THEME="agnoster"
    ```
  - Para aplicar as alterações:
    ```bash
    $ source ~/.zshrc
    ```

5. **Adicionar plugins úteis (opcional):**
  - No ficheiro `~/.zshrc`, adicione plugins à linha `plugins=(git)` (exemplo: `plugins=(git sudo history)`)
  - Recarregue as configurações:
    ```bash
    $ source ~/.zshrc
    ```

### Exemplo prático:

```bash
$ sudo apt update
$ sudo apt install zsh -y
$ chsh -s $(which zsh)
# Termine sessão e volte a entrar
$ sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
# Edite ~/.zshrc para mudar o tema ou adicionar plugins
$ source ~/.zshrc
```

### Vídeos recomendados

- [APRENDA COMO INSTALAR E CONFIGURAR O OH MY ZSH E TENHA SUPER PODERES](https://www.youtube.com/watch?v=1-Lm4znOtaQ)





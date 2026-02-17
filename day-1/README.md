# Linux For Developers

## Índice

- [Objetivos Dia 1](#objetivos-dia-1)
- [Exercício Prático](#exercício-prático)
- [Introdução ao Linux](#introdução-ao-linux)
  - [História e evolução do Linux](#história-e-evolução-do-linux)
  - [Distribuições Populares (Ubuntu, Fedora, Debian, Redhat, Arch)](#distribuições-populares-ubuntu-fedora-debian-redhat-arch)
  - [Filosofia Open Source](#filosofia-open-source)
- [Virtualização do Linux](#virtualização-do-linux)
  - [Tipos de Virtualização no Windows](#tipos-de-virtualização-no-windows)
  - [Hyper-V](#hyper-v)
    - [Como habilitar o Hyper-V no Windows](#como-habilitar-o-hyper-v-no-windows)
    - [Criar uma nova VM no Hyper-V](#criar-uma-nova-vm-no-hyper-v)
- [Instalação](#instalação)
- [Comandos Básicos](#comandos-básicos)
  - [Tabela rápida de comandos](#tabela-rápida-de-comandos)
  - [1) Neofetch](#1-neofetch)
  - [2) Comando SUDO](#2-comando-sudo)
  - [3) Atualizar e instalar pacotes com APT](#3-atualizar-e-instalar-pacotes-com-apt)
  - [4) Acesso remoto com SSH](#4-acesso-remoto-com-ssh)
  - [5) Nome da máquina: hostname e hostnamectl](#5-nome-da-máquina-hostname-e-hostnamectl)
  - [6) Navegação no sistema](#6-navegação-no-sistema)

## **Objetivos Dia 1**

  - Apresentar a história e evolução do Linux, destacando o seu desenvolvimento, licenciamento e impacto global.
  - Explicar as principais distribuições Linux, suas características, público-alvo e diferenças.
  - Introduzir a filosofia Open Source, seus princípios, benefícios e tipos de licenças.
  - Demonstrar as opções de virtualização no Windows, incluindo Hyper-V, VirtualBox, VMware, QEMU, WSL 2 e KVM no WSL 2.
  - Instalar uma distribuição Linux (Ubuntu ou debian) num computador ou Máquina Virtual.

## Exercício Prático

1. Instalar uma das distribuições abaixo num computador ou máquina virtual.

- Zorin OS 18
- Ubuntu Desktop 24.04
- Ubuntu Server 24.04
- Debian 13

2. Obter o IP da interface de rede principal.
3. Aceder remotamente
4. **Opcionalmente:** Instalar Fedora 43 ou Almalinux 10 noutra máquina virtual.

## **Introdução ao Linux**

### História e evolução do Linux

O Linux nasceu em 1991 quando Linus Torvalds, então estudante de ciência da computação na Universidade de Helsínquia, Finlândia, começou a desenvolver um kernel de sistema operativo como hobby. Inspirado no MINIX (um sistema Unix-like educacional), Linus queria criar um sistema operativo livre e aberto que pudesse executar em computadores pessoais com processadores Intel 386.

A primeira versão (0.01) foi lançada em Setembro de 1991, contendo apenas cerca de 10.000 linhas de código. O que começou como um projecto pessoal rapidamente ganhou colaboradores em todo o mundo através da Internet. Em 1992, Linus decidiu licenciar o Linux sob a GPL (General Public License), tornando-o verdadeiramente livre e open source.

Ao longo das décadas, o Linux evoluiu de um kernel experimental para a fundação de milhares de milhões de dispositivos. Nos anos 90, surgiram as primeiras distribuições como Slackware, Debian e Red Hat, tornando o Linux mais acessível. Os anos 2000 viram a explosão do Linux em servidores web e a criação do Android, que leva o kernel Linux para smartphones. Hoje, o Linux domina servidores (mais de 90% do top 1 milhão de sítios), supercomputadores (100% do Top500), dispositivos embarcados, e é fundamental para cloud computing e contentores.

O kernel Linux actual possui mais de 30 milhões de linhas de código e conta com milhares de programadores a contribuir de empresas como Google, Intel, Red Hat, Samsung e muitas outras. É um dos maiores e mais bem-sucedidos projectos de código aberto da história.

### Distribuições Populares (Ubuntu, Fedora, Debian, Redhat, Arch)

#### Videos

1. [Linux Crash Course - What is a "Distribution" of Linux?](https://www.youtube.com/watch?v=6EKzuBAEbOA&list=PLT98CRl2KxKHKd_tH3ssq0HPrThx2hESW&index=39)
2. [Teste distros Linux online!](https://distrosea.com/pt/)

Uma **distribuição Linux** (ou "distro") é um sistema operativo completo construído sobre o kernel Linux. Enquanto o kernel é apenas o núcleo do sistema, uma distribuição empacota o kernel juntamente com ferramentas do sistema, gestores de pacotes, ambientes gráficos, aplicações e configurações pré-definidas, formando um sistema operativo utilizável.

Cada distribuição tem a sua própria filosofia, público-alvo e método de gestão. As principais diferenças estão no sistema de pacotes, frequência de actualizações, estabilidade vs. software mais recente, e facilidade de uso.

**Principais distribuições:**

- **[Ubuntu](https://ubuntu.com/)**: Baseada no Debian, é a distribuição mais popular para desktops e iniciantes. Focada em facilidade de uso, possui ciclos de lançamento regulares a cada 6 meses e versões LTS (Long Term Support) com 5 anos de suporte. Ideal para programadores e uso geral. Usa gestor de pacotes APT (.deb).

  **Distribuições derivadas do Ubuntu:**

  - **[Zorin OS](https://zorin.com/)**: Distribuição desenhada especificamente para utilizadores que migram do Windows. Apresenta um ambiente de trabalho visualmente semelhante ao Windows, facilitando a transição. Inclui várias disposições de desktop (Layouts) que imitam Windows, macOS e até ChromeOS. Vem com Wine pré-instalado para executar algumas aplicações Windows. Existe em versões Core (gratuita), Lite (para hardware mais antigo) e Pro (paga, com software adicional e layouts premium). Ideal para iniciantes e para ambientes empresariais que procuram substituir o Windows.
  - **[Pop!_OS](https://pop.system76.com/)**: Desenvolvida pela System76 (fabricante de computadores Linux), é optimizada para programadores, criadores de conteúdo e utilizadores de ciência de dados. Destaca-se pelo excelente suporte para placas gráficas NVIDIA (drivers incluídos por defeito) e pela funcionalidade de organização automática de janelas (Auto-tiling). Inclui ferramentas de recuperação integradas e um instalador que facilita a encriptação completa do disco. Popular entre gamers e utilizadores que trabalham com machine learning, edição de vídeo e desenvolvimento de software.
- **[Debian](https://www.debian.org/)**: Uma das distribuições mais antigas e respeitadas, conhecida pela sua estabilidade e compromisso com software livre. É a base para muitas outras distros, incluindo Ubuntu. Possui três ramos: Stable (muito estável), Testing e Unstable. Preferida para servidores e utilizadores que valorizam estabilidade. Usa APT (.deb).
- **[Fedora](https://fedoraproject.org/)**: Patrocinada pela Red Hat, é uma distribuição com atualizações frequentes que serve como campo de testes para tecnologias que eventualmente chegam ao Red Hat Enterprise Linux (RHEL). Sempre com software actualizado e inovador. Popular entre programadores e entusiastas. Usa gestor DNF (.rpm).
- **[Red Hat (RHEL)](https://www.redhat.com/en/technologies/linux-platforms/enterprise-linux)**: Red Hat Enterprise Linux é uma distribuição comercial focada em ambientes corporativos e servidores empresariais. Oferece suporte pago, certificações e grande estabilidade. É a base para CentOS (descontinuado) e Rocky Linux/AlmaLinux. Usa DNF (.rpm).
- **[Arch Linux](https://archlinux.org/)**: Distribuição rolling release (actualização contínua) minimalista e altamente personalizável. Segue a filosofia KISS (Keep It Simple, Stupid) e é voltada para utilizadores avançados que querem controlo total sobre o seu sistema. Conhecida pela sua documentação excelente (Arch Wiki) e gestor de pacotes Pacman. Requer instalação manual e configuração detalhada.

### Filosofia Open Source

A **filosofia Open Source** (código aberto) é o fundamento sobre o qual o Linux e milhares de projectos de software são construídos. Esta filosofia defende que o código-fonte do software deve estar disponível publicamente para qualquer pessoa visualizar, modificar e distribuir. Mais do que apenas uma metodologia de desenvolvimento, representa um movimento cultural e ético que promove a colaboração, transparência e liberdade tecnológica.

**Princípios fundamentais:**

1. **Liberdade de utilização**: Qualquer pessoa pode executar o software para qualquer propósito, sem restrições.
2. **Acesso ao código-fonte**: O código está disponível para leitura e estudo, permitindo compreender como o software funciona internamente.
3. **Liberdade de modificação**: Utilizadores podem adaptar o software às suas necessidades específicas, corrigir falhas ou adicionar funcionalidades.
4. **Liberdade de redistribuição**: As melhorias podem ser partilhadas com a comunidade, beneficiando todos os utilizadores.

**Benefícios do Open Source:**

- **Segurança e transparência**: Com milhares de olhos a rever o código, vulnerabilidades são identificadas e corrigidas rapidamente. Não há "portas traseiras" ocultas.
- **Inovação colaborativa**: Programadores de todo o mundo contribuem, acelerando o desenvolvimento e a inovação. Projectos como o kernel Linux recebem contribuições de milhares de programadores.
- **Independência tecnológica**: Organizações não ficam dependentes de fornecedores específicos (vendor lock-in) e podem adaptar o software às suas necessidades.
- **Redução de custos**: Elimina licenças caras e permite reutilização de código entre projectos.
- **Qualidade superior**: A revisão colaborativa constante tende a produzir software mais robusto e bem testado.
- **Educação e aprendizagem**: Estudantes e programadores podem aprender com código real de projectos de qualidade mundial.
- **GPL (General Public License)**: Utilizada pelo kernel Linux. Garante que derivados também sejam open source (copyleft).
- **MIT/BSD**: Licenças permissivas que permitem uso em software proprietário.
- **Apache 2.0**: Popular em projectos empresariais, oferece protecção de patentes.

O Linux é o exemplo máximo do sucesso do Open Source: começou como projecto de um estudante e tornou-se a base da infraestrutura tecnológica mundial, demonstrando que a colaboração aberta pode superar modelos proprietários tradicionais.

## **Virtualização do Linux**

### Tipos de Virtualização no Windows

No Windows, existem várias soluções de virtualização, cada uma com características, requisitos e casos de utilização específicos:

- **Hyper-V**: Solução de virtualização nativa da Microsoft disponível nas edições Pro, Enterprise e Education do Windows. Permite criar e gerir máquinas virtuais com bom desempenho e integração no sistema. Requer suporte à virtualização no hardware (Intel VT-x/AMD-V) e pode entrar em conflito com outros softwares de virtualização.
- **VirtualBox**: Plataforma de virtualização gratuita e open source mantida pela Oracle. Suporta múltiplos sistemas operativos convidados (Linux, Windows, BSD, etc.) e é fácil de utilizar. Funciona em várias versões do Windows, mas pode ter desempenho inferior ao Hyper-V e limitações de integração.
- **VMware Workstation Player/Pro**: Solução comercial (com versão gratuita para uso pessoal) da VMware. Oferece desempenho robusto, funcionalidades avançadas e excelente compatibilidade com diferentes sistemas operativos convidados. Bastante utilizada em ambientes empresariais e por profissionais de TI.
- **QEMU**: Emulador e virtualizador open source poderoso, mais comum em ambientes Linux, mas disponível para Windows. Permite emulação completa de hardware e virtualização acelerada (quando combinado com KVM). No Windows, é mais utilizado por utilizadores avançados.
- **WSL 2 (Windows Subsystem for Linux 2)**: Permite executar distribuições Linux diretamente no Windows, com kernel Linux real a correr numa máquina virtual leve gerida pelo próprio Windows. Ideal para programadores que necessitam de um ambiente Linux sem sair do Windows. Suporta integração de ficheiros, rede e execução de aplicações gráficas (WSLg).
- **KVM no WSL 2**: Com o WSL 2, é possível correr o KVM (Kernel-based Virtual Machine) dentro do ambiente Linux, permitindo criar e gerir VMs Linux diretamente no WSL. Esta abordagem é experimental e dirigida a utilizadores avançados que pretendem explorar virtualização aninhada (nested virtualization) no Windows.

Cada solução tem vantagens e limitações. A escolha depende do objetivo (desenvolvimento, testes, produção), requisitos de desempenho, integração e facilidade de utilização.

### Hyper-V

#### Como habilitar o Hyper-V no Windows

Siga estes passos para ativar o Hyper-V no Windows 10 ou 11 (edições Pro, Enterprise ou Education):

1. **Verifique os requisitos**

    Certifique-se de que está a usar uma edição compatível do Windows (Pro, Enterprise ou Education).
    O seu processador deve suportar virtualização (Intel VT-x ou AMD-V) e esta opção deve estar ativada na BIOS/UEFI.
2. **Ative o Hyper-V nas funcionalidades do Windows**

    Prima `Win + R`, escreva `optionalfeatures` e carregue em ENTER.
    Na janela "Funcionalidades do Windows", procure e selecione **Hyper-V** (inclua as subopções "Plataforma Hyper-V" e "Ferramentas de Gestão Hyper-V").
    Clique em **OK** e aguarde a instalação dos componentes.
3. **Reinicie o computador**

    Após a instalação, será solicitado que reinicie o Windows. Guarde o seu trabalho e reinicie.
4. **Aceda ao Hyper-V Manager**

    Após reiniciar, pesquise por "Hyper-V Manager" no menu Iniciar e abra a aplicação.
    A partir daqui pode criar e gerir máquinas virtuais.

**Nota:** Se não encontrar a opção Hyper-V, verifique se o seu hardware suporta virtualização e se está ativada na BIOS/UEFI. Em alguns casos, pode ser necessário ativar também a "Segurança baseada em virtualização" nas definições do Windows.

#### Criar uma nova VM no Hyper-V

1. Abra o Hyper-V Manager (procure por "Hyper-V Manager" no menu Iniciar).
2. No painel direito, clique em "Novo" > "Máquina Virtual...".
3. Clique em "Seguinte" no assistente de criação.
4. Dê um nome à sua VM e escolha a localização para os ficheiros (opcional).
5. Selecione a geração da VM (Geração 1 para BIOS/MBR, Geração 2 para UEFI/GPT).
6. Defina a quantidade de memória RAM a atribuir.
7. Configure a ligação de rede (escolha o switch virtual, se existir).
8. Crie um novo disco rígido virtual (VHDX) ou utilize um existente.
9. Selecione a imagem ISO de instalação do sistema operativo ou configure para instalar mais tarde.
10. Reveja as configurações e clique em "Concluir".
11. A VM aparecerá na lista. Clique com o botão direito e escolha "Iniciar".
12. Clique em "Conectar" para abrir o ecrã da VM e proceder à instalação do sistema operativo.

#### Videos

1. [How to deploy Ubuntu Server as a VM on Hyper-V](https://www.youtube.com/watch?v=SddejlcR72Q)
2. [Como Instalar Ubuntu Linux no Hyper-V no Windows (Tutorial Completo)](https://www.youtube.com/watch?v=p6RoEe0CO_Q)    # PT.BR

## **Instalação**

  1. [Manual de Instalação do Ubuntu 24.04 Desktop](Ubuntu.Desktop.md)
  2. [Tutorial: Debian 13 Cloud no Windows com QEMU + cloud-init](Debian13.Cloud.md)

## **Comandos Básicos**

Abaixo estão os comandos essenciais para começar a usar Linux logo após a instalação (Ubuntu/Debian).

### Tabela rápida de comandos

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

### 1) Neofetch

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

### 2) Comando SUDO

O `sudo` (superuser do) permite executar comandos com privilégios administrativos de forma temporária, sem precisar iniciar sessão como root. É usado para tarefas que exigem permissões elevadas, como instalar software ou alterar configurações do sistema.

**Exemplo:**

```bash
sudo apt install -y git
```

### 3) Atualizar e instalar pacotes com APT

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

### 4) Acesso remoto com SSH

#### Instalar servidor ssh (Openssh)

```bash 
$ sudo apt update                               # atualiza a bd de pacotes
$ sudo apt install -y openssh-server            # instalar o servidor openssh
# Em debian e ubuntu mais recenets não necessita dos comandos abaixo
$ sudo systemctl enable --now ssh               # habilita o serviço ssh. Em distribuições mais recentes o ssh já fica habilitado após instalação
$ sudo systemctl status ssh                     # verifica o estado do serviço ssh
```

#### Descobrir o IP

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

#### Conectar por ssh

Conectar a partir de outra máquina:

```bash
$ ssh <utilizador>@<ip-da-maquina>
```

Exemplo:

```powershell
C: ❯ ssh paulo@192.168.231.128
paulo@192.168.231.128's password:
Welcome to Ubuntu 24.04.4 LTS (GNU/Linux 6.17.0-14-generic x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/pro

Expanded Security Maintenance for Applications is not enabled.

0 updates can be applied immediately.

6 additional security updates can be applied with ESM Apps.
Learn more about enabling ESM Apps service at https://ubuntu.com/esm

Last login: Mon Feb 16 16:08:23 2026 from 192.168.231.1
paulo@Ubuntu-Lab:~$
```

### 5) Nome da máquina: `hostname` e `hostnamectl`

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

### 6) Navegação no sistema

```bash
$ pwd
$ ls
$ ls -la
$ cd <pasta>
$ cd ..
$ cd ~
$ cd -

```
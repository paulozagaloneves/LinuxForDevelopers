# Linux para Developers - Dia 2

## Table of Contents

- [Linux para Developers - Dia 2](#linux-para-developers---dia-2)
  - [Table of Contents](#table-of-contents)
  - [**Objetivos Dia 2**](#objetivos-dia-2)
  - [Exercício Prático](#exercício-prático)
  - [Acesso Remoto SSH](#acesso-remoto-ssh)
    - [Configuração de SSH](#configuração-de-ssh)
    - [Acesso remoto ao linux sem senha](#acesso-remoto-ao-linux-sem-senha)
  - [Interface Linha de Comandos (CLI)](#interface-linha-de-comandos-cli)
  - [Documentação (man)](#documentação-man)
  - [Gerenciamento de Pacotes](#gerenciamento-de-pacotes)
  - [Pacotes SNAP e FLATPAK](#pacotes-snap-e-flatpak)
  - [Editores e IDE](#editores-e-ide)
  - [SDKMAN](#sdkman)
  - [.NET](#net)

## **Objetivos Dia 2**

## Exercício Prático

Para a realização dos exercicios pode usar:

1. (Preferencialmente) Linux instalado da aula 1 em computador ou VM.
2. Usar [KillerCoda - Playground Ubuntu Linux](https://killercoda.com/playgrounds/scenario/ubuntu) 
3. Usar [Iximiuz Labs - Ubuntu 24.04](https://labs.iximiuz.com/playgrounds?category=linux)


## Acesso Remoto SSH

O acesso SSH (Secure Shell) é um protocolo que permite ligar-se de forma segura a um servidor remoto, normalmente via linha de comandos, para administrar o sistema, transferir ficheiros e executar comandos. A ligação é encriptada, protegendo dados e credenciais contra interceptação.

Distingue-se de outros tipos de acesso ao servidor, como:

**Telnet:** Não encripta a comunicação, tornando-a vulnerável a ataques.

**FTP:** Usado para transferência de ficheiros, mas sem encriptação (a menos que seja FTPS/SFTP).

**Acesso físico/local:** Requer estar junto ao servidor, sem ligação remota.

**RDP/VNC:** Proporciona acesso gráfico ao desktop, mas pode ser menos seguro e mais pesado.

SSH é preferido para administração remota, por ser seguro, flexível e permitir automação (via scripts e chaves).

### Configuração de SSH

No servidor linux instalar OpenSSH e habilitar serviço ssh.

```bash
$ sudo apt install openssh-server
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


## Interface Linha de Comandos (CLI)

- Introdução ao shell (bash, zsh)

**O que é um Shell?**

Um **shell** é um interpretador de comandos que funciona como intermediário entre o utilizador e o kernel do Linux. Ele permite que você execute comandos, scripts e navegue pelo sistema de ficheiros através de uma interface de linha de comandos (CLI).

**Em resumo:** O shell é a porta de entrada para o poder do Linux, permitindo controlo completo do sistema através de comandos.

**Shells mais famosos**

**Bash (Bourne Again Shell)**
- Shell padrão na maioria das distribuições Linux
- Desenvolvido como evolução do sh original
- Versátil e amplamente suportado
- Ideal para scripts de automação
- Sintaxe simples e direta
- Excelente para iniciantes

**Zsh (Z Shell)**
- Shell moderno e poderoso com recursos avançados
- Oferece autocompletar inteligente e histórico melhorado
- Suporta temas e plugins (via frameworks como Oh My Zsh)
- Sintaxe compatível com bash, mas com mais funcionalidades
- Melhor experiência interativa para desenvolvedores
- Presets prontos para aumentar produtividade


- Navegação básica
- Variáveis de ambiente (PATH, .bashrc, .zshrc)

## Documentação (man)
- `man <comando>` - Manual de comandos
- Navegação: espaço, setas, `q` para sair
- Seções do manual (1-9)
- `man -k <palavra>` - Pesquisar por palavra-chave
- `apropos` - Buscar comandos relacionados
- `whatis` - Descrição breve de comandos
- `info` - Sistema alternativo de documentação
- `--help` ou `-h` - Ajuda rápida dos comandos

## Gerenciamento de Pacotes
- APT (Debian/Ubuntu): `apt-get`, `apt`
- YUM/DNF (RedHat/Fedora)
- Instalar, atualizar e remover software

## Pacotes SNAP e FLATPAK
- Conceitos e diferenças
- Instalação e gerenciamento

## Editores e IDE
- Visual Studio Code
- IntelliJ IDEA
- Rider
- PyCharm
- GoLand

## SDKMAN
- Instalação
- Comandos básicos
- Java
- Maven
- Projeto básico

## .NET
- Instalação
- Projeto básico

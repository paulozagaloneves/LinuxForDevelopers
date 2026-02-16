# Linux para Developers - Dia 2

## Índice

- [Linux para Developers - Dia 2](#linux-para-developers---dia-2)
  - [Índice](#índice)
  - [Objetivos Dia 2](#objetivos-dia-2)
  - [Exercícios Práticos](#exercícios-práticos)
    - [Preparação](#preparação)
    - [Exercícios](#exercícios)
  - [Acesso Remoto SSH](#acesso-remoto-ssh)
    - [Configuração de SSH](#configuração-de-ssh)
    - [Acesso remoto ao linux sem senha](#acesso-remoto-ao-linux-sem-senha)
  - [Comandos: Command e Which](#comandos-command-e-which)
  - [Editores de texto no terminal](#editores-de-texto-no-terminal)
    - [VIM](#vim)
    - [Principais atalhos do Vim](#principais-atalhos-do-vim)
    - [NANO](#nano)
    - [Principais atalhos do Nano](#principais-atalhos-do-nano)
  - [Descomplicando o Sudo](#descomplicando-o-sudo)
    - [Videos](#videos)
    - [Comando Sudo](#comando-sudo)
    - [O que é o ficheiro sudoers](#o-que-é-o-ficheiro-sudoers)
    - [Listar permissões sudo](#listar-permissões-sudo)
    - [Editar permissões Sudo](#editar-permissões-sudo)
  - [Documentação (man)](#documentação-man)
    - [MAN - Manual de comandos](#man---manual-de-comandos)
  - [Interface Linha de Comandos (CLI)](#interface-linha-de-comandos-cli)
  - [Gerenciamento de Pacotes](#gerenciamento-de-pacotes)
  - [Pacotes SNAP e FLATPAK](#pacotes-snap-e-flatpak)
  - [Ambiente DEV Java](#ambiente-dev-java)
    - [SDKMAN: Instalação](#sdkman-instalação)
    - [SDKMAN: Comandos básicos](#sdkman-comandos-básicos)
    - [SDKMAN: Exercícios](#sdkman-exercícios)
    - [Instalação maven](#instalação-maven)
    - [Projeto: Gerador Senhas Java](#projeto-gerador-senhas-java)
      - [Compilar](#compilar)
      - [Executar](#executar)
  - [Ambiente DEV .NET](#ambiente-dev-net)
  - [IDEs para Programação](#ides-para-programação)

## Objetivos Dia 2

- Acesso remoto com ssh (com e sem senha);
- Aprender a usar os editores VIM ou nano;
- Executando comando com privilégios de administrador; 
- Configurar ambiente de desenvolvimento Java;
  - Instalar JDK 21;
  - Instalar JDK 25;
- Configurar ambiente de desenvolvimento .NET;


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


## Comandos: Command e Which

| Comando | Descrição | Exemplo |
|---|---|---|
| `command` | Comando interno do shell para verificar como um comando será resolvido (builtin, alias, função ou executável). Muito usado com `-v` para mostrar o caminho/comando encontrado. | `command -v python3` |
| `which` | Mostra o caminho do executável encontrado no `PATH` (normalmente para comandos externos). | `which python3` |

Exemplo:

```bash
paulo@Ubuntu-Lab:~$ command -v python3
/usr/bin/python3
paulo@Ubuntu-Lab:~$ which python3
/usr/bin/python3
paulo@Ubuntu-Lab:~$
```

## Editores de texto no terminal

### VIM

O **Vim** é um editor de texto avançado que corre no terminal e é muito usado em Linux/Unix para edição rápida de ficheiros de configuração, código e scripts.
É um editor **modal**, ou seja, tem modos diferentes para escrever texto, navegar e executar comandos.

**Modos principais:**

- **Normal:** navegar e executar comandos
- **Insert:** inserir/editar texto
- **Command-line:** executar comandos como gravar, sair ou procurar

### Principais atalhos do Vim

| Atalho | Descrição |
|---|---|
| `i` | Entra no modo Insert (insere antes do cursor) |
| `a` | Entra no modo Insert (insere depois do cursor) |
| `o` | Cria nova linha abaixo e entra em Insert |
| `Esc` | Volta ao modo Normal |
| `:w` | Guarda o ficheiro |
| `:q` | Sai do Vim (se não houver alterações por gravar) |
| `:wq` | Guarda e sai |
| `:q!` | Sai sem guardar alterações |
| `dd` | Apaga a linha atual |
| `yy` | Copia (yank) a linha atual |
| `p` | Cola após o cursor |
| `u` | Desfaz a última alteração |
| `Ctrl+r` | Refaz alteração desfeita |
| `/texto` | Procura `texto` no ficheiro |
| `n` | Vai para a próxima ocorrência da pesquisa |
| `N` | Vai para a ocorrência anterior da pesquisa |
| `gg` | Vai para o início do ficheiro |
| `G` | Vai para o fim do ficheiro |

Exemplo:

```bash
$ vim ficheiro.txt
<carrega tecla i> Entra no modo edição
escreve o texto
<ESC> Entra no modo Normal para executar comandos
<:wq> w - Write (Grava) q - Quit (sai)
```


### NANO

O **Nano** é um editor de texto simples e intuitivo para terminal, muito usado para editar ficheiros de configuração de forma rápida.
Ao contrário do Vim, não é modal: escreve-se diretamente e os atalhos aparecem no rodapé do editor.

**Exemplo de utilização:**

```bash
$ nano ficheiro.txt
```

### Principais atalhos do Nano

| Atalho | Descrição |
|---|---|
| `Ctrl+O` | Grava o ficheiro (Write Out) |
| `Ctrl+X` | Sai do Nano |
| `Ctrl+K` | Corta a linha atual |
| `Ctrl+U` | Cola o conteúdo cortado |
| `Ctrl+W` | Procura texto |
| `Alt+W` | Vai para a próxima ocorrência da pesquisa |
| `Ctrl+\\` | Procurar e substituir |
| `Ctrl+G` | Mostra a ajuda |
| `Ctrl+C` | Mostra posição do cursor (linha/coluna) |
| `Ctrl+_` | Ir para linha e coluna |
| `Ctrl+A` | Início da linha |
| `Ctrl+E` | Fim da linha |

**Dica:** no Nano, `^` significa tecla `Ctrl` (ex.: `^X` = `Ctrl+X`).



## Descomplicando o Sudo


### Videos

1. [Linux Crash Course - sudo](https://www.youtube.com/watch?v=07JOqKOBRnU&list=PLT98CRl2KxKHKd_tH3ssq0HPrThx2hESW&index=59)


### Comando Sudo

O comando `sudo` (**superuser do**) permite executar comandos com privilégios elevados (normalmente como `root`) sem iniciar sessão diretamente como `root`.
É a forma recomendada para tarefas administrativas no Linux, porque mantém registo de auditoria e reduz riscos de segurança.

**Exemplos comuns:**

- `sudo apt update`
- `sudo systemctl restart ssh`
- `sudo -l` (lista os comandos permitidos ao utilizador atual)

### O que é o ficheiro sudoers

O ficheiro `sudoers` define **quem** pode usar `sudo`, **como** pode usar e **que comandos** pode executar.
Normalmente fica em `/etc/sudoers` e pode incluir regras adicionais em `/etc/sudoers.d/`.

**Importante:** este ficheiro deve ser editado com `visudo` (e não com editor direto), para validar a sintaxe e evitar bloquear o acesso administrativo.


### Listar permissões sudo 

```bash
$ sudo -l
[sudo] password for paulo:
Matching Defaults entries for paulo on Ubuntu-Lab:
    env_reset, mail_badpass, secure_path=/usr/local/sbin\:/usr/local/bin\:/usr/sbin\:/usr/bin\:/sbin\:/bin\:/snap/bin, use_pty

User paulo may run the following commands on Ubuntu-Lab:
    (ALL : ALL) ALL
$
```

ou 

```bash
$ sudo cat /etc/sudoers
#
# This file MUST be edited with the 'visudo' command as root.
#
# Please consider adding local content in /etc/sudoers.d/ instead of
# directly modifying this file.
#
# See the man page for details on how to write a sudoers file.
#
Defaults        env_reset
Defaults        mail_badpass
Defaults        secure_path="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/snap/bin"

# This fixes CVE-2005-4890 and possibly breaks some versions of kdesu
# (#1011624, https://bugs.kde.org/show_bug.cgi?id=452532)
Defaults        use_pty

# This preserves proxy settings from user environments of root
# equivalent users (group sudo)
#Defaults:%sudo env_keep += "http_proxy https_proxy ftp_proxy all_proxy no_proxy"

# This allows running arbitrary commands, but so does ALL, and it means
# different sudoers have their choice of editor respected.
#Defaults:%sudo env_keep += "EDITOR"

# Completely harmless preservation of a user preference.
#Defaults:%sudo env_keep += "GREP_COLOR"

# While you shouldn't normally run git as root, you need to with etckeeper
#Defaults:%sudo env_keep += "GIT_AUTHOR_* GIT_COMMITTER_*"

# Per-user preferences; root won't have sensible values for them.
#Defaults:%sudo env_keep += "EMAIL DEBEMAIL DEBFULLNAME"

# "sudo scp" or "sudo rsync" should be able to use your SSH agent.
#Defaults:%sudo env_keep += "SSH_AGENT_PID SSH_AUTH_SOCK"

# Ditto for GPG agent
#Defaults:%sudo env_keep += "GPG_AGENT_INFO"

# Host alias specification

# User alias specification

# Cmnd alias specification

# User privilege specification
root    ALL=(ALL:ALL) ALL

# Members of the admin group may gain root privileges
%admin ALL=(ALL) ALL

# Allow members of group sudo to execute any command
%sudo   ALL=(ALL:ALL) ALL

# See sudoers(5) for more information on "@include" directives:

@includedir /etc/sudoers.d
```


**Explicar a linha que define as permissões sudo dos utilizadores do grupo sudo (utilizadores comuns a que foi atribuído sudo)** 

```bash
%sudo   ALL=(ALL:ALL) ALL
```

Essa linha é uma regra do ficheiro **sudoers** e significa:

- `%sudo` → aplica-se ao grupo sudo (o % indica grupo, não utilizador individual).
- `ALL (1º)` → válida em todos os hosts.
- `(ALL:ALL)` → os membros do grupo podem executar comandos como qualquer utilizador e qualquer grupo.
- `ALL (final)` → podem executar qualquer comando.

**Em resumo:** qualquer utilizador que pertença ao grupo sudo pode usar sudo para correr qualquer comando com privilégios elevados (incluindo root), pedindo palavra-passe conforme a política definida.


### Editar permissões Sudo

**Editar ficheiro sudo**

Por segurança, o `sudo` pede a palavra-passe do utilizador quando executa comandos administrativos.
Num laboratório de testes, pode ser útil evitar esse passo para agilizar os exercícios.
Para este cenário, vamos ajustar o ficheiro `sudoers` para o nosso utilizador não pedir palavra-passe ao usar `sudo`.


Edite o ficheiro `sudoers` e acrescente a linha abaixo (substitua `paulo` pelo seu utilizador).

```
# Definir permissões especificas para o utilizador de testes
paulo ALL=(ALL:ALL) NOPASSWD: ALL
```

**Como editar**

```bash
sudo visudo
```


**Extrato como deve ficar:**

```
# User privilege specification
root    ALL=(ALL:ALL) ALL

# Members of the admin group may gain root privileges
%admin ALL=(ALL) ALL

# Allow members of group sudo to execute any command
%sudo   ALL=(ALL:ALL) ALL


# Definir permissões especificas para o utilizador de testes
paulo ALL=(ALL:ALL) NOPASSWD: ALL
```


## Documentação (man)

### MAN - Manual de comandos

O comando **man** abre o **manual** de referência de comandos e programas no Linux.

Exemplo:

**Pesquisar comandos por palavra chave**

```bash
$ man -k ssh
authorized_keys (5)  - OpenSSH daemon
EVP_KDF-SSHKDF (7ssl) - The SSHKDF EVP_KDF implementation
rrsync (1)           - a script to setup restricted rsync users via ssh logins
scp (1)              - OpenSSH secure file copy
sftp (1)             - OpenSSH secure file transfer
sftp-server (8)      - OpenSSH SFTP server subsystem
slogin (1)           - OpenSSH remote login client
ssh (1)              - OpenSSH remote login client
ssh-add (1)          - adds private key identities to the OpenSSH authentication agent
ssh-agent (1)        - OpenSSH authentication agent
ssh-argv0 (1)        - replaces the old ssh command-name as hostname handling
ssh-copy-id (1)      - use locally available keys to authorise logins on a remote machine
ssh-import-id (1)    - retrieve one or more public keys from a public keyserver and append them to the current user's authorized_keys file (or some other specified file)
ssh-import-id-gh (1) - retrieve one or more public keys from a public keyserver and append them to the current user's authorized_keys file (or some other specified file)
ssh-import-id-lp (1) - retrieve one or more public keys from a public keyserver and append them to the current user's authorized_keys file (or some other specified file)
ssh-keygen (1)       - OpenSSH authentication key utility
ssh-keyscan (1)      - gather SSH public keys from servers
ssh-keysign (8)      - OpenSSH helper for host-based authentication
ssh-pkcs11-helper (8) - OpenSSH helper for PKCS#11 support
ssh-sk-helper (8)    - OpenSSH helper for FIDO authenticator support
ssh_config (5)       - OpenSSH client configuration file
sshd (8)             - OpenSSH daemon
sshd_config (5)      - OpenSSH daemon configuration file
sss_ssh_authorizedkeys (1) - get OpenSSH authorized keys
sss_ssh_knownhostsproxy (1) - get OpenSSH host keys
```

**Consultar manual do comando ssh-add**

```bash
$ man ssh-add
SSH-ADD(1)                                 General Commands Manual                                                                                                  SSH-ADD(1)

NAME
       ssh-add — adds private key identities to the OpenSSH authentication agent

SYNOPSIS
       ssh-add [-cCDdKkLlqvXx] [-E fingerprint_hash] [-H hostkey_file] [-h destination_constraint] [-S provider] [-t life] [file ...]
       ssh-add -s pkcs11 [-vC] [certificate ...]
       ssh-add -e pkcs11
       ssh-add -T pubkey ...

DESCRIPTION
       ssh-add  adds  private  key  identities  to  the  authentication  agent,  ssh-agent(1).   When  run  without arguments, it adds the files ~/.ssh/id_rsa, ~/.ssh/id_ecdsa, ~/.ssh/id_ecdsa_sk, ~/.ssh/id_ed25519, ~/.ssh/id_ed25519_sk, and
       ~/.ssh/id_dsa.  After loading a private key, ssh-add will try to load corresponding certificate information from the filename obtained by appending -cert.pub to the name of the private key file.  Alternative file names can be given on
       the command line.

       If any file requires a passphrase, ssh-add asks for the passphrase from the user.  The passphrase is read from the user's tty.  ssh-add retries the last passphrase if multiple identity files are given.

       The authentication agent must be running and the SSH_AUTH_SOCK environment variable must contain the name of its socket for ssh-add to work.

       The options are as follows:

       -c      Indicates that added identities should be subject to confirmation before being used for authentication.  Confirmation is  performed  by  ssh-askpass(1).   Successful  confirmation  is  signaled  by  a  zero  exit  status  from
               ssh-askpass(1), rather than text entered into the requester.

       -C      When loading keys into or deleting keys from the agent, process certificates only and skip plain keys.

       -D      Deletes all identities from the agent.

       -d      Instead  of  adding  identities, removes identities from the agent.  If ssh-add has been run without arguments, the keys for the default identities and their corresponding certificates will be removed.  Otherwise, the argument
               list will be interpreted as a list of paths to public key files to specify keys and certificates to be removed from the agent.  If no public key is found at a given path, ssh-add will append .pub and retry.   If  the  argument
               list consists of “-” then ssh-add will read public keys to be removed from standard input.

       -E fingerprint_hash
               Specifies the hash algorithm used when displaying key fingerprints.  Valid options are: “md5” and “sha256”.  The default is “sha256”.

       -e pkcs11
               Remove keys provided by the PKCS#11 shared library pkcs11.

       -H hostkey_file
               Specifies a known hosts file to look up hostkeys when using destination-constrained keys via the -h flag.  This option may be specified multiple times to allow multiple files to be searched.  If no files are specified, ssh-add
               will use the default ssh_config(5) known hosts files: ~/.ssh/known_hosts, ~/.ssh/known_hosts2, /etc/ssh/ssh_known_hosts, and /etc/ssh/ssh_known_hosts2.

       -h destination_constraint
               When adding keys, constrain them to be usable only through specific hosts or to specific destinations.

               Destination constraints of the form ‘[user@]dest-hostname’ permit use of the key only from the origin host (the one running ssh-agent(1)) to the listed destination host, with optional user name.

               Constraints of the form ‘src-hostname>[user@]dst-hostname’ allow a key available on a forwarded ssh-agent(1) to be used through a particular host (as specified by ‘src-hostname’) to authenticate to a further host, specified by
               ‘dst-hostname’.

               Multiple  destination  constraints  may  be  added when loading keys.  When attempting authentication with a key that has destination constraints, the whole connection path, including ssh-agent(1) forwarding, is tested against
               those constraints and each hop must be permitted for the attempt to succeed.  For example, if key is forwarded to a remote host, ‘host-b’, and is attempting authentication to another host, ‘host-c’, then the operation will  be
               successful only if ‘host-b’ was permitted from the origin host and the subsequent ‘host-b>host-c’ hop is also permitted by destination constraints.

               Hosts  are  identified  by their host keys, and are looked up from known hosts files by ssh-add.  Wildcards patterns may be used for hostnames and certificate host keys are supported.  By default, keys added by ssh-add are not
               destination constrained.

               Destination constraints were added in OpenSSH release 8.9.  Support in both the remote SSH client and server is required when using destination-constrained keys over a forwarded ssh-agent(1) channel.

               It is also important to note that destination constraints can only be enforced by ssh-agent(1) when a key is used, or when it is forwarded by a cooperating ssh(1).  Specifically, it does not prevent an attacker with access  to
               a remote SSH_AUTH_SOCK from forwarding it again and using it on a different host (but only to a permitted destination).

       -K      Load resident keys from a FIDO authenticator.

       -k      When loading keys into or deleting keys from the agent, process plain private keys only and skip certificates.
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

## Gerenciamento de Pacotes
- APT (Debian/Ubuntu): `apt-get`, `apt`
- YUM/DNF (RedHat/Fedora)
- Instalar, atualizar e remover software

## Pacotes SNAP e FLATPAK
- Conceitos e diferenças
- Instalação e gerenciamento


## Ambiente DEV Java

### SDKMAN: Instalação

[SDKMAN.io](https://sdkman.io/)

O **SDKMAN!** é um gestor de versões para SDKs e ferramentas de linha de comandos (ex.: Java, Maven, Gradle, Kotlin). Permite instalar, atualizar e alternar versões facilmente, por projeto ou por utilizador.

**Instalação (Linux/macOS):**

```bash
$ sudo apt update
$ sudo apt install -y curl zip unzip

$ curl -s "https://get.sdkman.io" | bash
```

Depois, carregue o SDKMAN na sessão atual:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
$ sdk version

SDKMAN!
script: 5.20.0
native: 0.7.16 (linux x86_64)

```

### SDKMAN: Comandos básicos

| Comando | Descrição |
|---|---|
| `sdk version` | Mostra a versão do SDKMAN instalada |
| `sdk list java` | Lista as versões de Java disponíveis para instalação |
| `sdk install java 25.0.2-tem` | Instala a versão 25.0.2 do Temurin (Java) |
| `sdk use java 21.0.2-tem` | Usa a versão indicada apenas na sessão atual |
| `sdk default java 21.0.2-tem` | Define a versão indicada como padrão |
| `sdk current java` | Mostra a versão de Java ativa |
| `sdk uninstall java 25.0.2-tem` | Remove a versão instalada |
| `sdk list maven` | Lista versões do Maven disponíveis |
| `sdk install maven 3.9.6` | Instala o Maven na versão indicada |

**Exemplo de uso rápido:**

```bash
sdk list java
sdk install java 21.0.2-tem
sdk install java 25.0.2-tem
sdk use java 21.0.2-tem
java -version
```

### SDKMAN: Exercícios

1. Instalar JDK 21 (21.0.10-tem)
2. Instalar JDK 25 (25.0.2-tem)
3. Verificar a versão de java atual
Ajuda: use java --version e sdk current java
4. Alterar versão java default para jdk 21


### Instalação maven

```bash
$ sdk install maven 3.9.12
$ sdk install maven 3.9.12

Downloading: maven 3.9.12

In progress...

################################################################################################################################################################################ 100.0%

Installing: maven 3.9.12
Done installing!


Setting maven 3.9.12 as default.
$
$ mvn --version
Apache Maven 3.9.12 (848fbb4bf2d427b72bdb2471c22fced7ebd9a7a1)
Maven home: /home/paulo/.sdkman/candidates/maven/current
Java version: 25.0.2, vendor: Eclipse Adoptium, runtime: /home/paulo/.sdkman/candidates/java/25.0.2-tem
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.17.0-14-generic", arch: "amd64", family: "unix"
$
```

### Projeto: Gerador Senhas Java

#### Compilar

```bash
$ cd gerador-senhas-java
$ mvn clean package                               
```

#### Executar

```bash
$ java -jar .\target\gerador-senhas-java-1.0.0.jar gerar 
$
$ java -jar .\target\gerador-senhas-java-1.0.0.jar gerar 10
$
$ java -jar .\target\gerador-senhas-java-1.0.0.jar version
```


## Ambiente DEV .NET
- Instalação de SDK
- Projeto básico


## IDEs para Programação
- Visual Studio Code
- IntelliJ IDEA
- Rider
- PyCharm
- GoLand






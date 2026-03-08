# Linux For Developers - Dia 3

## Índice

- [Documentação (man)](#documentação-man)
  - [MAN - Manual de comandos](#man---manual-de-comandos)
- [Editores de texto no terminal](#editores-de-texto-no-terminal)
  - [VIM](#vim)
  - [NANO](#nano)
  - [Visual Studio Code Remote](#visual-studio-code-remote)
- [Gerenciamento de Pacotes](#gerenciamento-de-pacotes)
        - [Videos](#videos)
        - [APT (Debian/Ubuntu): `apt-get`, `apt`](#apt-debianubuntu-apt-get-apt)
        - [YUM/DNF (RedHat/Fedora)](#yumdnf-redhatfedora)
        - [Instalar, atualizar e remover software (resumo rápido)](#instalar-atualizar-e-remover-software-resumo-rápido)
- [Pacotes SNAP e FLATPAK](#pacotes-snap-e-flatpak)
        - [Conceitos e diferenças](#conceitos-e-diferenças)
        - [Para quem servem](#para-quem-servem)
        - [SNAP vs FLATPAK vs APT — quando usar cada um](#snap-vs-flatpak-vs-apt--quando-usar-cada-um)
        - [FLATPAK](#flatpak)
        - [SNAP](#snap)


## Documentação (man)

### MAN - Manual de comandos

O comando **man** abre o **manual** de referência de comandos e programas no Linux.
Funciona como uma documentação local, organizada por tópicos, que ajuda a compreender rapidamente **como usar um comando**, **quais opções existem** e **como interpretar os argumentos**.

Em vez de procurar sempre na internet, o `man` permite consultar a documentação oficial diretamente no terminal, mesmo sem ligação à internet (desde que as páginas do manual estejam instaladas no sistema).

Uma página de manual costuma trazer secções como:

- **NAME**: nome e descrição curta do comando
- **SYNOPSIS**: sintaxe de utilização
- **DESCRIPTION**: explicação detalhada do funcionamento
- **OPTIONS**: lista de opções e flags disponíveis
- **EXAMPLES**: exemplos práticos (quando disponíveis)
- **SEE ALSO**: comandos relacionados

Além disso, o Linux separa documentação por **secções numeradas**. Isto é útil quando existe o mesmo nome para coisas diferentes:

- `1` → comandos de utilizador (ex.: `man ls`)
- `5` → formatos de ficheiros e configuração (ex.: `man 5 ssh_config`)
- `8` → comandos administrativos/sistema (ex.: `man 8 sshd`)

Navegação básica dentro do `man`:

- `Space` / `b` → avançar/voltar página
- `/texto` → procurar conteúdo na página
- `n` / `N` → próxima/anterior ocorrência da pesquisa
- `q` → sair

Comandos úteis relacionados:

- `man -k <palavra>` → pesquisa por palavra-chave (equivalente a `apropos`)
- `man <comando>` → abre o manual de um comando
- `man <secção> <nome>` → abre uma secção específica (ex.: `man 5 passwd`)
- `man -f <nome>` → descrição curta (equivalente a `whatis`)


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

## Editores de texto no terminal

### VIM

O **Vim** é um editor de texto avançado que corre no terminal e é muito usado em Linux/Unix para edição rápida de ficheiros de configuração, código e scripts.
É um editor **modal**, ou seja, tem modos diferentes para escrever texto, navegar e executar comandos.

**Modos principais:**

- **Normal:** navegar e executar comandos
- **Insert:** inserir/editar texto
- **Command-line:** executar comandos como gravar, sair ou procurar

#### Principais atalhos do Vim

| Atalho   | Descrição                                        |
| -------- | ------------------------------------------------ |
| `i`      | Entra no modo Insert (insere antes do cursor)    |
| `a`      | Entra no modo Insert (insere depois do cursor)   |
| `o`      | Cria nova linha abaixo e entra em Insert         |
| `Esc`    | Volta ao modo Normal                             |
| `:w`     | Guarda o ficheiro                                |
| `:q`     | Sai do Vim (se não houver alterações por gravar) |
| `:wq`    | Guarda e sai                                     |
| `:q!`    | Sai sem guardar alterações                       |
| `dd`     | Apaga a linha atual                              |
| `yy`     | Copia (yank) a linha atual                       |
| `p`      | Cola após o cursor                               |
| `u`      | Desfaz a última alteração                        |
| `Ctrl+r` | Refaz alteração desfeita                         |
| `/texto` | Procura `texto` no ficheiro                      |
| `n`      | Vai para a próxima ocorrência da pesquisa        |
| `N`      | Vai para a ocorrência anterior da pesquisa       |
| `gg`     | Vai para o início do ficheiro                    |
| `G`      | Vai para o fim do ficheiro                       |

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

#### Principais atalhos do Nano

| Atalho    | Descrição                                 |
| --------- | ----------------------------------------- |
| `Ctrl+O`  | Grava o ficheiro (Write Out)              |
| `Ctrl+X`  | Sai do Nano                               |
| `Ctrl+K`  | Corta a linha atual                       |
| `Ctrl+U`  | Cola o conteúdo cortado                   |
| `Ctrl+W`  | Procura texto                             |
| `Alt+W`   | Vai para a próxima ocorrência da pesquisa |
| `Ctrl+\\` | Procurar e substituir                     |
| `Ctrl+G`  | Mostra a ajuda                            |
| `Ctrl+C`  | Mostra posição do cursor (linha/coluna)   |
| `Ctrl+_`  | Ir para linha e coluna                    |
| `Ctrl+A`  | Início da linha                           |
| `Ctrl+E`  | Fim da linha                              |

**Dica:** no Nano, `^` significa tecla `Ctrl` (ex.: `^X` = `Ctrl+X`).

### Visual Studio Code Remote

É possivel usar o VS Code para editar ficheiros num Linux remoto.
O VS Code Remote - SSH é uma das formas mais produtivas de editar ficheiros remotamente como se estivessem na tua máquina local.

Vou mostrar:

✅ Como configurar o acesso remoto

✅ Como editar ficheiros no diretório do utilizador

🔐 Como editar ficheiros que precisam de permissões de administrador (sudo)

1️⃣ **Instalar o VS Code e a extensão Remote SSH**

🧩 Instalar o Visual Studio Code

Se ainda não tiveres:

👉 Instala o Visual Studio Code no Windows ou Linux

🔌 Instalar a extensão Remote - SSH

1. Abre o VS Code
2. Vai a Extensions (Ctrl+Shift+X)
3. Procura por: Remote - SSH
4. Instala a extensão da Microsoft

Nome completo:

Remote - SSH (da Microsoft)

2️⃣ **Preparar o servidor Linux**

No servidor remoto precisas de:

- SSH ativo
- Um utilizador com acesso SSH

Verifica no servidor:

```bash
$ sudo systemctl status ssh
```

Se não estiver instalado:

```bash
$ sudo apt install openssh-server
```

3️⃣ **Configurar ligação SSH no teu computador**

No teu PC (Windows/Linux/Mac), edita o ficheiro:

```powershell
$USER/.ssh/config
```

**Exemplo:**

Host vigilant
    HostName 192.168.1.199
    User paulo
    IdentityFile ~/.ssh/id_rsa

Agora no VS Code:

1. Ctrl + Shift + P
2. Escreve: Remote-SSH: Connect to Host
3. Escolhe o host configurado

O VS Code vai instalar automaticamente um servidor interno no Linux remoto.

4️⃣ **Editar ficheiros no diretório do utilizador (modo normal)**

Depois de conectado:

1. Vai a File → Open Folder
2. Escolhe /home/paulo
3. Abre qualquer ficheiro normalmente

Exemplo:

```bash
/home/paulo/appsettings.json
/home/paulo/docker-compose.yml
```

💡 Aqui estás a usar as permissões normais do utilizador SSH.

Se o utilizador tiver acesso, tudo funciona normalmente.

🔐 **Como editar ficheiros que precisam de permissões de administrador (sudo)**

Em Linux remoto, ficheiros como os de `/etc` normalmente não podem ser alterados por utilizadores comuns.
Nesses casos, deves usar `sudo` para editar com privilégios elevados.

Formas recomendadas:

1. **No terminal com editor**

```bash
sudo nano /etc/ssh/sshd_config
```

ou

```bash
sudo vim /etc/ssh/sshd_config
```

2. **Com `sudoedit` (mais seguro)**

```bash
sudoedit /etc/ssh/sshd_config
```

O `sudoedit` abre uma cópia temporária no teu editor, e só no fim grava no ficheiro original com permissões de administrador.

Pode configurar para usar o VS Code:

```bash
export EDITOR="code --wait"
```

3. **Fluxo prático no VS Code Remote (sem abrir o VS Code inteiro como root)**

- Lê o ficheiro para inspeção:

```bash
sudo cat /etc/ssh/sshd_config
```

- Edita via terminal com `sudo nano`/`sudo vim` para alterações rápidas.
- Para ficheiros grandes, podes copiar para a home, editar no VS Code e depois substituir com `sudo`:

```bash
sudo cp /etc/ssh/sshd_config ~/sshd_config.tmp
sudo chown $USER:$USER ~/sshd_config.tmp
# editar no VS Code
sudo cp ~/sshd_config.tmp /etc/ssh/sshd_config
```

4. **Validar e aplicar alterações**

Depois de editar ficheiros de serviços (como SSH), valida a configuração antes de reiniciar:

```bash
sudo sshd -t
sudo systemctl restart ssh
sudo systemctl status ssh
```

✅ Boa prática: evita trabalhar sempre como `root`; usa `sudo` apenas nos comandos necessários.




## Gerenciamento de Pacotes

### Videos

- [Curso intensivo de Linux - O comando apt](https://www.youtube.com/watch?v=1kicKTbK768)
- [CLI do Linux em 60 segundos - apt](https://www.youtube.com/watch?v=yE9oct13WTQ)

### APT (Debian/Ubuntu): `apt-get`, `apt`

O **APT (Advanced Package Tool)** é o sistema de gestão de pacotes nas distribuições baseadas em Debian/Ubuntu.
Ele trabalha sobre pacotes `.deb` e resolve automaticamente dependências entre pacotes.

**Como funciona (visão prática):**

1. O sistema lê a lista de repositórios em `/etc/apt/sources.list` e `/etc/apt/sources.list.d/`
2. Com `apt update`, descarrega o índice de pacotes disponíveis
3. Com `apt install`, escolhe versões compatíveis e instala dependências necessárias
4. Mantém base local de pacotes instalados para gerir upgrades e remoções

**`apt` vs `apt-get`**

- `apt`: interface mais amigável para uso interativo
- `apt-get`: interface tradicional, muito usada em scripts e automação

#### Exemplos completos com APT

**1) Atualizar índices e sistema**

```bash
sudo apt update
sudo apt upgrade -y
```

**2) Procurar pacote e ver detalhes**

```bash
apt search nginx
apt show nginx
apt policy nginx
```

**3) Instalar software**

```bash
sudo apt install -y nginx curl git
```

**4) Remover software**

```bash
sudo apt remove -y nginx
sudo apt purge -y nginx
sudo apt autoremove -y
```

- `remove`: remove o pacote, mas mantém ficheiros de configuração
- `purge`: remove pacote e configurações locais
- `autoremove`: limpa dependências que ficaram órfãs

**5) Limpeza de cache de pacotes**

```bash
sudo apt clean
sudo apt autoclean
```

**6) Atualização completa (inclui mudanças de dependências)**

```bash
sudo apt full-upgrade -y
```

> Usa com atenção em servidores de produção, pois pode adicionar/remover pacotes para satisfazer dependências.


### YUM/DNF (RedHat/Fedora)

Nas distribuições da família Red Hat/Fedora, o gestor atual é o **DNF** (sucessor do YUM).
Ele trabalha sobre pacotes `.rpm`, também resolve dependências e usa repositórios configurados em ficheiros `.repo`.

**Como funciona (visão prática):**

1. Lê repositórios em `/etc/yum.repos.d/`
2. Sincroniza metadados dos pacotes
3. Resolve dependências e conflitos
4. Instala, atualiza ou remove pacotes mantendo consistência do sistema

#### Exemplos completos com DNF

**1) Verificar updates e atualizar sistema**

```bash
sudo dnf check-update
sudo dnf upgrade -y
```

**2) Procurar pacote e inspecionar info**

```bash
dnf search nginx
dnf info nginx
dnf list installed
```

**3) Instalar software**

```bash
sudo dnf install -y nginx curl git
```

**4) Remover software e dependências não usadas**

```bash
sudo dnf remove -y nginx
sudo dnf autoremove -y
```

**5) Limpar metadados/cache**

```bash
sudo dnf clean all
sudo dnf makecache
```

> Em sistemas mais antigos podes ver `yum` em vez de `dnf`; na maioria dos cenários modernos, `dnf` é o comando recomendado.

### Instalar, atualizar e remover software (resumo rápido)

**Debian/Ubuntu (APT):**

```bash
sudo apt update
sudo apt install -y pacote
sudo apt upgrade -y
sudo apt remove -y pacote
```

**RedHat/Fedora (DNF):**

```bash
sudo dnf check-update
sudo dnf install -y pacote
sudo dnf upgrade -y
sudo dnf remove -y pacote
```

✅ Regra prática: atualiza os índices/metadados antes de instalar e valida sempre o nome do pacote com `search`/`info`.

## Pacotes SNAP e FLATPAK

O **Snap** e o **Flatpak** são formatos modernos de distribuição de aplicações no Linux.
Ao contrário do modelo clássico de pacotes da distro (como `apt`), eles empacotam a aplicação com boa parte das dependências, facilitando instalação e atualização entre diferentes distribuições.

### Conceitos e diferenças

**SNAP**

- Formato criado pela Canonical
- Usa o serviço `snapd`
- Forte integração com Ubuntu
- Distribuição centralizada via Snap Store
- Atualizações automáticas por padrão

**FLATPAK**

- Formato focado principalmente em aplicações desktop
- Usa runtimes compartilhados (ex.: GNOME/KDE Runtime)
- Distribuição por repositórios como o Flathub
- Muito usado em Fedora e outras distros desktop
- Bom isolamento por permissões/sandbox

**Diferenças principais (resumo):**

- Snap: mais integrado no ecossistema Canonical/Ubuntu e também comum em apps de servidor/CLI
- Flatpak: muito forte para apps gráficas desktop e integração com lojas como Flathub
- APT: gestor tradicional da distro, ideal para base do sistema e bibliotecas nativas

### Para quem servem

Snap e Flatpak são úteis para:

- Utilizadores que querem instalar apps recentes sem depender do ciclo de versões da distro
- Ambientes com múltiplas distribuições (mesma app, método semelhante)
- Casos onde isolamento/sandbox é desejado
- Desenvolvedores que querem distribuir aplicações com menos variação entre distros

### SNAP vs FLATPAK vs APT — quando usar cada um

**Usa APT quando:**

- Estás a gerir componentes do sistema (kernel tools, libs base, serviços nativos)
- Queres integração total com a distro
- Precisas de comportamento previsível para administração de servidor

**Usa Flatpak quando:**

- Queres aplicações desktop atualizadas (ex.: browsers, IDEs, utilitários GUI)
- Pretendes isolamento por permissões de app
- Estás num desktop Linux e queres catálogo amplo via Flathub

**Usa Snap quando:**

- Estás em Ubuntu e queres integração simples com Snap Store
- Queres atualizações automáticas de apps empacotadas em snap
- Precisas de apps já distribuídas oficialmente em Snap

✅ Regra prática: **sistema e ferramentas base** → `apt`; **apps desktop isoladas e recentes** → `flatpak` (muito comum) ou `snap` (especialmente no Ubuntu).

### FLATPAK

O **Flatpak** é um formato universal para distribuir aplicações Linux, com foco em desktop, isolamento de permissões e portabilidade entre distribuições.

#### Instalar Flatpak

**Ubuntu/Debian:**

```bash
sudo apt update
sudo apt install -y flatpak
```

Adicionar o repositório Flathub:

```bash
flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo
```

#### Usar Flatpak (comandos principais)

Pesquisar app:

```bash
flatpak search vlc
```

Instalar app:

```bash
flatpak install -y flathub org.videolan.VLC
```

Executar app:

```bash
flatpak run org.videolan.VLC
```

Listar apps instaladas:

```bash
flatpak list
```

Atualizar apps Flatpak:

```bash
flatpak update -y
```

Remover app:

```bash
flatpak uninstall -y org.videolan.VLC
```

Limpar runtimes não usados:

```bash
flatpak uninstall --unused -y
```

### SNAP

O **Snap** é um formato universal da Canonical para empacotar e distribuir aplicações em Linux, com atualizações automáticas, isolamento e instalação simplificada via `snapd`.

#### Instalar Snap

**Ubuntu:** normalmente já vem instalado.

**Debian/Ubuntu (se necessário):**

```bash
sudo apt update
sudo apt install -y snapd
```

Ativar serviço:

```bash
sudo systemctl enable --now snapd
```

#### Usar Snap (comandos principais)

Pesquisar app:

```bash
snap find vlc
```

Instalar app:

```bash
sudo snap install vlc
```

Listar snaps instalados:

```bash
snap list
```

Atualizar snaps:

```bash
sudo snap refresh
```

Atualizar um snap específico:

```bash
sudo snap refresh vlc
```

Remover app:

```bash
sudo snap remove vlc
```

Ver informação detalhada:

```bash
snap info vlc
```


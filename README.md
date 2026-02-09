# Linux For Developers

## Trilha de Treinamento

### 📅 [Dia 1 - Fundamentos do Linux](day-1/README.md)

- **Introdução ao Linux**
  - História e evolução do Linux
  - Distribuições Populares (Ubuntu, Debian, Fedora, CentOS)
  - Filosofia Open Source
- **Virtualização do Linux**
- **Instalação e Configuração**
  - Instalação de distribuições


---

### 📅 Dia 2 - Acesso Remoto e Gerenciamento de Pacotes

- **Acesso SSH**
  - Configuração de SSH
  - Autenticação por chave pública/privada
  - Conexões seguras
- **Interface Linha de Comandos (CLI)**
  - Introdução ao shell (bash, zsh)
  - Navegação básica
  - Variáveis de ambiente (PATH, .bashrc, .zshrc)

  -
- **Documentação (man)**
  - `man <comando>` - Manual de comandos
  - Navegação: espaço, setas, `q` para sair
  - Seções do manual (1-9)
  - `man -k <palavra>` - Pesquisar por palavra-chave
  - `apropos` - Buscar comandos relacionados
  - `whatis` - Descrição breve de comandos
  - `info` - Sistema alternativo de documentação
  - `--help` ou `-h` - Ajuda rápida dos comandos
- **Gerenciamento de Pacotes**
  - APT (Debian/Ubuntu): `apt-get`, `apt`
  - YUM/DNF (RedHat/Fedora)
  - Instalar, atualizar e remover software
- **Pacotes SNAP e FLATPAK**
  - Conceitos e diferenças
  - Instalação e gerenciamento
- **Editores e IDE**
  - Visual Studio Code
  - IntelliJ IDEA
  - Rider
  - PyCharm
  - GoLand
- **SDKMAN**
  - Instalação
  - Comandos básicos
  - Java
  - Maven
  - Projeto básico
- **.NET**    
  - Instalação
  - Projeto básico

---

### 📅 Dia 3 - Manipulação de Arquivos e Diretórios

- **Estrutura de Diretorios (FHS)**
  - `/` - Diretório raiz
  - `/bin` - Binários essenciais do sistema
  - `/boot` - Arquivos de inicialização (kernel, GRUB)
  - `/dev` - Dispositivos (devices)
  - `/etc` - Arquivos de configuração do sistema
  - `/home` - Diretórios pessoais dos usuários
  - `/lib` - Bibliotecas compartilhadas essenciais
  - `/mnt` - Pontos de montagem temporários
  - `/opt` - Pacotes de software opcionais
  - `/proc` - Sistema de arquivos virtual (processos)
  - `/root` - Diretório pessoal do superusuário
  - `/sbin` - Binários do sistema (superusuário)
  - `/srv` - Dados de serviços
  - `/tmp` - Arquivos temporários
  - `/usr` - Hierarquia secundária (programas, bibliotecas)
  - `/var` - Dados variáveis (logs, cache, spool)
- **Comandos de Manipulação de Diretórios**
  - `pwd`, `cd`, `ls`, `mkdir`, `rmdir`
  - `tree`, `find`, `locate`
  - Navegação e organização
- **Comandos de Manipulação de Ficheiros**
  - `touch`, `cp`, `mv`, `rm`
  - `cat`, `less`, `more`, `head`, `tail`
  - `grep`, `awk`, `sed`
  - Permissões: `chmod`, `chown`, `chgrp`
- **Editores de Texto**
  - `nano` - Editor para iniciantes
  - `vim` - Editor avançado
  - `vi` - Editor clássico
  - Configuração e personalização

---

### 📅 Dia 4 - Processos, Compressão e Redes

- **Comandos de Processos**
  - `ps` - Listar processos
  - `top`, `htop` - Monitoramento em tempo real
  - `kill`, `killall` - Finalizar processos
  - `jobs`, `bg`, `fg` - Gerenciamento de jobs
  - `nohup`, `screen`, `tmux`
- **Comandos de Compressão**
  - `tar` - Arquivamento
  - `gzip`, `gunzip` - Compressão
  - `zip`, `unzip` - Arquivos ZIP
  - `bzip2`, `xz` - Outras ferramentas
- **Comandos Básicos de Redes**
  - `ping`, `traceroute` - Diagnóstico
  - `ifconfig`, `ip` - Configuração de rede
  - `netstat`, `ss` - Conexões ativas
  - `curl`, `wget` - Download de arquivos
  - `scp`, `rsync` - Transferência de arquivos

---

### 📅 Dia 5 - Administração de Utilizadores, Grupos e Ficheiros

- **Criação, Modificação e Remoção de Utilizadores e Grupos**
  - `useradd`, `usermod`, `userdel` - Gestão de utilizadores
  - `groupadd`, `groupmod`, `groupdel` - Gestão de grupos
  - `id`, `whoami`, `who`, `w` - Informações de utilizadores
  - `sudo` - Privilégios de Superuser com Sudo
  - Ficheiros: `/etc/passwd`, `/etc/shadow`, `/etc/group`
- **Gestão de Senhas e Permissões**
  - `passwd` - Alterar senhas
  - `chage` - Política de expiração de senhas
  - `sudo`, `su` - Elevação de privilégios
  - Configuração do `sudoers` (`visudo`)
- **Permissões de Ficheiros e Diretórios**
  - Leitura, escrita e execução (rwx)
  - Permissões para proprietário, grupo e outros
  - Notação octal e simbólica
- **Comandos de Controlo de Permissões**
  - `chown` - Alterar proprietário
  - `chgrp` - Alterar grupo
  - `chmod` - Alterar permissões
  - `umask` - Máscara padrão de permissões
- **Controlo Avançado de Permissões**
  - **SUID** (Set User ID) - Executar com privilégios do proprietário
  - **SGID** (Set Group ID) - Executar com privilégios do grupo
  - **Sticky Bit** - Proteção de ficheiros em diretórios compartilhados
  - Exemplos práticos e casos de uso

---

### 📅 Dia 6 - Redirecionamento, Pipes e Shell Scripting

- **Uso de STDIN, STDOUT e STDERR**
  - File descriptors: 0 (stdin), 1 (stdout), 2 (stderr)
  - Compreensão dos fluxos de entrada e saída
- **Redirecionadores**
  - `>` - Redirecionar stdout (sobrescrever)
  - `>>` - Redirecionar stdout (anexar)
  - `<` - Redirecionar stdin
  - `2>` - Redirecionar stderr
  - `2>&1` - Redirecionar stderr para stdout
  - `&>` ou `>&` - Redirecionar stdout e stderr
  - `/dev/null` - Descartar saída
- **Comandos Pipes e Tee**
  - `|` (pipe) - Encadear comandos
  - `tee` - Ler stdin e escrever para stdout e ficheiros
  - Exemplos práticos de pipelines
  - Combinação de múltiplos comandos
- **Aliases**
  - Criar aliases temporários: `alias nome='comando'`
  - Aliases permanentes: `~/.bashrc`, `~/.bash_aliases`
  - Listar aliases: `alias`
  - Remover aliases: `unalias`
  - Boas práticas e exemplos úteis
- **Programação Shell (Shell Scripting)**
  - Estrutura básica de um script
  - Shebang (`#!/bin/bash`)
  - Variáveis e tipos de dados
  - Estruturas de controlo: `if`, `else`, `elif`, `case`
  - Loops: `for`, `while`, `until`
  - Funções
  - Parâmetros e argumentos (`$1`, `$2`, `$@`, `$#`)
  - Testes e condicionais (`test`, `[ ]`, `[[ ]]`)
  - Códigos de saída (`$?`)
  - Boas práticas e debugging

---

### Configurações Gerais

- [Certbot com Let's Encrypt e Cloudflare](general/Certbot-LetsEncrypt-Cloudflare.md)

---

## 🎯 Objetivos do Treinamento

Ao final desta trilha, o desenvolvedor será capaz de:
- Navegar e operar com confiança em ambientes Linux
- Gerenciar pacotes e dependências
- Manipular arquivos e diretórios de forma eficiente
- Conectar-se remotamente via SSH
- Monitorar e gerenciar processos do sistema
- Trabalhar com compressão e arquivamento
- Executar operações básicas de rede
- Administrar utilizadores, grupos e permissões de segurança
- Utilizar redirecionamento de I/O e criar pipelines eficientes
- Desenvolver scripts shell para automação de tarefas

## 📚 Recursos Adicionais

- Documentação oficial das distribuições
- Man pages (`man <comando>`)
- [Linux Command Line Basics](https://www.linux.org)
- Comunidades e fóruns de suporte
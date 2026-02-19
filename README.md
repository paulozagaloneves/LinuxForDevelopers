# Linux For Developers

## Trilha de Treinamento

### 📅 [Dia 1 - Setup](day-1/README.md)

- **Objetivos Dia 1**
- Exercício Prático
- **Introdução ao Linux**
  - História e evolução do Linux
  - Distribuições Populares (Ubuntu, Debian, Fedora, CentOS)
  - Filosofia Open Source
- **Virtualização do Linux**
- **Instalação e Configuração**
  - Manual de Instalação do Ubuntu 24.04 Desktop
  - Tutorial: Debian 13 Cloud no Windows com QEMU + cloud-init


---

### 📅 [Dia 2 - Shell Básico](day-2/README.md)
  - Objetivos Dia 2
  - Exercícios Práticos
    - Preparação
    - Exercícios
  - O Despertar do Terminal
    - Mapa de Sobrevivência: Comandos Essenciais
    - Raio-X do Sistema: Conhecendo a Máquina com Neofetch
    - Poder Elevado: Usando o Sudo
    - O Ecossistema de Pacotes: Atualizações e Instalações com APT
      - Videos
    - Localizando a Máquina na Rede: Descobrindo o IP do Servidor
    - Identidade Digital: Gerenciando o Hostname da Máquina
  - Além das Fronteiras: Acesso Remoto com SSH
    - Configuração de SSH
      - Instalar servidor ssh (Openssh)
    - Acesso remoto ao linux sem senha
      - Videos
  - A Arquitetura do Sistema: Entendendo o FHS
  - Explorando o Território: Navegação e Listagem no Sistema de Arquivos
  - Construindo e Remodelando: Manipulação de Ficheiros e Diretórios
  - Memória do Shell: Produtividade e Eficiência com History
  - Estética e Poder: Transformando o Terminal com Oh-My-Zsh
  

---

### 📅 [Dia 2 - Acesso Remoto e Gerenciamento de Pacotes](day-2/README.md)

- **Objetivos Dia 2**
- Exercícios Práticos
  - Preparação
  - Exercícios
- Acesso Remoto SSH
  - Configuração de SSH
  - Acesso remoto ao linux sem senha
- Comandos: Command e Which]
- Editores de texto no terminal
  - VIM
    - Principais atalhos do Vim
  - Nano
    - Principais atalhos do Nano
  - Visual Studio Code Remote
- Descomplicando o Sudo
  - Comando Sudo
  - O que é o ficheiro sudoers
  - Listar permissões sudo
  - Editar permissões Sudo
- Documentação (man)
  - MAN - Manual de comandos
- Interface Linha de Comandos (CLI)
- Gerenciamento de Pacotes
- Pacotes SNAP e FLATPAK
- Ambiente DEV Java
  - GIT
  - SDKMAN: Instalação
  - SDKMAN: Comandos básicos
  - SDKMAN: Exercícios
  - Instalação maven
  - Projeto: Gerador Senhas Java
    - Compilar
    - Executar
- Ambiente DEV .NET
- IDEs para Programação

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

### Configurações Avançadas

- [Certbot com Let's Encrypt e Cloudflare](general/Certbot-LetsEncrypt-Cloudflare.md)

---

## 🎯 Objetivos do Treinamento

No final desta formação, o programador será capaz de:
- Navegar e operar com confiança em ambientes Linux
- Gerir pacotes e dependências
- Manipular ficheiros e diretórios de forma eficiente
- Ligar-se remotamente via SSH
- Monitorizar e gerir processos do sistema
- Trabalhar com compressão e arquivamento
- Executar operações básicas de rede
- Administrar utilizadores, grupos e permissões de segurança
- Utilizar redirecionamento de I/O e criar pipelines eficientes
- Desenvolver scripts shell para automatizar tarefas

## 📚 Recursos Adicionais

- Documentação oficial das distribuições
- Man pages (`man <comando>`)
- [Linux Command Line Basics](https://www.linux.org)
- Comunidades e fóruns de suporte
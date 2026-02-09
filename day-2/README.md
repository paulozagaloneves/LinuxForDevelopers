# Linux para Developers - Dia 2

## Acesso Remoto e Gerenciamento de Pacotes

### Acesso SSH

O acesso SSH (Secure Shell) é um protocolo que permite ligar-se de forma segura a um servidor remoto, normalmente via linha de comandos, para administrar o sistema, transferir ficheiros e executar comandos. A ligação é encriptada, protegendo dados e credenciais contra interceptação.

Distingue-se de outros tipos de acesso ao servidor, como:

**Telnet:** Não encripta a comunicação, tornando-a vulnerável a ataques.

**FTP:** Usado para transferência de ficheiros, mas sem encriptação (a menos que seja FTPS/SFTP).

**Acesso físico/local:** Requer estar junto ao servidor, sem ligação remota.

**RDP/VNC:** Proporciona acesso gráfico ao desktop, mas pode ser menos seguro e mais pesado.

SSH é preferido para administração remota, por ser seguro, flexível e permitir automação (via scripts e chaves).

- Configuração de SSH

No servidor linux instalar OpenSSH e habilitar serviço ssh.

```bash
$ sudo apt install openssh-server
```

Agora já consegue aceder remotamente ao linux.

- Acesso remoto ao linux com SSH

```powershell
c: > ssh user@<IP do linux>
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


- Autenticação por chave pública/privada
- Conexões seguras

### Interface Linha de Comandos (CLI)
- Introdução ao shell (bash, zsh)
- Navegação básica
- Variáveis de ambiente (PATH, .bashrc, .zshrc)

### Documentação (man)
- `man <comando>` - Manual de comandos
- Navegação: espaço, setas, `q` para sair
- Seções do manual (1-9)
- `man -k <palavra>` - Pesquisar por palavra-chave
- `apropos` - Buscar comandos relacionados
- `whatis` - Descrição breve de comandos
- `info` - Sistema alternativo de documentação
- `--help` ou `-h` - Ajuda rápida dos comandos

### Gerenciamento de Pacotes
- APT (Debian/Ubuntu): `apt-get`, `apt`
- YUM/DNF (RedHat/Fedora)
- Instalar, atualizar e remover software

### Pacotes SNAP e FLATPAK
- Conceitos e diferenças
- Instalação e gerenciamento

### Editores e IDE
- Visual Studio Code
- IntelliJ IDEA
- Rider
- PyCharm
- GoLand

### SDKMAN
- Instalação
- Comandos básicos
- Java
- Maven
- Projeto básico

### .NET
- Instalação
- Projeto básico

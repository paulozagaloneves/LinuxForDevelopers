# Linux For Developers - Dia 4

## Índice



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
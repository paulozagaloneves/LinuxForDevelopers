# Linux For Developers - Dia 7

## Índice


## Ambiente DEV Java

### GIT

**Instalar**

```bash
$ sudo apt install git
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following package was automatically installed and is no longer required:
  libllvm19
Use 'sudo apt autoremove' to remove it.
The following additional packages will be installed:
  git-man liberror-perl
Suggested packages:
  git-daemon-run | git-daemon-sysvinit git-doc git-email git-gui gitk gitweb git-cvs git-mediawiki git-svn
The following NEW packages will be installed:
  git git-man liberror-perl
0 upgraded, 3 newly installed, 0 to remove and 0 not upgraded.
Need to get 4,806 kB of archives.
After this operation, 24.5 MB of additional disk space will be used.
Do you want to continue? [Y/n] y
Get:1 https://pt.archive.ubuntu.com/ubuntu noble/main amd64 liberror-perl all 0.17029-2 [25.6 kB]
Get:2 https://pt.archive.ubuntu.com/ubuntu noble-updates/main amd64 git-man all 1:2.43.0-1ubuntu7.3 [1,100 kB]
Get:3 https://pt.archive.ubuntu.com/ubuntu noble-updates/main amd64 git amd64 1:2.43.0-1ubuntu7.3 [3,680 kB]
Fetched 4,806 kB in 1s (8,171 kB/s)
Selecting previously unselected package liberror-perl.
(Reading database ... 155914 files and directories currently installed.)
Preparing to unpack .../liberror-perl_0.17029-2_all.deb ...
Unpacking liberror-perl (0.17029-2) ...
Selecting previously unselected package git-man.
Preparing to unpack .../git-man_1%3a2.43.0-1ubuntu7.3_all.deb ...
Unpacking git-man (1:2.43.0-1ubuntu7.3) ...
Selecting previously unselected package git.
Preparing to unpack .../git_1%3a2.43.0-1ubuntu7.3_amd64.deb ...
Unpacking git (1:2.43.0-1ubuntu7.3) ...
Setting up liberror-perl (0.17029-2) ...
Setting up git-man (1:2.43.0-1ubuntu7.3) ...
Setting up git (1:2.43.0-1ubuntu7.3) ...
Processing triggers for man-db (2.12.0-4build2) ...
$
$
$ # verificar git instalado
$ git version
git version 2.43.0
$
$ # localização
$ command -v git
/usr/bin/git
```

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

| Comando                         | Descrição                                            |
| ------------------------------- | ---------------------------------------------------- |
| `sdk version`                   | Mostra a versão do SDKMAN instalada                  |
| `sdk list java`                 | Lista as versões de Java disponíveis para instalação |
| `sdk install java 25.0.2-tem`   | Instala a versão 25.0.2 do Temurin (Java)            |
| `sdk use java 21.0.2-tem`       | Usa a versão indicada apenas na sessão atual         |
| `sdk default java 21.0.2-tem`   | Define a versão indicada como padrão                 |
| `sdk current java`              | Mostra a versão de Java ativa                        |
| `sdk uninstall java 25.0.2-tem` | Remove a versão instalada                            |
| `sdk list maven`                | Lista versões do Maven disponíveis                   |
| `sdk install maven 3.9.6`       | Instala o Maven na versão indicada                   |

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



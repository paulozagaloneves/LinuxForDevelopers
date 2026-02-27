# Linux For Developers - Dia 2

## Índice

- [Linux For Developers - Dia 2](#linux-for-developers---dia-2)
  - [Índice](#índice)
  - [Objetivos Dia 2](#objetivos-dia-2)
  - [Exercícios Práticos](#exercícios-práticos)
    - [Preparação](#preparação)
    - [Exercícios](#exercícios)
  - [O Despertar do Terminal](#o-despertar-do-terminal)
    - [Videos](#videos)
    - [Mapa de Sobrevivência: Comandos Essenciais](#mapa-de-sobrevivência-comandos-essenciais)
    - [Mapa de Sobrevivência: Encontre os seus ficheiros](#mapa-de-sobrevivência-encontre-os-seus-ficheiros)
      - [Pesquisa avançada](#pesquisa-avançada)
      - [`tree`](#tree)
      - [`find`](#find)
      - [Extração Inteligente de Texto](#extração-inteligente-de-texto)
      - [`grep`](#grep)
      - [`awk`](#awk)
      - [`sed (Stream Editor)`](#sed-stream-editor)
      - [`tr (Translate)`](#tr-translate)
      - [🚀 Exercício: Análise de Logs](#-exercício-análise-de-logs)
      - [🚀 Exercício: Análise de CSV](#-exercício-análise-de-csv)
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
    - [Vídeos recomendados](#vídeos-recomendados)
    - [Instalação do Zsh e Oh-My-Zsh (Ubuntu 24.04)](#instalação-do-zsh-e-oh-my-zsh-ubuntu-2404)
    - [Exemplo prático:](#exemplo-prático-3)

## Objetivos Dia 2

Ao final deste dia, o participante deverá ser capaz de:

- Utilizar comandos essenciais do terminal Linux para navegação e manipulação de ficheiros e diretórios.
- Compreender a estrutura do sistema de ficheiros Linux (FHS) e identificar diretórios importantes.
- Instalar, atualizar e remover pacotes utilizando o APT.
- Utilizar o sudo para executar comandos com privilégios administrativos.
- Configurar e aceder remotamente ao sistema via SSH, incluindo autenticação sem senha.
- Gerir permissões de utilizador e configurar sudo sem senha para utilizadores específicos.
- Explorar diretórios de configuração e telemetria do sistema (/etc, /proc, /boot).
- Utilizar o histórico do shell para aumentar a produtividade.
- Personalizar o terminal com Zsh e Oh-My-Zsh para maior eficiência e estética.

## Exercícios Práticos

### Preparação

Para a realização dos exercicios pode usar:

1. (Preferencialmente) Linux instalado da aula 1 em computador ou VM.
2. Girus Labs [Girus](https://girus.io/)
3. Usar [KillerCoda - Playground Ubuntu Linux](https://killercoda.com/playgrounds/scenario/ubuntu)
4. Usar [Iximiuz Labs - Ubuntu 24.04](https://labs.iximiuz.com/playgrounds?category=linux)

### Exercícios

## O Despertar do Terminal

Comandos essenciais para começar a usar Linux logo após a instalação (Ubuntu/Debian).

### Videos

- [Getting Started with Linux CLI: Must-Know Commands | Linux Basics](https://www.youtube.com/watch?v=eafVBUh5-pQ)

### Mapa de Sobrevivência: Comandos Essenciais

| Comando   | Descrição                                                                                                                                                                      | Exemplo                      |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ---------------------------- |
| `clear`   | Limpa o ecrã do terminal                                                                                                                                                       | `clear`                      |
| `pwd`     | Mostra a diretoria atual                                                                                                                                                       | `pwd`                        |
| `ls`      | Lista ficheiros e pastas                                                                                                                                                       | `ls -la`                     |
| `cd`      | Muda de diretoria                                                                                                                                                              | `cd /etc`                    |
| `mkdir`   | Cria uma nova pasta                                                                                                                                                            | `mkdir projetos`             |
| `rm`      | Remove ficheiros (ou pastas com `-r`)                                                                                                                                          | `rm ficheiro.txt`            |
| `rmdir`   | Remove pasta vazia                                                                                                                                                             | `rmdir pasta-vazia`          |
| `touch`   | Cria ficheiro vazio ou atualiza data de modificação                                                                                                                            | `touch notas.txt`            |
| `cat`     | Mostra conteúdo de ficheiro                                                                                                                                                    | `cat notas.txt`              |
| `less`    | Visualiza ficheiro página a página (navegação)                                                                                                                                 | `less /var/log/syslog`       |
| `more`    | Visualiza ficheiro página a página (simples)                                                                                                                                   | `more notas.txt`             |
| `tail`    | Mostra linhas finais de ficheiro                                                                                                                                               | `tail -n 20 /var/log/syslog` |
| `head`    | Mostra linhas iniciais de ficheiro                                                                                                                                             | `head -n 20 /var/log/syslog` |
| `mv`      | Move ou renomeia ficheiros/pastas                                                                                                                                              | `mv antigo.txt novo.txt`     |
| `cp`      | Copia ficheiros/pastas                                                                                                                                                         | `cp ficheiro.txt copia.txt`  |
| `sudo`    | Executa comando com privilégios administrativos                                                                                                                                | `sudo apt update`            |
| --- | --- | --- |
| `command` | Comando interno do shell para verificar como um comando será resolvido (builtin, alias, função ou executável). Muito usado com `-v` para mostrar o caminho/comando encontrado. | `command -v python3`         |
| `which`   | Mostra o caminho do executável encontrado no `PATH` (normalmente para comandos externos).                                                                                      | `which python3`              |

Exemplo:

```bash
$ pwd
/home/paulo/workspace/ITSector/LinuxForDevelopers
$
$ ls -la     
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

### Mapa de Sobrevivência: Encontre os seus ficheiros

#### Pesquisa avançada

#### `tree`

- [Libere o poder do comando tree do Linux](https://www.youtube.com/watch?v=b5F8xpHsGn8)


O comando **tree** exibe a estrutura de diretórios e ficheiros em formato de árvore.

- Uso básico:

```bash
$ tree 
.
├── day-1
│   ├── Debian13.Cloud.md
│   ├── README.md
│   └── Ubuntu.Desktop.md
├── day-2
│   └── README.md
├── day-3
│   └── README.md
├── day-4
│   └── README.md
├── day-5
│   └── README.md
├── day-6
│   └── README.md
├── day-7
│   ├── gerador-senhas-java
│   │   ├── pom.xml
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── pt
│   │                   └── exemplo
│   │                       └── senhas
│   │                           └── app
│   │                               └── Application.java
│   └── README.md
├── Estrutura.md
├── general
│   ├── Certbot-LetsEncrypt-Cloudflare.md
│   └── README.md
├── girus
│   └── README.md
├── girus-labs
│   ├── index.yaml
│   ├── labs
│   │   ├── linux_comandos-basicos
│   │   │   └── lab.yaml
│   │   ├── linux_despertar_do_terminal
│   │   │   └── lab.yaml
│   │   └── linux_fhs_navegacao_manipulacao
│   │       └── lab.yaml
│   └── LICENSE
├── images
│   ├── install_ubuntu_desktop_001.png
│   ├── install_ubuntu_desktop_002.png
│   ├── install_ubuntu_desktop_003.png
│   ├── install_ubuntu_desktop_004.png
│   ├── install_ubuntu_desktop_005.png
│   ├── install_ubuntu_desktop_006.png
│   ├── install_ubuntu_desktop_007.png
│   ├── install_ubuntu_desktop_008.png
│   ├── install_ubuntu_desktop_009.png
│   ├── install_ubuntu_desktop_010.png
│   ├── install_ubuntu_desktop_011.png
│   ├── install_ubuntu_desktop_012.png
│   ├── install_ubuntu_desktop_013.png
│   └── Plataforma_Girus_Local.png
├── LICENSE
├── notas.txt
└── README.md

24 directories, 37 files
```

- Mostra a árvore até 2 níveis de profundidade

```bash
$ tree -L 2
.
├── day-1
│   ├── Debian13.Cloud.md
│   ├── README.md
│   └── Ubuntu.Desktop.md
├── day-2
│   └── README.md
├── day-3
│   └── README.md
├── day-4
│   └── README.md
├── day-5
│   └── README.md
├── day-6
│   └── README.md
├── day-7
│   ├── gerador-senhas-java
│   └── README.md
├── Estrutura.md
├── general
│   ├── Certbot-LetsEncrypt-Cloudflare.md
│   └── README.md
├── girus
│   └── README.md
├── girus-labs
│   ├── index.yaml
│   ├── labs
│   └── LICENSE
├── images
│   ├── install_ubuntu_desktop_001.png
│   ├── install_ubuntu_desktop_002.png
│   ├── install_ubuntu_desktop_003.png
│   ├── install_ubuntu_desktop_004.png
│   ├── install_ubuntu_desktop_005.png
│   ├── install_ubuntu_desktop_006.png
│   ├── install_ubuntu_desktop_007.png
│   ├── install_ubuntu_desktop_008.png
│   ├── install_ubuntu_desktop_009.png
│   ├── install_ubuntu_desktop_010.png
│   ├── install_ubuntu_desktop_011.png
│   ├── install_ubuntu_desktop_012.png
│   ├── install_ubuntu_desktop_013.png
│   └── Plataforma_Girus_Local.png
├── LICENSE
├── notas.txt
└── README.md

14 directories, 32 files
```

- Mostra apenas estrutura (diretórios)

```bash
$ tree -d        
.
├── day-1
├── day-2
├── day-3
├── day-4
├── day-5
├── day-6
├── day-7
│   └── gerador-senhas-java
│       └── src
│           └── main
│               └── java
│                   └── pt
│                       └── exemplo
│                           └── senhas
│                               └── app
├── general
├── girus
├── girus-labs
│   └── labs
│       ├── linux_comandos-basicos
│       ├── linux_despertar_do_terminal
│       └── linux_fhs_navegacao_manipulacao
└── images

24 directories
```

#### `find`

- [Curso intensivo de Linux - O comando find](https://www.youtube.com/watch?v=skTiK_6DdqU)
- [Comando find no Linux: buscas eficientes no terminal](https://www.youtube.com/watch?v=Ix4mbqtxoRo)

O comando **find** procurar ficheiros e diretórios de forma flexível, usando critérios como nome, tipo, tamanho, data, etc.


- **Uso básico**: Procura por ficheiros chamados arquivo.txt dentro da pasta especificada.

```bash
$ find /caminho/para/pasta -name "arquivo.txt"
```

- **Uso básico**: Procurar ficheiros com extensão .jpg no diretorio atual e subdiretórios.

```bash
$ find . -type f -name "*.jpg"
```

- **Uso intermediário**: Procura ficheiros maiores que 10MB em /var/log

```bash
$ find /var/log -type f -size +10M
```

-type f : Procura apenas ficheiros
-type d : Procura apenas diretorios

- **Uso intermediário**: Procura por ficheiros modificados nos últimos 7 dias

```bash
$ find . -mtime -7
```


#### Extração Inteligente de Texto

#### `grep`

- [Linux Crash Course - The grep Command](https://www.youtube.com/watch?v=Tc_jntovCM0)
- [Comando grep | Curso Linux para Computação Científica](https://www.youtube.com/watch?v=g-gpH_3GY4Y)
- [Ferramentas incríveis do Linux: ripgrep (rg)](https://www.youtube.com/watch?v=1gywe0ILrvw)

O `grep` é a ferramenta de procura. Ele varre ficheiros ou fluxos de dados à procura de padrões específicos (strings ou expressões regulares) e exibe as linhas correspondentes.

No desenvolvimento pode ser usado para filtrar logs de erro, encontrar onde uma função foi definida ou verificar processos em execução.

**Exemplos Práticos:**

- Procura simples num ficheiro:

```bash
$ grep "NullPointerException" server.log
```

- Procura recursiva (em todos os ficheiros do projeto):

```bash 
$ grep -r "api_key" ./src
```

- Ignorar maiúsculas/minúsculas e mostrar o número da linha:

```bash
$ grep -in "todo" README.md
```

- Filtrar outputs de outros comandos (Pipe):
  
```bash
$ ps aux | grep node (Mostra se o processo Node.js está a correr)
```

#### `awk`

- [Curso Intensivo de Linux - awk](https://www.youtube.com/watch?v=oPEnvuj9QrI)
- [Awk Tutorial - Ultimate Guide](https://www.youtube.com/watch?v=KZ9Oj4XZ8d8)

O `awk` não é apenas um comando, é uma **linguagem de processamento de dados** baseada em colunas. Ele é ideal para extrair informações específicas de ficheiros formatados (como CSVs, logs ou tabelas).

No desenvolvimento pode ser usado para extrair IDs de uma lista, somar valores de uma coluna de logs ou reformatar outputs de comandos.

**Exemplos Práticos:**

- Imprimir apenas a primeira e a terceira coluna (separadas por espaço):

```bash
$ awk '{print $1, $3}' dados.txt
```

- Filtrar por condição (ex: linhas onde a 2ª coluna é maior que 100):

```bash
$ awk '$2 > 100 {print $0}' métricas.log
```

- Alterar o delimitador (ex: processar um ficheiro CSV separado por vírgulas):
Nota: Por defeito o delimitador no awk é o espaço. Com o parâmetro -F pode alterar o delimitador para outro caracter.

```bash
$ awk -F "," '{print $1}' utilizadores.csv
```

- Contar o número de linhas de um ficheiro:

```bash
$ awk 'END {print NR}' ficheiro.txt
```

Ou usando o comando wc (Word Count)

wc -l : conta número de linhas de um ficheiro

Os 3 comandos abaixo contam número de linhas de um ficheiro

```bash
$ wc -l ficheiro.txt
```

```bash
$ cat ficheiro.txt | wc -l
```

```bash
$ wc -l < ficheiro.txt
```

#### `sed (Stream Editor)`

- [Curso intensivo de Linux - O comando sed](https://www.youtube.com/watch?v=nXLnx8ncZyE)
- [sed no Linux: Editando Arquivos Diretamente no Terminal | Aula 19](https://www.youtube.com/watch?v=3-FcXxy9I48)

O `sed` é um **editor de texto não interativo**. Ele permite transformar, substituir ou apagar texto num fluxo de dados de forma automática.

No desenvolvimento pode ser usado para refactoring rápido (mudar nome de variáveis em vários ficheiros), automatizar updates de versões em ficheiros de configuração,limpar dados sujos ou substituição de placeholders.

**Exemplos Práticos:**

- Substituir a primeira ocorrência de "localhost" por "127.0.0.1" numa linha:

```bash
$ sed 's/localhost/127.0.0.1/' config.env
```

- Substituição global (todas as ocorrências) e gravar no ficheiro (In-place):

```bash
$ sed -i 's/v1.0/v2.0/g' package.json
```

- Apagar linhas específicas (ex: apagar a linha 3):

```bash
$ sed '3d' lista.txt
```

- Remover todas as linhas que contêm comentários (começam por #):

```bash
$ sed '/^#/d' setup.sh
```


#### `tr (Translate)`

- [Curso intensivo de Linux - O comando tr](https://www.youtube.com/watch?v=4qP5xA_epXo)
- [Aula 11 – Comando tr | Curso Linux para Computação Científica](https://www.youtube.com/watch?v=34mndfZqcJI)

O comando `tr` lê do standard input (entrada padrão) e traduz, remove repetições (squeeze) ou elimina caracteres, enviando o resultado para o standard output.

**Nota importante**: O tr não aceita um nome de ficheiro como argumento direto (ex: tr a b ficheiro.txt não funciona). Ele precisa de receber os dados através de um pipe (|) ou de um redirecionamento (<).

**Utilidade para Devs:**

- Normalizar dados (converter tudo para minúsculas).

- Limpar ficheiros CSV (trocar vírgulas por tabs).

- Remover quebras de linha ou caracteres invisíveis que causam bugs em scripts.

**Exemplos Práticos:**

- Alterar a caixa do texto (Upper para Lower):

```bash
$ echo "LINUX PARA DEVS" | tr 'A-Z' 'a-z'
```
Útil para comparar strings em scripts de forma case-insensitive.

- Substituir delimitadores (ex: transformar espaços em vírgulas):
```bash
$ cat lista.txt | tr ' ' ','
```

- Eliminar caracteres específicos (Flag -d de delete):
```bash
$ echo "User ID: 12345" | tr -d '0-9'
```
Output: User ID:  (Remove todos os dígitos).

- Remover repetições (Flag -s de squeeze):
```bash
$ echo "Onde      está o   espaço?" | tr -s ' '
```
Output: Onde está o espaço? (Transforma múltiplos espaços seguidos em apenas um).

- Remover quebras de linha (Transformar uma lista numa linha única):

```bash
$ cat lista_ids.txt | tr -d '\n'
```

| Comando | Foco Principal         | Melhor Caso de Uso                              | Exemplo de Operação                                 |
|---------|-----------------------|-------------------------------------------------|-----------------------------------------------------|
| grep    | Linhas / Padrões      | Filtrar e encontrar informação específica        | Encontrar todos os "404" num log                    |
| sed     | Substituição / Edição | Transformar strings ou editar ficheiros em massa | Trocar "localhost" por "127.0.0.1"                  |
| awk     | Colunas / Campos      | Processar dados estruturados e gerar relatórios  | Extrair a 3ª coluna de um CSV                       |
| tr      | Caracteres Individuais| Limpezas rápidas e normalização de texto         | Converter minúsculas em MAIÚSCULAS                  |
| wc      | Contagem              | Validar volume de dados ou resultados            | Contar quantas linhas tem um ficheiro               |



#### 🚀 Exercício: Análise de Logs

**Cenário:** Tens um ficheiro chamado access.log com milhares de linhas. Precisas de gerar um relatório rápido que mostre quantos acessos únicos a API recebeu, mas apenas para pedidos que resultaram em erro 500 (Internal Server Error).

O Ficheiro de Exemplo (access.log):

```txt
192.168.1.1 - [2024-03-01] "GET /api/v1/users" 200
192.168.1.5 - [2024-03-01] "POST /api/v1/save" 500
172.16.0.10 - [2024-03-01] "GET /api/v1/admin" 403
192.168.1.5 - [2024-03-01] "POST /api/v1/save" 500
10.0.0.45   - [2024-03-01] "PUT /api/v1/update" 500
```

**O Desafio: A "linha" Mágica**

O teu objetivo é criar um comando único que:

- Filtre apenas as linhas com erro 500.

- Remova o texto desnecessário (ex: o prefixo /api/v1/).

- Extraia apenas o endpoint (ex: save, update).

- Conte quantas ocorrências de erro existem no total.

**A Solução Passo a Passo:**

- `grep "500"`: Filtra apenas as linhas problemáticas.

- `sed 's/\/api\/v1\///g'`: Limpa o caminho do URL para facilitar a leitura.

- `awk '{print $7}'`: Extrai a 7ª coluna (onde está o endpoint após a limpeza).

- `wc -l`: Dá-te o número final de erros processados.


**Comando Completo:**

```bash
$ grep "500" access.log | sed 's/\/api\/v1\///g' | awk '{print $7}' | wc -l
```


📝 **Questões:**

- **Pergunta 1**: O que acontece se removermos o wc -l do final do comando?

- **Pergunta 2**: Como alterarias o comando para contar apenas os erros vindos de um IP específico (ex: 192.168.1.5)?

- **Pergunta 3**: (Bónus) Se quisesses guardar o resultado num ficheiro chamado relatorio_erros.txt em vez de ver no ecrã, o que adicionarias ao final?


#### 🚀 Exercício: Análise de CSV

📋 **Cenário: Relatório de Vendas Internacional**

**O Problema:**

Recebeste um ficheiro CSV (lista_clientes.csv) extraído de uma base de dados antiga. O ficheiro está "sujo": alguns nomes de países estão em minúsculas, outros em maiúsculas, e tu precisas de saber rapidamente quantos clientes temos em Portugal, extraindo apenas o nome deles para um relatório interno.

**Estrutura do Ficheiro** (`lista_clientes.csv`):

```csv
nome,email,pais
Joana Silva,joana@mail.com,Portugal
John Doe,john@mail.com,USA
CARLOS SERRANO,carlos@mail.com,portugal
Marta Reais,marta@mail.com,PORTUGAL
```


```bash
$ cat lista_clientes.csv | tr 'a-z' 'A-Z' | grep "PORTUGAL" | awk -F',' '{print $1}' | wc -l
```

🛠️ **Decomposição do Pipeline**

1. `cat lista_clientes.csv`
- **O que faz:** Lê o conteúdo do ficheiro e "atira-o" para o pipeline.

- **Estado dos dados:** O texto original, com misturas de maiúsculas e minúsculas.

2. `tr 'a-z' 'A-Z'`
- **O que faz: Normalização**. Converte todos os caracteres do fluxo para Letras Maiúsculas.

- **Porquê?** Para garantir que o grep seguinte não ignore "portugal" ou "Portugal". Assim, tudo passa a ser "PORTUGAL".

3. `grep "PORTUGAL"`
- **O que faz:** Filtragem. Seleciona apenas as linhas que contêm a palavra "PORTUGAL".

- **Resultado:** Remove todos os clientes de outros países (USA, Espanha, etc.).

4. `awk -F',' '{print $1}'`
- **O que faz: Extração**. Define a vírgula (,) como separador de colunas (-F) e imprime apenas a primeira coluna ($1).

- **Resultado:** Ficas apenas com uma lista de nomes (ex: JOANA SILVA, CARLOS SERRANO), descartando o e-mail e o país.

5. `wc -l`
- **O que faz:** Contagem. Conta quantas linhas (clientes) restaram após todos os filtros.

- **Resultado Final**: Um número inteiro (neste exemplo: 3).

> **Dica**: Se o objetivo fosse apenas ver os nomes, pararíamos no `awk`. Como o objetivo é um relatório estatístico, terminamos com o `wc -l`. Esta modularidade é o que torna o CLI do Linux tão flexível para Developers e Data Analysts.


🛠️ **Desafio Prático: Extração de Contactos**
**Enunciado:**

Utilizando o mesmo ficheiro lista_clientes.csv do exemplo anterior, modifica o pipeline para que o sistema:

1. Normalize os dados para maiúsculas.

2. Filtre apenas os clientes de PORTUGAL.

3. Extraia apenas os e-mails (que estão na 2ª coluna).

4. Guarde o resultado final num novo ficheiro chamado emails_marketing.txt em vez de os mostrar no ecrã.


**Solução:**

```bash
$ cat lista_clientes.csv | tr 'a-z' 'A-Z' | grep "PORTUGAL" | awk -F',' '{print $2}' > emails_marketing.txt
```

🌟 Bónus: "Dica de Performance"

Embora o `cat` seja muito usado por iniciantes, o pipeline pode ser encurtado. Em Linux, quase todos estes comandos aceitam o ficheiro como argumento ou via redirecionamento de entrada:

```bash
$ tr 'a-z' 'A-Z' < lista_clientes.csv | grep "PORTUGAL" | awk -F',' '{print $2}' > emails_marketing.txt
```

Isto elimina um processo (`cat`) e torna a execução marginalmente mais rápida em ficheiros massivos.


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

| Comando | Descrição                     | Exemplo   |
| ------- | ----------------------------- | --------- |
| `pwd`   | Mostra a diretoria atual      | `pwd`     |
| `cd`    | Muda de diretoria             | `cd /etc` |
| `cd ~`  | Vai para a home do utilizador | `cd ~`    |
| `cd ..` | Sobe um nível na hierarquia   | `cd ..`   |
| `cd -`  | Volta à diretoria anterior    | `cd -`    |

### Comandos de Listagem

| Comando  | Descrição                                        | Exemplo           |
| -------- | ------------------------------------------------ | ----------------- |
| `ls`     | Lista ficheiros e pastas                         | `ls`              |
| `ls -l`  | Lista detalhada (permissões, datas, etc.)        | `ls -l /etc`      |
| `ls -a`  | Mostra ficheiros ocultos                         | `ls -a`           |
| `ls -lh` | Lista detalhada com tamanhos legíveis            | `ls -lh /var/log` |
| `tree`   | Mostra a estrutura em árvore (requer instalação) | `tree /etc`       |

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

| Comando | Descrição                           | Exemplo                          |
| ------- | ----------------------------------- | -------------------------------- |
| `touch` | Cria ficheiro vazio                 | `touch notas.txt`                |
| `mkdir` | Cria diretoria                      | `mkdir projetos`                 |
| `cp`    | Copia ficheiro                      | `cp notas.txt copia.txt`         |
| `cp -r` | Copia diretoria recursivamente      | `cp -r projetos projetos_backup` |
| `mv`    | Move ou renomeia ficheiro/diretoria | `mv notas.txt notas_antigas.txt` |
| `rm`    | Remove ficheiro                     | `rm copia.txt`                   |
| `rm -r` | Remove diretoria e conteúdo         | `rm -r projetos_backup`          |
| `rmdir` | Remove diretoria vazia              | `rmdir pasta_vazia`              |

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

| Comando    | Descrição                                         | Exemplo                                      |
| ---------- | ------------------------------------------------- | -------------------------------------------- |
| `history`  | Mostra o histórico de comandos                    | `history`                                    |
| `!n`       | Executa o comando número n do histórico           | `!42`                                        |
| `!!`       | Repete o último comando                           | `!!`                                         |
| `!palavra` | Executa o último comando que começa por 'palavra' | `!sudo`                                      |
| `Ctrl+R`   | Pesquisa interativa no histórico                  | (pressione Ctrl+R e digite parte do comando) |

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

- [https://ohmyz.sh/](https://ohmyz.sh/)

### Vídeos recomendados

- [APRENDA COMO INSTALAR E CONFIGURAR O OH MY ZSH E TENHA SUPER PODERES](https://www.youtube.com/watch?v=1-Lm4znOtaQ)

  

### Instalação do Zsh e Oh-My-Zsh (Ubuntu 24.04)

1. **Instalar o Zsh:**

   ``bash
    sudo apt update
    sudo apt install zsh -y
   ``
2. **Definir o Zsh como shell padrão:**

   ``bash
    chsh -s $(which zsh)
    Terá de terminar sessão e voltar a entrar para ativar.
   ``
3. **Instalar o Oh-My-Zsh:**

   ``bash
    sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
    Ou, se preferir usar wget:
    sh -c "$(wget https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh -O -)"
   ``
4. **Mudar de tema (opcional):**

    Edite o ficheiro `~/.zshrc` e altere a linha `ZSH_THEME="robbyrussell"` para outro tema, por exemplo:
    ```bash
    ZSH_THEME="agnoster"
    ```
    Para aplicar as alterações:
    ```bash
    $ source ~/.zshrc
    ```
5. **Adicionar plugins úteis (opcional):**

    No ficheiro `~/.zshrc`, adicione plugins à linha `plugins=(git)` (exemplo: `plugins=(git sudo history)`)
    Recarregue as configurações:
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
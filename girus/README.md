# Linux For Developers - Girus

## Índice

- [Linux For Developers - Girus](#linux-for-developers---girus)
  - [Índice](#índice)
  - [Objetivos](#objetivos)
  - [Docker](#docker)
    - [Docker em Ubuntu ou Debian](#docker-em-ubuntu-ou-debian)
    - [Docker no WSL2 e Ubuntu ou Debian](#docker-no-wsl2-e-ubuntu-ou-debian)
  - [Girus-cli](#girus-cli)
    - [Instalar](#instalar)
    - [Criar a plataforma Girus](#criar-a-plataforma-girus)
    - [Resolucao de problemas](#resolucao-de-problemas)
    - [Aceder a Plataforma Girus](#aceder-a-plataforma-girus)
  - [Adicionar repositorio de Labs](#adicionar-repositorio-de-labs)
    - [Labs Linux4Developers](#labs-linux4developers)
    - [Listar Labs](#listar-labs)
    - [Instalar um lab](#instalar-um-lab)

## Objetivos

## Docker

Docker é uma plataforma que permite criar, distribuir e executar aplicações em containers.
Um container empacota a aplicação com as suas dependências, garantindo que funciona de forma consistente em qualquer ambiente (dev, teste, produção).

- **Leve**: usa o kernel do sistema anfitrião (mais rápido que VM em muitos casos).
- **Portável**: “build once, run anywhere”.
- **Isolado**: cada contentor corre com processos e recursos separados.
- **Prático**: facilita CI/CD, microserviços e ambientes reproduzíveis.

### Docker em Ubuntu ou Debian

- [Install Docker Engine on Ubuntu](https://docs.docker.com/engine/install/ubuntu/)
- [Install Docker Engine on Debian](https://docs.docker.com/engine/install/debian/)

```bash
$ curl -fsSL https://get.docker.com/ | sudo sh
```

**Configurar acesso rootless (Acesso a utilizador não Root)**

```bash
$ sudo sh -eux <<EOF
# Install newuidmap & newgidmap binaries
apt-get install -y uidmap
EOF
```

```bash
$ dockerd-rootless-setuptool.sh install
```

**Validar instalação Docker**

```bash
$ docker container run hello-world
Unable to find image 'hello-world:latest' locally
latest: Pulling from library/hello-world
17eec7bbc9d7: Pull complete 
ea52d2000f90: Download complete 
Digest: sha256:ef54e839ef541993b4e87f25e752f7cf4238fa55f017957c2eb44077083d7a6a
Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/

$
$ docker container list
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
$ 
```

### Docker no WSL2 e Ubuntu ou Debian

- [Setting Up Docker on WSL2 with Ubuntu 24.04: An Easy Guide](https://dev.to/0xkoji/setting-up-docker-on-wsl2-with-ubuntu-2404-an-easy-guide-59cd)
- [Containers Land: Docker setup on WSL2](https://blog.bartekr.net/2025/05/01/containers-land-docker-setup-on-wsl2/)

```bash
$ curl -fsSL https://get.docker.com/ | sudo sh
```

**Configurar acesso rootless (Acesso a utilizador não Root)**

```bash
$ sudo sh -eux <<EOF
# Install newuidmap & newgidmap binaries
apt-get install -y uidmap
EOF
```

```bash
$ dockerd-rootless-setuptool.sh install
```

**Validar instalação Docker**

```bash
$ docker container run hello-world
Unable to find image 'hello-world:latest' locally
latest: Pulling from library/hello-world
17eec7bbc9d7: Pull complete 
ea52d2000f90: Download complete 
Digest: sha256:ef54e839ef541993b4e87f25e752f7cf4238fa55f017957c2eb44077083d7a6a
Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/

$
$ docker container list
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
$ 
```

## Girus-cli

A [Plataforma Girus](https://girus.io/) é uma solução open source da [LINUXtips](https://linuxtips.io) para aprendizagem prática de DevOps e SRE através de laboratórios interativos executados localmente. Em vez de depender de ambientes remotos, o Girus roda na própria máquina do utilizador com Docker e Kubernetes, oferecendo cenários isolados, seguros e sem conflitos com o sistema anfitrião. A experiência combina terminal interativo, tarefas guiadas, dicas contextuais e validação automática de progresso, acelerando o aprendizado hands-on em tecnologias como Linux, Docker, Kubernetes, Terraform e AWS. Com instalação simples via CLI e catálogo de dezenas de labs, o Girus reduz barreiras técnicas e financeiras para quem quer praticar competências reais de cloud e infraestrutura.

### Instalar

```bash
$ curl -sSL girus.linuxtips.io | bash
```

### Criar a plataforma Girus

```bash
$ girus create cluster

────────────────────────────────────────────────────────────────────────────────
GIRUS CREATE
────────────────────────────────────────────────────────────────────────────────
Verificando atualizações...

Verificando pré-requisitos...
ATIVO docker detectado e funcionando

Criando cluster Girus...
Criando cluster... 100% |█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████| (100/100) 
SUCESSO: Cluster Girus criado com sucesso!

Implantando o Girus no cluster...
Implantando infraestrutura... 100% |██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████| (100/100) 
SUCESSO: Infraestrutura básica aplicada com sucesso!

Aplicando templates de laboratório...
Aplicando templates de laboratório... 100% |████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████| (27/27) 
SUCESSO: Todos os templates de laboratório aplicados com sucesso!

Verificando templates de laboratório instalados:
   Templates encontrados:
   ATIVO aws-dynamodb-nosql-lab
   ATIVO aws-lambda-serverless-lab
   ATIVO aws-localstack-terraform-lab
   ATIVO aws-s3-storage-lab
   ATIVO docker-compose-lab
   ATIVO docker-fundamentos-lab
   ATIVO docker-fundamentos-redes-lab
   ATIVO docker-gerenciamento-containers-lab
   ATIVO docker-volumes-lab
   ATIVO kubernetes-configmaps-secrets-lab
   ATIVO kubernetes-cronjobs-lab
   ATIVO kubernetes-deployment-lab
   ATIVO kubernetes-deployments-lab
   ATIVO kubernetes-exploracao-recursos-lab
   ATIVO kubernetes-fundamentos-lab
   ATIVO kubernetes-servicos-redes-lab
   ATIVO linux-comandos-basicos-lab
   ATIVO linux-gerenciamento-processos-lab
   ATIVO linux-gerenciamento-usuarios-lab
   ATIVO linux-monitoramento-sistema-lab
   ATIVO linux-permissoes-arquivos-lab
   ATIVO linux-processamento-texto-lab
   ATIVO linux-shell-script-lab
   ATIVO terraform-aws-infraestrutura-lab
   ATIVO terraform-fundamentos-lab
   ATIVO terraform-provisioners-modulos-lab

Reiniciando o backend para carregar os templates...
   Aguardando o reinício do backend completar...
   SUCESSO: Backend reiniciado com sucesso!            
   Aguardando inicialização completa...

Aguardando os pods do Girus inicializarem...
Inicializando Girus... 100% |██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████|  
SUCESSO: Backend: Pronto
SUCESSO: Frontend: Pronto
SUCESSO: Aplicação: Respondendo
SUCESSO: Todos os componentes do Girus estão prontos e em execução!
SUCESSO: Girus implantado com sucesso no cluster!

Configurando acesso aos serviços do Girus...    Limpando port-forwards existentes...
   Configurando port-forward para o backend (8080)...
   Verificando conectividade do backend...
   Tentativa 1 falhou, aguardando...
   SUCESSO: Backend conectado com sucesso!
   Configurando port-forward para o frontend (8000)...
   Verificando conectividade do frontend...
   Tentativa 1 falhou, aguardando...
   Tentativa 2 falhou, aguardando...
   Tentativa 3 falhou, aguardando...
   Tentativa 4 falhou, aguardando...
   Tentativa 5 falhou, aguardando...
   Tentativa 6 falhou, aguardando...
   Tentativa 7 falhou, aguardando...
   Tentativa 8 falhou, aguardando...
   Tentativa 9 falhou, aguardando...
   Tentativa 10 falhou, aguardando...
   Tentativa 11 falhou, aguardando...
   Tentativa 12 falhou, aguardando...
   Tentativa 13 falhou, aguardando...
   Tentativa 14 falhou, aguardando...
   Tentativa 15 falhou, aguardando...
AVISO:
AVISO: Não foi possível configurar o acesso automático: não foi possível conectar ao frontend após várias tentativas

Você pode tentar configurar manualmente com os comandos:
kubectl port-forward -n girus svc/girus-backend 8080:8080 --address 0.0.0.0
kubectl port-forward -n girus svc/girus-frontend 8000:80 --address 0.0.0.0

────────────────────────────────────────────────────────────
GIRUS PRONTO PARA USO!
────────────────────────────────────────────────────────────
PRÓXIMOS PASSOS:
  • Acesse o Girus no navegador:
    http://localhost:8000

  • Para aplicar mais templates de laboratórios com o Girus:
    girus create lab -f caminho/para/lab.yaml

  • Para ver todos os laboratórios disponíveis:
    girus list labs
────────────────────────────────────────────────────────────
```

### Resolucao de problemas

```bash
Configurando acesso aos serviços do Girus...    Limpando port-forwards existentes...
   Configurando port-forward para o backend (8080)...
   Verificando conectividade do backend...
   Tentativa 1 falhou, aguardando...
   SUCESSO: Backend conectado com sucesso!
   Configurando port-forward para o frontend (8000)...
   Verificando conectividade do frontend...
   Tentativa 1 falhou, aguardando...
   Tentativa 2 falhou, aguardando...
   Tentativa 3 falhou, aguardando...
   Tentativa 4 falhou, aguardando...
   Tentativa 5 falhou, aguardando...
   Tentativa 6 falhou, aguardando...
   Tentativa 7 falhou, aguardando...
   Tentativa 8 falhou, aguardando...
   Tentativa 9 falhou, aguardando...
   Tentativa 10 falhou, aguardando...
   Tentativa 11 falhou, aguardando...
   Tentativa 12 falhou, aguardando...
   Tentativa 13 falhou, aguardando...
   Tentativa 14 falhou, aguardando...
   Tentativa 15 falhou, aguardando...
AVISO:
AVISO: Não foi possível configurar o acesso automático: não foi possível conectar ao frontend após várias tentativas

Você pode tentar configurar manualmente com os comandos:
kubectl port-forward -n girus svc/girus-backend 8080:8080 --address 0.0.0.0
kubectl port-forward -n girus svc/girus-frontend 8000:80 --address 0.0.0.0
```

**Se apresentar o erro acima, deve executar:**

```bash
$ kubectl port-forward -n girus svc/girus-frontend 8000:80 --address 0.0.0.0&
```

### Aceder a Plataforma Girus

Agora vai poder aceder à Plataforma Girus.

[Plataforma Girus Local](http://localhost:8000)

![Plataforma Girus](/images/Plataforma_Girus_Local.png)

## Adicionar repositorio de Labs

### Labs Linux4Developers

```bash
$ girus repo add  linux-for-developers https://raw.githubusercontent.com/paulozagaloneves/LinuxForDevelopers/refs/heads/main/girus-labs --description "Repositório de labs co curso Linux For Developers"
Repositório 'linux-for-developers' adicionado com sucesso.
```

### Listar Labs

```bash
$ girus lab list
Verificando cache em: /home/paulo/.girus/cache/girus-labs/index.yaml
Usando índice do cache
Verificando cache em: /home/paulo/.girus/cache/linux-for-developers/index.yaml
Usando índice do cache
LABORATÓRIOS DISPONÍVEIS
────────────────────────────────────────────────────────────────────────────────
NOME                              VERSÃO   REPOSITÓRIO   DESCRIÇÃO
linux-processamento-texto         1.0.0             girus-labs             Domine as ferramentas essenciais de manipulação de texto no Linux - grep, sed, awk
linux-gerenciamento-processos     1.0.0             girus-labs             Aprenda a monitorar, controlar e gerenciar processos no sistema Linux
linux-shell-script                1.0.0             girus-labs             Aprenda a criar scripts de shell para automatizar tarefas no Linux
linux-monitoramento-sistema       1.0.0             girus-labs             Aprenda a usar ferramentas como vmstat, iostat, free e o /proc para monitorar recursos do sistema
linux-comandos-basicos            1.0.0             girus-labs             Domine os comandos básicos e conceitos fundamentais do Linux
linux-gerenciamento-usuarios      1.0.0             girus-labs             Aprenda a gerenciar usuários, grupos e permissões no Linux
linux-permissoes-arquivos         1.0.0             girus-labs             Entenda o sistema de permissões de arquivos e diretórios no Linux
docker-fundamentos                1.1.0             girus-labs             Introdução ao Docker, criação de imagens e gerenciamento de containers
docker-gerenciamento-containers   1.0.0             girus-labs             Aprenda técnicas avançadas para gerenciar containers Docker
docker-fundamentos-redes          1.0.0             girus-labs             Entenda e configure redes no ecossistema Docker
docker-volumes                    1.0.0             girus-labs             Aprenda a persistir dados com volumes no Docker
docker-compose                    1.0.0             girus-labs             Aprenda a definir e executar aplicações multi-container Docker de forma declarativa
kubernetes-exploracao-recursos    1.0.0             girus-labs             Conheça os principais recursos disponíveis no Kubernetes
kubernetes-servicos-redes         1.0.0             girus-labs             Configure serviços e redes para suas aplicações no Kubernetes
kubernetes-configmaps-secrets     1.0.0             girus-labs             Gerencie configurações e dados sensíveis no Kubernetes
kubernetes-cronjobs               1.0.0             girus-labs             Configure tarefas agendadas no Kubernetes com CronJobs
kubernetes-deployments            1.0.2             girus-labs             Aprenda a criar e gerenciar deployments no Kubernetes
kubernetes-fundamentos            1.0.0             girus-labs             Aprenda os conceitos básicos do Kubernetes e sua arquitetura
kubernetes-deployment             1.0.0             girus-labs             Aprenda técnicas avançadas de deployments no Kubernetes
aws-localstack-terraform          1.0.0             girus-labs             Aprenda a usar AWS LocalStack para desenvolvimento local com Terraform
aws-s3-storage                    2.0.0             girus-labs             Como utilizar o serviço S3 da AWS para armazenamento de objetos
aws-dynamodb-nosql                1.0.0             girus-labs             Aprenda a utilizar o DynamoDB da AWS para armazenamento NoSQL
aws-lambda-serverless             1.0.0             girus-labs             Explore a computação serverless com AWS Lambda
terraform-fundamentos             1.0.0             girus-labs             Aprenda os princípios fundamentais do Terraform
terraform-aws-infraestrutura      1.0.0             girus-labs             Crie e gerencie infraestrutura AWS com Terraform
terraform-provisioners-modulos    1.0.0             girus-labs             Aprenda a utilizar provisioners e módulos no Terraform
linux-comandos-basicos            1.0.0             linux-for-developers   Domine os comandos básicos e conceitos fundamentais do Linux
```

### Instalar um lab


```bash
$ girus lab install linux-for-developers linux-comandos-essenciais
```
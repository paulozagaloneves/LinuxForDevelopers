# Linux For Developers

## Table of Contents

- [Introdução ao Linux](#introdução-ao-linux)
  - [História e evolução do Linux](#história-e-evolução-do-linux)
  - [Distribuições Populares (Ubuntu, Fedora, Debian, Redhat, Arch)](#distribuições-populares-ubuntu-fedora-debian-redhat-arch)
  - [Filosofia Open Source](#filosofia-open-source)
- [Instalação e Configuração](#instalação-e-configuração)

## **Introdução ao Linux**

### História e evolução do Linux

O Linux nasceu em 1991 quando Linus Torvalds, então estudante de ciência da computação na Universidade de Helsínquia, Finlândia, começou a desenvolver um kernel de sistema operativo como hobby. Inspirado no MINIX (um sistema Unix-like educacional), Linus queria criar um sistema operativo livre e aberto que pudesse executar em computadores pessoais com processadores Intel 386.

A primeira versão (0.01) foi lançada em Setembro de 1991, contendo apenas cerca de 10.000 linhas de código. O que começou como um projecto pessoal rapidamente ganhou colaboradores em todo o mundo através da Internet. Em 1992, Linus decidiu licenciar o Linux sob a GPL (General Public License), tornando-o verdadeiramente livre e open source.

Ao longo das décadas, o Linux evoluiu de um kernel experimental para a fundação de milhares de milhões de dispositivos. Nos anos 90, surgiram as primeiras distribuições como Slackware, Debian e Red Hat, tornando o Linux mais acessível. Os anos 2000 viram a explosão do Linux em servidores web e a criação do Android, que leva o kernel Linux para smartphones. Hoje, o Linux domina servidores (mais de 90% do top 1 milhão de sítios), supercomputadores (100% do Top500), dispositivos embarcados, e é fundamental para cloud computing e contentores.

O kernel Linux actual possui mais de 30 milhões de linhas de código e conta com milhares de programadores a contribuir de empresas como Google, Intel, Red Hat, Samsung e muitas outras. É um dos maiores e mais bem-sucedidos projectos de código aberto da história.

### Distribuições Populares (Ubuntu, Fedora, Debian, Redhat, Arch)

Uma **distribuição Linux** (ou "distro") é um sistema operativo completo construído sobre o kernel Linux. Enquanto o kernel é apenas o núcleo do sistema, uma distribuição empacota o kernel juntamente com ferramentas do sistema, gestores de pacotes, ambientes gráficos, aplicações e configurações pré-definidas, formando um sistema operativo utilizável.

Cada distribuição tem a sua própria filosofia, público-alvo e método de gestão. As principais diferenças estão no sistema de pacotes, frequência de actualizações, estabilidade vs. software mais recente, e facilidade de uso.

**Principais distribuições:**

- **[Ubuntu](https://ubuntu.com/)**: Baseada no Debian, é a distribuição mais popular para desktops e iniciantes. Focada em facilidade de uso, possui ciclos de lançamento regulares a cada 6 meses e versões LTS (Long Term Support) com 5 anos de suporte. Ideal para programadores e uso geral. Usa gestor de pacotes APT (.deb).

  **Distribuições derivadas do Ubuntu:**
  
  - **[Zorin OS](https://zorin.com/)**: Distribuição desenhada especificamente para utilizadores que migram do Windows. Apresenta um ambiente de trabalho visualmente semelhante ao Windows, facilitando a transição. Inclui várias disposições de desktop (Layouts) que imitam Windows, macOS e até ChromeOS. Vem com Wine pré-instalado para executar algumas aplicações Windows. Existe em versões Core (gratuita), Lite (para hardware mais antigo) e Pro (paga, com software adicional e layouts premium). Ideal para iniciantes e para ambientes empresariais que procuram substituir o Windows.
  
  - **[Pop!_OS](https://pop.system76.com/)**: Desenvolvida pela System76 (fabricante de computadores Linux), é optimizada para programadores, criadores de conteúdo e utilizadores de ciência de dados. Destaca-se pelo excelente suporte para placas gráficas NVIDIA (drivers incluídos por defeito) e pela funcionalidade de organização automática de janelas (Auto-tiling). Inclui ferramentas de recuperação integradas e um instalador que facilita a encriptação completa do disco. Popular entre gamers e utilizadores que trabalham com machine learning, edição de vídeo e desenvolvimento de software.

- **[Debian](https://www.debian.org/)**: Uma das distribuições mais antigas e respeitadas, conhecida pela sua estabilidade e compromisso com software livre. É a base para muitas outras distros, incluindo Ubuntu. Possui três ramos: Stable (muito estável), Testing e Unstable. Preferida para servidores e utilizadores que valorizam estabilidade. Usa APT (.deb).

- **[Fedora](https://fedoraproject.org/)**: Patrocinada pela Red Hat, é uma distribuição com atualizações frequentes que serve como campo de testes para tecnologias que eventualmente chegam ao Red Hat Enterprise Linux (RHEL). Sempre com software actualizado e inovador. Popular entre programadores e entusiastas. Usa gestor DNF (.rpm).

- **[Red Hat (RHEL)](https://www.redhat.com/en/technologies/linux-platforms/enterprise-linux)**: Red Hat Enterprise Linux é uma distribuição comercial focada em ambientes corporativos e servidores empresariais. Oferece suporte pago, certificações e grande estabilidade. É a base para CentOS (descontinuado) e Rocky Linux/AlmaLinux. Usa DNF (.rpm).

- **[Arch Linux](https://archlinux.org/)**: Distribuição rolling release (actualização contínua) minimalista e altamente personalizável. Segue a filosofia KISS (Keep It Simple, Stupid) e é voltada para utilizadores avançados que querem controlo total sobre o seu sistema. Conhecida pela sua documentação excelente (Arch Wiki) e gestor de pacotes Pacman. Requer instalação manual e configuração detalhada.

### Filosofia Open Source

A **filosofia Open Source** (código aberto) é o fundamento sobre o qual o Linux e milhares de projectos de software são construídos. Esta filosofia defende que o código-fonte do software deve estar disponível publicamente para qualquer pessoa visualizar, modificar e distribuir. Mais do que apenas uma metodologia de desenvolvimento, representa um movimento cultural e ético que promove a colaboração, transparência e liberdade tecnológica.

**Princípios fundamentais:**

1. **Liberdade de utilização**: Qualquer pessoa pode executar o software para qualquer propósito, sem restrições.

2. **Acesso ao código-fonte**: O código está disponível para leitura e estudo, permitindo compreender como o software funciona internamente.

3. **Liberdade de modificação**: Utilizadores podem adaptar o software às suas necessidades específicas, corrigir falhas ou adicionar funcionalidades.

4. **Liberdade de redistribuição**: As melhorias podem ser partilhadas com a comunidade, beneficiando todos os utilizadores.

**Benefícios do Open Source:**

- **Segurança e transparência**: Com milhares de olhos a rever o código, vulnerabilidades são identificadas e corrigidas rapidamente. Não há "portas traseiras" ocultas.

- **Inovação colaborativa**: Programadores de todo o mundo contribuem, acelerando o desenvolvimento e a inovação. Projectos como o kernel Linux recebem contribuições de milhares de programadores.

- **Independência tecnológica**: Organizações não ficam dependentes de fornecedores específicos (vendor lock-in) e podem adaptar o software às suas necessidades.

- **Redução de custos**: Elimina licenças caras e permite reutilização de código entre projectos.

- **Qualidade superior**: A revisão colaborativa constante tende a produzir software mais robusto e bem testado.

- **Educação e aprendizagem**: Estudantes e programadores podem aprender com código real de projectos de qualidade mundial.

**Licenças Open Source:**

Diferentes licenças definem como o software pode ser utilizado e redistribuído:

- **GPL (General Public License)**: Utilizada pelo kernel Linux. Garante que derivados também sejam open source (copyleft).
- **MIT/BSD**: Licenças permissivas que permitem uso em software proprietário.
- **Apache 2.0**: Popular em projectos empresariais, oferece protecção de patentes.

O Linux é o exemplo máximo do sucesso do Open Source: começou como projecto de um estudante e tornou-se a base da infraestrutura tecnológica mundial, demonstrando que a colaboração aberta pode superar modelos proprietários tradicionais.

## **Instalação e Configuração**
  - Instalação de distribuições

  - Configurações iniciais do sistema
  
  - Dual boot e máquinas virtuais
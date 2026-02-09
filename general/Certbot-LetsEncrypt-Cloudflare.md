# Certbot com Let's Encrypt - Challenge DNS-01 e Cloudflare

## Pré-requisitos

- Servidor Linux (Ubuntu/Debian)
- Domínio configurado no Cloudflare
- Token de API do Cloudflare


## Referências

- [certbot-dns-cloudflare](https://certbot-dns-cloudflare.readthedocs.io/en/stable/)

## Passo 1: Instalar Certbot

```bash
sudo apt update
sudo apt install certbot python3-certbot-dns-cloudflare -y
```

## Passo 2: Obter Token da API Cloudflare

1. Acesse https://dash.cloudflare.com/profile/api-tokens
2. Clique em "Create Token"
3. Use o template "Edit zone DNS"
4. Selecione as zonas/domínios desejados
5. Copie o token gerado

## Passo 3: Configurar Credenciais Cloudflare

Crie o arquivo de credenciais:

```bash
sudo mkdir -p /etc/letsencrypt
sudo nano /etc/letsencrypt/cloudflare.ini
```

Adicione o conteúdo:

```ini
dns_cloudflare_api_token = YOUR_CLOUDFLARE_API_TOKEN
```

Proteja o arquivo:

```bash
sudo chmod 600 /etc/letsencrypt/cloudflare.ini
```

## Passo 4: Gerar Certificado

```bash
sudo certbot certonly \
    --dns-cloudflare \
    --dns-cloudflare-credentials /etc/letsencrypt/cloudflare.ini \
    -d exemplo.com \
    -d *.exemplo.com
```

## Passo 5: Renovação Automática

Teste a renovação:

```bash
sudo certbot renew --dry-run
```

O certbot cria automaticamente um cronjob para renovação.

## Localização dos Certificados

- Certificado: `/etc/letsencrypt/live/exemplo.com/fullchain.pem`
- Chave Privada: `/etc/letsencrypt/live/exemplo.com/privkey.pem`

## Passo 5: Configurar Pré e Post Hooks

### Pré Hook

```bash
vim /etc/letsencrypt/renewal-hooks/pre/harbor.sh
```

```
#!/bin/bash
/usr/bin/docker stop nginx
```

```bash
$ chmod 755 /etc/letsencrypt/renewal-hooks/pre/harbor.sh
```

### Post Hook

```bash
$ vim /etc/letsencrypt/renewal-hooks/post/harbor.sh
``` 

```
#!/bin/bash
/usr/bin/docker stop nginx

root@harbor:~/harbor# cat /etc/letsencrypt/renewal-hooks/post/harbor.sh
#!/bin/bash
cp -f /etc/letsencrypt/live/kode.expert/fullchain.pem /data/secret/cert/server.crt
cp -f /etc/letsencrypt/live/kode.expert/privkey.pem /data/secret/cert/server.key
/usr/bin/docker start nginx
```

```bash
$ chmod 755 /etc/letsencrypt/renewal-hooks/post/harbor.sh
```

# hubspot-integration
# Integração com HubSpot via OAuth 2.0

Este projeto realiza a autenticação via OAuth com a API do HubSpot e permite realizar operações de leitura e criação de contatos após a autenticação.

---

## 🔐 Fluxo OAuth com HubSpot

### 1. Obter Código de Autorização (Authorization Code)

Acesse o link abaixo no navegador:
https://app.hubspot.com/oauth/authorize?client_id=xxxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx&scope=oauth&redirect_uri=http://localhost:8080/authentication/callback&optional_scope=crm.schemas.contacts.read crm.schemas.contacts.write crm.objects.contacts.write crm.objects.contacts.read

> 🔁 Substitua 'xxxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx' pelo seu 'client_id'.

![image](https://github.com/user-attachments/assets/5761d6b0-9373-4a84-b681-3c18d46787b7)

O HubSpot redirecionará para o 'redirect_uri' com um parâmetro 'code' na URL, como:
http://localhost:8080/authentication/callback?code=xxx-xxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx

### 2. Trocar o código por um token de acesso

Envie uma requisição **POST** para o endpoint:
https://api.hubapi.com/oauth/v1/token


Com os seguintes parâmetros (form-urlencoded):

| Parâmetro       | Valor                                                                 |
|----------------|------------------------------------------------------------------------|
| `grant_type`    | `authorization_code`                                                  |
| `client_id`     | Seu client ID                                                         |
| `client_secret` | Seu client secret                                                     |
| `redirect_uri`  | `http://localhost:8080/authentication/callback`                       |
| `code`          | O código recebido na etapa anterior (`na1-...`)                       |

Exemplo de chamada com todos os parâmetros:


https://api.hubapi.com/oauth/v1/token/?grant_type=authorization_code&client_id=xxxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx&client_secret=xxxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx&redirect_uri=http://localhost:8080/authentication/callback&code=xxxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx

---

## 🔧 Endpoints da Aplicação Local

### 📬 Criar um contato

    POST http://localhost:8080/contacts

    Content-Type: application/json

    Authorization: Bearer {access_token}

    Exemplo de body:

    {
      "firstname": "Cassiano",
      "lastname": "L",
      "email": "cassiano@email.com"
    }

📄 Listar contatos:

    GET http://localhost:8080/contacts
    
    Authorization: Bearer {access_token}

✅ Requisitos:

    -Java 17+;

    -Spring Boot;

    -Conta HubSpot com app registrado;

    -Dependências: Feign (para o client HTTP), Spring Web, Lombok;

📎 Observações:

    -O access_token tem validade de 30 minutos (expires_in: 1800);

    -Utilize o refresh_token (salvo na resposta da troca do code) para obter um novo access_token futuramente;

    -Os escopos opcionais usados são:

        -crm.objects.contacts.read
  
        -crm.objects.contacts.write
  
        -crm.schemas.contacts.read
  
        -crm.schemas.contacts.write

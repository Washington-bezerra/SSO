# OAuth2 Login Example

Este projeto demonstra como implementar login com OAuth2 usando Google e GitHub em uma aplicação Spring Boot com Kotlin.

## Pré-requisitos

Para que o projeto funcione corretamente, você precisa fornecer as seguintes variáveis de ambiente:

- `GOOGLE_CLIENT_ID`
- `GOOGLE_CLIENT_SECRET`
- `GITHUB_CLIENT_ID`
- `GITHUB_CLIENT_SECRET`

## Configuração

### Google OAuth2

1. Acesse o Google Cloud Console.
2. Crie um novo projeto ou selecione um projeto existente.
3. Navegue até **APIs & Services** > **Credentials**.
4. Clique em **Create Credentials** e selecione **OAuth 2.0 Client IDs**.
5. Configure a tela de consentimento OAuth, fornecendo as informações necessárias.
6. Adicione um **Authorized Redirect URI**: `http://localhost:8080/login/oauth2/code/google`.
7. Após criar as credenciais, você receberá um `client_id` e um `client_secret`.

### GitHub OAuth2

1. Acesse GitHub Developer Settings.
2. Clique em **New OAuth App**.
3. Preencha os campos necessários:
   - **Application name**: Nome da sua aplicação.
   - **Homepage URL**: `http://localhost:8080`.
   - **Authorization callback URL**: `http://localhost:8080/login/oauth2/code/github`.
4. Após criar a aplicação, você receberá um `client_id` e um `client_secret`.

## Configuração das Variáveis de Ambiente

Você pode configurar as variáveis de ambiente no seu sistema pelo proprio Intellij ou em um arquivo `.env` na raiz do projeto.

### Exemplo de `.env`:

```env
GOOGLE_CLIENT_ID=your-google-client-id
GOOGLE_CLIENT_SECRET=your-google-client-secret
GITHUB_CLIENT_ID=your-github-client-id
GITHUB_CLIENT_SECRET=your-github-client-secret
```
### Como testar?
Bastar rodar a aplicação, acessar a `localhost:8080/secured` no navegador, escolher o Github ou Google.

Se tudo der certo, vc verá algo assim:

![image](https://github.com/user-attachments/assets/bc7ee8c0-da75-436b-bef1-804b1c25098b)

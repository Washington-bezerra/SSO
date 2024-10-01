package com.teste.oauth2

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.ui.Model

@RestController
class MainController {

    @GetMapping("/")
    fun home(): String {
        return "Hello, home!"
    }

    @GetMapping("/secured")
    fun secured(@AuthenticationPrincipal principal: OAuth2User?): String {

        principal?.attributes?.forEach { (key, value) ->
            println("$key: $value")
        }

        val picture = principal?.attributes?.get("picture") ?: principal?.attributes?.get("avatar_url")
        val name = principal?.attributes?.get("name") ?: "Usuário"
        val email = principal?.attributes?.get("email") ?: principal?.attributes?.get("html_url")

        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Perfil do Usuário</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        margin: 20px;
                    }
                    .profile {
                        border: 1px solid #ccc;
                        padding: 20px;
                        max-width: 400px;
                        margin: auto;
                        text-align: center;
                    }
                    .profile img {
                        border-radius: 50%;
                        width: 100px;
                        height: 100px;
                    }
                    .profile h2 {
                        margin: 10px 0;
                    }
                    .profile p {
                        color: #666;
                    }
                </style>
            </head>
            <body>
                <div class="profile">
                    <img src="$picture" alt="Foto do Usuário">
                    <h2>$name</h2>
                    <p>Email ou perfil GitHub: $email</p>
                </div>
            </body>
            </html>
        """.trimIndent()
    }
}

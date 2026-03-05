fun main() {
    val listaDeRegras = listOf(
        Requisito("Mínimo de 5 caracteres") { it.length >= 5 },
        Requisito("Deve conter o ano do Hexa (2026)") { it.contains("2026") }
    )
    var senhaAprovada = false

    do {
        println("\nDigite sua senha:")
        val entrada = readLine() ?: "" // Null Safety com operador Elvis
        var erroEncontrado: String? = null
        for (regra in listaDeRegras) {
            if (!regra.validacao(entrada)) {
                erroEncontrado = regra.mensagemErro
                break
            }
        }
        if (erroEncontrado != null) {
            println("❌ ERRO: $erroEncontrado")
        } else {
            println("✅ SUCESSO! Senha aceite pelo Overlord.")
            senhaAprovada = true
        }
    } while (!senhaAprovada)
}

class Requisito(val string: String, val function: () -> Boolean)
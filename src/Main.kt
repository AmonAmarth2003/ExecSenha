fun main() {
    fun containsEmoji(text: String): Boolean {
        return text.codePoints().anyMatch { codePoint ->
            Character.getType(codePoint).toByte() == Character.OTHER_SYMBOL
        }
    }

    fun sumNumbersInString(text: String): Int {
        var digits = ""
        var sum = 0

        for (char in text) {
            if (char.isDigit()) {
                digits += char
                continue
            }

            if (digits.isNotEmpty() && digits != "-") {
                sum += digits.toInt()
            }

            digits = if (char == '-') "-" else ""
        }

        if (digits.isNotEmpty() && digits != "-") {
            sum += digits.toInt()
        }

        return sum
    }

    fun hasCapitalLetter(text: String): Boolean {
        for (char in text) {
            if (char.isUpperCase()) {
                return true
            }
        }
        return false
    }

    val listaDeRegras = listOf(
        Requisito("Mínimo de 5 caracteres") { it.length >= 5 },
        Requisito("Deve conter o ano do Hexa (2026)") { it.contains("2026") },
        Requisito("Deve conter pelo menos uma letra maiúscula e um número") { it.contains("[0-9]".toRegex()) or hasCapitalLetter(it) },
        Requisito("Deve conter a palavra 'shell' (sem distinguir maiúsculas/minúsculas).") { it.lowercase().contains("shell") },
        Requisito("Deve conter pelo menos um Emoji (ex: ❄).") { containsEmoji(it) },
        Requisito("Os valores somandos devem ser menores que 2026.") { sumNumbersInString(it) != 2026 }
    )

    var senhaAprovada = false
    do {
        println("\nDigite sua senha:")
        val entrada = readLine() ?: ""

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
            println("✅ SUCESSO! Senha aceita pelo Overlord.")
            senhaAprovada = true
        }

    } while (!senhaAprovada)

}

class Requisito(
    val mensagemErro: String,
    val validacao: (String) -> Boolean
)

import org.junit.Test
import org.junit.Assert.assertEquals

class SumNumbersInStringTest {

    @Test
    fun withEmotes() {
        assertSum("10😊-30", -20)
    }

    @Test
    fun jumpNegative() {
        assertSum("10-a10", 20)
    }

    @Test
    fun nothingIn() {
        assertSum("", 0)
    }

    @Test
    fun onlySpace() {
        assertSum(" ", 0)
    }

    @Test
    fun lastDigitCounting() {
        assertSum("200a10", 210)
    }

    @Test
    fun negativeAddition() {
        assertSum("100-10a", 90)
    }

    @Test
    fun sumWithDoubleHyphen() {
        assertSum("200--20+10", 190)
    }

    @Test
    fun withSpaces() {
        assertSum("10 10 -30", -10)
    }

    private fun assertSum(text: String, expected: Int) {
        assertEquals(expected, sumNumbersInString(text))
    }

    fun sumNumbersInString(text : String): Int{
        var digits : String = ""
        var sum : Int = 0

        var isNegativeSign : Boolean = false

        for(char in text){
            if(!char.isDigit() and digits.isNotEmpty()){
                if(digits.toIntOrNull() != null){
                    sum += digits.toInt()
                }
                digits = ""
            }

            isNegativeSign = ((char == '-') and digits.isEmpty())

            if(char.isDigit() or isNegativeSign){
                digits += char
            }

        }

        if(digits.toIntOrNull() != null){
            sum += digits.toInt()
        }

        return sum
    }
}

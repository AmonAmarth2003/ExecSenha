fun main(){
    println(testNegativeAddition())
    println(testLastDigitCounting())
    println(testNoDigit())
    println(testSumWithDoubleHyphen());
    println(testJumpNegative());
    println(testWithEmotes());
}

fun testWithEmotes() : Boolean{
    return sumNumbersInString("10😊-30") == -20
}

fun testJumpNegative() : Boolean{
    return sumNumbersInString("10-a10") == 20
}

fun testNoDigit() : Boolean{
    return sumNumbersInString("") == 0
}

fun testLastDigitCounting() : Boolean{
    return sumNumbersInString("200a10") == 210
}

fun testNegativeAddition() : Boolean{
    return sumNumbersInString("100-10a") == 90
}

fun testSumWithDoubleHyphen(): Boolean {
    return sumNumbersInString("200--20+10") == 190
}

//fun sumNumbersInString(text : String): Int{
//    var digits : String = ""
//    var sum : Int = 0
//
//    for(char in text){
//        if(char.isDigit()){
//            digits += char
//        }
//
//        if(!char.isDigit() and digits.isNotEmpty()){
//            if(digits.toIntOrNull() != null){
//                sum += digits.toInt()
//            }
//            digits = ""
//        }
//
//        if((char == '-') and digits.isEmpty()){
//            digits += char
//        }
//    }
//
//    // If the last chars where numbers, add them
//    if(digits.toIntOrNull() != null){
//        sum += digits.toInt()
//    }
//
//    return sum
//}

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


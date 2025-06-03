package spacecat.learn.kotlin

//Code
//Testcase
//Test Result
//Test Result
//8. String to Integer (atoi)
//Medium
//Topics
//premium lock icon
//Companies
//Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//
//The algorithm for myAtoi(string s) is as follows:
//
//Whitespace: Ignore any leading whitespace (" ").
//Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//Return the integer as the final result.
//
//
//
//Example 1:
//
//Input: s = "42"
//
//Output: 42
//
//Explanation:
//
//The underlined characters are what is read in and the caret is the current reader position.
//Step 1: "42" (no characters read because there is no leading whitespace)
//^
//Step 2: "42" (no characters read because there is neither a '-' nor '+')
//^
//Step 3: "42" ("42" is read in)
//^
//Example 2:
//
//Input: s = " -042"
//
//Output: -42
//
//Explanation:
//
//Step 1: "   -042" (leading whitespace is read and ignored)
//^
//Step 2: "   -042" ('-' is read, so the result should be negative)
//^
//Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
//^
//Example 3:
//
//Input: s = "1337c0d3"
//
//Output: 1337
//
//Explanation:
//
//Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//^
//Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//^
//Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
//^
//Example 4:
//
//Input: s = "0-1"
//
//Output: 0
//
//Explanation:
//
//Step 1: "0-1" (no characters read because there is no leading whitespace)
//^
//Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
//^
//Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
//^
//Example 5:
//
//Input: s = "words and 987"
//
//Output: 0
//
//Explanation:
//
//Reading stops at the first non-digit character 'w'.
//
//
//
//Constraints:
//
//0 <= s.length <= 200
//s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
fun main() {
    println("outcome = ${myAtoi("-+12")}")

    println("b Outcome = ${myAtoiB("-+12")}")
}
fun myAtoi(s: String): Int {
//    println(s)
//    println(Int.MAX_VALUE)
//    println(Int.MIN_VALUE)
    var outcome = 0L
    var isNumFound = false
    var isNegative = false
    var charAt = 0
    while (charAt < s.length) {
        while (s[charAt] == ' '&& !isNumFound) {
            charAt++
            if (charAt >=s.length) return 0
        }
        if (s[charAt] == '-' && !isNumFound) {
            isNumFound = true
            isNegative = true
            if(charAt<s.length-1) charAt++

        }
        if (s[charAt] == '+' && !isNumFound) {
            isNumFound = true
            if(charAt<s.length-1) charAt++
        }
        if (!s[charAt].isDigit() && !isNumFound) {
            return outcome.toInt()
        }
        if (s[charAt].isDigit()) {
            isNumFound = true
            outcome = outcome * 10 + s[charAt].digitToInt()
        }
        if (!s[charAt].isDigit() && isNumFound) charAt = s.length
        if (outcome > Int.MAX_VALUE)
            return if(isNegative) Int.MIN_VALUE else Int.MAX_VALUE
        charAt++
    }
    return if (isNegative) (outcome * -1).toInt() else outcome.toInt()
}

// best way on leetcode that dont have to use Long
fun myAtoiB(s:String):Int{
    var charAt = 0
    val length = s.length
    var sign = 1
    var outcome =0
    // check and skill all the first empty space of the string
    while(charAt<length && s[charAt]==' ') charAt++

    if(charAt<length && (s[charAt]=='-' || s[charAt]=='+'))
    {
        if(s[charAt]=='-') sign =-1
        charAt++
    }
    while (charAt < length && s[charAt].isDigit()){
        val number = s[charAt]-'0'
        if(outcome > (Int.MAX_VALUE - number)/10){
            return if(sign == -1) Int.MIN_VALUE else Int.MAX_VALUE
        }
        outcome = outcome*10 +number
        charAt++
    }
    return outcome*sign
}

package spacecat.learn.kotlin

//A word is considered valid if:
//
//It contains a minimum of 3 characters.
//It contains only digits (0-9), and English letters (uppercase and lowercase).
//It includes at least one vowel.
//It includes at least one consonant.
//You are given a string word.
//
//Return true if word is valid, otherwise, return false.
//
//Notes:
//
//'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
//A consonant is an English letter that is not a vowel.
//
//
//Example 1:
//
//Input: word = "234Adas"
//
//Output: true
//
//Explanation:
//
//This word satisfies the conditions.
//
//Example 2:
//
//Input: word = "b3"
//
//Output: false
//
//Explanation:
//
//The length of this word is fewer than 3, and does not have a vowel.
//
//Example 3:
//
//Input: word = "a3$e"
//
//Output: false
//
//Explanation:
//
//This word contains a '$' character and does not have a consonant.
//
//
//
//Constraints:
//
//1 <= word.length <= 20
//word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.

fun main() {
    for (i in '0'..'9') print(" $i = ${i.code}")
    for (i in 'a'..'z') print(" $i = ${i.code}")
    for (i in 'A'..'Z') print(" $i = ${i.code}")
    println()
    println(isValid("somehing"))
}

fun isValid(word: String): Boolean {
    if (word.length < 3) return false
    var hasVowel = false
    var hasConsonant = false
    for (i in word) {
        if (i !in 'a'..'z' && i !in '0'..'9' && i !in 'A'..'Z') return false

        if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' || i == 'A' || i == 'E' || i == 'I' || i == 'O' || i == 'U')
            hasVowel = true
        else if (i !in '0'..'9') hasConsonant = true
    }
    return hasVowel && hasConsonant
}
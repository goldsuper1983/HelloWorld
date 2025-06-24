package spacecat.learn.kotlin

//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
//
//Each letter in pattern maps to exactly one unique word in s.
//Each unique word in s maps to exactly one letter in pattern.
//No two letters map to the same word, and no two words map to the same letter.
//
//
//Example 1:
//
//Input: pattern = "abba", s = "dog cat cat dog"
//
//Output: true
//
//Explanation:
//
//The bijection can be established as:
//
//'a' maps to "dog".
//'b' maps to "cat".
//Example 2:
//
//Input: pattern = "abba", s = "dog cat cat fish"
//
//Output: false
//
//Example 3:
//
//Input: pattern = "aaaa", s = "dog cat cat dog"
//
//Output: false
//
//
//
//Constraints:
//
//1 <= pattern.length <= 300
//pattern contains only lower-case English letters.
//1 <= s.length <= 3000
//s contains only lowercase English letters and spaces ' '.
//s does not contain any leading or trailing spaces.
//All the words in s are separated by a single space.

fun main() {
    val patten = "he"
    val s = "aaasdfasdfsadfasdf"
    println(wordPattern(patten, s))
}

fun wordPattern(pattern: String, s: String): Boolean {
    var startWord = 0
    var patternCharAt = 0
    var sCharAt = 1
    val endS = s.length - 1
    val patternL = pattern.length
    val mapPtoS = hashMapOf<Char, String>()
    val mapStoP = hashMapOf<String, Char>()
    while (sCharAt <= endS && patternCharAt < pattern.length) {
        if (s[sCharAt] == ' ' || sCharAt == endS) {
            println("$mapPtoS   $mapStoP")
            if (sCharAt == endS) sCharAt++
            val supString = s.substring(startWord, sCharAt)
            if (sCharAt == endS) sCharAt++
            if (mapPtoS.contains(pattern[patternCharAt])
                && mapPtoS[pattern[patternCharAt]] != supString)
                return false
            else mapPtoS[pattern[patternCharAt]] = s.substring(startWord, sCharAt)
            if (mapStoP.contains(supString) && mapStoP[supString] != pattern[patternCharAt]) return false
            else mapStoP[supString] = pattern[patternCharAt]
            startWord = sCharAt + 1
            patternCharAt++
            if(patternCharAt == patternL && sCharAt < endS) return false
            if(sCharAt>endS && patternCharAt < patternL) return false
        }
        sCharAt++
    }
    return true
}
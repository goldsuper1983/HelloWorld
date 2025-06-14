package spacecat.learn.kotlin

//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
//
//
//Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//Example 2:
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false
//Example 3:
//
//Input: ransomNote = "aa", magazine = "aab"
//Output: true
//
//
//Constraints:
//
//1 <= ransomNote.length, magazine.length <= 105
//ransomNote and magazine consist of lowercase English letters.

fun main() {
    val ransomNote = "aa"
    val magazine = "ab"
    println(canConstruct(ransomNote, magazine))
}

/// hashmap way
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val map = hashMapOf<Char, Int>()
    for (char in ransomNote) {
        if (map.contains(char)) map[char] = map[char]!! + 1
        else map[char] = 1
    }
    for (char in magazine) {
        if (map.contains(char)) map[char] = map[char]!! - 1
    }
    if (map.all { it.value <= 0 }) return true
    return false
}

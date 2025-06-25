package spacecat.learn.kotlin

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//
//Output: true
//
//Example 2:
//
//Input: s = "rat", t = "car"
//
//Output: false
//
//
//
//Constraints:
//
//1 <= s.length, t.length <= 5 * 104
//s and t consist of lowercase English letters.
//
//

fun main() {
    val s = ""
    val t = ""
    println(isAnagram(s, t))
}

//Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
fun isAnagram(s: String, t: String): Boolean {
    val ss = s.toCharArray()
    val tt = t.toCharArray()
    tt.sort()
    ss.sort()
    return tt.joinToString() == ss.joinToString()
}

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
    val s = "rat"
    val t = "atr"
    println(isAnagram(s, t))
}
// solution learned form leetcode
fun isAnagram(s: String, t: String): Boolean {
    if(s.length!= t.length) return false
    val codeMap = IntArray(26){0}
    for(c in s)  codeMap[c.code - 'a'.code] +=1

    for(c in t)codeMap[c.code - 'a'.code] -=1
    println(codeMap.joinToString())
    return codeMap.all { it ==0 }
}

//Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
//fun isAnagram(s: String, t: String): Boolean {
//    val ss = s.toCharArray()
//    val tt = t.toCharArray()
//    tt.sort()
//    ss.sort()
//    return tt.joinToString() == ss.joinToString()
//}

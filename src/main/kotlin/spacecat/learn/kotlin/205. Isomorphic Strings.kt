package spacecat.learn.kotlin

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//Example 1:
//
//Input: s = "egg", t = "add"
//
//Output: true
//
//Explanation:
//
//The strings s and t can be made identical by:
//
//Mapping 'e' to 'a'.
//Mapping 'g' to 'd'.
//Example 2:
//
//Input: s = "foo", t = "bar"
//
//Output: false
//
//Explanation:
//
//The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
//
//Example 3:
//
//Input: s = "paper", t = "title"
//
//Output: true
//
//
//
//Constraints:
//
//1 <= s.length <= 5 * 104
//t.length == s.length
//s and t consist of any valid ascii character.

fun main() {
    val s = "badc"
    val t = "baba"
    println(isIsomorphic(s, t))
}

fun isIsomorphic(s: String, t: String): Boolean {
    val maps = hashMapOf<Char, Char>()
    val mapt = hashMapOf<Char,Char>()
    for (i in 0 until s.length) {
        if (maps.contains(s[i])) {
            if (maps[s[i]] != t[i]) return false
        }
        if(mapt.contains(t[i])){
            if (mapt[t[i]]!= s[i]) return false
        }
        maps[s[i]] = t[i]
        mapt[t[i]] = s[i]
    }
    return true
}

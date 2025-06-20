package spacecat.learn.kotlin

//49. Group Anagrams
//Medium
//Topics
//conpanies icon
//Companies
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//Explanation:
//
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
//Example 2:
//
//Input: strs = [""]
//
//Output: [[""]]
//
//Example 3:
//
//Input: strs = ["a"]
//
//Output: [["a"]]
//
//
//
//Constraints:
//
//1 <= strs.length <= 104
//0 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.

fun main() {
    val strs = arrayOf("cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc")
    println(groupAnagrams(strs))
}

/// sort the string then use it as the key
fun groupAnagramsm(strs: Array<String>): List<List<String>> {
    val map = hashMapOf<String, MutableList<String>>()
    for (s in strs) {
        val charArray = s.toCharArray()
        charArray.sort()
        val key = charArray.concatToString()
        println(key)
        if (map.contains(key)) map[key]?.add(s)
        else {
            map[key] = mutableListOf(s)
        }
    }
    return map.map { it.value }
}

/// learned it form best solution on leetcode. count the letters then make it become a string then use it as a key

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = hashMapOf<String, MutableList<String>>()
    for (s in strs) {
        val charArray = CharArray(26) { 'a' }
        for (char in s) {
            charArray[char - 'a']++
        }
        val key = charArray.concatToString()
        if(map.contains(key)) map[key]?.add(s)
        else map[key] = mutableListOf(s)
    }
    return map.map { it.value }
}

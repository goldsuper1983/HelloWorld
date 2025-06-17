package spacecat.learn.kotlin

//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//
//
//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
//
//Constraints:
//
//1 <= haystack.length, needle.length <= 104
//haystack and needle consist of only lowercase English characters.

fun main() {
    val haystack = "mississippi"
    val needle = "pi"
    println(strStr(haystack, needle))
}

fun strStr(haystack: String, needle: String): Int {
    var i = 0
    var start = -1
    if (needle == "") return -1
    while (i < haystack.length) {
        if (needle[0] == haystack[i]) {
            start = i
            i++
            var j = 1
            println("j = $j n =${needle[j]} i= $i h= ${haystack[i]} ")
            while (i < haystack.length && j < needle.length && needle[j] == haystack[i]) {

                i++
                j++
            }
            if (j == needle.length) return start
            i = start
        }
        i++
    }
    return -1
}

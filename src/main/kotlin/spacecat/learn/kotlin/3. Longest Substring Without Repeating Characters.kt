package spacecat.learn.kotlin

//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//Constraints:
//
//0 <= s.length <= 5 * 104
//s consists of English letters, digits, symbols and spaces.

fun main() {
    val s = "tmmzuxtaaaddbb"
    println(lengthOfLongestSubstring(s))

}

fun lengthOfLongestSubstring(s: String): Int {
    val set = mutableSetOf<Char>()
    var maxLenght = 0
    var left = 0
    for (right in s.indices) {
        if (set.contains(s[right])){
            println("left = $left right= $right ")
            println(set)
            while (s[left] != s[right] ) {
                set.remove(s[left])
                left ++
            }
            left++
            println("left = $left right= $right ")
            println(set)
        }
        set.add(s[right])
        if(maxLenght < set.size) maxLenght =set.size
    }
    return maxLenght
}


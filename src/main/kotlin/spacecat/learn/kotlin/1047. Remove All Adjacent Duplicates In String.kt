package spacecat.learn.kotlin

//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//
//We repeatedly make duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
//
//
//
//Example 1:
//
//Input: s = "abbaca"
//Output: "ca"
//Explanation:
//For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
//Example 2:
//
//Input: s = "a"
//Output: "ay"
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase English letters.
fun main() {
    val str = "abbaca"
    println(removeDuplicates(str))
}

/// new way use char array as stack.
fun removeDuplicates(s: String): String {
    val charArray = CharArray(s.length)
    var i = 0
    for (c in s) {
        if (i > 0 && charArray[i-1] == c) i--
        else {
            charArray[i]=c
            i++
        }
    }
    return String(charArray,0,i)
}
//////dump way take too much time
//fun removeDuplicates(s: String): String {
//    val length = s.length - 1
//    if (length <= 0) return s
//    val stack = ArrayDeque<Char>()
//    var runner = 1
//    stack.add(s[0])
//    while (runner <= length) {
//        if (stack.isNotEmpty() && s[runner] == stack.last()) {
//            stack.removeLast()
//        } else {
//            stack.add(s[runner])
//        }
//        runner++
//    }
//    return stack.joinToString("")
//}
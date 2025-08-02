package spacecat.learn.kotlin

import java.lang.Math.abs

//Given a string s of lower and upper case English letters.
//
//A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
//
//0 <= i <= s.length - 2
//s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
//To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
//
//Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
//
//Notice that an empty string is also good.

fun main() {
    println(makeGood("abBAcC"))
}

fun makeGood(s: String): String {
    var i = -1
    val r = 'e' - 'E'
    val charArray = CharArray(s.length)
    for (c in s) {
        if (i >= 0 && abs(c - charArray[i]) == r) i--
        else charArray[++i] = c
    }
    return String(charArray, 0, i+1)
}
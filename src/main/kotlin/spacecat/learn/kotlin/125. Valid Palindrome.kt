package spacecat.learn.kotlin

fun main() {
    val s = " 0P"
    println(isPalindrome(s))
}

fun isPalindrome(s: String): Boolean {
//    if(s.trim() == "") return false
    var left = 0
    var right = s.length - 1
    while (left < right) {
        while (!(s[left].isLetter()|| s[left].isDigit())) {
            if (left >= s.length - 1) return true
            left++
        }
        while (!(s[right].isLetter()||s[right].isDigit())) right--
        println(" l : ${s[left]} r: ${s[right]}")
        if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false
        left++
        right--
    }
    return true
}



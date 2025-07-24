package spacecat.learn.kotlin

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//Example 1:
//
//Input: s = "()"
//
//Output: true
//
//Example 2:
//
//Input: s = "()[]{}"
//
//Output: true
//
//Example 3:
//
//Input: s = "(]"
//
//Output: false
//
//Example 4:
//
//Input: s = "([])"
//
//Output: true
//
//Example 5:
//
//Input: s = "([)]"
//
//Output: false
//
//
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.
fun main() {
    val s = ")"
    println(isValidParentheses(s))
}

fun isValidParentheses(s: String): Boolean {
    if (s == "") return true
    val map = hashMapOf<Char, Char>()
    map[')'] = '('
    map[']'] = '['
    map['}'] = '{'
    var parentheseStack = java.lang.StringBuilder()
    for (c in s) {
        if (c == '(' || c == '[' || c == '{') parentheseStack.append(c)
        else if (parentheseStack.isNotEmpty() && map[c] == parentheseStack.last()) parentheseStack.deleteCharAt(parentheseStack.length - 1)
        else return false
    }
    return parentheseStack.isEmpty()
}

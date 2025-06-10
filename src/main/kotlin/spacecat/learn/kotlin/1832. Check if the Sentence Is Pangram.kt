package spacecat.learn.kotlin

fun main() {
    val s = "leetcode"
    println(checkIfPangram(s))
}

fun checkIfPangram(sentence: String): Boolean {
    val map = HashMap<Char, Boolean>()
    for (i in 'a'..'z') {
        map[i] = false
    }
    for (i in sentence.indices) {
        map[sentence[i]] = true
    }
    return !map.containsValue(false)
}

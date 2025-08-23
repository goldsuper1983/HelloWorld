package spacecat.learn.kotlin

//Given a list of phrases, generate a list of Before and After puzzles.
//
//A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase.
//
//Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase.
//
//Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders.
//
//You should return a list of distinct strings sorted lexicographically.
//
//
//
//Example 1:
//
//Input: phrases = ["writing code","code rocks"]
//Output: ["writing code rocks"]
//Example 2:
//
//Input: phrases = ["mission statement",
//"a quick bite to eat",
//"a chip off the old block",
//"chocolate bar",
//"mission impossible",
//"a man on a mission",
//"block party",
//"eat my words",
//"bar of soap"]
//Output: ["a chip off the old block party",
//"a man on a mission impossible",
//"a man on a mission statement",
//"a quick bite to eat my words",
//"chocolate bar of soap"]
//Example 3:
//
//Input: phrases = ["a","b","a"]
//Output: ["a"]
//
//
//Constraints:
//
//1 <= phrases.length <= 100
//1 <= phrases[i].length <= 100
fun main() {

}

fun beforeAndAfterPuzzles(phrases: Array<String>): List<String> {
    val resultList = mutableListOf<String>()
    val resultSet = mutableSetOf<String>()
    val componentList = mutableListOf<MutableList<String>>()
    // break the sentence to first last and mid
    for (str in phrases) {
        var i = 0
        while (i < str.length && str[i] != ' ') i++
        val first = str.substring(0, i)
        var j = str.length - 1
        while (j >= 0 && str[j] != ' ') j--
        var last = ""
        if (j > 0) last = str.substring(j + 1, str.length)
        var middle = ""
        if (i < j) {
            middle = str.substring(i, j)
        }
        componentList.add(mutableListOf(first, middle, last))
    }
    for (i in componentList.indices) {
        var ilast= if(componentList[i][2]!=="") componentList[i][2] else componentList[i][0]
        for (j in componentList.indices) {
            if (i != j && ilast == componentList[j][0] ) {
                resultSet.add((phrases[i] + componentList[j][1] + ' ' + componentList[j][2]).trim())
            }
        }
    }
    return resultSet.toList().sorted()
}


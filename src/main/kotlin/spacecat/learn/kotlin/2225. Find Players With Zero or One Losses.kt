package spacecat.learn.kotlin

//You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
//
//Return a list answer of size 2 where:
//
//answer[0] is a list of all players that have not lost any matches.
//answer[1] is a list of all players that have lost exactly one match.
//The values in the two lists should be returned in increasing order.
//
//Note:
//
//You should only consider the players that have played at least one match.
//The testcases will be generated such that no two matches will have the same outcome.
//
//
//Example 1:
//
//Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
//Output: [[1,2,10],[4,5,7,8]]
//Explanation:
//Players 1, 2, and 10 have not lost any matches.
//Players 4, 5, 7, and 8 each have lost one match.
//Players 3, 6, and 9 each have lost two matches.
//Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
//Example 2:
//
//Input: matches = [[2,3],[1,3],[5,4],[6,4]]
//Output: [[1,2,5,6],[]]
//Explanation:
//Players 1, 2, 5, and 6 have not lost any matches.
//Players 3 and 4 each have lost two matches.
//Thus, answer[0] = [1,2,5,6] and answer[1] = [].
//
//
//Constraints:
//
//1 <= matches.length <= 105
//matches[i].length == 2
//1 <= winneri, loseri <= 105
//winneri != loseri
//All matches[i] are unique.

fun main() {
    val matches = arrayOf(
        arrayOf(1, 3),
        arrayOf(2, 3),
        arrayOf(3, 6),
        arrayOf(5, 6),
        arrayOf(5, 7),
        arrayOf(4, 5),
        arrayOf(4, 8),
        arrayOf(4, 9),
        arrayOf(10, 4),
        arrayOf(10, 9)
    )
    println(findWinners(matches))
}
// doing using array
fun findWinners(matches: Array<Array<Int>>): List<List<Int>> {
    val lostResult = IntArray(10000)
    for (match in matches) {
        if (lostResult[match[0]] == 0) lostResult[match[0]] = -1
        if (lostResult[match[1]] == -1) lostResult[match[1]] = 1
        else lostResult[match[1]] += 1
    }
    val noLost = mutableListOf<Int>()
    val oneLost = mutableListOf<Int>()
    for (i in lostResult.indices) {
        if (lostResult[i] == -1) noLost.add(i)
        if (lostResult[i] == 1) oneLost.add(i)
    }
    return listOf(noLost,oneLost)
}


fun findWinnerss(matches: Array<Array<Int>>): List<List<Int>> {
    val mapPeopleWithLose = hashMapOf<Int, Int>()
    for (match in matches) {
        if (!mapPeopleWithLose.contains(match[0])) mapPeopleWithLose[match[0]] = 0
        if (mapPeopleWithLose.contains(match[1])) mapPeopleWithLose[match[1]] = mapPeopleWithLose[match[1]]!! + 1
        else mapPeopleWithLose[match[1]] = 1
    }
    println(mapPeopleWithLose)
    return listOf(
        mapPeopleWithLose.filter { it.value == 0 }.map { it.key }.sorted(),
        mapPeopleWithLose.filter { it.value == 1 }.map { it.key }.sorted()
    )
}



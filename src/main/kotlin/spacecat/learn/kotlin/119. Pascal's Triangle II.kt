package spacecat.learn.kotlin

//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//Example 1:
//
//Input: rowIndex = 3
//Output: [1,3,3,1]
//Example 2:
//
//Input: rowIndex = 0
//Output: [1]
//Example 3:
//
//Input: rowIndex = 1
//Output: [1,1]
//
//
//Constraints:
//
//0 <= rowIndex <= 33
//
//
//Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

fun main(){
    println(getRow(3))
}
/// my dummy ways
fun generatePascalII(numRows: Int): List<Int>{
    var pascalRowN = listOf<Int>()
    var pascalRowPreN :List<Int>

    if(numRows < 1)  return listOf(1)
    if(numRows<2)  return listOf(1,1)
    pascalRowPreN = mutableListOf(1,1)
    for(n in 2 ..numRows){
        pascalRowN = mutableListOf<Int>()
        pascalRowN.add(1)
        for(i in 0 until pascalRowPreN.size-1){
            pascalRowN.add(pascalRowPreN[i]+pascalRowPreN[i+1])
        }
        pascalRowN.add(1)
        pascalRowPreN= pascalRowN
    }
    return pascalRowN

}

fun getRow(rowIndex: Int): List<Int> {
    val pascalRowN = List(rowIndex+1){0}.toMutableList()
    pascalRowN[rowIndex] = 1
    var runner = rowIndex-1
    while(runner >=0){
        for(i in runner until rowIndex){
            pascalRowN[i] += pascalRowN[i+1]
        }
        runner--
    }
    return pascalRowN

}
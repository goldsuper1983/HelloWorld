package spacecat.learn.kotlin

//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//Example 1:
//
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//
//Input: numRows = 1
//Output: [[1]]
//
//
//Constraints:
//
//1 <= numRows <= 30
fun main(){
    println(generate(6))

}
fun generate(numRows: Int): List<List<Int>>{
    var pascalList = mutableListOf<List<Int>>()
    pascalList.add(listOf(1))
    if(numRows <= 1)return  pascalList
    pascalList.add(listOf(1,1))
    if(numRows<=2) return pascalList
        for(n in  3..numRows){
            var lineN  = mutableListOf<Int>()
            lineN.add(1)
            for(i in 0 ..pascalList.last().size-2){
                lineN.add(pascalList.last()[i]+pascalList.last()[i+1])
            }
            lineN.add(1)
            pascalList.add(lineN)
    }

    return pascalList
}
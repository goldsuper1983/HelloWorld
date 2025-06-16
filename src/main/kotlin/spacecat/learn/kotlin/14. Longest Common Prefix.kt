package spacecat.learn.kotlin

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//
//
//Constraints:
//
//1 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] consists of only lowercase English letters if it is non-empty.

fun main(){
    val strs = arrayOf("ab", "a")
    println(longestCommonPrefix(strs))
}
fun longestCommonPrefix(strs: Array<String>):String{
    val commonPrefix = StringBuilder()
    var charAt=0
    while(charAt < strs[0].length){
        commonPrefix.append(strs[0][charAt])
        for(strAt in 1 until strs.size){
            if( charAt >= strs[strAt].length || commonPrefix[charAt]!= strs[strAt][charAt] ){
                return commonPrefix.substring(0,commonPrefix.length-1)
            }
        }
        charAt++
    }

    return commonPrefix.toString()
}
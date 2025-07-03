package spacecat.learn.kotlin

//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
//
//
//
//Example 1:
//
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//Example 2:
//
//Input: height = [1,1]
//Output: 1
//
//
//Constraints:
//
//n == height.length
//2 <= n <= 105
//0 <= height[i] <= 104

fun main(){
    val heights = intArrayOf(1,8,6,2,100,90,8,55,7)
    println(maxArea(heights))
}

fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var left =0
    var right = height.size-1
    while(left< right){
        var area =0
        if(height[left]<= height[right]) {
            area = height[left] * (right - left)
            left++
        }
        else {
            area = height[right] * (right - left)
            right--
        }
        if (maxArea < area) maxArea = area

    }
    return maxArea
}
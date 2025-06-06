package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4)
    println(nums.joinToString())
    removeDuplicatesb(nums)
}

fun removeDuplicates2(nums: IntArray): Int {
    var nonDupArrayRunner = 0
    val numsSize = nums.size - 1
    var count = 1

    for (i in 1..numsSize) {
        if (nums[i] == nums[nonDupArrayRunner]) {
            count++
            if (count <= 2)
                nonDupArrayRunner++
            nums[nonDupArrayRunner] = nums[i]
        }
        if (nums[i] != nums[nonDupArrayRunner]) {
            count = 1
            nonDupArrayRunner++
            nums[nonDupArrayRunner] = nums[i]
        }

        println("non: $nonDupArrayRunner i :$i count : $count")
        println(nums.joinToString())
    }
    println(nums.joinToString())
    println(nonDupArrayRunner)
    return nonDupArrayRunner + 1
}

fun removeDuplicatesb(nums: IntArray): Int {
    var k=1
    for (i in 1 until nums.size) {
        if (k == 1 || nums[i] != nums[k-2]) {
            nums[k++] = nums[i]

        }
    }
    println(nums.joinToString (  ))
    return k
}
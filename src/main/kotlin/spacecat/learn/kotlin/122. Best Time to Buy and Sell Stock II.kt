package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(7, 1, 5, 3, 6, 4,5,6)
    println(maxProfit(nums))
}

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var buyDay = 0
    for (i in 0..prices.size-2) {
        if(prices[i]< prices[buyDay]) buyDay =i
        if (prices[i] > prices[i + 1]) {
            profit += prices[i] - prices[buyDay]
            buyDay= i+1
        }
    }
    profit+=prices[prices.size-1]- prices[buyDay]
    return profit
}
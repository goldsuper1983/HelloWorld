package spacecat.learn.kotlin

fun main(){
    val intArray = intArrayOf(1,2)
    val intArray2 = intArrayOf(7,1,5,3,6,4)
  println(maxProfit(intArray2))
}
fun maxProfit1(prices:IntArray):Int{
    var profit = 0
    var buyDay =0
    for(i in prices.indices){
      if(prices[i] < prices[buyDay]){
          buyDay = i
      }
        if(prices[i] - prices[buyDay] > profit){
            profit = prices[i] - prices[buyDay]
        }

    }
    return profit
}
// stupid way /////////
fun maxProfit(prices:IntArray):Int{
    var profit = 0;
    for(i in 0.. prices.size){
        for(j in i+1 until prices.size){
            if(prices[j]-prices[i]>0&& prices[j]-prices[i] >profit){
                profit = prices[j]-prices[i]
            }
        }
    }
    return profit
}
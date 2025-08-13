package spacecat.learn.kotlin

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//    MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.
//
//
//
//Example 1:
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//Constraints:
//
//-231 <= val <= 231 - 1
//Methods pop, top and getMin operations will always be called on non-empty stacks.
//At most 3 * 104 calls will be made to push, pop, top, and getMin.

fun main() {

}

class MinStack() {
    private val dummyHead = MinStackLinkList(0, 0)
    fun push(`val`: Int) {

        if (dummyHead.next == null) {
            val newNode = MinStackLinkList(`val`, `val`)
            dummyHead.next = newNode
        } else {
            val newNode =
                MinStackLinkList(`val`, (if (`val` < dummyHead.next!!.min) `val` else dummyHead.next!!.min))
            newNode.next = dummyHead.next
            dummyHead.next = newNode
        }
    }

    fun pop() {
        if (dummyHead.next != null) dummyHead.next = dummyHead.next?.next
    }

    fun top(): Int {
        if (dummyHead.next != null) return dummyHead.next!!.`val`
        return 0
    }

    fun getMin(): Int {
        if (dummyHead.next != null) return dummyHead.next!!.min
        return 0
    }
}

class MinStackLinkList(var `val`: Int, var min: Int) {
    var next: MinStackLinkList? = null
}

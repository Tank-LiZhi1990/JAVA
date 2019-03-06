package Sword.src.com.stackadnqueue;

import java.util.Stack;

public class StackWithMin {

	// 带min函数的栈,增加一个辅助栈,在有新元素入栈时,入新元素和当前最小元素较小的那个值到辅助栈中
	private Stack<Integer> mStack = new Stack<>();
	private Stack<Integer> stack = new Stack<>();

	public void push(Integer i) {
		if (mStack.isEmpty() || i < mStack.peek()) {
			mStack.push(i);
		} else {
			mStack.push(mStack.peek());
		}
		stack.push(i);
	}

	public Integer pop() {
		mStack.pop();
		return stack.pop();
	}

	public Integer min() {
		return mStack.peek();
	}
}

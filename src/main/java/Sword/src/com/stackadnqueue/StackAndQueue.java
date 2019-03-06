package Sword.src.com.stackadnqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.junit.Test;

public class StackAndQueue {
	// 两个栈模拟队列,如果用于输出的栈不空,就输出输出栈里的值,否则,将输入栈里的值放入输出栈
	private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();

	public void enqueue(Integer value) {
		inStack.push(value);
	}

	public Integer dequeue() {
		if (!outStack.isEmpty()) {
			return outStack.pop();
		}

		if (!inStack.isEmpty()) {
			while (!inStack.isEmpty())
				outStack.push(inStack.pop());
			return this.dequeue();
		} else {
			throw new RuntimeException("Empty queue!");
		}
	}

	@Test
	public void test_twoStackAsQueue() {
		Integer i = 10;
		StackAndQueue queue = new StackAndQueue();
		queue.enqueue(i);
		queue.enqueue(i + 1);
		queue.enqueue(i + 2);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(i + 10);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

	// 两个队列模拟栈,入1队列,输出时,将1队列的值入2队列,最后一个输出,然后交换1与2队列
	private Queue<Integer> queue1 = new LinkedList<>();
	private Queue<Integer> queue2 = new LinkedList<>();

	public void push(Integer i) {
		if (i != null) {
			queue1.add(i);
		}
	}

	public Integer pop() {

		if (!queue1.isEmpty()) {
			while (queue1.size() > 1) {
				queue2.add(queue1.poll());
			}

			if (queue1.size() == 1) {
				Integer result = queue1.poll();

				Queue<Integer> temp = queue1;
				queue1 = queue2;
				queue2 = temp;

				return result;
			}
		}

		return null;
	}

	@Test
	public void test_twoQueueAsStack() {
		StackAndQueue stack = new StackAndQueue();

		System.out.println(stack.pop());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(10);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
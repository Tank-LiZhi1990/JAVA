package com.nio.buffer;

import java.nio.ByteBuffer;

public class BufferDemo {
	/*
	 * 缓冲区通常是一个数组,字节数组,但是也可以使用其他类型的数组
	 * 缓冲区不仅仅是一个数组,还提供了对数组的结构化的访问.
	 */
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		/*
		 * 除了byteBuffer类,每一个其他类型的buffer都有完全相同的操作,
		 * 因为大多数标准IO都使用ByteBuffer,因此它有所有共享的缓冲区操作,以及一些特有的操作
		 * CharBuffer
		 * ShortBuffer;
		 * IntBuffer;
		 * FloatBuffer;
		 * DoubleBuffer;
		 * LongBuffer;
		 * ShortBuffer;
		 */
		// byteBuffer get方法返回自身的引用 this

		// get() get(byte[]) get(byte[],int offset,int len) get(int index)
		// 前三个相对,最后一个绝对,但不会影响position和limit,绕过了buffer的统计方法
		// 其他buffer也有同样方法,只是处理的数据类型不一样

		// put() put(byte[]) put(byte[] int offset,int len) put(ByteBuffer)
		// put(int index,byte)
		// 前四个相对,最后一个绝对
		// 其他buffer也有同样的方法.
	}
}

package com.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class DiffBuffer {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		buffer.put((byte) 1);
		buffer.putInt(1);
		buffer.putLong(100000000000000L);
		buffer.putFloat(1.0f);
		buffer.putDouble(Math.PI);

		buffer.flip();

		// 顺序必须一致
		System.out.println(buffer.get());
		System.out.println(buffer.getInt());
		System.out.println(buffer.getLong());
		System.out.println(buffer.getFloat());
		System.out.println(buffer.getDouble());

		// float没有out其他类型数据的方法
		FloatBuffer floatBuffer = FloatBuffer.allocate(102);

		// wrap包装
		byte[] arr = new byte[1024];
		ByteBuffer buf = ByteBuffer.wrap(arr);

		// slice分片,与底层数组共享,position和limit指定起止位置(指定状态量)
		buffer.position(10);
		buffer.limit(100);
		ByteBuffer buf2 = buffer.slice();

		buffer.position(0);
		buffer.limit(buffer.capacity());
		while (buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}

		// 只读共享,共享底层数组;不能将只读缓冲区转换成可读的
		ByteBuffer readOnly = buffer.asReadOnlyBuffer();

		// 直接缓冲区,java虚拟机将尽最大努力对它执行本机IO操作,会在每次调用底层操作系统的本机IO之前或之后
		// 避免将缓冲区内容拷贝到中间缓冲区中,或者从一个中间缓冲区中拷贝数据
		
	}
}

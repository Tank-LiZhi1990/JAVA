package com.nio.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileWriteAndReadBytes {
	/*
	 * 1.从FileInputStream中获取Channel
	 * 2.创建buffer
	 * 3.将数据从channel读到buffer
	 * 
	 */
	public static void main(String[] args) throws IOException {
		// 初始化步骤
		FileOutputStream out = new FileOutputStream(new File("write.txt"));
		FileChannel fc = out.getChannel();
		ByteBuffer bb = ByteBuffer.allocate(1024);

		// 写,内部机制会跟踪它包含多少数据以及还有多少数据要写入
		byte[] message = "abcdefghijklmnopqrstuvwxyz中国".getBytes("UTF-8");
		for (int i = 0; i < message.length; i++) {
			bb.put(message[i]);
		}
		bb.flip();
		fc.write(bb);
		out.close();

		FileInputStream fin = new FileInputStream(new File("write.txt"));
		fc = fin.getChannel();

		bb.clear();

		// 读,跟踪已经读了多少数据,以及还有多少空间可以容纳新的数据
		fc.read(bb);
		bb.flip();

		long inputLength = new File("write.txt").length();
		byte[] bytes = new byte[(int) inputLength];
		int i = 0;
		while (bb.hasRemaining()) {
			bytes[i++] = bb.get();
		}

		System.out.println(new String(bytes, "UTF-8"));// StringBuilder

		fin.close();
	}
}

package com.lz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteSomeBytes {
	public static void main(String[] args) throws IOException {
		FileOutputStream out = new FileOutputStream(new File("write.txt"));
		FileChannel fc = out.getChannel();

		ByteBuffer bb = ByteBuffer.allocate(1024);
		byte[] message = "abcdefghijklmnopqrstuvwxyzÖÐ¹ú".getBytes();
		for (int i = 0; i < message.length; i++) {
			bb.put(message[i]);
		}

		bb.flip();
		fc.write(bb);
		out.close();

		FileInputStream fin = new FileInputStream(new File("write.txt"));
		fc = fin.getChannel();

		bb.clear();
		fc.read(bb);
		bb.flip();

		long inputLength = new File("write.txt").length();
		byte[] bytes = new byte[(int) inputLength];
		int i = 0;
		while (bb.hasRemaining()) {
			bytes[i++] = bb.get();
		}
		System.out.println(new String(bytes));//StringBuilder

		fin.close();
	}
}

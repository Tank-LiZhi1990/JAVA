package com.nio.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FastCopy {

	// 直接缓冲区
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("write.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("fastcopy.txt");

		FileChannel in = fileInputStream.getChannel();
		FileChannel out = fileOutputStream.getChannel();

		ByteBuffer direct = ByteBuffer.allocateDirect(1024);

		int i = 0;
		while (true) {
			i = in.read(direct);

			if (i == -1)
				break;

			direct.flip();

			out.write(direct);

			direct.clear();
		}

		fileInputStream.close();
		fileOutputStream.close();
	}

}

package IONIO.src.com.nio.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	/*
	 * clear重设缓冲区,使它可以接受读入的数据
	 * flip重设缓冲区,使它可以将新读入的数据写到另一个通道.
	 * 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("write.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("copyfile.txt");

		FileChannel in = fileInputStream.getChannel();
		FileChannel out = fileOutputStream.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(1024);

		/*
		 * int count = 0;
		 * while ((count = in.read(buffer)) != -1) {
		 * buffer.flip();
		 * out.write(buffer);
		 * buffer.clear();
		 * }
		 */

		int count = 0;
		while (true) {
			buffer.clear();
			count = in.read(buffer);
			if (count == -1) {
				break;
			}

			buffer.flip();
			out.write(buffer);
		}

		fileInputStream.close();
		fileOutputStream.close();
	}
}

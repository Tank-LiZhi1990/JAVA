package com.lz;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyServer {
	private static final int firstHeaderLength = 2;
	private static final int secondHeaderLength = 4;
	private static final int bodyLength = 6;

	private static final String host = "localhost";
	private static final int port = 8888;

	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		InetSocketAddress addr = new InetSocketAddress(port);
		ssc.socket().bind(addr);

		int messageLength = firstHeaderLength + secondHeaderLength + bodyLength;
		ByteBuffer bufs[] = new ByteBuffer[3];
		bufs[0] = ByteBuffer.allocate(firstHeaderLength);
		bufs[1] = ByteBuffer.allocate(secondHeaderLength);
		bufs[2] = ByteBuffer.allocate(bodyLength);

		SocketChannel sc = ssc.accept();

		int count = 3;
		while (count > 0) {
			// scatter read into buffer
			int bytesRead = 0;
			while (bytesRead < messageLength) {
				long r = sc.read(bufs);
				bytesRead += r;
				System.out.println("r " + r);

				for (int i = 0; i < bufs.length; i++) {
					ByteBuffer bb = bufs[i];
					System.out.println("b " + i + " " + bb.position() + " " + bb.limit());
				}
			}
			
			// process message
			// flip
			for (int i = 0; i < bufs.length; i++) {
				ByteBuffer bb = bufs[i];
				bb.flip();
			}

			// scatter-write back out
			int bytesWrites = 0;
			while (bytesWrites < messageLength) {
				long r = sc.write(bufs);
				bytesWrites += r;
			}

			// clear
			for (int i = 0; i < bufs.length; i++) {
				ByteBuffer bb = bufs[i];
				bb.clear();
			}

			System.out.println(bytesRead + " " + bytesWrites + " " + messageLength);

			count--;
		}

		sc.close();
	}
}

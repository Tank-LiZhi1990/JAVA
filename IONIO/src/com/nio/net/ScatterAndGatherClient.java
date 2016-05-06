package com.nio.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ScatterAndGatherClient {
	private static final int firstHeaderLength = 2;
	private static final int secondHeaderLength = 4;
	private static final int bodyLength = 6;

	private static final String host = "localhost";
	private static final int port = 8888;

	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		InetSocketAddress addr = new InetSocketAddress(host, port);

		int messageLength = firstHeaderLength + secondHeaderLength + bodyLength;
		ByteBuffer bufs[] = new ByteBuffer[3];
		bufs[0] = ByteBuffer.allocate(firstHeaderLength);
		bufs[0].put("aa".getBytes());
		bufs[1] = ByteBuffer.allocate(secondHeaderLength);
		bufs[1].put("bbbb".getBytes());
		bufs[2] = ByteBuffer.allocate(bodyLength);
		bufs[2].put("cccccc".getBytes());

		sc.socket().connect(addr);

		int count = 3;
		while (count > 0) {
			for (int i = 0; i < bufs.length; i++) {
				ByteBuffer bb = bufs[i];
				bb.flip();
			}

			int writeBytes = 0;
			while (writeBytes < messageLength) {
				long r = sc.write(bufs);
				writeBytes += r;
			}

			for (int i = 0; i < bufs.length; i++) {
				ByteBuffer bb = bufs[i];
				bb.clear();
			}

			int readBytes = 0;
			while (readBytes < messageLength) {
				long r = sc.read(bufs);
				readBytes += r;

				System.out.println("r " + r);
				for (int i = 0; i < bufs.length; i++) {
					ByteBuffer bb = bufs[i];
					System.out.println("b " + i + bb.position() + " " + bb.limit());
				}
			}

			System.out.println(writeBytes + " " + readBytes + " " + messageLength);

			count--;
		}

		sc.close();
	}

}

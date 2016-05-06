package com.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

public class Consumer extends Thread {
	private PipedInputStream pipeIn = new PipedInputStream();

	public Consumer() {
		super();
	}

	public PipedInputStream getPipeIn() {
		return pipeIn;
	}

	@Override
	public void run() {
		super.run();
		byte[] msg = new byte[256];
		int len = 0;
		try {
			do {
				len = pipeIn.read(msg);
				if (len >= 0) {
					System.out.print(new String(msg, 0, len));
				}
			} while (len != -1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pipeIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

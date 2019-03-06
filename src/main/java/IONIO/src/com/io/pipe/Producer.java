package IONIO.src.com.io.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;

public class Producer extends Thread {
	private PipedOutputStream pipeOut = new PipedOutputStream();

	public Producer() {
		super();
	}

	public PipedOutputStream getPipeOut() {
		return pipeOut;
	}

	@Override
	public void run() {
		super.run();

		int i = 0;
		try {
			do {
				pipeOut.write(new Random().nextInt(13) + 108);
				pipeOut.flush();
				Thread.sleep(10);
				++i;
			} while (i < 101);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				pipeOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

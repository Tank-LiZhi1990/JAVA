package com.io.pipe;

import java.io.IOException;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		producer.getPipeOut().connect(consumer.getPipeIn());

		producer.start();
		consumer.start();
	}
}

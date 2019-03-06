package IONIO.src.com.nio.buffer;

import java.nio.FloatBuffer;

public class UseFloatBuffer {
	public static void main(String[] args) {
		FloatBuffer floatBuffer = FloatBuffer.allocate(20);

		for (int i = 0; i < floatBuffer.capacity(); i++) {
			float f = (float) (Math.sin(i * Math.PI * 2));
			floatBuffer.put(f);
		}

		// 翻译:翻转
		floatBuffer.flip();

		while (floatBuffer.hasRemaining()) {
			float f = floatBuffer.get();
			System.out.println(f);
		}
	}
}

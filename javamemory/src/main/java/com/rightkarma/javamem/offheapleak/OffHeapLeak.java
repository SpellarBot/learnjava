package com.rightkarma.javamem.offheapleak;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class OffHeapLeak {

	/*
	 * run this and see this in JvisualVM
	 * you will see very less memory used by the class 
	 * but if you see BufferPools tab, you will lot of memory consumed.
	 * That is becuase of use of ByteBuffers
	 * */
	private static final int BUFFER_SIZE=64*1024;
	public static void main(String[] args) throws IOException {
		final List<ByteBuffer> buffers = new ArrayList<>();
		while (true) {
			buffers.add(ByteBuffer.allocateDirect(BUFFER_SIZE));
			System.out.println("Press any key to continue");
			System.in.read();
		}
	}
}

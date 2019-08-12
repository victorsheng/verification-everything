package file.nio.write;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Write {

  public static void main(String[] args) throws IOException {
    RandomAccessFile aFile = new RandomAccessFile(
        "/Users/victor/code/vicProjects/verification-everything/io/src/main/resources/write.txt",
        "rw");
    FileChannel channel = aFile.getChannel();
    String newData = "New String to write to file..." + System.currentTimeMillis();

    ByteBuffer buf = ByteBuffer.allocate(48);
    buf.clear();
    buf.put(newData.getBytes());

    buf.flip();

    while(buf.hasRemaining()) {
      channel.write(buf);
    }
  }

}

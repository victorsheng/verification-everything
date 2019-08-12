package file.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileWithFileSizeBuffer {

  public static void main(String args[]) {
    try {
      RandomAccessFile aFile = new RandomAccessFile(
          "/Users/victor/code/vicProjects/verification-everything/io/src/main/resources/test.txt",
          "r");
      FileChannel inChannel = aFile.getChannel();
      long fileSize = inChannel.size();
      ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
      inChannel.read(buffer);
      //buffer.rewind();
      buffer.flip();
      System.out.println("fileSize:" + fileSize);
      System.out.println(buffer);
      for (int i = 0; i < fileSize; i++) {
        System.out.print((char) buffer.get());
      }
      inChannel.close();
      aFile.close();
    } catch (IOException exc) {
      System.out.println(exc);
      System.exit(1);
    }
  }

}

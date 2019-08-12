package file.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileWithMappedByteBuffer {

  public static void main(String[] args) throws IOException {
    RandomAccessFile aFile = new RandomAccessFile
        ("/Users/victor/code/vicProjects/verification-everything/io/src/main/resources/test.txt",
            "r");
    FileChannel inChannel = aFile.getChannel();
    MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
    buffer.load();
    for (int i = 0; i < buffer.limit(); i++) {
      System.out.print((char) buffer.get());
    }
    buffer.clear(); // do something with the data and clear/compact it.
    inChannel.close();
    aFile.close();
  }
}
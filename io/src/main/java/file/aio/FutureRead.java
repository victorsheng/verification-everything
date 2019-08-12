package file.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureRead {

  public static void main(String[] args) {
    try {
      Path file = Paths.get("/Users/victor/code/vicProjects/verification-everything/io/src/main/resources/test.txt");

      AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

      ByteBuffer buffer = ByteBuffer.allocate(30);
      Future<Integer> result = channel.read(buffer, 0);

      while (!result.isDone()) {
        // do something
        TimeUnit.SECONDS.sleep(1);
        System.out.println("waiting");
      }

      Integer bytesRead = result.get();
      byte b = buffer.get();
      System.out.println(b);

      System.out.println("Bytes read [" + bytesRead + "]");

      //正确
//      String fileContent = new String(buffer.array()).trim();
//      buffer.clear();
//      System.out.println(fileContent);

      //正确
//      buffer.flip();从写转为读取
//      for (int i = 0; i < bytesRead; i++) {
//        System.out.print((char) buffer.get());
//      }

      System.out.println(buffer);

      //错误
//      for (int i = 0; i < bytesRead; i++) {
//        System.out.print((char) buffer.get());
//      }


    } catch (IOException | ExecutionException | InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }

}

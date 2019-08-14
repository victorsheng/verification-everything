package file.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class CallBackRead {

  public static void main(String[] args) throws InterruptedException {
    try {
      Path file = Paths.get(
          "/Users/victor/code/vicProjects/verification-everything/io/src/main/resources/test.txt");

      AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

      ByteBuffer buffer = ByteBuffer.allocate(30);

      channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
        public void completed(Integer result, ByteBuffer attachment) {
          System.out.println(Thread.currentThread());
          attachment.flip();
          for (int i = 0; i < result; i++) {
            System.out.print((char) buffer.get());
          }
        }

        public void failed(Throwable exception, ByteBuffer attachment) {
          System.err.println(exception.getMessage());
        }
      });
    } catch (
        IOException e) {
      System.err.println(e.getMessage());
    }
    TimeUnit.SECONDS.sleep(1);
    System.out.println(Thread.currentThread());
  }
}

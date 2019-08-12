package socket.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

  public static void main(String[] args) throws Exception {
    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.configureBlocking(false);
    socketChannel.connect(new InetSocketAddress("localhost", 7777));

    while (!socketChannel.finishConnect()) {
      //wait, or do something else...
    }

    String newData = "New String to write to file..." + System.currentTimeMillis();

    ByteBuffer buf2 = ByteBuffer.allocate(48);
    buf2.clear();
    buf2.put(newData.getBytes());

    buf2.flip();

    while (buf2.hasRemaining()) {
      socketChannel.write(buf2);
    }

    ByteBuffer buf = ByteBuffer.allocate(48);

    int bytesRead = socketChannel.read(buf);
    buf.flip();
    while (buf.hasRemaining()) {
      System.out.print((char) buf.get());
    }

    socketChannel.close();
  }

}

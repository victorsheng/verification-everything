package socket.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

  public static void main(String[] args) throws Exception {
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

    serverSocketChannel.socket().bind(new InetSocketAddress(7777));
    serverSocketChannel.configureBlocking(false);

    while (true) {
      SocketChannel socketChannel =
          serverSocketChannel.accept();
      if (socketChannel != null) {
        System.out.println("accept");
        //do something with socketChannel...
        while (!socketChannel.finishConnect()) {
          //wait, or do something else...
        }
        System.out.println("finishConnect");
        socketChannel.write(ByteBuffer.wrap("hello".getBytes()));

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = socketChannel.read(buf);
        buf.flip();
        while (buf.hasRemaining()) {
          System.out.print((char) buf.get());
        }
        System.out.println();


      }
    }

  }

}

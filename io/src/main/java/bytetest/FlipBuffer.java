package bytetest;

import java.nio.CharBuffer;

public class FlipBuffer {

  public static void main(String[] args) {
    CharBuffer buffer = CharBuffer.allocate(5);
    buffer.put('a');
    buffer.put('b');
    buffer.put('c');
    buffer.put('d');
    buffer.flip();
    System.out.println(buffer.toString());


  }

}

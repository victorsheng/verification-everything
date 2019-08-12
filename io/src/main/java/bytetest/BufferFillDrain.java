package bytetest;

import java.nio.CharBuffer;

public class BufferFillDrain {

  public static void main(String[] argv)
      throws Exception {
    CharBuffer buffer = CharBuffer.allocate(100);
    //写
    while (fillBuffer(buffer)) {
      buffer.flip();
      //打印
      drainBuffer(buffer);
      buffer.clear();
    }
  }

  private static void drainBuffer(CharBuffer buffer) {
    while (buffer.hasRemaining()) {
      System.out.print(buffer.get());
    }

    System.out.println("");
  }

  private static boolean fillBuffer(CharBuffer buffer) {
    if (index >= strings.length) {
      return (false);
    }

    String string = strings[index++];

    for (int i = 0; i < string.length(); i++) {
      buffer.put(string.charAt(i));
    }

    return (true);
  }

  private static int index = 0;

  private static String[] strings = {
      "Some random string content 1",
      "Some random string content 2",
      "Some random string content 3",
      "Some random string content 4",
      "Some random string content 5",
      "Some random string content 6",
  };
}

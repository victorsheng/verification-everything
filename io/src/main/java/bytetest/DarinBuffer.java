package bytetest;

import java.nio.CharBuffer;

public class DarinBuffer {

  public static void main(String[] args) {
    CharBuffer buffer = CharBuffer.allocate(5);
    buffer.put('a');
    buffer.put('b');
    buffer.put('c');
    buffer.put('d');

    char[] myByteArray = new char[5];
    buffer.flip();

//    for (int i = 0; buffer.hasRemaining(); i++) {
//      myByteArray[i] = buffer.get();
//    }
//    System.out.println(myByteArray);
//    abcd 




//    -----

    int count = buffer.remaining();
    System.out.println(count);
    for (int i = 0; i < count; i++) {
      myByteArray[i] = buffer.get();
    }
    System.out.println(myByteArray);
    //abcd 

  }

}

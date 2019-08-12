package test.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import test.StreamConvert;

public class JdkChannelImpl implements StreamConvert {

  public void copy(InputStream in, FileOutputStream ou) {
    ReadableByteChannel readableByteChannel = Channels.newChannel(in);
    // TODO need review
    try {
      ou.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

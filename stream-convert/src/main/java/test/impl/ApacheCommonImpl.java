package test.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import test.StreamConvert;

public class ApacheCommonImpl implements StreamConvert {

  public void copy(InputStream in, FileOutputStream ou) {
    try {
      IOUtils.copy(in, ou);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

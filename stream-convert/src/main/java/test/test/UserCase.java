package test.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import test.StreamConvert;
import test.impl.ApacheCommonImpl;
import test.impl.JdkChannelImpl;

public class UserCase {

  public static void main(String[] args) {
    ApacheCommonImpl apacheCommon = new ApacheCommonImpl();

    JdkChannelImpl jdkChannel = new JdkChannelImpl();

    List<StreamConvert> todoList = new ArrayList<>();
    todoList.add(jdkChannel);
    todoList.add(apacheCommon);

    for (StreamConvert streamConvert : todoList) {

      try (FileInputStream fileInputStream = new FileInputStream(
          "/Users/victor/tennis/match6.0.mp4");) {
        long date = new Date().getTime();
        File tempFile = File.createTempFile("test", "test");
        System.out.println(tempFile.getAbsolutePath());
        tempFile.deleteOnExit();
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
        streamConvert.copy(fileInputStream, fileOutputStream);
        long date1 = new Date().getTime();
        long diff = date1 - date;
        System.out.println(streamConvert.getClass().getName());
        System.out.println(diff);

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

}

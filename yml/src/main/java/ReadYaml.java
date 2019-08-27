import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ReadYaml {

  public static void main(String[] args) throws IOException {
    String yaml = readAllBytesJava7("/Users/victor/code/vicProjects/verification-everything/yml/src/main/resources/s1.yml");
//    String yaml = readAllBytesJava7("/Users/victor/code/vicProjects/verification-everything/yml/src/main/resources/store.yml");
    HashMap<String, StoreInfo> storeMap = convertYamlToJson(yaml);
    System.out.println(storeMap);

  }

  static HashMap<String, StoreInfo> convertYamlToJson(String yaml) throws IOException {
    ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
    HashMap<String, StoreInfo> storeMap = yamlReader
        .readValue(yaml, new TypeReference<HashMap<String, StoreInfo>>() {
        });

    return storeMap;
  }


  private static String readAllBytesJava7(String filePath) {
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

}

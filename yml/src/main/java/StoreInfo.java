import java.util.HashMap;
import java.util.Map;

public class StoreInfo {

  private String className;

  private HashMap<String, String> connctionInfo;

  private HashMap<String, String> configInfo;

  private Map<String, String> metaInfo;

  private Map<String, String> runtimeInfo;

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public HashMap<String, String> getConnctionInfo() {
    return connctionInfo;
  }

  public void setConnctionInfo(HashMap<String, String> connctionInfo) {
    this.connctionInfo = connctionInfo;
  }

  public HashMap<String, String> getConfigInfo() {
    return configInfo;
  }

  public void setConfigInfo(HashMap<String, String> configInfo) {
    this.configInfo = configInfo;
  }

  public Map<String, String> getMetaInfo() {
    return metaInfo;
  }

  public void setMetaInfo(Map<String, String> metaInfo) {
    this.metaInfo = metaInfo;
  }

  public Map<String, String> getRuntimeInfo() {
    return runtimeInfo;
  }

  public void setRuntimeInfo(Map<String, String> runtimeInfo) {
    this.runtimeInfo = runtimeInfo;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StoreInfo{");
    sb.append("className='").append(className).append('\'');
    sb.append(", connctionInfo=").append(connctionInfo);
    sb.append(", configInfo=").append(configInfo);
    sb.append(", metaInfo=").append(metaInfo);
    sb.append(", runtimeInfo=").append(runtimeInfo);
    sb.append('}');
    return sb.toString();
  }
}

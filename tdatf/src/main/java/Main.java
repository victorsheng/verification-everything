import com.talkingdata.sdx.atf.Clerk;
import com.talkingdata.sdx.atf.dao.TaskDao;
import com.talkingdata.sdx.atf.entity.TaskDataEntity;
import com.talkingdata.sdx.atf.entity.TaskEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ATFConf.class);
    TaskDao bean = context.getBean(TaskDao.class);
    List<TaskEntity> tasksForClerk = bean.getTasksForClerk();
    System.out.println(tasksForClerk);

    Clerk clerk = context.getBean(Clerk.class);
    TaskEntity taskEntity = new TaskEntity();
    List<TaskDataEntity> data = new ArrayList<TaskDataEntity>();
    TaskDataEntity taskDataEntity = new TaskDataEntity();
    taskDataEntity.setInPath("in");
    taskDataEntity.setOutPath("out");
    taskDataEntity.setMediaType("hhh");
    data.add(taskDataEntity);
    taskEntity.setData(data);
    String taskId = clerk.register(taskEntity);
    System.out.println(taskId);
  }

}

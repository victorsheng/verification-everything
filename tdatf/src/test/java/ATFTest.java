import static com.talkingdata.sdx.atf.entity.TaskResultEntity.State.RUNNING;

import com.talkingdata.sdx.atf.Clerk;
import com.talkingdata.sdx.atf.dao.TaskDao;
import com.talkingdata.sdx.atf.entity.TaskDataEntity;
import com.talkingdata.sdx.atf.entity.TaskEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ATFTest {

  @Test
  public void list() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ATFConf.class);
    TaskDao bean = context.getBean(TaskDao.class);
    List<TaskEntity> tasksForClerk = bean.getTasksForClerk();
    System.out.println(tasksForClerk.size());
    System.out.println(tasksForClerk);


  }

  @Test
  public void submit() throws InterruptedException {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ATFConf.class);

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

    TimeUnit.SECONDS.sleep(30);
  }

  @Test
  public void pickUp() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ATFConf.class);

    final Clerk clerk = context.getBean(Clerk.class);
    clerk.pickupTask(e -> {
      e.setStatus(RUNNING.getValue());
      System.out.println("pickUp");
      clerk.updateTaskStatus(e);
    });



  }

}

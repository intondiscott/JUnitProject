import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TODO TaskServiceTest ✓
public class TaskServiceTest {
    String taskID, taskName, taskDesc;
    TaskService ts;

    @BeforeEach
    public void init(){
        taskID = "123";
        taskName = "Chores";
        taskDesc = "Cleaning the house";
        ts = new TaskService();
        ts.addTask(taskName,taskDesc);
    }
    @Test
    @DisplayName("Test adding a task")
    public void testAddingTask(){
        ts.addTask("School Work", "Must Finish School Work Before Sunday");
        ts.addTask("Clean", "Clean Some Dishes");
        ts.listAllTasks();
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            ts.addTask("",null);
        });
    }

    @Test
    @DisplayName("Test deleting a task")
    public void testDeleteTask(){
        ts.addTask("School Work", "Must Finish School Work Before Sunday");
        ts.addTask("Clean", "Clean Some Dishes");
        ts.deleteTask("2");
        ts.listAllTasks();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           ts.deleteTask(taskID);
        });

    }

    @Test
    @DisplayName("Test updating a task")
    public void testUpdateTask(){
        ts.addTask("School Work", "Must Finish School Work Before Sunday");
        ts.addTask("Clean", "Clean Some Dishes");

        ts.updateTask("2","Updated Task", "Updated Description");
        ts.listAllTasks();
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            ts.updateTask("6", "Task", "Desc");
        });
    }


}
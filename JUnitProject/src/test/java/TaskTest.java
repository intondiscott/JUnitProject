import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//TODO TaskTest ✓
public class TaskTest {
    String taskID, taskName, taskDesc, taskIDTooLong, taskNameTooLong, taskDescTooLong;
    Task task;
    @BeforeEach
    public void init(){
        taskID = "123";
        taskName = "Chores";
        taskDesc = "Cleaning the house";
        taskIDTooLong = "12345678910";
        taskNameTooLong = "Storing Lots of characters here";
        taskDescTooLong = "Going to the store to buy eggs, milk, juice, meat, vegetables";
        task = new Task();
    }

    @Test
    @DisplayName("Test set name too long")
    public void testSetNameTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName(taskNameTooLong);
        });
    }
    @Test
    @DisplayName("Test set description too long")
    public void testSetDescTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(taskDescTooLong);
        });
    }

    @Test
    @DisplayName("Test Task Object")
    public void testTask(){
        Task t = new Task(taskID, taskName, taskDesc);
        assertEquals("123", t.getTaskID());
        assertEquals("Chores", t.getTaskName());
        assertEquals("Cleaning the house", t.getTaskDescription());
    }

    @Test
    @DisplayName("Test task ID too long")
    public void testTaskIDTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskIDTooLong, taskName, taskDesc);
        });
    }
    @Test
    @DisplayName("Test task name too long")
    public void testTaskNameTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, taskNameTooLong, taskDesc);
        });
    }
    @Test
    @DisplayName("Test task description too long")
    public void testTaskDescTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, taskName, taskDescTooLong);
        });
    }
}
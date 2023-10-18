import java.util.ArrayList;
public class TaskService {
    public ArrayList<Task> listOfTasks = new ArrayList<>();
    public String generateTaskID(){
        int i = 0;
        for(int j=i; j < listOfTasks.size(); j++){
            i++;
        }
        return String.valueOf(++i);
    }
    public void addTask(String taskName, String taskDescription){
        Task task = new Task(generateTaskID(),taskName, taskDescription);
        listOfTasks.add(task);
    }
    public void deleteTask(String taskID){
        for(Task task: listOfTasks){
            if(task.getTaskID().equals(taskID)){
                listOfTasks.remove(task);
                System.out.printf("Task with TaskID: %s has been deleted...\n%s\n", taskID, "-".repeat(100));
                break;
            }
        }
        if(listOfTasks.size() < Integer.parseInt(taskID)){
            throw new IllegalArgumentException("Task cannot be deleted because TaskID: " + taskID + " is not in list.");
        }
    }
    public void updateTask(String taskID, String taskName, String taskDescription){
        for(Task task: listOfTasks){
            if(task.getTaskID().equals(taskID)) {
                listOfTasks.set(listOfTasks.indexOf(task), new Task(taskID, taskName, taskDescription));
                System.out.printf("Task with TaskID: %s has been updated...\n%s\n", taskID, "-".repeat(100));
                break;
            }
        }
        if(listOfTasks.size() < Integer.parseInt(taskID)){
            throw new IllegalArgumentException("Task cannot be updated because TaskID: " + taskID +" is not in list");
        }

    }
    public void listAllTasks(){
        for (Task task :listOfTasks){
            System.out.println("{ " +
                    "\n\tID: " + task.getTaskID() +
                    ", \n\tTask: " + task.getTaskName() +
                    ", \n\tTask Description: " + task.getTaskDescription()+
                    "\n}" + ((listOfTasks.indexOf(task) < listOfTasks.size()-1)?",":""));
        }
    }
}

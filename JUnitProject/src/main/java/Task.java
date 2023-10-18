public class Task {
    private String taskID;
    private String taskName;
    private String taskDescription;

    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        if(taskName == null || taskName.length() > 20){
            throw new IllegalArgumentException("taskName cannot be null nor greater than twenty characters...");
        }
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        if(taskDescription == null || taskDescription.length() > 50){
            throw new IllegalArgumentException("taskDescription cannot be null nor greater than thirty characters...");
        }
        this.taskDescription = taskDescription;
    }
    public Task(){}
    public Task(String taskID, String taskName, String taskDescription){
        if(taskID == null || taskID.length() > 10){
           throw new IllegalArgumentException("taskID cannot be null nor greater than ten characters...");
        }
        if(taskName == null || taskName.length() > 20){
            throw new IllegalArgumentException("taskName cannot be null nor greater than twenty characters...");
        }
        if(taskDescription == null || taskDescription.length() > 50){
            throw new IllegalArgumentException("taskDescription cannot be null nor greater than thirty characters...");
        }
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }
}

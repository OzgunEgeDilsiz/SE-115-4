public class Task {
    private String taskName;
    private int energyCost;
    public Task(String taskName,int energyCost){
        this.taskName = taskName;
        this.energyCost = energyCost;
    }
    public String getTaskName(){
        return taskName;
    }
    public int getEnergyCost() {
        return energyCost;
    }
    public void describeTask(){
        System.out.println(taskName);
        System.out.println(energyCost);
    }
}

public class TaskBatch {
    private Task[] tasks;
    private int taskCount;

    public TaskBatch() {
        tasks = new Task[5]; // max batch size
        taskCount = 0;
    }

    public void addTask(Task t) {
        if (taskCount >= 5) {
            System.out.println("Task batch is full.");
            return;
        }
        tasks[taskCount] = t;
        taskCount++;
    }
    public int getTotalEnergyCost() {
        if (taskCount == 0) {
            System.out.println("Task batch is empty.");
            return 0;
        }
        int total = 0;
        for (int i = 0; i < taskCount; i++) {
            total += tasks[i].getEnergyCost();
        }
        return total;
    }
    public Task[] getTasks() {
        if (taskCount==0){
            System.out.println("Task batch is empty.");
        }
            return tasks;
    }
    public void printBatchInfo() {
        if (taskCount == 0) {
            System.out.println("Task batch is empty.");
            return;
        }
        for (int i = 0; i < taskCount; i++) {
            System.out.println(tasks[i].getTaskName()+ ", " + tasks[i].getEnergyCost());
        }
    }
    public int getTaskCount() {
        return taskCount;
    }
}

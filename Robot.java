public class Robot {
    private String modelName;
    private int batteryLevel;
    private String status;

    public Robot(String mN, int bL, String st) {
        modelName = mN;
        batteryLevel = bL;
        status = st;
    }

    public String getmodelName() {
        return modelName;
    }

    public int getbatteryLevel() {
        return batteryLevel;
    }

    public String getstatus() {
        return status;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayRobotInfo() {
        System.out.print(modelName+" ");
        System.out.print(batteryLevel+" ");
        System.out.println(status+" ");
    }
    public boolean isBatteryEnough(int requiredAmount) {
        return batteryLevel >= requiredAmount;
    }
    public void consumeBattery(int amount) {
        batteryLevel -= amount;
    }
    public void chargeBattery(int amount) {
        batteryLevel += amount;
        if(batteryLevel>=100){
            status = "Active";
        }
        else{
            status = "Charging";
        }
    }
    public void performTask(Task t){
        System.out.println(modelName +" is attempting this task: "+t.getTaskName());
        if("Charging".equals(status)){
            System.out.println("Robot cannot do this task at the moment.");
        }
        if(isBatteryEnough(t.getEnergyCost())){
            System.out.println("You have enough battery for this task.");
            consumeBattery(t.getEnergyCost());
            System.out.println("The task is finished.");
        }
        else{
            System.out.println("You DON'T have enough battery for this task.");
        }
    }
    public void performTaskBatch(TaskBatch tb){
        if (tb.getTaskCount() == 0) {
            System.out.println("Task batch is empty.");
            return;
        }
        System.out.println("Total cost : "+ tb.getTotalEnergyCost());
        if (isBatteryEnough(tb.getTotalEnergyCost())){
            System.out.println("You have enough energy for these tasks. Processing...");
            Task[] tasks = tb.getTasks();
            for (int i = 0; i < tb.getTaskCount(); i++) {
                Task t = tasks[i];
                performTask(t);
            }
            displayRobotInfo();
        }
        else{
            System.out.println("You DON'T have enough energy for these tasks.");
        }
    }
}
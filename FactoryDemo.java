import java.util.Scanner;
public class FactoryDemo {
    public static void main(String[] args){
        Robot r1 = new Robot("A",240,"Active");
        Robot r2 = new Robot("B",52,"Active");
        r1.displayRobotInfo();
        r2.displayRobotInfo();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the amount of battery to consume: ");
        int consumeR1= sc.nextInt();
        if(r1.isBatteryEnough(consumeR1)){
            r1.consumeBattery(consumeR1);
            System.out.println("Consumption successful.");
        }
        else{
            System.out.println("Consumption failed.");
        }
        System.out.println("Enter the amount of battery to consume: ");
        int consumeR2= sc.nextInt();
        if(r2.isBatteryEnough(consumeR2)){
            r2.consumeBattery(consumeR2);
            System.out.println("Consumption successful.");
        }
        else{
            System.out.println("Consumption failed.");
        }
        r1.displayRobotInfo();
        r2.displayRobotInfo();
        Task t1= new Task("Cooking",30);
        Task t2= new Task("Cleaning",40);
        if(r1.isBatteryEnough(t1.getEnergyCost())){
            System.out.println("You have enough battery to do this task.");
        }
        else{
            System.out.println("You DON'T have enough battery to do this task.");
        }
        r1.performTask(t1);
        r2.performTask(t2);
        r1.displayRobotInfo();
        r2.displayRobotInfo();

        Task t3= new Task("Walking",20);
        Task t4= new Task("Shopping",45);
        TaskBatch tb = new TaskBatch();
        tb.addTask(t1);
        tb.addTask(t2);
        tb.addTask(t3);
        tb.addTask(t4);
        tb.printBatchInfo();
        System.out.println("Total energy cost: "+ tb.getTotalEnergyCost());

        r1.displayRobotInfo();
        r1.performTaskBatch(tb);
        r1.displayRobotInfo();
    }
}

// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};

    static int[][][] profits = new int[MONTHS][DAYS][COMMS];

    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {
    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {
        if (month<0 || month>=MONTHS){
            return "INVALID_MONTH";
        }
        int bestCommsIndex=0;
        int bestCommsProfit=0;
        for (int i=0;i<COMMS;i++){
            int sum=0;
            for (int j=0;j<DAYS;j++) {
                sum += profits[month][j][i];
            }
            if(i==0||sum>bestCommsProfit){
                    bestCommsProfit=sum;
                    bestCommsIndex=i;
            }
        }
        return commodities[bestCommsIndex]+" "+bestCommsProfit;
    }

    public static int totalProfitOnDay(int month, int day) {
        if (month<0 || month>=MONTHS || day<1 || day>DAYS){
            return -99999;
        }
        int totalprofit = 0;
        for (int i=0;i<COMMS;i++) {
            totalprofit += profits[month][day - 1][i];
        }
        return totalprofit;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        if(from>to || from<1 || to>DAYS){
            return -99999;
        }
        int comm =-1;
        for(int i=0;i<COMMS;i++){
            if (commodities[i].equals(commodity)){
                comm = i;
            }
        }
        if (comm==-1){
            return -99999;
        }
        int totalProfit=0;
        for (int i=0;i<MONTHS;i++){
            for (int f=from;f<=to;f++){
                totalProfit+=profits[i][f-1][comm];
            }
        }
        return totalProfit;
    }

    public static int bestDayOfMonth(int month) {
        if (month<0 || month>=MONTHS){
            return -1;
        }
        int bestDay = 1;
        int mostProfit = totalProfitOnDay(0,1);
        for (int day =2;day <=DAYS;day++) {
            int dailyProfit = totalProfitOnDay(month, day);
            if (dailyProfit>mostProfit){
                mostProfit = dailyProfit;
                bestDay = day;
            }
        }
        return bestDay;
    }

    public static String bestMonthForCommodity(String comm) {
        return "DUMMY";
    }

    public static int consecutiveLossDays(String comm) {
        return 1234;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        int commodity =-1;
        for(int i=0;i<COMMS;i++){
            if (commodities[i].equals(comm)){
                commodity = i;
            }
        }
        if (commodity==-1){
            return -1;
        }
        int thresholdCount=0;
        for (int i=0;i<MONTHS;i++){
            for (int j=0;j<DAYS;j++){
                if (profits[i][j][commodity]>threshold){
                    thresholdCount++;
                }
            }
        }
        return thresholdCount;
    }

    public static int biggestDailySwing(int month) {
        if (month<0 || month>=MONTHS){
            return -99999;
        }
        int biggestSwing=0;
        for (int i=0;i<DAYS-1;i++) {
            int today=0;
            int tomorrow=0;
            for (int j = 0; j < COMMS; j++) {
                today += profits[month][i][j];
                tomorrow += profits[month][i + 1][j];
            }
                int absolute=Math.abs(today-tomorrow);
                if (absolute>biggestSwing){
                    biggestSwing=absolute;
                }
        }
        return biggestSwing;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        int c1index=-1;
        int c2index=-1;
        for (int i=0;i<COMMS;i++){
            if (commodities[i].equals(c1)){
                c1index=i;
            }
            if (commodities[i].equals(c2)){
                c2index=i;
            }
        }
        if (c1index==-1 || c2index==-1){
            return "INVALID_COMMODITY";
        }
        int c1profit=0;
        int c2profit=0;
        for (int i=0;i<MONTHS;i++){
            for (int j=0;j<DAYS;j++){
                c1profit+=profits[i][j][c1index];
                c2profit+=profits[i][j][c2index];
            }
        }
        if (c1profit>c2profit){
            return c1+" is better by "+(c1profit-c2profit);
        }
        else if (c2profit>c1profit){
            return c2+" is better by "+(c2profit-c1profit);
        }
        else{
            return "Equal";
        }
    }

    public static String bestWeekOfMonth(int month) {
        return "DUMMY";
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}

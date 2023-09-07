package App; 

public class Main {
    public static void main(String[] args) {
        DB_Model.prepareeDB_Tables();
        //MeasuringAchievementStandardServices.serviceGuid();
        TrakingDailyServeice.trackingProccess();
    }

    public static void quit(String input)
    {
       
        if(input.equals("quit"))
        {
            System.out.println("Yow will exist from the app...");
            System.exit(0);
        }
    }
}

package App;

import java.util.Scanner;

public class Main {
    private static Scanner mainAppScanner = new Scanner(System.in);
    public static void main(String[] args) {
        DB_Model.prepareeDB_Tables();
        while(true)
        {
            String choosenService = startWindow();
            quit(choosenService);
            
            switch(choosenService)
            {
                case "1":
                    MeasuringAchievementStandardServices.serviceGuid();
                    break;
                case "2":
                    TrackingDailyServeice.trackingProccess();
                    break;
                case "3":
                    AnalysesServiece.servicesGuid();
                    break;
                case "../":
                    quit("quit");
                    break;
                default:
                    System.out.println("Please add a number for exist service.");
            }

        }
    }

    public static void quit(String input)
    {
       
        if(input.equals("quit"))
        {
            System.out.println("Yow will exist from the app...");
            System.exit(0);
        }
    }

    private static String startWindow()
    {
        System.out.println("\nHi, I'm tracked achievements app. here you can: record your standards achivements,\n"+
                                "And track them daily. Also with me you can get analytics for all of your achievements.\n"+
                                "In any step of the programm you can print '../' to go back, and 'quit' to exist from the app.\n");
            System.out.println("====================================\n"+
                                "The services that I offer for you:\n"+
                                "1. Measuring Achievement Standard Servieces.\n"+
                                "2. Tracking Daily Serice.\n"+
                                "3. Analyses Services.\n");
            System.out.print("Add the number of service(Note: if you don't know how to use the app start from 1->3): ");
            String choosenService = mainAppScanner.next();
            return choosenService;
    }
}

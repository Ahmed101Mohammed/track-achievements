package App;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class MeasuringAchievementStandardServices {
    public static void serviceGuid()
    {
        Scanner serviceScanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("\nHi, here you can: ");
            System.out.println("1. Add New Measuring Achievement Standard.");
            System.out.println("2. See All Measuring Achievements Standards.");
            System.out.print("Enter the number of service that you want: ");
            String serviceNumber = serviceScanner.next();
            Main.quit(serviceNumber);
            if(serviceNumber.equals("../"))
            {
                break;
            }
            else if(serviceNumber.equals("1"))
            {
                addNewMeasuringAchievementStandard();
            }
            else if (serviceNumber.equals("2"))
            {
                seeAllMeasuringAchievementsStandards();
            }
            else
            {
                System.out.println("May you didn't write exist number service or you write any thing not a number.");
            }
        }
    }

    private static void addNewMeasuringAchievementStandard()
    {
        for(int i = 0; i < 1; i++)
        {
            String title = modernScannerWithExting("\nEnter the title of your new Achivement Standard: ");
            if(title.equals("../")){break;}
            String question = modernScannerWithExting("Enter the question that I will ask you when you add your achievement: ");
            if(question.equals("../")){break;}
            String symbol = modernScannerWithExting("Enter the symbol of you achievement (symbols like: pages km kg h ..etc): ");
            if(symbol.equals("../")){break;}

            MeasuringAchievementStandard newStandard = new MeasuringAchievementStandard(title, question, symbol);
            DB_Model.addNewMeasuringAchievementStandard(newStandard);
        }
    }

    private static String modernScannerWithExting(String question)
    {
        Scanner addNewScanner = new Scanner(System.in);
        System.out.print(question);
        String answer = addNewScanner.nextLine();
        Main.quit(answer);
        return answer;
    }

    private static void seeAllMeasuringAchievementsStandards()
    {
        System.out.println("\n");
        ArrayList<MeasuringAchievementStandard> allStandards = DB_Model.getAllMeasuringAchievemntsStandards();
        if(allStandards.isEmpty())
        {
            System.out.println("You have not any Measuring Achievement Standard.");
        }
        else
        {
            for(int i = 0; i < allStandards.size(); i++)
            {
                MeasuringAchievementStandard item = allStandards.get(i);
                System.out.println("- Title: "+item.getTitle()+", Question: "+item.getDailyTrackingQuestionSentence()+", Symbol: "+item.getMeasureStandardSymbol()+".\n");
            }
        }
    }
    
}

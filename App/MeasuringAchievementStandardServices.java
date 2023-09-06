package App;
import java.util.Scanner;
public abstract class MeasuringAchievementStandardServices {
    public static void serviceGuid()
    {
        Scanner serviceScanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("In any step of measuring achivement standard services you can write 'mas' to return here.");
            System.out.println("1. Add New Measuring Achievement Standard.");
            System.out.println("2. See All Measuring Achievements Standards.");
            System.out.println("Enter the number of service: ");
            String serviceNumber = serviceScanner.next();
            if(serviceNumber == "1")
            {
                addNewMeasuringAchievementStandard();
            }
            else if (serviceNumber == "2")
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
        
    }
}

package App;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.time.LocalDate;

public abstract class TrakingDailyServeice {
    private static ArrayList<Achievement> achievements = new ArrayList<Achievement>();

    public static void trackingProccess()
    {
        System.out.println("\nHi, here where you should be every end of day, to add your progress in your life.");
        ArrayList<MeasuringAchievementStandard> allStandards = DB_Model.getAllMeasuringAchievemntsStandards();
        String today = convetToDayToString();
        int counter = -1;
        for(int i = 0; i < allStandards.size(); i++)
        {
            MeasuringAchievementStandard item = allStandards.get(i);
            String title = item.getTitle();
            String question = item.getDailyTrackingQuestionSentence();
            String symbol = item.getMeasureStandardSymbol();
            double progress = modernScannerWithExting(question);
            if(progress == -1.1){break;}
            Achievement newAchievement = new Achievement(title, question, symbol, today, progress);
            achievements.add(newAchievement);
            counter = i;
        }

        if(allStandards.size()-1 == counter)
        {
            addNewAchievements();
        }
        else if (counter == -1)
        {
            System.out.println("Please first add you Measuring Achievements Standards then come here.");
        }

    }

    private static void addNewAchievements()
    {
        for(int i = 0; i < achievements.size(); i++)
        {
            DB_Model.addNewAchievement(achievements.get(i));
        }
    }

    private static double modernScannerWithExting(String question)
    {
        Scanner addNewScanner = new Scanner(System.in);
        double newAnswer;
        while(true)
        {
            System.out.print(question);
            String answer = addNewScanner.next();
            Main.quit(answer);
            if(answer.equals("../")){return -1.1;}
            try
            {
                newAnswer = Double.parseDouble(answer);
                if(newAnswer < 0.0)
                {
                    System.out.println("Please, Enter positive number.");
                }
                break;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter real number for your progress not string.");
                continue;
            }
        }
        return newAnswer;
    }

    private static String convetToDayToString()
    {
        LocalDate toDay = LocalDate.now();
        String toDayString = Integer.toString(toDay.getYear()) + "/" + Integer.toString(toDay.getMonthValue()) + "/" + Integer.toString(toDay.getDayOfMonth());
        return toDayString;
    }

}

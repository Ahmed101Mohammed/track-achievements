package App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public abstract class AnalysesServiece {
    private static HashSet<String> validString = new HashSet<String>(
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "/"));
    private static String[] services = {"Custom time period analystics service.", "Last year analytics service.", "Last month analytics service.",
                                    "Last week analytics service.", "Last day analytics service."};
    public static void servicesGuid()
    {
        while(true)
        {
            System.out.println("\nHere we have several analytics services:");
            for(int i = 0; i < services.length; i++)
            {
                System.out.println((i+1)+". "+services[i]);
            }
            Scanner analyticScanner = new Scanner(System.in);
            System.out.print("Enter service number that you want: ");
            String serviceNum = analyticScanner.next();
            Main.quit(serviceNum);
            if(serviceNum.equals("../")){break;}
            getService(serviceNum);
        }
    }

    private static void getService(String numInString)
    {
        switch(numInString)
        {
            case "1":
                customTimePeriodAnalyticsService();
                break;
            case "2":
                lastYearAnalyticsService();
                break;
            case "3":
                lastMonthAnalyticsService();
                break;
            case "4":
                lastWeekAnalyticsService();
                break;
            case "5":
                lastDayAnalyticsService();
                break;
            default:
                System.out.println("Please enter number of exist service.");
        }

    }

    private static void customTimePeriodAnalyticsService()
    {
        System.out.println("\nHere you detrmine two real dates, to give you the sum and avrage of your achievements.");
        while(true)
        {
            String date1 = getDate("Enter start date of the period: ");
            if(date1.equals("back")){break;}
            String date2 = getDate("Enter end date of the period: ");
            if(date2.equals("back")){break;}
            getSumAndAvrageForAchievemetnsBetweenTwoDates(date1, date2);
            break;
        }
    }

    private static String getDate(String question)
    {
        while(true)
        {
            String date = modernScannerWithExting(question);
            Main.quit(date);
            if(date.equals("../")){return "back";}
            if(! isDateInLegalForm(date))
            {
                System.out.println("Please use this form for adding dates): YYYY/MM/DD Like 2000/1/1");
                continue;
            }
            String[] yearMonthDay = yearMonthDay(date);

            if(! eachStringHasChar(yearMonthDay))
            {
                System.out.println("Please add an number after each '/'.");
                continue;
            }
            else if(! isRealDate(yearMonthDay))
            {
                System.out.println("Please add real date.");
                continue;
            }
            return date;
        }
    }

    private static String modernScannerWithExting(String question)
    {
        Scanner addNewScanner = new Scanner(System.in);
        System.out.print(question);
        String answer = addNewScanner.next();
        Main.quit(answer);
        return answer;
    }

    private static boolean isDateInLegalForm(String date)
    {
        int count_backSlach = 0;
        for (String ch:date.split(""))
        {
            boolean isExist = validString.contains(ch);
            if(! isExist)
            {
                return false;
            }

            if(isExist && ch.equals("/"))
            {
                count_backSlach += 1;
            }
        }

        if(count_backSlach == 2)
        {
            return true;
        }
        return false;
    }

    private static boolean isRealDate(String[] YearMonthDay)
    {
        int year = Integer.parseInt(YearMonthDay[0]);
        int month = Integer.parseInt(YearMonthDay[1]);
        int day = Integer.parseInt(YearMonthDay[2]);

        int monthRange = 12;
        int[] daysRange = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(year))
        {
            daysRange[1] = 29; 
        }

        if (year > 0 && (month > 0 && month <= monthRange) && (day > 0 && day <= daysRange[month-1]))
        {
            return true;
        }
        return false;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean eachStringHasChar(String[] list)
        {
            for(String item:list)
            {
                if(item.length() == 0)
                {
                    return false;
                }
            }
            return true;
        }

    private static String[] yearMonthDay(String dateInValidForm)
        {
            int count_backSlach = 0;
            String[] year_month_day = {"","",""};
            for(String chr:dateInValidForm.split(""))
            {
                if(chr.equals("/"))
                {
                    count_backSlach += 1;
                }
                else if(count_backSlach == 0)
                {
                    year_month_day[0] = year_month_day[0] + chr;
                }
                else if(count_backSlach == 1)
                {
                    year_month_day[1] = year_month_day[1] + chr;
                }
                else
                {
                    year_month_day[2] = year_month_day[2] + chr;
                }
            }
    
            if(eachStringHasChar(year_month_day))
            {
                return year_month_day;
            }
            {
                String[] empty = {};
                return empty;
            }
        }
    
        private static void getSumAndAvrageForAchievemetnsBetweenTwoDates(String date1, String date2)
        {
            ArrayList<MeasuringAchievementStandard> standards = DB_Model.getAllMeasuringAchievemntsStandards();
            if(standards.size() == 0)
            {
                System.out.println("You does not have any Measuring Achievement Standard. Add one please.");
            }
            else
            {
                printTheAnalaticsResults(standards, date1, date2);
            }
        }

        private static void printTheAnalaticsResults(ArrayList<MeasuringAchievementStandard> standards, String date1, String date2)
        {
            String anlyticses = "\nThese is your achievements in you specific period: ";
            for(int i = 0; i < standards.size(); i++)
            {
                MeasuringAchievementStandard standard = standards.get(i);
                double sum = DB_Model.getProgressesAvrageOfAchievementsOfAnMeasuringAchievementStandardOnSpecificTiemPeriod(standard.getTitle(), date1, date2);
                double avrage = DB_Model.getProgressesAvrageOfAchievementsOfAnMeasuringAchievementStandardOnSpecificTiemPeriod(standard.getTitle(), date1, date2);
                anlyticses += "\nAchievement Title: "+ standard.getTitle() + "\tYour Achievements Total: " + sum + " " + standard.getMeasureStandardSymbol()
                                + "\tYour Achievements Avarage: " + avrage + " " + standard.getMeasureStandardSymbol();
            }
            System.out.println(anlyticses);
        }

}

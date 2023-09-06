package App;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public abstract class DB_Model {
    private static Connection connectref;
    private static String path = "jdbc:sqlite:achievements.db";

    public static boolean prepareeDB_Tables()
    {
        if(connect())
        {
            String[] appTables = new String[2];
            appTables[0] = "CREATE TABLE IF NOT EXISTS measuring_achievement_standard (\n"
            +  "    id INTEGER PRIMARY KEY NOT NULL,\n"
            +  "    title TEXT NOT NULL,\n"
            +  "    daily_tracking_question_sentence TEXT NOT NULL,\n"
            +  "    measure_standard_symbol TEXT NOT NULL);";

            appTables[1] = "CREATE TABLE IF NOT EXISTS achievement (\n"
            +  "    id INTEGER PRIMARY KEY NOT NULL,\n"
            +  "    measuring_achievement_standard_id INTEGER NOT NULL,\n"
            +  "    date TEXT NOT NULL,\n"
            +  "    date_value INTEGER NOT NULL,\n"
            +  "    progress_value INTEGER NOT NULL);";
            if(createTablesInDB(appTables))
            {
                return true;
            }
            return false;
        }
        else
        {
           System.out.println("Connection field."); 
           return false;
        }
    }

    public static void addNewMeasuringAchievementStandard(MeasuringAchievementStandard newMeasuringAchievementStandard)
    {
        if (getMeasuringAchievementStandardId(newMeasuringAchievementStandard.getTitle()) == -1)
        {
            addNewMeasuringAchievementStandardToDB(newMeasuringAchievementStandard);
        }
        else
        {
            System.out.println("Sorry your Measuring Achievement Standard '" + newMeasuringAchievementStandard.getTitle() + "' is already exist.\n Or there is some error in Data Base.");
        }
    }

    public static ArrayList<MeasuringAchievementStandard> getAllMeasuringAchievemntsStandards()
    {
        String getAllQuerry = "SELECT title, daily_tracking_question_sentence, measure_standard_symbol FROM measuring_achievement_standard;";
        try
        {
            Statement getAll = connectref.createStatement();
            ResultSet results = getAll.executeQuery(getAllQuerry);
            return convertResultSetOfMeasuringAchievementsStandardsToArrrayList(results);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            ArrayList<MeasuringAchievementStandard> empty = new ArrayList<MeasuringAchievementStandard>();
            return empty;
        }
    }

    public static void addNewAchievement(Achievement newAchievement)
    {
        String insertQuery = "INSERT INTO achievement(measuring_achievement_standard_id, date, date_value, progress_value) VALUES(?,?,?,?);";
        int measuringAchievementStandardId = getMeasuringAchievementStandardId(newAchievement.getTitle());
        try
        {
            PreparedStatement insert = connectref.prepareStatement(insertQuery);
            insert.setInt(1, measuringAchievementStandardId);
            insert.setString(2, newAchievement.getDate());
            insert.setInt(3, convertDateToInt(newAchievement.getDate()));
            insert.setInt(4, newAchievement.getProgressValue());
            insert.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to save your new Achievement.");
        }
    }

    public int getProgressesSumOfAchievementsOfAnMeasuringAchievementStandardOnSpecificTiemPeriod(String standardTitle, String date1, String date2)
    {
        String query = "SELECT SUM(progressValue) AS total_progress_values FROM achievement WHERE date_value BETWEEN " + convertDateToInt(date1) 
                        + " AND "+convertDateToInt(date2)+" OR date_value BETWEEN "+ convertDateToInt(date2) +" AND "+convertDateToInt(date1)+";";
        try
        {
            Statement getSum = connectref.createStatement();
            ResultSet result = getSum.executeQuery(query);
            if(result.next())
            {
                return result.getInt("total_progress_values");
            }
            else
            {
                return -1;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int getProgressesAvrageOfAchievementsOfAnMeasuringAchievementStandardOnSpecificTiemPeriod(String standardTitle, String date1, String date2)
    {
        String query = "SELECT AVG(progressValue) AS avrage_progress_values FROM achievement WHERE date_value BETWEEN " + convertDateToInt(date1) 
                        + " AND "+convertDateToInt(date2)+" OR date_value BETWEEN "+ convertDateToInt(date2) +" AND "+convertDateToInt(date1)+";";
        try
        {
            Statement getSum = connectref.createStatement();
            ResultSet result = getSum.executeQuery(query);
            if(result.next())
            {
                return result.getInt("avrage_progress_values");
            }
            else
            {
                return -1;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int getProgressesSumOfAllAchievemetns()
    {
        String query = "SELECT SUM(progressValue) AS total_progress_values FROM achievement;";
        try
        {
            Statement getSum = connectref.createStatement();
            ResultSet result = getSum.executeQuery(query);
            if(result.next())
            {
                return result.getInt("total_progress_values");
            }
            else
            {
                return -1;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int getProgressesAvrageOfAllAchievemetns()
    {
        String query = "SELECT AVG(progressValue) AS avrage_progress_values FROM achievement;";
        try
        {
            Statement getSum = connectref.createStatement();
            ResultSet result = getSum.executeQuery(query);
            if(result.next())
            {
                return result.getInt("avrage_progress_values");
            }
            else
            {
                return -1;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    

    private static boolean connect()
    {
        try
        {
            connectref = DriverManager.getConnection(path);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static boolean createTablesInDB(String[] tablesCreationQueries)
    {
        try
        {
            Statement creteTableStatement = connectref.createStatement();
            creteTableStatement.execute(tablesCreationQueries[0]);
            creteTableStatement.execute(tablesCreationQueries[1]);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to Create project DB tables.");
            return false;
        }
    }
    
    private static void addNewMeasuringAchievementStandardToDB(MeasuringAchievementStandard newMeasuringAchievementStandard)
    {
        String insertQuery = "INSERT INTO measuring_achievement_standard(title, daily_tracking_question_sentence, measure_standard_symbol) VALUES(?,?,?);";
        try
        {
            PreparedStatement insert = connectref.prepareStatement(insertQuery);
            insert.setString(1, newMeasuringAchievementStandard.getTitle());
            insert.setString(2, newMeasuringAchievementStandard.getDailyTrackingQuestionSentence());
            insert.setString(3, newMeasuringAchievementStandard.getMeasureStandardSymbol());
            insert.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to save your new Measuring Achievement Stndard.");
        }
    }

    private static int getMeasuringAchievementStandardId (String mesuringAchievementStandardTitle)
    {
        String findQuery = "SELECT id FROM measuring_achievement_standard WHERE title LIKE \""+ mesuringAchievementStandardTitle +"\";";
        try
        {
            Statement findStatement = connectref.createStatement();
            ResultSet result = findStatement.executeQuery(findQuery);
            if(result.next())
            {
                return result.getInt("id");
            }
            return -1;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private static int convertDateToInt(String date)
    {
        String dateInStringStandard = convertDateToStandardFormate(date);
        return Integer.parseInt(dateInStringStandard);
    }

    private static String convertDateToStandardFormate(String date)
    {
        String[] yearMonthDay = yearMonthDay(date);
        modifyYearMonthDayFormate(yearMonthDay);
        return yearMonthDay[0]+yearMonthDay[1]+yearMonthDay[2];
    }

    private static void modifyYearMonthDayFormate(String[] yearMonthDay)
    {
        for (int i = 1; i < yearMonthDay.length; i++)
        {
            yearMonthDay[i] = addZeroStringForOneLenghtString(yearMonthDay[i]);
        }
    }

    private static String addZeroStringForOneLenghtString(String string)
    {
        if (string.length() == 1)
        {
            return "0" + string;
        }
        return string;
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

    private static ArrayList<MeasuringAchievementStandard> convertResultSetOfMeasuringAchievementsStandardsToArrrayList(ResultSet setOfMeasuringAchievementsStandards)
    {
        ArrayList<MeasuringAchievementStandard> resultsInArrayListForm = new ArrayList<MeasuringAchievementStandard>();
        try
        {
            while(setOfMeasuringAchievementsStandards.next())
            {
                String title = setOfMeasuringAchievementsStandards.getString("title");
                String dailyTrackingQuestionSentence = setOfMeasuringAchievementsStandards.getString("daily_tracking_question_sentence");
                String measureStandardSymbol = setOfMeasuringAchievementsStandards.getString("measure_standard_symbol");
                MeasuringAchievementStandard newMember = new MeasuringAchievementStandard(title, dailyTrackingQuestionSentence, measureStandardSymbol);
                resultsInArrayListForm.add(newMember);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return resultsInArrayListForm;
    }
    
}

package App;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public abstract class DB_Model {
    private static Connection connectref;
    private static String path = "jdbc:sqlite:achievemetns.db";

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

    public static boolean prepareeDB_Tables()
    {
        if(connect())
        {
            String[] appTables = new String[2];
            appTables[0] = "CREATE TABLE IF NOT EXISTS measuring_achievement_standard (\n"
            +  "    id INTEGER PRIMARY KEY NOT NULL,\n"
            +  "    title TEXT NOT NULL,\n"
            +  "    daily_tracking_question_sentence TEXT NOT NULL,\n"
            +  "    measure_Standard_Symbol TEXT NOT NULL);";

            appTables[1] = "CREATE TABLE IF NOT EXISTS achievement (\n"
            +  "    id INTEGER PRIMARY KEY NOT NULL,\n"
            +  "    measuring_achievement_standard_id INTEGER NOT NULL,\n"
            +  "    date TEXT NOT NULL,\n"
            +  "    date_value INTEGER NOT NULL,\n"
            +  "    progressValue INTEGER NOT NULL);";
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
            System.out.println("Field to Create project DB tables.");
            return false;
        }
    }    
}

package App; 

public class Main {
    public static void main(String[] args) {
        DB_Model.prepareeDB_Tables();
        MeasuringAchievementStandard newOne = new MeasuringAchievementStandard("Reading Books", "How much pages you readed to day? ", "page(s)");
        Achievement newAch = new Achievement("Reading Books", "How much pages you readed to day? ", "page(s)", "2023/9/6", 2);
        DB_Model.addNewMeasuringAchievementStandard(newOne);
        DB_Model.addNewAchievement(newAch);
        System.out.println(DB_Model.getAllMeasuringAchievemntsStandards());
    }
}

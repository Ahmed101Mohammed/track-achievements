package App;

public class Achievement extends MeasuringAchievementStandard
{
    private String date;
    private int progressValue;

    public Achievement(String title, String dailyTrackingQuestionSentence, String measureStandardSymbol ,String date, int progress)
    {
        super(title, dailyTrackingQuestionSentence, measureStandardSymbol);
        this.date = date;
        this.progressValue = progress;
    }

    public String getDate()
    {
        return this.date;
    }

    public int getProgressValue()
    {
        return this.progressValue;
    }
}

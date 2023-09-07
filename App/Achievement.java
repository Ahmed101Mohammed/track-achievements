package App;

public class Achievement extends MeasuringAchievementStandard
{
    private String date;
    private double progressValue;

    public Achievement(String title, String dailyTrackingQuestionSentence, String measureStandardSymbol ,String date, double progress)
    {
        super(title, dailyTrackingQuestionSentence, measureStandardSymbol);
        this.date = date;
        this.progressValue = progress;
    }

    public String getDate()
    {
        return this.date;
    }

    public double getProgressValue()
    {
        return this.progressValue;
    }

}

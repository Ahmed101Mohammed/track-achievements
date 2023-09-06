package App;

public class MeasuringAchievementStandard {
    protected String title;
    protected String dailyTrackingQuestionSentence;
    protected String measureStandardSymbol;

    public MeasuringAchievementStandard(String title, String dailyTrackingQuestionSentence, String measureStandardSymbol)
    {
        this.title = title;
        this.dailyTrackingQuestionSentence = dailyTrackingQuestionSentence;
        this.measureStandardSymbol = measureStandardSymbol;
    }

    public String getTitle()
    {
        return this.title;
    } 

    public String getDailyTrackingQuestionSentence()
    {
        return this.dailyTrackingQuestionSentence;
    }

    public String getMeasureStandardSymbol()
    {
        return this.measureStandardSymbol;
    }
}

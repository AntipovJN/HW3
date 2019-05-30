public class SpamAnalyzer extends KeywordAnalyzer  {

    private String[] keywords;
    private  Label label = Label.SPAM;



    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    public String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }

}

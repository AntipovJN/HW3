public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords = new String[]{":(", "=(", ":|"};
    private  Label label = Label.NEGATIVE_TEXT;



    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }
}

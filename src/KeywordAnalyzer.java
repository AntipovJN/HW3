public abstract class KeywordAnalyzer implements TextAnalyzer{
    private String[] keywords;
    private Label label;

    public  Label processText(String text) {
        for (int j = 0; j < getKeywords().length; j++) {
            if (text.contains(getKeywords()[j])) {
                return getLabel();
            }
        }
        return Label.OK;
    };
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();
}

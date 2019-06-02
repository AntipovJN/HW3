public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
    Label OK = Label.OK;
    Label TO_LONG = Label.TOO_LONG;

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return TO_LONG;
        }
        return OK;
    }

    public TooLongTextAnalyzer(int length) {
        this.maxLength = length;
    }

    public int getMaxLenght() {
        return maxLength;
    }
    public void setMaxLenght(int newMaxLength) {
        this.maxLength = maxLength;
    }

}

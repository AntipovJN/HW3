public class AsciiCharSequence implements CharSequence {
    private byte[] charArray;

    public AsciiCharSequence(byte[] charArray) {
        this.charArray = charArray.clone();
    }

    @Override
    public int length() {
        return charArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char) charArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (end > start) {
            int j = start;
            byte[] charSequence = new byte[end - start];
            for (int i = 0; i < end - start; i++, j++) {
                charSequence[i] = this.charArray[j];
            }
            return new AsciiCharSequence(charSequence);
        } else {
            System.out.println("invalid indexes");
            return new AsciiCharSequence(this.charArray);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b : charArray) {
            sb.append((char) b);
        }
        return sb.toString();
    }
}

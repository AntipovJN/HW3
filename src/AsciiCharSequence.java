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
        byte[] charSequence = new byte[end - start];
        for(int i = 0; i < end - start; i++, start++) {
            charSequence[i] = this.charArray[start];
        }
        return  new AsciiCharSequence(charSequence);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b: charArray) {
            sb.append((char) b);
        }
        return sb.toString();

        }
}

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber complexNumber = (ComplexNumber) o;
        return Double.compare(complexNumber.getRe(), this.re) == 0 && Double.compare(complexNumber.getIm(), this.im) == 0;
    }
    public int hashCode() {
        int result=0;
        int temp = Double.hashCode(re);
        result = 31 * temp * (temp - 31) + result;
        temp = Double.hashCode(im);
        result = 31 * temp * (temp - 31) + result;
        return result;


    }
    
}
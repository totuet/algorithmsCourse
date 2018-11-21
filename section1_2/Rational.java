package section1_2;
/*
Rational numbers. Implement an immutable data type Rational for rational
numbers that supports addition, subtraction, multiplication, and division.
 */

public class Rational {
    private long numerator;
    private long denominator;

    public Rational(long num, long den) {
        long gcd = calculateCommonDivisor(num, den);
        if (gcd != 1) {
            num = num / gcd;
            den = den / gcd;
        }
        if (den < 0) {
            this.numerator = -num;
            this.denominator = -den;
        }
        if (den != 0) {
            this.numerator = num;
            this.denominator = den;

        } else throw new IllegalArgumentException("Denominator cannot be zero");

    }
    public Rational plus(Rational b) {
        long newNum = this.numerator * b.getDenominator() + this.denominator + b.getNumerator();
        long newDen = this.denominator * b.getDenominator();
        return new Rational(newNum, newDen);

    }

    public Rational minus(Rational b) {
        long newNum = this.numerator * b.getDenominator() - this.denominator + b.getNumerator();
        long newDen = this.denominator * b.getDenominator();
        return new Rational(newNum, newDen);
    }

    public Rational times(Rational b) {
        long newNum = this.numerator * b.getNumerator();
        long newDen = this.denominator * b.getDenominator();
        return new Rational(newNum, newDen);
    }

    public Rational divides(Rational b) {
        long newNum = this.numerator * b.getDenominator();
        long newDen = this.denominator * b.getNumerator();
        return new Rational(newNum, newDen);
    }

    public boolean equals(Rational b) {
        if (this.numerator == b.getNumerator() && this.denominator == b.getDenominator()) return true;
        else return false;
    }


    private long calculateCommonDivisor(long num, long den) {
        if (den == 0) return num;
        long r = num % den;
        return calculateCommonDivisor(den,r);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return "Rational{" +
                numerator + "/"
                 + denominator +
                '}';
    }

    public static void main(String[] args) {
        try {

            Rational rat1 = new Rational(10,4);
            Rational rat2 = new Rational(10638,421);
            Rational rat3 = new Rational(10,9);
            Rational rat4 = new Rational(10,10);
            System.out.println(rat1.plus(rat2));
            System.out.println(rat2.times(rat3));
            System.out.println(rat3.minus(rat4));
            System.out.println(rat4.divides(rat1));
            System.out.println(rat4.getDenominator());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}

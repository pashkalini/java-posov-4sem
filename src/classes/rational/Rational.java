package classes.rational;

import java.math.BigInteger;

import static java.lang.StrictMath.abs;

public class Rational {
    //поля
    private long n; //numerator - числитель
    private long d; //denominator - знаменатель
    public final static Rational ONE = new Rational(1);
    public final static Rational ZERO = new Rational(0);

    //конструкторы
    public static int gcd(long n, long d) {
        BigInteger b1 = BigInteger.valueOf(n);
        BigInteger b2 = BigInteger.valueOf(d);
        BigInteger gcd = b1.gcd(b2); //Greatest Common Divisor

        return gcd.intValue();
    }

    private void normalize(long n, long d) {
        if (d < 0) {
            this.d = abs(d);
            this.n = -n;
        }

        int igcd = gcd(n, d);

        if (igcd != 0) {
            this.n = n / igcd;
            this.d = d / igcd;
        } else {
            this.n = n;
            this.d = d;
        }
    }

    public Rational(long n, long d) {
        normalize(n, d);
    }

    public Rational(long n) {
        this.n = n;
        this.d = 1;
    }

    //методы
    public long getN() {
        return n;
    }

    public long getD() {
        return d;
    }

    public String toString() {
        if (d == 1)
            return String.valueOf(n);
        else if (n == 0)
            return "0";
        else
            return (n + "/" + d);
    }

    public double toDouble() {
        return (double) this.n / this.d;
    }


    public Rational add(Rational r) {
        return new Rational(n * r.d + d * r.n, d * r.d);
    }

    public static Rational staticAdd(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d + r1.d * r2.n, r1.d * r2.d);
    }

    public void addInPlace(Rational r) {
        this.n = n * r.d + d * r.n;
        this.d = d * r.d;

        normalize(this.n, this.d);
    }


    public Rational sub(Rational r) {
        return new Rational(n * r.d - d * r.n, d * r.d);
    }

    public static Rational staticSub(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d - r1.d * r2.n, r1.d * r2.d);
    }


    public Rational mul(Rational r) {
        return new Rational(n * r.n, d * r.d);
    }

    public static Rational staticMul(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.n, r1.d * r2.d);
    }


    public Rational div(Rational r) {
        return new Rational(n * r.d, d * r.n);
    }

    public static Rational staticDiv(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d, r1.d * r2.n);
    }

}

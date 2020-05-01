package classes.rational;

import classes.rational.Rational;

public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(4, 6);
        //System.out.println("r1 to string: " + r1.toString());
        System.out.println("r1 to double: " + r1.toDouble());

        Rational r2 = new Rational(3);
        System.out.println("r2 to double: " + r2.toDouble());
        //System.out.println("r2 to string: " + r2.toString());

        Rational r3 = new Rational(0);
        //System.out.println("r3 to string: " + r3.toString());

        Rational r4 = new Rational(1, 6);
        System.out.println("r4 to double: " + r4.toDouble());

        Rational r5 = new Rational(7, 9);
        //System.out.println("r5 to string: " + r5.toString());

        Rational r6 = new Rational(1, 3);
        Rational r7 = r4.add(r6);
        System.out.println(r4 + "(r4)" + " + " + r6 + "(r6)" + " = " + r7);

        r4.addInPlace(r6);
        System.out.println(r4);

        Rational r8 = r5.sub(r6);
        System.out.println(r8);

        Rational r9 = r6.mul(r5);
        System.out.println(r9);

        Rational r10 = r6.div(r5);
        System.out.println(r10);

        System.out.println("f(2) = " + f(1));
        System.out.println("double(f(2)) = " + f(2).toDouble());
        System.out.println("double(f(3)) = " + f(3).toDouble());
        System.out.println("double(f(20)) = " + f(20).toDouble());

        System.out.println("Numerator of r6 (= 1/3) = " + r6.getN());
        System.out.println("Denominator of r6 (= 1/3) = " + r6.getD());

        System.out.println(Rational.ONE);
        System.out.println(Rational.ZERO);

        System.out.println("StaticAdd: 4/6 + 3 = " + Rational.staticAdd(r1, r2));
    }

    private static Rational f(long n) {
        Rational r = new Rational(1, 1);

        for (long i = 2; i <= n; i++) {
            Rational r1 = new Rational(1, i);
            r.addInPlace(r1);
        }
        return r;
    }

}

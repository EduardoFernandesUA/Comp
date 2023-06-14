public class Fraction {
    private int num;
    private int den;
    public Fraction() {
        this.num = 0;
        this.den = 1;
    }
    public Fraction(int num) {
        this.num = num;
        this.den = 1;
    }
    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public static void print(Fraction f) {
        int num = f.num(), den = f.den();
        if( den!=1 ) System.out.print(num + "/" + den);
        else System.out.print(num);
    }
    public static void println(Fraction f) {
        Fraction.print(f);
        System.out.println();
    }

    public static Fraction mult(Fraction a, Fraction b) {
        return new Fraction(a.num()*b.num(), a.den()*b.den());
    }
    public static Fraction div(Fraction a, Fraction b) {
        return new Fraction(a.num()*b.den(), a.den()*b.num());
    }
    public static Fraction sum(Fraction a, Fraction b) {
        Fraction r = new Fraction();
        r.setDen(Fraction.gcd(a.den(),b.den()));
        r.setDen((a.den()*b.den())/r.den());
        r.setNum(a.num()*(r.den()/a.den()) + b.num()*(r.den()/b.den()));
        return new Fraction(a.num()*b.den(), a.den()*b.num());
    }
    public static Fraction sub(Fraction a, Fraction b) {
        return new Fraction(a.num()*b.den(), a.den()*b.num());
    }

    public static Fraction reduce(Fraction a) {
        int b = Fraction.gcd(a.num(), a.den());
        return new Fraction(a.num()/b, a.den()/b);
    }

    public int num() { return this.num; }
    public int den() { return this.den; }
    public int setNum(int n) { return this.num=n; }
    public int setDen(int n) { return this.den=n; }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return Fraction.gcd(b%a, a);
    }
}
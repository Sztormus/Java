public class Complex
{
    private double a;
    private double b;

    public static Complex I = new Complex(0, 1);
    public static Complex ZERO = new Complex();
    public static Complex ONE = new Complex(1, 0);

    Complex(double _a)
    {
        a = _a;
        b = 0;
    }

    Complex(double _a, double _b)
    {
        this(_a);
        b = _b;
    }

    Complex()
    {
        this(0, 0);
    }

    public double getRe()
    {
        return a;
    }

    public double getIm()
    {
        return b;
    }

    public static Complex add(Complex ob1, Complex ob2)
    {
        return new Complex(ob1.a + ob2.a, ob1.b + ob2.b);
    }

    public static Complex subtract(Complex ob1, Complex ob2)
    {
        return new Complex(ob1.a - ob2.a, ob1.b - ob2.b);
    }

    public static Complex multiply(Complex ob1, Complex ob2)
    {
        return new Complex(ob1.a * ob2.a - ob1.b * ob2.b, ob1.b * ob2.a + ob1.a * ob2.b);
    }

    public static Complex multiply(Complex obj, double n)
    {
        return new Complex(obj.a * n, obj.b * n);
    }

    public static Complex divide(Complex ob1, Complex ob2)
    {
        return new Complex((ob1.a * ob2.a + ob1.b * ob2.b)/(ob2.a * ob2.a + ob2.b * ob2.b), (ob1.b * ob2.a - ob1.a * ob2.b)/(ob2.a * ob2.a + ob2.b * ob2.b));
    }

    public double mod()
    {
        return Math.sqrt(a * a + b * b);
    }

    public static Complex sqrt(double n)
    {   
        if(n < 0)
        {
            return new Complex(0, Math.sqrt(-n));
        }
        else if(n > 0)
        {
            return new Complex(Math.sqrt(n), 0);
        }
        else
            return ZERO;
    }
    
    public boolean equals(Object obj)
    {
        if(obj.getClass() == this.getClass())
        {
            Complex c = (Complex)obj;
            if(c.a == a && c.b == b)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public void conjugate()
    {
        b = -b;
    }

    public void opposite()
    {
        a = -a;
        b = -b;
    }

    public String toString()
    {
        if(a == 0 && b == 0)
            return new String("0.0");
        else if(a == 0)
            return new String("" + b + "i");
        else if(b == 0)
            return new String("" + a);
        else
        {
            if(b > 0)
                return new String("" + a + " + " + b + "i");
            else
                return new String("" + a + " - " + -b + "i");
        }
    }

    public void test()
    {
        // Wykorzystanie konstruktorów:
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        System.out.println(c1); // 2.5 + 13.1i
        System.out.println(c2); // -8.5 - 0.9i
        System.out.println(new Complex(4.5)); // 4.5
        System.out.println(new Complex()); // 0.0
        System.out.println(new Complex(0, 5.1)); // 5.1i
        System.out.println();

        // Stałe typu Complex:
        System.out.println(Complex.I); // 1.0i
        System.out.println(Complex.ZERO); // 0.0
        System.out.println(Complex.ONE); // 1.0
        System.out.println();

        // Wykorzystanie metod zwracających wynik obliczeń:
        System.out.println("Re(c1) = " + c1.getRe()); // Re(c1) = 2.5
        System.out.println("Im(c1) = " + c1.getIm()); // Im(c1) = 13.1
        System.out.println("c1 + c2 = " + Complex.add(c1, c2)); // c1 + c2 = -6.0 + 12.2i
        System.out.println("c1 - c2 = " + Complex.subtract(c1, c2)); // c1 - c2 = 11.0 + 14.0i
        System.out.println("c1 * c2 = " + Complex.multiply(c1, c2)); // c1 * c2 = -9.46 - 113.6i
        System.out.println("c1 * 15.1 = " + Complex.multiply(c1, 15.1)); // c1 * 15.1 = 37.75 + 197.81i
        System.out.println("c1 / c2 = " + Complex.divide(c1, c2)); // c1 / c2 = -0.4522310429783739 - 1.4932931836846426i
        System.out.println("|c1| = " + c1.mod()); // |c1| = 13.336416310238668
        System.out.println("sqrt(243.36) = " + Complex.sqrt(243.36)); // sqrt(243.36) = 15.6
        System.out.println("sqrt(-243.36) = " + Complex.sqrt(-243.36)); // sqrt(-243.36) = 15.6i
        Complex c3 = new Complex(2.5, 13.1);
        System.out.println(c1.equals(c2)); // false
        System.out.println(c1.equals(c3)); // true
        // Poniższe wywołanie - dla chętnych :)
        System.out.println(c1.equals("test ze zlym obiektem")); // false
        System.out.println();

        // Metoda zamieniająca liczbę na jej sprzężenie:
        c1.conjugate();
        System.out.println("c1* = " + c1); // c1* = 2.5 - 13.1i

        // Metoda zamieniająca liczbę na przeciwną:
        c1.opposite();
        System.out.println("-c1 = " + c1); // -c1 = -2.5 + 13.1i
    }

    public static void findSolutions(double _a, double _b, double _c)
    {
        double delta = _b * _b - (4 * _a * _c);
        if(delta == 0)
        {
            double x = (-_b)/(2 * _a);
            System.out.println("x = " + x);
        }
        else if(delta > 0)
        {
            double x1 = (-_b + Math.sqrt(delta))/(2 *_a);
            double x2 = (-_b - Math.sqrt(delta))/(2 *_a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
        else
        {
            Complex x1 = new Complex(-_b/(2 * _a), -Math.sqrt(-delta)/(2 * _a));
            Complex x2 = new Complex(-_b/(2 * _a), Math.sqrt(-delta)/(2 * _a));
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
    }

    public static void main(String[] args)
    {
        Complex c1 = new Complex();
        c1.test();

        if(args.length < 3)
        {
            System.out.println("Podales zla liczbe argumentow");
        }
        else
        {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
           
            Complex.findSolutions(a, b, c);
        }
    }
}

import java.math.BigInteger;

public class RSA
{
    public static void main(String[] args)
    {
        int p = 397;
        int q = 103;
        BigInteger n = new BigInteger("" + p * q);
        BigInteger m = new BigInteger("" + (p - 1)*(q - 1));
        BigInteger e = new BigInteger("" + 3);
    
        while(!(m.gcd(e).equals(BigInteger.ONE)))
        {

            e = e.add(BigInteger.ONE);
            e = e.add(BigInteger.ONE);
        }

        int d = extendedEuclid(e.intValue(), m.intValue());
        System.out.println("e = " + e + ", d = " + d);

        String s = args[0];
        BigInteger tab[] = new BigInteger[s.length()];
        for(int i = 0; i < s.length(); ++i)
        {
            tab[i] = new BigInteger("" + (int)s.charAt(i));
            tab[i] = tab[i].modPow(e, n);
            System.out.print("" + tab[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < s.length(); ++i)
        {
            System.out.print("" + (char)tab[i].modPow(new BigInteger("" + d), n).intValue() + " ");
        }
        System.out.println();
    }

    public static int extendedEuclid(int a, int b)
    {  
        int x0 = 1;
        int x = 0;
        int b0 = b;
        int q;
        int temp;
        while(b != 0)
        {
            q = a/b;
            temp = x;
            x = x0 - q * x;
            x0 = temp;
            temp = a%b;
            a = b;
            b = temp;
        }
        if(x0 < 0)
        {
            x0 = x0 + b0;
        }

        return x0;
    }
}

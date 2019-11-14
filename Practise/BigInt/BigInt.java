import java.math.BigInteger;
import java.util.Random;

final class BigInt
{
    private final byte[] tab;

    BigInt(String text)
    {
        tab = new byte[text.length()];
        for(int i = 0; i < tab.length; ++i)
            tab[i] = Byte.parseByte("" + text.charAt(i));
    }

    BigInt(byte[] number)
    {
        tab = new byte[number.length];
        for(int i = 0; i < tab.length; ++i)
            tab[i] = number[i];
    }

    BigInt(BigInt obj)
    {
        tab = obj.getNum();
    }

    public boolean equals(Object obj)
    {
        if(this == null || obj == null)
            return false;
        else if(this == obj)
            return true;
        else if(obj.getClass() == this.getClass())
        {
            BigInt c = (BigInt)obj;
            if(Arrays.equals(c.getNum(), this.getNum()))
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public String toString()
    {
        String text = new String("");
        for(int i = 0; i < tab.length; ++i)
            text += "" + tab[i];
        return text;
    }

    BigInt add(BigInt obj)
    {
        BigInteger ob1 = new BigInteger(obj.toString());
        BigInteger ob2 = new BigInteger(this.toString());
        return new BigInt(ob1.add(ob2).toString());
    }

    byte[] getNum()
    {
        byte[] temp = new byte[tab.length];
        for(int i = 0; i < temp.length; ++i)
            temp[i] = tab[i];
        return temp;
    }

    static void test()
    {
        Random rand = new Random();
        BigInt obj1, obj2, obj3;
        long n1, n2, n3;
        for(int i = 0; i < 1000; ++i)
        {
            n1 = Math.abs(rand.nextLong())/2;
            n2 = Math.abs(rand.nextLong())/2;
            System.out.println("Test nr " + (i + 1) + ": n1 = " + n1 + ", n2 = " + n2);
            n3 = n1 + n2;
            System.out.println("n1 + n2 = " + n3);
            obj1 = new BigInt("" + n1);
            obj2 = new BigInt("" + n2);
            System.out.println("BigInt(n1) = " + obj1 + ", BigInt(n2) = " + obj2);
            obj3 = obj1.add(obj2);
            System.out.println("BigInt(n1) + BigInt(n2) = " + obj3);
            if(obj3.toString().equals("" + n3))
                System.out.println("Liczby sa zgodne");
            else
                System.out.println("Liczby sa rozne");
            System.out.println();
        }
        n1 = 999999999999999999L;
        n2 = 1L;
        System.out.println("Test nr 1001: n1 = " + n1 + ", n2 = " + n2);
        n3 = n1 + n2;
        System.out.println("n1 + n2 = " + n3);
        obj1 = new BigInt("" + n1);
        obj2 = new BigInt("" + n2);
        System.out.println("BigInt(n1) = " + obj1 + ", BigInt(n2) = " + obj2);
        obj3 = obj1.add(obj2);
        System.out.println("BigInt(n1) + BigInt(n2) = " + obj3);
        if(obj3.toString().equals("" + n3))
            System.out.println("Liczby sa zgodne");
        else
            System.out.println("Liczby sa rozne");
        System.out.println();

        n2 = 999999999999999999L;
        n1 = 1L;
        System.out.println("Test nr 1002: n1 = " + n1 + ", n2 = " + n2);
        n3 = n1 + n2;
        System.out.println("n1 + n2 = " + n3);
        obj1 = new BigInt("" + n1);
        obj2 = new BigInt("" + n2);
        System.out.println("BigInt(n1) = " + obj1 + ", BigInt(n2) = " + obj2);
        obj3 = obj1.add(obj2);
        System.out.println("BigInt(n1) + BigInt(n2) = " + obj3);
        if(obj3.toString().equals("" + n3))
            System.out.println("Liczby sa zgodne");
        else
            System.out.println("Liczby sa rozne");
        System.out.println();
        
    }

    public static void main(String[] args)
    {
        test();
    }
}

package bench.cpu;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class Digits5 implements IBenchmark
{
    static int size;

    @Override
    public void initialize(int size)
    {
        this.size = size;
        con1024 = new MathContext(size);
    }

    private static MathContext con1024;
    private static final BigDecimal bigTwo = new BigDecimal(2);
    private static final BigDecimal bigFour = new BigDecimal(4);

    private static BigDecimal bigSqrt(BigDecimal bd, MathContext con)
    {
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal x1 = BigDecimal.valueOf(Math.sqrt(bd.doubleValue()));
        while (!Objects.equals(x0, x1))
        {
            x0 = x1;
            x1 = bd.divide(x0, con).add(x0).divide(bigTwo, con);
        }
        return x1;
    }

    @Override
    public void run()
    {
        BigDecimal a = BigDecimal.ONE;
        BigDecimal g = a.divide(bigSqrt(bigTwo, con1024), con1024);
        BigDecimal t;
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal pow = bigTwo;
        while (!Objects.equals(a, g))
        {
            t = a.add(g).divide(bigTwo, con1024);
            g = bigSqrt(a.multiply(g), con1024);
            a = t;
            pow = pow.multiply(bigTwo);
            sum = sum.add(a.multiply(a).subtract(g.multiply(g)).multiply(pow));
        }
        BigDecimal pi = bigFour.multiply(a.multiply(a)).divide(BigDecimal.ONE.subtract(sum), con1024);
    }

    @Override
    public void run(Object option)
    {
    }

    @Override
    public void clean()
    {
    }

    @Override
    public void warmUp()
    {
        for (int i = 1; i <= 1000; ++i)
        {
            for (int j = 1; j <= 1000; ++j)
            {
                for (int z = 1; z <= 1000; ++z)
                {
                    Digits3 warm_up = new Digits3();
                }
            }

        }
        System.out.println("START! Warm-up done!");
    }

    @Override
    public void warmUp(Object option)
    {
    }

    @Override
    public String getResult()
    {
        return null;
    }

    @Override
    public void cancel()
    {
    }
}
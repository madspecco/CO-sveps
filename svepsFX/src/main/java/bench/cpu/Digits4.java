package bench.cpu;

import java.math.BigDecimal;
import java.math.MathContext;

public class Digits4 implements IBenchmark
{

    int size;


    @Override
    public void initialize(int size)
    {
        this.size = size;
    }




    // 3 + 4/(2*3*4) - 4/(3*4*5) + 4/(4*5*6) ..... and so on
    @Override
    public void run()
    {
        size -= 1;
        BigDecimal pi = new BigDecimal(3);
        BigDecimal divisorBegin = new BigDecimal(2);
        BigDecimal divisor;
        BigDecimal one = new BigDecimal(1);
        BigDecimal two = new BigDecimal(2);
        BigDecimal four = new BigDecimal(4);
        BigDecimal minusFour = new BigDecimal(-4);
        MathContext mc = new MathContext(size);
        for (long i = 0; i < size; ++i)
        {
            divisor = one;
            for (long j = 0; j < 3; ++j)
            {
                divisor = divisor.multiply(new BigDecimal(j).add(divisorBegin, mc), mc);
            }
            pi = pi.add(i % 2 == 0 ? four.divide(divisor, mc) : minusFour.divide(divisor, mc), mc);
            divisorBegin = divisorBegin.add(two, mc);
        }
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

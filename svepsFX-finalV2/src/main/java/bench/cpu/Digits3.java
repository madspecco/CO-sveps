package bench.cpu;

public class Digits3 implements IBenchmark
{
    private static final int SCALE = 10000;
    private static final int ARRINIT = 2000;

    int size;

    @Override
    public void initialize(int size)
    {
        this.size = size;
    }


    @Override
    public void run()
    {

        StringBuffer pi = new StringBuffer(100);
        int[] arr = new int[size + 1];
        int carry = 0;

        for (int i = 0; i <= size; ++i)
            arr[i] = ARRINIT;

        for (int i = size; i > 0; i-= 14)
        {
            int sum = 0;
            for (int j = i; j > 0; --j) {
                sum = sum * j + SCALE * arr[j];
                arr[j] = sum % (j * 2 - 1);
                sum /= j * 2 - 1;
            }

            pi.append(String.format("%04d", carry + sum / SCALE));
            carry = sum % SCALE;

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


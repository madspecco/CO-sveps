package bench;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class CPUDigitsOfPIBench implements IBenchmark {
    private int size;
    public static BigDecimal pi =  BigDecimal.ZERO;
    public static BigDecimal denominator1 =  BigDecimal.ONE;
    public static BigDecimal denominator2 =  BigDecimal.ONE;
    public static BigDecimal term1 =  BigDecimal.ZERO;
    public static BigDecimal term2 =  BigDecimal.ZERO;

    @Override
    public void initialize(int size) {
        this.size = size;
    }

    @Override
    public void run() {
        // accuracy parameters set to 1000 arbitrarily
        for(int i=2;i<1000;i+=4)
        {
            denominator1 =  BigDecimal.ONE;
            denominator1 = denominator1.multiply(new BigDecimal(i));
            denominator1 = denominator1.multiply(new BigDecimal(i+1));
            denominator1 = denominator1.multiply(new BigDecimal(i+2));

            denominator2 =  BigDecimal.ONE;
            denominator2 = denominator2.multiply(new BigDecimal(i+2));
            denominator2 = denominator2.multiply(new BigDecimal(i+3));
            denominator2 = denominator2.multiply(new BigDecimal(i+4));
            term1 = new BigDecimal("4").divide(denominator1, 1000, RoundingMode.HALF_UP);
            term2 = new BigDecimal("-4").divide(denominator2, 1000, RoundingMode.HALF_UP);

            pi = pi.add(term1);
            pi = pi.add(term2);
        }

        pi = pi.add(new BigDecimal (3));

        pi = pi.setScale(size, BigDecimal.ROUND_HALF_UP);
        pi =  BigDecimal.ZERO;
    }
    @Override
    public void run(Object option) {
    }

    @Override
    public void clean() {
    }

    @Override
    public void warmUp() {
        for (int i = 1; i <= 1000; ++i) {
            for (int j = 1; j <= 1000; ++j) {
                for (int z = 1; z <= 1000; ++z){
                    CPUDigitsOfPIBench warm_up = new CPUDigitsOfPIBench();
                }
            }

        }
        System.out.println("START! Warm-up done!");
    }

    @Override
    public void warmUp(Object option) {

    }

    @Override
    public String getResult() {
        return null;
    }

    @Override
    public void cancel(){

    }
}



package bench.cpu;

public class Cramer implements IBenchmark
{
    int size;
    private double[][] mat = {
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3}
    };

    private double[] coef = {20, 15, 4, 2, 1, 1, 0, 12, 5};

    @Override
    public void initialize(int size)
    {
        this.size = size;
    }

     //Compute determinant.
     //For a square matrix we calculate the determinant using the cross method.
     //Recursion



    private double[][] computeMinor(final double[][] M, final int column)
    {
        int minorL=M.length-1;
        double[][] minorMat = new double[minorL][minorL];
        int dI=0;
        int dJ;
        for(int i=0; i<=minorL; i++)
        {
            dJ=0;
            for(int j=0; j<=minorL;j++)
                if(i==0)
                    dI=1;
                else if(j==column)
                    dJ=1;
                else
                    minorMat[i-dI][j-dJ]=M[i][j];
        }
        return minorMat;
    }

    private double computeDeterminant(final double[][] M)
    {
        double Result = 0.0;
        if(M.length == 2) {
            Result = M[0][0] * M[1][1] - M[1][0] * M[0][1];
        }
        else
        {
            int coefficient = 1;
            for(int i=0, length=M.length; i<length; i++)
            {
                if(i%2==1)
                    coefficient=-1;
                else
                    coefficient=1;
                Result+=coefficient*M[0][i]*this.computeDeterminant(this.computeMinor(M, i));
            }
        }
        return Result;
    }

    @Override
    public void run()
    {
        double[][] tmp=new double[mat.length][mat.length];
        double[] x=new double[mat.length];
        double detA;
        long timeout = System.currentTimeMillis();
        detA = computeDeterminant(mat);
        for(int m=0, n=mat.length; m<n; m++)
        {
            for(int i=0; i<n; i++)
                System.arraycopy(mat[i], 0, tmp[i], 0, n);
            for(int j=0; j<n; j++)
                tmp[j][m]=coef[j];
            x[m]=computeDeterminant(tmp)/detA;
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
                    Cramer warm_up = new Cramer();
                }
            }

        }
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

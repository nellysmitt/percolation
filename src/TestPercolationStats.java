import org.junit.Assert;
import org.junit.Test;

public class TestPercolationStats {

    @Test
    public void TestIdsConversionRow(){
        double id = 9;
        double n = 4;
        //System.out.println(Math.ceil(id/n));
        Assert.assertEquals(new Double(3), Math.ceil(id/n), new Double(0));
    }

    @Test
    public void TestIdsConversionCol(){
        double id = 9;
        double n = 4;
        int row = (int) Math.ceil(id/n);
        //System.out.println(Math.ceil(id/n));
        int col = (int) (id - row * n + n);
        Assert.assertEquals(1, col);
    }

    @Test
    public void TestIdsConversionRow2(){
        double id = 8;
        double n = 4;
        //System.out.println(Math.ceil(id/n));
        Assert.assertEquals(new Double(2), Math.ceil(id/n), new Double(0));
    }

    @Test
    public void TestIdsConversionCol2(){
        double id = 8;
        double n = 4;
        int row = (int) Math.ceil(id/n);
        //System.out.println(Math.ceil(id/n));
        int col = (int) (id - row * n + n);
        Assert.assertEquals(4, col);
    }

    @Test
    public void TestIdsConversion3(){
        double id = 3;
        double n = 4;
        int row = (int) Math.ceil(id/n);
        int col = (int) (id - row * n + n);
        Assert.assertEquals(1, row);
        Assert.assertEquals(3, col);
    }

    @Test
    public void TestPercolation200_100(){
        int n = 200;
        int T = 100;
        PercolationStats stats = new PercolationStats(n, T);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        //System.out.format("lo                  = %f%n", stats.confidenceLo());
        //System.out.format("hi                  = %f%n", stats.confidenceHi());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}



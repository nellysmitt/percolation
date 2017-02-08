import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {

    private int trials;
    private double[] threshold;

    public PercolationStats(int n, int trials){
        // perform trials independent experiments on an n-by-n grid

        if (n <=0 || trials <= 0) throw new java.lang.IllegalArgumentException();

        this.trials = trials;

        threshold = new double[trials];

        for (int t = 0; t < trials; t++) {
            int numberOfOpenSites = percolationTest(n);
            threshold[t] = ((double) numberOfOpenSites) / ((double) n*n);
        }
    }

    private int percolationTest(int n){

        Percolation p = new Percolation(n);
        int c = 0;
        while (!p.percolates()){
            int row = StdRandom.uniform(1, n+1);
            int col = StdRandom.uniform(1, n+1);
            if(!p.isOpen(row, col)) {
                p.open(row, col);
                c++;
            }
        }
        return c;
    }

    public double mean(){
        // sample mean of percolation threshold
        return StdStats.mean(threshold);
    }

    public double stddev(){
        // sample standard deviation of percolation threshold
        return StdStats.stddev(threshold);
    }
    public double confidenceLo(){
        // low  endpoint of 95% confidence interval
        return (mean() - (1.96 * stddev()) / Math.sqrt(trials));
    }
    public double confidenceHi(){
        // high endpoint of 95% confidence interval
        return (mean() + (1.96 * stddev()) / Math.sqrt(trials));
    }

    public static void main(String[] args){
        // test client (described below)
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, T);
        // System.out.println("mean                    = " + stats.mean());
        // System.out.println("stddev                  = " + stats.stddev());
        // System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}


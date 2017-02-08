import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF id;
    // private WeightedQuickUnionUF bottomId;
    private boolean openId[];
    private int[] bottom;
    private int b_count = 0;
    // private int N;
    private int n;
    private int numOfOpen = 0;

    public Percolation(int n) {
        // create n-by-n grid, with all sites blocked
        if (n <= 0 ) throw new java.lang.IllegalArgumentException();

        this.n = n;
        // this.N = n*n + 2;

        id = new WeightedQuickUnionUF(n*n + 2);
        // bottomId = new WeightedQuickUnionUF(n+1);
        bottom = new int[n];
        openId = new boolean[n*n + 2];

        openId[0] = true; // open top virtual node
        openId[n*n + 1] = true; // open bottom virtual node

    }

    private void checkRange(int row, int col) {
        if ((row < 1 || row > n) || (col < 1 || col > n))
            throw new java.lang.IndexOutOfBoundsException();
    }

    private int getId(int row, int col) {
        // checkRange(row, col);
        return row * n - n + col;
    }


    private void connectToNeighbours(int row, int col) {

        int c = getId(row, col);
        int t = getId(row-1, col); // top
        int b = getId(row+1, col); // bottom
        int l = getId(row, col-1); // left
        int r = getId(row, col+1); // right

        // connect to top
        try {
            if (isOpen(row-1, col)) id.union(c, t);
        } catch (java.lang.IndexOutOfBoundsException e) {
            id.union(c, 0);
        }
        // connect to left
        try {
            if(isOpen(row, col-1)) id.union(c, l);
        } catch (java.lang.IndexOutOfBoundsException e) {}

        // connect to right
        try {
            if(isOpen(row, col+1)) id.union(c, r);
        } catch (java.lang.IndexOutOfBoundsException e) {}

        // connect to bottom
        try {
            if(isOpen(row+1, col)) id.union(c, b);

        } catch (java.lang.IndexOutOfBoundsException e) {
            // bottomId.union(c, N-1);
            bottom[b_count] = c;
            b_count++;
        }

        /*
        System.out.println("Result");
        for (int i = 0; i < N; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < N; i++) {
            System.out.print(id.find(i) + " ");
        }
        System.out.println();
        */
    }

    public void open(int row, int col) {
        // open site (row, col) if it is not open already
        checkRange(row, col);
        if (!isOpen(row, col)) {
            openId[getId(row, col)] = true;
            numOfOpen += 1;
            connectToNeighbours(row, col);
        }
    }

    public boolean isOpen(int row, int col) {
        // is site (row, col) open?
        checkRange(row, col);
        return openId[getId(row, col)];
    }

    public boolean isFull(int row, int col) {
        // is site (row, col) full?
        checkRange(row, col);
        if (!isOpen(row, col)) return false;
        return id.connected(getId(row, col), 0);
    }

    public int numberOfOpenSites() {
        // number of open sites
        return numOfOpen;
    }

    public boolean percolates() {
        // does the system percolate?
        for (int i = 0; i < b_count; i++) {
            // System.out.println("b " + bottom[i]);
            if (id.connected(bottom[i], 0)) return true;
        }
        return false;
        //return id.connected(N-1, 0);
    }

    public static void main(String[] args) {
        // test client (optional)
    }
}



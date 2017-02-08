import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class TestPercolation {

    @Test
    public void testZeroN() throws Exception {
        int n = 0;
        try{new Percolation(n);}
        catch(Exception e) {
            if(e.getClass().isInstance(new java.lang.IllegalArgumentException())){}
            else throw e;
        }
    }

    @Test
    public void testNegativeN() throws Exception {
        int n = -10;
        try{new Percolation(n);}
        catch(Exception e) {
            if(e.getClass().isInstance(new java.lang.IllegalArgumentException())){}
            else throw e;
        }
    }

    // n = 1

    @Test
    public void testIdentityMatrixCreation() throws Exception {
        int n = 1;
        try{new Percolation(n);}
        catch(Exception e) {
            if(e.getClass().isInstance(new java.lang.IllegalArgumentException())){}
            else throw e;
        }
    }

    @Test
    public void testIdentityMatrixNumberOfOpenSitesEqualsZero() throws Exception {
        int n = 1;
        Percolation p = new Percolation(n);
        Assert.assertEquals(0, p.numberOfOpenSites());
    }

    @Test
    public void testIdentityMatrixSiteIsBlockedAfterInitialization() throws Exception {
        int n = 1;
        Percolation p = new Percolation(n);
        Assert.assertFalse(p.isOpen(1, 1));
    }

    @Test
    public void testIdentityMatrixCheckIfOpenedSiteIsOpen() throws Exception {
        int n = 1;
        Percolation p = new Percolation(n);
        p.open(1, 1);
        Assert.assertTrue(p.isOpen(1, 1));
    }

    @Test
    public void testIdentityMatrixCheckINumberOfOpenedSitesIsOne() throws Exception {
        int n = 1;
        Percolation p = new Percolation(n);
        p.open(1, 1);
        Assert.assertEquals(1, p.numberOfOpenSites());
    }

    // Test identity matrix percolates
    // Test if site is full

    @Test
    public void testIdentityMatrixIsFull() throws Exception {
        int n = 1;
        Percolation p = new Percolation(n);
        p.open(1, 1);
        Assert.assertTrue(p.isFull(1, 1));
    }

    // Test identity matrix percolates

    @Test
    public void testIdentityMatrixPercolates() throws Exception {
        int n = 1;
        Percolation p = new Percolation(n);
        p.open(1, 1);
        Assert.assertTrue(p.percolates());
    }

    // n = 2

    @Test
    public void testI2x2MatrixCreation() throws Exception {
        int n = 2;
        try{new Percolation(n);}
        catch(Exception e) {
            if(e.getClass().isInstance(new java.lang.IllegalArgumentException())){}
            else throw e;
        }
    }

    @Test
    public void test2x2MatrixNumberOfOpenSitesEqualsZero() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        Assert.assertEquals(0, p.numberOfOpenSites());
    }

    @Test
    public void test2x2MatrixSiteIsBlockedAfterInitialization() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        Assert.assertFalse(p.isOpen(1, 2));
    }

    @Test
    public void test2x2MatrixCheckIfOpenedSiteIsOpen() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        p.open(1, 2);
        p.open(2, 1);
        Assert.assertTrue(p.isOpen(1, 2));
        Assert.assertTrue(p.isOpen(2, 1));
    }

    @Test
    public void test2x2MatrixCheckINumberOfOpenedSitesIsOne() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        p.open(1, 2);
        Assert.assertEquals(1, p.numberOfOpenSites());
    }

    @Test
    public void test2x2MatrixCheckINumberOfOpenedSitesIsTwo() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        p.open(1, 2);
        p.open(2, 2);
        Assert.assertEquals(2, p.numberOfOpenSites());
    }

    @Test
    public void test2x2MatrixCheckIsFull() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        p.open(1, 2);
        Assert.assertTrue(p.isFull(1, 2));
    }

    @Test
    public void test2x2MatrixCheckIsNotFull() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        p.open(1, 2);
        Assert.assertFalse(p.isFull(1, 1));
    }

    @Test
    public void test2x2MatrixCheckDoesntPercolate() throws Exception {
        int n = 2;
        Percolation p = new Percolation(n);
        p.open(1, 2);
        p.open(2, 1);
        Assert.assertFalse(p.percolates());
    }

    @Test
    public void test3x3MatrixCheckDoesntPercolate1() throws Exception {
        int n = 3;
        Percolation p = new Percolation(n);
        p.open(1, 3);
        p.open(2, 2);
        p.open(3, 1);
        Assert.assertFalse(p.percolates());
    }

    @Test
    public void test3x3MatrixCheckDoesntPercolate2() throws Exception {
        int n = 3;
        Percolation p = new Percolation(n);
        p.open(1, 3);
        p.open(2, 2);
        p.open(3, 1);
        p.open(3, 2);
        Assert.assertFalse(p.percolates());
    }

    @Test
    public void test3x3MatrixCheckPercolates() throws Exception {
        int n = 3;
        Percolation p = new Percolation(n);
        p.open(1, 3);
        p.open(2, 2);
        p.open(3, 1);
        p.open(3, 2);
        p.open(1, 2);
        Assert.assertTrue(p.percolates());
    }

    private String pathTo(String fileName){
        return "/Users/nellysmitt/Projects/IdeaProjects/ALGO_I/WEEK1/Percolation/tests/" + fileName;
    }

    @Test
    public void TestFromInput1() throws Exception{
        File file = new File(pathTo("input1.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput1No() throws Exception{
        File file = new File(pathTo("input1-no.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertFalse(p.percolates());
    }

    @Test
    public void TestFromInput2() throws Exception{
        File file = new File(pathTo("input2.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput2No() throws Exception{
        File file = new File(pathTo("input2-no.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertFalse(p.percolates());
    }

    @Test
    public void TestFromInput3() throws Exception{
        File file = new File(pathTo("input3.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput4() throws Exception{
        File file = new File(pathTo("input4.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput3Custom() throws Exception{
        File file = new File(pathTo("input3_custom.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertFalse(p.isFull(3, 1));
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput5() throws Exception{
        File file = new File(pathTo("input5.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput6() throws Exception{
        File file = new File(pathTo("input6.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput7() throws Exception{
        File file = new File(pathTo("input7.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput8() throws Exception{
        File file = new File(pathTo("input8.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput8No() throws Exception{
        File file = new File(pathTo("input8-no.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertFalse(p.percolates());
    }

    @Test
    public void TestFromInput10() throws Exception{
        File file = new File(pathTo("input10.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput10Check() throws Exception{
        File file = new File(pathTo("input10.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertFalse(p.isFull(9, 1));
    }

    @Test
    public void TestFromInput10No() throws Exception{
        File file = new File(pathTo("input10-no.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertFalse(p.percolates());
    }

    @Test
    public void TestFromInput20() throws Exception{
        File file = new File(pathTo("input20.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput20Check() throws Exception{
        File file = new File(pathTo("input20_check.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertFalse(p.isFull(18, 1));
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromInput50() throws Exception{
        File file = new File(pathTo("input50.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromJerry47() throws Exception{
        File file = new File(pathTo("/jerry47.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromSedgewick60() throws Exception{
        File file = new File(pathTo("sedgewick60.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void TestFromWayne98() throws Exception{
        File file = new File(pathTo("wayne98.txt"));

        Scanner in = new Scanner(new FileReader(file));
        int n = in.nextInt();
        Percolation p = new Percolation(n);
        while(in.hasNext()){
            int i = in.nextInt();
            int j = in.nextInt();
            p.open(i, j);
        }
        Assert.assertTrue(p.percolates());
    }

}

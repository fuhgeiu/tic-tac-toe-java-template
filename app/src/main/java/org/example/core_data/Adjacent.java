package org.example.core_data;

public class Adjacent {

    private int[] on = {2, 4, 5};
    private int[] tw = {1, 3, 4, 5, 6};
    private int[] th = {2, 5, 6};
    private int[] fr = {1, 2, 5, 6, 7};
    private int[] fv = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int[] si = {2, 3, 5, 8, 9};
    private int[] sv = {4, 5, 8};
    private int[] eg = {4, 5, 6, 7, 9};
    private int[] nn = {5, 6, 8};

    public int[] refAdjacent(int spot) {
        switch (spot) {
            case 1: return on;
            case 2: return tw;
            case 3: return th;
            case 4: return fr;
            case 5: return fv;
            case 6: return si;
            case 7: return sv;
            case 8: return eg;
            case 9: return nn;
            default: throw new IndexOutOfBoundsException("range violation adjacent");
        }
    }
}

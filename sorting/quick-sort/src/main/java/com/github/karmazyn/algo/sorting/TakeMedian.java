package com.github.karmazyn.algo.sorting;

import java.util.Arrays;

/**
 * Created by m.karmazyn on 02/02/15.
 */
public class TakeMedian implements PivotStrategy {
    @Override
    public int choosePivot(int[] array, int left, int right) {
        int middle = (left + right) / 2;
        int a = array[left];
        int b = array[right];
        int c = array[middle];
        int[] copy = {a,b,c};
        Arrays.sort(copy);
        int median = copy[1];
        if( a == median ) return left;
        if (b == median ) return right;
        return middle;
    }
}

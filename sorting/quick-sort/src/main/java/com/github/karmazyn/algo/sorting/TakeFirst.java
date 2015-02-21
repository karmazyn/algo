package com.github.karmazyn.algo.sorting;

/**
 * Created by m.karmazyn on 02/02/15.
 */
public class TakeFirst implements PivotStrategy {
    
    @Override
    public int choosePivot(int[] array, int left, int right) {
        return left;
    }
}

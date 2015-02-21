package com.github.karmazyn.algo.sorting;

/**
 * Created by m.karmazyn on 02/02/15.
 */
public class TakeLast implements PivotStrategy {
    
    @Override
    public int choosePivot(int[] array, int left, int right) {
        return right;
    }
}

package com.github.karmazyn.algo.sorting;

/**
 * Created by m.karmazyn on 02/02/15.
 */
public interface PivotStrategy {
    
    public int choosePivot(int[] array, int left, int right);
}

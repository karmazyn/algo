package com.github.karmazyn.algo.sorting;

/**
 * Created by m.karmazyn on 02/02/15.
 */
public class QuickSort {

    private PivotStrategy strategy;

    private long counter;

    public QuickSort(PivotStrategy strategy) {
        this.strategy = strategy;
    }

    public long sort(int[] array) {
        counter = 0;
        sort(array, 0, array.length - 1);
        return counter;
    }

    private void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int pointer = partition(array, left, right);
        sort(array, left, pointer - 1);
        sort(array, pointer + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        counter += right - left;
        int pivot = strategy.choosePivot(array, left, right);
        int value = array[pivot];
        swap(array, left, pivot);
        int i = left + 1;
        for (int j = left + 1; j <= right; j++) {
            if (array[j] < value) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, left, i - 1);
        return i - 1;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}

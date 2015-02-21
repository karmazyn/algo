package com.github.karmazyn.algo.sorting.merge;

import java.util.Arrays;

/**
 * Created by m.karmazyn on 26/01/15.
 */
public class MergeSort {

    public <T extends Comparable<T>> void sort(T[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    private <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right) {
        T[] buffer = Arrays.copyOfRange(array, left, right + 1);
        int i = left, k = 0, j = middle + 1;
        while (i <= middle && j <= right) {
            if (array[i].compareTo(array[j]) <= 0) {
                buffer[k++] = array[i++];
            } else {
                buffer[k++] = array[j++];
            }
        }
        while (i <= middle) {
            buffer[k++] = array[i++];
        }
        for (int idx = 0; idx < buffer.length; idx++) {
            array[left + idx] = buffer[idx];
        }
    }
}

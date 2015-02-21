package com.github.karmazyn.algo.sorting.merge;

import java.util.Arrays;

/**
 * Created by m.karmazyn on 26/01/15.
 */
public class CountInversion {

    public long split(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int middle = (left + right) / 2;
        long inversionsLeft = split(array, left, middle);
        long inversionsRight = split(array, middle + 1, right);
        return inversionsLeft + inversionsRight + merge(array, left, middle, right);
    }

    private long merge(int[] array, int left, int middle, int right) {
        int[] buffer = Arrays.copyOfRange(array, left, right + 1);
        int i = left, k = 0, j = middle + 1;
        int inversions = 0;
        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                buffer[k++] = array[i++];
            } else {
                buffer[k++] = array[j++];
                inversions += middle - i + 1;
            }
        }
        while (i <= middle) {
            buffer[k++] = array[i++];
        }
        for (int idx = 0; idx < buffer.length; idx++) {
            array[left + idx] = buffer[idx];
        }

        return inversions;
    }
}

package com.github.karmazyn.algo.sorting.merge;

import java.util.Random;

import com.github.karmazyn.algo.sorting.merge.MergeSort;
import com.google.common.base.Joiner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private static final int MAX_LEN = 20;
    private static final int MAX_VALUE = 20;
    private MergeSort mergeSort;

    @Before
    public void setUp() throws Exception {
        mergeSort = new MergeSort();
    }

    
    @Test
    public void shouldSortIntArray() throws Exception {
        Integer [] array = generateArray();
        System.out.println(Joiner.on(',').join(array));
        mergeSort.sort(array,0,array.length - 1);
        Assertions.assertThat(array).isSorted();

    }

    private Integer[] generateArray() {
        Random rand = new Random(System.currentTimeMillis());
        int len = rand.nextInt(MAX_LEN - 5) + 5;
        Integer[] array = new Integer[len];
        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(MAX_VALUE);
        }
        return array;
    }
}
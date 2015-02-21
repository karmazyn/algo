package com.github.karmazyn.algo.sorting;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TakeMedianTest {

    private TakeMedian takeMedian = new TakeMedian();
    
    @Test
    public void testTakeFirst() throws Exception {
        int [] array = {2, 0, 4};
        int pivot = takeMedian.choosePivot(array, 0, 2);
        Assertions.assertThat(pivot).isEqualTo(0);
    }
    
    @Test
    public void testTakeSecond() throws Exception {
        int [] array = {9, 3, 2};
        int pivot = takeMedian.choosePivot(array, 0, 2);
        Assertions.assertThat(pivot).isEqualTo(1);
    }
    @Test
    public void testTakeLast() throws Exception {
        int [] array = {9, 2, 4};
        int pivot = takeMedian.choosePivot(array, 0, 2);
        Assertions.assertThat(pivot).isEqualTo(2);
    }
}
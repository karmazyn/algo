package com.github.karmazyn.algo.sorting.merge;

import com.github.karmazyn.algo.sorting.io.ArrayLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CountInversionTest {

    private CountInversion countInversions;

    @Before
    public void setUp() throws Exception {
        this.countInversions = new CountInversion();
    }

    @Test
    public void shouldCount0Inversions() throws Exception {
        ArrayLoader loader = new ArrayLoader(this.getClass().getClassLoader().getResourceAsStream("SortedSet.txt"));
        int[] array = loader.readArray();
        long split = countInversions.split(array, 0, array.length - 1);
        Assertions.assertThat(split).isZero();
    }
    
    @Test
    public void shouldCount3Inversions() throws Exception {
        ArrayLoader loader = new ArrayLoader(this.getClass().getClassLoader().getResourceAsStream("SmallSet.txt"));
        int[] array = loader.readArray();
        long split = countInversions.split(array, 0, array.length - 1);
        Assertions.assertThat(split).isEqualTo(3);
    }
    @Test
    public void shouldCountRevertedInversions() throws Exception {
        ArrayLoader loader = new ArrayLoader(this.getClass().getClassLoader().getResourceAsStream("RevertedSet.txt"));
        int[] array = loader.readArray();
        long split = countInversions.split(array, 0, array.length - 1);
        Assertions.assertThat(split).isEqualTo(45);
    }
    
    @Test
    public void shouldCountManyInversions() throws Exception {
        ArrayLoader loader = new ArrayLoader(this.getClass().getClassLoader().getResourceAsStream("IntegerArray.txt"));
        int[] array = loader.readArray();
        long split = countInversions.split(array, 0, array.length - 1);
        Assertions.assertThat(split).isEqualTo(2407905288l);
    }
}
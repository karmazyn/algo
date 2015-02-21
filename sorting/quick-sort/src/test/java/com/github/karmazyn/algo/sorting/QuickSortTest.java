package com.github.karmazyn.algo.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;

import com.github.karmazyn.algo.io.ArrayLoader;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void shouldCount5Comparisons() throws Exception {
        QuickSort counter = new QuickSort(new TakeFirst());
        int [] array = load(this.getClass().getClassLoader().getResourceAsStream("SmallSet.txt"));

        long comparisons = counter.sort(array);
        assertThat(comparisons).isEqualTo(6l);
        assertThat(array).isSorted();
    }

    @Test
    public void shouldCount45Comparisons() throws Exception {
        QuickSort counter = new QuickSort(new TakeFirst());
        int [] array = load(this.getClass().getClassLoader().getResourceAsStream("SortedSet.txt"));

        long comparisons = counter.sort(array);
        assertThat(comparisons).isEqualTo(45l);
        assertThat(array).isSorted();
    }
    
    @Test
    public void shouldCount162085Comparisons() throws Exception {
        QuickSort counter = new QuickSort(new TakeFirst());
        int [] array = load(this.getClass().getClassLoader().getResourceAsStream("QuickSort.txt"));

        long comparisons = counter.sort(array);
        assertThat(comparisons).isEqualTo(162085L);
        assertThat(array).isSorted();
    }
    
    @Test
    public void shouldCount164123Comparisons() throws Exception {
        QuickSort counter = new QuickSort(new TakeLast());
        int [] array = load(this.getClass().getClassLoader().getResourceAsStream("QuickSort.txt"));

        long comparisons = counter.sort(array);
        assertThat(comparisons).isEqualTo(164123L);
        assertThat(array).isSorted();
    }
    
    @Test
    public void shouldCount138382Comparisons() throws Exception {
        QuickSort counter = new QuickSort(new TakeMedian());
        int [] array = load(this.getClass().getClassLoader().getResourceAsStream("QuickSort.txt"));

        long comparisons = counter.sort(array);
        assertThat(comparisons).isEqualTo(138382L);
        assertThat(array).isSorted();
    }

    private int[] load(InputStream resourceAsStream) {
        ArrayLoader loader = new ArrayLoader(resourceAsStream);
        return loader.readArray();
    }
}
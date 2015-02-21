package com.github.karmazyn.algo.sorting.io;

import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArrayLoaderTest {

    @Test
    public void shouldCreateArray() throws Exception {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("SmallSet.txt");
        ArrayLoader loader = new ArrayLoader(stream);
        int[] array = loader.readArray();
        Assertions.assertThat(array).containsSequence(1, 2, 3, 6, 4, 5, 7, 9, 8, 10);
    }
}
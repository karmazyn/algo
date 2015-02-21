package com.github.karmazyn.algo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by m.karmazyn on 26/01/15.
 */
public class ArrayLoader {
    private final InputStream stream;

    public ArrayLoader(InputStream stream) {
        this.stream = stream;
    }

    public int[] readArray(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))){
            int[] array = reader.lines()
                    .filter(l -> !l.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[0];
    }
}

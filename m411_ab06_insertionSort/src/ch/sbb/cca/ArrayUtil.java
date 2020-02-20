package ch.sbb.cca;

import java.util.Random;

public class ArrayUtil {
    private static Random randomGenerator = new Random();

    // n == possible random values
    public static int[] randomIntArray(int length, int n){
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++){
            array[i] = randomGenerator.nextInt(n);
        }

        return array;
    }
}

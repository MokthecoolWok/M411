package ch.sbb.cca.Algorithms;

public class SelectionSorter {
    private int[] sortedArray;

    public SelectionSorter(int[] myArray) {
        sortedArray = sort(myArray);
    }

    private int[] sort(int[] intArray) {
        int n = intArray.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (intArray[j] < intArray[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = intArray[min_idx];
            intArray[min_idx] = intArray[i];
            intArray[i] = temp;
        }

        return intArray;
    }

    public int[] returnSortedArray(){
        return sortedArray;
    }
}

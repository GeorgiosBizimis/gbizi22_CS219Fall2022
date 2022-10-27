package ArrayExamples;

import java.util.Arrays;

public class SelectionSort
{

    /*
        Return the index of the smallest item in the array
     */
    private static int smallestLocation(final int[] arr, final int start)
    {
        int minValue = arr[start];
        int index = start;

        for(int i = start + 1; i < arr.length; i++)
            if(arr[i] < minValue) {
                minValue = arr[i];
                index = i;
            }

        return index;
    }

    private static int[] sort(int[] aoi)
    {
        for(int i = 0; i < aoi.length - 1; i++)
        {
            final int j = smallestLocation(aoi, i);
            final int temp = aoi[i];
            aoi[i] = aoi[j];
            aoi[j] = temp;
        }

        return aoi;
    }



    private static boolean isOrdered(final int[] aoi)
    {
        for(int i = 1; i < aoi.length; i++)
            if (aoi[i - 1] > aoi[i])
                return false;

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(smallestLocation(new int[] {4, 1, 9, -1, 6}, 0) == 3);
        System.out.println(smallestLocation(new int[] {4, 1, 9, -1, 6}, 4) == 4);

        int[] aoi = {4, 1, 9, 2, -1, 6};
        System.out.println(Arrays.toString(sort(aoi)));
        System.out.println(isOrdered(sort(aoi)));
    }

}

package HW8;

import java.util.Arrays;

public class HW8 {

    /*
     *   Return the sum of the array of integers starting at index i up
     *   to the end of the array.  Assume i >= 0.
     *
     *   Write this recursively. Do not use a loop.
     */
    public static int sum(final int[] aoi, int i)
    {
        if(i >= aoi.length)
            return 0;
        else
            return aoi[i++] + sum(aoi, i);
    }


    // Swap items at position i and j in aos.
    public static void swap(int[] aoi, int i, int j)
    {
        final int temp = aoi[i];
        aoi[i] = aoi[j];
        aoi[j] = temp;
    }


    /*
     *   Reverse the array items in aoi between indexes i and j inclusive.
     *
     *   Write this recursively. Do not use a loop.
     */
    private static int[] reverse(final int [] aoi, int i, int j)
    {
        swap(aoi, i++, j--);
        if(j <= i)
            return aoi;
        else
            return reverse(aoi, i, j);
    }

    /*
     *   Count the number of times target appears in aoi starting
     *   at index i.
     *
     *   Write this recursively. Do not use a fruit loop.
     */
    private static int count(final int [] aoi, final int target, int i)
    {
        if(i >= aoi.length)
            return 0;
        else if(aoi[i] == target)
            return 1 + count(aoi, target, ++i);
        else
            return count(aoi, target, ++i);
    }

    private static void tests()
    {
        int [] nums = {4, 9, 1, 3, 2, 2, 9, 2};
        System.out.println(sum(nums, 0) == 32);
        System.out.println(sum(nums, 4) == 15);
        System.out.println(sum(nums, 13) == 0);

        System.out.println(Arrays.equals(
                reverse(nums, 0, nums.length - 1),
                new int[] {2, 9, 2, 2, 3, 1, 9, 4}
        ));

        // Watchout! nums has been reversed
        System.out.println(Arrays.equals(
                reverse(nums, 2, 5),     // reverse the middle four numbers
                new int[] {2,9,1,3,2,2,9,4}
        ));

        System.out.println(count(nums, 2, 0) == 3);
        System.out.println(count(nums, 2, 13) == 0);
        System.out.println(count(nums, 2, 4) == 2);
    }

    public static void main(String [] args)
    {
        tests();
    }

}

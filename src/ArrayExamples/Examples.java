package ArrayExamples;

import java.util.Arrays;
import java.util.Random;

public final class Examples
{

    private static void f(int x)
    {
        x = 7;
    }

    // function to fill an array of integers
    // with random values between 1 and 10 inclusive

    private static void fillRandom(final int[] arr)
    {
        final Random rng = new Random(10);

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = rng.nextInt(1, 11);
        }
    }

    private static void printArray(final int[] arr)
    {
        System.out.print("[" + arr[0]);
        for(int i = 1; i < arr.length; i++)
            System.out.print(", " + arr[i]);
        System.out.println("]");
    }

    private static void printArray2(int[] arr)
    {
        System.out.print('[');

        // enhanced for loop
        for(int v : arr)
            System.out.print(v + ", ");
        System.out.println(']');
    }

    private static int sum(final int[] arr)
    {
        int total = 0;
        for(int v : arr)
            total += v;

        return total;
    }

    private static int sum2(final int[] arr)
    {
        int total = 0;
        for(int i = 0; i < arr.length; i++)
            total += arr[i];

        return total;
    }

    private static int sum3(final int[] arr)
    {
        int count = 0;
        int sum = 0;
        while(true)
        {
            try
            {
                sum += arr[count];
            }
            catch (Exception e)
            {
                break;
            }
            count++;
        }

        return sum;
    }

    private static int sum4(final int[] arr)
    {
        int i = 0;
        int sum = 0;

        while(i < arr.length)
            sum += arr[i++];

        return sum;
    }

    private static int max(final int[] arr)
    {
        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(arr[i] > maxValue)
                maxValue = arr[i];

        return maxValue;
    }

    /*
        Reverse the values on the array. Modify the actual array passed.
     */
    private static int[] reverse(final int[] arr)
    {
        int temp;
        for(int i = 0; i < arr.length/2; i++)
        {
            final int mirror = arr.length - 1 - i;
            temp = arr[i];
            arr[i] = arr[mirror];
            arr[mirror] = temp;
        }

        return arr;
    }

    /*
        Return the index of the item in an arr. If not found -1
     */

    public static int indexOf(final String[] arr, final String item)
    {
        for(int i = 0; i < arr.length; i++)
            if(arr[i].equals(item))
                return i;
        return -1;
    }

    // write a function that returns the average of an array of integers
    private static double average(final int[] arr)
    {
        return sum(arr)/ (double) arr.length;
        //return (double) sum(arr)/ arr.length; // cast takes presidense over the divide
    }

    private static double median(final int[] arr)
    {
        Arrays.sort(arr);
        final int l = arr.length;

        if(l % 2 == 0)
            return (arr[l / 2] + arr[l / 2 - 1]) / 2.0;
        else
            return arr[l / 2];
    }

    public static void main(String[] args)
    {

        final String[] names = {"Harry", "Vladimir", "Ron", "Draco"};
        System.out.println(indexOf(names, "Howard") == -1);
        System.out.println(indexOf(names, "Vladimir") == 1);

        final int[] nums = {4, 1, 0, 9, 2, 8, 10};

        reverse(nums);

        System.out.println(Arrays.equals(nums, new int[] {10, 8, 2, 9, 0, 1, 4}));

        final int[] grades = new int[10]; //allocate space for 10 grades

        System.out.println(nums[2]);
        //System.out.println(nums[-1]); //index out of range error

        fillRandom(grades);

        System.out.println(Arrays.toString(grades));
        printArray(grades);
        printArray2(grades);

        final int z = 33;
        f(z); // when z is passed to x, a copy is made
        System.out.println(z);

        System.out.println("\n --TESTS--");
        System.out.println(sum(grades) == 48);
        System.out.println(sum2(grades) == 48);
        System.out.println(sum3(grades) == 48);
        System.out.println(sum4(grades) == 48);
        System.out.println(average(grades) == 4.8);

        System.out.println(median(grades) == 4.5);
    }

}

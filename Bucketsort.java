//Brandon Kreiser
import java.util.*;

public class Bucketsort
{
    public static void main(String [] args)
    {
        int rnd;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is the maximum number you would like to generate?");
        int max = keyboard.nextInt();
        System.out.println();

        System.out.println("What is the minimum number you would like to generate?");
        int min = keyboard.nextInt();
        System.out.println();

        int range = (max - min) + 1;

        System.out.println("How large would you like the array to be?");
        int arraySize = keyboard.nextInt();
        System.out.println();
        

        int[] array = new int[arraySize];

        //Generate random integers to fill the array.
        for(int i = 0; i < array.length; i++)
        {
            rnd = (int) (Math.random() * range) + min;

            array[i] = rnd;
        }

        System.out.println("UNSORTED");
        System.out.println("-----------------------");
        printArray(array);


        bucketSort(array);

        System.out.println("SORTED");
        System.out.println("-----------------------");
        printArray(array);
    }

    public static void bucketSort(int[] array)
    {
        int max = array[0];
        int min = array[0];

        //Find the maximim and minimum integers in the array.
        for(int index = 0; index < array.length; index++)
        {
            if(array[index] > max)
                max = array[index];
            if(array[index] < min)
                min = array[index];
        }

        int[] buckets = new int[(max - min) + 1];
        
        //Initialize each bucket with the values of the array.
        for(int index = 0; index < array.length; index++)
        {
            buckets[array[index] - min]++;
        }
        
        int pointer = 0;

        //Dump the bucket values into the array.
        for(int index = 0; index < array.length; index++)
        {
            if(buckets[pointer] != 0)
            {
                array[index] = pointer + min;
                buckets[pointer]--;
            }
            else
            {
                index--;
                pointer++;
            }
        }
    }

    public static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
/* You are given an integer array nums and an integer k. Append k unique positive integers that do not appear in 
nums to nums such that the resulting total sum is minimum. Return the sum of the k integers appended to nums.
* Eg 1 : nums = [1,4,19,25,20]     k = 2                     Output = 2 + 3 = 5
* Eg 2 : nums = [5,6]              k = 6                     Output = 1 + 2 + 3 + 4 + 7 + 8 = 25
*/
import java.util.*;
public class UniqueK
{
      public long MinimalKSum(int nums[], int k)
      {
            PriorityQueue<Integer> MinHeap = new PriorityQueue<Integer>();    //*  Min Heap -> O(N)
            for(int i = 0; i < nums.length; i++)
                  MinHeap.add(nums[i]);      //! Storing -> O(N)
            long sum = 0l;
            int number = 1;    // Unique number variable...
            while(k != 0)    //! Comparison -> O(N + k)
            {
                  if(MinHeap.isEmpty())    // If the unique number is greater than Heap number...
                  {
                        sum = sum + number;
                        number++;
                        k--;       // Decrement k...
                  }
                  else if(number < MinHeap.peek())    // If the unique number is lower...
                  {
                        sum = sum + number;
                        number++;
                        k--;         // Decrement k...
                  }
                  else if(number == MinHeap.peek())   // If the unqiue number is same...
                  {     // Set the number variable as the Heap head value...
                        number = MinHeap.peek() + 1;
                        MinHeap.remove();     // Remove the Heap head...
                  }
            }
            return sum;      // Return the sum of unqiue values added...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of elements in the array : ");
            x = sc.nextInt();
            int nums[] = new int[x];
            for(int i = 0; i < nums.length; i++)
            {
                  System.out.print("Enter number : ");
                  nums[i] = sc.nextInt();
            }
            System.out.print("Enter the value of k : ");
            x = sc.nextInt();
            UniqueK uniquek = new UniqueK();    // Object creation...
            System.out.println("The Minimum Sum : "+uniquek.MinimalKSum(nums, x));  // Function calling...
            sc.close();
      }
}



//! Time Complexity -> O(N + k)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? We use the Min Heap to store the values of array, and for every missing gaps, we put the number...
 */
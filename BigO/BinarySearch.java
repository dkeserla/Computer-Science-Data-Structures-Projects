import java.util.Arrays;

public class BinarySearch
{
    public static void main(String[] args){
        System.out.println("\n\nBinary Search");
        
        int[] bigO = new int[3];
        
        int[] test10 = makeTest(10);
        System.out.println("original array is: " + Arrays.toString(test10));
        System.out.println("searching for 10 random nums in a list of 10");
        
        bigO = runTest(test10, 10);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        int[] test100 = makeTest(100);
        System.out.println("original array is: " + Arrays.toString(test100));
        System.out.println("searching for 100 random nums in a list of 100");
        
        bigO = runTest(test100, 100);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        int[] test1000 = makeTest(1000);
        System.out.println("original array is: " + Arrays.toString(test1000));
        System.out.println("searching for 1000 random nums in a list of 1000");
        
        bigO = runTest(test1000, 1000);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
    }
    
    public static int[] makeTest(int n){
        int[] ray = new int[n];
        for(int i = 0; i < n; i++)
            ray[i] = i + 1;
        return ray;
    }
    
    public static int[] runTest(int[] nums, int trials){
        int[] results = new int[3];
        results[0] = Integer.MAX_VALUE;
        for(int i = 0; i < trials; i++){
            int random = (int)(Math.random() * nums.length) + 1;
            int computations =  binarySearch(nums, random, 0, nums.length-1);
            
            results[1]+= computations;
            if(computations < results[0])
                results[0] = computations;
            if(computations > results[2])
                results[2] = computations;
        }
        results[1]/=trials;
        return results;
    }
    
    public static int binarySearch(int arr[], int x, int l, int r) 
    { 
        int mid = l + (r - l)/2; 
        
        // if(x < arr[0] || x > arr[arr.length-1])
            // return 1;
       
        if (r>=l)
            if (arr[mid] == x) 
               return 1; 
            else if (arr[mid] > x) 
               return 1 + binarySearch(arr, x, l, mid-1); 
            else
                return 1 + binarySearch(arr, x, mid+1, r);
            
        return 1; 
    
    }
}
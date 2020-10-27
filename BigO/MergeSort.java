import java.util.Arrays;

public class MergeSort
{
    public static void main(String args[]){
        
        int[] one = randArray(10);
        System.out.println("original: " + Arrays.toString(one));
        int comp = mergeSort(one,0,one.length-1);
        System.out.println("comparisons: " + comp);
        System.out.println("sorted: " + Arrays.toString(one));
        
        int[] two = new int[]{1,2,3,4,5,6,7,8,9,10};
        int comp2 = mergeSort(two, 0, two.length-1);
        System.out.println("\nsorted is: " + Arrays.toString(two));
        System.out.println("comparisons: " + comp2);
        
        int[] three = new int[]{10,9,8,7,6,5,4,3,2,1};
        int comp3 = mergeSort(three, 0, three.length-1);
        System.out.println("\nsorted is: " + Arrays.toString(three));
        System.out.println("comparisons: " + comp3);
        
        System.out.println(printData(10));
        System.out.println(printData(100));
        System.out.println(printData(1000));
    }
    
    public static String printData(int n){
        String out = "";
        out += "\nsorting 10 lists of n = " + n;
        int[] trial = trial(n);
        out += "\nbest: " + trial[0] + ", average: " + trial[1] + ", worst: " + trial[2];
        out += "\nnlog2n = " + Math.round(n * Math.log(n)/Math.log(2)) + "\tn^2 = " + ((int)Math.pow(n,2));
        return out;
    }
    
    public static int[] trial(int n){
        int[] results = new int[3];
        results[0] = Integer.MAX_VALUE;
        for(int i = 0; i < 10; i++){
            int comp = mergeSort(randArray(n), 0, n-1);
            results[1]+= comp;
            if(comp < results[0])
                results[0] = comp;
            if(comp > results[2])
                results[2] = comp;
        }   
        results[1] /= 10;
        return results;
    }
    
    public static int[] randArray(int n){
       int[] array = new int[n];
       for(int i = 0; i < array.length; i++)
           array[i] = (int)(Math.random() * n) + 1;
       return array;
    }
    
    public static int mergeSort(int[] array, int start, int end){
        int comparisons = 0;
        if(start < end){
            int mid = (start+end)/2;
            comparisons += mergeSort(array, start, mid) + mergeSort(array, mid+1, end);
            return comparisons + merge(array, start, mid, end);
        }
        return comparisons;
    }
    
    public static int merge(int[] array, int start, int mid, int end){
        int[] s = new int[mid - start];
        int[] e = new int[end - mid];
        for(int i = start; i < mid; i++)
            start[i-start] = array[i];
        for(int i = mid; i < end; i++)
            start[i-mid] = array[i];
            
        
    }
}

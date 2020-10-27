import java.util.Arrays;
public class HeapRunner
{
    public static void main(String[] args){
        int[] heapA = MinHeap.createHeap();
        System.out.println(Arrays.toString(heapA));
        System.out.println(MinHeap.size(heapA,0));
//         
//         int[] heapB = MinHeap.heapify(new int[]{50,6,22,12,27,5,2});
//         System.out.println(Arrays.toString(heapB));
//         
//         int[] heapU = MinHeap.merge(heapA,heapB);
//         System.out.println(Arrays.toString(heapU));
    }
}

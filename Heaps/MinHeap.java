
public class MinHeap
{
    public static int[] createHeap(){
        int[] heap = new int[10];
        for(int i = 0; i < heap.length; i++)
            insert(heap, (int)(Math.random()* 99) + 1);
        return heap;
    }
    
    public static int[] heapify(int[] values){
        int[] heap = new int[values.length];
        for(int i = 0; i < heap.length; i++)
            insert(heap, values[i]);
        return heap;
    }
//     
//     public static int[] merge(int[] heapA, int[] heapB){
//         int[] heapU = new int[heapA.length+heapB.length];
//         for(int i = 0; i < heapA.length; i++)
//             insert(heapU, heapA[i]);
//             
//         for(int i = 0; i < heapB.length; i++)
//             insert(heapU, heapB[i]);
//         
//         return heapU;
//     }
    
    public static int findVal(int[] heap, int value, int index){
        if(index > heap.length-1){
            return -1;
        }
        if(heap[index] == value){
            return index;
        }
        if(findVal(heap,value,index*2+1) != -1){
            return findVal(heap,value,index*2+1);
        }
        return findVal(heap,value,index*2+2);
        
    }
    
    public static void insert(int[] heap, int value){
        int index = nextLeaves(heap);
        if(index == -1 || findVal(heap, value,0) != -1)
            return;
        
        heap[index] = value;
        
        siftUp(heap, index);
    }
    
    public static void siftUp(int[] heap, int index){
        int parent = (index - 1)/2;
        if(parent > -1 && heap[index] < heap[parent]){
            swap(heap, index, parent);
            siftUp(heap,parent);
        }
    }
//     
//     public static void siftDown(int[] heap, int index){
//         int childA = 2*index+1;
//         int childB = 2*index+2;
//         while((childA < heap.length && heap[index] < heap[childA]) || (childB < heap.length && heap[index] < heap[childB]))
//             if(heap[index] < heap[childA]){
//                 swap(heap, index, childA);
//                 index = childA;
//                 childA = 2*index+1;
//                 childB = 2*index+2;
//             }
//             else if(heap[index] < heap[childB]){
//                 swap(heap, index, childB);
//                 index = childB;
//                 childA = 2*index+1;
//                 childB = 2*index+2;
//             }
//     }
//     
    public static void swap(int[] heap, int a, int b){
        int temp  = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    
    public static int nextLeaves(int[] heap){
        return findVal(heap,0,0);
    }
//     
    public static int size(int[] heap, int index){
        if(index > heap.length -1 || heap[index] == 0){
            return 0;
        }
        return size(heap,index*2+1) + size(heap,index*2+2) + 1;
    }
    
    public static boolean isEmpty(int[] heap){
        return size(heap,0) == 0;
    }
    
    public static int findMin(int[] heap){
        return heap[0];
    }
    
}

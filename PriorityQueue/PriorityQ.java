package PriorityQueue;
// A priority queue is a data structure that allows you to efficiently retrieve the element with the highest (or lowest) priority.
// In Java, you can implement a priority queue using the `PriorityQueue` class from the `java.util` package.
// The `PriorityQueue` class in Java is a min-heap by default, 
// which means that the element with the lowest priority (or smallest value) will be retrieved first.
//  However, you can customize the behavior of the priority queue by providing a comparator to
//  define the ordering of elements based on their priority.

// We will heap structure from scratch and implement the following operations:
// 1. insert: Add an element to the priority queue with a given priority.
// 2. peek: Retrieve the element with the highest priority without removing it from the queue.
// 3. poll: Retrieve and remove the element with the highest priority from the queue.
// 4. isEmpty: Check if the priority queue is empty.






class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap() {
        this.heap = new int[100];
        this.size = 0;
    }

    private void upheapify(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap[parent] >= heap[index]) {
                break;
            }

            swap(parent, index);
            index = parent;
        }
    }

    public void insert(int val) {
        if (size == heap.length) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = val;
        upheapify(size);
        size++;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        return heap[0];
    }

    public int remove() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        downheapify(0);

        return max;
    }

    private void downheapify(int index) {
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}


public class PriorityQ {
   
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 1, 5, 9 };
        MaxHeap pq = new MaxHeap();

        for (int val : arr) {
            pq.insert(val);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}

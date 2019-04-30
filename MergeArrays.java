import java.util.PriorityQueue;


public class MergeArrays {
	
    static int[] mergeArrays(int[][] arr) {
        int K = arr.length;
        int N = arr[0].length;
        // Get appropriate priority queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(); 
        for (int i = 0; i < K; i++) {
            priorityQueue.add(new Node(arr[i][0], i, 0));
        }
        int ans[] = new int[N * K];
        int pointer = 0;
        while (pointer < N * K) {
            Node rem = priorityQueue.poll();
            ans[pointer++] = rem.value;
            // Add the next element from the same row from which element is
            // removed, if available
            if (rem.column + 1 < N) {
                priorityQueue.add(new Node(arr[rem.row][rem.column + 1], rem.row, 
                    rem.column + 1));
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	
    }

}

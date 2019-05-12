package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesAtK {
	
	public static void main(String[] args)  
	{
		Node root = new Node(8); 
		root.left = new Node(-3); 
		root.left.left = new Node(-10); 
		root.left.right = new Node(1);
		
		root.right = new Node(14);
		root.right.left = new Node(10);
		root.right.left.right = new Node(12);
		root.right.right = new Node(17);
	
		/* Print all root-to-leaf paths of the input tree */
		printKNodes(root, 2);
		System.out.println();
		printKNodesBFS(root, 2);
	}

	private static void printKNodes(Node root, int k) {
		if (root == null || k==0) return;
		
		printKNodes(root.left, k-1);
		System.out.print(root.data + " ");
		printKNodes(root.right, k-1);
	}
	
	private static void printKNodesBFS(Node root, int k) {
		if (root == null || k==0) return;
		
		Queue<Node> myQueue = new LinkedList<Node>();
		myQueue.add(root);
		int counter=0;

		while (!myQueue.isEmpty() && k>0) {
			Node currentNode = myQueue.poll();
			if (currentNode.left != null) myQueue.add(currentNode.left);
			if (currentNode.right != null) myQueue.add(currentNode.right);
			
			System.out.println("\n Loop No.: " + counter + " k: " + k);
			//queuePrint(myQueue);
			counter+=1;
			
			myQueue.add(new Node(999));	
			
			if (currentNode.data == 999) { 
				myQueue.add(new Node(999));
				k--;
			} else {
				System.out.print(currentNode.data + " ");
			}
		}
	}
	
	private static void queuePrint(Queue<Node> printQueueData) {
		for (Node x: printQueueData) {
			System.out.print(x.data + " ");
		}
	}
}

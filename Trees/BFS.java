package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		Node root = new Node(8); 
		root.left = new Node(-3); 
		root.left.left = new Node(-10); 
		root.left.right = new Node(1);
		
		root.right = new Node(14);
		root.right.left = new Node(10);
		root.right.left.right = new Node(12);
		root.right.right = new Node(17);
		
		breadthFirstSearch(root);
		
	}

	private static void breadthFirstSearch(Node root) {

		Queue<Node> treeQ = new LinkedList<Node>();
		treeQ.add(root);

		Node currentNode = root;
		while(!treeQ.isEmpty()) {
			
			currentNode = treeQ.poll();
			System.out.println(currentNode.data);
			
			if (currentNode.left != null) treeQ.add(currentNode.left);
			if (currentNode.right != null) treeQ.add(currentNode.right);
			
		}
	}
}

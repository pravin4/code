package Trees;

import java.util.Stack;

public class TreeTraversal {
	/* Driver program to test all above functions */
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
		System.out.print("InOrderRecursive ");
		InOrderRecursive(root);
		System.out.println();
		postOrderIterative(root);
		preOrderIterative(root);
		System.out.print("PostOrderRecursive ");
		postOrderRecursive(root);
		System.out.println();
		System.out.print("PreOrderRecursive ");
		preOrderRecursive(root);
	}

	private static void InOrderRecursive(Node root) {
		if (root == null) return;
		
		if (root.left != null) InOrderRecursive(root.left);
		System.out.print(root.data + " ");
		if (root.right != null) InOrderRecursive(root.right);
	}
	
	private static void postOrderRecursive(Node root) {
		if (root == null) return;
		
		if (root.left != null) postOrderRecursive(root.left);
		if (root.right != null) postOrderRecursive(root.right);
		System.out.print(root.data + " ");

	}
	
	private static void preOrderRecursive(Node root) {
		if (root == null) return;
		System.out.print(root.data + " ");

		if (root.left != null) preOrderRecursive(root.left);
		if (root.right != null) preOrderRecursive(root.right);
	}
	
	static void postOrderIterative(Node root) {
		System.out.print("PostOrderIterative ");
		if (root == null) return;

		Stack<Node> currentStack = new Stack<Node>();
		Stack<Node> iteratedStack = new Stack<Node>();

		currentStack.push(root);
		while(!currentStack.isEmpty()) {
			Node currentNode = currentStack.pop();
			iteratedStack.push(currentNode);

			if (currentNode.left != null) {
				currentStack.push(currentNode.left);
			}

			if (currentNode.right != null) {
				currentStack.push(currentNode.right);
			}
		}
		printStack(iteratedStack);
	}

	
	private static void preOrderIterative(Node root) {
		System.out.print("PreOrderIterative ");

		if (root == null) return;

		Stack<Node> currentStack = new Stack<Node>();
		currentStack.push(root);
		while (!currentStack.isEmpty()) {
			Node currentNode = currentStack.pop();
			System.out.print(currentNode.data + " ");
			
			if (currentNode.right != null) {
				currentStack.push(currentNode.right);
			}
			
			if (currentNode.left != null) {
				currentStack.push(currentNode.left);
			}
		}
		System.out.println();
	}

	private static void printStack(Stack<Node> iteratedStack) {
		// Print all elements of second stack s2
		StringBuilder output = new StringBuilder();
		while(!iteratedStack.isEmpty()) {
			output.append(iteratedStack.pop().data).append(" ");
		}
		System.out.print(output.toString().trim() + "\n");
	}
}

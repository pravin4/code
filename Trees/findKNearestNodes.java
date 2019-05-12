package Trees;

public class findKNearestNodes {

	public static void main(String[] args) {

		Node root = new Node(4); 
		root.left = new Node(3); 
		root.right = new Node(5); 
		root.left.left = new Node(1); 
		root.left.right = new Node(4); 

		/* Print all root-to-leaf paths of the input tree */
		System.out.println(findNext(root, root.left.left, true));   
	}

	private static char[] findNext(Node root, Node left, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
}

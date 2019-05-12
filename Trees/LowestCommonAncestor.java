package Trees;

public class LowestCommonAncestor {
	
	public static void main(String[] args)  
	{    
		Node root = new Node(5); 
		root.left = new Node(3); 
		root.right = new Node(6); 
		root.left.left = new Node(1); 
		root.left.right = new Node(4); 

		/* Print all root-to-leaf paths of the input tree */
		System.out.println(findLCA(root, 1, 6).data);    
	}

	private static Node findLCA(Node root, int i, int j) {
		if (root == null) return null;
		
		// if node found return node
		if (root.data == i || root.data == j) return root;
		
		// recurse the left and right subtrees
		Node left = findLCA(root.left, i, j);
		Node right = findLCA(root.right, i, j);
		
		// if node found return node, else return null, if a node has both right and left
		// then it is the LCA, since the right/left subtree returns null if not found
		
		if (left != null && right !=null) return root;
		else return (left != null?  left : right);
		
	}
}

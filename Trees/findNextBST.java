package Trees;

public class findNextBST {
	
	public static void main(String[] args)  
	{    
		Node root = new Node(4); 
		root.left = new Node(3); 
		root.right = new Node(5); 
		root.left.left = new Node(1); 
		root.left.right = new Node(4); 

		/* Print all root-to-leaf paths of the input tree */
		System.out.println(findNext(root, root.left.left, true));    
	}

	private static Node findNext(Node root, Node n, boolean b) {

		if (root == null) return null;

		if (n.right != null) {
			return getMin(n.right);
		} 
		
		Node p = n.parent; 
        while (p != null && n == p.right) { 
            n = p; 
            p = p.parent; 
        } 
        return p;
	}
	
    private static Node getMin(Node node) { 
        Node current = node; 
  
        /* loop down to find the leftmost leaf */
        while (current.left != null) { 
            current = current.left; 
        } 
        return current; 
    } 
    
    private static Node getMax(Node node) { 
        Node current = node; 
  
        /* loop down to find the leftmost leaf */
        while (current.right != null) { 
            current = current.right; 
        } 
        return current; 
    } 
	

}

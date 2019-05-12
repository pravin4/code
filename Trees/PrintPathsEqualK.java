package Trees;

public class PrintPathsEqualK {
	
	 /* Driver program to test all above functions */
    public static void main(String[] args)  
    {    
        Node root = new Node(10); 
        root.left = new Node(20); 
        root.right = new Node(30); 
        root.left.left = new Node(40); 
        root.left.right = new Node(50); 
   
        /* Print all root-to-leaf paths of the input tree */
	    printPaths(root, new int[10], 0, 80);    
    }

	private static void printPaths(Node root, int path[], int pathlen, int k) {
		if (root == null) return;
		
		path[pathlen] = root.data;
		pathlen++;
		
		if (root.left == null && root.right == null && k == root.data) {
			printArray(path, pathlen); 
		} else {
			printPaths(root.left, path, pathlen, k-root.data);
			printPaths(root.right, path, pathlen, k-root.data);
		}	
	}
	
	static void printArray(int ints[], int len)  
	{ 
		for (int i = 0; i < len; i++)  {
			System.out.print(ints[i] + " "); 
		}
		System.out.println(""); 
	}

}

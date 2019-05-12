package Trees;


public class PrintPaths {
	 /* Driver program to test all above functions */
    public static void main(String[] args)  
    {    
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
   
        /* Print all root-to-leaf paths of the input tree */
        printPaths(root);    
    }
    
	private static void printPaths(Node root) {		  
	    int path[] = new int[5];  
	    printPathsRecur(root, path, 0);  
	} 
	
	/* Utility that prints out an array on a line */
	static void printArray(int ints[], int len)  
	{ 
		for (int i = 0; i < len; i++)  {
			System.out.print(ints[i] + " "); 
		}
		System.out.println(""); 
	}
	
	static void printPathsRecur(Node node, int path[], int pathlen) {
		if (node == null) return; 
		
		path[pathlen] = node.data;
		pathlen++;
		
		if (node.left == null && node.right == null) {
			printArray(path, pathlen); 
		} else {
			printPathsRecur(node.left, path, pathlen);
			printPathsRecur(node.right, path, pathlen);
		}
		
	}
 

}

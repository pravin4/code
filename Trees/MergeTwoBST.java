package Trees;

import java.util.ArrayList;

public class MergeTwoBST {

	public static void main(String[] args)  
	{    
		Node root1 = new Node(5); 
		root1.left = new Node(3); 
		root1.right = new Node(6); 
		root1.left.left = new Node(1); 
		root1.left.right = new Node(4); 

		Node root2 = new Node(15); 
		root2.left = new Node(13); 
		root2.right = new Node(16); 
		root2.left.left = new Node(11); 
		root2.left.right = new Node(14); 

		/* Print all root-to-leaf paths of the input tree */
		merge(root1, root2);    
	}

	private static void merge(Node root1, Node root2) {

		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		inorderTraversal(root1, arr1);
		System.out.println(arr1);

		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		inorderTraversal(root2, arr2);
		System.out.println(arr2);

		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3 = mergeTwoArrays(arr1, arr2);
		System.out.println(arr3);

		Node mergedTree = convertArrayToBST(arr3,0,arr3.size()-1);
		System.out.println(mergedTree.data);
		System.out.println("InOrder");
		printInorder(mergedTree);
		System.out.println("\nPreOrder");
		printPreorder(mergedTree);
		System.out.println("\nPostOrder");
		printPostorder(mergedTree);


	}

	private static void printInorder(Node node) 
	{ 
		if (node == null) return; 
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right); 
	}

	private static void printPreorder(Node node) 
	{ 
		if (node == null) return; 
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right); 
	}

	private static void printPostorder(Node node) 
	{ 
		if (node == null) return; 
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	private static void inorderTraversal(Node root, ArrayList<Integer> arr1) {
		if (root == null) return;

		inorderTraversal(root.left, arr1);
		arr1.add(root.data);
		inorderTraversal(root.right, arr1);
	}

	private static ArrayList<Integer> mergeTwoArrays(ArrayList<Integer> arr1,
			ArrayList<Integer> arr2) {

		if (arr1.isEmpty()) return arr2;
		else if (arr2.isEmpty()) return arr1;
		else {
			int i=0, j=0;
			ArrayList<Integer> arr3 = new ArrayList<Integer> ();
			while (i < arr1.size() && j< arr2.size()) {
				if (arr1.get(i) < arr2.get(j)) {
					arr3.add(arr1.get(i));
					i++;
				} else {
					arr3.add(arr2.get(j));
					j++;
				}
			}

			while (i < arr1.size()) {
				arr3.add(arr1.get(i));
				i++;
			}

			while (j < arr2.size()) {
				arr3.add(arr2.get(j));
				j++;
			}
			return arr3;
		}

	}

	private static Node convertArrayToBST(ArrayList<Integer> arr, int start, int end) {

		if (start > end) return null; 

		int mid = (start+end)/2;
		Node node = new Node(arr.get(mid));
		node.left = convertArrayToBST(arr, start, mid-1); 
		node.right = convertArrayToBST(arr, mid+1, end); 
		return node;
	}


}

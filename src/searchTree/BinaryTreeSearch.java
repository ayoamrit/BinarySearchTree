package searchTree;

public class BinaryTreeSearch {
	Node root;  //root node
	
	//insert method 
	public void insert(Node node) {
		
		//calling helper method to insert values to the root node
		root = insertHelper(root, node);
		
	}
	
	//insert helper method
	private Node insertHelper(Node root, Node node) {

		int data = node.data; //data variable
		
		//if the root is null
		if(root == null) {
			root = node;
			return root;
		}
		else if(data < root.data) {  //the value is lesser than the parent value
			
			//pushing value to left side of the parent node
			root.left = insertHelper(root.left, node);
		}
		else {  //the value is greater than the parent value
			
			//pushing value to right side of the parent node
			root.right = insertHelper(root.right, node);
		}
		
		//returning root
		return root;
	}
	
	
	//display method
	public void display() {
		
		//calling helper method 
		displayHelper(root);
	}
	
	//display helper method 
	private void displayHelper(Node root) {
		
		//if the root is null then nothing would be printed as there would be nothing
		//in the Binary Search Tree
		
		//the root is not null
		if(root != null) {
			
			//it is a non-tail recursion function because it has functions to perform after 
			//recursion call
			
			displayHelper(root.left);  //going to the farthest left to print the smallest value first
			System.out.println(root.data);  //printing 
			displayHelper(root.right);  //going to right of the node 
		}
	}
	
	//search method 
	public boolean search(int data) {
		
		//returning true if the value exist in the Binary Tree Search
		return searchHelper(root, data);
	}
	
	//search helper method 
	private boolean searchHelper(Node root, int data) {
		
		//base case
		//root would be null when the method went through all the nodes and did
		//not find the required value
		if(root == null) {
			return false;  //returning false
		}
		else if(root.data == data) {  //value found in the BST
			return true;  //returning true
		}
		else if(root.data > data) {  //when the parent node is greater than the required value
			
			//going left
			return searchHelper(root.left,data);
		}
		else {  //when the parent node is lesser than the required value
			
			//going right
			return searchHelper(root.right, data);
		}
	}

	
	//remove method 
	public void remove(int data) {
		
		//checking whether the value exists in the BST or not 
		if(search(data)) {
			
			//calling helper method to remove the value 
			removeHelper(root, data); 
			
			//printing message
			System.out.println(data+ " has removed successfully");
		}
		else {  //required value does not exist in the Binary Search Tree
			System.out.println(data+" does not exist in the Binary Search Tree");
		}
	}
	
	//remove helper method 
	private Node removeHelper(Node root, int data) {
		
		//base case 
		//when root is null
		if(root == null) {
			return root;  //return
		}
		else if(data < root.data) {  //the parent node is grater than the required value
			
			root.left = removeHelper(root.left, data);  //going left
		}
		else if(data > root.data){  //the parent node is lesser than the required value
			
			root.right = removeHelper(root.right, data);  //going right
		}
		else {  //node found
			
			//once the node has been found we have to fill the gap of the value being removed 
			//unless it is a leaf node
			
			//the value is left node in BTS
			//leaf node: the node that does not have any children
			if(root.left == null && root.right == null) {
				root = null;
			}
			else if(root.right != null){  //node has right children
				
				//getting the value from successor method 
				root.data = successor(root);
				
				//recursion
				root.right = removeHelper(root.right, root.data);
			}
			else {  //node has left children
				
				//getting the value from predecessor method 
				root.data = predecessor(root);
				
				//recursion
				root.left = removeHelper(root.left, root.data);
			}
		}
		
		return root;  //returning root 
	}
	
	private int successor(Node root) {  //greater value than parent node
		
		//take one step right and then go all the way down left
		root = root.right;
		
		//using while loop to get the farthest left value in the BTS
		while(root != null) {
			root = root.left;
		}
		
		//returning
		return root.data;
	}
	
	private int predecessor(Node root) {  //smaller value than parent node
		
		//take one step left and then go all the way down right
		root = root.left;
		
		//using while loop to get the farthest right value in the BTS
		while(root != null) {
			root = root.right;
		}
		
		//returning 
		return root.data;
	}
}

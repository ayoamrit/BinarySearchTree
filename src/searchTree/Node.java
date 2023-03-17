package searchTree;

//node class
public class Node {
	int data;  //initializing variable
	Node left;  //left node
	Node right;  //right node
	
	
	//constructor 
	public Node(int data) {
		this.data = data;  //setting value of the local node
		left = null;  //setting left to null
		right = left;  //setting right to null
	}
	
}

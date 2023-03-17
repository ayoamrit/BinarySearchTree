package main;
import searchTree.*;

/*
-Binary Search Tree is a data structure that allows us to keep a sorted list of numbers
-in a short amount of time. It is slightly different from Binary Tree as in Binary Search Tree
-left child node is always lesser than its parent and vice versa.

-TIME COMPLEXITY or TC
-TC of creating a binary search tree (unsorted elements): O(nlogn)
-TC of creating a binary search tree (sorted elements): O(n^2)

-TC to insert one element: O(n)
-TC to insert n elements: O(n^2)

-Searching in binary search tree has worst-case complexity of O(n).
-In general, the time complexity is O(h) where h is the height of the binary search tree.

This program is created by: Amrit Dhaliwal
**********Github: ayoamrit****************
*/
public class Main {
	
	//main method 
	public static void main(String[] args) {
		
		//creating object of the class
		BinaryTreeSearch BST = new BinaryTreeSearch();
		
		//calling method to insert nodes to the Binary Search Tree
		BST.insert(new Node(10));
		BST.insert(new Node(11));
		BST.insert(new Node(5));
		BST.insert(new Node(25));
		BST.insert(new Node(1));
		BST.insert(new Node(89));
		BST.insert(new Node(56));
		BST.insert(new Node(44));
		
		//calling function to display all of the nodes
		BST.display();
		
		//calling method to search for a number in Binary Tree
		System.out.println(BST.search(2));
		
		//calling method to remove node in Binary Search Tree
		BST.remove(44);
	}
}

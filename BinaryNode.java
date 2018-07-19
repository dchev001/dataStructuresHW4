/*
  COURSE: COP 3530
  Section: U02
  Semester: Fall 2012
  Instructor: Alex Pelin
  Author: Daniel Chevez
  Assignment: 4
  Due Date: November 15, 2012
  Description: This homework consisted of five methods which deals with binary trees.
  Which are the isomorphic(), buildTheTree(), levelsPlusIn(), postPlusIn(), and
  printByLevels(). The isomorphic() determines if two binary trees are ismorphic. The
  buildTheTree() builds a binary tree given the input string. The levelsPlusIn() 
  constructs a binary tree with the level order and inorder traversals of a binary 
  tree. The postPlusIn() constructs a binary tree with the post order and inorder
  traversals of a binary tree. The printByLevels() prints the binary tree by its
  levels.

  I certify that the work is my own and did not consult with anyone.

 */


import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;


public class BinaryNode <T>
{
    // the fields
    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    
    // create a default binary node
    public BinaryNode()
    {
	this(null, null, null);
    }
    
    // create a node with a given value and children
    public BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt)
    {
	element = theElement;
	left = lt;
	right = rt;
    }
    
    // the get element
    public T getElement()
    {
	return element;
    }
    
    // get the left child
    public BinaryNode<T> getLeft()
    {
	return left;
    }
    
    // get the right child
    public BinaryNode<T> getRight()
    {
	return right;
    }
    
    // set the T element 'x' to 'element'
    public void setElement(T x)
    {
	element = x;
    }
    
    // set the BinaryNode element 't' to 'left'
    public void setLeft(BinaryNode<T> t)
    {
	left = t;
    }
    
    // set the BinaryNode element 't' to 'right'
    public void setRight(BinaryNode<T> t)
    {
	right = t;
    }
    
    // calculates the size of the binary tree from the BinaryNode at 't'
    public static <T> int size(BinaryNode<T> t)
    {
	if (t == null)
	    return 0;
	else
	    return 1 + size(t.left) + size(t.right);
    }
    
    // calculates the height of the binary tree form teh BinaryNode at 't'
    public static <T> int height(BinaryNode<T> t)
    {
	if (t == null)
	    return -1;
	else
	    return 1 + Math.max(height(t.left), height(t.right));
    }
    
    // tries to find if 'inq' occurs in the binary tree
    public BinaryNode<T> find(T inq)
    {
	// check if Node element == inq
	if (element.equals(inq))
	    return this;
	
	// create Binary object, out
	BinaryNode<T> out = null;
	
	// check left subtree
	if (left != null)
	    out = left.find(inq);
	
	// check if out != null, else check right subtree
	if (out != null)
	    return out;
	else
	    out = right.find(inq);
	
	// return out
	return out;
    }
    
    // creat a duplicate binary tree
    public BinaryNode<T> duplicate()
    {
	// create a BinaryNode, root
	BinaryNode<T> root = new BinaryNode<T>(element, null, null);
	
	// check if BinaryNode root has left subtree, create duplicate left
	if (left != null)
	    root.left = left.duplicate();
	
	// check if BinaryNode root has right subtree, create duplicate right
	if (right != null)
	    root.right = right.duplicate();
	
	// return BinaryNode root
	return root;
    }
    
    // print the preorder of the binary tree
    public void printPreOrder()
    {
	// print the binary tree element
	System.out.println(element);
	
	// check left subtree, if true go to left subtree
	if (left != null)
	    left.printPreOrder();
	
	// check right subtree, if true go to right subtree
	if (right != null)
	    right.printPreOrder();
    }
    
    // print the tree elements in post-order
    public void iterativePreOrder()
    {
	// create a Stack object, s
	Stack<BinaryNode<T>> s = new Stack();

	// create a BinaryNode
	BinaryNode<T> current = this;
	
	// check condition
	while (current != null || !s.empty())
	    {
		if (current != null)
		    {
			// print element
			System.out.println(current.element);
			// push current onto stack
			s.push(current);
			// reassigning current
			current = current.left;
		    }
		else
		    {
			// pop the stack
			current = s.pop();
			// reassigning current
			current = current.right;
		    }
	    }
    }
    
    // print the tree elements in in-order
    public void iterativeInOrder()
    {
	// create a Stack object, s
	Stack<BinaryNode<T>> s = new Stack();
	
	// create a BinaryNode, current
	BinaryNode current = this;
	
	// check condition
	while (current != null || !s.empty())
	    {
		if (current != null)
		    {
			// push current onto stack
			s.push(current);
			// reassigning current
			current = current.left;
		    }
		else
		    {
			// pop the stack
			current = s.pop();
			// print element
			System.out.println(current.element);
			// reassigning current
			current = current.right;
		    }
	    }
    }
    
    // print in post-order of the binary tree
    public void printPostOrder()
    {
	// check left subtree, if true go to left subtree
	if (left != null)
	    left.printPostOrder();
	
	// check right subtree, if true go to right subtree
	if (right != null)
	    right.printPostOrder();
	
	// print the binary tree element
	System.out.println(element);
    }
    
    // print the tree elements in in-order
    public void printInOrder()
    {
	// check left subtree
	if (left != null)
	    left.printInOrder();
	
	// print element
	System.out.println(element);
	
	// check right subtree
	if (right != null)
	    right.printInOrder();
    }
    
    // prints the binary tree by levels
    public void printByLevels()
    {
	// create a LinkedList object, s
	LinkedList<BinaryNode<T>> s = new LinkedList();
	
	// assigning current
	BinaryNode<T> current = this;
	
	// check condition
	while (current != null || !s.isEmpty())
	    {
		// print the element
		System.out.println(current.getElement());

		// check left subtree, if true add
		if (current.getLeft() != null)
		    {
			s.add(current.getLeft());
		    }
		
		// check right subtree, if true add
		if (current.getRight() != null)
		    {
			s.add(current.getRight());
		    }
		
		// remove the first element
		current = s.removeFirst();
	    }
    }
    
    // builds a binary tree from the given input inorder and postorder trees
    public static <T> BinaryNode<T> postPlusIn(T[] post, T[] in)
    {
	// throw IllegalArguementException
	if (post == null || in == null || post.length != in.length)
	    throw new IllegalArgumentException();
	
	// construct BinaryNode, root
	BinaryNode<T> root = new BinaryNode();
	
	// construct ArrayList, postOrder; with post elements
	ArrayList<T> postOrder = new ArrayList<T>(Arrays.asList(post));
	
	// construct ArrayList, inOrder; with in elements
	ArrayList<T> inOrder = new ArrayList<T>(Arrays.asList(in));
	
	// check for condition of both postOrder and inOrder
	if (!postOrder.isEmpty() && !inOrder.isEmpty())
	    {
		// ArrayList for the left and right sides for postOrder and inOrder
		ArrayList<T> postLeft = new ArrayList<T>();
		ArrayList<T> postRight = new ArrayList<T>();
		ArrayList<T> inLeft = new ArrayList<T>();
		ArrayList<T> inRight = new ArrayList<T>();
		
		// variables for in and post position
		int inOrderPos;
		int postOrderPos;
		
		// gets the last element of postOrder and sets it as the root
		root.setElement(postOrder.get(postOrder.size() - 1));
		
		// gets the index of the element occurence in inOrder
		inOrderPos = inOrder.indexOf(root.getElement());
		
		// adds all the inOrder elements to inLeft, 0 to inOrderPos
		inLeft.addAll(inOrder.subList(0, inOrderPos));
		
		// adds all the inOrder elements to inRight, inOrderPos+1, to end
		inRight.addAll(inOrder.subList(inOrderPos + 1, inOrder.size()));
		
		// gets the inLeft size to assign to postOrderPos
		postOrderPos = inLeft.size();
		
		// adds all the postOrder elements to postLeft
		postLeft.addAll(postOrder.subList(0, postOrderPos));
		
		// adds all the postOrder elements to postRight
		postRight.addAll(postOrder.subList(postOrderPos, postOrder.size() - 1));
		
		// check if left sides of in and post are not empty
		if (!inLeft.isEmpty() && !postLeft.isEmpty())
		    root.setLeft(postPlusIn((T[]) postLeft.toArray(), (T[]) inLeft.toArray()));
		
		// check if right sides of in and post are not empty
		if (!inRight.isEmpty() && !postRight.isEmpty())
		    root.setRight(postPlusIn((T[]) postRight.toArray(), (T[]) inRight.toArray()));
	    }
	
	// return root
	return root;
    }
    
    // constructs a tree given the input of inorder and level binary tree traversal
    public static <T> BinaryNode<T> levelsPlusIn(T[] in, T[] levels)
    {
	// not implemented
	return null;
    }
    
    // builds a binary tree given the input string
    public static BinaryNode<Character> buildTheTree(String in)
    {
	// not implemented
	return null;
    }
    
    // tests wheather two trees are isomorphic
    public boolean isomorphic(BinaryNode<T> r)
    {
	// assigning the t1, t2
	BinaryNode<T> t1 = this;
	BinaryNode<T> t2 = r;
	
	// check if the binary trees are null
	if (t1 == null || t2 == null)
	    return false;
	
	// check if elements of the trees equal each other, else check left & right
	if (t1.getElement() == t2.getElement())
	    return true;
	else
	    return isomorphic(r.getLeft()) && isomorphic(r.getRight());
    }
}

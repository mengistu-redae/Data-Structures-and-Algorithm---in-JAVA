package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import data.Student;

public class BinarySearchTree {

	public static Node createBinarySearchTree1() {

		Node head = null;

		Node n1 = new Node(new Student(1, "Werku", "Kassa", "Food Engineering"));
		Node n2 = new Node(new Student(2, "Lemlem", "Hagos", "Electrical Engineering"));
		Node n3 = new Node(new Student(3, "Hailemariam", "Teklay", "Comunication Engineering"));
		Node n4 = new Node(new Student(4, "Pliny", "Mengistu", "Information Technology"));
		Node n5 = new Node(new Student(5, "Liwam", "Atakilti", "Civil Engineering"));
		Node n6 = new Node(new Student(6, "Silondis", "Mengistu", "Computer Science"));
		Node n7 = new Node(new Student(7, "Negasi", "Hafte", "Comunication Engineering"));
		Node n8 = new Node(new Student(8, "Kibrom", "Gebrehiwot", "Information Technology"));
		Node n9 = new Node(new Student(9, "Abeba", "Redae", "Software Engineering"));
		Node n10 = new Node(new Student(10, "Hayelom", "Gebre", "Chemical Engineering"));

		head = addNodeToBinarySearchTreeIteratively(head, n6); // adding node Iteratively
		addNodeToBinarySearchTreeIteratively(head, n8);
		addNodeToBinarySearchTreeIteratively(head, n5);
		addNodeToBinarySearchTreeIteratively(head, n10);
		addNodeToBinarySearchTreeIteratively(head, n4);
		addNodeToBinarySearchTreeIRecursively(head, n1); // adding node recursively
		addNodeToBinarySearchTreeIRecursively(head, n9);
		addNodeToBinarySearchTreeIRecursively(head, n7);
		addNodeToBinarySearchTreeIRecursively(head, n3);
		addNodeToBinarySearchTreeIRecursively(head, n2);

		return head;
	}

	public static Node createBinarySearchTree2() {

		Node head = null;

		Node n11 = new Node(new Student(11, "Hawi", "Abera", "Electrical Engineering"));
		Node n12 = new Node(new Student(12, "Robel", "Arega", "Computer Science"));
		Node n13 = new Node(new Student(13, "Melaku", "Tena", "Software Engineering"));
		Node n14 = new Node(new Student(14, "Mesfin", "Haletu", "Information Technology"));

		head = addNodeToBinarySearchTreeIteratively(head, n13);
		addNodeToBinarySearchTreeIteratively(head, n11);
		addNodeToBinarySearchTreeIteratively(head, n12);
		addNodeToBinarySearchTreeIteratively(head, n14);

		return head;
	}

	public static Node addNodeToBinarySearchTreeIteratively(Node head, Node newNode) {
		if (newNode == null)
			return head;
		if (head == null)
			return newNode;

		Node current = head;
		Node insertionPosition = head;
		while (current != null) {
			if (newNode.getStudent().getStudentId() == current.getStudent().getStudentId())
				return head;

			if (newNode.getStudent().getStudentId() < current.getStudent().getStudentId()) {
				insertionPosition = current;
				current = current.getLeft();
			} else if (newNode.getStudent().getStudentId() > current.getStudent().getStudentId()) {
				insertionPosition = current;
				current = current.getRight();
			}
		}

		if (newNode.getStudent().getStudentId() < insertionPosition.getStudent().getStudentId())
			insertionPosition.setLeft(newNode);

		if (newNode.getStudent().getStudentId() > insertionPosition.getStudent().getStudentId())
			insertionPosition.setRight(newNode);

		return head;
	}

	public static Node addNodeToBinarySearchTreeIRecursively(Node head, Node newNode) {
		if (newNode == null)
			return head;
		if (head == null)
			return newNode;

		if (newNode.getStudent().getStudentId() < head.getStudent().getStudentId()) {
			if (head.getLeft() == null)
				head.setLeft(newNode);
			else
				addNodeToBinarySearchTreeIRecursively(head.getLeft(), newNode);
		}

		if (newNode.getStudent().getStudentId() > head.getStudent().getStudentId()) {
			if (head.getRight() == null)
				head.setRight(newNode);
			else
				addNodeToBinarySearchTreeIRecursively(head.getRight(), newNode);
		}

		return head;
	}

	/*
	 * For Binary trees, there are two types of traversals(searches): ~ Depth First
	 * Search (DFS) - traversal ~ Breadth-First Search (BFS) - traversal
	 * 
	 * DFS: - stack is used to track nodes - Note:- if there is a recursive solution
	 * to a problem, it means it uses stack data structure - there are three types
	 * of DFS traversals ~ Pre-Order (Parent-Left-Right) ~ In-Order
	 * (Left-Parent-Right) ~ Post-Order(Left-Right-Parent)
	 * 
	 * BFS is also called Level-Order Traversal - queue is used to track nodes -
	 * only solved in Iterative way i.e. there is no recursive solution for BFS -
	 * Note:- if iterative way is the only solution to a problem, it means it uses
	 * queue data structure - The algorithm is: ~ Initialize an empty queue ~ Start
	 * with setting temp as root ~ Run a Loop till queue is not empty: Print data
	 * from temp Enqueue temp’s children in the order left then right Dequeue a node
	 * from the queue and assign it’s value to temp
	 * 
	 */

	public static ArrayList<Student> depthFirstTraversalIteratively(Node head) {
		if (head == null)
			return new ArrayList<Student>();

		ArrayList<Student> students = new ArrayList<Student>();

		ArrayList<Node> stack = new ArrayList<Node>();
		stack.add(head);
		while (!stack.isEmpty()) {
			Node current = stack.remove(stack.size() - 1);
			students.add(current.getStudent());
			if (current.getRight() != null)
				stack.add(current.getRight());
			if (current.getLeft() != null)
				stack.add(current.getLeft());
		}

		return students;
	}

	public static ArrayList<Student> depthFirstTraversalRecursively(Node head, ArrayList<Student> students) {
		if (head == null)
			return students;

		students.add(head.getStudent());
		depthFirstTraversalRecursively(head.getLeft(), students);
		depthFirstTraversalRecursively(head.getRight(), students);

		return students;
	}

	// Iterative way the only solution for breadth-first traversal i.e. no recursive
	// solution
	public static ArrayList<Student> breadthFirstTraversalIteratively(Node head) {
		if (head == null)
			return new ArrayList<Student>();

		ArrayList<Student> students = new ArrayList<Student>();
		Queue<Node> queue = new ArrayDeque<>();

		queue.add(head);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			students.add(current.getStudent());

			if (current.getLeft() != null)
				queue.add(current.getLeft());
			if (current.getRight() != null)
				queue.add(current.getRight());
		}

		return students;
	}

	// Tree includes problem - Iterative Breadth First algorithm
	public static boolean treeIncludesIterativeBireadthFirstWay(Node head, int id) {
		if (head == null)
			return false;

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (current.getStudent().getStudentId() == id)
				return true;

			if (current.getLeft() != null)
				queue.add(current.getLeft());
			if (current.getRight() != null)
				queue.add(current.getRight());
		}

		return false;
	}

	// Tree includes problem - Recursive Depth First algorithm
	public static boolean treeIncludesRecursiveDepthFirstWay(Node head, int id) {
		if (head == null)
			return false;

		if (head.getStudent().getStudentId() == id)
			return true;

		return treeIncludesRecursiveDepthFirstWay(head.getLeft(), id)
				|| treeIncludesRecursiveDepthFirstWay(head.getRight(), id);
	}

	// Tree sum problem - Recursive Depth First algorithm
	public static int treeSumRecursiveDepthFirstWay(Node head) {
		if (head == null)
			return 0;

		return head.getStudent().getStudentId() + treeSumRecursiveDepthFirstWay(head.getLeft())
				+ treeSumRecursiveDepthFirstWay(head.getRight());
	}

	// Tree sum problem - Iterative Breadth First algorithm
	public static int treeSumIterativeBreadthFirstWay(Node head) {
		if (head == null)
			return 0;

		int sum = 0;
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(head);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			sum += current.getStudent().getStudentId();

			if (current.getLeft() != null) queue.add(current.getLeft());
			if (current.getRight() != null) queue.add(current.getRight());
		}

		return sum;
	}

	// Tree min value problem - Iterative Breadth First algorithm
	public static int treeMinIterativeBreadthFirstWay(Node head) {
		if (head == null)
			return 0;

		int min = head.getStudent().getStudentId();
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(head);

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (current.getStudent().getStudentId() < min)
				min = current.getStudent().getStudentId();

			if (current.getLeft() != null) queue.add(current.getLeft());
			if (current.getRight() != null) queue.add(current.getRight());

		}

		return min;
	}

	// Tree min value problem - Recursive Depth First algorithm
	public static int treeMinRecursiveDepthFirstWay(Node head) {
		if (head == null)
			return Integer.MAX_VALUE;

		int leftMin = treeMinRecursiveDepthFirstWay(head.getLeft());
		int rightMin = treeMinRecursiveDepthFirstWay(head.getRight());
		int min = head.getStudent().getStudentId();

		if (min > leftMin)
			min = leftMin;
		if (min > rightMin)
			min = rightMin;

		return min;
	}

//	// Tree max path sum problem(root to leaf) - Iterative Depth First algorithm
//	public static int maxPathSumIterativeDepthFirstWay(Node head) {
//		
//	}

	// Tree max path sum problem(root to leaf) - Recursive Depth First algorithm
	public static int maxPathSumRecursiveDepthFirstWay(Node head) {
		if (head == null) return 0;
		
		int leftMax = maxPathSumRecursiveDepthFirstWay(head.getLeft());
		int rightMax = maxPathSumRecursiveDepthFirstWay(head.getRight());
		
		return head.getStudent().getStudentId() + Math.max(leftMax, rightMax);
	}
}

















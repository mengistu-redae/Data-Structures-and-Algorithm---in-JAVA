package mainPackage;

//static imports
import static simpleSortingAlgorithms.SelectionSort.selectionSortAscending;
import static simpleSortingAlgorithms.SelectionSort.selectionSortDescending;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import binaryTree.BinarySearchTree;
import data.Student;
import graph.Graph;
import graph.Vertex;
import linkedList.SinglyLinkedList;

public class Main {

	public static void main(String[] args) {
		
		//array sorting algorithms 
		arraySortingAlgorithms();
		
		//Linked list data structure and algorithms
		linkeListAlgorithms();
		
		//Binary Tree data structure and algorithms
		binaryTreeAlgorithms();		
		
		//Graph data structure and algorithms
		graphAlgorithms();	
	}

	private static void graphAlgorithms() {		
		
		//create student list
		ArrayList<Student> studentList1 = new ArrayList<>();
		ArrayList<Student> studentList2 = new ArrayList<>();
		
		studentList1 = Graph.getStudnetsList1();
		studentList2 = Graph.getStudnetsList2();
		
		//create graph from student list
		Graph graph1 = Graph.createGraph1();
		Graph graph2 = Graph.createGraph2();
		
		//display generated graph-1
		printDecoratedMessage("Graph-1");
		for(Student s : studentList1) {
			System.out.print(s.getStudentId() + " -> " );
			graph1.getAdjacentVertices(s)
				.forEach(
						v->System.out.print(v.getStudent().getStudentId() + " ")
					);
			System.out.println();
		}
			
		//display generated graph-2
		printDecoratedMessage("Graph-2");
		for(Student s : studentList2){
			System.out.print(s.getStudentId() + " -> " );
			graph2.getAdjacentVertices(s)
				.forEach(
						v->System.out.print(v.getStudent().getStudentId() + " ")
					);
			System.out.println();
		}
		
		
		//Graph Traversal - Depth-first (DFS) --- uses stack data structure
		printDecoratedMessage("Graph Traversal - Depth-first");
		printMessage("Depth-first (Iteratively) -- from Vertex-1");
		Graph.depthFirstTraversalIteratively(graph1, new Vertex(studentList1.get(0)))
			.forEach(v->System.out.print(v.getStudent().getStudentId()+ ", "));

		System.out.println();
		printMessage("Depth-first (Recursively) -- from Vertex-1");
		Graph.depthFirstTraversalRecursively(graph1, new Vertex(studentList1.get(0)), new LinkedHashSet<>())
			.forEach(v->System.out.print(v.getStudent().getStudentId()+ ", "));
		
		System.out.println();
		printMessage("Depth-first -- from Vertex-5");
		Graph.depthFirstTraversalIteratively(graph1, new Vertex(studentList1.get(4)))
			.forEach(v->System.out.print(v.getStudent().getStudentId()+ ", "));
		
		System.out.println();
		printMessage("Depth-first -- from Vertex-9");
		Graph.depthFirstTraversalIteratively(graph1, new Vertex(studentList1.get(8)))
			.forEach(v->System.out.print(v.getStudent().getStudentId()+ ", "));
		
		
		System.out.println();
		//Graph Traversal - Breadth-first (BFS) --- uses queue data structure 
		printDecoratedMessage("Graph Traversal - Breadth-first");
		printMessage("Breadth-first -- from Vertex-1");
		Graph.breadthFirstTraversalIteratively(graph2, new Vertex(studentList2.get(0)))
			.forEach(v->System.out.print(v.getStudent().getStudentId()+ ", "));

		System.out.println();
		printMessage("Breadth-first -- from Vertex-4");
		Graph.breadthFirstTraversalIteratively(graph2, new Vertex(studentList2.get(3)))
			.forEach(v->System.out.print(v.getStudent().getStudentId()+ ", "));

		System.out.println();
		printDecoratedMessage("Has path problem");
		printMessage("Depth-first Recursively -- from Vertex 1 to 4");
		System.out.println(Graph.hasPathDepthFirstRecursively(
				graph1, 
				new Vertex(studentList1.get(0)), 
				new Vertex(studentList1.get(3)), 
				new HashSet<Vertex>()
			));
		
		printMessage("Breadth-first Iteratively -- from Vertex 1 to 4");
		System.out.println(Graph.hasPathBreadthFirstIteratively(
				graph1, 
				new Vertex(studentList1.get(0)), 
				new Vertex(studentList1.get(3))
			));
		printMessage("Depth-first Recursively -- from Vertex 5 to 9");
		System.out.println(Graph.hasPathDepthFirstRecursively(
				graph1, 
				new Vertex(studentList1.get(4)), 
				new Vertex(studentList1.get(8)), 
				new HashSet<Vertex>()
			));
		
		printMessage("Breadth-first Iteratively -- from Vertex 5 to 9");
		System.out.println(Graph.hasPathBreadthFirstIteratively(
				graph1, 
				new Vertex(studentList1.get(4)), 
				new Vertex(studentList1.get(8))
			));
		
		printDecoratedMessage("Count connected components");
		printMessage("connected components of - grpah1");
		System.out.println(Graph.connectedComponentsCount(graph1));
		
		printMessage("connected components of - grpah2");
		System.out.println(Graph.connectedComponentsCount(graph2));
		
	}

	// print contents of an array
	private static void printArrayElements(int[] array) {
		for (int a : array)
			System.out.print(a + ", ");

		System.out.println();
	}

	// print separator
	private static void printSeparator(String message) {
		System.out.println("---- " + message + " ----");
	}

	// print separator
	private static void printMessage(String message) {
		System.out.println(message);
	}

	// print separator
	private static void printDecoratedMessage(String message) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		printMessage(message);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private static void arraySortingAlgorithms() {
		int[] array1 = new int[] { 90, 23, 5, 109, 12, 22, 67, 34 };
		//int[] array2 = { 5, -2, 23, 7, 87, -42, 509 };
		//int[] array3 = { 45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8 };
	
		printDecoratedMessage("--- Selection Sort ---");
		printArrayElements(array1);
		printSeparator("Sorted - Asc and Des");
		printArrayElements(selectionSortAscending(array1));
		printArrayElements(selectionSortDescending(array1));
	}

	private static void linkeListAlgorithms() {
		printDecoratedMessage("Traversing Singly Linked List");
		linkedList.Node head1 = SinglyLinkedList.createSinglyLinkedList1();
		linkedList.Node head2 = SinglyLinkedList.createSinglyLinkedList2();

		printSeparator("Iterative way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(head1);

		printSeparator("Recursive way");
		SinglyLinkedList.traverseSinglyLinkedListRecursively(head2);

		printDecoratedMessage("Reversing Linked List");
		linkedList.Node newHead1 = SinglyLinkedList.reverseLinkedListIteratively(head1);
		linkedList.Node newHead2 = SinglyLinkedList.reverseLinkedListRecursively(head2, null);
		printSeparator("Iterative way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(newHead1);
		printSeparator("Recursive way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(newHead2);

		printDecoratedMessage("Zipping Linked List: --- Iterative way");
		linkedList.Node zippedList1 = SinglyLinkedList.zipLinkedListIteratively(newHead1, newHead2);
		linkedList.Node zippedList2 = SinglyLinkedList.zipLinkedListRecursively(SinglyLinkedList.createSinglyLinkedList1(),
				SinglyLinkedList.createSinglyLinkedList2());
		
		printSeparator("Iterative way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(zippedList1);

		printSeparator("Recursive way");
		SinglyLinkedList.traverseSinglyLinkedListIteratively(zippedList2);
	
		printDecoratedMessage("Linked List to array");
		Student[] studentArray1 = SinglyLinkedList.linkedListValuesToArrayIteratively(newHead1);
		Student[] studentArray2 = SinglyLinkedList.linkedListValuesToArrayRecursively(newHead2);
		
		printSeparator("Iterative way");
		for(Student s: studentArray1)
			System.out.println(s.toString());
		
		printSeparator("Recursive way");
		for(Student s: studentArray2)
			System.out.println(s.toString());
		
	}

	private static void binaryTreeAlgorithms() {
		printDecoratedMessage("--- BinarySearch Tree - Depth-First Search(Traversal)  ---");
		binaryTree.Node treeHead1 = BinarySearchTree.createBinarySearchTree1();
		binaryTree.Node treeHead2 = BinarySearchTree.createBinarySearchTree2();
		binaryTree.Node treeHead3 = BinarySearchTree.createBinarySearchTree1();
		
		printSeparator("Iterative way");
		ArrayList<Student> students1 = BinarySearchTree.depthFirstTraversalIteratively(treeHead1);
		for(Student s : students1) 
			System.out.print(s.getStudentId() + ", ");
		
		System.out.println();
		printSeparator("Recursive way");
		ArrayList<Student> students2 = BinarySearchTree.depthFirstTraversalRecursively(treeHead2, new ArrayList<Student>());
		
		for(Student s : students2)
			System.out.print(s.getStudentId() + ", ");
		
		System.out.println();
		printDecoratedMessage("--- BinarySearch Tree - Breadth-First Search(Traversal)  ---");
		printSeparator("Iterative way - is the only way");
		ArrayList<Student> students3 = BinarySearchTree.breadthFirstTraversalIteratively(treeHead3);
		for(Student s : students3)
			System.out.print(s.getStudentId() + ", ");
		
		System.out.println();
		printDecoratedMessage("--- Binary Tree - includes problem  ---");
		printSeparator("Iterative way");
		boolean id25 = BinarySearchTree.treeIncludesIterativeBireadthFirstWay(treeHead3, 25);
		System.out.println("Id exists? " + id25);
		printSeparator("Recursive way");
		boolean id10 = BinarySearchTree.treeIncludesRecursiveDepthFirstWay(treeHead3, 10);
		System.out.println("Id exists? " + id10);
		
		printDecoratedMessage("--- Binary Tree - includes problem  ---");
		printSeparator("Iterative way");
		int idSum1 = BinarySearchTree.treeSumIterativeBreadthFirstWay(treeHead3);
		System.out.println("Id Sum is: " + idSum1);
		printSeparator("Recursive way");
		int idSum2 = BinarySearchTree.treeSumRecursiveDepthFirstWay(treeHead3);
		System.out.println("Id Sum is: " + idSum2);
		
		printDecoratedMessage("--- Binary Tree - min value problem  ---");
		printSeparator("Iterative way");
		int min1 = BinarySearchTree.treeMinIterativeBreadthFirstWay(treeHead3);
		System.out.println("Min value is: " + min1);
		printSeparator("Recursive way");
		int min2 = BinarySearchTree.treeMinRecursiveDepthFirstWay(treeHead3);
		System.out.println("Min value is: " + min2);
		
		printDecoratedMessage("--- Binary Tree - min value problem  ---");
		printSeparator("Recursive way");
		int maxPathSum2 = BinarySearchTree.maxPathSumRecursiveDepthFirstWay(treeHead3);
		System.out.println("Max path sum is: " + maxPathSum2);
	}

}

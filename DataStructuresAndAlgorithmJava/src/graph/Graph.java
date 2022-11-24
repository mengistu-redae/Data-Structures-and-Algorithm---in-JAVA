package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import data.Student;

public class Graph {
	private Map<Vertex, List<Vertex>> adjacentVertices = new HashMap<>();

	//default constructor
	public Graph() {}
	
	//Parameterized constructor
	public Graph(Map<Vertex, List<Vertex>> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}

	public Map<Vertex, List<Vertex>> getAdjacentVertices() {
		return adjacentVertices;
	}

	public void setAdjacentVertices(Map<Vertex, List<Vertex>> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}
	
	//Graph Mutation Operations
	public void addVertex(Student student) {
		adjacentVertices.put(new Vertex(student), new ArrayList<>());
	}
	
	public void removeVertices(Student student) {
		Vertex vertex = new Vertex(student);
		//adjacentVertices.values().stream().forEach(e->e.remove(vertex));
		adjacentVertices.remove(vertex);
	}
	
	//adding Edge (undirected graph)
	public boolean addUndirectedEdge(Student studnet1, Student student2){
		Vertex vertex1 = new Vertex(studnet1);
		Vertex vertex2 = new Vertex(student2);
		
		//if either of the vertices exist as a key in the Graph, don't add Edge
		if(!adjacentVertices.containsKey(vertex1) || !adjacentVertices.containsKey(vertex2))
			return false;
				
		adjacentVertices.get(vertex1).add(vertex2);
		adjacentVertices.get(vertex2).add(vertex1);
		
		return true;
	}
	
	//removing Edge (undirected graph)
	public boolean removeUndirectedEdge(Student studnet1, Student student2) {
		Vertex vertex1 = new Vertex(studnet1);
		Vertex vertex2 = new Vertex(student2);
		
		//if either of the vertices do not exist as a key in the Graph, no Edge to remove
		if(!adjacentVertices.containsKey(vertex1) || !adjacentVertices.containsKey(vertex2))
			return false;
			
		List<Vertex> edgesVertex1 = adjacentVertices.get(vertex1);
		List<Vertex> edgesVertex2 = adjacentVertices.get(vertex2);
		
		if(edgesVertex1 != null)
			edgesVertex1.remove(vertex2);
		if(edgesVertex2 != null)
			edgesVertex2.remove(vertex1);
		
		return true;
	}
	
	//get the adjacent vertices of a particular vertex
	public List<Vertex> getAdjacentVertices(Student student){		
		return adjacentVertices.get(new Vertex(student));		
	} 
	
	//Graph Traversal - Depth-first (DFS) Iteratively --- uses stack data structure 
	public static Set<Vertex> depthFirstTraversalIteratively(Graph graph, Vertex root) {
		Set<Vertex> visitedVertices = new LinkedHashSet<>();
		Stack<Vertex> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Vertex current = stack.pop();
			if(!visitedVertices.contains(current)){
				//add current to visited vertices list
				visitedVertices.add(current);
				//add each adjacent vertices of current to stack
				graph.getAdjacentVertices(current.getStudent()).forEach(v-> stack.push(v));
				/*
				for(Vertex v : graph.getAdjacentVertices(current.getStudent())) {
					stack.push(v);
				}
				*/
			}
		}		
		
		return visitedVertices;
	}
	
	//Graph Traversal - Depth-first (DFS) Recursively --- uses stack data structure 
	public static Set<Vertex> depthFirstTraversalRecursively(Graph graph, Vertex root, Set<Vertex> visitedVertices) {
		
		if(visitedVertices.contains(root))
			return visitedVertices;
		
		visitedVertices.add(root);
		/*
		 for(Vertex v : graph.getAdjacentVertices(root.getStudent()))
			depthFirstTraversalRecursively(graph, v, visitedVertices);			 
		 */
		graph.getAdjacentVertices(root.getStudent())
			.forEach(v-> depthFirstTraversalRecursively(graph, v, visitedVertices) );
					
		return visitedVertices;
	}
	
	//Graph Traversal - Breadth-first (BFS) --- uses queue data structure 
	public static Set<Vertex> breadthFirstTraversalIteratively(Graph graph, Vertex root) {
		Set<Vertex> visitedVertices = new LinkedHashSet<>();
		Queue<Vertex> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Vertex current = queue.poll();
			if(!visitedVertices.contains(current)) {
				//add current to visited vertices
				visitedVertices.add(current);
				//add adjacent vertices of current to queue
				graph.getAdjacentVertices(current.getStudent()).forEach(v->queue.add(v));
			}
		}		
		
		return visitedVertices;
	}
	
	//has path - problem --- depth first search - recursively
	public static boolean hasPathDepthFirstRecursively(Graph graph, Vertex src, Vertex dst, Set<Vertex> visitedVertices) {
		if(src.equals(dst)) return true;
		
		for(Vertex v : graph.getAdjacentVertices(src.getStudent())) {
			if(!visitedVertices.contains(v)) {
				visitedVertices.add(v);				
				if(hasPathDepthFirstRecursively(graph, v, dst,visitedVertices) == true) 
					return true;
			}				
		}
		
		return false;
	}
	
	//has path - problem --- Breadth first search - Iteratively
	public static boolean hasPathBreadthFirstIteratively(Graph graph, Vertex src, Vertex dst) {
		Set<Vertex> visitedVertices = new HashSet<>();
		Queue<Vertex> queue = new ArrayDeque<>();
		queue.add(src);
		
		while(!queue.isEmpty()) {
			Vertex current = queue.poll();
			if(current.equals(dst))
				return true;
			else if(!visitedVertices.contains(current)) {
				visitedVertices.add(current);
				/* graph.getAdjacentVertices(current.getStudent()).forEach(v->queue.add(v)); */
				for(Vertex v : graph.getAdjacentVertices(current.getStudent()))
					queue.add(v);
			}
		}		
		
		return false;
	}
	
	//count connected components problem
	public static int connectedComponentsCount(Graph graph) {
		Set<Vertex> visitedVertices = new HashSet<>();
		int count = 0;
		
		/*
		//Way-1
		for(Vertex v : graph.getAdjacentVertices().keySet()) {
			if(!visitedVertices.contains(v)) {
				count++;
				exploreWay1(graph, v, visitedVertices);				
			}
		}
		*/
		
		//Way-2
		for(Vertex v : graph.getAdjacentVertices().keySet()) {
			if(exploreWay2(graph, v, visitedVertices) == true) 
				count++;
		}		
			
		return count;
	}
	
	//explore --- helper function for count connected components problem
	private static void exploreWay1(Graph graph, Vertex src, Set<Vertex> visitedVertices) {
		if(visitedVertices.contains(src)) return;
		
		visitedVertices.add(src);
		
		graph.getAdjacentVertices(src.getStudent())
			.forEach(v->exploreWay1(graph, v, visitedVertices));
	}
	
	//explore --- helper function for count connected components problem
	private static boolean exploreWay2(Graph graph, Vertex src, Set<Vertex> visitedVertices) {
		if(visitedVertices.contains(src)) return false;
		
		visitedVertices.add(src);
		
		graph.getAdjacentVertices(src.getStudent())
			.forEach(v->exploreWay2(graph, v, visitedVertices));
		
		return true;
	}
	
	
	
	
	//creating graph manually
	public static Graph createGraph1() {
		//create graph
		Graph graph = new Graph();
		
		//Student list to create vertices
		ArrayList<Student> studentList = Graph.getStudnetsList1();
		
		//add vertices
		studentList.stream().forEach(s->graph.addVertex(s)); //.peek(s->System.out.println("Student number: " + s.toString()))
		
		//add edges --- 
		graph.addUndirectedEdge(studentList.get(0), studentList.get(1));
		graph.addUndirectedEdge(studentList.get(0), studentList.get(2));
		graph.addUndirectedEdge(studentList.get(1), studentList.get(3));
		graph.addUndirectedEdge(studentList.get(2), studentList.get(3)); 
		//graph.addUndirectedEdge(studentList.get(2), studentList.get(4)); // To create disconnected islands 
		graph.addUndirectedEdge(studentList.get(4), studentList.get(5));
		graph.addUndirectedEdge(studentList.get(4), studentList.get(6));
		graph.addUndirectedEdge(studentList.get(5), studentList.get(6));
		graph.addUndirectedEdge(studentList.get(5), studentList.get(7));
		//graph.addUndirectedEdge(studentList.get(7), studentList.get(8)); // To create a disconnected vertex
		graph.addUndirectedEdge(studentList.get(7), studentList.get(9));
		
		return graph;
	}
	
	public static Graph createGraph2() {
		//create graph
		Graph graph = new Graph();
		
		//Student list to create vertices
		ArrayList<Student> studentList = Graph.getStudnetsList2();
		
		//add vertices
		studentList.stream().forEach(s->graph.addVertex(s)); //.peek(s->System.out.println("Student number: " + s.toString()))
		
		//add edges 
		graph.addUndirectedEdge(studentList.get(0), studentList.get(2));
		graph.addUndirectedEdge(studentList.get(0), studentList.get(3));
		graph.addUndirectedEdge(studentList.get(1), studentList.get(2));
		graph.addUndirectedEdge(studentList.get(1), studentList.get(3));
		graph.addUndirectedEdge(studentList.get(2), studentList.get(3));
		
		return graph;
	}
	
	//students list-1
	public static ArrayList<Student> getStudnetsList1(){
		
		ArrayList<Student> studentList1 = new ArrayList<>();
		
		studentList1.add(new Student(1, "Werku", "Kassa", "Food Engineering"));
		studentList1.add(new Student(2, "Lemlem", "Hagos", "Electrical Engineering"));
		studentList1.add(new Student(3, "Hailemariam", "Teklay", "Comunication Engineering"));
		studentList1.add(new Student(4, "Pliny", "Mengistu", "Information Technology"));
		studentList1.add(new Student(5, "Liwam", "Atakilti", "Civil Engineering"));
		studentList1.add(new Student(6, "Silondis", "Mengistu", "Computer Science"));
		studentList1.add(new Student(7, "Negasi", "Hafte", "Comunication Engineering"));
		studentList1.add(new Student(8, "Kibrom", "Gebrehiwot", "Information Technology"));
		studentList1.add(new Student(9, "Abeba", "Redae", "Software Engineering"));
		studentList1.add(new Student(10, "Hayelom", "Gebre", "Chemical Engineering"));
		
		return studentList1;
	}
	
	//students list-1
	public static ArrayList<Student> getStudnetsList2(){
		
		ArrayList<Student> studentList2 = new ArrayList<>();
		
		studentList2.add(new Student(11, "Hawi", "Abera", "Electrical Engineering"));
		studentList2.add(new Student(12, "Robel", "Arega", "Computer Science"));
		studentList2.add(new Student(13, "Melaku", "Tena", "Software Engineering"));
		studentList2.add(new Student(14, "Mesfin", "Haletu", "Information Technology"));
		
		return studentList2;
	}
}









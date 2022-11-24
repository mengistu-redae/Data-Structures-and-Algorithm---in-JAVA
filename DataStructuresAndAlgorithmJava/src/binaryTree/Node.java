package binaryTree;

import data.Student;

public class Node {
	private Student student;
	private Node left; // pointer to left node
	private Node right; // pointer to right node

	public Node(Student student) {
		this.student = student;
		this.left = null;
		this.right = null;
	}

	public Node(Student student, Node left, Node right) {
		this.student = student;
		this.left = left;
		this.right = left;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}

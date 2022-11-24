package linkedList;

import data.Student;

public class SinglyLinkedList {

	static public Node createSinglyLinkedList1() {

		Node head = null;
		
		Node n1 = new Node(new Student(1, "Silondis", "Mengistu", "Computer Science"));
		Node n2 = new Node(new Student(2, "Pliny", "Mengistu", "Information Technology"));
		Node n3 = new Node(new Student(3, "Abeba", "Redae", "Software Engineering"));
		Node n4 = new Node(new Student(4, "Lemlem", "Hagos", "Electrical Engineering"));
		Node n5 = new Node(new Student(5, "Hayelom", "Gebre", "Chemical Engineering"));
		Node n6 = new Node(new Student(6, "Werku", "Kassa", "Food Engineering"));
		Node n7 = new Node(new Student(7, "Hailemariam", "Teklay", "Comunication Engineering"));
		Node n8 = new Node(new Student(8, "Kibrom", "Gebrehiwot", "Information Technology"));
		Node n9 = new Node(new Student(9, "Negasi", "Hafte", "Comunication Engineering"));
		Node n10 = new Node(new Student(10, "Liwam", "Atakilti", "Civil Engineering"));

//		head = n1;
//		n1.setNext(n2);
//		n2.setNext(n3);
//		n3.setNext(n4);
//		n4.setNext(n5);
//		n5.setNext(n6);
//		n6.setNext(n7);
//		n7.setNext(n8);
//		n8.setNext(n9);
//		n9.setNext(n10);
//		n10.setNext(null);

		head = addNodeToLinkedList(head, n1);
		addNodeToLinkedList(head, n2);
		addNodeToLinkedList(head, n3);
		addNodeToLinkedList(head, n4);
		addNodeToLinkedList(head, n5);
		addNodeToLinkedList(head, n6);
		addNodeToLinkedList(head, n7);
		addNodeToLinkedList(head, n8);
		addNodeToLinkedList(head, n9);
		addNodeToLinkedList(head, n10);
		
		return head;
	}

	static public Node createSinglyLinkedList2() {

		Node head = null;

		Node n11 = new Node(new Student(11, "Hawi", "Abera", "Electrical Engineering"));
		Node n12 = new Node(new Student(12, "Robel", "Arega", "Computer Science"));
		Node n13 = new Node(new Student(13, "Melaku", "Tena", "Software Engineering"));
		Node n14 = new Node(new Student(14, "Mesfin", "Haletu", "Information Technology"));

//		head = n11;
//		n11.setNext(n12);
//		n12.setNext(n13);
//		n13.setNext(n14);
//		n14.setNext(null);

		head = addNodeToLinkedList(head, n11);
		addNodeToLinkedList(head, n12);
		addNodeToLinkedList(head, n13);
		addNodeToLinkedList(head, n14);
		
		return head;
	}

	static public Node addNodeToLinkedList(Node head, Node newNode) {
		if(newNode == null) return head;
		if(head == null) return newNode;
		
		Node current = head;
		Node tail = head;
		while(current != null) {
			tail = current;
			current = current.getNext();
		}
		
		tail.setNext(newNode);
		return head;
	}

	// Linked list traversal - Iterative way
	public static void traverseSinglyLinkedListIteratively(Node head) {
		while (head != null) {
			// System.out.println(head.toString());
			System.out.println(head.getStudent().toString());
			// System.out.print(head.getStudent().getStudentId());

			head = head.getNext();
		}
	}

	// Linked list traversal - Recursive way
	public static Node traverseSinglyLinkedListRecursively(Node head) {

		if (head == null)
			return null;

		System.out.println(head.getStudent().toString());

		return traverseSinglyLinkedListRecursively(head.getNext());
	}

	// Linked list values problem - return linked list values in array ---
	// Iteratively
	public static Student[] linkedListValuesToArrayIteratively(Node head) {
		if (head == null)
			return null;

		int count = 0;
		Node current = head;
		while (current != null) {
			current = current.getNext();
			count++;
		}

		System.out.println("This is size of the linked list: " + count);

		Student[] studentArray = new Student[count];
		count = 0;
		while (head != null) {
			studentArray[count] = head.getStudent();
			head = head.getNext();
			count++;
		}

		return studentArray;
	}

	// Linked list values problem - return linked list values in array ---
	// Recursively
	public static Student[] linkedListValuesToArrayRecursively(Node head) {
		if (head == null)
			return null;

		int count = 0;
		Node current = head;
		while (current != null) {
			current = current.getNext();
			count++;
		}

		// System.out.println("This is size of the linked list: " + count);
		Student[] studentArray = new Student[count];

		return linkedListToArrayRecursiveHelperMethod(head, studentArray, 0);
	}

	private static Student[] linkedListToArrayRecursiveHelperMethod(Node head, Student[] studentArray, int index) {
		if (head == null)
			return studentArray;

		studentArray[index] = head.getStudent();
		return linkedListToArrayRecursiveHelperMethod(head.getNext(), studentArray, index + 1);
	}

	// Reversing linked list - Iterative way
	public static Node reverseLinkedListIteratively(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;

			current = next;
		}

		return prev;
	}

	// Reversing linked list - Recursive way
	public static Node reverseLinkedListRecursively(Node head, Node prev) {
		if (head == null)
			return prev;

		Node next = head.getNext();
		head.setNext(prev);
		// prev = head;
		// head = next;
		// return reverseLinkedListRecursively(head, prev);
		return reverseLinkedListRecursively(next, head);
	}

	// Zipper lists problem - zipping two linked lists together --- Iteratively
	public static Node zipLinkedListIteratively(Node head1, Node head2) {

		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		int count = 1;
		Node current1 = head1.getNext();
		Node current2 = head2;
		Node tail = head1;

		while (current1 != null && current2 != null) {
			if (count % 2 != 0) {
				tail.setNext(current2);
				tail = current2;
				current2 = current2.getNext();
			} else {
				tail.setNext(current1);
				tail = current1;
				current1 = current1.getNext();
			}
			count++;
		}

		if (current1 != null)
			tail.setNext(current1);
		if (current2 != null)
			tail.setNext(current2);

		return head1;
	}

	// Zipper lists problem - zipping two linked lists together --- Iteratively
	public static Node zipLinkedListRecursively(Node head1, Node head2) {
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		Node next1 = head1.getNext();
		Node next2 = head2.getNext();

		head1.setNext(head2);
		head2.setNext(zipLinkedListRecursively(next1, next2));

		return head1;
	}

}

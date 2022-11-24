package graph;

import java.util.Objects;

import data.Student;

public class Vertex {
	private Student student;

	public Vertex(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		return Objects.hash(student.getStudentId());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) //instanceof checking
			return false;
		
		Vertex other = (Vertex) obj;		
		return this.getStudent().getStudentId() == other.getStudent().getStudentId();
	}
	
	
}

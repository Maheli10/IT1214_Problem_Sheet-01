class Student{
	private int student;
	private String name;
	private int daysAttended;
	
	Student(int student, String name, int daysAttended){
		this.student=student;
		this.name=name;
		this.daysAttended=daysAttended;
		
	}
	
	int getStudent(){
		return student;
	}
	String getname(){
		return name;
	}
	int getdaysAttended(){
		return daysAttended;
	}
	
}
class Classroom{
	private Student[] students=new Student[10];
	private int studentno=0;
	
	
	public void addStudent(Student Stu) {
        if (studentno < students.length) {
            students[studentno] = Stu;
            studentno++;
        } 
		else {
            System.out.println("Classroom is full. Cannot add more students.");
        }
    }

    public void updateAttendance(int student, int newDaysAttended) {
        boolean found = false;
        for (int i = 0; i < studentno; i++) {
            if (students[i].getStudent() == student) {
                
                found = true;
                System.out.println("Attendance updated for Student ID: " + student);
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + student + " does not exist."); 
        }
    }

    public void displayAllStudents() { 
        if (studentno == 0) {
            System.out.println("No students in the classroom yet.");
            return;
        }
        for (int i = 0; i < studentno; i++) {
            System.out.println("StudentID Name	     DaysAttended");
			System.out.println(students[i].getStudent()+" 	  "+students[i].getname()+"   "+students[i].getdaysAttended());
        }
    }
}
class Main{
	public static void main(String[] args){
		Classroom cl = new Classroom();
		
		cl.addStudent(new Student(101, "Alice Smith", 12));
        cl.addStudent(new Student(102, "Bob Jones", 15));
        cl.addStudent(new Student(103, "Carol Lee", 10)); 
		
		cl.updateAttendance(102, 16);
		
		cl.updateAttendance(104, 5);
		
		 cl.displayAllStudents();
	}
}


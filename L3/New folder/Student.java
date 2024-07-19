import java.util.*;
import java.io.*;
class Student implements Serializable{
	static List<Student> students = new ArrayList<>();
	String name;
	int id;
	int mark1;
	int mark2;
	int mark3;
	int total_marks;
	double avg;
	Student(String name,int id,int mark1,int mark2,int mark3){
		this.name = name;
		this.id=id;
		this.mark1=mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.total_marks = mark1+mark2+mark3;
		this.avg = total_marks/3;
		students.add(this);
	}
		
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Student s1 = new Student("Ram",100,87,89,76);
		Student s2 = new Student("Ravi",101,66,96,86);
		Student s3 = new Student("John",102,98,96,86);
		Student s4 = new Student("Joe",103,85,96,86);
		Student s5 = new Student("Rakesh",104,90,96,86);
		try{
			FileOutputStream file = new FileOutputStream("Students.txt");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			for(Student student:students){
				obj.writeObject(student);
			}
			System.out.println("Serialized Sucessfully:");
			obj.close();
			file.close();
		}
		catch(Exception e){}
		try{
			FileInputStream file = new FileInputStream("Students.txt");
			ObjectInputStream obj = new ObjectInputStream(file);
			System.out.println("Enter Student Id to get Details:");
			int id = in.nextInt();
			while(obj!=null){
				Student s = (Student)obj.readObject();
				if(s.id==id){
					System.out.println("Name: " +s.name);
					System.out.println("Mark1: "+s.mark1);
					System.out.println("Mark2: "+s.mark2);
					System.out.println("Mark3: "+s.mark3);
					System.out.println("Total Marks:" +s.total_marks);
					System.out.println("Average:"+s.avg);
				}
			}
			file.close();
			obj.close();
		}
		catch(Exception e){System.out.println("");}
		
	}
}
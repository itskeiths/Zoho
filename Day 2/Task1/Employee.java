/*Write a program that would print the information (name, year of joining, salary, address) of three employees by creating a class named 'Employee'.*/

class Employee{
	String name;
	int year_of_join;
	String address;
	Employee(String name, int year_of_join,String address){
		this.name=name;
		this.year_of_join = year_of_join;
		this.address = address;
		System.out.println(this.name+"\t\t"+this.year_of_join+"\t\t"+this.address);
	}
	public static void main(String[] args){
		System.out.println("Name\tYear of joining\t\tAddress");
		Employee e1 = new Employee("Ashwin",1994,"64C-WallsStreat");
		Employee e2 = new Employee("Robert",2000,"64D-WallsStreat");
		Employee e3 = new Employee("John",1999,"26B-WallsStreat");
	}
}
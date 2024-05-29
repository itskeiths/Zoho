/*.Create an abstract class 'Parent' with a method 'message'. It has two subclasses each having a method with the same name 'message' that prints "This is first subclass" and "This is second subclass" respectively. Call the methods 'message' by creating an object for each subclass.*/

abstract class Parent{
	void message(){};
}

class Child1 extends Parent{
	void message(){System.out.println("This is first subclass");}
}

class Child2 extends Parent{
	void message(){System.out.println("This is second subclass");}
}

class Abstraction{
	public static void main(String[] args){	
		Child1 c1 = new Child1();
		c1.message();
		Child2 c2 = new Child2();
		c2.message();
	}
}
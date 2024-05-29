/*Create an abstract class 'Animals' with two abstract methods 'cats' and 'dogs'. Now create a class 'Cats' with a method 'cats' which prints "Cats meow" and a class 'Dogs' with a method 'dogs' which prints "Dogs bark", both inheriting the class 'Animals'. Now create an object for each of the sub classes and call their respective methods.*/

abstract class Animals{
	abstract void cats();
	abstract void dogs();
}

class Cats extends Animals{
	void dogs(){}
	void cats(){System.out.println("Cats meow");}
}

class Dogs extends Animals{
	void cats(){}
	void dogs(){System.out.println("Dogs bark");}
}

class Animal{
	public static void main(String[] args){
		Animals c = new Cats();
		Animals d = new Dogs();
		c.cats();
		d.dogs();
	}
}
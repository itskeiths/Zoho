import java.util.*;
class QuadraticEquation{
public static void main(String args[]){
	Scanner in = new Scanner(System.in);
	System.out.print("Enter a: ");
	double a = in.nextDouble();
	System.out.print("Enter b: ");
	double b = in.nextDouble();
	System.out.print("Enter c: ");
	double c = in.nextDouble();
	double discriminant = Math.sqrt((b*b)-(4*a*c));
	if(discriminant>0){
		double root1 = (-1*b + discriminant)/(2*a);
		double root2 = (-1*b - discriminant)/(2*a);
		System.out.println("The roots of the equation are real and the roots are "+ root1+" and  "+root2);
	}
	else if(discriminant==0){
		double root = (-1*b)/(2*a);
		System.out.println("The roots of the equation are equal and the root is "+root);
	}
	else{
		double realpart = (-1*b)/(2*a);
		double imaginarypart = discriminant/(2*a);
		System.out.println("The roots are unequal and the roots are "+realpart+"+"+imaginarypart+"i and "+realpart+"-"+imaginarypart+"i");
	}
}
}
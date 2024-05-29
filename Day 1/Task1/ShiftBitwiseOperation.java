import java.util.*;
class ShiftBitwiseOperation{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter number1: ");
	int num1 = in.nextInt();
	System.out.println("Enter number2: ");
	int num2 = in.nextInt();
	System.out.println(num1+">>"+num2+"="+(num1>>num2)); 
	System.out.println(num1+"<<"+num2+"="+(num1<<num2)); 
	System.out.println(num1+"&"+num2+"="+(num1&num2)); 
	System.out.println(num1+"|"+num2+"="+(num1|num2));
	System.out.println(num1+"^"+num2+"="+(num1^num2));  
}
}
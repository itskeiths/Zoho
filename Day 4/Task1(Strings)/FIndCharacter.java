/*Write a Java program to get the character at the given index within the String.*/
import java.util.*;
class FindCharacter{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = in.next();
	System.out.println("Enter index:");
	int index = in.nextInt();
	System.out.println(index<str.length()?str.charAt(index):"Index out of bound");

}
}
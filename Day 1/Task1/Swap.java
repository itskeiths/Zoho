import java.util.*;
public class Swap{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter a: ");
int a = in.nextInt();
System.out.println("Enter b: ");
int b = in.nextInt();
a=a^b;
b=a^b;
a=a^b;
System.out.println("a= "+a+" b= "+b);
}
}
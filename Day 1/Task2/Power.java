import java.util.*;
public class Power{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter Base value:");
int num = in.nextInt();
System.out.println("Enter Power value:");
int power= in.nextInt();
System.out.println(findPower(num,power));
}

public static int findPower(int n, int pow){
if(pow==0) return 1;
if(pow%2==1){
return n*findPower(n,pow/2)*findPower(n,pow/2);
}
return findPower(n,pow/2)*findPower(n,pow/2);
}
}
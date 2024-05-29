import java.util.*;
public class SumOdd{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
int n = in.nextInt();
int sum=0,odd=1;
for(int i=0;i<n;i++){
sum+=odd;
odd+=2;
}
System.out.println(sum);
}
}
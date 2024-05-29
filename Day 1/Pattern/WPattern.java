import java.util.*;
public class WPattern{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
int num = in.nextInt();
for(int i=0;i<num;i++){
for(int j=0;j<=num;j++){
 if(j==0 || j==num || ( i>=(num/2-1) && (i+j==num-1 || (j-i==1)))) System.out.print("w ");

 else System.out.print("  ");
}
System.out.println();
}
}
}
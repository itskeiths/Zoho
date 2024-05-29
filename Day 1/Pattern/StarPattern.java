import java.util.*;
class StarPattern{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int num = in.nextInt();
	for(int i=0;i<num;i++){
	for(int j=0;j<num;j++){
	if(i==j || i+j==num-1) System.out.print("*  ");
	else if((i==0 ||i==num-1) && j==num/2) System.out.print("*  ");
	else System.out.print("   ");
	}
	System.out.println();
	}
}
}
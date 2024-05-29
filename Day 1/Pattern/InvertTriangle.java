import java.util.*;
class InvertTriangle{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int num = in.nextInt();	
	for(int i=0;i<num;i++){
	for(int j=0;j<num;j++){
	if(j>=i) System.out.print("* ");
	else System.out.print("  ");
	}
	System.out.println();
	}
}
}
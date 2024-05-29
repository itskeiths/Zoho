import java.util.*;
class DiamondPattern{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int num = in.nextInt();
	int skip1=0;
	int skip2=0;
	if(num%2==0) num++;
	for(int i=0;i<=num;i++){
	if(i==1){
	skip1=num/2-1;
	skip2=num/2+1;
}
	for(int j=0;j<num;j++){
	if(((i==num/2 || i==num/2+1) && (j==0 || j==num-1))) System.out.print("x ");
	else if(j==num/2 && (i==0 || i==num)) System.out.print("x ");
	else if((i!=0 && i!=num/2 && i!=num/2+1) && (j==skip1 || j==skip2)) System.out.print("x ");
	else System.out.print("  ");
}
if(i<num/2-1){
skip1--;
skip2++;
}
if(i>num/2+1){
skip1++;
skip2--;
}
System.out.println();
}
}
}
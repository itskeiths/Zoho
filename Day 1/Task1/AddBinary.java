import java.util.*;
class AddBinary{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.print("Enter binary number 1: ");
	int bin1 = in.nextInt();
	System.out.print("Enter binary number 2: ");
	int bin2 = in.nextInt();
	int carry = 0;
	int result = 0;
	int multiplier = 1;
	while(bin1!=0 || bin2!=0){
		int sum = (bin1%10)+(bin2%10)+carry;
		result+= ((sum%2)*multiplier);
		carry = sum/2;
		multiplier*=10;
		bin1=bin1/10;
		bin2=bin2/10;
	}
	if(carry!=0) result+=(carry*multiplier);
	System.out.println("Addition of two binary numbers is: "+result);
}
}
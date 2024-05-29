import java.util.*;
class ClassifyFloatingNumber{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.print("Enter a floating point number: ");
	double float_num = in.nextDouble();
	if(float_num==0) System.out.println("zero");
	else if(float_num>0){
		System.out.println("positive");
		if(Math.abs(float_num)>1000000) System.out.println("large");
	}
	else{
		System.out.println("negative");
		if(Math.abs(float_num)<1) System.out.println("small");
	}

}
}
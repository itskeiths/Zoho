import java.util.Scanner;
class Vehicles{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of vehicles:");
		int vehicles =  in.nextInt();
		System.out.println("Enter number of wheels:");
		int wheels = in.nextInt();
		if(2>wheels || wheels%2==1 || vehicles>wheels){
			System.out.println("Invalid Input");
			return;
		} 
		int tw=0,fw=0;
		fw =(wheels-2*vehicles)/2;
		tw = vehicles-fw;
		System.out.println("TW: "+tw+" FW: "+fw);
	}
}
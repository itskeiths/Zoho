/*Print the average of three numbers entered by user by creating a class named 'Average' having a method to calculate and print the average.*/

import java.util.Scanner;
class Average{
	int num1,num2,num3;
	double average;
	Average(int num1,int num2,int num3){
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	void calculateAverage(){
		this.average=(double)(this.num1+this.num2+this.num3)/3;
	}
	void printAverage(){
		System.out.println("Average of the numbers is: "+this.average);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter three numbers:");
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		Average a = new Average(n1,n2,n3);
		a.calculateAverage();
		a.printAverage();
	}
}
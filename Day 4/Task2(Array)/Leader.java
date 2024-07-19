/*Write a Java program to print all the LEADERS in the array.*/
class Leader{
public static void main(String[] args){
int[] arr = {20,3,5,9,8,3,2,6};
System.out.println("Leader numbers are: ");
for(int i=0;i<arr.length-1;i++){
	int found = 1;
	for(int j=i+1;j<arr.length;j++)
	if(arr[i]<arr[j]) found=0;
	if(found==1) System.out.print(arr[i]+" ");
	
}
}
}
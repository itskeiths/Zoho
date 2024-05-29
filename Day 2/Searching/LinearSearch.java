import java.util.*;
class LinearSearch{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int[] arr = {9,14,3,2,43,11,58,22};
	System.out.print("Enter key: ");
	int key = in.nextInt();
	int index = -1;
	for(int i=0;i<arr.length;i++){
		if(arr[i]==key){
			index = i;
			break;
	}
	}
	System.out.println(index==-1?"Key not found":("Key found at position "+index)); 
}
}
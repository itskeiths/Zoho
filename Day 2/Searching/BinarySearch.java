import java.util.*;
class BinarySearch{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.print("Enter key: ");
	int key = in.nextInt();
	int index = -1;
	int arr[] = {1,2,4,7,10,11};
	int low = 0;
	int high = arr.length-1;
	while(low<=high){
		int mid = (low+high)/2;
		if(arr[mid]==key){
			index = mid;
			break;
		}
		else if(arr[mid]<key){
			low = mid+1;
		}
		else high = mid-1;
	}
	System.out.println(index==-1?"Key not found":("Key found at position "+index));
}
}
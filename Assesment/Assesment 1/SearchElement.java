
class SearchElement{
	public static void main(String[] args){
		int[] arr={1,3,5,6};
		int[] arr1 = {2,5,16,19,23,27,31};
		System.out.println("The element found at index "+search(arr,5));
		System.out.println("The element found at index "+search(arr,2));
		System.out.println("The element found at index "+search(arr,7));
		System.out.println("The element found at index "+search(arr1,19));
		System.out.println("The element found at index "+search(arr1,30));
	}
	
	public static int search(int[] arr,int target){
		int n = arr.length;
		int low = 0, high = n-1;
		while(low<=high){
			int mid=(low+high)/2;
			if(arr[mid]==target) return mid;
			else if(arr[mid]<target) low=mid+1;
			else if(arr[mid]>target) high = mid-1;
		}
		return low;
	}
}
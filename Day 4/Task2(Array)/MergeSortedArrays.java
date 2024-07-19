/*Given two sorted arrays A and B of size p and q, write a Java program to merge elements of A with B by maintaining the sorted order i.e. fill A with first p smallest elements and fill B with remaining elements.
*/

class MergeSortedArrays{
public static void main(String[] args){
	int[] A = { 2, 4, 9 };
	int[] B =  { 1, 5, 6, 7, 8 ,10};
	for(int i=0;i<A.length;i++){
		if(B[0]<A[i]){
			int temp = B[0];
			B[0] = A[i];
			A[i] = temp;
			int k=1;
			int key = B[0];
			while(k<B.length && B[k]<key){
				B[k-1] =B[k];
				k++;
			} 
			B[k-1] = key;
		}
	}
	System.out.println("Array A:");
	for(int i=0;i<A.length;i++) System.out.print(A[i]+" ");
	System.out.println();
	System.out.println("Array B :");
	for(int i=0;i<B.length;i++) System.out.print(B[i]+" ");
}

}
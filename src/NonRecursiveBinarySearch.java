import java.util.Scanner;
public class NonRecursiveBinarySearch{

	    Scanner input = new Scanner (System.in);
		char[] arr = {'a','b','c','d','e'};
		int low =0;
		int high= arr.length-1;
		int middle = (low+high+1)/2;
		
		int position = -1;
		
		
	
		
		public  NonRecursiveBinarySearch(){
			
			System.out.println(arr);
			System.out.println("enter your search key from the above list of characters");
			String value = input.nextLine();
			char value1 = value.charAt(0);
		for(int i=0; i<arr.length; i++){
			if(value1==arr[middle]){
				position = middle;
			}
			else if (value1<arr[middle]){
				high=middle-1;
				low =0;
				if(arr.length%2==0)
				middle= (low+high+1)/2;
				else
					middle = (low+high)/2;
				
				position = middle;
				
			}
			else if(value1>arr[middle]&& value1<=arr[high]){
				high=arr.length-1;
				low = middle+1;
				if(arr.length%2==0)
				middle = (low+high+1)/2;
				
				else
					middle = (low+high)/2;
				     
				position = middle;
				
			}
			if(value1>arr[high])
			System.out.println("the search key cannot be found");
			
			
		}
		
		System.out.println(value1+" is at index " +position);
	}

		 public static void main (String[] args){
			 NonRecursiveBinarySearch nonRecursive = new  NonRecursiveBinarySearch();
		 }

}

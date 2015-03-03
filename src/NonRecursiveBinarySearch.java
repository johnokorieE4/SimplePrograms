


public class NonRecursiveBinarySearch{

	
		char[] arr = {'a','b','c','d','e'};
		int low =0;
		int high= arr.length-1;
		int middle = (low+high+1)/2;
		int position = 0;
		
		public  NonRecursiveBinarySearch(){
		for(int i=0; i<arr.length; i++){
			if(arr[0]==middle){
				position = middle;
			}
			else if (arr[0]<middle){
				high=middle-1;
				low =0;
				middle= (low+high+1)/2;
				if(arr[0]==middle)
				position=middle;
			}
			else if(arr[0]>middle){
				high=arr.length-1;
				low = middle+1;
				middle = (low+high+1)/2;
				if(arr[0]==middle)
				position = middle;
			}
			
		}
		
		System.out.println(position);
	}

		 public static void main (String[] args){
			 NonRecursiveBinarySearch nonRecursive = new  NonRecursiveBinarySearch();
		 }

}

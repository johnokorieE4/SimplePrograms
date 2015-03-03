
public class SimpleSearch {

	
		
	

         char[] arr = {'a','b','c','d','e'};
         int high = arr.length-1;
         int low = 0;
         int middle =(low+high+1)/2;
         int position = 0;
         
        
      public SimpleSearch(){
         for (int i=0; i<arr.length; i++){
        	 if(arr[0]<arr[middle])
        		 high=middle-1;
        	 else 
        		 low = middle+1;
        	 
        	 middle = (low+high+1)/2;
        	 position = middle;
        	 
         }
         System.out.println("the first occurrence is at position "+ position);
      }
    
public static void main (String[] args){
	SimpleSearch simple = new SimpleSearch();
   }
}
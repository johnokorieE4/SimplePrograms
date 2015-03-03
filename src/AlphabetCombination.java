
public class AlphabetCombination {
	
	int count = 0;
    public AlphabetCombination(){
 	   char[] abcdeArray = {'a','b','c','d','e'};
 	   for (int a=0; a<abcdeArray.length; a++){
 		   for(int b=0; b<abcdeArray.length; b++){
 			   for(int c=0; c<abcdeArray.length; c++){
 				   for(int d=0; d<abcdeArray.length; d++){
 					   for(int e=0; e<abcdeArray.length; e++){ 
 						   
 					   
 						   System.out.print(abcdeArray[a]);
						   System.out.print(abcdeArray[b]);
						   System.out.print(abcdeArray[c]);
						   System.out.print(abcdeArray[d]);
						   System.out.print(abcdeArray[e]);
						   System.out.println();
						   count++;
 					   }
 				      } 
				   }
			   }
		   }
 	  System.out.println("there were "+count + " total combinations of abcde");
	   }
 	

	public static void main(String[] args) {
		
            new AlphabetCombination();
	}

}

import java.util.Scanner;
public class MainClass {
	public static void main (String[] args){
		System.out.println("1. AlphabetCombination");
		System.out.println("2. BinarySearch");
		System.out.println("3. NonRecursiveBinarySearch");
		System.out.println("4. EXIT");
		System.out.println("choose a program to run.. enter 1, 2 or 3");
		
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();
		
		
		switch (answer){
		case 1: 
			AlphabetCombination ac = new AlphabetCombination();
			break;
			
		case 2:
			SimpleSearch ss = new SimpleSearch();
			break;
		case 3:
			NonRecursiveBinarySearch nonrecursive = new NonRecursiveBinarySearch();
			break;
		case 4:

			System.out.println("the program has ended");
			break;
		}
		
		
	}

}

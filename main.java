import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
//Mohammed Chowdhury
//Grissel Lopez
// Yi Yu

public class main {

	static String stringBefore;
	static String stringAfter; 
	
	public static void main(String[] args) throws IOException {	
		ReadFromFile(); 
		cleanString(); 
		printInfo(); 
		FindLPS();  // find the longest non-contigious subsequence	
		FindContigiousLPS(); 
	}
	public static void FindContigiousLPS() {	
		
		System.out.println();
		LPSContiguous lps = new LPSContiguous(); 
		HashSet<String> set = lps.lps(stringAfter); 
		System.out.println("longest palindromic contiguous subsequence is: ");
		//System.out.println(ans);
		int length = 0; 
		for(String s: set) {
			length = s.length(); 
			System.out.println(s);
		}
		System.out.println("longest palindromic non-contiguous subsequence has a length of "+length);
	}
	
	
	
	public static void FindLPS() {	
		LPS lps = new LPS(); 
		String ans = lps.lps(stringAfter); 
		System.out.println("longest palindromic non-contiguous subsequence is: ");
		System.out.println(ans);
		System.out.println("longest palindromic non-contiguous subsequence has a length of "+ans.length());
	}
	
	public static void ReadFromFile() throws IOException {	
		stringBefore = ""; 
		File file = new File("/Users/mohammedchowdhury/OneDrive - CUNY/ALL JAVA WorkSpaces/JavaYoutubeWalkThrough/TeitelmanProject2/src/QueensCollegeDescription.txt"); //link the file
		BufferedReader br = new BufferedReader(new FileReader(file));   
		String st; 
		while ((st = br.readLine()) != null) {
			stringBefore = stringBefore+st; 
		} 	
	}
	
	public static void cleanString(){
		stringAfter = stringBefore; 	
		stringAfter = stringAfter.replaceAll("[^A-Za-z]", ""); // replace all the non alphabet chracters
		stringAfter = stringAfter.toUpperCase(); 	
		
	}
	
	public static void printInfo() {
		System.out.println("String Before: ");
		System.out.println(stringBefore);
		System.out.println(" \n");
		System.out.println("String After: ");
		System.out.println(stringAfter);
		
		System.out.println(" \n");
		System.out.println("Number of chracters before it was cleaned :"+ stringBefore.length());
		System.out.println("Number of chracters after it was cleaned :"+ stringAfter.length());	
		System.out.println();
	}
}






class LPS{ 	
	static String ans = ""; 
	
	static int max (int x, int y){ 		
		return (x > y)? x : y; 
	} 
	public static String lps(String seq){ 
		int n = seq.length(); 
		int j; 
		// Create a table to store results of subproblems 
		int L[][] = new int[n][n]; 
		String K [][] = new String[n][n]; 
		for(int b=0; b<n;b++) {
			for(int a=0; a<n; a++) {
				if(b==a) {
					K[a][a] = seq.charAt(a)+""; 
				}
				else {
					K[b][a] = ""; 
				}
			}
		}
		// Strings of length 1 are palindrome of lentgh 1 
		for (int i = 0; i < n; i++) {
			L[i][i] = 1; 
		}
		
		for (int cl=2; cl<=n; cl++){ 
			for (int i=0; i<n-cl+1; i++){ 
				j = i+cl-1; 
				if (seq.charAt(i) == seq.charAt(j) && cl == 2) { 
					L[i][j] = 2; 
					String t =  seq.charAt(j)+""+seq.charAt(i); 
					K[i][j] = t; 

				}
				else if (seq.charAt(i) == seq.charAt(j)) { 
					L[i][j] = L[i+1][j-1] + 2; 

					String t = seq.charAt(i)+K[i+1][j-1]+seq.charAt(j); 
					K[i][j] = t; 
				}
				else {			
					int x =  max(L[i][j-1], L[i+1][j]);
					if(L[i+1][j]==x) {
						L[i][j] = x; 
						K[i][j] = K[i+1][j]; 
					}else {
						L[i][j] = x; 
						K[i][j] = K[i][j-1]; 
					}

				}

			} 
		} 
		
		ans  = K[0][n-1]; 		
		return ans;
		
	} 

	public static void main(String args[]){ 	
//		String seq = "QUEENSCOLLEGEENJOYSANATIONALREPUTATIONFORITSLIBERALARTSANDSCIENCESANDPREPROFESSIONALPROGRAMSWITHITSEXTENSIVERANGEOFGRADUATEANDUNDERGRADUATEDEGREESHONORSPROGRAMSRESEARCHOPPORTUNITIESANDINTERNSHIPPLACEMENTSTHECOLLEGESERVESMORETHANSTUDENTSMENTOREDBYANAWARDWINNINGFACULTYLOCATEDONABEAUTIFULACRECAMPUSTHECOLLEGEHASBEENCITEDFORCONSECUTIVEYEARSINTHEPRINCETONREVIEWASABESTVALUECOLLEGEUSNEWSANDWORLDREPORTANDFORBESMAGAZINEALSORANKQUEENSCOLLEGEABESTVALUECOLLEGETHANKSTOITSOUTSTANDINGACADEMICSGENEROUSFINANCIALAIDPACKAGESANDAFFORDABILITYTHEEQUALITYOFOPPORTUNITYREPORTPLACEDQUEENSCOLLEGEINTHETOPONEPERCENTOFALLCOLLEGESINMOVINGSTUDENTSFROMPOVERTYTOPROSPERITY"; 
//		System.out.println("The lnegth of the lps is "+ lps(seq));
//		System.out.println(ans.length());
	} 
} 
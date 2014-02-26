public class Levenshtein {

    public static int socialNetworkSize ( String p, String [] dictionary ){
		if (dictionary == null | dictionary.length == 0 ) return 0;
		
		int result = 0;
		
		java.util.HashSet<String> friends = new java.util.HashSet<String> ();
		friends.add(p);
		
		for ( int j = 0; j < dictionary.length; j++ ){
			for ( String d :friends){
				if ( levenshteinIs1 (dictionary [ j ],d) && !friends.contains(dictionary [ j ])){
					//System.out.println (j + " " + dictionary [ j ]);
					friends.add(dictionary [ j ]);
					j=0;	//NOTE: This is sub-optimal. A smarter way is to save the location j for this word
							//in a HashMap, in order not to check for this word's friends before position j.
					break;
				}
			}
		}

		result = friends.size();
		return result;
	}
	
	public static boolean levenshteinIs1 (String p, String q ){
		if ( p.equals(q)) return false;

		if (Math.abs ( p.length() - q.length()) >1 ) return false;
		
		if ( p.length() == q.length()){
			for ( int i = 0; i < p.length(); i++){
				if ( p.charAt(i)!= q.charAt(i)){
					return p.substring(i+1).equals(q.substring(i+1)); 
				}
			}
		}
		
		String pPrime = p, qPrime = q;
		
		//pPrime must be the longest.
		if ( q.length() > p.length()){ 
			pPrime = q;
			qPrime = p;
		}
		
		for ( int i = 0; i < qPrime.length(); i++){
			if ( pPrime.charAt(i) != qPrime.charAt(i)){
				return pPrime.substring(i+1).equals(qPrime.substring(i)); 
			}
		}

		return true;
	}
	
	public static void main(String[] args) throws java.io.IOException {
		// TODO Auto-generated method stub
		//boolean q = levenshteinIs1 ("macro", "macros");
		
		if ( args.length != 1 ){
			System.out.println ("Wrong number of parameters");
			return;
		}
		
		java.io.File f = new java.io.File ( args [ 0 ] );
		java.io.FileReader isr = new java.io.FileReader ( f );
		java.io.BufferedReader b = new java.io.BufferedReader ( isr );
		
		String line = null;
		java.util.ArrayList < String > wordList = new java.util.ArrayList < String > ();
		java.util.ArrayList < String > dictionaryList = new java.util.ArrayList < String > ();
		
		boolean doneWithEntries  = false;
		while ( !doneWithEntries && (line = b.readLine())!= null){
			if ( line.equals("END OF INPUT")) doneWithEntries = true;
			else wordList.add(line);
		}
		
		while ( ( line = b.readLine())!= null ){
			dictionaryList.add(line);
		}
		
		String [] dictionary = dictionaryList.toArray(new String [ 0 ] );

		for ( int i = 0; i < wordList.size(); i++){
			int result = socialNetworkSize ( wordList.get(( i )), dictionary ); 
			System.out.println ( result );
		
		}
		
		b.close ();

	}
	
}

package codeeval;

public class Pangrams {
	public static String giveLetters ( String s ){
		if ( s == null ) s = "";
		java.util.HashMap <Character, Boolean> h = new java.util.HashMap <Character, Boolean> ();

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i=0; i < alphabet.length(); i++){
			h.put ( alphabet.charAt ( i ), false );
		}

		for ( int i=0; i < s.length(); i++){
			Character c;
			h.put ( Character.toLowerCase(s.charAt ( i )), true);
		}

		StringBuffer sb = new StringBuffer ();
		for ( char key : h.keySet () ){
			if ( !h.get(key) ){
				sb.append(key );
			}
		}

		//Sort the output.
		String output = sb.toString ();
		char [] chars = output.toCharArray ();
		java.util.Arrays.sort(chars);

		output = new String ( chars );

		if ( output.length() == 0) output="NULL";
		return output;
	}


	public static void main(String[] args) throws java.io.IOException {
		// TODO Auto-generated method stub

		String filePath = args [ 0 ];

		java.io.File file = new java.io.File ( filePath );

		java.io.FileReader fr = new java.io.FileReader( file );

		java.io.BufferedReader br = new java.io.BufferedReader ( fr );

		String line = new String ();

		while ( ( line = br.readLine()) != null ){

			System.out.println ( giveLetters (line));

		}
		
		br.close ();
	}

}

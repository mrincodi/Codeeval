import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SelfDescribingNumbers {
    public static void main (String[] args) throws IOException {
    
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;

    while ((line = in.readLine()) != null) {
        //System.out.println (line);
        if ( isAutodescriptive ( Integer.parseInt(line))) System.out.println ( "1 ");
    	else System.out.println ( "0 ");
    }

  }
    
    public static boolean isAutodescriptive ( int number ){
    
    	String numberString = "" + number;
   	
    	//System.out.println ( "Revisando XX" + numberString + "XX");
    	
    	for ( int i = 0; i < numberString.length (); i++ ){
    		
    		int valueSearched = i;
    		
    		char charSearched = Character.forDigit(valueSearched, 10);

    		//System.out.println ( "Vamos por el XX" + valueSearched + "XX");

    		int numberOfTimes = 0;
    		
    		for (int j = 0; j < numberString.length (); j++ ){
    			if ( numberString.charAt(j) == charSearched){
    				numberOfTimes++;
    			}
    		}
    		
    		int expectedNumberOfTimes = Integer.parseInt( ""  + numberString.charAt(i));
    		
    		if ( numberOfTimes != expectedNumberOfTimes) return false;
    	}
    		
    	return true;
    		
    }
}

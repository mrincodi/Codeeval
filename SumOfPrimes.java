public class SumOfPrimes {

    static java.util.ArrayList < Integer> primeList = new java.util.ArrayList < Integer> ();

	public static int suma ( int cuantos ) {
		int sumaTotal = 0;
		
		int i = 2;
		
		do {
			if ( esPrimo ( i ) ) sumaTotal += i;
			i++;
		}
		while ( primeList.size() < cuantos );
		
		return sumaTotal;
	}

	public static boolean esPrimo ( int num ){
		for ( int i = 0; i < primeList.size(); i++ ){
			if ( num % primeList.get ( i ) == 0 )
				return false;
		}
		primeList.add(num);
		return true;
	}
	
	public static void main ( String [] args ) {
		System.out.println ( suma ( 1000 ) ) ;
	}
	
}


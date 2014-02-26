class TreeNode {
    int value;
	TreeNode left;
	TreeNode right;

	public TreeNode ( int value ){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}


public class LowestCommonAncestor {

public static int commonAncestor ( int x, int y, TreeNode t ){
	if ( t == null ) return -1; //Or throw an exception.

	boolean xInLeft = containsNode ( t.left, x );
	boolean xInRight = containsNode ( t.right, x );
	boolean yInLeft = containsNode ( t.left, y );
	boolean yInRight = containsNode ( t.right, y );

	if ( t.value == x && ( yInLeft || yInRight ) )	return x;
	if ( t.value == y && ( xInLeft || xInRight ) )	return y;

	if ( ( xInLeft && yInRight ) || ( yInLeft && xInRight ) ) return t.value;

	if ( xInLeft && yInLeft ) return commonAncestor (x,y, t.left );
	if ( xInRight && yInRight ) return commonAncestor (x,y, t.right );

	return -1; //Or throw some exception.

}

public static boolean containsNode ( TreeNode t, int value ){
	if ( t == null ) return false;

	if ( t.value == value ) return true;

	return ( containsNode ( t.left, value ) || containsNode ( t.right, value ) );
}
	
public static void main ( String [] args ) throws java.io.IOException{

	TreeNode t = new TreeNode ( 30 );
	t.left =  new TreeNode ( 8 );
	t.right = new TreeNode ( 52 );
	t.left.left = new TreeNode ( 3 );
	t.left.right = new TreeNode ( 20 );
	t.left.right.left = new TreeNode ( 10 );
	t.left.right.right = new TreeNode ( 29 );

	java.io.File f= new java.io.File ( args [ 0 ]);	
	java.io.FileReader fileReader = new java.io.FileReader ( f );
	java.io.BufferedReader bufferedReader = new java.io.BufferedReader ( fileReader );

	String line;

	while ( (line = bufferedReader.readLine () ) != null ){
		String [] words = line.split ( " " );
		int x = Integer.parseInt ( words [ 0 ] );
		int y = Integer.parseInt ( words [ 1 ] );

		int result = commonAncestor ( x, y, t );
		System.out.println ( result );
	}
	
	bufferedReader.close();
}

}


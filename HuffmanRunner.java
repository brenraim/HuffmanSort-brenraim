/**
*	Brendan Raimann
*	2/6/16
*	Version 1.0
*	HuffmanRunner Class - Used for running the HuffmanTree and HuffmanNode classes
*/

public class HuffmanRunner
{
	/** Main method */
	public static void main (String[] args)
	{
		String s = "This is a test.";
		HuffmanTree tree = new HuffmanTree(s);
		System.out.println(tree.encode());
		//  returns 1001111011110100111101001000001011101011011100
		System.out.println(tree.decode("1001111011110100111101001000001011101011011100"));
		
	}
}
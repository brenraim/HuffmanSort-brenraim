/**
*	Brendan Raimann
*	2/6/16
*	Version 1.0
*	HuffmanNode Class - Used as nodes for a binary tree
*/

public class HuffmanNode implements Comparable<HuffmanNode>
{
	/** The frequency of the String */
	private int freq;
	/** The stored String for the node */
	private String key;
	/** Pointer to the left node */
	private HuffmanNode left;
	/** Pointer to the right node */
	private HuffmanNode right;
	
	/**
	*	Constructor that builds the node
	*	@param s The String to be stored in the node
	*	@param n The number of occurrences for the String
	*/
	public HuffmanNode(String s, int n)
	{
		key = s;
		freq = n;
		left = null;
		right = null;
	}
	
	/**
	*	Returns the String of the node
	*	@return Returns the stored String
	*/
	public String getString()
	{
		return key;
	}
	
	/**
	*	Returns the frequency of the String
	*	@return Returns the number of occurrences for the String
	*/
	public int getFreq()
	{
		return freq;
	}
	
	/**
	*	Returns the left node pointer
	*	@return Returns the pointer to the left node
	*/
	public HuffmanNode getLeft()
	{
		return left;
	}
	
	/**
	*	Returns the right node pointer
	*	@return Returns the pointer to the right node
	*/
	public HuffmanNode getRight()
	{
		return right;
	}
	
	
	/**
	*	Sets the left node
	*	@param node The node for the left pointer
	*/
	public void setLeft(HuffmanNode node)
	{
		left = node;
	}
	
	/**
	*	Sets the right node
	*	@param node The node for the right pointer
	*/
	public void setRight(HuffmanNode node)
	{
		right = node;
	}
	
	/**
	*	Returns whether or not the node has left and right pointers
	*	@return Returns true of the left and right pointers are null
	*/
	public boolean isLeaf()
	{
		if (left == null && right == null)
			return true;
		return false;
	}
	
	/**
	*	Allows for comparing nodes
	*	@param node Another node for comparison
	*	@return Returns the difference in frequency between the nodes
	*/
	public int compareTo(HuffmanNode node)
	{
		return freq - node.freq;
	}
	
	/**
	*	Returns a String representation of the node and its children
	*	@returns A String representation of the node
	*/
	public String toString()
	{
		String value = "[ " + key + ", " + freq + "]";
		if (isLeaf() == true)
			return value;
		else
		{
			if (left != null && right == null)
				return value + "(" + left.toString() + ",)";
			if (left == null && right != null)
				return value + "(," + right.toString() + ")";
			return value + "(" + left.toString() + "," + right.toString() + ")";
		}
	}
	
}
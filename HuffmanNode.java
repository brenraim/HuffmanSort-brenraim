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
	*/
	public HuffmanNode(String s)
	{
		key = s;
		freq = 1;
		left = null;
		right = null;
	}
	
	/**
	*	Returns the String of the node
	*/
	public String getString()
	{
		return key;
	}
	
	/**
	*	Returns the frequency of the String
	*/
	public int getFreq()
	{
		return freq;
	}
	
	/**
	*	Returns the left node pointer
	*/
	public HuffmanNode getLeft()
	{
		return left;
	}
	
	/**
	*	Returns the right node pointer
	*/
	public HuffmanNode getRight()
	{
		return right;
	}
	
	/**
	*	Increases the frequency value by 1
	*/
	public void updateFreq()
	{
		freq++;
	}
	
	/**
	*	Sets the left node
	*/
	public void setLeft(HuffmanNode node)
	{
		left = node;
	}
	
	/**
	*	Sets the right node
	*/
	public void setRight(HuffmanNode node)
	{
		right = node;
	}
	
	/**
	*	Allows for comparing nodes
	*/
	public int compareTo(HuffmanNode node)
	{
		return freq - node.freq;
	}
	
}
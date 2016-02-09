/**
*	Brendan Raimann
*	2/6/16
*	Version 1.0
*	HuffmanTree Class - Used for building a binary tree to compact data
*/

import java.util.PriorityQueue;
import java.util.HashMap;

public class HuffmanTree
{
	/** Pointer to the root node */
	private HuffmanNode root;
	
	/** Contains the string for encoding */
	private String str;
	
	/** Constructor that builds the binary tree
	*	@param s The string of letters to be used to build a Huffman Tree
	*/
	public HuffmanTree(String s)
	{
		str = s;
		root = buildTree(buildQueue(createMap(s)));
	}
	
	/**
	*	Takes in a string and turns it into a HashMap
	*	@param s A string to be turned into a HashMap
	*/
	private HashMap<String,Integer> createMap(String s)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++)
		{
			if (map.containsKey(s.substring(i,i+1)))
				map.put(s.substring(i,i+1),map.get(s.substring(i,i+1))+1);
			else
				map.put(s.substring(i,i+1),1);
		}
		return map;
	}
	
	/**
	*	Builds a PriorityQueue of HuffmanNode's using a HashMap
	*	@param map A HashMap<String, Integer> That stores a letter and its number of occurrences
	*	@return A PriorityQueue<HuffmanNode> that stores nodes with letters and their frequencies
	*/
	private PriorityQueue<HuffmanNode> buildQueue(HashMap<String,Integer> map)
	{
		PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
		
		for (String s: map.keySet())
		{
			queue.add(new HuffmanNode(s, map.get(s)));
		}
		return queue;
	}
	
	/**
	*	Builds a binary tree using a PriorityQueue<HuffmanNode>
	*	@param queue A PriorityQueue that stores nodes for the tree
	*	@return Returns the root node
	*/
	private HuffmanNode buildTree(PriorityQueue<HuffmanNode> queue)
	{
		HuffmanNode node;
		HuffmanNode head1;
		HuffmanNode head2;
		while (queue.size() > 1)
		{
			head1 = queue.remove();
			head2 = queue.remove();
			node = new HuffmanNode(head1.getString() + head2.getString(), head1.getFreq() + head2.getFreq());
			node.setLeft(head1);
			node.setRight(head2);
			queue.add(node);
		}
		return queue.remove();
		
	}

	/**
	*	Used to encode the String in the class field to binary digits
	*	@return Returns a series of binary digits in a String
	*/
	public String encode()
	{
		String output = "";
		String temp = "";
		HuffmanNode index;
		for (int i = 0; i < str.length(); i++)
		{
			index = root;
			while (index.isLeaf() == false)
			{
				if (index.getLeft().getString().indexOf(str.substring(i,i+1)) >= 0)
				{
					index = index.getLeft();
					temp += "0";
				}
				else
				{
					index = index.getRight();
					temp += "1";
				}
					
			}
			output += temp;
			temp = "";
		}
		return output;
	}

	/**
	*	Used to decode 
	*	@param s Binary digits in a String
	*	@return Returns the result of decoding the binary digits into symbols using the tree
	*/
	public String decode(String s)
	{
		String output = "";
		HuffmanNode index = root;
		for (int i = 0; i < s.length(); i++)
		{
			if (index.isLeaf() == true)
			{
				output += index.getString();
				index = root;
				i--;
			}
			else
			{
				if (s.charAt(i) == '0')
					index = index.getLeft();
				else
					index = index.getRight();
			}
		}
		output += index.getString();
		return output;
	}
}
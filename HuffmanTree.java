import java.util.PriorityQueue;
import java.util.HashMap;

public class HuffmanTree
{
	/** Pointer to the root node */
	private HuffmanNode root;
	
	/** Constructor 
	*	@param s The string of letters to be used to build a Huffman Tree
	*/
	public HuffmanTree(String s)
	{
		root = new HuffmanNode(s);
		PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
		createMap("This is a test.");
		
	}
	
	/**
	*	Takes a string and turns it into a HashMap
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
		//System.out.println(s.substring(i,i+1) + " " + map.get(s.substring(i,i+1)));
		}
		return map;
	}
	
	private void buildQueue()
	{
		System.out.println("temp");
	}
	/**
	*	Used to decode 
	*	@param s A String of letters and symbols to be encoded into digits
	*/
	public String decode(String s)
	{
		return "s";
	}
	
	/**
	*	Used to encode
	*	@param s A String of digits to be decoded into letters and symbols
	*/
	public String encode(String s)
	{
		return "s";
	}
}
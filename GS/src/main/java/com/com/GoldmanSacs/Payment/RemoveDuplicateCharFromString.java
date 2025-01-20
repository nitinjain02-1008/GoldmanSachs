package com.GoldmanSacs.Payment;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* Problem Name is &&& First NonRepeating &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement findFirst() correctly.
 *  4) If time permits, try to improve the efficiency of your implementation
 */

public class RemoveDuplicateCharFromString {

	  /**
	  * char findFirst(String input)
	  * Finds the first character that does not repeat anywhere in the input string
	  * If all characters are repeated, return 0
	  * Given "apple", the answer is "a"
	  * Given "racecars", the answer is "e"
	  * Given "ababdc", the answer is "d"
	  **/
	public static char findFirst(String input)
	{	
		// TODO: Implement solution
	    LinkedList<Character> queue = new  LinkedList<>();
	    Set<Character> charSet = new HashSet<Character>();
	    String s = input.replaceAll("\\s+", "");
	    
	    for(int i =0; i < s.length(); i++)
	    {	        
	    	if(queue.contains(s.charAt(i)) )
	    	{	          
	        	queue.remove(queue.indexOf(s.charAt(i)));
	        }
	    	else if(!charSet.contains(s.charAt(i))){
	    		queue.addLast(s.charAt(i));
	    		charSet.add(s.charAt(i));
	        }
	    }
	
	    if(queue.size()>0)
	      return (char)queue.getFirst();
	    
	    return '0';
	}

  /**
   * boolean doTestsPass()
   * Returns true if all tests pass. Otherwise returns false.
   */
  public static boolean doTestsPass()
  {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    String[] inputs = {"apple alea","racecars", "ababdc"};
    char[] outputs = {'0', 'e', 'd' };

    boolean result = true;
    for(int i = 0; i < inputs.length; i++ )
    {
    	char c = findFirst(inputs[i]);
      result = result &&  c == outputs[i];
      if(!result)
        System.out.println("Test failed for: " + inputs[i]);
      else
        System.out.println("Test passed for: " + inputs[i]);
    }
    return(result);
  }

  public static void main(String args[])
  {
    doTestsPass();
  }
}

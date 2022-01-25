import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Nikki Mcintyre
 * Will take a an array of Strings and figure out the longest common prefix. 
 * I.E.
 * 'aa, ab, ac' returns 'a'
 * 'aaw, bw, tf' returns the empty string
 * 'baby, bad. bank' returns 'ba'
 * and so on
 */
class Solution {
  public static void main(String[] args) {
    //take input of the list of strings and splits them on spaces
    System.out.println("Enter the strings you want to find the longest common prefix of seperated by space");
    Scanner kbd = new Scanner(System.in);
    String input = kbd.nextLine();
    kbd.close();
    String[] solve = input.split("\\s");
    //sends the input to the method 
    System.out.print("longest prefix is " + longestCommonPrefix(solve));
  }

  /**
   * Takes the string and determines the longest common prefix within them
   * @param strs the string array in question to find the common prefixes in 
   * @return the longest common prefix as a string
   */
  public static String longestCommonPrefix(String[] strs) {
    //String to hold the common prefix
    String biggestCommonPrefix = "";
    //how many strings are in the array
    int numberOfWords = strs.length;
    //a 2D array taking in an array of an array of characters. Not ideal but does work
    ArrayList<ArrayList<Character>> words = new ArrayList<ArrayList<Character>>();
    //iterating through all the words 
    for (int i = 0; i < numberOfWords; i++) {
      //add a new array list of characters for eaqch word
      words.add(new ArrayList<Character>());
      char[] temp = strs[i].toCharArray();
      //add all the characters of the word into a new arraylist
      for (int j = 0; j < temp.length; j++) {
        words.get(i).add(temp[j]);
      }
    }
    //Now if you got 2 words ["Foo", "Foobar"] you now got 2 arrays of arrays of characters[ ['F', 'o', 'o'], ['F', 'o', 'o', 'b', 'a', 'r'] ]

    //the index of the character currently being looked at
    int index = 0;
    //the current character that's being looked at
    char currentChar;
    //if the first element is empty return the empty string otherwise make the first character of the first word be the one we're looking at
    try{
       currentChar  = words.get(0).get(0);
      }
        catch(Exception e){
            return "";
        }
    //iterating through all the words
    for(int i=0; i<words.size(); i++){

      char x;
      //try to assign the current word and index if it's empty break out of the for loop
      try{
         x = words.get(i).get(index);
      }
      catch(Exception e){
        break;
      }
      //if the character is not the same as the previous words break out of the loop
      if (x != currentChar) {
        break;
      }
      //if cyclyed through all the words without breaking
      if(i == words.size()-1){
        //increase the index being looked at
        index ++;
        //start with the first word again
        i = 0;
        //add the character that was just established to be in all the words to the strong
        biggestCommonPrefix += currentChar;
        //try to get the next character, if the string ends break from the loop
        try{
          currentChar = words.get(0).get(index);
        }
        catch(Exception e){
          break;
        }
      } 
    }

    return biggestCommonPrefix;
    }
}
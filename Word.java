/**
 * This class represents a Word object.
 * 
 * @author Gilad Gur
 * @version 16/06/16
 */
public class Word
{
    // instance variables:
    
    private String _st;
    
    // Constructor:
    /**
     * Creates a new Word object. Takes a String parameter and initializes the variable instance _st to it.
     * @param str The string to be initialized.
     */
    public Word(String str)
    {
        _st = str;
    }
    
    // Methods:
    /**
     * This method compares between 2 strings.
     * Returns 1 if the first string is larger in the alphabetical order.
     * Returns -1 if the first string is smaller in the alphabetical order.
     * Returns 0 if both strings are the same.
     * 
     * @param s1 The first string to compare.
     * @param s2 The second string to compare.
     * 
     * @return 1 if s1 is alphabetically larger than s2.
     * @return -1 if s1 is alphabetically smaller than s2.
     * @return 0 if s1 and s2 are alphabetically the same.
     */
    public int myCompare(String s1, String s2)
    {
        int shorterStr = s1.length() - s2.length(); // check which string is shorter
        int shortLength = s1.length() > s2.length() ? s2.length() : s1.length(); // initializes to the length of the shorter string      
        for (int i = 0; i < shortLength ; i++) // this loop compares every letter from 1'st till last, if at any point one is larger than other then break
        {
            int diff = s1.charAt(i) - s2.charAt(i); // check which i'th letter is larger, s1's or s2's.
            if (diff > 0) // s1's is larger
            {
                return 1;
            }
            else if (diff < 0) // s2's is larger
            {
                return -1;
            }       
        }
        // if the loop check finds all letters are the same, we check here which string is longer.
        if (shorterStr > 0) // s1 has more letters
        {
            return 1;
        }
        else if (shorterStr < 0) // s2 has more letters
        {
            return -1;
        }
        return 0; // s1 equals s2 in length and letters
    }
    
    private boolean equals(String s1, String s2)
    {
        return (myCompare(s1,s2) == 0); // true if s1 & s2 are the same Word
    }
    
    /**
     * This method returns the index within this Word of the first occurrence of the specified character.
     * If the given char does not exist in this Word, returns -1.
     * @param c the char to be searched in the Word.
     * @return i the index of 1'st occurrence of the given char. Otherwise returns -1.
     */
    public int myIndexOf(char c)
    {
        return this.myIndexOf(c, 0); // utilizes the myIndexOf(char c, int ind) method
    }
    
    /**
     * Returns the index within this Word of the first occurrence of the specified character, starting the search at the specified index.
     * If the given char does not exist in this Word from index ind, returns -1.
     * @param c the char to be searched in the Word.
     * @param ind the index of this Word to start the char search.
     * @return i the index of 1'st occurrence of the given char. 
     */
    public int myIndexOf(char c, int ind)
    {
        for (int i = ind; i < _st.length(); i++) // loop search for char from given index ind 
        {
            if (c == _st.charAt(i))
            {
                return i; // if char occurence found
            }
        }
        return -1; // NO char occurance found
    }
    
    /**
     * Returns the index of the first occurrence of the specified String, within this Word.
     * If the given String does not exist in this Word, returns -1.
     * @param str the String to be searched in the Word.
     * @return index the index of 1'st occurrence of the given String parameter. 
     */
    public int myIndexOf (String str)
    {
        int ind = this.myIndexOf(str.charAt(0)); // sets ind to first occurence of 1'st letter of given String parameter, using myIndexOf (char c) method
        return this.myIndexOf(str, ind);        // invoking myIndexOf (String str, int ind) to return the desired index
    }
    
    /**
     * Returns the index within this Word of the first occurrence of the specified String, starting the search at the specified index.
     * If the given String does not exist in this Word from index ind, returns -1.
     * @param str the String to be searched in the Word.
     * @param ind the index of this Word to start the String search.
     * @return index the index of 1'st occurrence of the given String parameter. 
     */
    public int myIndexOf (String str, int ind) 
    {    
        int actSize = _st.length() - ind; // the actual size of string to search
        if ((str.length() > _st.length()) || (this.myIndexOf(str.charAt(0)) == -1) || (str.length() > actSize))
            // check if parameter is longer than object 
            // OR if the 1'st character of parameter does not exist anywhere in object 
            // OR if str length is larger than the actual size to measure.
        {
                return -1;      //  one of above conditions occured
        }    
        String sub = "";
        for (int i = ind; i < _st.length(); i++) // outer loop runs over this Word from index ind
        {
                sub = this.mySubString(i, i + str.length() - 1); // the substring of this Word from current index to param length -1 
                if (equals(str,sub)) // check if current substring equals param
                {
                    return i;               // substring equals param, return the start index of String param in Word object 
                }
        }
        return -1; // substring NOT found in Word
    }
    
    /**
     * Returns a new string that is a substring of this Word. The substring begins at the specified begin index (i) and extends to the end of the Word. 
     * Thus the length of the substring is Word.length-1 - beginIndex.
     * @param i the index to begin the string extraction.
     * @return subStr the substring from i index to end Word to be extracted and returned.
     */
    public String mySubString(int i)
    {
        return this.mySubString(i, _st.length() - 1); // invoking mySubString method of Word class and initializing int j to last index of this string
    }
    
    /**
     * Returns a new string that is a substring of this Word. The substring begins at the specified begin index (i) and extends to the character at index end index - 1 (j). 
     * Thus the length of the substring is endIndex-beginIndex (j - i).
     * @param i the index to begin the string extraction.
     * @param j the index to end the string extraction including j index.
     * @return subStr the substring from i to j indexes to be extracted and returned.
     */
    public String mySubString(int i, int j)
    {
        if (i >= _st.length() || i > j) // check if 1) i is larger OR equal to this Word length, 2) i larger than j
        {
            return "";                  // return empty string if above condition apply
        }
        if(_st.length() > 0 && i <= j && i < _st.length()) 
            // check if 1) this Word is not empty, 2) i smaller OR equal to j, 3) i is smaller than Word length
        {
            String subStr = "";
            for(i = i; i <= j && j < _st.length() ; i++)
            {
                subStr += _st.charAt(i);
            }
            return subStr;
        }
        return "";
    }
}
/**
 * This program analyzes a text file, either read from a URL or a local file, and sorts the words in alphabetical order.
 */

import java.util.*;
import java.net.*;
import java.io.*;
public class TextBreakdownExtension
{
	public static void main(String[] args)
	{
	    Scanner input=new Scanner(System.in);
		ArrayList<String> linesOfText = new ArrayList<String>();
		linesOfText=readText(linesOfText);
		linesOfText=formatText(linesOfText);
        ArrayList<String> words=new ArrayList<String>();
		// Splitting lines into words and converting to lowercase
        for(int i=0;i<linesOfText.size();i++)
        {
            String[] a=linesOfText.get(i).split(" ");
            for(int j=0;j<a.length;j++)
            words.add(a[j]);
        }
		// Sorting words in alphabetical order
        for(int i=0;i<words.size();i++)
        	words.set(i,words.get(i).toLowerCase());
        for(int i=0;i<words.size();i++)
        {
            for(int j=i+1;j<words.size();j++)
            {
                if(words.get(j).compareTo(words.get(i))<0)
                {
                    String f=words.get(i);
                    words.set(i,words.get(j));
                    words.set(j,f);
                }
            }
        }
        System.out.println(words);
	}
	/**
     * Reads a .txt file from the internet or a local file and stores each line as a String in an ArrayList.
     * If there is a problem reading the file from the internet, it attempts to read from a local file.
     * @param text An ArrayList to store the lines of text from the file
     * @return The ArrayList containing the lines of text from the file
     */
	public static ArrayList<String> readText(ArrayList<String> text)
	{
		String website = "http://archive.org/stream/TheEpicofGilgamesh_201606/eog_djvu.txt";
		//String website = "";
		try{URL url = new URL(website);Scanner s = new Scanner(url.openStream());while(s.hasNext())text.add(s.nextLine());}
		catch(Exception e){try{Scanner s = new Scanner(new File("PrideAndPrejudice.txt"));while(s.hasNext())text.add(s.nextLine());}catch(Exception ex){}}
		return text;
	}
	/**
     * Removes the extra HTML formatting associated with the file and retains only letters and spaces from the text.
     * @param text The ArrayList containing the lines of text to be formatted
     * @return The formatted ArrayList containing only letters and spaces
     */
	public static ArrayList<String> formatText(ArrayList<String> text)
	{	for(int line =0;line<text.size();line++)
		{	String s = text.get(line);
			if(s.contains("The Epic Of Gilgamesh")&&!s.contains("<"))
			{	for(int a=line-1;a>=0;a--)text.remove(a);break;}}
		for(int line =0;line<text.size();line++)
		{	String s = text.get(line);
			text.set(line,text.get(line).replaceAll("[^a-zA-Z ]",""));
			if(s.contains("</pre>"))for(int a=line-5;a<text.size();text.remove(a));}
		return text;
	}
}
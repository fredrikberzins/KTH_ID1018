// SynonymHandler

/****************************************************************

SynonymHandler handles information about synonyms for various
words.

The synonym data can be read from a file and handled in various
ways. These data consists of several lines, where each line begins
with a word, and this word is followed with a number of synonyms.

The synonym line for a given word can be obtained. It is possible
to add a synonym line, and to remove the synonym line for a given
word. Also a synonym for a particular word can be added, or
removed. The synonym data can be sorted. Lastly, the data can be
written to a given file.

Author: Fadil Galjic

****************************************************************/

import java.io.*;    // FileReader, BufferedReader, PrintWriter,
// IOException
import java.util.*;  // LinkedList

import javax.xml.transform.Templates;

class SynonymHandler
{
	// readSynonymData reads the synonym data from a given file
	// and returns the data as an array
    public static String[] readSynonymData (String synonymFile)
                                         throws IOException
    {
        BufferedReader reader = new BufferedReader(
	        new FileReader(synonymFile));
        LinkedList<String> synonymLines = new LinkedList<>();
        String synonymLine = reader.readLine();
        while (synonymLine != null)
        {
			synonymLines.add(synonymLine);
			synonymLine = reader.readLine();
		}
		reader.close();

		String[] synonymData = new String[synonymLines.size()];
		synonymLines.toArray(synonymData);

		return synonymData;
    }

    // writeSynonymData writes a given synonym data to a given
    // file
    public static void writeSynonymData (String[] synonymData,
        String synonymFile) throws IOException
    {
        PrintWriter writer = new PrintWriter(synonymFile);
        for (String synonymLine : synonymData)
            writer.println(synonymLine);
        writer.close();

    }

    // synonymLineIndex accepts synonym data, and returns the
    // index of the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	private static int synonymLineIndex (String[] synonymData,
        String word)
    {
		int delimiterIndex = 0;
		String w = "";
		int i = 0;
		boolean wordFound = false;
		while (!wordFound  &&  i < synonymData.length)
		{
		    delimiterIndex = synonymData[i].indexOf('|');
		    w = synonymData[i].substring(0, delimiterIndex).trim();
		    if (w.equalsIgnoreCase(word))
				wordFound = true;
			else
				i++;
	    }

	    if (!wordFound)
	        throw new IllegalArgumentException(
		        word + " not present");

	    return i;
	}

    // getSynonymLine accepts synonym data, and returns
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String getSynonymLine (String[] synonymData,
        String word)
    {
		int index = synonymLineIndex(synonymData, word);

	    return synonymData[index];
	}

    // addSynonymLine accepts synonym data, and adds a given
    // synonym line to the data
	public static String[] addSynonymLine (String[] synonymData,
	    String synonymLine)
	{
		String[] synData = new String[synonymData.length + 1];
		for (int i = 0; i < synonymData.length; i++)
		    synData[i] = synonymData[i];
		synData[synData.length - 1] = synonymLine;

	    return synData;
	}

    // removeSynonymLine accepts synonym data, and removes
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	public static String[] removeSynonymLine (String[] synonymData,
	    String word)
	{
		// add code here
        int lineNr = synonymLineIndex(synonymData, word);

        String[] synData = new String[synonymData.length-1];
		for (int i = 0, n = 0; i < synonymData.length; i++)
        {
            if (synonymData[i] != synonymData[lineNr])
            {
                synData[n] = synonymData[i];
                n++;
            }
        }
	    return synData;
	}

    // addSynonym accepts synonym data, and adds a given
    // synonym for a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	public static void addSynonym (String[] synonymData,
	    String word, String synonym)
	{
        // add code here
        synonymData[synonymLineIndex(synonymData, word)] += ", " + synonym;
	}

    // removeSynonym accepts synonym data, and removes a given
    // synonym for a given word.
    // If the given word or the given synonym is not present, an
    // exception of the type IllegalArgumentException is thrown.
	public static void removeSynonym (String[] synonymData,
	    String word, String synonym)
	{
        // add code here
        String line = synonymData[synonymLineIndex(synonymData, word)];
        //String line = "beautiful | lovely, pretty, pleasing, graceful, appealing, charming";
        String[] splitString = line.split("( \\| )|(, )", 0);
        String replacmentLine = splitString[0] + " | ";
        for (int i = 1; i < splitString.length; i++)
        {
            if (splitString[i] != word)
            {
                if (i >= 2)
                    replacmentLine += ", ";
                replacmentLine += splitString[i];
            }
        }
        synonymData[synonymLineIndex(synonymData, word)] = replacmentLine;
	}

    // sortIgnoreCase sorts an array of strings, using
    // the selection sort algorithm
    private static void sortIgnoreCase (String[] strings)
    {
        // add code here
        // changes string[i] to next string
        for (int i = 0; i < strings.length-1; i++)
        {
            // compares string[i] with the other lines
            for (int n = i + 1; n < strings.length; n++)
            {   
                // compares which is first alfabeticly
                if (strings[i].compareTo(strings[n]) > 0)
                {
                    // swaps places so the first alfabetical gets it corect placment
                    String temporary = strings[i];
                    strings[i] = strings[n];
                    strings[n] = temporary;
                }
            }
        }
	}

    // sortSynonymLine accepts a synonym line, and sorts
    // the synonyms in this line
    private static String sortSynonymLine (String synonymLine)
    {
	    // add code here
        String[] splitString = synonymLine.split("( \\| )|(, )", 0);
        String replacmentLine = splitString[0] + " | ";

        String[] wordArray = new String[splitString.length - 1];
        for (int n = 1; n < splitString.length; n++)
        {
            wordArray[n-1] = splitString[n];        
        }
        Arrays.sort(wordArray);
        for (int n = 0; n < wordArray.length; n++)
        {
            if (n >= 1)
                replacmentLine += ", ";
            replacmentLine += wordArray[n];
        }
        return replacmentLine;
	}

    // sortSynonymData accepts synonym data, and sorts its
    // synonym lines and the synonyms in these lines
	public static void sortSynonymData (String[] synonymData)
	{
        // add code here
        for (int i = 0; i < synonymData.length; i++)
        {
            String sortedLine = sortSynonymLine(synonymData[i]);
            synonymData[i] = sortedLine;
        }
        sortIgnoreCase(synonymData);
	}
}
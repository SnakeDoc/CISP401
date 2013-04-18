package com.snakedoc.cisp401.march142013;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ThreeTextBlocks {
	
	// file names
	private final static String[] texts = {"para1.txt", "para2.txt", "para3.txt"};
	
	// main() method
	public static void main(String[] args) {
	    
	    ThreeTextBlocks ttb = new ThreeTextBlocks();
	    
		// main logic loop
		for (int i = 0; i < texts.length; i++) {
		    
		    // construct an object for each text
		    Text text = new Text(texts[0]); // should be 'i'
		    
		    // now report the text
			ttb.reportOnText(text);
		}
	}
	
	protected void reportOnText(Text txt) {
	    txt.doAnalyse();
	    txt.displayReport();
	}
}

class Text {
    
    // vars
    private File file;
    private int wordCount = 0;
    private int[][] charOccurance;
    private int avgWordLength = 0;
    
    
    // constructor
    // pass in String representation of the filename
    Text(String input) {
        this.file = new File(input);
    }
    
    // getters
    public int getWordCount() {
        return wordCount;
    }
    public int[][] getCharOccurance() {
        return charOccurance;
    }
    public int getAvgWordLength() {
        return avgWordLength;
    }
    
    public void doAnalyse() {
        System.out.println("Starting analysis...");
        
        try {
            
            this.calcWordCount();
            
            this.calcCharOccurance();

            this.calcAvgWordLength();
        
        } catch (IOException e) {
            System.err.println("Can Not Read File!");
            e.printStackTrace();
        }
        
        System.out.println("Analysis complete!");
    }
    
    public void displayReport() {
        System.out.println("\n\t| Analysis Report For " + file.getName());
        System.out.println("\t - Word Count: " + this.getWordCount());
        System.out.println("\t - Average Word Length: " + this.getAvgWordLength());
        System.out.print("\t - Top 10 Character Occurance: ");
        
        for (int i = 0; i < this.getCharOccurance()[0].length; i++) {
            System.out.print( ((char)this.getCharOccurance()[i][0]) + " - " + this.getCharOccurance()[i][1] + " " );
        }
    }
    
    /**
     * Gets the number of words in given text.
     * 
     * @param file Input file (text).
     * @return Integer representation of number of words in given text.
     * @throws IOException 
     */
    private void calcWordCount() throws IOException {
        this.wordCount = fileToString(this.file).split(" ").length + 1; // return number of "spaces" + 1
    }                                                   // +1 because spaces are in-between words.
    
    private void calcCharOccurance() throws IOException {
        
        // convert text to character array
        char[] txtCharArry = fileToString(this.file).toLowerCase().toCharArray();

        // construct new list to hold characters
        List<Character> chars = new ArrayList<Character>();
        
        // pre-parse text
        // add first array character, it will always be unique (being first)
        chars.add(txtCharArry[0]);
        for (int i = 1; i < txtCharArry.length; i++) {
            for (int k = 0; k < chars.size(); k++) {
                if (!(chars.contains(txtCharArry[i]))) { 
                    chars.add(txtCharArry[i]);
                }
            }
        }
        
        System.out.println(chars.size());
        
        int[][] metrics = new int[chars.size()][2];
        
        // now we have a list holding all unique characters from text
        
        // loop and assign outside array the char value's.
        for (int i = 0; i < chars.size(); i++) {
            metrics[i][0] = chars.get(i); // automagically convert char to int for easier tracking
        }

        // now loop and count repeats
        for (int i = 1; i < chars.size(); i++) {
            for (int k = 0; k < txtCharArry[k]; k++) {
                 if (txtCharArry[k] == chars.get(i)) {
                     metrics[i][0] += 1;
                 }
            }
        }
        this.charOccurance = metrics;
    }
    
    private void calcAvgWordLength() throws IOException {
        
        String[] words = fileToString(this.file).replaceAll("^a-z\\sA-Z]", "").split(" ");
        System.out.println(words.length);
        
    }
    
    private static String fileToString(File file) throws IOException {
        
        FileInputStream fis = new FileInputStream(file); // open file stream, input file
        
        try {
            
            FileChannel fc = fis.getChannel();  // open file channel
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());  // read file into buffer
            
            return Charset.forName("UTF-8").decode(mbb).toString(); // return UTF-8 encoded string representation of the file
            
        } finally {
            
            fis.close(); // close file input stream
            
        }
    }
}


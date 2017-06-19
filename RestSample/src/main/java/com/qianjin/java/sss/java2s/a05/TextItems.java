package com.qianjin.java.sss.java2s.a05;


import java.io.*;
import java.util.*;

/**
 * A class of showing text one page at a time.The text is drawn from a file when
 * a TextItems object is constructed. Using List objects to hold the information
 * read from the file.
 *
 * @author Lingda Cai (A00372181)
 * @version 1.0
 */
public class TextItems {

    // Pointing to the file which will be read
    private File file;
    // Using this list object to hold the information read from the file.
    private List<Item> itemsList = new ArrayList<Item>();
    // An indicator if there are errors during reading from one file
    private boolean hasErrors = false;
    // The detailed error message
    private String errorMessage = "";

    /**
     * the constructor
     * 
     * @param fileName
     *            the file name which will be read
     * @exception FileNotFoundException
     *                maybe the file name is not correct
     */
    public TextItems(String fileName) {
        try {
            // construct file object
            file = new File(fileName);
            // using java Scanner to read from the text file
            Scanner fileScanner = new Scanner(file);
            // the item object will include text file content
            Item item = new Item();
            // The first line is the title of the text item. Using this boolean
            // to indicate if the current line is the first item line.
            boolean isTitle = true;
            // needs to check if the last line is correct with 80 -
            String lastLine = "";

            // start to read file content
            while (fileScanner.hasNextLine()) {
                // get the whole line
                String line = fileScanner.nextLine();
                // after this loop, the <code>lastLine<code> will the content of
                // last line
                lastLine = line;
                // After the last line of the item's text, there is a line of 80
                // hyphens, signaling the end of the item.(This must have
                // exactly 80 hyphens; otherwise it's just another line in the
                // file.)
                if (!line.matches("-{80}")) {
                    if (isTitle) {
                        // after setting title, turn off the indicator
                        item.setTitle(line);
                        isTitle = false;
                    } else {
                        // The following lines are the text of the item.
                        item.getLines().add(line);
                    }
                } else {
                    // if reach a line of 80 hyphens, means a new item start or
                    // reach the end of file
                    itemsList.add(item);
                    item = new Item();
                    // turn on the indicator of title
                    isTitle = true;
                }
            } // end while

            // close scanner
            fileScanner.close();

            // If the file ends unexpectedly, should print an appropriate
            // message on System.err and leave the object with no text items
            if (!lastLine.matches("-{80}")) {
                System.err.println("File '" + fileName + "' is improperly formatted");
                // Even if some items had previously been successfully read
                itemsList.clear();
            } // end if

        } catch (java.io.FileNotFoundException e) {
            // If the file requested by the client can't be found (or read
            // from), print an appropriate message on System.err and leave the
            // object with no text items.
            hasErrors = true;
            errorMessage = "Could not open file '" + fileName + "' for input";
        } // end try and catch
    } // end constructor

    /**
     * display the pre-formatted text which may include "pauses" where the
     * computer will stop and wait for the user to press the enter key.
     * 
     * @param itemName
     *            print the while data with the itemName
     */
    public void displayItem(String itemName) {
        // If the file requested by the client can't be found (or read from),
        // print an appropriate message on System.err and leave the object with
        // no text items.
        if (hasErrors) {
            System.err.println(errorMessage);
        } else {

            for (int i = 0; i < itemsList.size(); i++) {
                Item item = itemsList.get(i);
                if (item.getTitle().equals(itemName)) {
                    for (int j = 0; j < item.getLines().size(); j++) {
                        String line = item.getLines().get(j);
                        // Some items will contain a line of 80 at signs (@).
                        // Those lines are not to be printed, but instead
                        // signify that the print-out should pause (with a brief
                        // message, such as "...press enter...") and wait for
                        // the user to press the enter key. (The line must have
                        // exactly 80 at signs or else it's just another line to
                        // be printed.)
                        if (line.matches("@{80}")) {
                            pause();
                        } else {
                            System.out.println(line);
                        } // end inner if
                    } // end inner for
                } // end if
            } // end for
        } // end if
    }// end of method

    /**
     * A private inner class to hold the data for a single text item.
     * 
     * @author Lingda Cai (A00372181)
     * @version 1.0
     *
     */
    private class Item {
        // the title of each item
        private String title;
        // using a List to hold the content of each item
        private List<String> lines;

        // default constructor
        public Item() {
            lines = new ArrayList<String>();
        }// end of default constructor

        // get the current title
        public String getTitle() {
            return title;
        }// end of get

        // set the title from text file
        public void setTitle(String title) {
            this.title = title;
        }// end of setter

        // only provide a way to get contents,no setter in this class
        public List<String> getLines() {
            return lines;
        }// end of getter

        // in order to be easy to debug, override the <code>toString</code>
        @Override
        public String toString() {
            return "Item [title=" + title + ", lines=" + lines + "]";
        }// end of toString

    }

    // during reach a line with 80 @, print a puase to user
    private void pause() {
        Scanner kbd = new Scanner(System.in);
        System.out.println();
        System.out.println("...press enter...");
        kbd.nextLine();
        System.out.println();
    }// end of pause
}

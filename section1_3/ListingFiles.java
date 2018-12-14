package section1_3;

/*
1.3.43 Listing files. A folder is a list of files and folders. Write a program that takes the
name of a folder as a command-line argument and prints out all of the files contained
in that folder, with the contents of each folder recursively listed (indented) under that
folder’s name. Hint : Use a queue, and see java.io.File.
 */

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListingFiles {

    private String indentation = "";

    public void listFiles(String path) {
        File file = new File(path); 
        String[] list = file.list();
        Arrays.sort(list);
        for (String s : list) {
           if (s.startsWith(".")) continue;

           if (new File(path + "/" + s).isDirectory()) {
               System.out.println(indentation  + "DIR: "+ path + "/" + s);
               indentation += "--";
               listFiles(path + "/" +s);
               indentation = indentation.substring(0, indentation.length()-2);
           } else {
               System.out.println(indentation + "|" + s);
           }
        }

    }



    public static void main(String[] args) {
        String pathString = "/Users/Tomvdb/Java";
        ListingFiles list = new ListingFiles();

        list.listFiles(pathString);
    }
}

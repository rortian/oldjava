/*
 * Frederick F. Chew, The Java/C++ Cross Reference Handbook (Book/CD-ROM)
 * Published By HP Press/Prentice-Hall
 * Copyright (C) 1997 Hewlett-Packard Company
 * All Rights Reserved. ISBN 0-13-848318-3
 *
 * Permission to use, copy, modify, and distribute this 
 * software and its documentation for NON-COMMERCIAL purposes
 * and without fee is hereby granted provided that this 
 * copyright notice appears in all copies. 
 * 
 * THE AUTHOR AND PUBLISHER MAKE NO REPRESENTATIONS OR 
 * WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. THE AUTHOR
 * AND PUBLISHER SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED 
 * BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING 
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */
 
/**
 * @version 1.00 01 May 1997
 * @author Frederick F. Chew
 */

import java.awt.*;
import java.io.*;

public class SortFileDemo {

    static void Partition(String [] str, int left, int right) {
    int index1;
    int index2;
    String curr_str = null;
    String temp_str = null;

    index1 = left;
    index2 = right;

    curr_str = str[(left+right)/2];

    do {
       while ( (str[index1].compareTo(curr_str) < 0) && (index1 < right) ) index1++;
       while ( (curr_str.compareTo(str[index2]) < 0) && (index2 > left)  ) index2--;

       if (index1 < index2) {
		   temp_str    = str[index1];
		   str[index1] = str[index2];
		   str[index2] = temp_str;
		   index1++;
		   index2--;
	       }
       else
       if (index1 == index2) {
		   index1++;
		   index2--;
	       }

       } while (index1 <= index2);

    if (left < index2)  Partition(str, left,  index2);
    if (index1 < right) Partition(str, index1, right);
    }

    static void Quicksort(String [] str, int num_recs) {
    Partition(str, 0, num_recs-1);
    }

    static void ReadAndSortFile(String source_file, String target_file) throws IOException {
    String line = null;

    int count = 0;
    int index;

    RandomAccessFile ins = new RandomAccessFile(source_file, "r");
    PrintStream ps = new PrintStream(new FileOutputStream(target_file));

    while ((line = ins.readLine()) != null) {
       count++;
       }

    String record[] = new String[count];

    ins.seek(0);

    index = 0;

    while ((line = ins.readLine()) != null) {
       record[index++] = line;
       }

    Quicksort(record, count);

    for (index = 0; index < count; index++)
       ps.println(record[index]);

    ins.close();
    ps.close();
    }

    public static void main(String args[]) {

    if (args.length != 2) {
       System.err.println("Usage:  java SortFileDemo <source file> <target file>");
       Prompt();
       return;
       }
    try {
        ReadAndSortFile(args[0], args[1]);
        }
    catch(IOException err) {
        System.err.println(err.toString());
        Prompt();
        System.exit(1);
        }
    Prompt();
    }

    static void Prompt() {
    System.out.println("(press Enter to exit)");
    try {
        System.in.read();
        }
    catch (IOException e) {
        return;
        }
    }

}

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

/**
 * Note:  This program was built from the JDK version 1.02
 *        and has not been customized to work on version 1.1
 *
 *        The precision of floating point numbers has undergone
 *        change in version 1.1
 */

import java.awt.*;
import java.io.*;

public class IOS {

public IOS() {
radix = DEC;
width = 0;
fillchar = ' ';
justify_right = RIGHT;
precision = 6;
upper_case = false;
show_sign = false;
internal_pad = false;
fixed_format = FIXED;
}

public IOS(int base, int size, char fill, boolean just, int significant, boolean cap,
           boolean sign, boolean pad, boolean format) {
if ((base < 0) || (base > 2))
   base = DEC;
if (size < 0)
   size = 0;
radix = base;
width = size;
fillchar = fill;
justify_right = just;
precision = significant;
upper_case = cap;
show_sign = sign;
internal_pad = pad;
fixed_format = format;
}

// public mutator methods for IOS attributes

public int setRadix(int base) {
int org_radix = radix;
if ((base < 0) || (base > 2))
   base = DEC;
radix = base;
return org_radix;
}

public int setWidth(int size) {
int org_width = width;
if (size < 0)
   size = 0;
width = size;
return org_width;
}

public char setFill(char fill) {
char org_fillchar = fillchar;
fillchar = fill;
return org_fillchar;
}

public boolean setJustify(boolean just) {
boolean org_just = justify_right;
justify_right = just;
return org_just;
}

public int setPrecision(int prec) {
int org_precision = precision;
precision = prec;
return org_precision;
}

public boolean setUpperCase(boolean cap) {
boolean org_upper_case = upper_case;
upper_case = cap;
return org_upper_case;
}

public boolean setShowSign(boolean sign) {
boolean org_show_sign = show_sign;
show_sign = sign;
return org_show_sign;
}

public boolean setInternalPad(boolean pad) {
boolean org_internal_pad = pad;
internal_pad = pad;
return org_internal_pad;
}

public boolean setNumericalFormat(boolean format) {
boolean org_fixed_format = fixed_format;
fixed_format = format;
return org_fixed_format;
}

void showState(PrintStream ps) {
String radix_str = "";
String width_str = "";
String just_str = "";
String fillchar_str = "";
String format_str = "";

switch (radix) {
   case DEC: radix_str += "Decimal";
             break;
   case OCT: radix_str += "Octal";
             break;
   case HEX: radix_str += "Hexadecimal";
             break;
   }

if (width == 0)
   width_str += "Default";
else
   width_str += width;

if (justify_right)
   just_str += "RIGHT";
else
   just_str += "LEFT";

if (fillchar == ' ')
   fillchar_str += "Space";
else
   fillchar_str += fillchar;

if (fixed_format)
   format_str += "Fixed";
else
   format_str += "Scientific";

ps.println();
ps.println("Radix = "+radix_str);
ps.println("Width = "+width_str);
ps.println("Fill Character = "+fillchar_str);
ps.println("Justification = "+just_str);
ps.println("Precision = "+precision);
ps.println("Upper case = "+upper_case);
ps.println("Show sign = "+show_sign);
ps.println("Internal pad = "+internal_pad);
ps.println("Numerical format = "+format_str);
ps.println();
}

// public methods for print() and println()

public void println(PrintStream ps, char aChar) {
String newStr = "";
newStr += aChar;
print(ps, newStr);
ps.println();
}

public void println(PrintStream ps, char [] aCharArray) {
String newStr = "";
newStr += aCharArray;
print(ps, newStr);
ps.println();
}

public void println(PrintStream ps, int anInt) {
println(ps, (long)anInt);
}

public void println(PrintStream ps, long aLong) {
print(ps, aLong);
ps.println();
}


public void println(PrintStream ps, float aFlt) {
println(ps, (double) aFlt);
}

public void println(PrintStream ps, double aDbl) {
print(ps, aDbl);
ps.println();
}

public void println(PrintStream ps, String aStr) {
print(ps, aStr);
ps.println();
}

public void print(PrintStream ps, char aChar) {
String newStr = "";
newStr += aChar;
print(ps, newStr);
}

public void print(PrintStream ps, char [] aCharArray) {
String newStr = "";
newStr += aCharArray;
print(ps, newStr);
}

public void print(PrintStream ps, int anInt) {
print(ps, (long)anInt);
}

public void print(PrintStream ps, long aLong) {
String newStr = "";
if ((show_sign) && (aLong > 0))
   newStr += "+";
switch (radix) {
   case DEC: newStr += aLong;
             break;
   case OCT: newStr += "0"  + newBase(aLong, 3, 7, "01234567");
             break;
   case HEX: if (upper_case)
                newStr += "0X" + newBase(aLong, 4, 15, "0123456789ABCDEF");
             else
                newStr += "0x" + newBase(aLong, 4, 15, "0123456789abcdef");
             break;
   }
print(ps, newStr);
}

public void print(PrintStream ps, float aFlt) {
print(ps, (double)aFlt);
}

public void print(PrintStream ps, double aDbl) {
String newStr = "";
String tmpStr = "";
if (fixed_format)
   tmpStr += prepareFixedFormat(aDbl);
else
   tmpStr += prepareScientificFormat(aDbl);
newStr += padString(tmpStr, aDbl);
print(ps, newStr);
}

public void print(PrintStream ps, String aStr) {
ps.print(prepareField(aStr));
ps.flush();
}

// private helper methods

private void drawRuler(PrintStream ps) {
   String interval = new String("1234567890");
   String ruler = "";
   for (int index = 0; index < 6; index++)
      ruler += interval;
   ps.println();
   ps.println(ruler);
   ps.println();
}

private String newBase(long value, int no_of_bits, int one_bits, String digits) {
String result = "";
if (value == 0) {
   result += "0";
   }
else {
   while (value != 0) {
      result = digits.charAt((int)(value & one_bits)) + result;
      value = value >>> no_of_bits;
      }
   }
return result;
}

private String prepareField(String aStr) {
if (width == 0) {
   return aStr;
   }

if (width <= aStr.length()) {
   return aStr;
   }

String newStr = "";
int delta = width - aStr.length();
if (justify_right) {       // RIGHT
   for (int index = 0; index < delta; index++)
      newStr += fillchar;
   newStr += aStr;
   }
else {                     // LEFT
   StringBuffer sbuffer = new StringBuffer(aStr);
   char [] cbuffer = new char[delta];
   sbuffer.append(cbuffer);
   for (int index = 0; index < delta; index++)
      sbuffer.setCharAt(aStr.length()+index, fillchar);
   newStr += new String(sbuffer);
   }

return newStr;
}

private String eNotation(char sign, long exponent) {
String expStr = new Long(exponent).toString();
int leading_zeros = 3 - (expStr.length());
String result = "";
result += (upper_case)?"E":"e";
result += sign;
for (int index = 0; index < leading_zeros; index++)
   result += "0";
result += expStr;
return result;
}

private String moveDecimalLeft(long aLong) {
String result = "";
String str = "";
str += aLong;
result += str.substring(0, 1) + "." + str.substring(1, str.length());
return result;
}

private String moveDecimalRight(String str) {
char ch;
long pwr = 0;
int index2 = 0;
String result = "";
String newStr = "";

for (int index1 = 0; index1 < str.length(); index1++) {
   if ((ch = str.charAt(index1)) == '0')
      pwr++;
   else
      newStr += ch;
   }

pwr++;

if ((newStr.substring(1, newStr.length())).length() != 0)
   result += newStr.substring(0, 1) + "." + newStr.substring(1, newStr.length()) + eNotation('-', pwr);
else
   result += newStr.substring(0, 1) + "." + "0" + eNotation('-', pwr);

return result;
}

private boolean alreadyScientific(String str) {
boolean flag = false;
for(int index=0; index < str.length(); index++) {
   if ( (str.charAt(index) == 'e') || (str.charAt(index) == 'E') )
      flag = true;
   }
return flag;
}

private String improveDefault(String str) {
boolean decimal_pt = false;
int e_index = 0;
for (int index = 0; index < str.length(); index++) {
    if (str.charAt(index) == '.')
       decimal_pt = true;
    else
    if ( (str.charAt(index) == 'e') || (str.charAt(index) == 'E') )
       e_index = index;
    }

String result = "";

if (decimal_pt) {
   result += str.substring(0, e_index) + (upper_case?"E":"e") + str.substring(e_index+1, str.length());
   }
else {
   result += str.substring(0, e_index) + ".0" + (upper_case?"E":"e") + str.substring(e_index+1, str.length());
   }

return result;
}

private String padString(String str, double num) {
int lgth = width - str.length();

if (((show_sign) || (num < 0.0)) && (lgth > 0) && (internal_pad)) {
   String result = "";
   result += str.substring(0, 1);
   for (int index = 0; index < lgth; index++) result += fillchar;
   result += str.substring(1, str.length());
   return result;
   }

return str;
}

private String prepareScientificFormat(double aDbl) {
String result = "";

// The double may already be in scientific format

String dblStr = "";
dblStr += aDbl;

if (alreadyScientific(dblStr)) {
   String newStr = "";
   if ((show_sign) && (aDbl > 0))
      newStr += "+";
   newStr += improveDefault(dblStr);
   return newStr;
   }

// Include the sign if necessary

if (aDbl < 0.0) {
    result += "-";
    aDbl = -1 * aDbl;
    }
else
if (show_sign)
    result += "+";

// Find the whole part and the fractional part

long whole = (long) aDbl;
double fraction = aDbl - whole;

String wholeStr = "";
wholeStr += whole;

if (wholeStr.length() >= precision) {
   if (fraction >= 0.5) whole++;
   long pwr = wholeStr.length() - 1;
   result += moveDecimalLeft(whole) + eNotation('+', pwr);
   }
else {
   int frac_prec = precision - wholeStr.length();
   if (fraction == 0.0) {
      long pwr = wholeStr.length() - 1;
      result += moveDecimalLeft(whole) + ((whole==0)?"0":"") + eNotation('+', pwr);
      }
   else
      result += determineFraction(frac_prec, fraction, whole);
   }

return result;
}

private String determineFraction(int prec, double aDbl, long org_whole) {

String result = "";
String aDblStr = "";
aDblStr += aDbl;
int lgth = aDblStr.length()-2;
String frac_str = "";

if (prec < lgth) {
   double newDbl = aDbl;
   for (int index = 0; index < prec; index++)
      newDbl *= 10.0;
   long sub_whole = (long)newDbl;
   double sub_fraction = newDbl - sub_whole;
   if (sub_fraction >= 0.5) sub_whole++;
   frac_str += sub_whole;
   }
else
  frac_str += aDblStr.substring(2, aDblStr.length());

String orgWholeStr = "";
orgWholeStr += org_whole;

if (org_whole > 0) {
   long pwr = orgWholeStr.length() - 1;
   result += moveDecimalLeft(org_whole) + frac_str + eNotation('+', pwr);
   }
else {
   result += moveDecimalRight(frac_str);
   }

return result;
}

private String prepareFixedFormat(double aDbl) {
String result = "";

// The double may already be in scientific format

String dblStr = "";
dblStr += aDbl;

if (alreadyScientific(dblStr)) {
   String newStr = "";
   if ((show_sign) && (aDbl > 0))
      newStr += "+";
   newStr += improveDefault(dblStr);
   return newStr;
   }

// Include the sign if necessary

if (aDbl < 0.0) {
    result += "-";
    aDbl = -1 * aDbl;
    }
else
if (show_sign)
    result += "+";

// Find the whole part and the fractional part

long whole = (long) aDbl;
double fraction = aDbl - whole;

String wholeStr = "";
wholeStr += whole;

if (wholeStr.length() >= precision) {
   if (fraction >= 0.5) whole++;
   result += whole;
   }
else {
   int frac_prec = precision - wholeStr.length();
   if (fraction == 0.0)
      result += whole;
   else
      result += whole + "." + findFraction(frac_prec, fraction);
   }

return result;
}

private String findFraction(int prec, double aDbl) {

String result = "";
String aDblStr = "";
aDblStr += aDbl;
int lgth = aDblStr.length()-2;

if (prec < lgth) {
   double newDbl = aDbl;
   for (int index = 0; index < prec; index++)
      newDbl *= 10.0;
   long sub_whole = (long)newDbl;
   double sub_fraction = newDbl - sub_whole;
   if (sub_fraction >= 0.5) sub_whole++;
   result += sub_whole;
   }
else
   result += aDblStr.substring(2, aDblStr.length());

return result;
}

// public final fields

public static final int DEC = 0;
public static final int OCT = 1;
public static final int HEX = 2;
public static final boolean RIGHT = true;
public static final boolean LEFT  = false;
public static final boolean FIXED = true;
public static final boolean SCIENTIFIC  = false;

// private variable fields

private int  precision;
private int  radix;
private int  width;
private char fillchar;
private boolean justify_right;
private boolean upper_case;
private boolean show_sign;
private boolean internal_pad;
private boolean fixed_format;

public static void main(String args[]) throws IOException {

double [] dbl1 = {
                 0.0, 0.1, 0.01, 0.001, 0.0001, 0.00001,
                 0.000001, 0.0000001, 0.00000001, 0.000000001, 0.0000000001, 0.00000000001
                 };

double [] dbl2 = {
                 0.1, 0.12, 0.123, 0.1234, 0.12345, 0.123456, 0.1234567, 0.12345678, 0.123456789,
                 0.1234567891, 0.12345678912, 0.123456789123, 0.1234567891234, 0.12345678912345
                 };

double [] dbl3 = {
                 0.123456, 1.123456, 12.123456, 123.123456, 1234.123456, 12345.123456, 123456.123456,
                 12345.6123456, 1234.56123456, 123.456123456, 12.3456123456, 1.23456123456,
                 1234561.23456, 12345612.3456, 123456123.456, 1234561234.56, 12345612345.6, 1234567.123456,
                 12345678.123456, 123456789.123456, 1234567891.123456, 12345678912.123456, 123456789123.123456,
                 1234567891234.123456
                 };

double [] dbl4 = {
                 1.1, 12.12, 123.123, 1234.1234, 12345.12345, 123456.123456, 1234567.1234567, 12345678.12345678,
                 123456789.123456789, 1234567891.1234567891, 12345678912.12345678912, 123456789123.123456789123,
                 1234567891234.1234567891234, 12345678912345.12345678912345, 123456789123456.123456789123456,
                 1234567891234567.1234567891234567, 12345678912345678.12345678912345678, 123456789123456789.123456789123456789
                 };


// Test01

PrintStream prs1 = new PrintStream(new FileOutputStream("OS1A.TXT"));
IOS os1A = new IOS();

String bird = "penguin";
String fish = "rock cod";
String tree = "maple";

os1A.setFill('~');
os1A.setWidth(12);
os1A.println(prs1, bird);
os1A.println(prs1, fish);
os1A.setWidth(0);
os1A.println(prs1, tree);

prs1.close();

// Test02

PrintStream prs2 = new PrintStream(new FileOutputStream("OS2A.TXT"));
IOS os2A = new IOS();

double num1 = 17.7875678;
os2A.setPrecision(8);
os2A.println(prs2, num1);

prs2.close();

// Test03

PrintStream prs3 = new PrintStream(new FileOutputStream("OS3A.TXT"));
IOS os3A = new IOS();

int num2 = 160;

os3A.setRadix(IOS.OCT);
os3A.print(prs3, "Octal = ");
os3A.println(prs3, num2);
os3A.setRadix(IOS.HEX);
os3A.print(prs3, "Hexadecimal = ");
os3A.println(prs3, num2);
os3A.setUpperCase(true);
os3A.print(prs3, "Hexadecimal = ");
os3A.println(prs3, num2);
os3A.setRadix(IOS.DEC);
os3A.print(prs3, "Decimal = ");
os3A.println(prs3, num2);

prs3.close();

// Test04

PrintStream prs4 = new PrintStream(new FileOutputStream("OS4A.TXT"));
IOS os4A = new IOS();

String feline = "bob cat";
long   lnum   = 757905;
double dnum   = 2345070.00915756;

os4A.setJustify(IOS.LEFT);
os4A.setFill('#');
os4A.setWidth(12);
os4A.setPrecision(14);
os4A.println(prs4, feline);
os4A.println(prs4, lnum);
os4A.println(prs4, dnum);

os4A.setJustify(IOS.RIGHT);
os4A.setFill('*');
os4A.setWidth(12);
os4A.setPrecision(14);
os4A.println(prs4, feline);
os4A.println(prs4, lnum);
os4A.println(prs4, dnum);

prs4.close();

// Test05

PrintStream prs5 = new PrintStream(new FileOutputStream("OS5A.TXT"));
IOS os5A = new IOS();

os5A.setJustify(IOS.LEFT);
os5A.setFill('*');
os5A.setWidth(12);
os5A.println(prs5, bird);
os5A.println(prs5, fish);
os5A.setJustify(IOS.RIGHT);
os5A.println(prs5, tree);

prs5.close();

// Test06

PrintStream prs6 = new PrintStream(new FileOutputStream("OS6A.TXT"));
IOS os6A = new IOS();

int   int1 = 34950;
int   int2 = -int1;
float flt1 = 17.5829f;
float flt2 = -flt1;

os6A.setInternalPad(true);
os6A.setFill('^');
os6A.setWidth(16);
os6A.println(prs6, int1);
os6A.println(prs6, int2);
os6A.println(prs6, flt1);
os6A.println(prs6, flt2);
os6A.setInternalPad(false);
os6A.println(prs6, flt2);

prs6.close();

// Test07

PrintStream prs7 = new PrintStream(new FileOutputStream("OS7A.TXT"));
IOS os7A = new IOS();

long   long1 = 875090406;
double doub1 = 395.0;
double doub2 = 7693.8356;
double doub3 = 3409.958;

os7A.println(prs7, doub1);
os7A.setShowSign(true);
os7A.println(prs7, doub1);
os7A.setNumericalFormat(IOS.SCIENTIFIC);
os7A.println(prs7, long1);
os7A.println(prs7, doub2);
os7A.println(prs7, doub3);
os7A.setShowSign(false);
os7A.setNumericalFormat(IOS.FIXED);
os7A.println(prs7, long1);
os7A.println(prs7, doub1);
os7A.println(prs7, doub2);
os7A.println(prs7, doub3);

prs7.close();

// Test08

PrintStream prs8 = new PrintStream(new FileOutputStream("OS8A.TXT"));
IOS os8A = new IOS();

os8A.setPrecision(20);
os8A.setWidth(30);
os8A.setJustify(IOS.RIGHT);
os8A.drawRuler(prs8);

os8A.println(prs8, "Default System.out.println() - Positive");
for(int index = 0; index < dbl1.length; index++)
   prs8.println(dbl1[index]);

os8A.println(prs8, "Default System.out.println() - Negative");
for(int index = 0; index < dbl1.length; index++)
   prs8.println(-dbl1[index]);

os8A.println(prs8, "Fixed Format - Positive");
for(int index = 0; index < dbl1.length; index++)
   os8A.println(prs8, dbl1[index]);

os8A.println(prs8, "Fixed Format - Negative");
for(int index = 0; index < dbl1.length; index++)
   os8A.println(prs8, -dbl1[index]);

os8A.setNumericalFormat(IOS.SCIENTIFIC);

os8A.println(prs8, "Scientific Format - Positive");
for(int index = 0; index < dbl1.length; index++)
   os8A.println(prs8, dbl1[index]);

os8A.println(prs8, "Scientific Format - Negative");
for(int index = 0; index < dbl1.length; index++)
   os8A.println(prs8, -dbl1[index]);

prs8.close();

// Test09

PrintStream prs9 = new PrintStream(new FileOutputStream("OS9A.TXT"));
IOS os9A = new IOS();

os9A.setPrecision(20);
os9A.setWidth(30);
os9A.setJustify(IOS.RIGHT);
os9A.drawRuler(prs9);

os9A.println(prs9, "Default System.out.println() - Positive");
for(int index = 0; index < dbl2.length; index++)
   prs9.println(dbl2[index]);

os9A.println(prs9, "Default System.out.println() - Negative");
for(int index = 0; index < dbl2.length; index++)
   prs9.println(-dbl2[index]);

os9A.println(prs9, "Fixed Format - Positive");
for(int index = 0; index < dbl2.length; index++)
   os9A.println(prs9, dbl2[index]);

os9A.println(prs9, "Fixed Format - Negative");
for(int index = 0; index < dbl2.length; index++)
   os9A.println(prs9, -dbl2[index]);

os9A.setNumericalFormat(IOS.SCIENTIFIC);

os9A.println(prs9, "Scientific Format - Positive");
for(int index = 0; index < dbl2.length; index++)
   os9A.println(prs9, dbl2[index]);

os9A.println(prs9, "Scientific Format - Negative");
for(int index = 0; index < dbl2.length; index++)
   os9A.println(prs9, -dbl2[index]);

prs9.close();

// Test10

PrintStream prs10 = new PrintStream(new FileOutputStream("OS10A.TXT"));
IOS os10A = new IOS();

os10A.setPrecision(20);
os10A.setWidth(30);
os10A.setJustify(IOS.RIGHT);
os10A.drawRuler(prs10);

os10A.println(prs10, "Default System.out.println() - Positive");
for(int index = 0; index < dbl3.length; index++)
   prs10.println(dbl3[index]);

os10A.println(prs10, "Default System.out.println() - Negative");
for(int index = 0; index < dbl3.length; index++)
   prs10.println(-dbl3[index]);

os10A.println(prs10, "Fixed Format - Positive");
for(int index = 0; index < dbl3.length; index++)
   os10A.println(prs10, dbl3[index]);

os10A.println(prs10, "Fixed Format - Negative");
for(int index = 0; index < dbl3.length; index++)
   os10A.println(prs10, -dbl3[index]);

os10A.setNumericalFormat(IOS.SCIENTIFIC);

os10A.println(prs10, "Scientific Format - Positive");
for(int index = 0; index < dbl3.length; index++)
   os10A.println(prs10, dbl3[index]);

os10A.println(prs10, "Scientific Format - Negative");
for(int index = 0; index < dbl3.length; index++)
   os10A.println(prs10, -dbl3[index]);

prs10.close();

// Test11

PrintStream prs11 = new PrintStream(new FileOutputStream("OS11A.TXT"));
IOS os11A = new IOS();

os11A.setPrecision(20);
os11A.setWidth(30);
os11A.setJustify(IOS.RIGHT);
os11A.drawRuler(prs11);

os11A.println(prs11, "Default System.out.println() - Positive");
for(int index = 0; index < dbl4.length; index++)
   prs11.println(dbl4[index]);

os11A.println(prs11, "Default System.out.println() - Negative");
for(int index = 0; index < dbl4.length; index++)
   prs11.println(-dbl4[index]);

os11A.println(prs11, "Fixed Format - Positive");
for(int index = 0; index < dbl4.length; index++)
   os11A.println(prs11, dbl4[index]);

os11A.println(prs11, "Fixed Format - Negative");
for(int index = 0; index < dbl4.length; index++)
   os11A.println(prs11, -dbl4[index]);

os11A.setNumericalFormat(IOS.SCIENTIFIC);

os11A.println(prs11, "Scientific Format - Positive");
for(int index = 0; index < dbl4.length; index++)
   os11A.println(prs11, dbl4[index]);

os11A.println(prs11, "Scientific Format - Negative");
for(int index = 0; index < dbl4.length; index++)
   os11A.println(prs11, -dbl4[index]);

prs11.close();

System.out.println("(press Enter to exit)");
try {
    System.in.read();
    }
catch (IOException e) {
    return;
    }
}

}

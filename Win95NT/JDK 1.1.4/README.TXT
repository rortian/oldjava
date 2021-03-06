                             README

                    Java(tm) Development Kit
                         JDK(tm) 1.1.4

-----------------------------------------------------------------------
CONTENTS


  Overview of Java
    - Introduction
    - Purpose
    - Version Compatibility
    - Bug Fixes
    - What the JDK Contains
    - Where to Find More Information
    - Submitting Comments
    - Reporting Bugs and Requesting Features
    - JavaBeans(tm) and the Beans Development Kit

  Installing and Running Java
    - Installation Notes
    - Windows
      - Running Java Tools in Microsoft Windows
      - Microsoft Windows PATH and CLASSPATH
      - Microsoft Windows Installation Troubleshooting
    - Solaris
      - Running Java Tools in Solaris
      - Solaris PATH and CLASSPATH
      - Solaris Installation Troubleshooting
    - Running Applets with the AppletViewer
    - Debugging Programs with the Java Debugger


=======================================================================
                           OVERVIEW OF JAVA
=======================================================================

-----------------------------------------------------------------------
INTRODUCTION
-----------------------------------------------------------------------
Thank you for downloading the JDK(tm) 1.1.4 release.

This is version 1.1.4 of the Java Development Kit, also known as 
JDK 1.1.4.  The JDK is a development environment for writing 
applets and applications that conform to the Java 1.1 Core API.  
Its compiler and other tools are run from a shell and have no
GUI interface. This version includes improvements in functionality, 
performance, and quality over JDK 1.0.2, and includes 
bug fixes since JDK 1.1.3.

JDK 1.1.4 is a bug-fix release.  Changes made to the JDK since 
the first 1.1 beta release are in the file named CHANGES.

Because there are no API changes in bug-fix releases, we continue 
to refer to this platform as the Java Platform 1.1 (rather than 1.1.4).   
While bugs have been fixed in 1.1.4, the platform hasn't changed.

The Java Platform 1.1 offers new capabilities:  Internationalization, 
signed applets, JAR file format, AWT (window toolkit) enhancements, 
JavaBeans(tm) component model, networking enhancements, Math package for 
large numbers, Remote Method Invocation (RMI), Reflection, database 
connectivity (JDBC), new Java Native Interface, Object Serialization, 
Inner Classes, and performance enhancements.

For further description of these features, see the "New Feature 
Summary" in the JDK documentation.

As part of our ongoing effort to improve the quality of the JDK,
we will continue to fix bugs and develop new features.
In order to help us prioritize our bug-fixing effort, please submit
any bugs you find as soon as possible, using the procedure described 
in the "Reporting Bugs" section below.

The JDK is a product of Sun Microsystems, Inc.  
JavaSoft, an operating company of Sun, develops the JDK.


-----------------------------------------------------------------------
PURPOSE
-----------------------------------------------------------------------
The JDK allows you to:

      - Develop applets that will run in browsers supporting the
        Java Platform 1.1, such as HotJava version 1.0, and future 
        versions of Netscape Navigator and Microsoft Internet Explorer.

      - Develop Java applications.  Applications run without the
        need for a browser. (HotJava itself is a Java application.)


-----------------------------------------------------------------------
VERSION COMPATIBILITY
-----------------------------------------------------------------------
In general, any applet or application that ran in JDK 1.0.2 should
run correctly in JDK 1.1.4.  A failure to do so is a bug, except 
for a small number of cases where compatibility has had to be
broken to close potential security holes, or fix implementation 
or design bugs.  

Of course, applets that depend on any new 1.1 APIs will not work on 
any browsers that support only 1.0.2, such as Internet Explorer 3.0, 
Netscape 3.0, and the alpha and pre-beta1 versions of the HotJava 
browser.  However, in general, applets relying only on APIs defined 
in 1.0.2 (but compiled with the JDK 1.1 compiler) will run on 1.0.2 
browsers.  This "downwards" compatibility has not been extensively 
tested and cannot be guaranteed. 

For more details, see the document on compatibility at:

   http://java.sun.com/products/jdk/1.1/compatibility.html

If you find any such incompatibilities that are not listed on the
Compatibility web page, please report them to us as noted below
under "Reporting Bugs," and mention that they are compatibility
bugs.  Compatibility is critically important to us, and a cornerstone
of the Java promise: Write Once, Run Anywhere(tm).


-----------------------------------------------------------------------
BUG FIXES
-----------------------------------------------------------------------
As with any release, we will continue vigorously testing and 
debugging the JDK.  If we uncover any important bugs, we will 
post them on the JavaSoft web site at:

   http://java.sun.com/products/jdk/1.1/bugs.html

As always, your comments and bug reports are important to making 
future releases successful.  We will use your feedback to help plan 
future releases.  Please report bugs, request features and submit 
comments using the procedure noted below in the sections "Submitting 
Comments" and "Reporting Bugs and Requesting Features". 


-----------------------------------------------------------------------
WHAT THE JDK CONTAINS
-----------------------------------------------------------------------

JAVA RUNTIME ----------------------------------------------------------

    - Java Core Classes (classes.zip)
            DO NOT UNZIP THIS FILE!  It must remain zipped for the
            compiler and interpreter to access the class files
            within it properly.  This file contains all of the
            the compiled .class files for the JDK.

JAVA SOURCE FILES -----------------------------------------------------

    - Java Source Files for Public Classes 
            (src.zip file or src directory)
            This is the set of source files used to create the
            classes included in the Java Core Classes classes.zip 
            file (above).  These source files are provided for 
            information purposes only, to help developers learn
            and use Java.  They do not include the private 
            java.* classes or the sun.* classes, and therefore 
            cannot be compiled into a complete classes.zip file.

            Do not modify these classes;  instead, create subclasses
            and override where you need to. These classes are 
            documented in the API Reference documentation, which is 
            generated by javadoc.  

            How this is installed depends on the platform:

             - On Windows, these are automatically unzipped for you
               during installation.

             - On Solaris, you must unzip the src.zip file yourself.
               You can get a free copy of the correct version
               of unzip in source form (which you must compile) from:

               http://www.cdrom.com/pub/infozip/zlib/

               or 

               ftp://ftp.cdrom.com/pub/infozip/zlib/

	       or

	       ftp://ftp.uu.net/pub/archiving/zip/UNIX/SUN/
              
JAVA TOOLS ------------------------------------------------------------

    - Java Compiler (javac)
            Compiles programs written in the Java programming language
            into bytecodes.

    - Java Interpreter (java)
            Executes Java bytecodes.  In other words, it runs 
            programs written in the Java programming language.

    - Jave Runtime Interpreter (jre)
	    Similar to the Java Interpreter (java), but intended for 
	    end users who do not require all the development-related 
            options available with the java tool.

    - Java AppletViewer (appletviewer)
            Used for testing and running applets.

    - Java Debugger (jdb)
            Helps you find bugs in Java programs.

    - Class File Disassembler (javap)
            Disassembles compiled Java files and prints out a
            representation of the Java bytecodes.

    - Java Documentation Generator (javadoc)
            Parses the declarations and documentation comments in
            a set of Java source files and produces a set of HTML pages
            describing the public and protected classes, interfaces,
            constructors, methods, and fields. Also produces
            a class hierarchy and an index of all members.

    - C Header and Stub File Generator (javah)
            For attaching native methods to Java code.

    - Java Archive Tool (jar)
            Combines many Java class files and other resources
            into a single jar file.

    - Digital Signing Tool (javakey)
            Manages entities, including their keys, certificates,
            and the trust associated with them.

    - Native-To-ASCII Converter (native2ascii)
            Converts a native encoding file to an ascii
            file that includes the \udddd Unicode notation.

    - Java RMI Stub Converter (rmic)
            Generates objects from the names of compiled Java classes
            that contain remote object implementations.

    - Java Remote Object Registry (rmiregistry)
            Creates and starts a remote object registry on the
            specified port of the current host.

    - Serial Version Command (serialver)
            Returns the serialVersionUID for one or more classes
            in a form suitable for copying into an evolving class.

    - AWT 1.1 Conversion Tool (updateAWT)
            Included with the JDK AWT documentation,
            rather than in the bin directory.
            Updates deprecated 1.0 AWT names to new 1.1 AWT
            names (for Sun Solaris and UNIX systems, or Windows
            systems with the MKS toolkit).

    - Various C libraries and include files

JAVA DOCUMENTATION AND DEMOS ------------------------------------------

    - demo directory
            awt-1.1         AWT demos
            i18n            Internationalization demos

            Animator        General-purpose animator
            ArcTest         Test arc drawing and filling
            BarChart        Simple bar-chart applet
            Blink           Blinking, multicolored text
            CardTest        Test card layout manager
            Clock           Analog clock
            DitherTest      Test image dithering
            DrawTest        Draw points and lines
            Fractal         Fractal figures
            GraphLayout     Graph layout by iterated relaxation
            GraphicsTest    Test graphics operations
            ImageMap        Live-feedback image map
            JumpingBox      Catch the jumping box
            MoleculeViewer  Three-dimensional chemical model viewer
            NervousText     Nervous text
            SimpleGraph     Draw a simple graph
            SortDemo        Animated sorting algorithms
            SpreadSheet     Simple spreadsheet
            TicTacToe       Tic-tac-toe game
            WireFrame       Three-dimensional wire-frame model viewer

      RMI demos are available in the separately-downloadable 
      JDK documentation.  See the entry "Demonstration Applets
      and Applications" in the JDK documentation table of 
      contents for access.

    - README
            This file you are currently reading

    - CHANGES
            Changes made in the beta and final JDK releases

    - COPYRIGHT
            Copyright notice for the JDK software

    - LICENSE
            License agreement for the JDK software

NOTE: The JDK does NOT include a Web browser.  To obtain the HotJava(tm)
Browser, see the HotJava Browser web page:

      http://java.sun.com/products/hotjava/


-----------------------------------------------------------------------
WHERE TO FIND MORE INFORMATION
-----------------------------------------------------------------------
This README file and the accompanying CHANGES, LICENSE, COPYRIGHT files,
demo directory, and Java source code (src.zip) are the only
"documentation" included in this JDK software bundle.

The rest of the documentation is in a separately-downloaded bundle
known as the "JDK 1.1.4 Documentation," and is available from the same
download page where you got this software:

          http://java.sun.com/products/jdk/1.1/

This JDK 1.1.4 Documentation includes the following information:

 - JDK Release Notes
 - JDK API Reference
 - JDK Guide to New Features
 - JDK Demos
 - JDK Tools Documentation
 - Java Tutorial


-----------------------------------------------------------------------
SUBMITTING COMMENTS
-----------------------------------------------------------------------
We are very interested in receiving your comments and suggestions
as early as possible.  

If you have a specific feature request or bug to report, please 
refer to the next section for how to submit it. Send other comments 
and informal suggestions directly to us at our JavaSoft email addresses 
at Sun, which are listed at:

     http://java.sun.com/mail/

Here is a summary of what is on this web page:

 - Technical Help - Sun does not provide free technical help.
   See the above web page for some places to obtain help with your
   programming problems.

 - JavaSoft Email Addresses - The following are our most current
   email addresses as of this release.  Use these for sending in 
   comments and informal suggestions. 

      java-intl@java.sun.com                   Internationalization
      java-awt@java.sun.com                    AWT package
      java-security@java.sun.com               Security package
      java-io@java.sun.com                     IO package
      java-net@java.sun.com                    Net package
      jdbc@wombat.eng.sun.com                  JDBC package
      jdbc-odbc@wombat.eng.sun.com             JDBC-ODBC bridge
      java-beans@java.sun.com                  Beans package
      reflection-comments@worthy.eng.sun.com   Reflection package
      jni@java.sun.com                         Java Native Interface

   If your comment does not fall into any of those categories,
   please send it to:

      jdk-comments@java.sun.com                General comments

   While we are not able to respond individually to each comment,
   we do review all comments.


-----------------------------------------------------------------------
REPORTING BUGS AND REQUESTING FEATURES
-----------------------------------------------------------------------
To report bugs or feature requests, go to this web page:

     http://java.sun.com/cgi-bin/bugreport.cgi

This gives you instructions for checking if your bug is a duplicate
by allowing you to look in our known bugs list.  This also gives
instructions for how to submit bugs and request features.

Please be aware that bugs that you submit will not necessarily 
appear on the "Known Bugs" or "Fixed Bugs" pages, as we post 
only major bugs there.

When submitting a bug, be sure you include the version number of
the JDK you are running.  You can get the version number of the JDK 
by executing:

    java -version


-----------------------------------------------------------------------
JAVABEANS(tm) AND THE BEANS DEVELOPMENT KIT
-----------------------------------------------------------------------
A version of the Beans Development Kit (BDK) is also available for 
immediate download from JavaSoft.  BDK includes specific tools and 
support for JavaBeans developers such as the BeanBox test containers
and example beans. See:

    http://java.sun.com/beans/bdk_download.html

We will continue to ship the BDK in addition to the JDK.  
Updates to the BDK, tools, and general JavaBeans information 
will be posted on a regular basis to the JavaBeans web site:

     http://java.sun.com/beans



=======================================================================
                   INSTALLING AND RUNNING JAVA
=======================================================================

-----------------------------------------------------------------------
INSTALLATION NOTES
-----------------------------------------------------------------------
    
    IMPORTANT: Please make sure you understand the Copyright
    and License information (in the files named COPYRIGHT and 
    LICENSE) before installing this release.
    
The JDK 1.1.4 software and documentation are available in two separate
downloadable compressed files, called "bundles".  They need to be 
downloaded separately into the same directory and 
unpacked as follows for the few links between them to work.

Here are the abbreviated instructions.  (The installation procedure 
is different on different platforms, so these instructions are 
quite general.)

  1. Go to the JDK Download page and download the software and
     documentation separately:

        http://java.sun.com/products/jdk/1.1/

  2. Follow the installation instructions for your particular 
     platform at:

      http://java.sun.com/products/jdk/1.1/installation-solaris2.html

        OR

      http://java.sun.com/products/jdk/1.1/installation-win32-x86.html

  3. Unpack the software and documentation bundles according to the
     instructions on the web page given in step 2.  You should end up
     with the directory structure shown below.

  4. Set the PATH and CLASSPATH for Windows or Solaris as
     described in the section that follows.

  5. Use a web browser to go to your new, local JDK documentation
     table of contents by opening the "index.html" file in the "docs" 
     directory:  jdk1.1/docs/index.html


                           jdk1.1.4
    _________________________|_____________________________________
   |      |         |      |      |   |     |     |    |    |      |
README CHANGES COPYRIGHT LICENSE bin lib include demo src docs index.html
                                  |   |     |     |    |    |
                                                            |
                               _____________________________|_____
                              |       |        |       |          |
                             api  tooldocs relnotes  guide    index.html
                              |       |        |       |
  

   The "src" directory shown above originally appears as a "src.zip"
   file in the Solaris installation, which you must manually unzip.
   On Windows, the installer automatically unzips it for you.


-----------------------------------------------------------------------
RUNNING JAVA TOOLS IN MICROSOFT WINDOWS
-----------------------------------------------------------------------

After installing the JDK software, you start a tool by typing its
name into the DOS window with a filename as an argument.  None of
the main Java tools are Windows programs with GUI interfaces -- they
are all run from the DOS command line.  (For example, if you 
double-click on the Java Compiler "javac" icon, it will briefly 
open and immediately close a DOS window, because that is not the 
proper way to run it.)

You can specify the path to a tool either by typing the path in 
front of the tool each time, or by adding the path to the 
startup file (autoexec.bat).  For example, if the JDK is 
installed at C:\jdk1.1.4, to run the compiler on a file
myfile.java, go to a DOS shell and execute this:

    Type:  C:\jdk1.1.4\bin\javac myfile.java

     -or- 

    Add    C:\jdk1.1.4\bin to your path statement
    Type:  javac myfile.java

See the next section about setting the PATH and CLASSPATH variables.

-----------------------------------------------------------------------
MICROSOFT WINDOWS PATH and CLASSPATH
-----------------------------------------------------------------------

The CLASSPATH is not required, but if it is set, it will need to be
unset.  You may want to update the "path" variable for convenience.

     Developing in JDK 1.0.2 and 1.1.4 - If you want 
     to develop in both JDK 1.0.2 and JDK 1.1.4, you must
     set CLASSPATH (and PATH) separately for each one.  
     To run both versions simultaneously, you can run 
     each one from its own DOS window.  If you are running 
     only one at a time, you can write a batch script to
     switch the value of CLASSPATH (and PATH). 

     Windows NT only - If you are using Windows NT, it is  
     preferable to make the following environment variable  
     changes in the Control Panel. Start the Control Panel,  
     select System, then edit the environment variables. 

  1. PATH -  Add the absolute path of the "jdk1.1.4\bin" 
     directory to your PATH statement as follows. 

     The PATH statement enables Windows to find the executables 
     (javac, java, javadoc, etc.) from any current directory.

     To find out the current value of your PATH, at the
     DOS prompt type:

         C:\> path

     To change the PATH, open the AUTOEXEC.BAT file and make the
     change to the PATH statement. To edit the AUTOEXEC.BAT
     file in Windows 95: 

       i. Start a text editor by choosing "Start", "Programs", 
          "Accessories", and choosing WordPad or NotePad. 
      ii. Choose Open from the File menu and type "c:\autoexec.bat" 
          for the filename This will open the file for editing. 
     iii. Look for the PATH statement. Notice that the PATH statement
          is a series of directories separated by semi-colons (;).  
          Windows looks for programs in the PATH directories in order,
          from left to right. Look for other JDK versions in the PATH.
          There should only be one path to a classes.zip file.
          When in doubt, put the java directory at the end of 
          the path statement. For example, in the following PATH
          statement, we have added the java directory at the end: 

           PATH C:\WINDOWS;C:\WINDOWS\COMMAND;C:\;C:\DOS;C:\JDK1.1.4\BIN 

     To make the path take effect, execute the following:

           C:\> autoexec.bat


  2. CLASSPATH Environment Variable - If you follow the default 
     installation, you do not need to set CLASSPATH, because the
     tools automatically set it for you.  (This was actually
     also true in all beta versions and the final version of 
     JDK 1.1, but was undocumented.)  If your CLASSPATH has 
     not previously been set, you can skip this step.

     UNSETTING CLASSPATH

       If you have previously set the CLASSPATH and want to
       unset it, you normally need to change the current value
       (at the command line) and the startup value (in a startup
       file or script).  For example, to see if it is currently 
       set, type:

          % set

       This lists all of the environment variables.  CLASSPATH
       will not appear if it is not set.

       If it is set, you can unset the current value by setting
       it to no value:

          % set CLASSPATH=

       Also open your startup file (autoexec.bat) or script and 
       remove the path to the JDK classes from the CLASSPATH 
       environment variable, if you want the change to be
       permanent.

     WHAT CLASSPATH DOES

       The CLASSPATH tells the Java Virtual Machine and other Java 
       applications (which are located in the "jdk1.1.4\bin" 
       directory) where to find the class libraries, such as 
       classes.zip file (which is in the lib directory).  
       By default, the java tools temporarily append the 
       following to whatever CLASSPATH you have explicitly 
       set in your startup file:

       .;[bin]\..\classes;[bin]\..\lib\classes.zip

       where [bin] is substituted by the absolute path to the   
       jdk1.1\bin directory.  Therefore, if you keep the bin and  
       lib directories at the same directory level (that is, if 
       they have a common parent directory), the Java executables 
       will find the classes.  You need to set the CLASSPATH only 
       if you move classes.zip or want to load a different library 
       (such as one you develop).  

     Refer to the Windows Installation Troubleshooting section below 
     if you have problems running the JDK.


-----------------------------------------------------------------------
MICROSOFT WINDOWS INSTALLATION TROUBLESHOOTING
-----------------------------------------------------------------------

Here are four troubleshooting tips for Microsoft Windows.

   * If you see the following error message 

        net.socketException: errno = 10047

        -or-

        Unsupported version of Windows Socket API

     check which TCP/IP drivers you have installed. The AppletViewer
     supports only the Microsoft TCP/IP drivers included with 
     Windows 95. If you are using third-party drivers (e.g., 
     Trumpet Winsock), you'll need to change over to the native
     Microsoft TCP/IP drivers if you want to load applets over the
     network. 

   * If the AppletViewer does not load applets then you might
     try the following: 

      1. set HOMEDRIVE=c:
         set HOMEPATH=\
         and restart the AppletViewer (in the same DOS box) 

      2. set HOME=c:\
         and restart the AppletViewer (in the same DOS box) 

     If none of these work, try: 

         java -verbose sun.applet.AppletViewer

     This lists the classes that are being loaded. From this output, 
     you can determine which class the AppletViewer is trying to 
     load and where it's trying to load it from. Check to make sure
     that the class exists and is not corrupted in some way. 

   * Error Message: "Exception in thread NULL"
     or "Unable to initialize threads: cannot find class 
     java/lang/Thread" (yes, with forward slashes)

     If you are getting one of these fatal error messages 
     when running java, javac, or appetviewer, you should check 
     your CLASSPATH environment variable. It may list 
     "c:\java" or the "classes" directory from an older 
     JDK release.  You can either unset the CLASSPATH variable, 
     or set it to include only the latest version of the JDK class 
     library.  For example: 

        C:\> set CLASSPATH=.;C:\jdk1.1.4\lib\classes.zip

     This will make sure that you are using the correct classes 
     for this release.

   * Cannot close AppletViewer copyright window (Windows 95 only)
     In Microsoft Windows 95, the launch bar may partially cover
     the AppletViewer copyright notice window Accept and Reject 
     buttons. If this happens, you can move the Windows 95
     launch bar to the side of the desktop to allow access to 
     the copyright window Accept and Reject buttons.


-----------------------------------------------------------------------
RUNNING JAVA TOOLS IN SOLARIS
-----------------------------------------------------------------------

After installing the JDK software, you start a tool by typing its
name into a shell window with a filename as an argument.  You can 
specify the path to a tool either by typing the path in front of 
the tool each time, or by adding the path to the startup file.  
For example, if the JDK is installed at /usr/local/jdk1.1.4, 
to run the complier on a file myfile.java, go to a shell and execute:

    Type:  /usr/local/jdk1.1.4/bin/javac myfile.java

     -or- 

    Add  /usr/local/jdk1.1.4/bin to your path statement 
    Type:  javac myfile.java

The path and CLASSPATH variables are not required, but it is helpful 
to know more about them.  See the next section about setting these 
variables.


-----------------------------------------------------------------------
SOLARIS PATH and CLASSPATH
-----------------------------------------------------------------------

The CLASSPATH is not required, but if it is set, it will need to be 
unset.  You may want to update the "path" variable for convenience.

     NOTE - If you want to develop in both JDK 1.0.2 and 
     JDK 1.1.4, you must set CLASSPATH (and path) separately
     for each one.  To run both versions simultaneously, you 
     can run each one from its own shell window.  If you are
     running only one at a time, you can write a batch script 
     to switch the value of CLASSPATH (and PATH). 

  1. Path Variable -  Add the absolute path of the "jdk1.1.4/bin"
     directory to your Unix path variable, as follows.  

     The path variable enables Solaris to find the executables 
     (javac, java, javadoc, etc.) from any current directory.
     To find out if the path is currently set for any java tools,
     execute:

        % which java

     This will print the path to java, if it can find it.

     If you use the C shell (csh), you can set the path in 
     your startup file (~/.cshrc) as follows, for example:

        set path=($path /usr/local/jdk1.1.4/bin)

     Then load the startup file and verify that the path 
     is set by repeating the "which" command above:

        % source ~/.cshrc
        % which java

  2. CLASSPATH Environment Variable - If you follow the default 
     installation, you do not need to set CLASSPATH, because the
     shell scripts automatically set it for you.  (This was actually
     also true in all beta versions and the final version of 
     JDK 1.1, but was undocumented.)  If your CLASSPATH has 
     not previously been set, you can skip this step.


     If you want to develop in both JDK 1.0.2 and JDK 1.1.4, 
     you must set CLASSPATH separately for each one.  To run
     both simultaneously, run each one in its own DOS window.
     If you are running only one at a time, you can write a batch 
     script to switch the value of CLASSPATH. 

     UNSETTING CLASSPATH

       If you have previously set the CLASSPATH and want to
       unset it, you normally need to change the current value
       (at the command line) and the startup value (in a startup
       file or script).  For example, to see if it is currently 
       set, type:

          % echo $CLASSPATH

       If it is set, you can unset the current value by typing:

          % unsetenv CLASSPATH

       Also open your startup file (~/.cshrc) or script and 
       remove the path to the JDK classes from the CLASSPATH 
       environment variable if you want the change to be 
       permanent.

     WHAT CLASSPATH DOES

       The CLASSPATH tells the Java Virtual Machine and other Java 
       applications (which are located in the "jdk1.1.4/bin" directory) 
       where to find the class libraries, such as classes.zip file  
       (which is in the lib directory).  By default, the java tools 
       temporarily append the following to whatever CLASSPATH 
       you have explicitly set in your startup file:

       .:[bin]/../classes:[bin]/../lib/classes.zip

       where [bin] is substituted by the absolute path to the 
       jdk1.1/bin directory.  Therefore, if you keep the bin and 
       lib directories at the same directory level (that is, if
       they have a common parent directory), the Java executables
       will find the classes.  You need to set the CLASSPATH only 
       if you move classes.zip or want to load a different library
       (such as one you develop).  

     Refer to the Solaris Installation Troubleshooting section below 
     if you have problems running the JDK.

-----------------------------------------------------------------------
SOLARIS INSTALLATION TROUBLESHOOTING
-----------------------------------------------------------------------

   * Error Message: "Exception in thread NULL"
     or "Unable to initialize threads: cannot find class java/lang/Thread"

     If you are getting one of these fatal error messages 
     when running java, javac, or appetviewer, you should check 
     your CLASSPATH environment variable. It may list 
     "java" or the "classes" directory from an older 
     JDK release.  You can either unset the CLASSPATH variable, 
     or set it to include only the latest version of the JDK class 
     library.  For example: 

     % setenv CLASSPATH .:/usr/local/jdk1.1.4/lib/classes.zip

     This will ensure that you are using the correct classes for 
     this release.


-----------------------------------------------------------------------
RUNNING APPLETS WITH THE APPLETVIEWER
-----------------------------------------------------------------------
AppletViewer allows you to run one or more Java applets that are 
called by reference in a web page (HTML file) using the APPLET tag.
The AppletViewer finds the APPLET tags in the HTML file and runs 
the applets (in separate windows) as specified by the tags.

AppletViewer is for viewing applets.  It cannot display an entire 
web page that contains many HTML tags.  It parses only the APPLET 
tag and no other HTML on the web page.
  
To run an applet with appletviewer, you go to a command line for 
your operating system and run appletviewer, passing in the filename 
or URL of the web page as its argument. 
_______
SOLARIS

  Here is an example of how to invoke AppletViewer on a file-based
  web page in Solaris.  First change to the "jdk1.1.4" directory.  
  Then execute:

  bin/appletviewer demo/GraphLayout/example1.html

  Here is an example of how to invoke AppletViewer on a URL-based
  web page in Solaris. Execute:

  bin/appletviewer http://java.sun.com/applets/NervousText/example1.html
_______
WINDOWS
  Here is an example of how to invoke AppletViewer on a file-based
  web page in Windows.  Go to a DOS prompt, change to the "jdk1.1.4" 
  directory and then execute:

  bin\appletviewer demo\GraphLayout\example1.html

  Here is an example of how to invoke AppletViewer on a URL-based
  web page in Windows. Execute:

  bin\appletviewer http://java.sun.com/applets/NervousText/example1.html

-----------------------------------------------------------------------
DEBUGGING PROGRAMS WITH THE JAVA DEBUGGER (JDB)
-----------------------------------------------------------------------
You can debug applets using the -debug option of appletviewer.
When debugging applets, it's best to invoke appletviewer from
the directory that contains the applet's HTML file.  For example,
on Solaris:

     cd demo/TicTacToe
     ../../bin/appletviewer -debug example1.html

On the PC:

     cd demo\TicTacToe
     ..\..\bin\appletviewer -debug example1.html

You can find documentation on the debugger and its API at:

     http://java.sun.com/products/jdk/1.1/debugging/


-----------------------------------------------------------------------
Copyright � 1996,1997 Sun Microsystems, Inc.
901 San Antonio Rd., Palo Alto, CA 94303 USA
All rights reserved.



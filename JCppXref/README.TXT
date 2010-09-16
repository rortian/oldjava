The Java/C++ Cross Reference Handbook

About the Sample Program Files:

When the compressed, archive file has been restored to its original form,
the resulting directory structure should look like

..\JCppXref\JAVA
..\JCppXref\JAVA\JAVA1_1
..\JCppXref\JAVAPAKS
..\JCppXref\Unix_C
..\JCppXref\WinNTCpp

The subdirectories are organized as follows:

Subdirectory JAVA contains all of the Java sources and bytecode files.  The
bytecode files were produced with the Java Developer's Kit v. 1.02 under
Microsoft Windows/NT 4.0

Subdirectory JAVA\JAVA1_1 contains all of the Java sources and bytecode
files built with the Java Developer's Kit v. 1.1.1 under Microsoft
Windows/NT 4.0

Subdirectory Unix_C contains all of the C language and any supporting MOTIF
resource files.  There are no executables provided.  Instead, the reader is
given a Korn shell script to make the executable specific to his platform.

Note:  After the Korn shell script file and the source files are copied to
the particular UNIX platform, it is necessary to do a "chmod +x" on the
script file to make it executable.

Subdirectory WinNTCpp contains all of the C++ samples for the Microsoft
Windows 95 or NT environment (many of these samples can also be compiled
under a UNIX environment).  These samples include executables and Visual
C++ 4.0 project files.  Two samples from this subdirectory are intended to
be compiled with Borland C++ 5.0 (since this version at the time of
writing fully supported exception handling).

Subdirectory JAVAPAKS contains all of the supporting packages for some
of the Java programs contained in subdirectory JAVA.  In order for these
programs to compile, the CLASSPATH environment variable must be properly
set.  If we assume that the parent subdirectory JCppXref is installed from
the root of the C: drive of a Windows/NT environment (v. 3.51 or higher),
then the following statement should be set in the Control Panel (go to
the "Settings" menu and choose "System"):

CLASSPATH=.;C:\JAVA\LIB\CLASSES.ZIP;C:\JCppXref\JAVAPAKS;

Note that in a Windows 95 or NT environment, the path and file names are
NOT case-sensitive.  The above statement can also be typed from the
command line of a MSDOS window, but the environment variable setting will
only be valid for that window and as long as that window is open.  For
Windows 95, the statement can be placed within the AUTOEXEC.BAT file.

If the Java samples and the Java packages are installed on a UNIX system,
the CLASSPATH environment variable will be set depending on the type of
shell being used.  For the Bourne or Korn shells, the command line statement
is

CLASSPATH=/Java/Lib/classes.zip:/JCppXref/JAVAPAKS:.; export CLASSPATH

For the C shell, the command line statement is

setenv CLASSPATH /Java/Lib/classes.zip:/JCppXref/JAVAPAKS:.;

Note that under UNIX, the path and file names ARE case-sensitive.

About the Java Developers Kit, version 1.02 or 1.1.1 and Cafe Lite:

It is recommended that one of the JDK 1.02, JDK 1.1.1 or Cafe Lite be installed
on a single personal computer.  Mixing files from different versions can generate
strange or bizzard results.  Cafe Lite uses a particular version of the JDK.

After one of these development kits have been installed, make sure the JAVA_HOME
and PATH environment variables have been set or updated.  Use the Windows 95 or
Windows/NT Control Panel to verify or perform the updates.

If one of the JDK versions is installed, the following should be set:

JAVA_HOME=C:\JAVA

PATH=...;C:\JAVA\BIN

In this example, we are assuming the JAVA directory is created from the root
directory of drive C:.  The environment variable PATH should have ";C:\JAVA\BIN"
appended to the existing string value.

If Cafe Lite is installed, the following should be set:

JAVA_HOME=C:\Cafe\JAVA

PATH=...;C:\Cafe\BIN;C:\Cafe\JAVA\BIN;

In this example, we are assuming the Cafe directory is created from the root
directory of drive C:.  The environment variable PATH should have 
";C:\Cafe\BIN;C:\Cafe\JAVA\BIN;" appended to the existing string value.

After these environment variables have been set through the Control Panel, the
version of the Java compiler can be verified by opening a MSDOS window and by
typing the following (terminated by an <enter> key) on the command line:

javac -version

The output will display the version number.
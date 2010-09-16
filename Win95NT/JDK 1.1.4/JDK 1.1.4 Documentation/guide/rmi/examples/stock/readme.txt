The docs/guide/rmi/examples/stock directory in the JDK 1.1 Beta
installation directory contains an example that illustrates an applet
that exports a remote object in order to receive stock updates from a
stock server. The applet displays the stock data dynamically as
notifications are received from the server. The interfaces/classes for
this example are as follows:

   - StockWatch is the remote interface for stock server.
 
   - StockNotify is the remote interface for stock observer.
 
   - Stock is the serializable object containing stock data.

   - StockServer (implements StockWatch) sends notifications of stock
     updates to remote objects that have registered to receive updates.

   - StockApplet (implements StockNotify) exports a remote object (itself), 
     registers with StockServer for stock updates, and displays stock 
     notifications as they are received.

On Solaris, after downloading the JDK 1.1 Beta release, execute the run
script in the docs/guide/rmi/examples/stock directory, which will print
out what it is doing while it runs the example.  The stock server
creates its own registry, so the "rmiregistry" does not need to be
started.  Here are the basic steps that the run script executes:

setenv CLASSPATH ../..:$CLASSPATH
javac -d ../.. *.java
rmic -d ../.. examples.stock.StockServer examples.stock.StockApplet
java examples.stock.StockServer &
appletviewer index.html

Note: you can set your CLASSPATH back to the old CLASSPATH (without
../.. in it) before running the appletviewer, so that classes get
downloaded via the network rather than via CLASSPATH; each of the
scripts actually does this.

On Windows systems, after downloading the JDK 1.1 Beta release, execute
run.bat in the docs/guide/rmi/examples/stock directory, which will
explain each step as it builds and runs the example.  Upon completion,
you will need to explicitly destroy the window created for the server
process.

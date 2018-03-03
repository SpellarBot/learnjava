Notes from https://www.lynda.com/Java-tutorials/Java-Advanced-Training/107061-2.html

Diamond Operator - no need to repeat the class name on right side.
Number format - java 7 will ignore _ in numbers
String Switch - java 7 will let you create switch statement on string values
static block - called once before any other static field is used. called once only.
non-static block - called before constructor is called. called everytime object is instantiated.
member class - visible only to the class inside which it is declared.
inner class - visible only the method inside which it is declared.
annonymous class - remove the name when not needed. define and instantiate on the fly.

reflection - you can get class details

collections - http://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

------------|-----------|-------------------|---------------|-----------|--------------------------
Interface	|Hash Table	|Resizable Array	|Balanced Tree	|Linked List|Hash Table + Linked List
------------|-----------|-------------------|---------------|-----------|--------------------------
Set			|HashSet	|	 				|TreeSet		| 			|LinkedHashSet
List		| 			|ArrayList			|				|LinkedList	| 
Deque		| 			|ArrayDeque			| 				|LinkedList	| 
Map			|HashMap	| 					|TreeMap		| 			|LinkedHashMap
------------|-----------|-------------------|---------------|-----------|--------------------------

io
Paths, Files - 2 util classes to make File/Dir ops easier
FileReader - text files. 
FileBufferedReader - text files - faster reading
FileWriter - write text files.
FileBufferedWriter - text files - faster writing
FileInputStream - binary data reader
FileOutputStream - binary data writer

SimpleFileVisitor - scanning paths to see what files exist
PathMatcher - to filter files found by SimpleFileVisitor 
WatchService - to track file creation/deletion/modification in a directory 

Threads
t.run - start process on main
t.start - run a seperate thread
synchronized - block of code that only one thread can run at any time

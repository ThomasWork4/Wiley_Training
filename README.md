Creating and running a scala program from command line 
--------------------------------------------------------------
1. Write a program onto notepad++ and save it with .scala at the end
2. Enter into terminal Scalac filename.scala to compile the file into a class and bytecode file
3. Run the class file using scala filename (Without the .class extension)


Running .jar files to see original code
--------------------------------------------------------------
Two main options
1. Open JD Gui manually and select the .jar file 
2. java -jar jar-file-name.jar 


Connecting Intellij to GitHub and pushing work
--------------------------------------------------------------
1. Connect your GitHub account through settings 
2. Right click on the file you want to push and go to git commit 
3. Write a message in the commit box and then push commit 
4. Then do the same thing again but click push instead of commit 
5. In the box that comes up, configure a branch to push to by providing the repository link. The repository NEEDS to be new.


Variable Declaration
--------------------------------------------------------------
Var my_variable - Creates a mutable variable
Val my_variable - Creates an immutable variable
Best practice is to declare the data type so that Scala knows for sure what it's dealing with 
E.g. Var my_variable:String = "Hello"
This is a much safer practice

Tuples
--------------------------------------------------------------
Tuples store a number of values per element. For example:
val tuple:(String, Int)=("Thomas", 22) 
Creates a tuple containing a string and integer
You can print indexes of tuples using tuplen._1  tuple._2 etc

Data types in scala
--------------------------------------------------------------
String = ""
Byte is 8 bits
Short is 16 bits
Char is 16 bits
Int is 32 bits
Long is 64 bits
Float is 32 bits
Double is 64 bits 
Boolean is True or False

Pattern matching for the same data type 
--------------------------------------------------------------
You can use the keywords "match" and "case" to match a variable
to a list of possible cases. Doing this typically means you can only 
use one data type. 

Pattern matching for different data types 
--------------------------------------------------------------
Similar to the process above however we use the Any keyword which
allows us to search cases with multiple data types. This is best to 
implement inside a function to keep the whole process automatec

For loops
--------------------------------------------------------------
for(a <-1 to 5){} ------ Loops through 1 to 5 and includes the upper boundary
for(a <-1 until 5){} ------- Loops through 1 to 5 and doesn't include the upper boundary
for(a <- 1 to 10 if a%2==0 ----- For loop combined with an if statement
var result = for(a<-1 to 10) yield a ------- Yield returns the result of the entire loop after it's completed not the result at every step
for(i<-1 to 20 by 2){println(i)} -------- For loop where you can stipulate the size of each increment during each iteration

While loops
--------------------------------------------------------------
While loops iterate until the termination criteria is met. 
  var a = 10
  while (a <= 20) {
    println(a)
    a = a + 2
  }
This prints the value of a at each iteration until it is bigger than 20

It's possible to implement infinite loops, however there's typically no reason for this

Control Structures
--------------------------------------------------------------
if statement --- Procs if the conditions of the if statement are met
if else ---- Used when there are multiple criteria needed to be checked
else ----- If all else fails, or if there are only two conditions to check

Basic lists
--------------------------------------------------------------
 var listOfNumbers = List(1, 2, 3, 4, 5)
 There are three ways to print the content of a list
 1.   listOfNumbers.foreach(print)
 2.   listOfNumbers.foreach(println)
 3.   listOfNumbers.foreach{
    (element: Int) => print(element + " ")
  }
  
 NOTE that curly brackets are used for multi-line statements whereas normal parenthesis are used for single line statements

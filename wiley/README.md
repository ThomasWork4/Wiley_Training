
AbstractClasses 
-----------------------
- This package contains two abstract class implementations
- An abstract class is a class that cannot be instantiated
- It can contain abstract methods or normal methods
- It can only be instantiated by inheriting with a normal class and then defining the methods yourself
- It's good to use when you don't know all the functionality of the class you are making. You can implement the parts you do know, and leave the parts you don't     bodiless, ready for those who do know, to fill out the functionality for you in extended classes

AbstractClass.scala - Creates an Animal abstract class with abstract method Run() and normal method die(). It then extends the abstract class into subclass Dog and defines the body of the abstract method run(). Concludes by creating a new Dog object and calling the overriden abstract method. 

AbstractClassPractice.scala - Creates an Human abstract class with two abstract methods (Run and showAttributes). Similar to the previous abstract class implementation, it then extends this class adn overrides the abstract methods. This implementation contains inherited attributes as well as methods. 

AccessModifiers
-----------------------
- This package contains example implementations of the three access modifiers contained within Scala
- Access modifiers are mechanisms that restrict the accessability of class variables and functions
- There are 3 main modifiers in Scala.
- No Modifier / Public (The least restrictive) = Class(Yes), Companion(Yes), Subclass(Yes), Package(Yes), World(Yes)
- Protected (More restrictive than public, but less so that private) = Class(Yes), Companion(Yes), Subclass(Yes), Package(No), World(No) 
- Private (The most restrictive) = Class(Yes), Companion(Yes), Subclass(No), Package(No), World(No)

AccessModifiers.scala  - Displays the syntax for each of the 3 access modifiers and then calls the variables to print to the console. 

AkkaStream
-----------------------
- This package contains example implementations of the Flow, Sink and source behaviours as well as use cases for the Actor thread system
- Actor system is a group of threads that executes in the backend, we can choose to utilize one or more threads for a single process
- Source is typically the source of the data being transformed or manipulated
- Flow is the filtration or transformation being applied to the source data 
- Sink is the mechanism for with our source code is then returned to the user
- NOTE using multiple threads for small sources may not work as efficient as a single thread, however it will always be more efficient for very large data sources

AkkaStrean.scala - Creates a source, flow, sink pipeline that takes a large range, multiplies each value by 4, and prints the output. This script contains two implementations of flow: One that uses a single thread to transform the data, and another that uses 4 threads to transform the data.

AkkaStream2.scala - Modified version of AkkaStream.scala. We are now sleeping each thread for a second inside the sink mechanism. This changes the way the threads print to the console. Note this implementation uses 4 threads only.

AnonymousObjects 
-----------------------
- This package contain an example implementation of anonymous objects
- Anonymous objects are objects created without a reference 
- This is sometimes done for anonymity but in most cases done to quickly utilize a method inside a class
- The main benefit is that you can declare and instantiate a new object in one line
- Also, because you are not assigning a reference, it doesn't take up any space on the heap memory, and when the garbage collector runs, this will be one of the     first objects to go

AnonymousObjects.scala - Defines a class AnonymousObject that contains the method add, which sums two parameters and prints the output. In the main object, we define an anonymous object with no reference and call the method with custom inputs. 

CaseClass
-----------------------

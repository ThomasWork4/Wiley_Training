
AbstractClasses 
-----------------------
- This package contains two abstract class implementations
- An abstract class is a class that cannot be instantiated
- It can contain abstract methods or normal methods
- It can only be instantiated by inheriting with a normal class and then defining the methods yourself
- It's good to use when you don't know all the functionality of the class you are making. You can implement the parts you do know, and leave the parts you don't     bodiless, ready for those who do know, to fill out the functionality for you in extended classes

[AbstractClass.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/AbstractClasses/AbstractClass.scala) - Creates an Animal abstract class with abstract method Run() and normal method die(). It then extends the abstract class into subclass Dog and defines the body of the abstract method run(). Concludes by creating a new Dog object and calling the overriden abstract method. 

[AbstractClassPractice.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/AbstractClasses/AbstractClassPractice.scala) - Creates an Human abstract class with two abstract methods (Run and showAttributes). Similar to the previous abstract class implementation, it then extends this class adn overrides the abstract methods. This implementation contains inherited attributes as well as methods. 

AccessModifiers
-----------------------
- This package contains example implementations of the three access modifiers contained within Scala
- Access modifiers are mechanisms that restrict the accessability of class variables and functions
- There are 3 main modifiers in Scala.
- No Modifier / Public (The least restrictive) = Class(Yes), Companion(Yes), Subclass(Yes), Package(Yes), World(Yes)
- Protected (More restrictive than public, but less so that private) = Class(Yes), Companion(Yes), Subclass(Yes), Package(No), World(No) 
- Private (The most restrictive) = Class(Yes), Companion(Yes), Subclass(No), Package(No), World(No)

[AccessModifiers.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/AccessModifiers/AccessModifiers.scala)  - Displays the syntax for each of the 3 access modifiers and then calls the variables to print to the console. 

AkkaStream
-----------------------
- This package contains example implementations of the Flow, Sink and source behaviours as well as use cases for the Actor thread system
- Actor system is a group of threads that executes in the backend, we can choose to utilize one or more threads for a single process
- Source is typically the source of the data being transformed or manipulated
- Flow is the filtration or transformation being applied to the source data 
- Sink is the mechanism for with our source code is then returned to the user
- NOTE using multiple threads for small sources may not work as efficient as a single thread, however it will always be more efficient for very large data sources

[AkkaStrean.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/AkkaStream/akkaStream.scala) - Creates a source, flow, sink pipeline that takes a large range, multiplies each value by 4, and prints the output. This script contains two implementations of flow: One that uses a single thread to transform the data, and another that uses 4 threads to transform the data.

[AkkaStream2.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/AkkaStream/akkaStream2.scala) - Modified version of AkkaStream.scala. We are now sleeping each thread for a second inside the sink mechanism. This changes the way the threads print to the console. Note this implementation uses 4 threads only.

AnonymousObjects 
-----------------------
- This package contain an example implementation of anonymous objects
- Anonymous objects are objects created without a reference 
- This is sometimes done for anonymity but in most cases done to quickly utilize a method inside a class
- The main benefit is that you can declare and instantiate a new object in one line
- Also, because you are not assigning a reference, it doesn't take up any space on the heap memory, and when the garbage collector runs, this will be one of the     first objects to go

[AnonymousObjects.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/AnonymousObjects/AnonymousObjects.scala) - Defines a class AnonymousObject that contains the method add, which sums two parameters and prints the output. In the main object, we define an anonymous object with no reference and call the method with custom inputs. 

CaseClass
-----------------------
- This package contains an example implemenetation of Case classes
- Case classes are great for modelling immutable data
- They also work really well with pattern matching 
- By default, all constructor parameters for case classes are public and immutable

[CaseClass.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/CaseClass/CaseClass.scala) - Defines a trait (Java interface) from which we extend 3 case classes. We also define a method that contains a pattern matching mechanism for printing the attributes of each object once instantiated. Each of the 3 case classes are passed to this method, and the output printed to the console. 

Constructors 
-----------------------
- This package contains an example implementation of all the different constructor mechanisms in Scala
- Constructors are called with a new object is instantiated, they are responsible for setting a new objects attributes 
- There are multiple ways of implementing a class constructor (Default, parameterized, secondary) 

[DefaultConstructors.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Constructors/DefaultConstructor.scala)- A class with parameters that are predefined in the case that the user does not set them himself
[ParameterizedConstructors.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Constructors/ParameterizedConstructor.scala)- A class with 2 parameters, not default. These need to be defined with instantiating a new object otherwise the program will thrown an exception 
[SecondaryConstructor.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Constructors/SecondaryConstructor.scala) - Also referred to auxiliary constructors. By defining a this() method, we can redefine how many parameters the class is willing to accept when instantiated. This is done on two occasions in this program to show that the class can be instantiated with 2, 3 or 4 parameters passed to it.
[ThisKeyword](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Constructors/ThisKeyword.scala) - An extension of SecondaryConstructor.scala. Complimentary works with an auxiliary constructor with more comments.

CustomClasses
-----------------------
- This package contains an example of a custom class implementation 
- This package was purely for practice purposes in the early stages of OOP training

[CustomClasses.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/CustomClasses/CustomClasses.scala) - Custom class parameterized by name and id attributes with 3 internal class methods. The idea here is that we have a classroom map, with each student having a name and ID. We can instantiate new CustomClass objects, and pass them to the class room map using their attributes. We also implement this functionality using user inputs.

Dates 
-----------------------
- This package contains example implementation for date manipulation using both Java.util and Joda.time
- Java.util is easier to use and doesn't require any dependencies, however it does not display smaller time figures such as seconds. The biggest flaw is that when   defining a date, the year must be calculated by minusing 1900. 
- Joda.time requires the maven dependency however is very versatile and inclusive. You can define any time figures down to the milisecond. 

[Dates.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Dates/Dates.scala) - Two date implementations, one with Java.util, the other with Joda.time. We also define a custom data in each case and print to the console. 

Enumeration 
-----------------------
- This package contains example implementations of enumeration 
- An enumeration is a set of values with named constants 
- They offer an easy way to work with these named, related constants 
- They are good for reducing errors, increasing readability, and changing values in the future

[EnumerationPractice.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Enumeration/EnumerationPractice.scala) - Defines a planet enumeration contains all the planets as named constants. The program passes them to an isPlanet that tests whether they are part of the enumeration 

[DifferentEnumerationCase.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Enumeration/DifferentEnumerationCase.scala) - Defines a different donut enumeration with donut types as named constants. The program implements a for loop demonstrating how to test each constant using pattern matching. In this case, only Glazed or Vanilla donuts will print to the console properly.

Exceptions 
-----------------------
- This package contains example implementations of exceptions and custom exceptions 
- Exceptions are logical errors in the code that stop the flow of execution 
- Checked exceptions are triggered at compile time 
- Unchecked exception are triggered at runtime

[CreaingExceptions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Exceptions/CreatingExceptions.scala) - Custom exception for validating an integer is greater than 18. If not, the custom exception will be thrown, handled and printed to the console. 
[MoreCustomExceptions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Exceptions/MoreCustomExceptions.scala) - Another custom exception to validate whether the user has enough funds to purchase an item as well as a custom exception to check whether an input value is a digit or not. 
[MoreHandling.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Exceptions/MoreHandling.scala) - An example of the try catch block in combination with throwing exceptions. In this example, we are trying to access the 10th index of an array of size 2. 
[MoreThrows.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Exceptions/MoreThrows.scala) - Another implementation of the try catch block in combination with implicitly throwing an exception under certain circumstances
[ThrowingExceptions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Exceptions/ThrowingExceptions.scala) - First program made in this package showing the syntax for throwing an exception implicitly
[TryCatchFinally.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Exceptions/TryCatchFinally.scala) - An implemention of the try catch finally mechanism. The logic here is the same as MoreHandling.scala 

FileManipulation
--------------------------
- This package contains example implementations of reading and writing to a text file

[ReadingFromFile.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/FileManipulation/ReadingFromFile.scala) - Reads from a text file and prints the result in array for seperated by commas.
[WritingToFile.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/FileManipulation/WritingToFile.scala) - Writes multiple lines to a text file

Functions 
---------------------------
- This package contains example implementations of functions in Scala 
- Given that Scala is massively functionally driven, these program were the cornerstone to my early understanding of the langauge

[DefaultValueFunctions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Functions/DefaultValueFunctions.scala) - Displays the syntax for writing a function with default values in the case where no parameters are passed at calltime. 
[Recursion.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Functions/Recursion.scala) - Recursive function (function that calls itself). This recursive function can be used to find the factorial of a number. 
[ScalaFunctions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Functions/ScalaFunctions.scala) - One of the first programs written in training designed to demonstrate the syntax of a regular function


Higher Order Functions 
------------------------------
- This package contains example implementations of the different higher order functions 

[AnonymousFunctions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/AnonymousFunctions.scala) - Implementation of anonymous functions where functions are essentially written as variables. This program defines an addition AF. It implemented in different ways with varied datatypes. 
[Composition.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/Composition.scala) - Implementation of composition where functions are stacked and executed on after an other dependent on the order of the stack.
[CuryingFunctions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/CuryingFunctions.scala) - Implementation of currying which is essentially the process of converting a function with multiple arguments into a sequence of functions that take a single argument.
[HigherOrderFunctions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/HigherOrderFunctions.scala) - Implementations of functions that accept other functions as a parameter input. 
[MultiLineExpressions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/MultiLineExpressions.scala) - Implementation of multi line expressions where the last return clause is executed instead of the first because code is interpreted by the JVM from top to bottom.
[NestedFunctions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/NestedFunctions.scala) - Implementation of nested functions where functions are called inside another function
[SupplementaryObject.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/SupplementaryObject.scala) - This can be ignored, this was merely a supplentary object for other programs to call upon should they need it. 
[VariableLengthParameters.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/HigherOrderFunctions/VariableLengthParameters.scala) - Implementation of functions that can accept varialbe length parameters using key symbols like * or collections of data.

Inheritance
------------------------------
- This package contains example implementations of the different inheritance instances
- There are 4 different types of inheritance (Single, Multiple, Multilevel and Hierarchical)

[BankTask.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Inheritance/BankTask.scala) - Class that implements an example of hierarchical inheritance. In this case, multiple banks are inheriting the base interest rate from the parent Central bank class. 
[Inheritance.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Inheritance/Inheritance.scala) - Class that implementes regular inheritance. In this case, class Amphibian extends the parent class Animal and inherits all it's attributes and methods. 
[Multilevelinheritance.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Inheritance/MultilevelInheritance.scala) - Class that implements multilevel inheritance. In this case child class Mammal extends parent class SuperAnimal and grandchilds class mammoth extends child class mammal. 

LabWork
------------------------------
- This package all mini-assignments given during training as part of the Wiley Edge slides, or Leetcode tasks that needed to be completed in our own time. 

LazyEvalutation
------------------------------
- This package contains an example implementation of the lazy keyword 
- Lazy evaluation is also referred to as "Call-by-need" 

[LazyEvaluation.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/LazyEvaluation/LazyEvaluation.scala) - This program demonstrates the usability of the lazy keyword and that it's only used by the program when it is explicity, otherwise will do nothing. 

LazyEvalutation
------------------------------
- This package contains an example implementation of the lazy keyword 
- Lazy evaluation is also referred to as "Call-by-need" 

[LazyEvaluation.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/LazyEvaluation/LazyEvaluation.scala) - This program demonstrates the usability of the lazy keyword and that it's only used by the program when it is explicity, otherwise will do nothing. 

List 
------------------------------
- This package contains an example implementation of the list collection

[BasicLists.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/List/BasicLists.scala) - Demonstrates the syntax of a simple list and how to iterate them. 

MultiDimensionalArrays 
------------------------------
- This package contains an implementation of multi dimensional arrays and how they can be manipulated

[AdditionOFMDArrays.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/MultiDimensionalArrays/AdditionOfMDArrays.scala) - This program creates two multidimensional arrays and adds them together essentially using matrix addition. 
[MultiDimensionalArrays.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/MultiDimensionalArrays/MultiDimensionalArrays.scala) - This program shows multiple syntaxes for creating multidimensional arrays. It also demonstrates how to iterate and partition them as required.
[StringInterpolation.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/MultiDimensionalArrays/StringInterpolation.scala) - This program shows  a very brief example of how to format a string using the different formatting options. 

ObjectOrientation 
------------------------------
- This package contains the first programs written as part of the OOP part of training regarding the syntax of classes and how they are used.

[StudentClass.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/ObjectOrientation/StudentClass.scala) - This program demonstrates a student simple student class with multiple attributes and methods. We demonstrate in the main thread how to instantiate classes and call class methods. 
[StudentClassContinuation.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/ObjectOrientation/StudentClassContinuation.scala) - This program is a continuation of the previous class experimenting with the basic concept of object orientation. 

Operators 
------------------------------
- This package contains an implementation for each of the differnent operators in Scala

[Operators.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Operators/Operators.scala) - This program demonstrates the syntax for each of the different operators (==, &&, ||). 

Options 
------------------------------
- This package contains implementations for the Option container in scala and what it's different use cases are.

[Example.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Options/Example.scala) - Fairly complex progfram that accesses a map and attempts to retrieve from the option container returned. Corresponding messages are provided to the user regarding whether the option is empty or not. 
[Student.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Options/Student.scala) - Similar to Example.scala, follows a map implementation an attempts to retrieve from the map and execute pattern matching cases based on the contents of each option. 

Package
------------------------------
- This package contains examples of how to import from other packages contained inside your intellij project

[PackageTrial.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Package/PackageTrial.scala) - This program demonstrates the syntax for importing from an alternative class or object and executing whatever is provided inside.
[PracticePackage.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/Package/PracticePackage.scala) - A continuation of PackageTrial.scala with a different example.

Regex 
------------------------------
- This package contains an

[]()

ScalaLogging
------------------------------
- This package contains an implementation of the lazy logging import. 

[Logging.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/ScalaLogging/Logging.scala) - This program demonstrates the syntax for logging a particular message instead of printing to the console. 

SingletonAndCompanion
------------------------------
- This package contains an implementation of the companion object as well as the singelton object

[CompanionObject.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/SingletonAndCompanion/CompanionObject.scala) - This program demonstrates the syntax for the companion object. It is an object declared in the same file as a class and has the same name as the class. Companion objects typically don't have a reference. 
[Singleton.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/SingletonAndCompanion/Singleton.scala) - This program demonstrates the syntax for the singleton object. Singleton object is an object that is declared by an object instead of a class. It's also used to expose some globally accessible functions or methods. Singleton objects are instantiated only once therefore its state IS SAVED and it's attributes are never re-initialized

Stream 
------------------------------
- This package contains an

[]()
[]()

SyllabusInPractice 
------------------------------
- This package contains an

[]()
[]()

Testing
------------------------------
- This package contains an

[]()
[]()

Threads
------------------------------
- This package contains an

[]()
[]()

TypeHierarchy 
------------------------------
- This package explains the different type heirarchies in Scala given that they differ to most other programming languages

[TypeHierarchy.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/TypeHierarchy/TypeHierarchy.scala) - This program demonstrates the syntax for Any, AnyVal, AnyRef and explores what they represent in regards to their usability.

breakTesting 
------------------------------
- This package contains implementations for the break clause and how it is used in Scala

[testBreak](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/breakTesting/testBreak.scala) - This program demonstrates the syntax of the break clause and how it can be used to break out of control structures. Note that breakable must be used with break otherwise a break exception with stop the flow of execution in Scala.

Collections
------------------------------
- This package contains an

[]()
[]()

controlStructures
------------------------------
- This package contains implementations for the different types of control structures inside Scala

[ControlStructures.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/controlStructures/ControlStructures.scala) - This program demonstrates the syntax for if statements and how they can be used in Scala.
[ForLoops.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/controlStructures/ForLoops.scala) - This program demonstrates the syntax for for loops and how they can be used to control collections of data. Most of these examples cover ranges, however this is expanded upon in other packages.
[LoopsContinuous.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/controlStructures/LoopsContinuous.scala) - This program explores the usability of infinite loops, although this is not often implemented without a termimation criteria. 
[WhileLoops.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/controlStructures/WhileLoops.scala) - This program demostrates the syntax for while loop and how they are fairly similar to for loops but only stop when a particular criteria is met.

fieldOveriding
------------------------------
- This package contains an implementation of field overriding. This is essentially overriding parents attributes inside a child class.

[fieldOverriding](https://github.com/ThomasWork4/Wiley_Training/tree/master/wiley/fieldOverriding) - This program demonstrates the syntax of the override keyword with regards to changing parent attributes inside a child class. Note that the attributes must be declared as val for this to be possible. 

mapFunction
------------------------------
- This package contains an implementation of method overriding which is also referred to as runtime polymorphism 

[mapFunction.scala](https://github.com/ThomasWork4/Wiley_Training/tree/master/wiley/mapFunction) - This program demonstrates the use cases for the map function. The map function is great for performing transformations on collections of data. It's less computationally expensive then a for loop.  


mixTraits
------------------------------
- This package contains an implementation of mix traits that can be mixed with abstract classes using the with keyword

[mixTraits.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/patternMatching/MixTypes.scala) - This program demonstrats the use cases of mixing traits with abstract classes when being inherited. 
[mixTraitsPractice.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/patternMatching/PatternMatching.scala) - This program is a continuation of mixTraits.scala. 


patternMatching
------------------------------
- This package contains example implementations for the pattern matching mechanism 

[MixTypes.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/patternMatching/MixTypes.scala) - This program demonstrates the pattern matching syntax and how it can be used as an alternative to if statements.
[PatternMatching.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/patternMatching/PatternMatching.scala) - This program is a continuation of MixTypes.scala. 

Tuples 
------------------------------
- This package contains an implementation of the Tuple collection and how it's unique use cases

[Tuples.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/scalacohort/Tuples/Tuples.scala) - This program highlights the syntax for a scala Tuple, as well as how to index them for individual elements. Tuples are great for storing multiple datatypes inside a single collection, however they can sometimes be fairly one-dimensional and don't have alot of other usages.

stringManipulation 
------------------------------
- This package contains the different implementations for manipulating strings in Scala. 

[compareTo.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/stringManipulation/compareTo.scala) - This program demonstrates the usability of the compareTo function. A further description of how this function is contained within the documentation of the program. 
[stringFunctions.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/stringManipulation/stringFunctions.scala) - This program highlights the substring and concatenation functions, each of which with their own advantages for indexing strings and transforming them.
[stringManipulation.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/stringManipulation/stringManipulation.scala) - This program highlights the difference between == and .equals(). Furthermore it discusses the computational differences between using the plus symbol to concatenate strings, and the concatentation function itself.

traits 
------------------------------
- This package contains an implementation of the traits mechanism. This is similar to java interfaces.

[traits.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/traits/traits.scala) - This program demonstrates the syntax and usages of traits. Traits are bodyless classes with abstract methods. They have no functionality whatsoever. They act purely as a skeleton for other subclasses to extend from. In this particular script, we define a Human trait with multiple abstract methods, as well as a Man child class that extends the train and overrides each of it's possible functionalities. NOTE, multiple inheritance is possible using traits in Scala.

variables 
------------------------------
- This package contains the first program made as part of the scala training.

[Variables.scala](https://github.com/ThomasWork4/Wiley_Training/blob/master/wiley/variables/Variables.scala) - This program demonstrates the syntax of a regular variable

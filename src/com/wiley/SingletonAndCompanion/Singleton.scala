package com.wiley.SingletonAndCompanion

/*
Scala is more object oriented language than Java so,
Scala does not contain any concept of static keyword.
Instead of static keyword Scala has singleton object.
A Singleton object is an object which defines a single object of a class.
A singleton object provides an entry point to your program execution.
If you do not create a singleton object in your program,
then your code compile successfully but does not give output.
So you required a singleton object to get the output of your program.
This description was sourced from GeeksforGeeks
*/

/*
A singleton object is an object that is declared by an object instead of a class.
It's used when you need exactly one instance of an object
It's also used to expose some globally accessible functions or methods
Singleton objects are instantiated only once therefore its state IS SAVED and it's
attributes are never re-initialized
If you ran the Singletonobject.hello() command multiple times, it would print
2, 4, 6, 8 etc
Instead of reinitializing a to 2 every time the object is called which would result in
4, 4, 4, 4 etc
^ This is what happens in Java and Python
 */

object Singleton {
  def main(args: Array[String]): Unit = {
    SingletonObject.hello()
    SingletonObject.hello()
    SingletonObject.hello()
  }
}

object SingletonObject{
  var a=2
  def hello():Unit = {
    println("Hello")
    a=a+2
    println(a)
  }
}
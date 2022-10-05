package com.wiley.LabWork
import scala.jdk.CollectionConverters.MapHasAsScala
import scala.language.implicitConversions

object PrintingAndFormatting{
  def main(args: Array[String]): Unit = {
    // Prints to the console
    Console.println("Welcome to Scala Console")

    // Prints on a single line
    print("CS")
    print("_Portal")

    //Prints on a newline
    println()

    //Formats the print statement
    //You can have multiple formatted values on the same line
    //%d is for integers
    //%s is for strings
    //%f is for floats
    printf("Age = %d and %d", 83, 100)
    println()
    printf("Pi = %f", 3.14)
    println()
    printf("Hello %s", "World")
    println()
    //An alternative to printing variables inside a string other than
    //Using the plus sign, is to use the dollar sign
    var variable_name = "World"
    println(s"Hello $variable_name")

    //How to print the Scala version
    println("Thomas Sadler")
    println("Scala language: "+util.Properties.versionString)


    //How to print the System properties and Environment variables properties
    val environmentVars = System.getenv().asScala
    for ((k, v) <- environmentVars) println(s"key: $k, value: $v")

    val properties = System.getProperties.asScala
    for ((k, v) <- properties) println(s"key: $k, value: $v")
  }
}

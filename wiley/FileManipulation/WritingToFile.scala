package com.wiley.FileManipulation
import java.io._
object WritingToFile extends App{

  val pw = new PrintWriter(new File("C:\\Users\\thoma\\Desktop\\Training\\Training_Scala\\Scala_1\\FirstSBTProject\\src\\main\\scala\\com\\wiley\\FileManipulation\\hello.txt"))
  pw.write("Hello, world\n")
  pw.write("My name is Thomas Sadler\n")
  pw.close()

}

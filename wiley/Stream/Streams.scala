package com.wiley.Stream

import scala.collection.immutable.Stream.cons

object Streams extends App{

  //Streams are lazy
  //They only invoke elements of the list that you need
  //When you need them, for example, when you print the stream
  //Only the head element will get printed, the rest will be "Not computed"
  //Streams are backed by lists
  //The first element in the head of the stream

  //stream.empty is used to signify where the end of the stream is
  var stream = 1 #:: 2#:: 8#:: Stream.empty
  var stream2 = 1 #:: 2#:: 3#:: 10#:: 40#:: Stream.empty

  println(stream)

  //Take first 2 numbers from the stream
  stream.take(2).print()
  println("")

  //Print by index
  println(stream.head)
  println(stream(1))
  println(stream(2))

  //Take the first 10 elements from the stream
  //The stream only has 3 elements
  //Therefore only the first 3 elements will get printed
  stream.take(10).print()
  println("")
  stream2.take(10).print()

  println("")
  println(stream.size)

  //Map a transformation to each element
  //Add 10 to each element
  var stream3 = stream2.map(_ + 10)
  stream3.take(10).print
  //How to express the above statement as a single line
  //If you don't want to save the new stream
  println("")
  stream2.map(_ + 10).take(10).print
  println("")

  //Easy way to initialize a stream using ranges
  val RangeStream = (1 to 10).toStream
  val RangeStream2 = ('a' to 'z').toStream
  RangeStream2.take(28).print
  println("")

  //To find the max value
  println(RangeStream.max)
  //To find the sum of the stream
  println(RangeStream.sum)
  //To filter the stream for certain values
  //In this example we've chosen values greater than 5
  RangeStream.filter(_>5).take(5).print
  println("")

  //Another way of initializing a stream
  //I find this way fairly "dirty" and can be less readible
  var AnotherStream = cons(1,cons(2,cons(3,Stream.empty)))
  AnotherStream.take(3).print


}

package com.wiley.collections.Sequence

/*
Sequence is an iterable collection of class Iterable.
It is used to represent indexed sequences that are having a
defined order of element i.e. guaranteed immutable.
The elements of sequences can be accessed using their indexes.
Method apply is used for the purpose of indexing.
Sequences can also be accessed reversibly using the method reverse
and reverseIterator.
*/

//Sequences are really good for quick lookup
//They lookup using indexes

object sequence extends App{
  var seq:Seq[Int] = Seq(52,8,9,1,3,6)

  seq.foreach((elem:Int)=> print(elem+","))

  //For quick access
  println(seq(2))
  println(seq.isEmpty)
  println(seq.endsWith(Seq(3)))
  println(seq.contains(12))
  println(seq.head)
  //Does the same as indexing
  println(seq.apply(3))
  println(seq.toBuffer)
}

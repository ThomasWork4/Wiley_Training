package com.wiley.collections.Stacks

import scala.collection.mutable

object Stacks {
  var stack = new mutable.Stack[Int]
  stack.push(1)
  stack.push(2)
  val oldSize: Int = stack.size
  val result: Int = stack.pop()
  val newSize:Int = stack.size
}

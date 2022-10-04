package com.wiley.controlStructures

object ForLoops extends App{

  // A number to another number, this includes the upper boundary
  // In this case 5.
  for(a <-1 to 5){
    print(a)
  }


  // A number until another number, this does not include the upper boundary
  // So this for loop prints until 49
  for(a <-1 until 50){
    println(a)
  }

  //For loop combined with an if statement
  for(a <- 1 to 10 if a%2==0){
    println(a)
  }

  // Yield returns the result of the entire loop after it's completed
  // not the result at every step
  // When the list of results from the iteration is returned after
  // the loop is complete
  // the returned elements are returned in the same data structured
  // in which they were iterated
  // List input == List output
  var result = for(a<-1 to 10) yield a
  for(i<- result){
    println(i)
  }


  // another for loop where you can stiplate the size the
  // the increments at each iteration
  for(i<-1 to 20 by 2){
    println(i)
  }

}

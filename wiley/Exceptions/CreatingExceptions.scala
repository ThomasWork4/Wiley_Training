package com.wiley.Exceptions


//We are creating our own exception call Invalid age exception
//Previously we were using the default exceptions available from java
// Now we are creating our own for custom situations
class InvalidAgeException(s:String) extends Exception{
  //When our exception is thrown, print the error message we have manually provided
  //on line 19
  override def toString: String = super.toString+"---------"+s
}


class ExceptionExample3{
  //Declaring that this method will throw an exception
  //I'm not sure that this is explicitly required
  @throws(classOf[InvalidAgeException])
  def validate(age:Int):Unit = {
    if(age < 18){
      //Now we can force our Invalid age exception that we previously made
      throw new InvalidAgeException("You are below the age requirement")
    }
    else{
      println("You are above the age requirement")
    }
  }
}

object ma extends App{
  var e = new ExceptionExample3()
  try{
    e.validate(15)
  }catch{
        //Catch the exception and print the "Exception occured" message
        //Along with our toString method that we previously defined
    case ex:InvalidAgeException => println("Exception Occured "+ex)
  }
}
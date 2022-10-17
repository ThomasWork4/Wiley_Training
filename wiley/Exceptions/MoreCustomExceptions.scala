package com.wiley.Exceptions

class CheckIntException(s:String) extends Exception{
  override def toString: String = super.toString+"---------"+s
}

class NotEnoughFundsException(s:String) extends Exception {
  override def toString: String = super.toString + "---------" + s
}

class MoreCustomExceptions {

  @throws(classOf[NotEnoughFundsException])
  def buyItem(Item:String, Balance:Int):String = {
    if(Balance < 5){
      throw new NotEnoughFundsException("Unfortunately, you don't have enough money")
    }
    else{
      return "You have bought an "+ Item
    }
  }

  @throws(classOf[CheckIntException])
  def checkInt(Character:Char):String = {
    if(!Character.isDigit){
     throw new CheckIntException("The character you have entered is not a digit")
    }
    else{
      return "Thank you"
    }
  }
}

object maintest5 extends App {
  var obj1 = new MoreCustomExceptions
  //Uncomment either of below to test new custom exceptions
  //obj1.buyItem("Apple", 0)
  //obj1.checkInt('h')
}

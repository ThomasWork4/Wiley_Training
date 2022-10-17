package com.wiley.Inheritance

class CentralBank(private val InterestRate:Int = 2) {
  def showInterestRate():Int = {
    InterestRate
  }
}

class NatwestBank extends CentralBank {
    private val NatwestInterestRate:Int = 3

  override def showInterestRate(): Int = {
    super.showInterestRate()+NatwestInterestRate
  }
}

//In order for a grandchild class to access the parent parent class interest rate only
//In this case central banks 2, we would have to save that instance on it's own in
//The child class natwest bank, and then inherit to through barclays.
//Basically, one class ONLY HAS KNOWLEDGE OF THE CLASS ABOVE IT in the hierarchy
class BarclaysBank extends NatwestBank {
  private val BarclaysInterestRate: Int = 5

  override def showInterestRate(): Int = {
    super.showInterestRate() + BarclaysInterestRate
  }
}


object main extends App {
var CentralBankCustomer = new CentralBank()
  println(CentralBankCustomer.showInterestRate())
  var NatwestBankCustomer = new NatwestBank
  println(NatwestBankCustomer.showInterestRate())
  var BarclaysBankCustomer = new BarclaysBank
  //Should print 10 because we are adding Barclays interest rate 5
  //To Natwest interest rate which is 3 + Central bank interest rate(2)
  println(BarclaysBankCustomer.showInterestRate())
}
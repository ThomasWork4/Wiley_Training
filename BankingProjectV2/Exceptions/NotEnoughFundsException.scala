package BankingProjectV2.Exceptions

//Custom exception called when the user attempts to withdraw funds that they do no have
class NotEnoughFundsException(s:String) extends Exception {
  override def toString: String = super.toString + "-" + s
}
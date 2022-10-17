package BankingProjectV2.Exceptions

//Custom exception invoked when the user attempts to
//withdraw money that they don't have
class NotEnoughFundsException(s:String) extends Exception {
  override def toString: String = super.toString + "-" + s
}
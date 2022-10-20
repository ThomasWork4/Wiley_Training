package BankingProjectV2.Exceptions

//Custom exception called when the user attempts to create an account that they already possess
class TooManyAccountExceptions(s:String) extends Exception {
  override def toString: String = super.toString + "-" + s
}

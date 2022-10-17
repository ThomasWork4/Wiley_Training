package BankingProjectV2.Exceptions

class TooManyAccountExceptions(s:String) extends Exception {
  override def toString: String = super.toString + "-" + s
}

package BankingProjectV2.Exceptions


class NotEnoughFundsException(s:String) extends Exception {
  override def toString: String = super.toString + "-" + s
}
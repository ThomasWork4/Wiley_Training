package BankingProjectV2.Exceptions

class ExistingAccountException(s:String) extends Exception{
  override def toString: String = super.toString + "-" + s
}

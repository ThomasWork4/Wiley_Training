package BankingProjectV2.Exceptions

//Custom exception called when the user attempts to create a new profile that already exists in the SQL database
class ExistingAccountException(s:String) extends Exception{
  override def toString: String = super.toString + "-" + s
}

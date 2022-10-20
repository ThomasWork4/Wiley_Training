package BankingProjectV2.validateInput

//Utility function called when the user wants to validate an integer input
//Note this function has become deprecated in the project due to a single try, catch work around the reusable menu
//that proved much more efficient
object validateInput {
  def isDigits(input: String): Boolean = input.matches("^[0-9]+$")
}

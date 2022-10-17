package BankingProjectV2.Accounts

import BankingProjectV2.Accounts.Account

//Case class for help to buy ISA account extending the Account class, the account type is overriden here
case class HelpToBuyISA(override val AccountType:String) extends Account
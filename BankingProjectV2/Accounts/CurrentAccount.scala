package BankingProjectV2.Accounts

import BankingProjectV2.Accounts.Account

//Case class for current account extending the Account class, the account type is overriden here
case class CurrentAccount(override val AccountType:String) extends Account
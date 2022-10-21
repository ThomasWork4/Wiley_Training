package ProjectTesting.funSuite

import BankingProjectV2.Accounts.SavingsAccount
import BankingProjectV2.CreditCard.CreditCard
import BankingProjectV2.Profile.Profile
import BankingProjectV2.{CreditCard, Profile}
import org.scalatest.funsuite.AnyFunSuite
import BankingProjectV2.SQL_Account_Storage.DoesAccountExist
import BankingProjectV2.Exceptions.{TooManyAccountExceptions,NotEnoughFundsException,ExistingAccountException}
class projectUnitTest extends AnyFunSuite{
  var testCustomer = new Profile("HelloHello")

  test("TestingDeposits"){
    testCustomer.currentAccount.AccountBalance += 1000
    assert(testCustomer.currentAccount.AccountBalance == 1000)
  }

  test("TestingWithdrawals"){
    testCustomer.currentAccount.AccountBalance -= 500
    assert(testCustomer.currentAccount.AccountBalance == 500)
  }

  test("AddNewAccount"){
    testCustomer.accountPortfolio += new SavingsAccount("Savings Account")
    assert(testCustomer.accountPortfolio.size === 2)
  }

  test("CheckAddedAccount"){
    assert(testCustomer.accountPortfolio(1).AccountType === "Savings Account")
  }
  var cCard = new CreditCard(0, "Basic credit card", 2000, 16)
  test("Order new credit card"){
    testCustomer.accountPortfolio(1).creditCards += cCard
    assert(testCustomer.accountPortfolio(1).creditCards.size === 1)
  }
  var testObj = new DoesAccountExist
  test("Check that an account exists in the database"){
    var testObj = new DoesAccountExist
    assert(testObj.Check("Thomas", "Sadler") === true)
  }
  test("Check that an account account does not exist in the database"){
    assert(testObj.Check("srofseunfse", "Saaefaedler") === false)
  }
  test("Increasing the a cards interest rate"){
    cCard.interestRate += 2
    assert(cCard.interestRate === 18)
  }
  test("Withdrawing from a credit card"){
    cCard.ccBalance -= 1000
    assert(cCard.ccBalance.abs === 1000)
  }
  test("Check ExistingAccountException is functional"){
    assertThrows[ExistingAccountException](throw new ExistingAccountException("Exception thrown"))
  }
  test("Check TooManyAccountsException is functional"){
    assertThrows[TooManyAccountExceptions](throw new TooManyAccountExceptions("Exception thrown"))
  }
  test("Check NotEnoughFundsException is functional"){
    assertThrows[NotEnoughFundsException](throw new NotEnoughFundsException("Exception thrown"))
  }

}

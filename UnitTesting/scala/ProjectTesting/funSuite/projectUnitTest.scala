//package ProjectTesting.funSuite
//
//import BankingProject.{CreditCard, InstanceOptions, SavingsAccount}
//import org.scalatest.funsuite.AnyFunSuite
//
//
//class projectUnitTest extends AnyFunSuite{
//  var testCustomer = new InstanceOptions("HelloHello")
//
//  test("TestingDeposits"){
//    testCustomer.currentAccount.AccountBalance += 1000
//    assert(testCustomer.currentAccount.AccountBalance == 1000)
//  }
//
//  test("TestingWithdrawals"){
//    testCustomer.currentAccount.AccountBalance -= 500
//    assert(testCustomer.currentAccount.AccountBalance == 500)
//  }
//
//  //NotEnoughFundsException only gets thrown as a result of the user input
////  test("NotEnoughFundsToWithdraw"){
////    assertThrows[NotEnoughFundsException]{
////      testCustomer.currentAccount.AccountBalance -= 1000000
////      println(testCustomer.currentAccount.AccountBalance)
////    }
////  }
//
//  test("AddNewAccount"){
//    testCustomer.innerAccounts += new SavingsAccount("Savings Account")
//    assert(testCustomer.innerAccounts.size === 2)
//  }
//
//  test("CheckAddedAccount"){
//    assert(testCustomer.innerAccounts(1).AccountType === "Savings Account")
//  }
//
//  test("Order new credit card"){
//    testCustomer.creditAccount.creditCards += new CreditCard(2000, "Basic credit card", 2000, 16)
//    assert(testCustomer.creditAccount.creditCards.size === 1)
//  }
//}

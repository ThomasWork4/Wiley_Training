//package ProjectTesting.flatSpec
//
//import org.scalatest.flatspec.AnyFlatSpec
//import BankingProject.{CreditCard, InstanceOptions, SavingsAccount}
//
//class ProjectTestingFlatSpec extends AnyFlatSpec{
//
//  var testCustomer = new InstanceOptions("HelloHello")
//
//  "New balance" should "be 1000 pounds after deposit" in {
//    testCustomer.currentAccount.AccountBalance += 1000
//    assert(testCustomer.currentAccount.AccountBalance == 1000)
//  }
//
//  "New balance" should "be 500 pounds after withdrawal" in {
//    testCustomer.currentAccount.AccountBalance -= 500
//    assert(testCustomer.currentAccount.AccountBalance == 500)
//  }
//
//  //NotEnoughFundsException only gets thrown as a result of the user input
//  //  test("NotEnoughFundsToWithdraw"){
//  //    assertThrows[NotEnoughFundsException]{
//  //      testCustomer.currentAccount.AccountBalance -= 1000000
//  //      println(testCustomer.currentAccount.AccountBalance)
//  //    }
//  //  }
//
//  "Size of account portfolio" should "be 2 after adding a savings account" in {
//    testCustomer.innerAccounts += new SavingsAccount("Savings Account")
//    assert(testCustomer.innerAccounts.size === 2)
//  }
//
//  "Account of account at index 1 inside account portfolio" should "be Savings Account" in {
//    assert(testCustomer.innerAccounts(1).AccountType === "Savings Account")
//  }
//
//  "Size of the customers credit card portfolio" should "be 1 after adding a new Basic Credit card" in {
//    testCustomer.creditAccount.creditCards += new CreditCard(2000, "Basic credit card", 2000, 16)
//    assert(testCustomer.creditAccount.creditCards.size === 1)
//  }
//
//}

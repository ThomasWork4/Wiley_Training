//package ProjectTesting.funSpec
//
//import BankingProject.{CreditCard, InstanceOptions, SavingsAccount}
//import org.scalatest.funspec.AnyFunSpec
//
//class ProjectTestingFunSpec extends AnyFunSpec{
//
//    var testCustomer = new InstanceOptions("HelloHello")
//
//    it("New balance should be 1000 after deposit"){
//      testCustomer.currentAccount.AccountBalance += 1000
//      assert(testCustomer.currentAccount.AccountBalance == 1000)
//    }
//
//    it("New balance should be 500 after withdrawal"){
//      testCustomer.currentAccount.AccountBalance -= 500
//      assert(testCustomer.currentAccount.AccountBalance == 500)
//    }
//
//    //NotEnoughFundsException only gets thrown as a result of the user input
//    //  test("NotEnoughFundsToWithdraw"){
//    //    assertThrows[NotEnoughFundsException]{
//    //      testCustomer.currentAccount.AccountBalance -= 1000000
//    //      println(testCustomer.currentAccount.AccountBalance)
//    //    }
//    //  }
//
//    it("Size of account portfolio should be 2 after adding a savings account"){
//      testCustomer.innerAccounts += new SavingsAccount("Savings Account")
//      assert(testCustomer.innerAccounts.size === 2)
//    }
//
//    it("The account at index 1 in the portfolio should be of type Savings Account"){
//      assert(testCustomer.innerAccounts(1).AccountType === "Savings Account")
//    }
//
//    it("Size of the customers credit card portfolio should be 1 after adding a new Basic Credit card"){
//      testCustomer.creditAccount.creditCards += new CreditCard(2000, "Basic credit card", 2000, 16)
//      assert(testCustomer.creditAccount.creditCards.size === 1)
//    }
//  }

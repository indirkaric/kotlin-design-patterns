import command.CalculateLoanRate
import command.invoker.LoanProcessorCommandExecutor
import command.receiver.LoanCalculator
import command.receiver.LoanProcessor
import enum.LoanType
import factory.LoanFactory
import request.CalculateLoanRequest
import request.CreateLoanRequest
import singleton.AppConfig

fun main(args: Array<String>) {

    val createLoanRequest = CreateLoanRequest(loanType = LoanType.LONG, amount = 100000, years = 15)
    val loan = LoanFactory.createLoan(createLoanRequest)

    println("Start date: " + loan.startDate)
    println("End date: " + loan.endDate)
    println("Returning amount: " + loan.returningAmount)
    println("Rate per month: " + loan.ratePerMonth)
    println("Rate percentage: " + loan.ratePercentage)

    AppConfig.getConfiguration()

    val calculateLoanRequest = CalculateLoanRequest(months = 36, loanType = LoanType.LONG, amount = 234.toDouble())
    val loanProcessor: LoanProcessor = LoanCalculator(calculateLoanRequest)
    val calculateLoanRate = CalculateLoanRate(loanProcessor)
    val loanProcessorCommandExecutor = LoanProcessorCommandExecutor(calculateLoanRate)
    loanProcessorCommandExecutor.execute()
    val loanCalculator: LoanCalculator = loanProcessor as LoanCalculator
    loanCalculator.loanRatesDtoList.forEach { println(it.month) }
}
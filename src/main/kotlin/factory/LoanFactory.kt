package factory

import enum.LoanType
import model.Loan
import model.LongTermLoan
import model.MediumTermLoan
import model.ShortTermLoan
import request.CreateLoanRequest

class LoanFactory {
    companion object {
        fun createLoan(createLoanRequest: CreateLoanRequest): Loan {
            return when(createLoanRequest.loanType) {
                LoanType.SHORT -> ShortTermLoan(createLoanRequest)
                LoanType.MEDIUM -> MediumTermLoan(createLoanRequest)
                LoanType.LONG -> LongTermLoan(createLoanRequest)
            }
        }
    }
}
package request

import enum.LoanType

class CreateLoanRequest (
    val loanType: LoanType,
    val years: Int,
    val amount: Int
)
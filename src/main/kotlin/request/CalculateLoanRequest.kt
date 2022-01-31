package request

import enum.LoanType

class CalculateLoanRequest (
    val months: Int? = null ,
    val amount: Double? = null,
    val loanType: LoanType? = null
)
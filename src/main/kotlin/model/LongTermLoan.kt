package model

import request.CreateLoanRequest
import util.DateUtil

class LongTermLoan(createLoanRequest: CreateLoanRequest) : Loan(createLoanRequest) {
    init {
        calculateRates()
        calculateDates()
    }

    override fun calculateRates() {
        ratePercentage = 5
        months = createLoanRequest.years * 12
        val amountPerMonthWithoutRate = createLoanRequest.amount / months!!
        ratePerMonth = (((ratePercentage!! / amountPerMonthWithoutRate) * 100) + amountPerMonthWithoutRate) as Int
        returningAmount = months!! * ratePerMonth!!
    }

    override fun calculateDates() {
        endDate = DateUtil.calculateEndDate(startDate, createLoanRequest.years)
    }
}
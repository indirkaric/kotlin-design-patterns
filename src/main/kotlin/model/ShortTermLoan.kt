package model

import request.CreateLoanRequest
import util.DateUtil

class ShortTermLoan(createLoanRequest: CreateLoanRequest) : Loan(createLoanRequest) {
    init {
        calculateRates()
        calculateDates()
    }

    override fun calculateRates() {
        ratePercentage = 6
        months = createLoanRequest.years * 12
        val amountPerMonthWithoutRate = createLoanRequest.amount / months!!
        val amountPerMonth = (((ratePercentage!! / amountPerMonthWithoutRate) * 100) + amountPerMonthWithoutRate) as Int
        returningAmount = months!! * amountPerMonth
    }

    override fun calculateDates() {
        endDate = DateUtil.calculateEndDate(startDate, createLoanRequest.years)
    }
}
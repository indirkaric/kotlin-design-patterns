package model

import request.CreateLoanRequest
import java.util.*

abstract class Loan(val createLoanRequest: CreateLoanRequest) {
    var startDate: Date = Date()
    var endDate: Date? = null
    var months: Int? = null
    var ratePercentage: Int? = null
    var ratePerMonth: Int? = null
    var returningAmount: Int? = null
    abstract fun calculateRates()
    abstract fun calculateDates()
}
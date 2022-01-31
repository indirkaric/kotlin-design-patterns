package command.receiver

import request.CalculateLoanRequest
import response.LoanMonthlyRateDto


class LoanCalculator(val calculateLoanRequest: CalculateLoanRequest) : LoanProcessor {
    val loanRatesDtoList: MutableList<LoanMonthlyRateDto> = mutableListOf()

    init {
        startProcess()
    }
    override fun startProcess() {
        for (i in 1..calculateLoanRequest.months!!) {
            val rate = Math.round(((calculateLoanRequest.months / calculateLoanRequest.months) * 100).toDouble()) / 100;
            val loanMonthlyRateDto = LoanMonthlyRateDto()
            loanMonthlyRateDto.rate = (rate * 1.2)
            loanMonthlyRateDto.month = i
            loanRatesDtoList.add(loanMonthlyRateDto)
        }
    }
}
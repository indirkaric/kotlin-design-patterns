package command

import command.receiver.LoanProcessor

class CalculateLoanRate(private val loanProcessor: LoanProcessor) : Command {
    override fun execute() {
        loanProcessor?.startProcess()
    }
}
package command.invoker

import command.Command


class LoanProcessorCommandExecutor(private val command: Command) {
    fun execute() {
        command!!.execute()
    }
}
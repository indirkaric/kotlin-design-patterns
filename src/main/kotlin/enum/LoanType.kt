package enum

enum class LoanType (val id: Long, val description: String) {
    SHORT(1, "Short term loan"),
    MEDIUM(2, "Medium term loan"),
    LONG(3, "Long term loan")
}
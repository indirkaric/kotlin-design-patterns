package util

import java.util.*

class DateUtil {
    companion object {
        fun calculateEndDate(startDate: Date, years: Int): Date {
            val calendar = Calendar.getInstance()
            startDate.also { calendar.time = it }
            calendar.add(Calendar.YEAR, years)
            return calendar.time
        }
    }
}
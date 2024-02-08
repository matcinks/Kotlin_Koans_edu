import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
    this.addTimeIntervals(timeInterval, 1)

class MultipliedTimeIntervals(val timeInterval: TimeInterval, val multiplier: Int)

operator fun TimeInterval.times(number: Int) =
    MultipliedTimeIntervals(this, number)

operator fun MyDate.plus(timeIntervals: MultipliedTimeIntervals): MyDate =
    this.addTimeIntervals(timeIntervals.timeInterval, timeIntervals.multiplier)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

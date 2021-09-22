package `4kyu`

import junit.framework.Assert.assertEquals
import org.junit.Test

object TimeFormatter {
    fun formatDuration(seconds: Int): String {
        if (seconds < 0) {
            return "Invalid"
        }
        else if (seconds == 0) {
            return "now"
        }
        else {
            return getTimeUnits(seconds)
        }
    }
}

fun getTimeUnits(seconds: Int): String {
    val durationArray = getDuration(seconds)
    val stringArray = ArrayList<String>()
    var myString = ""

    if(durationArray[0] == 1) {
        stringArray += "${durationArray[0]} year"
    }else if(durationArray[0] > 1) {
        stringArray += "${durationArray[0]} years"
    }
    if(durationArray[1] == 1) {
        stringArray += "${durationArray[1]} day"

    }else if(durationArray[1] > 1) {
        stringArray += "${durationArray[1]} days"
    }
    if(durationArray[2] == 1) {
        stringArray += "${durationArray[2]} hour"
    }else if(durationArray[2] > 1) {
        stringArray += "${durationArray[2]} hours"
    }
    if(durationArray[3] == 1) {
        stringArray += "${durationArray[3]} minute"
    }else if(durationArray[3] > 1) {
        stringArray += "${durationArray[3]} minutes"
    }
    if(durationArray[4] == 1) {
        stringArray += "${durationArray[4]} second"
    }else if(durationArray[4] > 1) {
        stringArray += "${durationArray[4]} seconds"
    }
    if (stringArray.size == 1) {
        myString += stringArray.joinToString("")
    }else if (stringArray.size == 2) {
        myString += stringArray.joinToString(" and ")
    }else {
        myString += stringArray.subList(0, stringArray.lastIndex).joinToString(", ") + " and ${stringArray.last()}"

    }
    return myString
}

fun getDuration (seconds: Int): IntArray {
    val secondsInYears = 60 * 60 * 24 * 365
    val secondsInDays = 60 * 60 * 24
    val secondsInHours = 60 * 60
    val secondsInMinutes = 60
    var years = 0
    var days = 0
    var hours = 0
    var minutes = 0
    var secondsRemain = seconds

    if(secondsRemain >= secondsInYears) {
        years = secondsRemain/secondsInYears
        secondsRemain -= secondsInYears * years
    }
    if(secondsRemain >= secondsInDays) {
        days = secondsRemain/secondsInDays
        secondsRemain -= secondsInDays * days
    }
    if(secondsRemain >= secondsInHours) {
        hours = secondsRemain/secondsInHours
        secondsRemain -= secondsInHours * hours
    }
    if (secondsRemain >= secondsInMinutes){
        minutes = secondsRemain/secondsInMinutes
        secondsRemain -= secondsInMinutes * minutes
    }
    return intArrayOf(years, days, hours, minutes, secondsRemain)
}

class TimeFormatterTest {
    @Test
    fun testFormatDurationExamples() {
        // Example Test Cases
        assertEquals("1 second", TimeFormatter.formatDuration(1))
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62))
        assertEquals("2 minutes", TimeFormatter.formatDuration(120))
        assertEquals("1 hour", TimeFormatter.formatDuration(3600))
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662))
    }
}
package my.timer.hoursoldv2


import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.NumberFormat
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class Utils(private val context: Context) {


    // Function to generate a Toast
    fun showToast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateHours(day: String, month : String, year : String){

        try{
            val birthDayInt   =   day.toInt()
            val birthMonthInt =   month.toInt()
            val birthYearInt  =   year.toInt()


            val currentDate = LocalDate.now()
            val cday: Int = currentDate.dayOfMonth
            val cmonth: Int = currentDate.monthValue
            val cyear: Int = currentDate.year



            val currentTime = LocalTime.now()
            val hour: Int = currentTime.hour



            val startDate = LocalDate.of(birthYearInt, birthMonthInt,birthDayInt )
            val startTime = LocalTime.of(12, 0)

            val endDate = LocalDate.of(cyear, cmonth, cday)
            val endTime = LocalTime.of(hour, 0)

            val startDateTime = startDate.atTime(startTime)
            val endDateTime = endDate.atTime(endTime)


            val duration = Duration.between(startDateTime, endDateTime)
            val hoursElapsed = duration.toHours()

            if(hoursElapsed < 0){
                throw Exception()
            }

            val formattedNumber = NumberFormat.getNumberInstance(Locale.US).format(hoursElapsed)
            showToast(context, "You are around ${formattedNumber} hours old ")

        }catch (e: Exception) {
            showToast(context, "Make sure you are entering correct values" )
        }



    }

}
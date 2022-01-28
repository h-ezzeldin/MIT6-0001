import kotlin.math.abs

fun main(args: Array<String>) {
    biSectionSearch(150000f)
    biSectionSearch(300000f)
    biSectionSearch(10000f)
}


private fun calculate(annual_salary: Float, portion_saved: Float): Float {

    var currentSavings = 0.0f
    var currentAnnSalary = annual_salary
    //var months = 0
    for (months in 0..35){
        if (months % 6 == 0 && months > 0) currentAnnSalary += currentAnnSalary * 0.07f
        currentSavings += (currentSavings * 0.04f) / 12 + currentAnnSalary / 12 * portion_saved

    }
    return currentSavings

}

private fun biSectionSearch(starting_salary: Float) {
    val annualSalary = starting_salary
    var low = 0
    var high = 10000
    var mid: Int = (low + high) / 2
    val downPayment = 250000.0f
    //var current_savings = 0.0f
    var steps = 0
    while (true) {
        //println(mid / 10000.0f)
        steps += 1
        val currentSavings = calculate(annualSalary, (mid / 10000.0f))
        //println("cur sav = $current_savings rate = ${mid / 10000.0f}")
        //println(current_savings)
        if (abs(currentSavings - downPayment) < 100.0f) {
            println("Best savings rate: ${mid / 10000.0f}")
            println("Steps in bisection search: $steps" )
            break
        } else if (low == high) {
            println("It is not possible to pay the down payment in three years.")
            break
        }
        if (currentSavings < downPayment) {
            low = mid + 1
        } else {
            high = mid - 1
        }
        mid = (low + high) / 2
    }
}


fun main(args: Array<String>) {
    val case1 = calculate(120000f, 0.10f, 1000000f)
    val case2 = calculate( 80000f, 0.15f, 500000f)

    println("Test Case 1 = $case1")
    println("Test Case 2 = $case2")
}

private fun calculate(
    annualSalary: Float,
    portionSaved: Float,
    totalCost: Float,
): Int{
    var currentSavings = 0.0
    val monthlySalary = annualSalary / 12
    val monthlySaved = monthlySalary * portionSaved
    var months = 0
    while ( currentSavings <= totalCost * 0.25) {
        currentSavings += ((currentSavings * 0.04) / 12) + monthlySaved
        months += 1
    }
    return months

}

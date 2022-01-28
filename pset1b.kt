fun main(args: Array<String>) {
    val case1 = calculate(120000f, 0.05f, 500000f, 0.03f)
    val case2 = calculate(80000f, 0.1f, 800000f, 0.03f)
    val case3 = calculate(75000f, 0.05f, 1500000f, 0.05f)

    println("Test Case 1 = $case1")
    println("Test Case 2 = $case2")
    println("Test Case 2 = $case3")
}

private fun calculate(
    annualSalary: Float,
    portionSaved: Float,
    totalCost: Float,
    semiAnnualRaise: Float
): Int {
    var currentSavings = 0.0
    var currentAnnSalary = annualSalary
    var months = 0
    while (currentSavings <= totalCost * 0.25) {
        if (months % 6 == 0 && months > 0) currentAnnSalary += currentAnnSalary * semiAnnualRaise
        currentSavings += currentSavings * 0.04 / 12 + currentAnnSalary / 12 * portionSaved
        months += 1
    }
    return months

}

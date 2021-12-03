package com.example.codequality

class SumMultiples {
    /*
     * ***********************************************************************************************************************************
     * Problem description
     *
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     * ***********************************************************************************************************************************
     */

    fun sumMultiplesOfThreeAndFive(upperBound: Int, multiplesToBeSummed: MutableList<Int>): Int {
        return try {
            val numbers = IntRange(1, upperBound - 1).toList()
            doCalculation(numbers, multiplesToBeSummed)
        } catch (ex: Exception) {
            0
        }
    }

    // Handle the case that the input is a string
    fun sumMultiplesOfThreeAndFive(upperBound: String, multiplesToBeSummed: MutableList<Int>): Int {
        return try {
            val numbers = IntRange(1, upperBound.size - 1).toList()
            doCalculation(numbers, multiplesToBeSummed)
        } catch (ex: Exception) {
            0
        }
    }

    private fun doCalculation(numbers: List<Int>, multiplesToBeSummed: MutableList<Int>): Int {
        // Loop through each of the numbers in numbers, and for each we find that
        // is divisible by 3 or 5, we will update sum. At the end of all this we return
        // that sum to solve the problem above
        for (n in numbers) {
            if ( n isDivisibleBy 3 ) {
                multiplesToBeSummed.accumulate(n)
            }
            if ( n isDivisibleBy 5 ) {
                multiplesToBeSummed.accumulate(n)
            }
        }

        return multiplesToBeSummed.sum()
    }
}



// Helpers
// --------
infix fun Int.isDivisibleBy(x: Int): Boolean = this % x == 0

val String.size
    get() = this.length

fun MutableList<Int>.accumulate(x: Int): Int {
    this.add(x)
    return this.sum()
}
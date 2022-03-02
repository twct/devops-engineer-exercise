package me.swaminathan.swordle

import org.junit.Assert.*
import org.junit.Test

typealias GR = GameViewModel.GuessResult

internal class GameViewModelTest {

    @Test
    fun submitGuess() {
        data class Test(
            val word: String,
            val guess: String,
            val raises: Boolean,
            val guesses: List<CharArray>,
            val results: List<Array<GR>>
        )

        val tests = listOf(
            Test("realm", "realm", true, emptyList(), emptyList()),
            Test(
                "realm",
                "raise",
                false,
                listOf("raise".toCharArray()),
                listOf(
                    listOf(
                        GR.Correct,
                        GR.InWord,
                        GR.Incorrect,
                        GR.Incorrect,
                        GR.InWord
                    ).toTypedArray()
                )
            )
        )

        val vm = GameViewModel("realm".toCharArray())

        tests.forEach { test ->
            try {
                vm.submitGuess(test.guess.toCharArray())
            } catch (e: Throwable) {
                if (!test.raises) {
                    fail("unexpected exception: ${e.message}")
                }
            }
            assertArrayEquals(
                "guesses don't match. got ${vm.guesses.map { it.concatToString() }}, want ${test.guesses.map { it.concatToString() }}",
                test.guesses.toTypedArray(),
                vm.guesses.toTypedArray()
            )
            assertArrayEquals(
                "results don't match. got ${test.results}, want ${vm.results}",
                test.results.toTypedArray(),
                vm.results.toTypedArray()
            )
        }
    }
}

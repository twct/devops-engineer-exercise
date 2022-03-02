package me.swaminathan.swordle

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class GameViewModel(val word: CharArray, val size: Int = 5) : ViewModel() {
    private val charsInWord = word.toSet()

    init {
        if (word.size != size) throw RuntimeException("Invalid word")
    }

    internal val guesses = mutableListOf<CharArray>()
    internal val results = mutableListOf<Array<GuessResult>>()

    fun submitGuess(guess: CharArray) {
        if (guess.size != size) throw Exception("invalid guess: $guess for word size: $size")
        if (guess.contentEquals(word)) {
            TODO("need to implement win condition")
        }
        val colors = guess.zip(word).map { (guessed, actual) ->
            when {
                guessed == actual -> GuessResult.Correct
                charsInWord.contains(guessed) -> GuessResult.InWord
                else -> GuessResult.Incorrect
            }
        }
        guesses.add(guess)
        results.add(colors.toTypedArray())
    }

    enum class GuessResult {
        Incorrect, InWord, Correct;

        fun color(): Color = when (this) {
            Incorrect -> Color.Gray
            InWord -> Color.Yellow
            Correct -> Color.Green
        }
    }
}
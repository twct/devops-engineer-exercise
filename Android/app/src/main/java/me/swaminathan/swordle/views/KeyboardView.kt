package me.swaminathan.swordle.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KeyboardView(
    onLetterClick: ((Char) -> Unit)? = null,
    onDelete: (() -> Unit)? = null,
    onSubmit: (() -> Unit)? = null,
) {
    val rows = listOf(
        "QWERTYUIOP".map {
            Character(it, 1f) { onLetterClick?.invoke(it) }
        },
        "ASDFGHJKL".map {
            Character(it, 1f) { onLetterClick?.invoke(it) }
        },
        listOf(Character('⏎', 1.25f) { onSubmit?.invoke() })
            .plus("ZXCVBNM".map {
                Character(it, 1f) { onLetterClick?.invoke(it) }
            }).plusElement(Character('⌫', 1.25f) { onDelete?.invoke() })
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        rows.map { row ->
            val maxWidth = row.sumOf { it.weight.toDouble() } / 10
            Row(
                horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterHorizontally),
                modifier = Modifier.fillMaxWidth(maxWidth.toFloat()),
            ) {
                row.map {
                    @Suppress("UNCHECKED_CAST")
                    KeyView(
                        letter = it.char,
                        modifier = Modifier.weight(it.weight),
                        onClick = it.onClick
                    )
                }
            }
        }
    }
}

data class Character(val char: Char, val weight: Float, val onClick: () -> Unit)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KeyboardPreview() {
    KeyboardView()
}
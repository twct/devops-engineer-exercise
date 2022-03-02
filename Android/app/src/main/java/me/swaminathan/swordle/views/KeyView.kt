package me.swaminathan.swordle.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.onEach

@Composable
fun KeyView(letter: Char, modifier: Modifier = Modifier, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = modifier.background(color = Color.LightGray, shape = RoundedCornerShape(8.dp)),
        interactionSource = remember {
            MutableInteractionSource().apply {
                interactions.onEach {
                    when (it) {
                        is PressInteraction.Press -> {} // TODO set color
                        is PressInteraction.Release -> {} // TODO reset color
                        is PressInteraction.Cancel -> {} // TODO reset color
                        else -> {}
                    }
                }
            }
        }
    ) {
        Text(
            text = letter.toString(),
            style = TextStyle(color = Color.Black),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KeyViewPreview() {
    KeyView(letter = 'A') {}
}
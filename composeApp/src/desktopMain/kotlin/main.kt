import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.ChartBar
import compose.icons.fontawesomeicons.regular.Clock
import compose.icons.fontawesomeicons.regular.User
import compose.icons.fontawesomeicons.solid.Bell
import compose.icons.fontawesomeicons.solid.SearchDollar

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KmpBottomBar") {
        App()
    }
}

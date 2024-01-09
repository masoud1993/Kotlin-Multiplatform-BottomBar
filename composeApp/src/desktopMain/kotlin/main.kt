import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.icons.AllIcons
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.ChartBar
import compose.icons.fontawesomeicons.regular.Clock
import compose.icons.fontawesomeicons.regular.Newspaper
import compose.icons.fontawesomeicons.regular.User
import compose.icons.fontawesomeicons.solid.Bell
import compose.icons.fontawesomeicons.solid.SearchDollar
import org.jetbrains.compose.resources.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KmpBottomBar") {
        //App()
        BottomBar()
    }
}

@Preview
@Composable
fun BottomBar(){
    val brush = Brush.verticalGradient(listOf(Color(0xff6e7587), Color(0xff4a546a)))

    var selectedKey by remember {
        mutableStateOf(0)   
    }
    Card(modifier = Modifier
        .padding(50.dp)
        .fillMaxWidth()
        .height(70.dp),
        elevation = 20.dp,
        shape = RoundedCornerShape(25.dp),
        
    ) {
            Row(Modifier
                .background(brush)
                .fillMaxWidth()
                .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                
                BottomBarItem(0, FontAwesomeIcons.Regular.ChartBar, selectedKey){
                    selectedKey = 0
                }
                    BottomBarItem(1, FontAwesomeIcons.Solid.SearchDollar, selectedKey){
                        selectedKey = 1
                    }
                    BottomBarItem(2, FontAwesomeIcons.Regular.Clock, selectedKey){
                        selectedKey = 2
                    }
                    BottomBarItem(3, FontAwesomeIcons.Solid.Bell, selectedKey){
                        selectedKey = 3
                    }
                    BottomBarItem(4, FontAwesomeIcons.Regular.User, selectedKey){
                        selectedKey = 4
                    } 
            }
    }
}
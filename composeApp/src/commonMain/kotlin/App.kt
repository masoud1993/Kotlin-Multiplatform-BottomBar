import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.ChartBar
import compose.icons.fontawesomeicons.regular.Clock
import compose.icons.fontawesomeicons.regular.User
import compose.icons.fontawesomeicons.solid.Bell
import compose.icons.fontawesomeicons.solid.SearchDollar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            BottomBar()
        }
    }
}

@Composable
fun BottomBar() {
    var selectedKey by remember {
        mutableStateOf(0)
    }

    val brush = Brush.verticalGradient(listOf(Color(0xff6e7587), Color(0xff4a546a)))

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
                selectedKey = it
            }
                BottomBarItem(1, FontAwesomeIcons.Solid.SearchDollar, selectedKey){
                    selectedKey = it
                }
                BottomBarItem(2, FontAwesomeIcons.Regular.Clock, selectedKey){
                    selectedKey = it
                }
                BottomBarItem(3, FontAwesomeIcons.Solid.Bell, selectedKey){
                    selectedKey =  it
                }
                BottomBarItem(4, FontAwesomeIcons.Regular.User, selectedKey){
                    selectedKey =  it
                }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
 fun BottomBarItem(key: Int, icon:ImageVector, selectedKey : Int, onClick: (Int) -> Unit){
     val brush = Brush.verticalGradient(listOf(Color(0xff93bdfc), Color(0xff5297ff)))

    val selected = (key == selectedKey)

    Column(modifier = Modifier
        .clickable {
            onClick(key)
        }
        .padding(5.dp)
        .fillMaxHeight(),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .background(brush, shape = RoundedCornerShape(10.dp))
            .width(if(selected) 20.dp else 0.dp)
            .height(4.dp))

               Icon(icon,
                    null,
                   tint = if (selected) Color.White else Color.LightGray,
                   modifier = Modifier.size(35.dp).padding(top = 12.dp))
              

    }
}
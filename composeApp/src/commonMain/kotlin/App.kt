import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
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

@Composable
fun App() {
    MaterialTheme {

        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom) {
            BottomBar()
        }
    }
}

@Composable
fun BottomBar() {
    var selectedKey by remember {
        mutableStateOf(0)
    }

    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState {
            _, offsetChange, _ ->
        offset += offsetChange
    }

    val brush = Brush.verticalGradient(listOf(Color(0xff6e7587), Color(0xff4a546a)))

    Card(modifier = Modifier
        .graphicsLayer(
            translationX = offset.x,
            translationY = offset.y
        )
        .transformable(state = state)
        .padding(25.dp)
        .fillMaxWidth()
        .height(75.dp),
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

@Composable
 fun BottomBarItem(key: Int, icon:ImageVector, selectedKey : Int, onClick: (Int) -> Unit){
     val brush = Brush.verticalGradient(listOf(Color(0xff93bdfc), Color(0xff5297ff)))
    val selected = (key == selectedKey)

    val tintAnimation by animateColorAsState(if (selected) Color.White else Color.LightGray)

    val springAnimation by animateDpAsState(if(selected) 20.dp else 0.dp,
        animationSpec = if (selected) spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMediumLow
        ) else spring(visibilityThreshold = Dp.VisibilityThreshold)
    )

    val iconSizeAnimation by animateDpAsState(if(selected) 40.dp else 35.dp)

    Column(modifier = Modifier
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onClick(key)
        }
        .padding(5.dp)
        .fillMaxHeight(),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .background(brush, shape = RoundedCornerShape(10.dp))
            .width(springAnimation)
            .height(4.dp))

               Icon(icon,
                    null,
                   tint = tintAnimation,
                   modifier = Modifier.size(iconSizeAnimation).padding(top = 12.dp))
    }
}
package com.example.pizzaanimation.ui.home_screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pizzaanimation.R


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeScreenContent(viewModel: HomeViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsState()
    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = Color.White), contentAlignment = Alignment.TopStart
    ) {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_arrow_back_ios),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = 24.dp, y = 45.dp)
                        .width(30.dp)
                        .height(30.dp),
                    tint = Color.Black,

                    )
                Text(
                    modifier = Modifier
                        .offset(x = 0.dp, y = 45.dp)
                        .padding(start = 150.dp)
                        .wrapContentSize()
                        .wrapContentHeight(),
                    text = "Pizza",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_fav),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 128.dp)
                        .offset(x = 0.dp, y = 45.dp)
                        .width(30.dp)
                        .height(30.dp),
                    tint = Color.Black,

                    )
            }


        }

        Box(
            modifier = Modifier.padding(top = 70.dp), contentAlignment = Alignment.Center,
        ) {
            Image(

                painter = painterResource(id = R.drawable.plate),
                contentDescription = null,
                contentScale = ContentScale.FillBounds, modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
                    .background(color = Color.White)
            )


            var expanded by remember { mutableStateOf(false) }
            var selectedChip by remember { mutableStateOf("") }



            HorizontalPager(
                pageCount = state.value.bread.size,
                state = pagerState,
                modifier = Modifier
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) { index ->
                Box(contentAlignment = Alignment.Center)
                {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(state.value.bread[index].image)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(getImageSize(selectedChip))
                            .clickable { },
                        contentScale = ContentScale.FillBounds,
                    )
                    for (item in state.value.bread[index].Ingredient) {
                        ExpandableImages(
                            expandedImages = item.component, isSelected = item.isSelected
                        )
                    }

                }


            }

            Box(  modifier = Modifier.fillMaxWidth().wrapContentSize()) {
                SuggestionChipLayout(selectedChip) { chip ->
                    selectedChip = chip
                    expanded = !expanded
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = 330.dp)
                    .wrapContentSize()
                    .wrapContentHeight(),
                text = "17$",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                )
            )


        }
    }





    ComponentScreen(
        state.value.bread[pagerState.currentPage].Ingredient,
        onCLickImage = { viewModel.onClickImage(it, pagerState.currentPage) })




    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(Color.Black),
        modifier = Modifier
            .padding(top = 700.dp, start = 80.dp)
            .width(250.dp)
            .height(67.dp)
            .background(
                color = Color.Black,
                shape = RoundedCornerShape(size = 12.dp)

            ),
    ) {
        Row {
            Icon(
                modifier = Modifier.padding(PaddingValues(horizontal = 16.dp)),
                painter = painterResource(id = R.drawable.card),
                contentDescription = null,
            )
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight(),
                text = "Add to Cart",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    fontWeight = FontWeight(600),
                    color = Color.White,
                )
            )
        }
    }

}



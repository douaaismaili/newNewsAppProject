package com.douaamohamed.newsapp.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.douaamohamed.newsapp.data.database.entity.Article
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun NewsLayout(
    newsList: List<Article>,
    articleClicked: (Article) -> Unit
) {
    LazyColumn {
        items(newsList) {
            Article(
                article = it,
                onItemClick = { article ->
                    articleClicked(article)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsLayoutWithDelete(
    newsList: List<Article>,
    articleClicked: (Article) -> Unit,
    deleteArticle: (Article) -> Unit
) {
    var hasShownDemo by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (!hasShownDemo) {
            delay(500)
            hasShownDemo = true
        }
    }

    LazyColumn {
        itemsIndexed(
            items = newsList,
            key = { index, article -> article.url!! }
        ) { index, article ->
            val offsetX = remember { Animatable(0f) }

            LaunchedEffect(hasShownDemo) {
                if (hasShownDemo && index == 0) {
                    offsetX.animateTo(
                        targetValue = -100f,
                        animationSpec = tween(durationMillis = 400)
                    )
                    delay(200)
                    offsetX.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(durationMillis = 400)
                    )
                }
            }

            // Tout ce qui est lié à Material3 est couvert par l'opt-in
            val dismissState = rememberDismissState()
            if (dismissState.isDismissed(DismissDirection.EndToStart) ||
                dismissState.isDismissed(DismissDirection.StartToEnd)
            ) {
                deleteArticle(article)
            }
            SwipeToDismiss(
                state = dismissState,
                background = {},
                dismissContent = {
                    Article(
                        article = article,
                        onItemClick = { articleClicked(it) },
                        modifier = Modifier.offset { IntOffset(offsetX.value.roundToInt(), 0) }
                    )
                }
            )
        }
    }
}

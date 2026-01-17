package com.douaamohamed.newsapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.douaamohamed.newsapp.R
import com.douaamohamed.newsapp.data.database.entity.Article
import com.douaamohamed.newsapp.ui.base.ShowError
import com.douaamohamed.newsapp.ui.base.WebViewPage
import com.douaamohamed.newsapp.ui.viewmodels.SharedViewModel
import kotlinx.coroutines.launch

@Composable
fun ArticleScreen(
    article: Article?,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val mContext = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var isSaved by remember { mutableStateOf(false) }

    LaunchedEffect(article?.url) {
        if (article?.url != null) {
            isSaved = sharedViewModel.isArticleSaved(article.url)
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (article != null) {
                    coroutineScope.launch {
                        if (isSaved) {
                            sharedViewModel.deleteArticle(article)
                            isSaved = false
                            Toast.makeText(
                                mContext,
                                mContext.resources.getString(R.string.article_removed_from_favorites),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            sharedViewModel.saveArticle(article)
                            isSaved = true
                            Toast.makeText(
                                mContext,
                                mContext.resources.getString(R.string.article_saved_successfully),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }) {
                Icon(
                    painter = painterResource(
                        id = if (isSaved) R.drawable.ic_favourite_filled else R.drawable.ic_save
                    ),
                    contentDescription = null
                )
            }
        }
    ) {
        if (article?.url == null) {
            ShowError(text = stringResource(id = R.string.something_went_wrong))
        } else {
            WebViewPage(
                url = article.url,
                modifier = Modifier.padding(it)
            )
        }
    }
}
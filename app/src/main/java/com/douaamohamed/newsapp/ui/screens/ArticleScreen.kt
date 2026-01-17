package com.douaamohamed.newsapp.ui.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import com.douaamohamed.newsapp.R
import com.douaamohamed.newsapp.data.database.entity.Article
import com.douaamohamed.newsapp.ui.base.ShowError
import com.douaamohamed.newsapp.ui.base.WebViewPage
import com.douaamohamed.newsapp.ui.viewmodels.SharedViewModel
import kotlinx.coroutines.launch
import java.net.URLDecoder
import kotlin.text.Charsets.UTF_8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    article: Article?,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var isSaved by remember { mutableStateOf(false) }

    // Vérifie si l'article est déjà sauvegardé
    LaunchedEffect(article?.url) {
        if (article?.url != null) {
            isSaved = sharedViewModel.isArticleSaved(article.url)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // Décodage propre du titre pour supprimer les "+" et %XX
                    val decodedTitle = try {
                        URLDecoder.decode(article?.title ?: "Article", UTF_8.name())
                    } catch (e: Exception) {
                        article?.title ?: "Article"
                    }

                    Text(
                        text = decodedTitle,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    // Icône Partager
                    IconButton(onClick = {
                        if (article?.url != null) {
                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, article.url)
                                putExtra(Intent.EXTRA_SUBJECT, article.title ?: "Article intéressant")
                            }
                            try {
                                context.startActivity(Intent.createChooser(shareIntent, "Partager via"))
                            } catch (e: Exception) {
                                Toast.makeText(context, "Impossible de partager", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Partager",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFD32F2F),  // Rouge de ton thème
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (article != null) {
                    coroutineScope.launch {
                        if (isSaved) {
                            sharedViewModel.deleteArticle(article)
                            isSaved = false
                            Toast.makeText(
                                context,
                                "Article retiré des favoris",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            sharedViewModel.saveArticle(article)
                            isSaved = true
                            Toast.makeText(
                                context,
                                "Article sauvegardé avec succès",
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
                    contentDescription = if (isSaved) "Retirer des favoris" else "Sauvegarder"
                )
            }
        }
    ) { innerPadding ->
        if (article?.url == null) {
            ShowError(text = "Une erreur est survenue")
        } else {
            WebViewPage(
                url = article.url,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}
package com.example.newsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import org.w3c.dom.Text

class DetailedNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_news)

        val webView: WebView = findViewById(R.id.webView)

        val web_url: String? = intent.getStringExtra("web_url")

        webView.webViewClient = WebViewClient()

        if (web_url != null) {
            webView.loadUrl(web_url)
        }

    }
}
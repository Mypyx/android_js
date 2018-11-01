package com.example.administrator.webviewprojcet.web

import android.os.Handler
import android.view.View
import android.widget.TextView
import com.example.administrator.webviewprojcet.R
import wendu.dsbridge.DWebView


/**
 * Created by Administrator on 2018/11/1 0001.
 */
object WebErrorLayout {

    //错误布局
    fun webErrorLayout(webView: DWebView, errorLayout: View) {
        webView.visibility = View.GONE
        errorLayout.visibility = View.VISIBLE
        errorLayout.findViewById<TextView>(R.id.anewClick).setOnClickListener { webView.reload() }
    }

    //成功布局
    fun webCompleteLayout(webView: DWebView, errorLayout: View?) {
        webView.visibility = View.VISIBLE
        errorLayout?.let { Handler().postDelayed({ it.visibility = View.GONE }, 1000) }
    }
}
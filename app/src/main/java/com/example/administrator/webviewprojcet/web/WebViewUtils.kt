package com.example.administrator.webviewprojcet.web

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.*
import wendu.dsbridge.DWebView


/**
 * Created by Administrator on 2018/11/1 0001.
 */
class WebViewUtils(private val webView: DWebView, private val faceBase: BaseWebViewFace) : WebViewClient() {


    private var loadError = true

    init {
        initWebView()
    }

    //加载网易
    fun loadUrl(url: String) {
        webView.loadUrl(url)
    }

    //添加js交互
    fun addJavascriptApi(jsWebApi: JsWebDataApi) {
        webView.addJavascriptObject(jsWebApi, null)
    }


    //初始化webView
    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webView.webViewClient = this
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(false)
        webView.settings.builtInZoomControls = false
        webView.settings.displayZoomControls = false
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
    }


    //页面开始加载
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        loadError = true
        faceBase.webStart()
    }


    //页面加载完成
    override fun onPageFinished(view: WebView?, url: String?) {
        if (loadError) faceBase.webComplete() else faceBase.webError()
    }


    //加载失败
    override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
        super.onReceivedError(view, errorCode, description, failingUrl)
        loadError = false
    }

    //加载失败
    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
        loadError = false
    }


}
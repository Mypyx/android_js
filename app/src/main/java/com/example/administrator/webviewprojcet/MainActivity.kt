package com.example.administrator.webviewprojcet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.administrator.webviewprojcet.web.BaseJsWebApiFace
import com.example.administrator.webviewprojcet.web.BaseWebViewFace
import com.example.administrator.webviewprojcet.web.JsWebDataApi
import com.example.administrator.webviewprojcet.web.WebErrorLayout.webCompleteLayout
import com.example.administrator.webviewprojcet.web.WebErrorLayout.webErrorLayout
import com.example.administrator.webviewprojcet.web.WebViewUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_error_no_data.*
import wendu.dsbridge.OnReturnValue

class MainActivity : AppCompatActivity(), BaseWebViewFace, BaseJsWebApiFace {


    private lateinit var loading: LoadDialog
    private lateinit var webViewUtils: WebViewUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLoading()
        initWebView()
        showAddValue()
    }



    private fun initLoading() {
        loading = LoadDialog(this, false, "loading···")
    }

    //http://39.98.43.66/index.html
    //https://proapi.flashdate.cn/webapp/v0/index/index.html
    private fun initWebView() {
        webViewUtils = WebViewUtils(webView, this)
        webViewUtils.loadUrl("http://39.98.43.66/index.html")
        webViewUtils.addJavascriptApi(JsWebDataApi(this))
    }


    private fun showAddValue() {
        webView.callHandler("openCamera", arrayOf<Any>("呵呵"), OnReturnValue<String> {

        })
    }


    //开始加载
    override fun webStart() {
        loading.show()
    }


    //加载成功
    override fun webComplete() {
        loading.dismiss()
        webCompleteLayout(webView, errorLayout)
    }

    //加载失败
    override fun webError() {
        loading.dismiss()
        webErrorLayout(webView, errorLayout)
    }


    override fun openBrowser(args: Any) {
        Toast.makeText(this, args.toString(), Toast.LENGTH_LONG).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        webView.destroy()
    }

}

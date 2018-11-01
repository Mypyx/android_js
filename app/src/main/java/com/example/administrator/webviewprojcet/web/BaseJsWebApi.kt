package com.example.administrator.webviewprojcet.web

import android.webkit.JavascriptInterface

/**
 * Created by Administrator on 2018/11/1 0001.
 */
open class BaseJsWebApi(private var face: BaseJsWebApiFace) {

    @JavascriptInterface
    public fun openBrowser(`object`: Any) {
        face.openBrowser(`object`)
    }
}
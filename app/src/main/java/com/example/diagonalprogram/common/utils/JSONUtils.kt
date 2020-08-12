package com.example.diagonalprogram.common.utils

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

object JSONUtils {

    fun loadAssetsJsonObject(mContext: Context, fileName: String): JSONObject? {
        var json: String? = null
        var `object`: JSONObject? = null
        var pageJson:JSONObject? = null
        try {
            val `is` = mContext.assets.open(fileName)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = buffer.toString(Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        } finally {
            try {
                `object` = JSONObject(json ?: "")
                pageJson = `object`.getJSONObject("page")
//                val contentItems = pageJson.getJSONObject("content-items")
//                content = contentItems.getJSONArray("content")

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return pageJson
    }

}
package com.DecupleProject

import com.DecupleProject.Utility.getJsonByUrl
import com.google.gson.JsonObject
import com.google.gson.JsonParser

fun versionChecker(): String {
    val versionInfo: String = getJsonByUrl("http://www.developerdecuple.kro.kr:7777/custom-musicbot-maker")

    val jp = JsonParser()
    val info: JsonObject = jp.parse(versionInfo) as JsonObject

    return info.get("nowVersion").asString
}

fun getDownloadUrl(): String {
    val versionInfo: String = getJsonByUrl("http://www.developerdecuple.kro.kr:7777/custom-musicbot-maker")

    val jp = JsonParser()
    val info: JsonObject = jp.parse(versionInfo) as JsonObject

    return info.get("downloadLink").asString
}
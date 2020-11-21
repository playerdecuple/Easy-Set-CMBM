package com.DecupleProject.Utility

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

fun getJsonByUrl(url: String): String {

    val targetUrl = URL(url)
    val uC: HttpURLConnection = targetUrl.openConnection() as HttpURLConnection

    uC.requestMethod = "GET"
    val br = BufferedReader(InputStreamReader(uC.inputStream, StandardCharsets.UTF_8))

    val result = StringBuilder()
    var line: String?

    while (true) {
        line = br.readLine()
        if (line == null) break
        result.append(line)
    }

    return result.toString()

}
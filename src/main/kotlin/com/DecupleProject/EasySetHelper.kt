@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.DecupleProject

import com.DecupleProject.Utility.WriteFile
import com.DecupleProject.Utility.unzipper
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels
import java.nio.channels.ReadableByteChannel
import java.util.Scanner
import kotlin.concurrent.timer

val BASE_DIRECTORY = System.getProperty("user.dir")!!

fun main(args: Array<String>) {

    val downloadTargetDir = File("$BASE_DIRECTORY/_Download")

    val version = versionChecker().replace("v", "")
    val downloadLink = URL(getDownloadUrl())

    if (!downloadTargetDir.exists()) {

        downloadTargetDir.mkdir()

        val rbc: ReadableByteChannel = Channels.newChannel(downloadLink.openStream())
        val fos = FileOutputStream("_Download/CORE.zip")

        println("Download : 'Custom-MusicBot-Maker' CORE File (Version v$version)")
        print("Wait a moment")

        val timer = timer(period = 1000) {
            print(".")
        }

        fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
        timer.cancel()

        println("\nDone. Started Extract..\n\n")

        unzipper().unzip(downloadTargetDir.path + "/CORE.zip", downloadTargetDir.path)

        println("\n\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ \n\n")

        println("Download completed.\n")

        println("You need to go through the initial setup.")
        println("Please refer to this page. It will definitely help.\n")
        println("'https://github.com/playerdecuple/Custom-MusicBot-Maker'")

        println("\n\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ \n\n")

        print("Input Discord Bot Token : ")
        var sc = Scanner(System.`in`)
        val discordToken = sc.nextLine()
        println()

        print("Input Youtube Data API V3 OAuth Token : ")
        sc = Scanner(System.`in`)
        val youtubeAPIToken = sc.nextLine()

        println("\n\n\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ \n\n")

        WriteFile().writeString(downloadTargetDir.path + "/Custom-MusicBot-Maker-$version/TOKEN.txt", discordToken)
        WriteFile().writeString(downloadTargetDir.path + "/Custom-MusicBot-Maker-$version/YOUTUBE_API_KEY.txt", youtubeAPIToken)

        print("Input Bot Activity Message : ")
        sc = Scanner(System.`in`)
        val activityMessage = sc.nextLine()
        println()

        println("\n\n\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ \n\n")

        println("Well done! Please restart this tool please!")
        return

    }

    var downloadedFiles = downloadTargetDir.listFiles()
    var coreFile: File
    var coreFilePath = ""

    for (itemFile in downloadedFiles) {
        if (itemFile.isDirectory) {
            coreFile = itemFile
            coreFilePath = coreFile.path
        }
    }

    println("\n\n    Okay! You can activate your bot!\n\n     Execute `$coreFilePath/RUN.bat` Please!")

}
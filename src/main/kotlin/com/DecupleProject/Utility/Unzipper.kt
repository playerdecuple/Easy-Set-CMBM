package com.DecupleProject.Utility

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.charset.Charset
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

class unzipper {

    private fun createFile(file: File, zis: ZipInputStream) {

        val parentDir = File(file.parent)
        if (!parentDir.exists()) parentDir.mkdirs()

        var fos: FileOutputStream? = null

        try {

            fos = FileOutputStream(file)
            val buffer = ByteArray(256)

            var size: Int
            while (true) {
                size = zis.read(buffer)

                if (size > 0) {
                    fos.write(buffer, 0, size)
                } else {
                    break
                }
            }

        } catch (e: Throwable) {
            throw e
        } finally {

            if (fos != null) {
                try {
                    fos.close()
                } catch (e: IOException) {
                    // ignore
                }
            }

        }
    }

    fun unzip(zipPath: String, targetPath: String): Boolean {

        var fine: Boolean
        val zipFile = File(zipPath)

        var fis: FileInputStream? = null
        var zis: ZipInputStream? = null
        var zipEntry: ZipEntry?

        try {

            val targetFile = File(targetPath)
            if (!targetFile.exists()) targetFile.mkdir()

            fis = FileInputStream(zipFile)
            zis = ZipInputStream(fis, Charset.forName("EUC-KR"))

            while (true) {

                zipEntry = zis.nextEntry
                if (zipEntry == null) break

                val fileName = zipEntry.name
                val entryFile = File(targetFile, fileName)

                println("Extracting File: $fileName")

                if (zipEntry.isDirectory) {
                    entryFile.mkdir()
                } else {
                    try {
                        createFile(entryFile, zis)
                    } catch (e: Throwable) {
                        println("ERROR OCCURRED. PLEASE RETRY AGAIN.")
                    }
                }

            }

            fine = true

        } catch (e: Exception) {
            fine = false
        } finally {
            if (zis != null) {
                try {
                    zis.close()
                } catch (e: IOException) {
                    // ignore
                }
            }

            if (fis != null) {
                try {
                    fis.close()
                } catch (e: IOException) {
                    // ignore
                }
            }
        }

        return fine

    }

}
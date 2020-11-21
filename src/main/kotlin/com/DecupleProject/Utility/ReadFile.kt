package com.DecupleProject.Utility

import java.io.File
import java.io.FileInputStream

class ReadFile {
    fun readLong(filePath: String?): Long {
        return try {
            val fs = FileInputStream(filePath)
            val rB = ByteArray(fs.available())
            while (fs.read(rB) != -1) {
            }
            String(rB).toLong()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    fun readLong(file: File): Long {
        return try {
            val fs = FileInputStream(file.path)
            val rB = ByteArray(fs.available())
            while (fs.read(rB) != -1) {
            }
            String(rB).toLong()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    fun readInt(path: String?): Int {
        return try {
            val fs = FileInputStream(path)
            val rB = ByteArray(fs.available())
            while (fs.read(rB) != -1) {
            }
            String(rB).toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    fun readInt(f: File): Int {
        return try {
            val fs = FileInputStream(f.path)
            val rB = ByteArray(fs.available())
            while (fs.read(rB) != -1) {
            }
            String(rB).toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    fun readString(path: String?): String? {
        return try {
            val fs = FileInputStream(path)
            val rB = ByteArray(fs.available())
            while (fs.read(rB) != -1) {
            }
            String(rB)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun readString(f: File): String? {
        return try {
            val fs = FileInputStream(f.path)
            val rB = ByteArray(fs.available())
            while (fs.read(rB) != -1) {
            }
            String(rB)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
package com.DecupleProject.Utility

import java.io.File
import java.io.FileWriter

class WriteFile {
    fun writeString(f: File, value: String?) {
        try {
            val fW = FileWriter(f.path)
            fW.write(value)
            fW.flush()
            fW.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeStringToFiles(value: String?, vararg f: File) {
        try {
            for (file in f) {
                val fW = FileWriter(file.path)
                fW.write(value)
                fW.flush()
                fW.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeLong(f: File, value: Long) {
        try {
            val fW = FileWriter(f.path)
            fW.write(value.toString())
            fW.flush()
            fW.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeInt(f: File, value: Int) {
        try {
            val fW = FileWriter(f.path)
            fW.write(value.toString())
            fW.flush()
            fW.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeString(path: String?, value: String?) {
        try {
            val fW = FileWriter(path)
            fW.write(value)
            fW.flush()
            fW.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeLong(path: String?, value: Long) {
        try {
            val fW = FileWriter(path)
            fW.write(value.toString())
            fW.flush()
            fW.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeInt(path: String?, value: Int) {
        try {
            val fW = FileWriter(path)
            fW.write(value.toString())
            fW.flush()
            fW.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
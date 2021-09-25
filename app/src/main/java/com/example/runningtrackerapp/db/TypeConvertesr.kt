package com.example.runningtrackerapp.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class TypeConvertesr {

    @TypeConverter
    fun fromBitMapToByteArray(bitMap: Bitmap): ByteArray = run {
        val outputStream = ByteArrayOutputStream()
        bitMap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        outputStream.toByteArray()
    }

    @TypeConverter
    fun fromByteArrayToBitMap(byteArray: ByteArray): Bitmap = run {
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}

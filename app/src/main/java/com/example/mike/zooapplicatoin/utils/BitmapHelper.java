package com.example.mike.zooapplicatoin.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class BitmapHelper {


    public static Bitmap bytes2bmp( byte[] a ){
        return BitmapFactory.decodeByteArray(a, 0, a.length);
    }

    public static byte[] bmp2bytes(Bitmap bmp){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 50, stream);
        return stream.toByteArray();
    }
}

package com.github.cyano.jni;

public class JNIUtils {
    //加载native-jni
    static {
        System.loadLibrary("native-lib");
    }

    //java 调用C中的方法都需要用native申明且方法名必须和c的方法名一样
    public native String stringFromJNI();

}

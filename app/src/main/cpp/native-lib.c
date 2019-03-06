//
// Created by 朱孝诚 on 2017/8/30.
//
#include "com_niwoxuexi_ndkdemo_JNIUtils.h"
/**
 * 上边的引用标签一定是.h的文件名家后缀，方法名一定要和.h文件中的方法名称一样
 */
JNIEXPORT jstring JNICALL Java_com_niwoxuexi_ndkdemo_JNIUtils_stringFromJNI
        (JNIEnv *env, jobject ojb){

    return (*env) -> NewStringUTF(env,"Hello, I'm from jni");
}
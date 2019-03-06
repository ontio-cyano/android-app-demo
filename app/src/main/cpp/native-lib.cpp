#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_github_cyano_jni_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_github_cyano_jni_JNIUtils_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO  测试

    std::string hello = "这个是c的代码";
    return env->NewStringUTF(hello.c_str());
}
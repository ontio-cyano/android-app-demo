package com.github.cyano.demo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tvLogin = findViewById(R.id.sample_text);
        TextView tvInvoke = findViewById(R.id.sample_text1);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "{\"action\":\"login\",\"id\":\"10ba038e-48da-487b-96e8-8d3b99b6d18a\",\"version\":\"v1.0.0\",\"params\":{\"type\":\"ontid or account\",\"dappName\":\"dapp Name\",\"dappIcon\":\"dapp Icon\",\"message\":\"helloworld\",\"expire\":1546415363,\"callback\":\"http://127.0.0.1:80/login/callback\"}}";
                sendData(data);
            }
        });
        tvInvoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "{\"action\":\"invoke\",\"version\":\"v1.0.0\",\"id\":\"10ba038e-48da-487b-96e8-8d3b99b6d18a\",\"params\":{\"login\":true,\"qrcodeUrl\":\"http://101.132.193.149:4027/qrcode/AUr5QUfeBADq6BMY6Tp5yuMsUNGpsD7nLZ\",\"message\":\"will pay 1 ONT in this transaction\",\"callback\":\"http://101.132.193.149:4027/invoke/callback\"}}";
                sendData(data);
            }
        });
    }


    private void sendData(String data) {
        if (isInstallApp(MainActivity.this)) {
            Toast.makeText(MainActivity.this, "installed ", Toast.LENGTH_LONG).show();
            String sendData = Base64.encodeToString(Uri.encode(data).getBytes(), Base64.NO_WRAP);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("ontprovider://ont.io?param=" + sendData));
            intent.addCategory("android.intent.category.DEFAULT");
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Not Installed", Toast.LENGTH_LONG).show();
        }
    }

    private static String PACK_NAME = "com.github.ont.cyanowallet";

    public static boolean isInstallApp(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName.toLowerCase(Locale.ENGLISH);
                if (pn.equals(PACK_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

}
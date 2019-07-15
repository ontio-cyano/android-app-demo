# android-app-demo
android APP demo is a demo support wake up wallet for login and invoke smartcontract.

[Mobile Provider](http://dev-docs.ont.io/#/docs-cn/cyano/02-mobile-provider)

```
login example:

{
    "action": "login",
    "id": "10ba038e-48da-487b-96e8-8d3b99b6d18a",
    "version": "v1.0.0",
    "params": {
        "type": "ontid or account",
        "dappName": "dapp Name",
        "dappIcon": "dapp Icon",
        "message": "helloworld",
        "expire": 1546415363,
        "callback": "http://127.0.0.1:80/login/callback"
    }
}


```
open ONTO wallet:
```
String data = "{\"action\":\"login\",\"id\":\"10ba038e-48da-487b-96e8-8d3b99b6d18a\",\"version\":\"v1.0.0\",\"params\":{\"type\":\"ontid or account\",\"dappName\":\"dapp Name\",\"dappIcon\":\"dapp Icon\",\"message\":\"helloworld\",\"expire\":1546415363,\"callback\":\"http://127.0.0.1:80/login/callback\"}}"; //

 String sendData = Base64.encodeToString(Uri.encode(data).getBytes(), Base64.NO_WRAP);

 Intent intent = new Intent("android.intent.action.VIEW");
 intent.setData(Uri.parse("ontprovider://ont.io?param=" + sendData));
 intent.addCategory("android.intent.category.DEFAULT");
 startActivity(intent);
        
```

This app and two wallets can be download from here: http://101.132.193.149/files2/ 



<div align="center">
  <img src="https://raw.githubusercontent.com/ontio-cyano/android-app-demo/master/demo.png" height="350" width="200">
  <img src="https://raw.githubusercontent.com/ontio-cyano/android-app-demo/master/wakeup.png" height="350" width="200">
</div>

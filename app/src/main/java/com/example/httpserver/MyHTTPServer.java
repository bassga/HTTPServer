package com.example.httpserver;

import fi.iki.elonen.NanoHTTPD;

public class MyHTTPServer extends NanoHTTPD {

    public MyHTTPServer() {
        super(8080); // ポート番号を設定
    }

    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello from NanoHTTPD!</h1></body></html>";
        return newFixedLengthResponse(msg);
    }
}

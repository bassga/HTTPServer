package com.example.httpserver;

import static fi.iki.elonen.NanoHTTPD.SOCKET_READ_TIMEOUT;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.io.IOException;

public class ServerService extends Service {

    private MyHTTPServer myHTTPServer;
    private static final String TAG = "ServerService";

    @Override
    public void onCreate() {
        super.onCreate();
        myHTTPServer = new MyHTTPServer();
        try {
            myHTTPServer.start(SOCKET_READ_TIMEOUT, false);
            Log.i(TAG, "Server started on port 8080");
        } catch (IOException e) {
            Log.e(TAG, "Couldn't start server:", e);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myHTTPServer != null) {
            myHTTPServer.stop();
            Log.i(TAG, "Server stopped");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; // This service is not intended to be bound
    }
}

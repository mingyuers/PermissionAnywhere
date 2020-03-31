package com.mingyuers.permissionanywhere;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.mingyuers.permission.PermissionAnywhere;
import com.mingyuers.permission.PermissionCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PermissionAnywhere.requestPermission(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE}
                    , new PermissionCallback() {
                        @Override
                        public void onComplete(List<String> grantedPermissions, List<String> deniedPermissions, List<String> alwaysDeniedPermissions) {
                            Log.d(TAG, "Permission result:");
                            Log.d(TAG, "onPermissionGranted" + grantedPermissions.toString());
                            Log.d(TAG, "onPermissionDenied" + deniedPermissions.toString());
                            Log.d(TAG, "onPermissionAlwaysDenied" + alwaysDeniedPermissions.toString());
                            Log.d(TAG, "onComplete");
                        }
                    });
        }
    }
}

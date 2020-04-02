package com.mingyuers.permissionanywhere;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mingyuers.permission.PermissionAnywhere;
import com.mingyuers.permission.PermissionCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PermissionAnywhere.requestPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE}
                    , new PermissionCallback() {
                        @Override
                        public void onComplete(List<String> grantedPermissions, List<String> deniedPermissions, List<String> alwaysDeniedPermissions) {
                            System.out.println("onPermissionGranted" + grantedPermissions.toString());
                            System.out.println("onPermissionDenied" + deniedPermissions.toString());
                            System.out.println("onPermissionAlwaysDenied" + alwaysDeniedPermissions.toString());

                            System.out.println("onComplete");
                        }
                    });
        }

    }
}

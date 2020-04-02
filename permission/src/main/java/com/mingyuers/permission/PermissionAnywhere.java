package com.mingyuers.permission;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.annotation.RequiresApi;


/***
 * Created by fangm on 2019-11-18 14:29
 *
 **/
public class PermissionAnywhere {
    private static PermissionFragment permissionFragment;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void requestPermission(final Activity context, final String[] permissions, PermissionCallback permissionCallback) {
        if(permissionFragment == null){
            permissionFragment = new PermissionFragment();
        }
        permissionFragment.setOnAttachCallback(new FragmentAttachCallback() {
            @Override
            public void onAttach() {
                permissionFragment.requestPermission(permissions);
            }
        });
        permissionFragment.setOnPermissionCallback(permissionCallback);
        FragmentTransaction fragmentTransaction = context.getFragmentManager().beginTransaction();
        fragmentTransaction.add(permissionFragment, "permissionFragment@777").commit();
    }
}

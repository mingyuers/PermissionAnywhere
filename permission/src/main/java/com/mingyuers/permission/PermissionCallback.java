package com.mingyuers.permission;

import java.util.List;

/***
 * Created by fangm on 2019-11-18 17:25
 *
 **/
public interface PermissionCallback {
    void onComplete(List<String> grantedPermissions, List<String> deniedPermissions, List<String> alwaysDeniedPermissions);
}

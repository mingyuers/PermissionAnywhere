# PermissionAnywhere

[![](https://jitpack.io/v/mingyuers/PermissionAnywhere.svg)](https://jitpack.io/#mingyuers/PermissionAnywhere)

## SetUp

1、Add the JitPack repository to your build file
```js
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
2、Add the dependency
```js
dependencies {
    implementation 'com.github.mingyuers:PermissionAnywhere:latest.release'
}
```

## How to use
1、use in your code
```java
requestPermission(final Activity context, final String[] permissions, PermissionCallback permissionCallback)
requestPermission(final String[] permissions, PermissionCallback permissionCallback) throws Exception
```
2、some demo
```java
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
```


## License

MIT License

Copyright (c) 2020 mingyuers
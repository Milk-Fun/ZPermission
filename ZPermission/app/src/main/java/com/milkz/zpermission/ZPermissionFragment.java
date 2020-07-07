package com.milkz.zpermission;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by zuoqi@wsdashi.com on 2020/7/7 16:35
 * Description:
 */
public class ZPermissionFragment extends Fragment {

    private static final int ZPERMISSION_REQUEST_CODE = 0x1001;

    private ZPermissionCallback zPermissionCallback;

    public void setzPermissionCallback(ZPermissionCallback zPermissionCallback) {
        this.zPermissionCallback = zPermissionCallback;
    }

    public void requestPermission(@NonNull String... permissions) {
        requestPermissions(permissions, ZPERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != ZPERMISSION_REQUEST_CODE) return;
        if (zPermissionCallback == null) return;



    }
}

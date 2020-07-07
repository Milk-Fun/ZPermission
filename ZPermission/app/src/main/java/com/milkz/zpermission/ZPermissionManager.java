package com.milkz.zpermission;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;

/**
 * Created by zuoqi@wsdashi.com on 2020/7/7 16:17
 * Description: 权限管理类
 */
public class ZPermissionManager {

    private static ZPermissionManager zPermissionManager;

    private ZPermissionManager() {
    }

    public static ZPermissionManager getInstance() {
        if (zPermissionManager == null) {
            synchronized (ZPermissionManager.class) {
                if (zPermissionManager == null) {
                    zPermissionManager = new ZPermissionManager();
                }
            }
        }
        return zPermissionManager;
    }

    //TODO 对于多个权限的处理
    public void request(@NonNull Activity activity, @NonNull String permission, @NonNull ZPermissionCallback zPermissionCallback) {
        int status = getPermissionStatus(activity, permission);
        switch (status) {
            case ZPermission.STATUS_HAS_PERMISSION: {
                zPermissionCallback.onPermissionResult(ZPermissionCallback.PERMISSION_GRANT);
            }
            break;
            case ZPermission.STATUS_CAN_REQUEST_PERMISSION: {
                ZPermissionFragment zPermissionFragment = new ZPermissionFragment();
                zPermissionFragment.setzPermissionCallback(zPermissionCallback);
                zPermissionFragment.requestPermission(permission);
            }
            break;
            case ZPermission.STATUS_CAN_NOT_REQUEST_PERMISSION: {
                //TODO 返回用户拒绝的权限
                zPermissionCallback.doSpecialOperation();
            }
            break;
        }
    }

    @ZPermission.PermissionStatus
    public int getPermissionStatus(@NonNull Activity activity, @NonNull String permission) {
        if (checkPermission(activity.getApplicationContext(), permission)) {
            // 有权限
            return ZPermission.STATUS_HAS_PERMISSION;
        }

        // 无权限
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission) ?
                ZPermission.STATUS_CAN_REQUEST_PERMISSION : ZPermission.STATUS_CAN_NOT_REQUEST_PERMISSION;
    }

    public boolean checkPermission(Context context, String permission) {
        return PermissionChecker.checkSelfPermission(context, permission) == PermissionChecker.PERMISSION_GRANTED;
    }

}

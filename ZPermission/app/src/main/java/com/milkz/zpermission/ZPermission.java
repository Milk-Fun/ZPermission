package com.milkz.zpermission;

import android.app.Activity;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

/**
 * Created by zuoqi@wsdashi.com on 2020/7/7 16:17
 * Description:
 */
public class ZPermission {

    // 有权限
    public static final int STATUS_HAS_PERMISSION = 100;
    // 无权限，但是可以申请权限
    public static final int STATUS_CAN_REQUEST_PERMISSION = 101;
    // 无权限，用户选择了不再提示，不可以使用系统权限框申请权限
    public static final int STATUS_CAN_NOT_REQUEST_PERMISSION = 102;

    @IntDef({STATUS_CAN_NOT_REQUEST_PERMISSION, STATUS_CAN_REQUEST_PERMISSION, STATUS_HAS_PERMISSION})
    public @interface PermissionStatus {
    }

    private ZPermissionCallback zPermissionCallback;

    public void setPermissionCallback(@NonNull ZPermissionCallback zPermissionCallback) {
        this.zPermissionCallback = zPermissionCallback;
    }

    public void request(@NonNull Activity activity, @NonNull String permission) throws ZPermissionException {
        if (zPermissionCallback == null)
            throw new ZPermissionException(ZPermissionException.ZPermissionExceptionImpl.CallBackNullException);
        ZPermissionManager.getInstance().request(activity, permission, zPermissionCallback);
    }


}

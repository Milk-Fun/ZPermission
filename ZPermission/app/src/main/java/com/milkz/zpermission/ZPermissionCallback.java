package com.milkz.zpermission;

import android.support.annotation.IntDef;

/**
 * Created by zuoqi@ on 2020/7/7 16:34
 * Description: 结果回调
 */
public interface ZPermissionCallback {

    /**
     * 用户授权成功
     */
    int PERMISSION_GRANT = 1;
    /**
     * 用户拒绝授权
     */
    int PERMISSION_DENY = 2;
    /**
     * 当前手机版本没有该权限
     */
    int PERMISSION_NOT_FIND = 3;

    @IntDef({PERMISSION_GRANT, PERMISSION_DENY, PERMISSION_NOT_FIND})
    @interface PermissionResult {
    }

    /**
     * 结果回调
     *
     * @param result @see {@link PermissionResult}
     */
    void onPermissionResult(@PermissionResult int result);

    /**
     * 当用户拒绝过该权限时候，所做的处理，比如显示个对话框跳转到系统设置界面让用户手动打开权限
     */
    void doSpecialOperation();
}

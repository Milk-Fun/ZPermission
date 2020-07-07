package com.milkz.zpermission;

import android.support.annotation.Nullable;

/**
 * Created by zuoqi@wsdashi.com on 2020/7/7 17:25
 * Description:
 */
public class ZPermissionException extends Exception {

    private ZException zException;

    public ZPermissionException(ZException zException) {
        super();
        this.zException = zException;
    }

    @Nullable
    @Override
    public String getMessage() {
        return zException.errorMsg();
    }

    public interface ZException{
        int errorCode();

        String errorMsg();
    }

    //TODO 以后把枚举去掉

    public enum ZPermissionExceptionImpl implements ZException {

        CallBackNullException(100,"ZPermissionCallback is null"),

        ;

        private int code;
        private String msg;

        ZPermissionExceptionImpl(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public int errorCode() {
            return this.code;
        }

        @Override
        public String errorMsg() {
            return this.msg;
        }
    }

}

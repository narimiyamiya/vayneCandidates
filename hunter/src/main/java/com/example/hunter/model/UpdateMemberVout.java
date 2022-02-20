package com.example.hunter.model;

public class UpdateMemberVout {
    private String isSuccess;
    private String errorMsg;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "DeleteMemberVout{" +
                "isSuccess='" + isSuccess + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}

package com.devssi.prueba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TransactionResultDTO {
    Boolean success = false;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String errorMsg;

    public TransactionResultDTO() {
        success = true;
    }

    public TransactionResultDTO(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

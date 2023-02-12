package com.dj.serverapi.model;

/**
 * @author zcq
 */
public class Response<T> {

    public class Result {

        private Integer status;

        private String pi;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getPi() {
            return pi;
        }

        public void setPi(String pi) {
            this.pi = pi;
        }
    }

    public class Data {

        private Result result;


        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }
    }

    private Integer errcode;

    private String errmsg;

    private Data data;


    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}

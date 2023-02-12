package com.dj.serverapi.model;

/**
 * @author zcq
 */
public class AuthenticationQueryRequest implements IClientRequest{

    private String ai;

    public String getAi() {
        return ai;
    }

    public void setAi(String ai) {
        this.ai = ai;
    }

}

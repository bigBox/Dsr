package com.dj.domain.entity.player;

import com.dj.domain.base.IEntity;
import lombok.Data;

import java.util.Date;
@Data
public class SmsCode implements IEntity {
    protected long id;
    private String phone;
    private String code;
    private String ip;
    protected Date createTime;
    protected Date updateTime;

    @Override
    public String getPrimaryKeyName() {
        return "id";
    }

    @Override
    public Object getPrimaryKeyValue() {
        return id;
    }

    @Override
    public IEntity copy() {
        SmsCode item = new SmsCode();
        item.setId(id);
        item.setPhone(phone);
        item.setIp(ip);
        item.setCode(code);
        item.setCreateTime(new Date());
        item.setUpdateTime(new Date());
        return item;
    }
}

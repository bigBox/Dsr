package com.dj.serverapi.service;

import com.dj.domain.entity.player.AliPay;
import com.dj.domain.entity.player.WxPay;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.AliPayDao;
import com.dj.serverapi.dao.WxPayDao;
import com.dj.serverapi.service.inf.IPayService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.servercore.spring.SpringContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PayServiceImpl extends BaseService implements IPayService {

    @Autowired
    public WxPayDao  wxPayDao;

    @Autowired
    public AliPayDao aliPayDao;

    @Override
    public void addAliPayItem(Long roleId, String tradeNo) {
        if(ObjectUtils.isEmpty(aliPayDao)){
            aliPayDao = SpringContext.getBean(AliPayDao.class);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleId);
        queryParams.put("tradeNo",tradeNo);
        AliPay aliPay = aliPayDao.cacheSelect(queryParams, roleId);
        if(ObjectUtils.isNotEmpty(aliPay)){
            if((aliPay.getSuccess() == true)&&(aliPay.getDeliver() == false)){
                if(aliPay.getItemId() == 1){
                    ServiceProvider.getCommonService().addAttrBill(roleId, PlayerAttrEnum.GOLD.getKey(), aliPay.getCount(), ResourceBillEnum.mallBuy);
                    EventProvider.postSyncAttrEvent(roleId);
                }else if(aliPay.getItemId() == 2){
                    ServiceProvider.getCommonService().addAttrBill(roleId, PlayerAttrEnum.DIAMOND.getKey(), aliPay.getCount(), ResourceBillEnum.mallBuy);
                    EventProvider.postSyncAttrEvent(roleId);
                }else if(aliPay.getItemId() == 3){
                    ServiceProvider.getCommonService().addAttrBill(roleId, PlayerAttrEnum.STAMINA.getKey(), aliPay.getCount(), ResourceBillEnum.mallBuy);
                    EventProvider.postSyncAttrEvent(roleId);
                }else if(aliPay.getItemId() > 1000){
                    ServiceProvider.getItemService().addItemBill(roleId, aliPay.getItemId(), aliPay.getCount(),
                            ResourceBillEnum.mallBuy, true ,true);
                    EventProvider.postSyncItemEvent(roleId);
                }else {
                    log.error("AliPay the itemId=%d is not exit", aliPay.getItemId());
                    return;
                }
                EventProvider.commitRoleEvent(roleId);
                aliPay.setDeliver(true);
                aliPayDao.cacheUpdate(aliPay, roleId);
            }
        }
    }

    @Override
    public void addWxPayItem(Long roleId, String tradeNo){
        if(ObjectUtils.isEmpty(wxPayDao)){
            wxPayDao = SpringContext.getBean(WxPayDao.class);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleId);
        queryParams.put("tradeNo",tradeNo);
        WxPay wxPay = wxPayDao.cacheSelect(queryParams, roleId);
        if(ObjectUtils.isNotEmpty(wxPay)){
            if((wxPay.getSuccess() == true )&&(wxPay.getDeliver() == false)){
                if(wxPay.getItemId() == 1){
                    ServiceProvider.getCommonService().addAttrBill(roleId, PlayerAttrEnum.GOLD.getKey(), wxPay.getCount(),
                            ResourceBillEnum.mallBuy);
                    EventProvider.postSyncAttrEvent(roleId);
                }else if(wxPay.getItemId() == 2){
                    ServiceProvider.getCommonService().addAttrBill(roleId, PlayerAttrEnum.DIAMOND.getKey(), wxPay.getCount(),
                            ResourceBillEnum.mallBuy);
                    EventProvider.postSyncAttrEvent(roleId);
                }else if(wxPay.getItemId() == 3){
                    ServiceProvider.getCommonService().addAttrBill(roleId, PlayerAttrEnum.STAMINA.getKey(), wxPay.getCount(),
                            ResourceBillEnum.mallBuy);
                    EventProvider.postSyncAttrEvent(roleId);
                }else if(wxPay.getItemId() > 1000){
                    ServiceProvider.getItemService().addItemBill(roleId, wxPay.getItemId(), wxPay.getCount(),
                            ResourceBillEnum.mallBuy, true ,true);
                    EventProvider.postSyncItemEvent(roleId);
                }else {
                    log.error("WxPay the itemId=%d is not exit", wxPay.getItemId());
                    return;
                }
                EventProvider.commitRoleEvent(roleId);
                wxPay.setDeliver(true);
                wxPayDao.cacheUpdate(wxPay, roleId);
            }
        }
    }
}

package com.dj.serverapi.service;

import com.dj.serverapi.service.inf.IHolidayService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.DateUtil;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HolidayServiceImpl extends BaseService implements IHolidayService {

    static List<String> holiday =new ArrayList<>();

    public HolidayServiceImpl() {
        super();
        initHoliday();
    }

    public Boolean isPlayGameDayTime(long time) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneOffset.of("+8"));
        String dateStr = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //节假日 和 周五周六周日
        DayOfWeek week = dateTime.getDayOfWeek();
        if((holiday.contains(dateStr)) || week==DayOfWeek.FRIDAY || week==DayOfWeek.SATURDAY || week==DayOfWeek.SUNDAY){
            Date today = DateUtil.getCurrentDate();
            Date date20 = DateUtil.parseDate(dateStr + " 20:00", DateUtil.VIEW_STYLE_NORMAL);
            Date date21 = DateUtil.parseDate(dateStr + " 21:00", DateUtil.VIEW_STYLE_NORMAL);
            if(today.getTime() > date20.getTime() && today.getTime() < date21.getTime()) {
                return true;
            }
        }
        return false;

    }
    /**
     *  初始化节假日
     */
    public void initHoliday(){
        holiday.add("2022-11-05");
        holiday.add("2022-11-06");
        holiday.add("2022-11-12");
        holiday.add("2022-11-13");
        holiday.add("2022-11-19");
        holiday.add("2022-11-20");
        holiday.add("2022-11-26");
        holiday.add("2022-11-27");
        holiday.add("2022-12-03");
        holiday.add("2022-12-04");
        holiday.add("2022-12-10");
        holiday.add("2022-12-11");
        holiday.add("2022-12-17");
        holiday.add("2022-12-18");
        holiday.add("2022-12-24");
        holiday.add("2022-12-25");
        holiday.add("2022-12-31");
        holiday.add("2023-01-01");
        holiday.add("2023-01-02");
        holiday.add("2023-01-07");
        holiday.add("2023-01-08");
        holiday.add("2023-01-14");
        holiday.add("2023-01-15");
        holiday.add("2023-01-21");
        holiday.add("2023-01-22");
        holiday.add("2023-01-24");
        holiday.add("2023-01-25");
        holiday.add("2023-01-26");
        holiday.add("2023-01-27");
        holiday.add("2023-02-04");
        holiday.add("2023-02-05");
        holiday.add("2023-02-09");
        holiday.add("2023-02-11");
        holiday.add("2023-02-12");
        holiday.add("2023-02-18");
        holiday.add("2023-02-19");
        holiday.add("2023-02-25");
        holiday.add("2023-02-26");
        holiday.add("2023-03-04");
        holiday.add("2023-03-05");
        holiday.add("2023-03-11");
        holiday.add("2023-03-12");
        holiday.add("2023-03-18");
        holiday.add("2023-03-19");
        holiday.add("2023-03-25");
        holiday.add("2023-03-26");
        holiday.add("2023-04-01");
        holiday.add("2023-04-02");
        holiday.add("2023-04-05");
        holiday.add("2023-04-08");
        holiday.add("2023-04-09");
        holiday.add("2023-04-15");
        holiday.add("2023-04-16");
        holiday.add("2023-04-22");
        holiday.add("2023-04-23");
        holiday.add("2023-05-01");
        holiday.add("2023-05-02");
        holiday.add("2023-05-03");
        holiday.add("2023-05-04");
        holiday.add("2023-05-05");
        holiday.add("2023-05-13");
        holiday.add("2023-05-14");
        holiday.add("2023-05-20");
        holiday.add("2023-05-21");
        holiday.add("2023-05-27");
        holiday.add("2023-05-28");
        holiday.add("2023-06-03");
        holiday.add("2023-06-04");
        holiday.add("2023-06-10");
        holiday.add("2023-06-11");
        holiday.add("2023-06-17");
        holiday.add("2023-06-18");
        holiday.add("2023-06-22");
        holiday.add("2023-06-23");
        holiday.add("2023-06-24");
        holiday.add("2023-07-01");
        holiday.add("2023-07-02");
        holiday.add("2023-07-08");
        holiday.add("2023-07-09");
        holiday.add("2023-07-15");
        holiday.add("2023-07-16");
        holiday.add("2023-07-22");
        holiday.add("2023-07-23");
        holiday.add("2023-07-29");
        holiday.add("2023-07-30");
        holiday.add("2023-08-05");
        holiday.add("2023-08-06");
        holiday.add("2023-08-12");
        holiday.add("2023-08-13");
        holiday.add("2023-08-19");
        holiday.add("2023-08-20");
        holiday.add("2023-08-26");
        holiday.add("2023-08-27");
        holiday.add("2023-09-02");
        holiday.add("2023-09-03");
        holiday.add("2023-09-09");
        holiday.add("2023-09-10");
        holiday.add("2023-09-16");
        holiday.add("2023-09-17");
        holiday.add("2023-09-23");
        holiday.add("2023-09-24");
        holiday.add("2023-09-29");
        holiday.add("2023-09-30");
        holiday.add("2023-10-01");
        holiday.add("2023-10-02");
        holiday.add("2023-10-03");
        holiday.add("2023-10-04");
        holiday.add("2023-10-05");
        holiday.add("2023-10-06");
    }

}

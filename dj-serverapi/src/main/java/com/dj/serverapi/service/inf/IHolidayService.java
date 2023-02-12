package com.dj.serverapi.service.inf;

public interface IHolidayService {

	Boolean isPlayGameDayTime(long time);

	void initHoliday();

	//void initExtraWorkDay();

}

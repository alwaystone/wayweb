package com.ways.utils;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleUtil {
	/*@Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行*/
	public void testSchedule(){
		
		System.out.println("schedulle"+new Date());
	}
}

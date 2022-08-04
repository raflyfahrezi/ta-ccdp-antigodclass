/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.util;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author azis
 */
public enum SimpleDateFormatFlyWeight{
	INSTANCE;

	public String format(Date date, String formatPattern){
		SimpleDateFormat timeFormatter = FlyweightHolder.HOLDER.get(formatPattern);
		if(timeFormatter == null){
			timeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			FlyweightHolder.HOLDER.put(formatPattern, timeFormatter);
		}
		return timeFormatter.format(date);
	}

	private static class FlyweightHolder{
		private static final Map<String, SimpleDateFormat> HOLDER = new ConcurrentHashMap<>();
	}
}
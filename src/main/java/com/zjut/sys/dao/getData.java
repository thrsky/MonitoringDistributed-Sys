package com.zjut.sys.dao;

import java.util.Date;
import java.util.List;

/**
 * Created by thRShy on 2017/6/6.
 */
public interface getData {

    public List<String > get15Minutes(String ip);

    public List<String > getOneDayData(String ip);

    public List<String > getSevenDayData(String ip);

    public List<String > getHalfMonthData(String ip);
}

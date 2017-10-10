package com.lanou.crm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Tools {
    public static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 返回指定格式化的时间对象
     **/
    public static String getFormat(Date date) {
        return dateFormater.format(date);
    }
}

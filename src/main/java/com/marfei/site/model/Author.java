package com.marfei.site.model;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Litch1
 * @date 2021/5/5 6:33 下午
 */
public enum Author {

    litch1("陈宏锟","军军",new Date(1999, Calendar.MARCH,23)),
    feifei("林少惠","狒狒",new Date(1999,Calendar.FEBRUARY,4))
    ;
    private String name;
    private String nikeName;
    private Date birthday;

    Author(String name,String nikeName,Date birthday){
        this.name = name;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

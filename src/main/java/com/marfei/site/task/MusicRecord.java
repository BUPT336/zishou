package com.marfei.site.task;

import com.marfei.site.util.MusicUtil;

import java.io.IOException;

/**
 * @author Litch1
 * @date 2021/5/18 11:07 下午
 */
public class MusicRecord implements Runnable {

    @Override
    public void run() {
        MusicUtil musicUtil = new MusicUtil();
        try {
            String json = musicUtil.getUserMusicListJson(MusicUtil.USER_ID,"1");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

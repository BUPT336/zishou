package com.marfei.site.util;

import org.junit.jupiter.api.Test;

/**
 * @author Litch1
 * @date 2021/5/18 3:29 上午
 */
public class MusicUtilTest {
    @Test
    public void testLoginAndGetMusicList(){
        MusicUtil musicUtil = new MusicUtil();
        musicUtil.loginMusicCloud("18876376083","!@wxdpdd7");
        //musicUtil.getUserMusicListJson("508732813","1");
    }
}

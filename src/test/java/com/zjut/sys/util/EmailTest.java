package com.zjut.sys.util;

import org.junit.Test;

/**
 * Created by xjy on 2017/6/4.
 */
public class EmailTest {
    @Test
    public void sendMail() throws Exception {
        Email. sendMail("15957180610@163.com", "15957180610@163.com", "xujunyu520",
                "1098672878@qq.com",
                "Java Mail 测试邮件",
                "<a>html 元素</a>：<b>邮件内容</b>");
    }

}
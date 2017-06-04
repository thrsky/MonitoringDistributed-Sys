package com.zjut.sys.pojo;

import lombok.Data;

/**
 * 邮件、短信告警的消息
 * Created by xjy on 2017/6/3.
 */
@Data
public class WarnMessage {
    long id;
    String title;
    //暂时只支持cpu
    //告警线 百分比的形式:13.9%
    double warnLine;
    int type;
    boolean status;

    public static enum TYPE {
        larger(1),
        equal(0),
        smaller(-1);
        private int type;

        private TYPE(int t) {
            this.type = t;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public int value() {
            return this.type;
        }
    }
}

package com.zjut.sys.pojo;

import lombok.Data;

@Data
public class WarnMessage {
    private Long id;

    private String title;

    private Double warnline;

    private Integer type;

    private Byte status;

    private String item;

    private String email;


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
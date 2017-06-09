package com.zjut.sys.pojo;

import lombok.Data;

@Data
public class WarnMessage {
    private Long id;

    private String ip;

    private String title;

    //警戒线
    private Double warnLine;

    //
    private Integer type;

    //
    private Byte status;

    //cpu
    private String item;

    private String email;


    public enum TYPE {
        larger(1),
        equal(0),
        smaller(-1);
        private int type;

        TYPE(int t) {
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

    @Override
    public String toString() {
        return "WarnMessage{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", title='" + title + '\'' +
                ", warnLine=" + warnLine +
                ", type=" + type +
                ", status=" + status +
                ", item='" + item + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

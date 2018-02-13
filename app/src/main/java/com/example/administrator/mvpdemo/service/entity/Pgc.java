package com.example.administrator.mvpdemo.service.entity;

import java.util.List;

/**
 * Created by xiaofeizhang on 2018/1/30.
 */

public class Pgc {

    /**
     * status : 200
     * statusText : OK
     * data : [{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128020","second_cate_name":"其他"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128100","second_cate_name":"游戏头条"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128103","second_cate_name":"电子竞技"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128105","second_cate_name":"手游"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128108","second_cate_name":"集锦TOP"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128109","second_cate_name":"现场赛事"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128110","second_cate_name":"宣传片CG"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128111","second_cate_name":"真人秀"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128112","second_cate_name":"DOTA/DOTA2"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128113","second_cate_name":"英雄联盟"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128114","second_cate_name":"我的世界"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128115","second_cate_name":"网络游戏"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128116","second_cate_name":"单机游戏"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128117","second_cate_name":"王者荣耀"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128118","second_cate_name":"阴阳师"},{"first_cate_code":"31","first_cate_name":"游戏","second_cate_code":"128119","second_cate_name":"守望先锋"}]
     */

    private int status;
    private String statusText;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * first_cate_code : 31
         * first_cate_name : 游戏
         * second_cate_code : 128020
         * second_cate_name : 其他
         */

        private String first_cate_code;
        private String first_cate_name;
        private String second_cate_code;
        private String second_cate_name;

        public String getFirst_cate_code() {
            return first_cate_code;
        }

        public void setFirst_cate_code(String first_cate_code) {
            this.first_cate_code = first_cate_code;
        }

        public String getFirst_cate_name() {
            return first_cate_name;
        }

        public void setFirst_cate_name(String first_cate_name) {
            this.first_cate_name = first_cate_name;
        }

        public String getSecond_cate_code() {
            return second_cate_code;
        }

        public void setSecond_cate_code(String second_cate_code) {
            this.second_cate_code = second_cate_code;
        }

        public String getSecond_cate_name() {
            return second_cate_name;
        }

        public void setSecond_cate_name(String second_cate_name) {
            this.second_cate_name = second_cate_name;
        }
    }
}

package com.zz.supercleaner.bean.response;

import com.zz.supercleaner.bean.BaseBean;

public class UserInfo extends BaseBean {


    /**
     * avatar : null
     * bio : She loves to share
     * birthdate : null
     * finished_info : false
     * gender : unknown
     * huanxin : {"password":"b7702c283c823038ce4776cf9a3735fb","user_id":"love1236383185000000731"}
     * is_first_login : false
     * session : session.1236383185488762076
     * user_id : 5c7feb513fff225d00f432d7
     */

    private String avatar;
    private String bio;
    private String birthdate;
    private boolean finished_info;
    private String gender;
    private HuanxinBean huanxin;
    private boolean is_first_login;
    private String session;
    private String user_id;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isFinished_info() {
        return finished_info;
    }

    public void setFinished_info(boolean finished_info) {
        this.finished_info = finished_info;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HuanxinBean getHuanxin() {
        return huanxin;
    }

    public void setHuanxin(HuanxinBean huanxin) {
        this.huanxin = huanxin;
    }

    public boolean isIs_first_login() {
        return is_first_login;
    }

    public void setIs_first_login(boolean is_first_login) {
        this.is_first_login = is_first_login;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public static class HuanxinBean extends BaseBean{
        /**
         * password : b7702c283c823038ce4776cf9a3735fb
         * user_id : love1236383185000000731
         */

        private String password;
        private String user_id;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}

package es.source.code.model;

import java.io.Serializable;

/**
 * Created by huang on 2016/6/13.
 */
public class User implements Serializable{
    private String userName;
    private String passwrod;
    private Boolean oldUser;

    public User(){}
    public  User(String name,String passwrod,Boolean oldUser){
        this.userName = name;
        this.passwrod = passwrod;
        this.oldUser = oldUser;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public Boolean getOldUser() {
        return oldUser;
    }

    public void setOldUser(Boolean oldUser) {
        this.oldUser = oldUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passwrod='" + passwrod + '\'' +
                ", oldUser=" + oldUser +
                '}';
    }
}

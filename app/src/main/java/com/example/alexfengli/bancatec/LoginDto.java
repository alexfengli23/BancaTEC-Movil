package com.example.alexfengli.bancatec;

/**
 * Created by Alex Feng Li on 5/6/2017.
 */

class LoginDto {
    private String userName,passWord;

    public LoginDto(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

package com.example.week04;

import java.io.Serializable;

public class Change implements Serializable {
    private int b1000, b500, b100, b20, b10, b5, b1;

    public Change(){
        this.b1000 = 0;
        this.b500 = 0;
        this.b100 = 0;
        this.b20 = 0;
        this.b10 = 0;
        this.b5 = 0;
        this.b1 = 0;
    }

    public int getB1000() {
        return b1000;
    }

    public void setB1000(int b1000) {
        this.b1000 = b1000;
    }

    public int getB500() {
        return b500;
    }

    public void setB500(int b500) {
        this.b500 = b500;
    }

    public int getB100() {
        return b100;
    }

    public void setB100(int b100) {
        this.b100 = b100;
    }

    public int getB20() {
        return b20;
    }

    public void setB20(int b20) {
        this.b20 = b20;
    }

    public int getB10() {
        return b10;
    }

    public void setB10(int b10) {
        this.b10 = b10;
    }

    public int getB5() {
        return b5;
    }

    public void setB5(int b5) {
        this.b5 = b5;
    }

    public int getB1() {
        return b1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }


}

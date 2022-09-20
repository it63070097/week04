package com.example.week04;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Cashier {
    private int total = 0;
    private Change myObj;

    @RequestMapping(path = "/getChange/{n1}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("n1") String n1){
        this.myObj = new Change();
        int num = Integer.parseInt(n1);
        this.total = num;
        if(this.total >= 1000){
            this.myObj.setB1000(this.total/1000);
            this.total = this.total%1000;
        } if (this.total >= 500) {
            this.myObj.setB500(this.total/500);
            this.total = this.total%500;
        } if (this.total >= 100) {
            this.myObj.setB100(this.total/100);
            this.total = this.total%100;
        } if (this.total >= 20) {
            this.myObj.setB20(this.total/20);
            this.total = this.total%20;
        } if (this.total >= 10) {
            this.myObj.setB10(this.total/10);
            this.total = this.total%10;
        } if (this.total >= 5) {
            this.myObj.setB5(this.total/5);
            this.total = this.total%5;
        } if (this.total >= 1) {
            this.myObj.setB1(this.total/1);
            this.total = this.total%1;
        }
        return this.myObj;
    };
}

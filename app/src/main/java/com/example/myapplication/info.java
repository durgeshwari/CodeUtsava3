package com.example.myapplication;

public class info {
    private String name;
    private String bloodgrp;

    public info(){

    }

    public info(String name, String bloodgrp) {
        this.name = name;
        this.bloodgrp = bloodgrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }
}

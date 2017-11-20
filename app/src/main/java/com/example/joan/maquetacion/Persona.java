package com.example.joan.maquetacion;

import java.io.Serializable;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class Persona implements Serializable{
    private int id;
    private String name;
    private String surname;
    private int spinnerPosition;
    private boolean checkBoxState;
    private int imgFront, imgProfile;

    public Persona(int id, String name, String surname, int spinnerPosition, boolean checkBoxState, int imgFront, int imgProfile) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.spinnerPosition = spinnerPosition;
        this.checkBoxState = checkBoxState;
        this.imgFront = imgFront;
        this.imgProfile = imgProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSpinnerPosition() {
        return spinnerPosition;
    }

    public void setSpinnerPosition(int spinnerPosition) {
        this.spinnerPosition = spinnerPosition;
    }

    public boolean isCheckBoxState() {
        return checkBoxState;
    }

    public void setCheckBoxState(boolean checkBoxState) {
        this.checkBoxState = checkBoxState;
    }

    public int getImgFront() {
        return imgFront;
    }

    public void setImgFront(int imgFront) {
        this.imgFront = imgFront;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }
}

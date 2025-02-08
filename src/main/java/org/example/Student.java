package org.example;

import java.util.ArrayList;

public class Student {
  public static final String LICENTA = "licenta";
  public static final String MASTER = "master";
  protected String nume;
  protected double medie;
  protected ArrayList<Curs<?>> preferinte;
  protected Curs<?> curs;

  public Student(String nume) {
    this.nume = nume;
    this.medie = 0.0;
    this.preferinte = new ArrayList<>();
    this.curs = null;
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public double getMedie() {
    return medie;
  }

  public void setMedie(double medie) {
    this.medie = medie;
  }

  public ArrayList<Curs<?>> getPreferinte() {
    return preferinte;
  }

  public void setPreferinte(ArrayList<Curs<?>> preferinte) {
    this.preferinte = preferinte;
  }

  public Curs<?> getCurs() {
    return curs;
  }

  public void setCurs(Curs<?> curs) {
    this.curs = curs;
  }
}

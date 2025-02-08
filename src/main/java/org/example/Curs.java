package org.example;

import java.util.Set;
import java.util.TreeSet;

public class Curs<T extends Student> {
  private String numeCurs;
  private int capacitateMaxima;
  private Set<T> studentiInscrisi;

  public Curs(String numeCurs, int capacitateMaxima) {
    this.numeCurs = numeCurs;
    this.capacitateMaxima = capacitateMaxima;
    this.studentiInscrisi = new TreeSet<>((o1, o2) -> o1.getNume().compareTo(o2.getNume()));
  }

  public String getNumeCurs() {
    return numeCurs;
  }

  public void setNumeCurs(String numeCurs) {
    this.numeCurs = numeCurs;
  }

  public int getCapacitateMaxima() {
    return capacitateMaxima;
  }

  public void setCapacitateMaxima(int capacitateMaxima) {
    this.capacitateMaxima = capacitateMaxima;
  }

  public Set<T> getStudentiInscrisi() {
    return studentiInscrisi;
  }

  public void setStudentiInscrisi(Set<T> studentiInscrisi) {
    this.studentiInscrisi = studentiInscrisi;
  }

  public void adaugaStudentInscris(Student student) {
    studentiInscrisi.add((T) student);
  }
}

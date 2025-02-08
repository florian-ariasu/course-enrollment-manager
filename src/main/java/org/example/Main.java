package org.example;

import java.io.*;

public class Main {
  public static void main(String[] args) {
    Secretariat secretariat = new Secretariat();

    String cale = "src/main/resources/";
    String fisierIntrare = cale + args[0] + "/" + args[0] + ".in";
    String fisierIesire = cale + args[0] + "/" + args[0] + ".out";

    try (BufferedReader br = new BufferedReader(new FileReader(fisierIntrare))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] cuvinte = line.split(" - ");
        if (cuvinte[0].equals("adauga_student")) {
          try {
            secretariat.adaugaStudent(cuvinte[1], cuvinte[2]);
          } catch (StudentDuplicatExceptie e) {
            try (FileWriter fw = new FileWriter(fisierIesire, true)) {
              try (BufferedWriter bw = new BufferedWriter(fw)) {
                try (PrintWriter pw = new PrintWriter(bw)) {
                  pw.println("***");
                  pw.println(e.getMessage());
                }
              }
            } catch (IOException exceptie) {
              exceptie.printStackTrace();
            }
          }
        }
        if (cuvinte[0].equals("adauga_curs")) {
          secretariat.adaugaCurs(cuvinte[1], cuvinte[2], Integer.parseInt(cuvinte[3]));
        }
        if (cuvinte[0].equals("citeste_mediile")) {
          secretariat.citesteMedii(args[0]);
        }
        if (cuvinte[0].equals("posteaza_mediile")) {
          secretariat.prezintaMedii(fisierIesire);
        }
        if (cuvinte[0].equals("contestatie")) {
          secretariat.aplicaContestatie(cuvinte[1], cuvinte[2]);
        }
        if (cuvinte[0].equals("adauga_preferinte")) {
          secretariat.adaugaPreferinte(cuvinte);
        }
        if (cuvinte[0].equals("repartizeaza")) {
          secretariat.realizeazaRepartizarea();
        }
        if (cuvinte[0].equals("posteaza_curs")) {
          secretariat.prezintaCurs(cuvinte[1], fisierIesire);
        }
        if (cuvinte[0].equals("posteaza_student")) {
          secretariat.prezintaStudent(cuvinte[1], fisierIesire);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

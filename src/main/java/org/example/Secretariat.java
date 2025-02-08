package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Secretariat {
  private final ArrayList<Student> studenti;
  private final ArrayList<Curs<? extends Student>> cursuri;

  public Secretariat() {
    this.studenti = new ArrayList<>();
    this.cursuri = new ArrayList<>();
  }

  public ArrayList<Student> getStudenti() {
    return studenti;
  }

  public ArrayList<Curs<? extends Student>> getCursuri() {
    return cursuri;
  }

  public void adaugaStudent(String tipInvatamant, String nume) throws StudentDuplicatExceptie {
    for (Student studentVerifica : studenti) {
      if (studentVerifica.getNume().equals(nume)) {
        throw new StudentDuplicatExceptie("Student duplicat: " + nume);
      }
    }

    if (tipInvatamant.equalsIgnoreCase(Student.LICENTA)) {
      StudentLicenta student = new StudentLicenta(nume);
      studenti.add(student);
    } else {
      StudentMaster student = new StudentMaster(nume);
      studenti.add(student);
    }
  }

  public void adaugaCurs(String tipInvatamant, String numeCurs, int capacitateMaxima) {
    if (tipInvatamant.equalsIgnoreCase(Student.LICENTA)) {
      Curs<StudentLicenta> curs = new Curs<>(numeCurs, capacitateMaxima);
      cursuri.add(curs);
    } else if (tipInvatamant.equalsIgnoreCase(Student.MASTER)) {
      Curs<StudentMaster> curs = new Curs<>(numeCurs, capacitateMaxima);
      cursuri.add(curs);
    }
  }

  public void citesteMedii(String folder) {
    for (int i = 1; i < 4; i++) {
      String cale = "src/main/resources/" + folder + "/";
      String fisierIntrare = cale + "note_" + i + ".txt";

      if (!Files.exists(Path.of(fisierIntrare)))
        break;

      try (BufferedReader br = new BufferedReader(new FileReader(fisierIntrare))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] cuvinte = line.split(" - ");
          for (Student student : studenti) {
            if (student.getNume().equals(cuvinte[0])) {
              student.setMedie(Double.parseDouble(cuvinte[1]));
            }
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void aplicaContestatie(String numeStudent, String medie) {
    for (Student student : studenti) {
      if (student.getNume().equals(numeStudent)) {
        student.setMedie(Double.parseDouble(medie));
      }
    }
  }

  public void prezintaMedii(String fisierIesire) {
    try (FileWriter fw = new FileWriter(fisierIesire, true)) {
      try (BufferedWriter bw = new BufferedWriter(fw)) {
        try (PrintWriter pw = new PrintWriter(bw)) {
          pw.println("***");
          studenti.sort((s1, s2) -> {
            if (s1.getMedie() > s2.getMedie()) {
              return -1;
            } else if (s1.getMedie() < s2.getMedie()) {
              return 1;
            } else {
              return s1.getNume().compareTo(s2.getNume());
            }
          });
          for (Student student : studenti) {
            pw.println(student.getNume() + " - " + student.getMedie());
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void adaugaPreferinte(String[] cuvinte) {
    String numeStudent = cuvinte[1];
    for (Student student : studenti) {
      if (student.getNume().equals(numeStudent)) {
        for (int i = 2; i < cuvinte.length; i++) {
          for (Curs<? extends Student> curs : cursuri) {
            if (curs.getNumeCurs().equals(cuvinte[i])) {
              student.getPreferinte().add(curs);
            }
          }
        }
      }
    }
  }

  public void realizeazaRepartizarea() {
    for (Student student : studenti) {
      for (Curs<? extends Student> curs : student.getPreferinte()) {
        if (curs.getCapacitateMaxima() > curs.getStudentiInscrisi().size()) {
          curs.adaugaStudentInscris(student);
          student.setCurs(curs);
          break;
        } else {
          for (Student studentCurs : curs.getStudentiInscrisi()) {
            if (studentCurs.getMedie() == student.getMedie()) {
              curs.adaugaStudentInscris(student);
              student.setCurs(curs);
              break;
            }
          }
        }
      }

      if (student.getCurs() == null) {
        ArrayList<Curs<? extends Student>> copieCursuri = new ArrayList<>(cursuri);
        copieCursuri.sort((c1, c2) -> c1.getNumeCurs().compareTo(c2.getNumeCurs()));
        for (Curs<? extends Student> cursDisponibil : copieCursuri) {
          if (cursDisponibil.getCapacitateMaxima() > cursDisponibil.getStudentiInscrisi().size()) {
            cursDisponibil.adaugaStudentInscris(student);
            student.setCurs(cursDisponibil);
            break;
          }
        }
      }
    }
  }

  public void prezintaCurs(String numeCurs, String fisierIesire) {
    try (FileWriter fw = new FileWriter(fisierIesire, true)) {
      try (BufferedWriter bw = new BufferedWriter(fw)) {
        try (PrintWriter pw = new PrintWriter(bw)) {
          pw.println("***");
          for (Curs<? extends Student> curs : cursuri) {
            if (curs.getNumeCurs().equals(numeCurs)) {
              pw.println(curs.getNumeCurs() + " (" + curs.getCapacitateMaxima() + ")");
              for (Student student : curs.getStudentiInscrisi()) {
                pw.println(student.getNume() + " - " + student.getMedie());
              }
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void prezintaStudent(String numeStudent, String fisierIesire) {
    try (FileWriter fw = new FileWriter(fisierIesire, true)) {
      try (BufferedWriter bw = new BufferedWriter(fw)) {
        try (PrintWriter pw = new PrintWriter(bw)) {
          pw.println("***");
          for (Student student : studenti) {
            if (student.getNume().equals(numeStudent)) {
              String tipul = student instanceof StudentLicenta ? "Licenta" : "Master";
              pw.println("Student " + tipul + ": " + student.getNume() + " - " + student.getMedie() + " - " + student.getCurs().getNumeCurs());
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

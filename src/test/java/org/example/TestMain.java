package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestMain {
    String antetResources = "src/main/resources/";

    public boolean areFilesEqual(Path file1, Path file2) throws IOException {
        List<String> lines1 = Files.readAllLines(file1);
        List<String> lines2 = Files.readAllLines(file2);

        return lines1.equals(lines2);
    }

    public void emptyOutput(String test_name) {
        File[] files = new File(antetResources + test_name).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".out")) {
                file.delete();
            }
        }
    }

    @Test
    public void posteazaMedii01() throws IOException {
        String file = "01-posteaza_medii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void posteazaMediiContestatii02() throws IOException {
        String file = "02-posteaza_medii_contestatii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void posteazaMediiContestatii03() throws IOException {
        String file = "03-posteaza_medii_contestatii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void posteazaMediiContestatii04() throws IOException {
        String file = "04-posteaza_medii_contestatii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void inroleazaSimplu05() throws IOException {
        String file = "05-inroleaza_simplu";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void inroleazaCicluStudii06() throws IOException {
        String file = "06-inroleaza_ciclu_studii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void inroleazaCicluStudiiContestatii07() throws IOException {
        String file = "07-inroleaza_ciclu_studii_contestatii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void coliziuniMedie08() throws IOException {
        String file = "08-coliziuni_medie";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void coliziuniCicluStudii09() throws IOException {
        String file = "09-coliziuni_ciclu_studii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void coliziuniCicluStudiiContestatii10() throws IOException {
        String file = "10-coliziuni_ciclu_studii_contestatii";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void exceptieSimplu11() throws IOException {
        String file = "11-exceptie_simplu";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void toateFunctionalitatile12() throws IOException {
        String file = "12-toate_functionalitatile";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        Path ref = Paths.get(antetResources + file + "/" + file + ".ref");
        assertTrue(areFilesEqual(out, ref));
    }

    @Test
    public void bonusTema13() throws IOException {
        String file = "13-bonus_tema";
        emptyOutput(file);
        Main.main(new String[]{file});
        Path out = Paths.get(antetResources + file + "/" + file + ".out");
        assertTrue(Files.exists(out));
    }
}
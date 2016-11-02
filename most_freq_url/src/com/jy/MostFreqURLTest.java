package com.jy;

import org.junit.Before;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by jy on 11/1/2016.
 */
public class MostFreqURLTest {
    private final static String UNITTEST_FOLDER = "unittest";
    private final static String UNITTEST_FILE = "input.csv";
    @Before
    public void setUp() throws Exception {

        (new File(UNITTEST_FOLDER)).mkdir();
        Path file = Paths.get(UNITTEST_FOLDER + File.separator + UNITTEST_FILE);
        if (!Files.exists(file)) {
            Files.createFile(file);
        }
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writeTest("T1,A,U1\n", writer);
            writeTest("T2,A,U3\n", writer);
            writeTest("T3,C,U5\n", writer);
            writeTest("T4,B,U1\n", writer);
            writeTest("T5,A,U8\n", writer);
            writeTest("T6,B,U3\n", writer);
            writeTest("T7,A,U7\n", writer);
            writer.close();
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    private void writeTest(String s, BufferedWriter writer) throws IOException {
        writer.write(s, 0, s.length());
    }

    @org.junit.Test
    public void solution2() throws Exception {
        String[] result = MostFreqURL.solution2(UNITTEST_FOLDER + File.separator + UNITTEST_FILE);
        String[] exp = new String[]{"U1", "U3"};
        assertArrayEquals(exp, result);
    }

    @org.junit.Test
    public void solution() throws Exception {
        MostFreqURL.UrlPair result = MostFreqURL.solution(UNITTEST_FOLDER + File.separator + UNITTEST_FILE);
        MostFreqURL.UrlPair exp = new MostFreqURL.UrlPair("U1", "U3");
        assertEquals(exp, result);
    }

}
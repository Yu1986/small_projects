package com.jy;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class MostFreqURL {
    public static class UrlPair {

        public UrlPair(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public void set(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public void set(UrlPair p) {
            this.a = p.a;
            this.b = p.b;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj instanceof  UrlPair) {
                UrlPair p = (UrlPair) obj;
                if (this.a.equals(p.a) && this.b.equals(p.b)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (a+b).hashCode();
        }

        private String a;
        private String b;
    }

    public static UrlPair solution(String path) {
        HashMap<String, String> userMap = new HashMap<>();
        HashMap<UrlPair, Set<String>> pairMap = new HashMap<>();
        UrlPair resultPair = new UrlPair(null, null);
        int max = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            UrlPair pair = new UrlPair(null, null);
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (userMap.containsKey(split[1])) {
                    pair.set(userMap.get(split[1]), split[2]);
                    Set<String> userSet;
                    if (pairMap.containsKey(pair)) {
                        userSet = pairMap.get(pair);
                        userSet.add(split[1]);
                    } else {
                        userSet = new TreeSet<String>();
                        userSet.add(split[1]);
                        pairMap.put(pair, userSet);
                    }
                    if (userSet.size() > max) {
                        max = userSet.size();
                        resultPair.set(pair);
                    }
                }
                userMap.put(split[1], split[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultPair;
    }

    public static String[] solution2(String path) {
        HashMap<String, String> userMap = new HashMap<>();
        HashMap<String[], Set<String>> pairMap = new HashMap<>();
        String[] resultPair = new String[2];
        int max = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            String[] pair = new String[2];
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (userMap.containsKey(split[1])) {
                    pair[0] = userMap.get(split[1]);
                    pair[1] = split[2];
                    Set<String> userSet;
                    if (pairMap.containsKey(pair)) {
                        userSet = pairMap.get(pair);
                        userSet.add(split[1]);
                    } else {
                        userSet = new TreeSet<String>();
                        userSet.add(split[1]);
                        pairMap.put(pair, userSet);
                    }
                    if (userSet.size() > max) {
                        max = userSet.size();
                        resultPair[0] = pair[0];
                        resultPair[1] = pair[1];
                    }
                }
                userMap.put(split[1], split[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultPair;
    }
}
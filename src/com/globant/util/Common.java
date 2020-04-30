package com.globant.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Common {

    public List<String> readFile(String fileName){
        String path = "C:\\Users\\diana.sandoval\\IdeaProjects\\University\\src\\com\\globant\\resources\\";
        List<String> lines = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path + "" + fileName));
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

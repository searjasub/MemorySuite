package edu.neumont.csc150.model;

import java.io.File;
import java.util.List;

public class ScoreManager {

    private int currentScore;
    private int topScore;
    private long time;
    private long bestTime;

    private String filePath;

    public ScoreManager(){
        filePath = new File("").getAbsolutePath();
    }
}
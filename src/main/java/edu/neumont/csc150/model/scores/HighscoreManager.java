package edu.neumont.csc150.model.scores;

import java.io.*;
import java.util.ArrayList;

public class HighscoreManager implements Serializable {

    private static final String HIGHSCORE_FILE = "scores.dat";
    private ObjectOutputStream outputStream = null;
    private ObjectInputStream inputStream = null;
    private ArrayList<Score> scores;

    public HighscoreManager() {
        scores = new ArrayList<>();
    }

    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }

    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        scores.sort(comparator);
    }

    public void addScore(String name, int score) {
        loadScoreFile();
        scores.add(new Score(name, score));
        updateScoreFile();
    }

    private void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    private void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }

    public String getHighscoreString() {
        String highscoreString = "";
        int max = 10;

        ArrayList<Score> scores = getScores();
        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            if (scores.get(i).getScore() >= 1000) {
                highscoreString += scores.get(i).getScore() + "  -  " + scores.get(i).getName() + "\n";
            } else {
                highscoreString += scores.get(i).getScore() + "    -  " + scores.get(i).getName() + "\n";
            }
            i++;
        }
        return highscoreString;
    }
}

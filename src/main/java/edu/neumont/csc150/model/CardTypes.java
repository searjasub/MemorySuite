package edu.neumont.csc150.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public enum CardTypes {
    ONE("src\\main\\resources\\images\\cards_front\\one.png"),
    TWO("src\\main\\resources\\images\\cards_front\\two.png"),
    THREE("src\\main\\resources\\images\\cards_front\\three.png"),
    FOUR("src\\main\\resources\\images\\cards_front\\four.png"),
    FIVE("src\\main\\resources\\images\\cards_front\\five.png"),
    SIX("src\\main\\resources\\images\\cards_front\\six.png"),
    SEVEN("src\\main\\resources\\images\\cards_front\\seven.png"),
    EIGHT("src\\main\\resources\\images\\cards_front\\two.png"),
    NINE("src\\main\\resources\\images\\cards_front\\two.png"),
    TEN("src\\main\\resources\\images\\cards_front\\two.png"),
    ELEVEN("src\\main\\resources\\images\\cards_front\\two.png"),
    TWELVE("src\\main\\resources\\images\\cards_front\\two.png"),
    THIRTEEN("src\\main\\resources\\images\\cards_front\\two.png"),
    FOURTEEN("src\\main\\resources\\images\\cards_front\\two.png"),
    FIFTEEN("src\\main\\resources\\images\\cards_front\\two.png"),
    SIXTEEN("src\\main\\resources\\images\\cards_front\\two.png"),
    SEVENTEEN("src\\main\\resources\\images\\cards_front\\two.png"),
    EIGHTEEN("src\\main\\resources\\images\\cards_front\\two.png"),
    NINETEEN("src\\main\\resources\\images\\cards_front\\two.png"),
    TWENTY("src\\main\\resources\\images\\cards_front\\two.png");

    private ImageView image;

    CardTypes(String url) {
        File f = new File(url);
        System.out.println(f.exists());

        Image rawImage = new Image(f.toURI().toString());
        image = new ImageView(rawImage);
        image.setFitHeight(100);
        image.setFitWidth(71.508379888268156424581005586592);

    }

    public ImageView getImage() {
        return image;
    }
}

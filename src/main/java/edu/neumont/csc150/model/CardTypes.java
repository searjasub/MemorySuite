package edu.neumont.csc150.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum CardTypes {
    DEFAULT("/images/cards_front/one.png"),
    ONE("/images/cards_front/one.png"),
    TWO("/images/cards_front/two.png"),
    THREE("/images/cards_front/two.png"),
    FOUR("/images/cards_front/two.png"),
    FIVE("/images/cards_front/two.png"),
    SIX("/images/cards_front/two.png"),
    SEVEN("/images/cards_front/two.png"),
    EIGHT("/images/cards_front/two.png"),
    NINE("/images/cards_front/two.png"),
    TEN("/images/cards_front/two.png"),
    ELEVEN("/images/cards_front/two.png"),
    TWELVE("/images/cards_front/two.png"),
    THIRTEEN("/images/cards_front/two.png"),
    FOURTEEN("/images/cards_front/two.png"),
    FIFTEEN("/images/cards_front/two.png"),
    SIXTEEN("/images/cards_front/two.png"),
    SEVENTEEN("/images/cards_front/two.png"),
    EIGHTEEN("/images/cards_front/two.png"),
    NINETEEN("/images/cards_front/two.png"),
    TWENTY("/images/cards_front/two.png");

    Image rawImage;
    ImageView image;

    CardTypes(String url){
        rawImage = new Image(url);
        image = new ImageView(rawImage);
        image.setFitHeight(100);
        image.setFitWidth(71.508379888268156424581005586592);
    }

    public ImageView getImage() {
        return image;
    }
}

package edu.neumont.csc150.model;

public enum CardType  {
    DEFAULT("src\\main\\resources\\images\\cards_front\\0.png"),
    ONE("src\\main\\resources\\images\\cards_front\\1.png"),
    TWO("src\\main\\resources\\images\\cards_front\\2.png"),
    THREE("src\\main\\resources\\images\\cards_front\\3.png"),
    FOUR("src\\main\\resources\\images\\cards_front\\4.png"),
    FIVE("src\\main\\resources\\images\\cards_front\\5.png"),
    SIX("src\\main\\resources\\images\\cards_front\\6.png"),
    SEVEN("src\\main\\resources\\images\\cards_front\\7.png"),
    EIGHT("src\\main\\resources\\images\\cards_front\\8.png"),
    NINE("src\\main\\resources\\images\\cards_front\\9.png"),
    TEN("src\\main\\resources\\images\\cards_front\\10.png"),
    ELEVEN("src\\main\\resources\\images\\cards_front\\11.png"),
    TWELVE("src\\main\\resources\\images\\cards_front\\12.png"),
    THIRTEEN("src\\main\\resources\\images\\cards_front\\13.png"),
    FOURTEEN("src\\main\\resources\\images\\cards_front\\14.png"),
    FIFTEEN("src\\main\\resources\\images\\cards_front\\15.png"),
    SIXTEEN("src\\main\\resources\\images\\cards_front\\16.png"),
    SEVENTEEN("src\\main\\resources\\images\\cards_front\\17.png"),
    EIGHTEEN("src\\main\\resources\\images\\cards_front\\18.png"),
    NINETEEN("src\\main\\resources\\images\\cards_front\\19.png"),
    TWENTY("src\\main\\resources\\images\\cards_front\\20.png");

    private String url;

    CardType(String url) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }
}

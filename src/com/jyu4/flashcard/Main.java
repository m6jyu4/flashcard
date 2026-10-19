package com.jyu4.flashcard;

public class Main {

        public static void main(String[] args) {


                var frame = new FlashcardFrame();
                var panel = new FlashcardPanel(new CardDeck("res/card.txt"));

                frame.setContentPane(panel);
                frame.setVisible(true);
        }

}

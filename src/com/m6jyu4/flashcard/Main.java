package com.m6jyu4.flashcard;

import javax.swing.*;

public class Main {

        public static void main(String[] args) {

                SwingUtilities.invokeLater(() -> {
                        var frame = new FlashcardFrame();
                        var panel = new FlashcardPanel(new CardDeck("res/card.txt"));

                        frame.setContentPane(panel);
                        frame.setVisible(true);
                });

        }

}

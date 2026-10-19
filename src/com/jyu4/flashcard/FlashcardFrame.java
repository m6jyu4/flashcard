package com.jyu4.flashcard;

import javax.swing.*;
import java.awt.*;

class FlashcardFrame extends JFrame {

        private String TITLE = "Flashcards";
        private static final String ICON_LOCATION = "res/icon.png";

        FlashcardFrame() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                setBackground(new Color(0x222222));

                int width = Toolkit.getDefaultToolkit().getScreenSize().width / 4;
                int height = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
                setSize(width, height);

                setIconImage(new ImageIcon(ICON_LOCATION).getImage());
                setTitle(TITLE);

                setResizable(false);
                setLocationRelativeTo(null);
        }

}

package com.m6jyu4.flashcard;

import javax.swing.*;
import java.awt.*;

public class FlashcardLabel extends JLabel {

        private static final Color TEXT_COLOUR = new Color(0xf2f2f2);
        private static final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 50);

        FlashcardLabel() {
                setForeground(TEXT_COLOUR);
                setFont(TEXT_FONT);
                setHorizontalAlignment(SwingConstants.CENTER);
        }
}

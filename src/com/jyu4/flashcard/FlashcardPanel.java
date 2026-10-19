package com.jyu4.flashcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createMatteBorder;

class FlashcardPanel extends JPanel implements ActionListener{



        private static final Color TEXT_COLOUR = new Color(0xf2f2f2);
        private static final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 50);
        private static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 25);

        private JLabel questionLabel;
        private JLabel answerLabel;
        private JLabel explanationLabel;
        private JButton button;

        private String question = null;
        private String answer = null;
        private String explanation = null;

        boolean isShowingAnswer = false;
        boolean isOutOfCards = false;

        private CardDeck deck;

        FlashcardPanel(CardDeck deck) {

                this.deck = deck;

                initPanel();
                showNextQuestion();
        }

        private void initPanel() {
                setLayout(new GridLayout(6, 1, 0, 0));
                setBackground(new Color(0x222222));

                // row 1
                add(Box.createVerticalStrut(0));

                // row 2
                var questionPanel = new JPanel();
                questionPanel.setOpaque(false);

                questionLabel = new JLabel();

                questionLabel.setForeground(TEXT_COLOUR);
                questionLabel.setFont(TEXT_FONT);
                questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

                questionLabel.setBorder(createMatteBorder(0,0,1,0, Color.WHITE));

                questionPanel.add(questionLabel);
                add(questionPanel);

                // row 3
                answerLabel = new JLabel();

                answerLabel.setForeground(TEXT_COLOUR);
                answerLabel.setFont(TEXT_FONT);
                answerLabel.setHorizontalAlignment(SwingConstants.CENTER);

                add(answerLabel);

                // row 4
                var explanationPanel = new JPanel();
                explanationPanel.setOpaque(false);
                explanationLabel = new JLabel();

                explanationLabel.setForeground(TEXT_COLOUR);
                explanationLabel.setFont(BUTTON_FONT);
                explanationLabel.setHorizontalAlignment(SwingConstants.CENTER);

                explanationPanel.add(explanationLabel);
                add(explanationPanel);

                // row 5
                add(Box.createVerticalStrut(0));

                // row 6
                var buttonPanel = new JPanel();
                buttonPanel.setOpaque(false);

                button = new JButton();
                button.setPreferredSize(new Dimension(210, 50));
                button.setVerticalAlignment(SwingConstants.CENTER);
                button.addActionListener(this);

                buttonPanel.add(button);
                add(buttonPanel);

                button.setText("Show Answer");
                button.setFont(BUTTON_FONT);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() != this.button) return;

                if (isOutOfCards) return;

                if (!isShowingAnswer) {
                        showAnswer();
                } else {
                        showNextQuestion();
                }
        }

        private void showAnswer() {
                isShowingAnswer = true;

                answerLabel.setText(answer);
                explanationLabel.setText(explanation);

                button.setText("Next Card");
        }

        private void showNextQuestion() {
                isShowingAnswer = false;

                if (!deck.hasNext()) {

                        isOutOfCards = true;

                        questionLabel.setText(null);
                        answerLabel.setText(null);
                        explanationLabel.setText(null);

                        button.setText("Done");

                        return;
                }

                Card card   = deck.next();

                question    = card.question();
                answer      = card.answer();
                explanation = card.explanation();

                questionLabel.setText(question);
                answerLabel.setText(null);
                explanationLabel.setText(null);

                button.setText("Show Answer");
        }

}

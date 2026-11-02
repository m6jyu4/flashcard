package com.m6jyu4.flashcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createMatteBorder;

class FlashcardPanel extends JPanel implements ActionListener{

        private enum State { QUESTION, ANSWER, DONE}
        private State currentState = State.QUESTION;

        private static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 25);

        private JLabel questionLabel;
        private JLabel answerLabel;
        private JLabel explanationLabel;
        private JButton button;

        private String question = null;
        private String answer = null;
        private String explanation = null;

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

                questionLabel = new FlashcardLabel();
                questionLabel.setBorder(createMatteBorder(0,0,1,0, Color.WHITE));
                questionPanel.add(questionLabel);

                add(questionPanel);

                // row 3
                answerLabel = new FlashcardLabel();
                add(answerLabel);

                // row 4
                var explanationPanel = new JPanel();
                explanationPanel.setOpaque(false);

                explanationLabel = new FlashcardLabel();
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

                if (currentState == State.DONE) return;

                if (currentState == State.QUESTION) {
                        showAnswer();
                } else {
                        showNextQuestion();
                }
        }

        private void showAnswer() {
                currentState = State.ANSWER;

                answerLabel.setText(answer);
                explanationLabel.setText(explanation);

                button.setText("Next Card");
        }

        private void showNextQuestion() {
                currentState = State.QUESTION;

                if (!deck.hasNext()) {

                        currentState = State.DONE;

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

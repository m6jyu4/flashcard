package com.m6jyu4.flashcard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class CardDeck {

        private List<Card> cards;

        private int cardIndex = 0;

        CardDeck(String path) {

                try (var reader = new BufferedReader(new FileReader(path))){
                        cards = parse(reader);
                } catch (IOException e) {
                        throw new UncheckedIOException("Failed to load card deck: " + path, e);
                }

        }

        private static List<Card> parse(BufferedReader reader) throws IOException {

                String line;
                String[] text;

                int lineNo = 0;
                List<Card> parsedCards = new ArrayList<>();

                while ((line = reader.readLine()) != null) {
                        lineNo++;
                        if (line.isBlank()) continue;

                        text = line.split(" */ *");

                        if (text.length < 2) {
                                System.out.println("Misformatted line at line: " + lineNo);
                                continue;
                        }
                        parsedCards.add(new Card(text[0], text[1], (text.length >= 3 ? text[2] : null)));

                }
                return parsedCards;
        }

        boolean hasNext() {
                return cardIndex < cards.size();
        }

        Card next() {
                return cards.get(cardIndex++);
        }

}

package com.m6jyu4.flashcard;

record Card(String question, String answer, String explanation) {
        Card {
                if (question.isEmpty()) throw new IllegalArgumentException("question blank");
                if (answer.isEmpty())   throw new IllegalArgumentException("answer blank");
        }
}

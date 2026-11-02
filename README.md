# Flashcards

A lightweight desktop flashcard reader app built with Java Swing that turns a plain-text deck into an interactive study tool.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Swing](https://img.shields.io/badge/UI-Java%20Swing-blue)

---

## Features

- Shows cards one at a time: the user sees a question, reveals the answer (and optional explanation), then advances. 
- Simple line-based card format: `question / answer / optional explanation`
- Skips blank/malformed lines and fails fast on empty question/answer

## How It Works

res/card.txt ──► CardDeck (parse) ──► Card (record) ──► FlashcardPanel (state machine) ──► UI


| State      | Button Label | Action                      |
|------------|--------------|-----------------------------|
| `QUESTION` | Show Answer  | Reveal answer + explanation |
| `ANSWER`   | Next Card    | Load next card              |
| `DONE`     | Done         | No-op (deck exhausted)      |

## Card Deck Format

Each non-blank line defines a card, fields separated by ` / `:

`ulica / street / (feminine noun)`

`miasto / city`

## Project Structure

```text
src/com/m6jyu4/flashcard/
├── Main.java            # Entry point (EDT-safe startup)
├── FlashcardFrame.java  # JFrame setup
├── FlashcardPanel.java  # UI + state machine
├── FlashcardLabel.java  # Shared styled JLabel
├── CardDeck.java        # File loading, parsing, iteration
└── Card.java            # Immutable record
```

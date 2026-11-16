---
title: Overview
description: "Summary of in-progress or completed project."
order: 0
---

{% include ddc-abbreviations.md %}

## Page contents
{:.no_toc}

{:.collapsible.collapsed}
- ToC
{:toc}

## Summary

Hand Solitaire is a simple card game played with a standard deck of playing cards. Only a few
rules are used, and the goal is to discard every card. The deck is shuffled, four cards are dealt
into the player's hand, and the newest card (the top card) is compared with the card three
positions behind it (the 4th card from the top).

## Intended users and user stories

Intended users are anyone with a few minutes to spare and an interest in cards who may not want to
play the standard type of solitaire. Hand Solitaire allows a very casual yet specific approach to
the solitaire model. I play Hand Solitaire when I want to restore peace and serenity.

- As a casual player with a few minutes to spare, I want to start a quick game with one tap so that
  I can relax without a long setup.
- As a returning player, I want to see my past games and badges so that I can track my improvement.
- As a player who likes to personalize things, I want to unlock art packages so that the game feels
  like my own.

## Functionality

- Start a new game (the deck is shuffled and four cards are dealt).
- Draw cards and discard matching cards according to the rules below.
- See a game timer and the number of cards left in the deck.
- See an end-of-game summary showing the number of cards remaining and the badge earned.
- View game history, badges earned, and best time.
- Choose a Picture Package (stretch goal).
- Change settings, such as turning sound on or off and choosing a music source.

### Order of play

1. If the top card is the same suit as the 4th card, the two cards between them are discarded.
2. If the top card is the same rank as the 4th card, all four cards are discarded.
3. If there is no match, the player draws one more card onto the front of the hand and compares the
   new top four cards in the same way.
4. If the whole deck has been drawn and the player still has cards in their hand, they can move the
   last card in the hand to the front and see how that plays, up to three times.
5. After the third move from the back, the game is over. The player has lost if any cards are left
   in their hand.

### Scoring

Scoring has only three parameters:

- Finishing by discarding all the cards during the game, which is the only way to truly win.
- The number of cards left if finishing is not possible (different award levels for 1–4, 5–8,
  9–12, and 13 or more cards remaining).
- A possible time bonus if the player beats their prior best time.

At the end of each game, the number of cards remaining in the hand is displayed and the appropriate
badge is awarded.

**_Badges_** are awarded at the following levels:

- Gold Star: the player has won the game and is awarded one Gold Star.
- Silver Star: the player is left with only 1–4 cards at the end of the game.
- Bronze Star: the player is left with 5–8 cards at the end of the game.
- Wood Star: the player is left with 9–12 cards at the end of the game.
- Lump o' Coal: the player is left with 13 or more cards at the end of the game.

## Persistent data

### Player

- Display name
- Avatar (character) selection
- Date the player was created

### Game (one record per game played)

- Player
- Start date/time
- Duration (playing time)
- Number of cards remaining at the end

From these we can calculate: games won (0 cards remaining), badge earned, best time, and win rate.

### Badge (one record per badge earned)

- Player
- Badge type (Gold, Silver, Bronze, Wood, Lump o' Coal)
- Date earned
- Source (game result or Wheel of Change)
- Date spent, if used on a Wheel of Change spin (stretch goal)

### Picture Package (stretch goal)

- Title/theme
- Museum collection object IDs and image URLs for the background and card back
- Music reference
- Whether the player has unlocked it

### Settings (stored as app preferences, not in the database)

- Sound on/off
- Music source (in-app or the device's own music)
- Currently selected Picture Package

## Device/external services

- Art images for Picture Packages from a museum collection API. A likely candidate is The
  Metropolitan Museum of Art Collection API (free, no key required); the source is still to be
  confirmed.
- A music source for Picture Packages (to be determined).
- Internet access to download images, and caching of downloaded images on the device.

## Stretch goals and possible enhancements

**_Leveling up:_**
After two unsuccessful games, during which a player earns badges according to the number of cards
remaining in their hand (as listed above), they will be offered a chance on the "Wheel of Change".
The player is given one spin at the cost of their lowest available badge. The wheel is not without
risk!

**_Wheel of Change:_**
Four slots land on a (possibly) higher-level badge, which is then associated with a "Picture
Package" allowing the player to change the environment in which they are playing. One slot allows
the player to spin again, and one slot ends the game immediately.

**Wheel of Change slots:**

- 4 Badge slots (1 each of Gold, Silver, Bronze, and Wood)
- 1 Spin-Again slot
- 1 Game Over slot
- 1 Extra Life slot (allows the player to play again after a loss)

[//]: # (TODO Decide whether the wheel has 7 slots or needs an 8th slot)

**Best-Time addendum:**
When a player beats their best time, the Wheel of Change appears immediately. The Game Over slot is
replaced randomly by any of the other slot types, except Wood or Bronze.

**Picture Packages:**
The player starts with a standard environment, which can be changed and personalized as the player
progresses. After either completing a Wheel of Change challenge successfully or winning a game, the
player will have the option to change their "Picture Package". Each package will be built from one
or more art API sources (see [Device/external services](#deviceexternal-services)) to provide both
background images for the screen and card backs. These will be grouped by theme into a package and
displayed together. They will be joined by music that complements the images. Sound can always be
turned off in settings, or the player can choose to play their own device's music through the app
instead.

## Credits, copyrights, and license information

Code, build scripts, workflow definitions, and instructional content written by Kristen Ekedal.

&copy; 2026 Kristen Ekedal.

[//]: # (TODO Add license info)

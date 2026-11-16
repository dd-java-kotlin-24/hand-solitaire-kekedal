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

  A simple game in which a small set of cards is displayed and a very few
  rules are utilized on a standard deck of playing cards with the goal being to discard
  all cards. The deck is shuffled to begin, four cards are dealt to the player, and the
  top card has to correlate to the bottom card in the hand.

###    Order of play:

      1. If the top card is of the same suit as the bottom card, the middle two cards are discarded.
      2. If the top card is the same rank as the bottom card, all four cards are discarded.
      3. If the top card is neither the same suit nor the same rank as the bottom card, the player draws another card and looks to what is now the fourth card back (what was the original third to last card) and makes the same assessment, and so on.
      4. If the whole deck is gone through and the player still has cards in their hand, they can pull the last card to the front, and see how that plays, up to three times.
      5. After the third pull from the back, the deck is played out and the player has lost if any cards are left in their hand.
      6. A count of the cards remaining in the hand is displayed and the appropriate badge is assigned.

### Intended users and user stories

  * Types of intended users are anyone with a few minutes to spare and an interest in cards that may
    not want to play the standard type of solitaire. Hand solitaire allows a very casual yet specific
    approach to the solitaire model. I play hand solitaire when I want to restore peace and serenity.

## Functionality

### Scoring

    Scoring has only three parameters: finishing by way of discarding all the cards during
    the course of the game, which is the only way to truly win; the amount of cards left if
    finishing is not possible (different award levels for 1-4, 5-8, 9-12, and 13 or more cards
    remaining); and then there may be a time bonus if the player beats their prior time.

  **_Badges_** are awarded in the following levels:
*     Gold Star - the player has won the game and is awarded one Gold Star.
*     Silver Star - the player is left with only 1-4 cards at end of game.
*     Bronze Star - the player is left with 5-8 cards at end of game.
*     Wood Star - the player is left with 9-12 cards at end of game.
*     Lump o'Coal - the player is left with 13+ cards at end of game.

### Persistent data

### Player data:

    * name
    * character (avatar)
    * games won
    * game played and cards remaining
    * individual game playing time
    * badge awarded
    * deck art collected
    * background art collected

### Device/external services

MOMA API data, there are 9 freely available API's, and currently I am not sure of which ones
I would like to employ, but I know they would need to be used here.

### Stretch goals and possible enhancements

**_Leveling up:_**
    After two unsuccessful games, during which a player achieves badges according
    to the remaining cards in their hand (as listed above) they will be offered a chance on the “wheel
    of change”. The player is given one spin at the cost of their lowest available badge. The wheel is
    not without risk!

**_Wheel of Change:_**  
    There are 8 slots on the wheel:  4 land on a (possibly) higher-level badge which
    is then associated with a “Picture Package” allowing the player to change the environment in which
    they are playing. Two slots allow the player to “spin again” and the slot ends the game 
    immediately.

    If a player beats their best-time, the “wheel of change” appears immediately, with the added bonus
    of the “game over” slots are replaced with two of the other game token slots, randomly.

**Wheel of Change (8) slots:**
*     4 Badge slots (1 each of Gold, Silver, Bronze and Wood)
*     2 Spin-Again slots
*     1 GAME OVER slot
*     1 Extra Life slot (allows the player play again after a loss)

**Best-Time addendum:**
    When a player beats their best time, the wheel appears immediately without the “Game Over” slot,
    which are replaced randomly by any of the other categories of slots, except Wood or Bronze.

**Picture Packages**: The player will be presented with an initial standard environment which can only
be changed and personalized as the player progresses. After either completing a Wheel of Change
challenge successfully or winning a game, the player will have an option to alter their “Picture
Package”. The package will be derived from a few API sources, including the Museum of Metropolitan
Art, to provide both background images for the screen and card backs. These will be theme-clustered
together as a package and populate the screen together. They will be joined by another outside
source of music that will be complementary to the images. Sound can always be turned off in settings
OR opted for a native music source at the players discretion to play through the app instead.

### Credits, copyrights, and license information

### Code, build scripts, workflow definitions, and instructional content written

by Kristen Ekedal (with ____________________).

&copy; 2026 by (Kristen Ekedal).

[//]: # (TODO Add license info)

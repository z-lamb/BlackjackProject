## Blackjack Project

### Week 3 Weekend Homework for SKill Distillery

### Summary
This program allows a user to play the game of Blackjack also known as twenty-one. This program was created with just under three weeks of bootcamp. One of the big things that we hit on this week was Collections which I was able to incorporate into this project. We also hit on enum for a class which we used to set the rank and value of the cards. Overall I thought this program was fun to code and wish I had more time to work on it to add the things I was not able to incorporate.

### Overview
The program runs out of many different classes with each one doing a specific function. You are first provided a menu to see the rules, start a new game, or end the program.

#### Classes Overview
These classes are stored in a separate package so that they can be used to build other programs that might use a deck of cards.
- Deck
- Card
- Abstract Hand
- Enum Rank
- Enum Suit
These classes are specific to the Blackjack game.
- BlackjackApp
- PlayerHand (extends Hand)
- HouseHand (extends Hand)
- GameMenu
- GameOperator

##### Classes Breakdown

Enum Suit:
- this class builds out suits of the cards

Enum Rank:
- this class builds out the ranks of all the cards

Deck:
- this class builds a deck of 52 cards and allows us to check on different qualities of the card

Card:
- this class allows us to look at card for the suit and rank as needed from other classes

Abstract Hand:
- this class allows us to build out a hand we can extend from to have all of the methods a hand might need

BlackjackApp:
- contains the main method to be able to start the program

PlayerHand (extends Hand):
- keeps track of the players hand information

HouseHand (extends Hand):
- keeps track of the house hand information

GameMenu:
- allows the user to choose from a menu to see the rules of the game, start a game, or quit the program

GameOperator:
- contains all the methods for playing the game

### Operation/Description of how the program works:

Game starts by welcoming the user to Blackjack
- this is done by from the main creating an instance of itself and calling the launch method
- inside the launch method it calls the GameMenu class and send the program to the menuOptions method

The user is prompted to enter their name and then the menu is displayed where they can choose what they would like to do
1. Display Rules
2. Start a new game
3. Quit

If the user selects option 1 the rules for Blackjack will be displayed.
If the user selects option 2 a new game will be started.
If the user selects option 3 the program will quit.

When a new game starts the user is given 1 card face up and then the dealer/house is given 1 card face down. The user is then given another card face up and the dealer/house is given a card face up.

If the user has 21 and the dealer/house does not have 21 the round is over and the user wins.

If the user has less than 21 they are given the option to stay or hit. If the user opts to hit they will be given another card face up and they will be given the option to stay or hit again. They can do this as many times as they would like. Once they user decides to stay the dealer/house will draw cards until they reach at least a hand of 17.

If at any point the user or the dealer/house goes over 21 the round is over. If neither went over the two hands are compared and the higher hand wins.

The user is given the opportunity to do another round or they can end the round. If they opt to end the round they will be taken to the main menu where they will be able to make a selection from there.

### Technologies/Techniques Used
- created an instance of the main application to be able to launch the app inside of the main and have that be the only method in there.
- call other methods from classes and pass information to and from them
- declare and create new objects
- print out
- Scanner
- pass Scanner through to other methods and other classes as needed
- while loop
- switch
- overloaded method
- getters/setters
- enum
- toString
- constructors
- Abstract class
- Collections
- foreach loop
- hashCode
- equals
- do while loop
- if statements
- continue
- break
- boolean
- for loop



### Lessons Learnedd
- I learned how to start and close one scanner by passing the scanner through the method calls
- I was able to better refactor and have smaller methods and had very little repeating code.
- I also was able to have the app be just the main app and have the rest of the program running in other classes
- I have a better understanding of how to call other methods from different classes and obtain the information that I need from them or send information to them
- Stick to the provided UML and it will give you a jump start on the direction you are supposed to go
- One thing that caught me up for a while was how I was going to add a card to a hand and also get its value at the same time. I realized I needed to grab a card from the deck first. Look at the value and add it to the total as well as add it the hand. My issue was that I was grabbing from the deck and putting it into the hand at the same time.
- I also had to work for a bit on figuring out how to print just the second card from the house hand instead of the whole hand. With some colaboration I was pointed in the right direction by  the TA of the class and was able to come up with a simple solution. I was going to first add it to an array with a size of one and then add everything else to an ArrayList. I was stuck in the pattern thinking before I got some outside input.
- Something that I realized later in the program was that each time a new round was started I would create a new instance of a player hand on the heap. In order to keep a new object from going on the heap each round I figure out how to just clear the hand and total points instead.

### Problems/Issues
- One of the bigger issues I ran into was how to make the logic work out for all of the different rules for Blackjack
- I also had an issue with how to make one of the menus options work where if the user did not enter one of the options it would not loop correctly
	- The first way I tried was the switch but that was giving me issues when the user would not enter the correct thing
	- My work around for this was to create an ArrayList that held the proper selections and then used the .contains() method to see if the user input was a menu option. I then had to run a second loop to see if they entered one of the options and if they didn't the menu would print again.
- One issue that took me a little bit to figure out was how to call a method where I needed the value but had to use three ".methodCall()" to finally get what I needed
- I don't think I did the app correct and believe I could have not created an instance of the app itself and then call a method inside the main that calls a different class. Seems like a lot of extra to me.
- There are a few times where I reset the userInput to a blank string ("") because I didn't know if the previous userInput would messup the options for the new option it needed to check against

- I was unsure I should have more classes to break up the GameOperation class more as there is a lot of code currently in itt

### Things I was unable to add or incorporate
- Test Driven Development with JUnit tests
- Soft Ace where an Ace can be 11 or 1
- A display that would show what round you are on
- A statistic class to keep track of games played, rounds played, wins/loses
- A monetary system for placing bets
- Allow a player to split hands if they get a double
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  //here the 8 instance variables are declared
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel currGuessLabel;
  JLabel accuracyLabel;
  JLabel lastGuessLabel;
  Random r;
  int randomNum;

  //constructor
  GuessingGame(){
    //the random number is initialized
    Random r = new Random();
    randomNum = r.nextInt(100);
    //frame is initialzied and set
    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);
    //textfield is initialized
    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");
    //the buttons are initialzed here
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");
    //the action listeners are added
    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);
    //labels are set 
    currGuessLabel = new JLabel("Enter your guess: ");
    accuracyLabel = new JLabel("");
    lastGuessLabel = new JLabel("");
    //adding the items to the frame and making it visible
    frame.add(currGuessLabel);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(accuracyLabel);
    frame.add(lastGuessLabel);
    frame.add(playAgainButton);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    //here we get what the user guessed and see if it's equal to the random number
    int guess = Integer.parseInt(userGuess.getText());

    if(ae.getActionCommand().equals("Guess")){
      if (guess > randomNum){
        accuracyLabel.setText("Too high!");
      }
      else if (guess < randomNum){
        accuracyLabel.setText("Too low!");
      }
      else if (guess == randomNum) {
        accuracyLabel.setText("You got it!");
      }
      lastGuessLabel.setText("Last guess was " + guess);
    }
    else if(ae.getActionCommand().equals("Play Again")){
      currGuessLabel.setText("Enter your guess: ");
      accuracyLabel.setText("");
      lastGuessLabel.setText("");
      userGuess.setText("");
      randomNum = r.nextInt(100);
    }
    else {
      accuracyLabel.setText("You pressed Enter. Please press the Guess Button.");
    }
}
}

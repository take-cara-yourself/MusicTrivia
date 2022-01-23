// AVRILLAVIGNE Class

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import sun.audio.*;
import java.io.*;

 public class AVRILLAVIGNE implements questions
 {
  String artist = "AVRILLAVIGNE";
  boolean asked = false;
  
  public AVRILLAVIGNE()
  {
  }
  
  // Checks if the artist's name inputed by the user is correct
  // Pre: User inputs a guess
  // Post: If the name is the same returns 1, if not returns 0
   public int artistName(String guess)
   {
 	 guess = guess.toUpperCase(); // Converts answer to upper case
    guess = guess.replaceAll("\\W", ""); // Deletes all non-words
    guess = guess.replaceAll("THE", ""); // Deletes any "the"s in the answer

    if (guess.equals(artist))
    {
     return(1);
    }
    else
    {
     return(0);
    }
   }
   
   // Plays a sound clip that corresponds to the question
   // Pre: none
   // Post: A sound clip is played
   public void playSound()
   {
    AudioPlayer MGP = AudioPlayer.player;// Creates audio player
    AudioStream BGM;
    AudioData MD;
    AudioDataStream play = null;// Stream for audio to be played once
    
    try
    {
     BGM = new AudioStream(new FileInputStream("AVRILLAVIGNE.wav"));// Imports audio file
     MD =  BGM.getData();
     play = new AudioDataStream(MD);
     MGP.start(play);// Plays audio file
     asked = true;
    }
    catch(IOException error) 
	 {
	  System.out.println("Error 401 File Not Found AVRL");// Exception if audio file is not found
	 }
   }   
  
   // Checks if the sound clip has been played or not
   // Pre: none
   // Post: 0 is returned if the song has not been played, 1 is returned if it has
   public int check()
   {
    if (asked == false)
    {
     return(0);
    }
    else
    {
     return(1);
    }
   }
  }
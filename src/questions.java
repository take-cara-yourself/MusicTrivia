// Programmer: Cara McNeil
// Description: Interface for the questions classes
// Date Created: 14/06/2018
// Date Modified: /06/2018

 interface questions
 {
  String artist = null;
  boolean asked = false;
  public int artistName(String guess);// Will return an int that will be added to the user's score
  public void playSound();// Will play sound that corresponds with class
  public int check();// Will check if the question has been asked
 }
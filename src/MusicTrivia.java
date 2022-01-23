// Programmer: Cara McNeil
// Description: ISU Music Trivia Game. Runs a GUI with options for a user to click a button to hear a song, enter a guess of an artist's name and then submit that answer to test their music knowledge.
// Date Created: 14/06/2018
// Date Modified: 18/06/2018

import java.awt.*;// Imports required package for GUIs
import java.awt.event.*;// Imports required package for GUIs
import javax.swing.*;// Imports required package for GUIs
import java.util.Random;// Generates random numbers


 public class MusicTrivia extends JFrame implements ActionListener
 {
  JFrame frame = new JFrame("Music Trivia");// Creates GUI frame
  JPanel contentPane;
  JLabel instructions, question, submitted;// String labels that will contain ins and que, the instructions for the game and question that prompts the user's input
  JButton okay, submitAnswer, song, nextQuestion, results;
  JTextField input;// For entering user input
  String answer;// For checking user's input
  int points;
  // Uses html to format the JLabel
  String ins = "<html>Welcome to MUSICTRIVIA 2000s Edition! How many arists can you name? <br/>Listen to the song by pressing the play button, <br/>then input the name of the artist who sang that song. <br/>Wait until the audio stops before submitting your answer. <br/>Spelling counts! Good luck!!</html>";
  String que = "What artist sings this song?";
  String sub = "Your answer has been submitted.";
  int score = 0;// Keeps track of score
  int questionCounter = 0;// Keeps track of questions asked
  int randG;//Used to pick a random group
  int stop = 0;
  int red, green, blue;
  
  // Question objects
  AVRILLAVIGNE a = new AVRILLAVIGNE();
  BEYONCE b = new BEYONCE();
  BLACKEYEDPEAS c = new BLACKEYEDPEAS();
  BRITNEYSPEARS d = new BRITNEYSPEARS();
  EMINEM e = new EMINEM();
  FALLOUTBOY f = new FALLOUTBOY();
  GREENDAY g = new GREENDAY();
  JUSTINTIMBERLAKE h = new JUSTINTIMBERLAKE();
  KANYEWEST i = new KANYEWEST();
  KATYPERRY j = new KATYPERRY();
  KELLYCLARKSON k = new KELLYCLARKSON();
  LADYGAGA l = new LADYGAGA();
  MARIANASTRENCH m = new MARIANASTRENCH();
  MAROON5 n = new MAROON5();
  NICKELBACK o = new NICKELBACK();
  NODOUBT p = new NODOUBT();
  OUTCAST q = new OUTCAST();
  PITBULL r = new PITBULL();
  RIHANNA s = new RIHANNA();
  SHAKIRA t = new SHAKIRA();
  USHER u = new USHER();
 
 
  public MusicTrivia()
  {
   //JFrame.setDefaultLookAndFeelDecorated(true);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   contentPane = new JPanel();// Creates a content pane with a BoxLayout and empty borders
	contentPane.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));//Sets size of frame
	contentPane.setBackground(new Color(0, 0, 0));// Sets background colour to black
	contentPane.setLayout(new FlowLayout());
     
	instructions = new JLabel(ins);
	instructions.setAlignmentX(JButton.CENTER_ALIGNMENT);
   instructions.setForeground(Color.white);
   contentPane.add(instructions);// Adds content pane to frame
   
   question = new JLabel(que);
	question.setAlignmentX(JButton.CENTER_ALIGNMENT);
   question.setForeground(Color.white);
   contentPane.add(question);// Adds content pane to frame
   question.setVisible(false);// The question is hidden until later
	
   okay = new JButton("Okay");
   frame.add(okay);
	okay.setLocation(200,200);
   okay.addActionListener(this);
   contentPane.add(okay);
   
   song = new JButton("Play");
   frame.add(song);
	song.setAlignmentX(JButton.CENTER_ALIGNMENT);
   song.setForeground(new Color(29, 209, 35));
   song.addActionListener(this);
   contentPane.add(song);
	song.setVisible(false);// The play button is hidden until later
   
	input = new JTextField();
   input.setPreferredSize(new Dimension(400, 24));
	contentPane.add(input, BorderLayout.NORTH);
	input.setVisible(false);
   
   submitAnswer = new JButton("Submit Answer");
   frame.add(submitAnswer);
	submitAnswer.setAlignmentX(JButton.CENTER_ALIGNMENT);
   submitAnswer.setForeground(new Color(242, 41, 41));
   submitAnswer.addActionListener(this);
   contentPane.add(submitAnswer);
	submitAnswer.setVisible(false);// The Submit ANswer button is hidden until later
   
   submitted = new JLabel(sub);
	submitted.setAlignmentX(JButton.CENTER_ALIGNMENT);
   submitted.setForeground(Color.white);
   contentPane.add(submitted);// Adds content pane to frame
   submitted.setVisible(false);
   
   nextQuestion = new JButton("Next Question");
   frame.add(nextQuestion);
	nextQuestion.setAlignmentX(JButton.CENTER_ALIGNMENT);
   nextQuestion.setForeground(Color.blue);
   nextQuestion.addActionListener(this);
   contentPane.add(nextQuestion);
	nextQuestion.setVisible(false);// The nextQuestion button is hidden until later
   
   results = new JButton("Results");
   frame.add(results);
	results.setAlignmentX(JButton.CENTER_ALIGNMENT);
   results.setForeground(new Color(239, 165, 16));
   results.addActionListener(this);
   contentPane.add(results);
	results.setVisible(false);// The results button is hidden until after 9 questions have been answered
   
   frame.setContentPane(contentPane);//Adds content pane to frame
	frame.pack();// Sizes and then displays the frame
	frame.setVisible(true);
  }
  
  // Various event happen depending on what button is pressed
  // Pre: A button is pressed
  // Post: Event corresponding to that button transpire
  public void actionPerformed(ActionEvent event)
  {
   String eventName = event.getActionCommand();
   
   Random rC = new Random();
   red = rC.nextInt(255 - 0 + 1) + 0;// Randomly selects a number between 0 and 255
   green = rC.nextInt(255 - 0 + 1) + 0;// Randomly selects a number between 0 and 255
   blue = rC.nextInt(255 - 0 + 1) + 0;// Randomly selects a number between 0 and 255
   contentPane.setBackground(new Color(red, green, blue));// Sets background colour to a special pink shade
	 
	if (eventName.equals("Okay"))
   {
    // Hides the okay button and the game's instructions, shows the game layout (play button, submit answer button and inout box)
    okay.setVisible(false);
	 instructions.setVisible(false);
    question.setVisible(true);
    song.setVisible(true);
	 input.setVisible(true);
    submitAnswer.setVisible(true);
   }
   
   if (eventName.equals("Play"))
   {
    if (stop == 0)// Keeps music from overlapping if the play button is pressed before entering the next round
    {
     music();// Runs music() method
     stop = 1;
    } 
   }
   
   if (eventName.equals("Submit Answer"))
   {
    questionCounter += 1;
    answer = input.getText();// Gets inputed answer from the JText Field
    
    if (randG == 1)// Checks if answer is right depending on which sound clip was played
    {
     score += a.artistName(answer);
    }
    else if (randG == 2)
    {
     score += b.artistName(answer);
    }
    else if (randG == 3)
    {
     score += c.artistName(answer);
    }
    else if (randG == 4)
    {
     score += d.artistName(answer);
    }
    else if (randG == 5)
    {
     score += e.artistName(answer);
    }
    else if (randG == 6)
    {
     score += f.artistName(answer);
    }
    else if (randG == 7)
    {
     score += g.artistName(answer);
    }
    else if (randG == 8)
    {
     score += h.artistName(answer);
    }
    else if (randG == 9)
    {
     score += i.artistName(answer);
    }
    else if (randG == 10)
    {
     score += j.artistName(answer);
    }
    else if (randG == 11)
    {
     score += k.artistName(answer);
    }
    else if (randG == 12)
    {
     score += l.artistName(answer);
    }
    else if (randG == 13)
    {
     score += m.artistName(answer);
    }
    else if (randG == 14)
    {
     score += n.artistName(answer);
    }
    else if (randG == 15)
    {
     score += o.artistName(answer);
    }
    else if (randG == 16)
    {
     score += p.artistName(answer);
    }
    else if (randG == 17)
    {
     score += q.artistName(answer);
    }
    else if (randG == 18)
    {
     score += r.artistName(answer);
    }
    else if (randG == 19)
    {
     score += s.artistName(answer);
    }
    else if (randG == 20)
    {
     score += t.artistName(answer);
    }
    else if (randG == 21)
    {
     score += u.artistName(answer);
    }
    
    if (questionCounter < 9)// Goes theough 9 rounds
    {
     song.setVisible(false);
	  input.setVisible(false);
     submitAnswer.setVisible(false);
     question.setVisible(false);
     submitted.setVisible(true);
     nextQuestion.setVisible(true);
    }
    else// After final round gives user options to see their results
    {
     song.setVisible(false);
	  input.setVisible(false);
     submitAnswer.setVisible(false);
     question.setVisible(false);
     submitted.setVisible(true);
     results.setVisible(true);
    }
   }
   
   if (eventName.equals("Next Question"))// Resets GUI for next round
   {
    submitted.setVisible(false);
    nextQuestion.setVisible(false);
    question.setVisible(true);
    song.setVisible(true);
    input.setText("");
	 input.setVisible(true);
    submitAnswer.setVisible(true);
    stop = 0;
   } 
    
   if (eventName.equals("Results"))// Displays user's results in a JOption Pane box
   {
    if (score <= 3)
    {
     JOptionPane.showMessageDialog(null, "You got " + score + " answers correct. \nYou didn't do so well, are you sure you know music? Doesn't seem like you do...");
     System.exit(0);
    }
    else if (score <= 6)
    {
     JOptionPane.showMessageDialog(null, "You got " + score + " answers correct. \nNot bad, you could do better though.");
     System.exit(0);
    }
    else if (score <= 8)
    {
     JOptionPane.showMessageDialog(null, "You got " + score + " answers correct. \nWow that was really great, only 1 off! Try again, I'm sure you can get a perfect score!");
     System.exit(0);
    }
    else
    {
     JOptionPane.showMessageDialog(null, "You got " + score + " answers correct. \nA perfect 9/9. I'm impressed. Either that or you cheated and you should be ashamed of yourself.");
     System.exit(0);
    }
   }
   
  }
  
  // Plays sound file that corresponds with the object/randomly generated number. Recures if the object's sound has already been played
  // Pre: none
  // Post: A new sound has been played
  public void music()
  {
   Random rand = new Random();
   // r.nextInt(highNum - lowNum + 1) + lowNum (formula for random number generator)
   randG = rand.nextInt(21 - 1 + 1) + 1;// Randomly selects a number between 1 and 21
   
   if (randG == 1)
   {
    if (pChecker(a) == 0)// Runs pChecker method to see if the song has ben played
    {
     a.playSound();// Plays sound
    }
    else
    {
     music();// Recures
    }
   }
   else if (randG == 2)
   {
    if (pChecker(b) == 0)
    {
     b.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 3)
   {
    if (pChecker(c) == 0)
    {
     c.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 4)
   {
    if (pChecker(d) == 0)
    {
     d.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 5)
   {
    if (pChecker(e) == 0)
    {
     e.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 6)
   {
    if (pChecker(f) == 0)
    {
     f.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 7)
   {
    if (pChecker(g) == 0)
    {
     g.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 8)
   {
    if (pChecker(h) == 0)
    {
     h.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 9)
   {
    if (pChecker(i) == 0)
    {
     i.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 10)
   {
    if (pChecker(j) == 0)
    {
     j.playSound();
      
    }
    else
    {
     music();
    }
   }
   else if (randG == 11)
   {
    if (pChecker(k) == 0)
    {
     k.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 12)
   {
    if (pChecker(l) == 0)
    {
     l.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 13)
   {
    if (pChecker(m) == 0)
    {
     m.playSound(); 
    }
    else
    {
     music();
    }
   }
   else if (randG == 14)
   {
    if (pChecker(n) == 0)
    {
     n.playSound(); 
    }
    else
    {
     music();
    }
   }
   else if (randG == 15)
   {
    if (pChecker(o) == 0)
    {
     o.playSound(); 
    }
    else
    {
     music();
    }
   }
   else if (randG == 16)
   {
    if (pChecker(p) == 0)
    {
     p.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 17)
   {
    if (pChecker(q) == 0)
    {
     q.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 18)
   {
    if (pChecker(r) == 0)
    {
     r.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 19)
   {
    if (pChecker(s) == 0)
    {
     s.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 20)
   {
    if (pChecker(t) == 0)
    {
     t.playSound();
    }
    else
    {
     music();
    }
   }
   else if (randG == 21)
   {
    if (pChecker(u) == 0)
    {
     u.playSound();
    }
    else
    {
     music();
    }
   }
  }
  
  // Checks if a sound clip corresponding to an object has been played
  // Pre: Object is sent
  // Post: Returns 0 if unplayed, 1 if already played
  public int pChecker(questions y)// Uses "questions" interface
  {
   int points;
   points = y.check();
   return(points);
  }
  
  private static void runGUI()
  {
   //JFrame.setDefaultLookAndFeelDecorated(true);
   MusicTrivia greeting = new MusicTrivia();
  }
  
  public static void main(String[] args)// Methods that create and show a GUI should be run from an event-dispatching thread.
  {
   javax.swing.SwingUtilities.invokeLater(new Runnable()
   {
    public void run()
    {
     runGUI();
    }
   });
  }
 }
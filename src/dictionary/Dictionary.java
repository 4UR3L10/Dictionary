package dictionary;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Dictionary
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Variable Declarations.       
        String menu = "Enter an option:\n[1] Enter Word\n[2] Enter Definition\n[3] Display Lists\n[4] Remove From The List\n[5] Exit";
        boolean endLoop = false;

        // Create a book list object.
        WordList words = new WordList();       

        while (!endLoop)
        {
            // Getting the user input as String.
            String tempString = JOptionPane.showInputDialog(menu);

            try
            {
                // Converting the user input from String to int to use it in the switch statement.
                int convertedChoice = Integer.parseInt(tempString);

                // MENU.
                switch (convertedChoice)
                {
                    // Accept word.
                    case 1:
                        // Getting the user input as String.
                        String word = JOptionPane.showInputDialog("Enter the Word:");
                        words.insertWord(new WordMeaning(word)); 
                        break;
                    
                    // Add meaning(s).    
                    case 2:
                        // Getting the user input as String.
                        String findWord = JOptionPane.showInputDialog("Enter the Word:");
                        if (words.searchWord(new WordMeaning(findWord)))
                        {
                            String insertMeaning = JOptionPane.showInputDialog("Enter the Definition:");
                           
                            try
                            {
                                if (insertMeaning.charAt(0) == '-')
                                {
                                    words.insertDefinition(new WordMeaning(insertMeaning));
                                }
                                else
                                {
                                    throw new MyException(insertMeaning);
                                }
                            }
                            catch (Exception e)
                            {
                                display(e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            // try catch (validate for definiton)
                            display("Word Not Found", "Error", JOptionPane.ERROR_MESSAGE);                       
                        }
                        
                        break;    
                        
                    // Show List(s).    
                    case 3:
                        // Showing the Attributes of the File in a Scroll Pane
                        showScrollPane(words.toString(), "Current List", JOptionPane.INFORMATION_MESSAGE);
                        showScrollPane(words.deleteToString(), "Deleted List", JOptionPane.INFORMATION_MESSAGE);                        
                        break;
                        
                    // Remove From The List.    
                    case 4:
                        // Getting the user input as String.
                        String searchWord = JOptionPane.showInputDialog("Enter the Word:");
                        if(words.searchWord(new WordMeaning(searchWord)))
                        {
                           words.deleteWord(new WordMeaning(searchWord));
                        }
                        else
                        {
                            display("Word Not Found", "Error", JOptionPane.ERROR_MESSAGE);         
                        }                        
                        break;    
                        
                    // EXIT.    
                    case 5:
                        endLoop = true;
                        break;

                    // Else display message none was selected.    
                    default:
                        display("This option is not acceptable", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } 
            // Else there was an error about the input.
            catch (NumberFormatException | NullPointerException e)
            {
                display("Enter a value", e.toString(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Template Method for Messages.
    static void display(String message, String windowsName, int typeOfMessage)
    {
        JOptionPane.showMessageDialog(null, message, windowsName, typeOfMessage);
    }
    
    // Method for the scroll pane.
    static void showScrollPane(String resultString, String heading, int MESSAGE_TYPE)
    {
        JTextArea textAreaObject = new JTextArea(resultString, 20, 50);
        JScrollPane scrollPaneObject = new JScrollPane(textAreaObject);
        JOptionPane.showMessageDialog(null, scrollPaneObject, heading, MESSAGE_TYPE);
    }
}

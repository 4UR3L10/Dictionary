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
        String menu = "Enter an option:\n[1] Enter Word with Meaning\n[2] Display List\n[3] Remove From The List\n[4] Exit";
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
                    // Accept word with meaning.
                    case 1:
                        // Getting the user input as String.
                        String word = JOptionPane.showInputDialog("Enter the Word:");
                        String meaning = JOptionPane.showInputDialog("Enter the Definition:");

//                        try-cathch
                        words.insert(new WordMeaning(word));
                        break;

                    // Show List(s).    
                    case 2:
//                        display("Not Defined Yet", "Alert!", JOptionPane.PLAIN_MESSAGE);
                        // Showing the Attributes of the File in a Scroll Pane
                        showScrollPane(words.toString(), "Input File Attributes", JOptionPane.INFORMATION_MESSAGE);
                        break;
                        
                    // Remove From The List.    
                    case 3:
                        display("Not Defined Yet", "Alert!", JOptionPane.PLAIN_MESSAGE);
                        break;    
                        
                    // EXIT.    
                    case 4:
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

//        books.insert(new Book("Danger on the Waters"));
//        books.insert(new Book("Paradise Lost"));
//        books.insert(new Book("Building Bridges"));
//        books.insert(new Book("Hall Mark of Fame"));

//        System.out.println(books.toString());
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

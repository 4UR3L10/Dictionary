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
        String menu = "Enter an option:\n[1] Enter Word with Meaning\n[2] Enter Meaning\n[3] Display Lists\n[4] Remove From The List\n[5] Exit";
        boolean endLoop = false;

        // Create a book list object.
        WordList words = new WordList();
        WordList deleteWords = new WordList();

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

//                       try-cathch(own exception)(validate for definiton)
                        words.insert(new WordMeaning(word),new WordMeaning(meaning)); 
                        break;
                    
                    // Add meaning(s).    
                    case 2:
                        // Getting the user input as String.
                        String findWord = JOptionPane.showInputDialog("Enter the Word:");
                        if(words.searchWord(new WordMeaning(findWord)))
                        {
                           String insertMeaning = JOptionPane.showInputDialog("Enter the Definition:"); 
                           words.InsertOrganizeDefinitions(new WordMeaning(insertMeaning));
                        }
                        else
                        {
                            // joption pane and try catch (validate for definiton)
                            System.out.println("word not found");
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
                            // joption pane and try catch (validate for word)
                            System.out.println("word not found");
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

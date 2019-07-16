package dictionary;

import javax.swing.JOptionPane;

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
//        BookList books = new BookList();

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
                        display("Not Defined Yet", "Alert!", JOptionPane.PLAIN_MESSAGE);
                        break;
                        
                    // Show List.    
                    case 2:
                        display("Not Defined Yet", "Alert!", JOptionPane.PLAIN_MESSAGE);
                        break;
                        
                    // Show List.    
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
}

package dictionary;

import javax.swing.JOptionPane;

public class WordList
{
//    private WordMeaningNode list, last;
    private WordMeaningNode list;
    private WordMeaningNode wordFounded;
    private WordMeaningNode wordBeforeFounded;
    private WordMeaningNode deleteList;

    // This constructor creates an empty list.    
    WordList() 
    {
        list = null;
    }

    // Insert a word and a definition and order them.
    public void insert(WordMeaning w, WordMeaning d) 
    {
        // Creating two temp nodes that hold the word and defintion.
        WordMeaningNode temp = new WordMeaningNode(w);
        WordMeaningNode tempd = new WordMeaningNode(d);
        
        // Creating two temp nodes that will hold the node before and after the current node.
        WordMeaningNode current = list;   
        WordMeaningNode back = null;
        
        // Boolean to stop while loop.
        boolean found = false;

        // While there is nodes go throught the linkedlist.
        while (current != null && !found)
        {
            // Comparing the word with the nodes values to sort.
            if (temp.word.getString().compareTo(current.word.getString()) < 0)
            {
                found = true;
            } else
            {
                back = current;
                current = current.next;
            }
        }

        // Hold nodes so we don't erase part of the linked list.
        temp.next = current;

        if (back == null)
        {
            list = temp;
        } else
        {
            // Finish the joining.
            back.next = temp;
        }

        /*Modifiying the values.*/
        // The inserted now is the back.      
        back = temp;
        // The next node of the back is now the current.
        current = back.next;

        /* 
        Doing the insertion of the definition next to the word
        without losing any nodes of the linkedlist.
         */
        tempd.next = current;
        back.next = tempd;
    }
        
    // Search the word in the dictionary (nodes).
    public boolean searchWord(WordMeaning findWord)
    {   
       // Creating a current node that will hold the value from the begining node. 
       WordMeaningNode current = list; 
        
        while (current != null)
        {
            if (findWord.getString().equalsIgnoreCase(current.word.getString()))
            {     
                wordFounded = current;
                return true;
            }
            wordBeforeFounded = current;
            current = current.next;
        }
        return false;
    }
    
    // Inserting and sorting by definitions.
    public void InsertOrganizeDefinitions(WordMeaning definition)
    {
        // Creating a current node that will hold the value from the word founded node. 
        //WordMeaningNode current = wordFounded;
        WordMeaningNode current = wordFounded.next;
        
        // Creating a temporary node 
        WordMeaningNode back = null;
         WordMeaningNode tempDefinition = new WordMeaningNode(definition);
         back = current; //----------------------------------------------------------
        
        // Boolean to stop while loop.
        boolean endLoop = false;
        
        // While there are defnitions and the next is not null.
        do
        {
            System.out.println(current.word.getString());

            if (current.word.getString().charAt(0) != '-') 
            {
                endLoop = true;
                tempDefinition.next = current;
                back.next = tempDefinition;
            }

            if (current.next == null)
            {
                endLoop = true;
//                current.next = tempDefinition; good

                if (tempDefinition.word.getString().compareTo(current.word.getString()) < 0) //testing
                {//testing
                    tempDefinition.next = current;//testing
                    wordFounded.next = tempDefinition;//testing
                }//testing
                else//testing
                {//testing
                    current.next = tempDefinition;
                }//testing
            } 
            else
            {
                // Comparing the word with the nodes values to sort.
                // if inserting word comes first than the current.
                //if (tempDefinition.word.getString().compareTo((current.next).word.getString()) < 0)
                if (tempDefinition.word.getString().compareTo(current.word.getString()) < 0)
                {
//                    tempDefinition.next = current.next;
                      tempDefinition.next = current;
                      back.next = tempDefinition;
//                    current.next = tempDefinition;
                }
                    back = current;
                    
                    current = current.next;
            }
        } while (current.word.getString().charAt(0) == '-' && !endLoop);   
    }

    public String toString()
    {
        String result = "";
        WordMeaningNode current = list;
        int differentWord = 0;

        while (current != null)
        {

            if (current.word.getString().charAt(0) == '-')
            {
                if (differentWord == 1)
                {
                    result += "" + current.word.getString() + "\n";
                    current = current.next;
                    differentWord = differentWord + 1;
                } 
                else
                {

                    result += current.word.getString() + "\n";
                    current = current.next;
                    differentWord = differentWord + 1;
                }
            }
            else
            {
                result += current.word.getString() + " ";
                current = current.next;
                differentWord = 0;
            }

        }
        return result;
    }
    
        public String deleteToString()
    {
        String result = "";
        WordMeaningNode current = deleteList;
        int differentWord = 0;

        while (current != null)
        {

            if (current.word.getString().charAt(0) == '-')
            {
                if (differentWord == 1)
                {
                    result += "" + current.word.getString() + "\n";
                    current = current.next;
                    differentWord = differentWord + 1;
                } 
                else
                {

                    result += current.word.getString() + "\n";
                    current = current.next;
                    differentWord = differentWord + 1;
                }
            }
            else
            {
                result += current.word.getString() + " ";
                current = current.next;
                differentWord = 0;
            }

        }
        return result;
    }
    
    public int askAnother()
    {
        boolean endLoop = false;
        int convertedChoice = 0;
        String menu = "Would you like to insert another defintion for the same word?\n[1] Yes\n[2] No";

        while (!endLoop)
        {
            // Getting the user input as String.
            String tempString = JOptionPane.showInputDialog(menu);

            try
            {

                // Converting the user input from String to int to use it in the switch statement.
                convertedChoice = Integer.parseInt(tempString);

                // MENU.
                switch (convertedChoice)
                {
                    // Add another one.
                    case 1:
                        convertedChoice = 1;
                        endLoop = true;
                        break;

                    // No Add.    
                    case 2:
                        convertedChoice = 2;
                        endLoop = true;
                        break;

                    // Else display message none was selected.    
                    default:
                        JOptionPane.showMessageDialog(null, "This option is not acceptable");
                        break;
                }
            } 
            // Else there was an error about the input.
            catch (NumberFormatException | NullPointerException e)
            {
                JOptionPane.showMessageDialog(null,"Enter a value");
            }
        }
        return convertedChoice;
    }
    
    public void deleteWord(WordMeaning deleteWord)
    {
        // Creating a temporary node 
        WordMeaningNode delete = new WordMeaningNode(deleteWord);
        WordMeaningNode current = wordFounded;
        WordMeaningNode temporary = wordFounded;

        // Boolean to stop while loop.
        boolean endLoop = false;
        
        while ((current.next).word.getString().charAt(0) == '-' && !endLoop)
        {
            
            if((current.next).word.getString().charAt(0) != '-' || current.next == null)
            {
                endLoop = true;
                
                delete.next = wordFounded;
                
                temporary.next = current;               
                
                wordBeforeFounded.next = temporary;
                
                deleteList = delete;               
            }
            else
            {
               temporary = current;
               current = current.next;               
            }            
        }
    }


}

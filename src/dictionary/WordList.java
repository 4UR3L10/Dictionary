package dictionary;

import javax.swing.JOptionPane;

public class WordList
{
//    private WordMeaningNode list, last;
    private WordMeaningNode list;
    private WordMeaningNode wordFounded;

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
//                System.out.println("Next thing is: " + (wordFounded.next).word.getString());
                return true;
            }
            
            current = current.next;
        }
        return false;
    }
    
    // Inserting and sorting by definitions.
    public void InsertOrganizeDefinitions(WordMeaning defintion)
    {
        // Creating a current node that will hold the value from the word founded node. 
        WordMeaningNode current = wordFounded;
        
         // Boolean to stop while loop.
        boolean endLoop = false;
        
        current = current.next;        
        
        while (current.word.getString().charAt(0) == '-' && !endLoop)
        {            
            System.out.println(current.word.getString());           
          
            if(current.next == null)
            {
                endLoop = true;
            }
            else 
            {
                current = current.next;  
            }
           
        }

       

        
        
    }
            
    
    //anotherDefinition(list, new WordMeaningNode(back.word));
    public void anotherDefinition(WordMeaningNode nodeList,WordMeaningNode lastWord)
    {    
        // Temp Value for the method.
        int tempValue = 0;

        // Boolean to stop while loops.
        boolean endLoopOne = false;
        boolean endLoopTwo = false;
        
        // Keep adding definitions until user want it.
        do
        {
            tempValue = askAnother();

            if (tempValue == 1)
            {
                String meaning = JOptionPane.showInputDialog("Enter the Definition:");

                // Creating one temp nodes that hold the other defintion.
                WordMeaningNode tempDefin = new WordMeaningNode(new WordMeaning(meaning));

                // While there is nodes go throught the linkedlist.                          
                while (nodeList != null)//      testing----------------------------------------------------------------
                {
                    System.out.println(nodeList.word.getString());
                    nodeList = nodeList.next;             
                }

            }
        } while (tempValue == 1);
        
        
        
    }
    

    public String toString()
    {
        String result = "";
        WordMeaningNode current = list;

        while (current != null)
        {
            if (current.word.getString().charAt(0) == '-')
            {
                result += current.word.getString() + "\n";
                current = current.next;
            } else
            {
                result += current.word.getString() + " ";
                current = current.next;
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
    
    public void deleteWord(WordMeaning dw)
    {
        
    }
        
//    public String toString()
//    {
//        String result = "";
//        WordMeaningNode current = list;
//
//        while (current != null)
//        {
//            result += current.word.getString() + ",  ";
//            current = current.next;
//        }
//        return result;
//    }

}

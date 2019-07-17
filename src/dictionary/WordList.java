package dictionary;

import javax.swing.JOptionPane;

public class WordList
{
//    private WordMeaningNode list, last;
    private WordMeaningNode list;

    // This constructor creates an empty list.    
    WordList() 
    {
        list = null;
    }

    void insert(WordMeaning w, WordMeaning d) // Insert in proper place 
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
        
        /*Asking to insert another definition.*/
        int tempValue = 0;

        // Boolean to stop while loop.
        boolean endLoop = false;

        // Getting the last word as a node.
        WordMeaningNode lastWord = new WordMeaningNode(back.word);

        // Second back node.
        WordMeaningNode backSecond = null;//       testing----------------------------------------------------------------

        current = lastWord.next;//      testing----------------------------------------------------------------

        // Keep adding definitions until user want it.
        do
        {
            tempValue = askAnother();

            if (tempValue == 1)
            {
                String meaning = JOptionPane.showInputDialog("Enter the Definition:");

                // Creating one temp nodes that hold the word and defintion.
                WordMeaningNode tempDefin = new WordMeaningNode(new WordMeaning(meaning));

                // While there is nodes go throught the linkedlist.
                while (current.word.getString().charAt(0) == '-' && !endLoop)//      testing----------------------------------------------------------------
                {
                    // Comparing the word with the nodes values to sort.
                    if (tempDefin.word.getString().compareTo(current.word.getString()) < 0)//      testing----------------------------------------------------------------
                    {
                        endLoop = true;
                    } else
                    {
                        backSecond = current;//      testing----------------------------------------------------------------
                        current = current.next;//      testing----------------------------------------------------------------
                    }
                }

                // Hold nodes so we don't erase part of the linked list.
                tempDefin.next = current;//      testing----------------------------------------------------------------

                if (backSecond == null)//      testing----------------------------------------------------------------
                {
                    list = tempDefin;//      testing----------------------------------------------------------------
                } else//      testing----------------------------------------------------------------
                {
                    // Finish the joining.//      testing----------------------------------------------------------------
                    backSecond.next = tempDefin;//      testing----------------------------------------------------------------
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
    
    public void insertMultipleDef()
    {
        
        
        
        
    }
    
//    void add(WordMeaning w)// pre-pending
//    {
//        WordMeaningNode temp = new WordMeaningNode(w);
//
//        try
//        {
//            if (list == null)
//            {
//                list = temp;
//                last = temp;
//            } else
//            {
//                last.next = temp;
//                last = temp;
//            }
//        } catch (NullPointerException e)
//        {
//
//        }
//    }
    
//    public String toString()
//    {
//        String result = "";
//        WordMeaningNode current = list;
//
//        while (current != null)
//        {
//            result += current.word.getTitle() + ",  ";
//            current = current.next;
//        }
//        return result;
//    }
    
//    void insert(WordMeaning w) // Insert in proper place -- Sorting
//     {
//        WordMeaningNode temp = new WordMeaningNode(w);
//
//        if (list == null)
//        {
//            list = temp;
//        } 
//        else // It is not the first node
//        {
//            WordMeaningNode current = list,
//                    back = null;
//            boolean found = false;
//
//            while (current != null && !found)
//            {
//                if (temp.word.getString().compareTo(current.word.getString()) < 0)
//                {
//                    found = true;
//                } else
//                {
//                    back = current;
//                    current = current.next;
//                }
//            }
//
//            temp.next = current;
//
//            if (back == null)
//            {
//                list = temp;
//            } else
//            {
//                back.next = temp;
//            }
//        }
//    }  
    
//        void insertMeaning(WordMeaning w, WordMeaning d) // Insert in proper place 
//    {
//        WordMeaningNode temp = new WordMeaningNode(w);
//        WordMeaningNode tempd = new WordMeaningNode(d);
//
////        if (list == null)
////        {
////            list = temp;
////        } 
////        else // It is not the first node
////        {
//            WordMeaningNode current = list,
//                    back = null;
//            boolean found = false;
//
//            while (current != null && !found)
//            {
//                if (temp.word.getString().compareTo(current.word.getString()) < 0)
//                {
//                    found = true;
//                } else
//                {
//                    back = current;
//                    current = current.next;
//                }
//            }
//
//            temp.next = current;
//
//            if (back == null)
//            {
//                list = temp;
//            } else
//            {
//                back.next = temp;  
//               
//            }
//            
////////        TESTING  
//            back = temp;
//            current = back.next;
//            
//            //INSERTING
//            tempd.next = current;
//            back.next = tempd;
//            
//            
//            
//            
////        }
//    }
}

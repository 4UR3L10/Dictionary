package dictionary;

import javax.swing.JOptionPane;

public class WordList
{
    private WordMeaningNode list;
    private WordMeaningNode wordFounded;
    private WordMeaningNode nodeBeforeFounded;
    private WordMeaningNode deleteList;

    // This constructor creates an empty list.    
    WordList() 
    {
        list = null;
        deleteList = null;
    }

    // This methods insert words.
    void insertWord(WordMeaning wm)
    {
        // This is the [Word-Node] that is going to be inserted in the list. 
        WordMeaningNode wordToBeInserted = new WordMeaningNode(wm);

        // Case (1) - Empty List.
        // If the list is empty insert the [Word-Node] directly to the list.
        if (list == null)
        {
            list = wordToBeInserted;
        }
        // If the list is not empty.
        else
        {
            // Create a [Word-Node] that is going to start from the beginning of the list.
            WordMeaningNode currentNode = list;

            // Create a [Word-Node] that is going to start getting the values that current had (The one before).
            WordMeaningNode backNodeOfCurrent = null;

            // A boolean to finish the loop
            boolean endLoop = false;

            // While the current node is not empty keep going through the list.
            // Implicit Case (3) - List no empty but word comes after the last node when current is null but the place for the word has not been found.
            while (currentNode != null && !endLoop)
            {
                // If the word to be inserted comes just before the one that is being reading finish the search. 
                if (wordToBeInserted.word.getString().compareTo(currentNode.word.getString()) < 0)
                {
                    endLoop = true;
                }
                /*
                If the word to be inserted comes after the one that is being reading.
                Each Time.
                Pass the value of the current node to the back node to get the value that comes before the current node.
                Advance to the next node.
                 */
                else
                {
                    // Pass the value of the current node to the back node to get the value that comes before the current node.
                    backNodeOfCurrent = currentNode;

                    // Advance to the next node. (Take the next node value and assign it to the current one)
                    currentNode = currentNode.next;
                }
            }

            // Once the word has found it is proper place on the list.
            // Cut the nodes that come after the current word.
            // And assign it after the insertedWord.
            wordToBeInserted.next = currentNode;

            // Case (2) - List no empty but word comes before the first node.
            // If the node back of the current is null (If the backNode is [Null] before the begining of the list)
            if (backNodeOfCurrent == null)
            {
                list = wordToBeInserted;
            }
            // Case (4) - List no empty but word goes between two nodes.
            // Join the back list with the one we cut. 
            else
            {
                backNodeOfCurrent.next = wordToBeInserted;
            }
        }
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
            nodeBeforeFounded = current;
            current = current.next;
        }
        return false;
    }
    
    // This method inserts definitions.
    void insertDefinition(WordMeaning d)
    {
        // This is the [Definition-Node] that is going to be inserted in the list. 
        WordMeaningNode definitionToBeInserted = new WordMeaningNode(d);

        // Create a [Definition-Node] that is going to start from the beginning of the definitions of the word.
        WordMeaningNode currentNode = wordFounded.next;

        // Create a [Definition-Node] that is going to start getting the values that current had (The one before).
        WordMeaningNode backNodeOfCurrent = wordFounded;

        // A boolean to finish the loop
        boolean endLoop = false;
      
        // While the current node is a definition keep going through the list.
        // Implicit Case (3) - List no empty but definition comes after the last definition node when current is word but the place for the word has not been found.           
        while (currentNode != null && !endLoop)
        {
            // If the definition to be inserted comes just before the one that is being reading finish the search. 
            if (definitionToBeInserted.word.getString().compareTo(currentNode.word.getString()) < 0)
            {
                endLoop = true;
            }
            /*
                If the definition to be inserted comes after the one that is being reading.
                Each Time:
                Pass the value of the current node to the back node to get the value that comes before the current node.
                then Advance to the next node.
             */
            else
            {
                // Pass the value of the current node to the back node to get the value that comes before the current node.
                backNodeOfCurrent = currentNode;

                // Advance to the next node. (Take the next node value and assign it to the current one)
                currentNode = currentNode.next;
            }
        }

        // Once the word has found it is proper place on the list.
        // Cut the nodes that come after the current word.
        // And assign it after the insertedWord.
        definitionToBeInserted.next = currentNode;
        // Case (2) - List no empty but defintion goes between two nodes.
        // Join the back list with the one we cut.
        backNodeOfCurrent.next = definitionToBeInserted;
    }
    
    // Shows the list with words (Actual Dictionary).
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
    
    // Insert the deleted word into the deleted list.
    public void insertDeleteWord(WordMeaning dw)
    {
      // This is the [Word-Node] that is going to be inserted in the list. 
      WordMeaningNode wordToBeInserted = new WordMeaningNode(dw);
      
      // Case (1) - Empty List.
        // If the list is empty insert the [Word-Node] directly to the list.
        if (deleteList == null)
        {
            deleteList = wordToBeInserted;
        }
        // If the list is not empty.
        else
        {
            // Create a [Word-Node] that is going to start from the beginning of the list.
            WordMeaningNode currentNode = deleteList;

            // Create a [Word-Node] that is going to start getting the values that current had (The one before).
            WordMeaningNode backNodeOfCurrent = null;

            // A boolean to finish the loop
            boolean endLoop = false;

            // While the current node is not empty keep going through the list.
            // Implicit Case (3) - List no empty but word comes after the last node when current is null but the place for the word has not been found.
            while (currentNode != null && !endLoop)
            {
                // If the word to be inserted comes just before the one that is being reading finish the search. 
                if (wordToBeInserted.word.getString().compareTo(currentNode.word.getString()) < 0)
                {
                    endLoop = true;
                }
                /*
                If the word to be inserted comes after the one that is being reading.
                Each Time.
                Pass the value of the current node to the back node to get the value that comes before the current node.
                Advance to the next node.
                 */
                else
                {
                    // Pass the value of the current node to the back node to get the value that comes before the current node.
                    backNodeOfCurrent = currentNode;

                    // Advance to the next node. (Take the next node value and assign it to the current one)
                    currentNode = currentNode.next;
                }
            }

            // Once the word has found it is proper place on the list.
            // Cut the nodes that come after the current word.
            // And assign it after the insertedWord.
            wordToBeInserted.next = currentNode;

            // Case (2) - List no empty but word comes before the first node.
            // If the node back of the current is null (If the backNode is [Null] before the begining of the list)
            if (backNodeOfCurrent == null)
            {
                deleteList = wordToBeInserted;
            }
            // Case (4) - List no empty but word goes between two nodes.
            // Join the back list with the one we cut. 
            else
            {
                backNodeOfCurrent.next = wordToBeInserted;
            }
        }
        
    }
    
    // Shows the deleted list.
    public String deleteToString()
    {
        String result = "";
        WordMeaningNode current = deleteList;

        while (current != null)
        {
                result += current.word.getString() + ", ";
                current = current.next;
        }
        return result;
    }    

    public void deleteWord(WordMeaning w)
    {
        // Create a [Current-Node] that is going to start from the beginning of the definitions of the word.
        WordMeaningNode currentNode = wordFounded.next;

        // Create a temporary node to hold the deleted part of the list when par of the is cut.
        WordMeaningNode deleteList = null;

        // A boolean to finish the loop
        boolean endLoop = false;

        // While the current node is a definition keep going through the list.
        while (currentNode != null && !endLoop)
        {
            // If the next node is a word means that it reached the end of the part of the list that is going to be delete it. 
            if (currentNode.word.getString().charAt(0) != '-')
            {
                endLoop = true;                
            }
            else
            {
                // Advance to the next node. (Take the next node value and assign it to the current one)
                currentNode = currentNode.next;
            }
        }
        
        
        // Once we know where the list is going to be cut.
        deleteList = wordFounded;
        nodeBeforeFounded.next = currentNode;
        // Add to the list
        insertDeleteWord(deleteList.word);
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
}

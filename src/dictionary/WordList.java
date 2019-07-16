package dictionary;

public class WordList
{
    private WordMeaningNode list, last;

    WordList() // This constructor creates an empty list.
    {
        list = null;
    }

    void add(WordMeaning w)// pre-pending
    {
        WordMeaningNode temp = new WordMeaningNode(w);

        try
        {
            if (list == null)
            {
                list = temp;
                last = temp;
            } else
            {
                last.next = temp;
                last = temp;
            }
        } catch (NullPointerException e)
        {

        }
    }

    void insert(WordMeaning w) // Insert in proper place -- Sorting
    {
        WordMeaningNode temp = new WordMeaningNode(w);

        if (list == null)
        {
            list = temp;
        } 
        else // It is not the first node
        {
            WordMeaningNode current = list,
                    back = null;
            boolean found = false;

            while (current != null && !found)
            {
                if (temp.word.getTitle().compareTo(current.word.getTitle()) < 0)
                {
                    found = true;
                } else
                {
                    back = current;
                    current = current.next;
                }
            }

            temp.next = current;

            if (back == null)
            {
                list = temp;
            } else
            {
                back.next = temp;
            }
        }
    }   
    
    
    void insertMeaning(WordMeaning w) // Insert in proper place 
    {
        WordMeaningNode temp = new WordMeaningNode(w);

//        IF LIST EMPTY THROW AN ERROR beacuse not defintion witouth a word
        if (list == null)
        {
            list = temp;
        } 
        // It is not the first node
        else 
        {
            // Initialization.
            WordMeaningNode current = list,
                    back = null;
            boolean found = false;
            
            
            
            // While node not null and the word is not found go thro nodes.
            while (current != null && !found)
            {
                // If the temp word is equal to the one found
                if (temp.word.getTitle().equalsIgnoreCase(current.word.getTitle()))
                {
                    found = true;
                } 
                else
                {
//                    THROW AN ERROR IF WORD NOT FOUND DO SOMETHING HEREEEEEEEEEEEEEEEEEEEEEEEEEEEE
                    
                    back = current;
            current = current.next;
                }
            }
            
            
            
            temp.next = current;

            if (back == null)
            {
                list = temp;
            } else
            {
                back.next = temp;
            }
        }
    }

    public String toString()
    {
        String result = "";
        WordMeaningNode current = list;

        while (current != null)
        {
            result += current.word.getTitle() + ",  ";
            current = current.next;
        }
        return result;
    }
}

package dictionary;

public class WordList
{
    private WordMeaningNode list, last;

    WordList() // This constructor creates an empty list.
    {
        list = null;
    }

    void add(WordMeaning b)// pre-pending
    {
        WordMeaningNode temp = new WordMeaningNode(b);

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

    void insert(WordMeaning b) // Insert in proper place -- Sorting
    {
        WordMeaningNode temp = new WordMeaningNode(b);

        if (list == null)
        {
            list = temp;
        } else // It is not the first node
        {
            WordMeaningNode current = list,
                    back = null;
            boolean found = false;

            while (current != null && !found)
            {
                if (temp.book.getTitle().compareTo(current.book.getTitle()) < 0)
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

    public String toString()
    {
        String result = "";
        WordMeaningNode current = list;

        while (current != null)
        {
            result += current.book.getTitle() + ",  ";
            current = current.next;
        }
        return result;
    }
}

package dictionary;

public class MyException extends Exception
{
    String definitionName;

    public MyException(String definitionName)
    {
        this.definitionName = definitionName;
    }

    @Override
    public String toString()
    {
        return "Type a valid definition (starting with a dash [-])\n" + "Example: - a holder\n Invalid name: " + definitionName;
    }
}

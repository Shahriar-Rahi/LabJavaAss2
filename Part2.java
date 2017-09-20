public class Part2
{
    int howMany(String stringa, String stringb)
    {
        int count = 0;
        int index = -1;
        do
        {
            index = stringb.indexOf(stringa, index + stringa.length());
            if(index != -1)
                ++count;
        }while(index != -1);
        return count;
    }
    
    void testHowMany()
    {
        String stringa = "AAA", stringb = "ATAAAA";
        System.out.println(howMany(stringa, stringb));
        
        stringa = "GAA";
        stringb = "ATGAACGAATTGAATC";
        
        System.out.println(howMany(stringa, stringb));
    }
}
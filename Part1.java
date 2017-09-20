public class Part1
{
    int findStopCodon(String DNA, int startIndex, String stopCodon)
    {
        int endIndex = startIndex;
        while(endIndex != -1)
        {
            endIndex = DNA.indexOf(stopCodon, endIndex + 1);
            if(endIndex != -1 && (endIndex - startIndex) % 3 == 0)
                return endIndex;
        }
        return DNA.length();
    }
    
    void testFindStopCodon()
    {
        String DNA = "ATACGATATTATACCCGAGAT";
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));

        DNA = "ATACGATATTATAACCCGAGAT";
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        
        DNA = "ATGACGATATTATACCCGAGAT";
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        
        DNA = "ATGACGATATAATATAACCCGAGAT";
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));

        DNA = "ATGACGATAGTAATATAACCCGAGAT";
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
        
        DNA = "ATGACGATAGTAATAAGTCCCTAGGAGAT";
        System.out.println("DNA: " + DNA);
        System.out.println("Gene: " + findGene(DNA));
    }
    
        String findGene(String DNA)
    {
        int startIndex = DNA.indexOf("ATG");
        if(startIndex == -1)
            return "";
        int index = findStopCodon(DNA, startIndex, "TAA");
        if(index == DNA.length())
        {
            index = findStopCodon(DNA, startIndex, "TAG");
        }
        if(index == DNA.length())
            return "";
        else
            return DNA.substring(startIndex, index + 3);
    }
}
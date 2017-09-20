public class Part3
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
    
    void testFindGene()
    {
        String DNA = "ATAATAAAATAATAAATAAATAGATTAGAATGTAG";
        printAllGenes(DNA);
        DNA = "GATCGATAGACTGATAGGGGATGCAGTATATCCCTGGATACAATAGACGCACAGGTTGGAATCCTAAGTGAAGTCGCGCGTCCGAACCCAGCTCTATTTTAGAGGTCATGGGTTCTGGTGCCCGCGAGCCGCGGAACCGATTAGGGGCATGTACAACAATATTTATTAGTCATCTTTCAGACACAATCTCCCAGCTCACTGGTATATAGTTCCTGCTATAATTAGCCTCCCTCATAAGTTGCACTACTTCAGCGTCCCAAATGCACCCTTACCACGAAGACAGGATTGTCCGATCCCATATTACGACCTTGGCAGGGGGTTCGCAAGTCCCACCCCAAACGATGCTGAAGGCTCAGGTTTCACAGGGACAAAAGCTTTAAACGCGAGTTCCCGCTCATAACCTGGACCGAATGCAGAATCATGCATCGTTCCACTGTGTTCGTGTCATCTAGGACGGGCGCAAAGGATATATAATTCAATTTTGAATACCTTATATTATTGTACACCTACCGGTCACCAGCCAACAATGTGCGGATGGCGTTACAACTTTCTGGGCCTAATCTGACCGTTCTAGATACCGCACTCTGGGCAATACGAGGTAAAGCCAGTCACCCAGTGTCGATCAACACCTAACCTAACGGTAAGAGGCTCACATAATGGCACTGTCGGCGTCCCCAGGGTATTTTACGTTAGCATCAGGTGGACTAACATGAATCTTTACTCCCAAGCGAAAACGGGTGCGTGGACTAGCGAGGAGCAAACGAAAATTCTTGGCCTGCTTGGTGTCTCGTATTCCTCTTAGAGATCGACGAAATGTTTCACGACCAAGGGAAAGGTCGCCCTACAAAATAGATTTGCGTTACTCTCTCCATAAGGAGTCCGGTGTAGCGAAGGATCAAGGCGACCCTAGGTAGCAACCGCCGGCTTCGGCGGTAAGGTATCACTCAAGAAGCAGACACAGTAAGACACGGTCTAGCTGACTGTCTATCGGCTAGGTCAA";
        printAllGenes(DNA);
        
    }
    
    void printAllGenes(String DNA)
    {
        String gene = "";
        int count = 1;
        int startIndex = 0;
        int index = -1;
        do
        {
            startIndex = DNA.indexOf("ATG", index + 1);
            if(startIndex == -1)
                break;
            index = findStopCodon(DNA, startIndex, "TAA");
            if(index == DNA.length())
            {
                index = findStopCodon(DNA, startIndex, "TAG");
            }
            if(index == DNA.length())
                break;
            gene = DNA.substring(startIndex, index + 3);
            System.out.println("Gene" + ": " + gene);
        }while(gene != "");
    }
    
    int countGenes(String DNA)
    {
        int count = 0;
        int startIndex = 0;
        int index = -1;
        do
        {
            startIndex = DNA.indexOf("ATG", index + 1);
            if(startIndex == -1)
                break;
            index = findStopCodon(DNA, startIndex, "TAA");
            if(index == DNA.length())
            {
                index = findStopCodon(DNA, startIndex, "TAG");
            }
            if(index == DNA.length())
                break;
            count++;
        }while(true);
        return count;
    }
    void testCountGenes()
    {
        String DNA = "ATAATAAAATAATAAATAAATAGATTAGAATGTAG";
        System.out.println("Number of genes in DNA sequence \"" + DNA + "\"\nIs: " + countGenes(DNA));
        DNA = "GATCGATAGACTGATAGGGGATGCAGTATATCCCTGGATACAATAGACGCACAGGTTGGAATCCTAAGTGAAGTCGCGCGTCCGAACCCAGCTCTATTTTAGAGGTCATGGGTTCTGGTGCCCGCGAGCCGCGGAACCGATTAGGGGCATGTACAACAATATTTATTAGTCATCTTTCAGACACAATCTCCCAGCTCACTGGTATATAGTTCCTGCTATAATTAGCCTCCCTCATAAGTTGCACTACTTCAGCGTCCCAAATGCACCCTTACCACGAAGACAGGATTGTCCGATCCCATATTACGACCTTGGCAGGGGGTTCGCAAGTCCCACCCCAAACGATGCTGAAGGCTCAGGTTTCACAGGGACAAAAGCTTTAAACGCGAGTTCCCGCTCATAACCTGGACCGAATGCAGAATCATGCATCGTTCCACTGTGTTCGTGTCATCTAGGACGGGCGCAAAGGATATATAATTCAATTTTGAATACCTTATATTATTGTACACCTACCGGTCACCAGCCAACAATGTGCGGATGGCGTTACAACTTTCTGGGCCTAATCTGACCGTTCTAGATACCGCACTCTGGGCAATACGAGGTAAAGCCAGTCACCCAGTGTCGATCAACACCTAACCTAACGGTAAGAGGCTCACATAATGGCACTGTCGGCGTCCCCAGGGTATTTTACGTTAGCATCAGGTGGACTAACATGAATCTTTACTCCCAAGCGAAAACGGGTGCGTGGACTAGCGAGGAGCAAACGAAAATTCTTGGCCTGCTTGGTGTCTCGTATTCCTCTTAGAGATCGACGAAATGTTTCACGACCAAGGGAAAGGTCGCCCTACAAAATAGATTTGCGTTACTCTCTCCATAAGGAGTCCGGTGTAGCGAAGGATCAAGGCGACCCTAGGTAGCAACCGCCGGCTTCGGCGGTAAGGTATCACTCAAGAAGCAGACACAGTAAGACACGGTCTAGCTGACTGTCTATCGGCTAGGTCAA";
        System.out.println("Number of genes in DNA sequence \"" + DNA + "\"\nIs: " + countGenes(DNA));
        DNA = "";
        System.out.println("Number of genes in DNA sequence \"" + DNA + "\"\nIs: " + countGenes(DNA));
        DNA = "ATAATATA";
        System.out.println("Number of genes in DNA sequence \"" + DNA + "\"\nIs: " + countGenes(DNA));
    }
}
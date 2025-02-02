import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TermFrequency frequency = new TermFrequency();

        List<String> doc1 = Arrays.asList("the","sky","is","blue");
        List<String> doc2 = Arrays.asList("the","sun","is","bright");
        List<String> doc3 = Arrays.asList("the","sun","in","the","sky","is","bright");

        List<List<String>> corpus = Arrays.asList(doc1,doc2,doc3);

        frequency.printList(doc1);
        frequency.printList(doc2);
        frequency.printList(doc3);

        System.out.println("\nDocument collection:");

        frequency.printListOfList(corpus);

        System.out.println("\nidf score of each term");

        TermFrequency.idfScoreOfEachTerm(corpus);

        System.out.println("\n tf- idf score of each term");
        TermFrequency.tfTimeIdf(corpus);


    }
}
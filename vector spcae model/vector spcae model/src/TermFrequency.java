import java.util.HashMap;
import java.util.List;

public class TermFrequency {
    public  void printList(List<String> doc){
        for(String word : doc){
            System.out.print(word+" ");
        }
        System.out.println();
    }

    public void printListOfList(List<List<String>> docs){
        for (List<String> doc : docs){
            printList(doc);
        }
    }

    public static int  termFrequency(List<String> doc , String term){
        HashMap <String,Integer> wordMap = new HashMap<String, Integer>();
        int frequencyOfTerm;
        for(String word : doc){
            if(wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word)+1);
            }else{
                wordMap.put(word,1);
            }
        }

        frequencyOfTerm = wordMap.getOrDefault(term, 0);

        return frequencyOfTerm;
    }

    public static double inverseDocumentFrequency (List<List<String>> docs , String term){
        int totalFrequencyTerm =0;

        for(List<String> doc : docs){
            totalFrequencyTerm = totalFrequencyTerm + (doc.contains(term)? 1:0);
        }
        return Math.log((double) docs.size()/totalFrequencyTerm );

    }

    public static void idfScoreOfEachTerm(List<List<String>> docs){
        double idfScore;
        for (List<String> doc : docs){
            for(String term : doc){
                idfScore = inverseDocumentFrequency(docs,term);
                System.out.println(term +" \t=\t"+ idfScore);

            }
        }
    }

    public static void tfTimeIdf(List<List<String>> docs){
        double idfScore;
        int termFreqn;
        double tf_idf ;
        for (List<String> doc : docs) {


            for (String term : doc) {
                termFreqn = termFrequency(doc,term);
                idfScore = inverseDocumentFrequency(docs,term);
                tf_idf = termFreqn * idfScore;

                System.out.println("tf-ifd of " +term + " is " +tf_idf );
            }
        }
    }

}

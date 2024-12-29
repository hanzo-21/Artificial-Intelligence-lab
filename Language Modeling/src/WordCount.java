import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCount {
     HashMap <String,Integer> wordMap = new HashMap<String, Integer>();
    writeFiles console = new writeFiles();

     WordCount(){
         console.clearConsole();
     }

     public void readFile(String file){
         String word = "";
         String cleanWord="";
         Scanner sc ;
         String sub ;
         String alphabets = "qwertyuiopasdfghjklzxcvbnm";

         try{
             sc = new Scanner(new File(file));
             sc.useDelimiter(" ");

             while (sc.hasNext()){
                 word = sc.next();
                 word = word.toLowerCase();
                 cleanWord="";


                 for(int i =0 ; i< word.length();i++){
                     sub = word.substring(i,i+1);
                     if(alphabets.contains(sub)){
                         cleanWord = cleanWord.concat(sub);
                     }
                 }

                 word = cleanWord;

                 word = word.replaceAll("[],./'?!@#$%^&*();:<>?{}|]=-+\"","");
                 if(!word.isEmpty()){
                     if(wordMap.containsKey(word)){
                         wordMap.put(word, wordMap.get(word)+1);
                     }else{
                         wordMap.put(word,1);
                     }
                 }
             }
             sc.close();

         }catch (FileNotFoundException e){
             System.out.println("file not found\n"+e);
         }

     }

     void printWordFrequency(){
         for(String word : wordMap.keySet()){
             int count = wordMap.get(word);

             console.writeConsole("|"+word+"\t\t|"+count);

             //System.out.println("|"+word+"\t|"+count);
         }
     }
}

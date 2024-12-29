public class Main {
    public static void main(String[] args) {
        WordCount unigram = new WordCount();

        unigram.readFile("An algorithm for suffix stripping .txt");
        unigram.printWordFrequency();


    }
}
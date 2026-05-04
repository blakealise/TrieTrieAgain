import java.util.HashMap;

public class TrieNodeHash {
    private boolean isWord;
    private String symbol;
    public static TrieNodeHash root = new TrieNodeHash();
    HashMap<String , TrieNodeHash> myMap = new HashMap<>();

    public TrieNodeHash(boolean isWord, String symbol){
        this.isWord = isWord;
        this.symbol = symbol;
    }

    public TrieNodeHash() {
        this.isWord = isWord;
        this.symbol = symbol;
        myMap = new HashMap<>();
    }

    public void insert(String symbol){
        TrieNodeHash curr = root;

        for(int i = 0; i<symbol.length() ; i++ ){
            System.out.println();
            String letter = symbol.substring(i,i+1);
//            System.out.println("I'm currently at: " + letter);

            //does root contain node with i
            // System.out.println("index of node in array is: " + idx);
            if (myMap.get(letter) == null) { //
                // System.out.println("the index: " + idx + " is null in the array");
                if(i == symbol.length()){
//                    System.out.println("word is true");
                    curr.isWord = true;
                }
                else {
                    TrieNodeHash newNode = new TrieNodeHash(false, letter);
//                    System.out.println("Added the letter " + letter + " to the hashmap");
//                    System.out.println("curr is: " + curr);
                    curr.myMap.put(letter,newNode);
                    curr = curr.myMap.get(letter);
//                    System.out.println("moving on");
//                    System.out.println("curr is: " + curr);
                }
            }
            else {
                curr = myMap.get(letter);
            }
        }
        //the for loop is done right above us
        curr.isWord = true;
    }

    public boolean search(String word){
        TrieNodeHash curr = root;
        return searchHelper(word, curr);
    }
    public boolean searchHelper(String word, TrieNodeHash curr){
        String letter = word.substring(0,1);
       // System.out.println("I'm at: " + curr.symbol);
        int idx = letter.charAt(0) - 'a';
        if(curr.myMap.get(letter) == null) { //does current contain the letter
           // System.out.println("current index is null");
            //now what do i do (question mark)
            if(word.length() == 1 && curr.isWord) {
          //      System.out.println("yay");
                return true;
            }
            return false;
        }
        else if(word.length() == 1 && curr.isWord) {
        //    System.out.println("yay");
            return true;
        }
        else{
            System.out.println(word.length());
            System.out.println(curr.isWord);
         //   System.out.println("Gotta scooch down");
            System.out.println();
            if(word.length() == 1) {
                return searchHelper(word.substring(0), curr.myMap.get(letter));
            }
            else {
                return searchHelper(word.substring(1), curr.myMap.get(letter));
            } //you aren't actually getting to the last index
        }
    }

    public boolean startsWith(String prefix){
        //Goal: return true if at least one inserted word begins with this prefix —
        // the prefix does not need to be a complete word itself.
        //
        //Returns false if any character in the path is missing.
        //Returns true as long as every character in the prefix was found — regardless of the endpoint flag.
        TrieNodeHash curr = root;
        return startHelper(prefix, curr);
    }
    public boolean startHelper(String prefix, TrieNodeHash current) {
        String letter = prefix.substring(0, 1);
        int idx = letter.charAt(0) - 'a';
//        System.out.println("prefix empty: " + prefix.isEmpty());
//        System.out.println(prefix);
//        System.out.println("test");
//        System.out.println("prefix is: " + prefix);
//        System.out.println("letter is: " + letter);

        if (prefix.isEmpty()) {
            System.out.println("we have no more words to search");
            return true;
        } else if (current.myMap.get(letter) == null) {
            //does current contain the letter
          //  System.out.println("No way to go");
            //now what do i do (question mark)
            return false;
            //animal -> animal
        } else if (prefix.length() == 1) {
         //   System.out.println("Done");
         //   System.out.println("I'm at the letter: " + letter);
            return true;
        } else {
            return startHelper(prefix.substring(1), current.myMap.get(letter));
        }
    }

}

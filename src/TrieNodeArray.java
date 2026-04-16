public class TrieNodeArray {
    private TrieNodeArray[] children;
    private boolean isWord;
    private String temp;
    private static TrieNodeArray root = new TrieNodeArray();

    public TrieNodeArray(boolean isWord, String symbol){
        this.isWord = isWord;
        this.temp = symbol;
        children = new TrieNodeArray[26];
    }

    public TrieNodeArray(){
        children = new TrieNodeArray[26];
    }

    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public boolean isWord() {
        return isWord;
    }
    public void setWord(boolean word) {
        isWord = word;
    }
    public TrieNodeArray[] getChildren() {
        return children;
    }
    public void setChildren(TrieNodeArray[] children) {
        this.children = children;
    }

    public void insert(String word){
        TrieNodeArray curr = root;

        for(int i = 0; i<word.length() ; i++ ){
            String letter = word.substring(i,i+1);
            System.out.println("letter is: " + letter);
            if(!letter.equals(letter.toLowerCase())){
                throw new IllegalArgumentException("must be lowercase! you typed: " +
                        letter + " at index " + i + ". 🤦🏻‍♀️");
            }
            int idx = letter.charAt(0) - 'a'; //We just need to convert String to char
            //does root contain node with i
            System.out.println("index of node in array is: " + idx);

            if (curr.children[idx] == null) {
                System.out.println("the index: " + idx + " is null in the array");
                if(i == word.length()-1){
                    System.out.println("word is true");
                    curr.isWord = true;
                 }
                else {
                    TrieNodeArray newNode = new TrieNodeArray(isWord, letter);
                    curr.children[idx] = newNode;
                    curr = curr.children[idx];
                    System.out.println("moving on");
                }
            }
        }
    }
    public boolean search(String word){
        TrieNodeArray curr = root;
        return searchHelper(word, curr);
    }
    public boolean searchHelper(String word, TrieNodeArray current){
        String letter = word.substring(0,1);
        int idx = letter.charAt(0) - 'a';
        if(current.children[idx] == null) { //does current contain the letter
            //now what do i do (question mark)
            return false;
        }
        else if(word.isEmpty() && isWord ) {
            return true;
        }
        else{
            return searchHelper(word.substring(1), current);
        }
    }

    public boolean startsWith(String prefix){
        //Goal: return true if at least one inserted word begins with this prefix —
        // the prefix does not need to be a complete word itself.
        //
        //Returns false if any character in the path is missing.
        //Returns true as long as every character in the prefix was found — regardless of the endpoint flag.
        TrieNodeArray curr = root;
        return startHelper(prefix, curr);
    }
    public boolean startHelper(String prefix, TrieNodeArray current){
        String letter = prefix.substring(0,1);
        int idx = letter.charAt(0) - 'a';
        if(current.children[idx] == null) { //does current contain the letter
            //now what do i do (question mark)
            return false;
        }
        else if(prefix.isEmpty()) {
            return true;
        }
        else{
            return searchHelper(prefix.substring(1), current);
        }
    }
}

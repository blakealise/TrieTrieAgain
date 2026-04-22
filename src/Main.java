public class Main {
    public static void main(String[] args) {
        TrieNodeArray ta = new TrieNodeArray();
        ta.insert2("animal");
        System.out.println(TrieNodeArray.root);
        System.out.println(ta.search("animal"));
        System.out.println(TrieNodeArray.root);
    }
}

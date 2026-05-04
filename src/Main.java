import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrieNodeArray ta = new TrieNodeArray();
        TrieNodeHash tH = new TrieNodeHash();
        for (String w : new String[]{"app", "apple", "application", "bat", "batman", "cat"})
            ta.insert2(w);
        for (String w : new String[]{"Apple", "apple", "App", "Batman99", "CAT", "cat", "R2D2"})
            tH.insert(w);
        //System.out.println(tH.startsWith("anim"));
        System.out.println();


        boolean keepGoing = true;
        while(keepGoing){
            System.out.println("running console");
            Scanner scan1 = new Scanner(System.in);
            System.out.println("Which trie? (A = lowercase only, B = alphanumeric, 0 = exit)");
            String ans1 = scan1.next();

            if (ans1.equals("0")){
                System.out.println("ok baii");
                keepGoing = false;
                return;
            }



            if(ans1.equals("A")){
                Scanner scan2 = new Scanner(System.in);
                System.out.println("1. Search exact word\n" +
                        "2. Search prefix\n" +
                        "0. Back");
                String ans2 = scan2.next();

                if(ans2.equals("1")){
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("what's the word?");
                    String ans3 = scan1.next();
                    System.out.println(ta.search(ans3));
                }
                else if (ans2.equals("2")){
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("what's the prefix?");
                    String ans3 = scan1.next();
                    System.out.println(ta.startsWith(ans3));
                }
                else if (ans2.equals("0")) {
                    System.out.println("going back now");
                }
                else{
                    System.out.println("wrong answer 😑\n" +"im dissapointed. were starting over");
                }
            }
            else if (ans1.equals("B")){

                Scanner scan2 = new Scanner(System.in);
                System.out.println("1. Search exact word\n" +
                        "2. Search prefix\n" +
                        "0. Back");
                String ans2 = scan2.next();

                if(ans2.equals("1")){
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("what's the word?");
                    String ans3 = scan1.next();
                    System.out.println(tH.search(ans3));
                }
                else if (ans2.equals("2")){
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("what's the prefix?");
                    String ans3 = scan1.next();
                    System.out.println(tH.startsWith(ans3));
                }
                else if (ans2.equals("0")) {
                    System.out.println("going back now");
                }
                else{
                    System.out.println("wrong answer 😑\n im dissapointed. were starting over");
                }
            }
            else{
                System.out.println("bro wrong character. type A,B, or 0");
            }
        }
    }
}

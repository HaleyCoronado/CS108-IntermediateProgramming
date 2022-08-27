/**
 * Read name and dictionary file
 * and display all anagrams in name.
 * Build a phrase from the available anagrams.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnagramPhrase {
    static ArrayList<String> dict, anagrams, phrase;
    static TreeMap<Character, Integer> nameLetterMap;
    static String inputName, remaining;

    /**
     * @param args 0 the dictionary words in a text file
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // Load a dictionary file
        if (args.length != 1) {
            System.out.println("Usage: java AnagramPhrase dictionaryFileName");
            System.exit(1);
        }
        dict = buildDictionary(args[0]);

        // Accept a name from user
        System.out.print("Enter a phrase: ");
        Scanner scan = new Scanner(System.in);
        setPhrase(scan.nextLine());

        //TreeMap<Character, Integer> map = makeMap(inputName);

        //TreeMap<Character, Integer> map2 = makeMap("fox");
        //containsWord(map2, map);

        //trimPhrase("See the fox run");

        // Set limit = length of name
        int limit = getPhraseLen(inputName);

        // Start empty list to hold anagram phrase
        phrase = new ArrayList<>();

        int i = 0;
        //String[] nextWords = new String[]{"tuts", "reef", "ox", "h", "n"};

        while (phraseLength() < limit) {

            // Generate list of dictionary words that fit in name
            anagrams = findAnagrams(remaining);

            // Present words to user
            //System.out.println("ANAGRAMS:");
            displayWords(anagrams);

            // Present current phrase to user
            System.out.println("Current phrase: " + getCurrentPhrase());

            // Present remaining letters to user
            System.out.println("Remaining letters: " + getRemainingLetters(remaining));
            System.out.println("Number of remaining letters: " + remaining.length());

            // Ask user to input word or start over
            String nextWord = getUserInput(scan);
            if (nextWord.equalsIgnoreCase("S")) {
                reset();
                continue;
            }

            // If user input can be made from remaining letters
            if (hasMoreAnagrams(nextWord)) {


                phrase.add(nextWord);

                // Remove letters in choice from letters in name
                remaining = removeWord(nextWord);
                getRemainingLetters(remaining);



                // Return choice and remaining letters in name
            } else {
                if (lastWord(nextWord) && isAnagram(nextWord)) {
                    phrase.add(nextWord);
                    remaining = removeWord(nextWord);
                } else {
                    // If choice is not a valid selection:
                    // Ask user for new choice or let user start over
                    String response = getUserInput(scan, true);
                    if (response.equalsIgnoreCase("q"))
                        break;
                    else
                        reset();
                }
            }
        }
        // When phrase length equals limit value:
        // Display final phrase
        System.out.print("Final phrase: " + getCurrentPhrase());
    }

    /**
     * If this word is an anagram contained within the remaining
     * letters of the original phrase and if, when the letters of
     * this word are removed from it, there will still be anagrams
     * left to form more words in the new phrase, then return true.
     *
     * @param word - the candidate word to add to the phrase
     * @return
     */
    public static boolean hasMoreAnagrams(String word) {
        if (!isAnagram(word))
            return false;
        String tmp = removeWord(word);
        return (findAnagrams(tmp).size() > 0);
    }

    /**
     * Verify that this word is contained in the list of anagrams
     * contained in the remaining original phrase
     *
     * @param word
     * @return
     */
    public static boolean isAnagram(String word) {
        return findAnagrams(remaining).contains(word);
    }

    /**
     * @param word
     * @return true if this is the final word that can be made
     * from the remaining letters in the original phrase
     */
    public static boolean lastWord(String word) {
        return remaining.length() - word.length() == 0;
    }

    /**
     * Remove the characters contained in the string parameter from the currently
     * remaining in the original phrase/string
     *
     * @param word
     * @return the string remaining from the original phrase
     */
    public static String removeWord(String word) {


        String tmpRemaining = new String(remaining);

        // TODO: Complete this method
        if(word != null){
            for(int i = 0; i < word.length(); i++){
                String tmp = word.substring(i, i+1);
                remaining = remaining.replaceFirst(tmp, "");
            }
        }

        return remaining;
    }

    /**
     * @param input Scanner object
     * @return user choice
     */
    public static String getUserInput(Scanner input) {
        System.out.print("\tEnter 'S' to start over or a word from the list: ");
        return input.next();
    }

    /**
     * @param input Scanner object
     * @param newWord
     * @return user choice
     */
    public static String getUserInput(Scanner input, String newWord) {
        System.out.print("\tEnter 'S' to start over or Enter to accept: " + newWord);
        return input.next();
    }

    /**
     * @param input Scanner object
     * @param hasQuitOption
     * @return user choice
     */
    public static String getUserInput(Scanner input, boolean hasQuitOption) {
        System.out.print("\tEnter 'Q' to quit else start over: ");
        return input.next();
    }

    /**
     * @return String of words in ArrayList phrase separated by a space
     */
    public static String getCurrentPhrase() {
        if(phrase == null){
            return "";
        }

        //TODO: is there a better way?
        // this is a better way
        String currPhrase = String.join(" ", phrase);

        // original code
        //String currPhrase = "";
        //for (String s : phrase)
        //    currPhrase += s + " ";
        return currPhrase;
    }


    /**
     * Sort the letters remaining in the original phrase
     * @param name
     * @return sorted string of characters
     */
    public static String getRemainingLetters(String name) {
        //TODO: Is there a better way to do this?
        // this is the better way
        char[] tmp = name.toCharArray();
        Arrays.sort(tmp);
        return String.valueOf(tmp);

        // original code
        //char[] tmp = name.toCharArray();
        //Arrays.sort(tmp);
        //StringBuilder str = new StringBuilder();
        //for (char ch : tmp)
        //    str.append(ch);
        //return str.toString();
    }
    /**
     * Display four columns of strings in list
     * @param list
     */
    public static void displayWords(ArrayList<String> list) {
        int count = 1;
        for (String word : list) {
            System.out.printf("%15s", word);
            if (count++ % 4 == 0)
                System.out.println();
        }
        System.out.println();
    }


    /**
     * Set phrase variable from line removing spaces and upperCase
     * @param line
     */
    public static void setPhrase(String line) {
        // TODO: rename this to what it really does - DONE
        // renaming this method causes it to fail ZyBooks test
        // I would rename it to "setInputName"
        if(line != null){
            inputName = line.replace(" ", "").toLowerCase();

            reset();
        }
    }

    /**
     * Reinitialize variable remaining with original input phrase
     * (with spaces and upperCase removed).
     */
    public static void reset() {
        remaining = new String(inputName);
        try{
            phrase.clear();
        } catch (NullPointerException e) {

        }
    }

    /**
     * @param word
     * @return the length of the string (not including spaces)
     */
    public static int getPhraseLen(String word) {
        //TODO:  Simplify this method - DONE
        return word.replaceAll(" ", "").length(); //simplified version

        // original code
        //int length = word.length();
        //for (int i = 0; i < word.length(); ++i) {
        //    if (Character.isWhitespace(word.charAt(i))) {
        //        length--;
        //    }
        //}
        //return length;
    }

    /**
     * Construct a list of words from filename.  Use BufferedReader and readLine().
     * Close the BufferedReader object when done.
     *
     * @param filename of a file that has one word per line
     * @return ArrayList<String> the list
     * @throws IOException
     */
    public static ArrayList<String> buildDictionary(String filename) throws IOException {
        // TODO: Complete this method - DONE
        dict = new ArrayList<String>();  // What is a more efficient constructor?

        BufferedReader reader;

        reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            //System.out.println(line);
            if(line != null && line.length() > 0)
                dict.add(line);

            // read next line
            line = reader.readLine();
        }
        reader.close();


        return dict;
    }

    /**
     * Make a TreeMap<Character,Integer> from the testWord.
     * Initialize a new list for anagrams.
     * for each word in the dictionary list of words (dict),
     *    make a map
     *    if the test word map is contained in the dict word
     *       add the testWord to the anagram list
     * @param testWord
     * @return list of anagrams
     */
    public static ArrayList<String> findAnagrams(String testWord) {
        anagrams = new ArrayList<String>();

        //TODO: Complete this method - DONE
        for(String s : dict){
            boolean valid = true; //this variable becomes unnecessary

            TreeMap<Character, Integer> dictMap = makeMap(s);
            TreeMap<Character, Integer> wordMap = makeMap(testWord);
            if(containsWord(dictMap, wordMap)){
                // its an anagram
                anagrams.add(s);
            }


            ///if(valid){
            // anagrams.add(s);
            //}
        }
        return anagrams;
    }


    /**
     * for each Character in letterMap2.keySet()
     *   if the char is in letterMap1 (dictWordMap) and occurs no more frequently than
     *   it occurs in letterMap2 (userWordMap), then it could be part of the anagram
     * @param letterMap1
     * @param letterMap2
     * @return true is letterMap1 is contained in letterMap2
     */
    public static boolean containsWord(TreeMap<Character, Integer> letterMap1,
                                       TreeMap<Character, Integer> letterMap2) {
        //TODO:  Complete this method
        boolean valid = true;
        for(char c : letterMap1.keySet()){
            if(!letterMap2.keySet().contains(c) || letterMap2.get(c) < letterMap1.get(c)){
                valid = false;
                break;
            }
        }
        return valid;
    }


    /**
     * Example: Given "sweettimes" the map is: ['e':3,'i':1,'m':1,'s':2,'t':2,'w':1]
     * @param word
     * @return a sorted key,value pair map for word
     */
    public static TreeMap<Character, Integer> makeMap(String word) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        //TODO: Make char[] from word (first remove spaces and uppercase)
        char[] tmp = word.toCharArray();

        //for ( //TODO: foreach char in the map) {
        //        map.merge(letter, 1, (curr, inc) -> curr + inc);

        for(char letter : tmp){
            map.merge(letter, 1, (curr, inc) -> curr + inc);
        }
        return map;
    }


    /**
     * @return number of characters in the internal phrase the user is constructing
     */
    public static int phraseLength() {
        int len = 0;
        for (String word : phrase)
            len += word.length();
        return len;
    }
}
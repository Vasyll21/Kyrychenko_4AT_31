package task_2;

public class StringProc {

    public static void main(String[] args) {
        //Task 2. Given a string, find the number of words in it.
        String s = "Hi there, the way you access the Games Workshop and Forge World webstores has been improved.";
        String[] words = s.split("[, ?.@]+");

        System.out.println(words.length);

        //Task 3. Given a string, show number of chars in each word
        for(String word:words){
            System.out.println(word + ":\t" + word.length());
        }

        //Task 4. Create function which takes 2 parameters:
        //1st(String) – text;
        //2nd (int) - index of word.
        //Function should return number of chars in word by its index in text

        int index = 5;

        System.out.println("length of " + (index + 1)  + " word: " + stringCharCount(s, index));
    }

    private static int stringCharCount(String s, int i) {
        String[] wordsArray = s.split("[, ?.@]+");
        if(wordsArray.length >= i){
            return wordsArray[i].length();
        }else {
            throw new RuntimeException("Index must be from " + 0 + " to " + wordsArray.length);
        }

    }
}

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("movies.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Movie list was not found!");
        }
        int movieNumbers = 0;
        ArrayList<String> movies = new ArrayList<>();

        while (scanner.hasNextLine()){
            String movie = scanner.nextLine();
           movieNumbers ++;
            movies.add(movie);
        }
        int randomNo = (int) (Math.random() * movieNumbers);
        String randomMovieName = movies.get(randomNo);
        String coveredMovie = coverMovieName(randomMovieName);


        System.out.println("Guess the movie: " + coveredMovie);
        System.out.println("Take a guess! Type a letter: ");

        //Retrieve the user typed letter
        Scanner inputScanner =  new Scanner(System.in);
        //Array list that will track the letters input by the user
        ArrayList<String> lettersList = new ArrayList<>();
        int i =0 ;
        String uncoverLettersMovieName = coveredMovie;
       while (i < (randomMovieName.trim().length()+3)) {
           i++;
           String inputLetter = inputScanner.nextLine().toLowerCase();
           if (randomMovieName.contains(inputLetter)) {
              uncoverLettersMovieName = changeGuessedLetter(randomMovieName, coveredMovie, inputLetter);
               System.out.println("Your progress: " + uncoverLettersMovieName);
               coveredMovie = uncoverLettersMovieName;
               System.out.println(randomMovieName);
               System.out.println("Take a guess! Type a letter: ");
           } else {
               System.out.println("Try again!");
               System.out.println("Your progress: " + uncoverLettersMovieName);
               System.out.println("Choose another letter!");
               inputLetter = inputScanner.nextLine().toLowerCase();
               if (lettersList.contains(inputLetter)) {
                   System.out.println("Your progress: " + uncoverLettersMovieName);
                   System.out.println(lettersList + "Choose another letter!");
                   lettersList.add(inputLetter);
               } else {
                   lettersList.add(inputLetter);
                   System.out.println(lettersList + "Choose another letter!");
               }
           }
       }
       if(coveredMovie.equals(randomMovieName)){
           System.out.println("You won!");
       } else {
           System.out.println("You loose!");
       }
    }


    private static String changeGuessedLetter(String movieName,String coveredName, String letter){
        // Checking if the letter entered from the user is one of the letters from the movie name

        for (int i = 0; i < movieName.length(); i++){
            if(letter.equals(movieName.substring(i,i+1).toLowerCase())){

                coveredName = coveredName.substring(0,i) + letter + coveredName.substring(i+1, movieName.length());
            }

        }
        return coveredName;

    }

    public static String coverMovieName(String movieName){
        String emptyMovie = "";
        // Returning the movie name that should be guessed
        for (int i = 0; i < movieName.length(); i++){
            if((" ").equals(movieName.substring(i,i+1))) {
                emptyMovie = emptyMovie + " ";

            } else {
                emptyMovie = emptyMovie + "_";
            }
        }
        return emptyMovie;
    }
}

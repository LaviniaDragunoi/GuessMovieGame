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
        String emptyMovie = "";
        for (int i = 0; i < randomMovieName.length(); i++){
             if((" ").equals(randomMovieName.substring(i,i+1))) {
                emptyMovie = emptyMovie + "  ";
            } else {
                emptyMovie = emptyMovie + "_ ";
            }
        }

        System.out.println("Random no is: " + randomNo);
        System.out.println("Movie name is: " + randomMovieName);
        System.out.println("Empty movie name is: " + emptyMovie);

    }


}

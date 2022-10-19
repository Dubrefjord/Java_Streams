//import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//import java.util.Map;
//import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Scanner;

public class TestStream{
    public static void main(String args[]){
        List<Word> words = getWords();
        List<Word> prioWords = words.stream()
            .filter(wrd -> wrd.getSuccessfulAttempts() < 20)
            .sorted(Comparator.comparing(Word::getPrio).reversed())
            //.map(s -> s.getEnglish())  // can be used if we want to get a list of strings instead!
            .collect(Collectors.toList());
            
        prioWords.forEach(s -> {
            Scanner input = new Scanner(System.in);
            System.out.println("Give the german translation of the following word please: "+s.getEnglish());
            String germanWord = input.nextLine();
            if(s.checkTranslation(germanWord))
                System.out.println("Well done!");
            else 
                System.out.println("Sorry, that's wrong.");
        });
        
        words.stream()
            .forEach(s -> System.out.println(s.getEnglish()+"  "+s.getPrio()));
    }
    public static List<Word> getWords(){
        return List.of(
            new Word("Boy","Der Junge",30,50,40),
            new Word("Girl","Das Mädchen",30 ,30 ,29 ),
            new Word("Mobile phone","Das Handy",80,20,7),
            new Word("Book","Das Buch",60 ,40 ,13 ),
            new Word("School","Die Schule",95 ,5 ,1 ),
            new Word("Mouse","Die Maus",50 ,20 ,10 ),
            new Word("Chancellor","Der Kanzler",70 ,10 ,3 ),
            new Word("Hospital","Das Krankenhaus",70 ,10 ,4 ),
            new Word("Car","Das Auto",10 ,10 ,10 ),
            new Word("Girlfriend","Die Freundin",70 ,30 ,10 ),
            new Word("Husband","Der Mann",50 ,80 ,55 )
        );
    }
}

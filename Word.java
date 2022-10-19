public class Word{
    private String english;
    private String german;
    private int priority;
    private int attempts;
    private int successful_attempts;
    // TODO: german innehåller endast ord. Der/die/das i egen variabel Bra för att öva. 

    public Word(String english, String german){
        this.english = english;
        this.german = german;
        this.priority = 50;
        this.attempts = 0;
        this.successful_attempts = 0;
    }

    public Word(String english, String german, int priority, int attempts, int successful_attempts){
        this.english = english;
        this.german = german;
        this.priority = priority;
        this.attempts = attempts;
        this.successful_attempts = successful_attempts;
    }

    public int getPrio(){
        return this.priority;
    }
    public int getAttempts(){
        return this.attempts;
    }
    public int getSuccessfulAttempts(){
        return this.successful_attempts;
    }
    public String getEnglish(){
        return this.english;
    }
    public String getGerman(){
        return this.german;
    }

    public boolean checkTranslation(String german){
        attempts++;
        if(this.german.equals(german)){
            successful_attempts++;
            priority-=10;
            return true;
        }
        priority+=10;
        return false;
    }
}
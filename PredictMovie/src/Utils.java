import java.util.Random;

public class Utils {
    public int getRandomNumberGenerator (){
        Random random = new Random();
        int randomNumber = random.nextInt(250) + 1;
        return randomNumber;
    }
}

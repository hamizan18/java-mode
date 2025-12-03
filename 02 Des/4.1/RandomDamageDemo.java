import java.util.Random;

public class RandomDamageDemo {
    Random random = new Random();
    int a = 0;
    public int RandomDamage(int min, int max) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            return randomNumber;
    }
}
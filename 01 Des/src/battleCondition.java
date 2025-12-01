public class battleCondition {

    void checkHp(int hp) {
        if (hp <= 0) {
            System.out.println("Game over");
        } else if (hp < 30) {
            System.out.println("You're dying");
        } else {
            System.out.println("You still strong!");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CharacterStats player1 = new CharacterStats();
        CharacterStats player2 = new CharacterStats();
        CharacterStats player3 = new CharacterStats();

        player1.setName("Jamal");
        player1.setHp(250);

        player2.setName("Udin");
        player2.setHp(450);

        player3.setName("Ace");
        player3.setHp(10000);

        System.out.println("Player 1: " + player1.getName() + "\t | Player HP: " + player1.getHp());
        System.out.println("Player 2: " + player2.getName() + "\t | Player HP: " + player2.getHp());
        System.out.println("Player 3: " + player3.getName() + "\t | Player HP: " + player3.getHp());

    }
}
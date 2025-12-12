public class BattleMain {
    public static void main(String[] args) {

        Character player = new Player("Mijaenn", 100, 20);
        Character enemy = new Enemy("Demon", 1000, 3);
        Window display = new Window(player, enemy);
    }
}
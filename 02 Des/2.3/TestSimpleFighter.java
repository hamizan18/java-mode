public class TestSimpleFighter {
    public static void main(String[] args) {

    SimpleFighter hero = new SimpleFighter("Alice", 100, 30);
    SimpleFighter monster = new SimpleFighter("Goblin", 270, 10);

        while (monster.hp > 0 && hero.hp > 0) {
            hero.hit(monster);
            monster.hit(hero);
        }
    }
}
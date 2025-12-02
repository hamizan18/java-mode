public class TestSimpleFighter {
    public static void main(String[] args) {

    SimpleFighter hero = new SimpleFighter();
    SimpleFighter monster = new SimpleFighter();

    hero.name = "Alice";
    hero.hp = 100;
    hero.attack = 30;
    monster.name = "Goblin";
    monster.hp = 500;

        while (monster.hp > 0) {
            hero.hit(monster);
        }
    }
}
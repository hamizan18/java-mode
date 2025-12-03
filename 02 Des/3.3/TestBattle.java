public class TestBattle {
    public static void main(String[] args) {
        AbstractFighter Hero = new PlayerFighter("Anos", 100, 25);
        EnemyFighter Enemy = new EnemyFighter("Slime", 120, 3);

        System.out.println("--- Battle Start! ---");
        System.out.println("=====================");
        System.out.println("Hero \t: " + Hero.name + "  | HP: " + Hero.hp);
        System.out.println("Enemy\t: " + Enemy.name + " | HP: " + Enemy.hp + "\n");

        while(Hero.hp > 0 && Enemy.hp > 0) {
            Hero.attack(Enemy);
            if (Hero.hp <= 0 || Enemy.hp <= 0) {
                break;
            }
            Enemy.attack(Hero);
        }
    }
}
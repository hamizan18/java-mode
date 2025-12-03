public class Main {
    public static void main(String[] args) {
        TheFighter hero = new TheFighter("Dante", 100, 5, 15);
        TheFighter enemy = new TheFighter("Demon", 1000, 10, 25);

        System.out.println("--- Battle Start! ---");
        System.out.println("=====================");
        System.out.println("Hero \t: " + hero.name + " | HP: " + hero.hp);
        System.out.println("Enemy\t: " + enemy.name + " | HP: " + enemy.hp + "\n");

        int i = 0;
        while (i < 5){
            if (enemy.hp < 0 || hero.hp < 0) {
                break;
            }
            hero.hit(enemy);
            enemy.hit(hero);
            i++;
        }
    }
}
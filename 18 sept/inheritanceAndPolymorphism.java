class Character {
    String name;
    int hp;
    int power;

    void attack(Character target) {
        System.out.println(name + " menyerang!");
    }
    void showStatus() {
        if (hp < 0) hp = 0;
        if (hp > 0) 
            System.out.println("[" + name + "] \nHP: " + hp + "\t| Damage: " + power);
        else
            System.out.println("[" + name + "] Die. ");
    }
}

class Hero extends Character {
    // Constructor
    Hero(String name, int hp, int atkPower) {
        this.name = name;
        this.hp = hp;
        this.power = atkPower;
        }
    @Override
    void attack(Character target) {
        System.out.println("[" + power + "damage] " + name + " menggunakan pedang ke arah " + target.name);
        target.hp -= power;
    }
}

class Enemy extends Character {
    // Constructor
    Enemy(String name, int hp, int atkPower) {
        this.name = name;
        this.hp = hp;
        this.power = atkPower;
    }
    @Override
    void attack(Character target) {
        if (hp > 0){
            System.out.println("[" + power + "damage] " + name + " menggigit!");
            target.hp -= power;
        } else {
            System.out.println("...");
        }
    }
}

class Boss extends Enemy {
    Boss(String name, int hp, int atkPower) {
        super(name, hp, atkPower);
    }
    @Override
    void attack(Character target) {
        if (hp > 0){
        System.out.println("[" + power + "damage] " + name + " menghantam lantai!\n");
        target.hp -= power;
        } else {
            System.out.println("...\n");
        }
    }
}

public class inheritanceAndPolymorphism {

    public static int randomDamage(int min, int max) {
        return (int)(Math.random()* (max - min + 1)) + min;
    }
        static void delay() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {


        int enemyDamage = randomDamage(10, 20);
        int heroDamage = randomDamage(30, 45);
        int bossDamage = randomDamage(18, 30);

        // Inisialisasi Object
        Hero hero1 = new Hero("Mingjaan", 150, heroDamage);
        Enemy enemy1 = new Enemy("Demon", 80, enemyDamage);
        Boss boss = new Boss("Lord", 200, bossDamage);

        // Print Status
        hero1.showStatus();
        boss.showStatus();
        enemy1.showStatus();

        while(hero1.hp > 0 && (enemy1.hp > 0 || boss.hp > 0)){

            System.out.print("\n");

            // Print attack
            hero1.attack(enemy1);
            delay();
            hero1.attack(boss);
            delay();
            enemy1.attack(hero1);
            delay();
            boss.attack(hero1);
            delay();

            // Print Status
            hero1.showStatus();
            delay();
            enemy1.showStatus();
            delay();
            boss.showStatus();
            delay();
        }
        if (hero1.hp == 0){
            System.out.println("\n" + hero1.name + " Kalah.");
        } else
            System.out.println("\n" + enemy1.name + " & " + boss.name + " Kalah.");
    }
}
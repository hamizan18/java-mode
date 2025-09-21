class Character {
    String name;
    int hp;
    int power;

    void attack(Character target) {
        System.out.println(name + " menyerang!");
    }
    void showStatus() {
        System.out.println("[" + name + "] \t\tHP: " + hp + " | Damage: " + power);
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
        System.out.println(name + " menggunakan pedang! \t[" + power + "damage]");
        enemy1.hp -= power;
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
        System.out.println(name + " menggigit! \t\t[" + power + "damage]");
    }
}

class Boss extends Enemy {
    Boss(String name, int hp, int atkPower) {
        super(name, hp, atkPower);
    }
    @Override
    void attack(Character target) {
        System.out.println("Boss menghantam lantai! \t\t[" + power + "damage]");
    }
    int bossHit(Character target) {
        hero1.hp -= bossDamage;
        return hero1.hp;
    }
}

public class inheritanceAndPolymorphism {

    public static int randomDamage(int min, int max) {
        return (int)(Math.random()* (max - min + 1)) + min;
    }

    public static void main(String[] args) {

        int enemyDamage = randomDamage(10, 20);
        int heroDamage = randomDamage(15, 25);
        int bossDamage = randomDamage(18, 20);

        // Inisialisasi Object
        Hero hero1 = new Hero("Mingjaan", 100, heroDamage);
        Enemy enemy1 = new Enemy("Demon", 80, enemyDamage);
        Boss boss = new Boss("Lord", 250, bossDamage);

        // Print Status
        hero1.showStatus();
        enemy1.showStatus();
        boss.showStatus();

        System.out.print("\n");

        // Print attack
        hero1.attack(hero1);
        enemy1.attack(enemy1);
    }
}
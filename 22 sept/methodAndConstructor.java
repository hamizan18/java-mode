class Character {
    String name;
    int hp;
    int power;

    void showStatus() {
        System.out.println("[" + name + "]\nHP: " + hp);
    }
}

class Hero extends Character {
    // Constructor
    Hero(String name, int hp, int atkPower) {
        this.name = name;
        this.hp = hp;
        this.power = atkPower;
    }

    void attack() {
        System.out.println("[" + power + "] " + name + " melakukan serangan biasa!");
    }
    void attack(String skill) {
        System.out.println("[" + power + "] " + name + " menggunakan skill " + skill);
    }
    void attack(String skill, int damage) {
        System.out.println("[" + damage + "] " + name + "menggunakan skill ultimate " + skill);
    }
}

class Enemy extends Character {
    Enemy(String name, int hp, int atkPower) {
        this.name = name;
        this.hp = hp;
        this.power = atkPower;
    }
    
}
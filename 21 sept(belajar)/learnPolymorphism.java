class Character {
    String name;
    int hp;
    int atkPower;

    void attack(Character target) {
        System.out.println(name + " menyerang [" + atkPower + "damage deals]");
    }
    void showStatus() {
        if (hp < 0) hp = 0;
        System.out.println(name + " HP: " + hp);
        if(hp == 0) System.out.println(name + " mati..");
    }
}

class Archer extends Character {
    Archer(String name, int hp, int atkPower) {
        this.name = name;
        this.hp = hp;
        this.atkPower = atkPower;
    }
    @Override
    void attack(Character target) {
        System.out.println(name + " menembakkan panah ke " + target.name + "[" + atkPower + "damage deals]");
        target.hp -= atkPower;
    }
    void tripleShot(Character target) {
        int tripleAmmo = atkPower * 3;
        System.out.println(name + " menembakkan 3x peluru dalam waktu bersamaan ke arah " + target.name + " [" + tripleAmmo + "damage deals]");
        target.hp -= tripleAmmo;
    }
}

class Goblin extends Character {
    Goblin(String name, int hp, int atkPower) {
        this.name = name;
        this.hp = hp;
        this.atkPower = atkPower;
    }
}

public class learnPolymorphism {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer", 100, 40);
        Goblin goblin = new Goblin("Goblin", 150, 5);

        goblin.showStatus();
        archer.showStatus();
        archer.attack(goblin);
        goblin.showStatus();
        archer.tripleShot(goblin);
        goblin.showStatus();

    }
}
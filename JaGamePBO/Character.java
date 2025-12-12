abstract public class Character {
    private String name;
    private int hp;
    private int damage;

    public Character(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    abstract public void shoot();

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }
}

class Enemy extends Character {
    public Enemy(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    public void shoot() {
        // System.out.println(getName() + " DORR ENEMY \t| Deals " + getDamage());
    }
}

class Player extends Character {
    public Player(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    public void shoot() {
        // System.out.println(getName() + " DORR ALLIES \t| Deals " + getDamage());
    }
}
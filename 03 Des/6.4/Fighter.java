public abstract class Fighter {
    private String name;
    private int maxHp;
    private int hp;
    private int attack;
    private int healAmount;

    public Fighter(String name, int maxHp, int attack, int healAmount) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.healAmount = healAmount;
    }

    public void basicAttack(Fighter target) {
        int damage = attack;
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void heal() {
        hp += healAmount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealAmount() {
        return healAmount;
    }
}

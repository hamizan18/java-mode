public class AbstractFighter {
    protected String name;
    protected int hp;
    protected int attack;

    public int damage(int damage) {
        return damage;
    }

    public void attack(AbstractFighter target) {
        int damage = damage(this.attack);
        target.hp -= damage;
        if (target.hp < 0) {
            target.hp = 0;
        }
        System.out.println(target.name + " attacked by " + this.name + " | deals damage " + damage + ".");
        System.out.println(this.name + " HP left: " + target.hp);
    }
    
}
class PlayerFighter extends AbstractFighter {
    public PlayerFighter(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = damage(attack);
    }
}
class EnemyFighter extends AbstractFighter {
    public EnemyFighter(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = damage(attack);
    }
}
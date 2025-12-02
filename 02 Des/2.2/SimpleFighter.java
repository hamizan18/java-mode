public class SimpleFighter {
    public String name;
    public int hp;
    public int attack;

    void hit(SimpleFighter target) {
        target.hp -= this.attack;
        if (target.hp < 0) {
            target.hp = 0;
        }
        System.out.println(target.name + " attacked by " + this.name + " for " + this.attack + " damage.");
        System.out.println(target.name + " has " + target.hp + " HP left.");
    }

}
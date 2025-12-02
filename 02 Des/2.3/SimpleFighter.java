public class SimpleFighter {
    String name;
    int hp;
    int attack;

    public SimpleFighter(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    void hit(SimpleFighter target) {
        target.hp -= this.attack;
        if (target.hp < 0) {
            target.hp = 0;
        }
        System.out.println(target.name + " attacked by " + this.name + " for " + this.attack + " damage.");
        System.out.println(target.name + " has " + target.hp + " HP left.");
    }

}
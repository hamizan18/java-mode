public class TheFighter {
    RandomDamageDemo rdd = new RandomDamageDemo();
    String name;
    int hp;
    int damageMin;
    int damageMax;

    public TheFighter(String name, int hp, int damageMin, int damageMax) {
        this.name = name;
        this.hp = hp;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }
    public void hit(TheFighter target) {
        int theDamage = rdd.RandomDamage(damageMin, damageMax);

        target.hp -= theDamage;
        if (target.hp < 0) target.hp = 0;
        
        System.out.println(this.name + " attacks " + target.name + " | Dealing " + theDamage + " damage.");
        System.out.println(target.name + " has " + target.hp + " HP remaining.");
    }
}
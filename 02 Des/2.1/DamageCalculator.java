public class DamageCalculator {
    static int calcDamage(int attack, int defense) {
        int damage = attack - defense;
        if (damage < 0) {
            damage = 0;
        }
        System.out.println("Damage dealt: " + damage);
    }
}
import java.util.Random;

public class BattleEngine {
    private Player player;
    private Enemy enemy;
    private Random random;
    private boolean playerTurn;

    public BattleEngine(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.random = new Random();
        this.playerTurn = true; // awalnya giliran player
    }

    public String playerAttack() {
        if (!playerTurn) {
            return "Sekarang giliran musuh.";
        }

        int damage = randomDamage(player.getAttack());
        enemy.takeDamage(damage);

        String text = player.getName() + " menyerang " + enemy.getName() +
                " dan memberi " + damage + " damage!";
        playerTurn = false;
        return text;
    }

    public String playerHeal() {
        if (!playerTurn) {
            return "Sekarang giliran musuh.";
        }

        if (player.getHealAmount() <= 0) {
            return player.getName() + " tidak bisa heal!";
        }

        player.heal();
        String text = player.getName() + " menyembuhkan diri.";
        playerTurn = false;
        return text;
    }

    public String enemyTurn() {
        if (playerTurn) {
            return "";
        }

        if (enemy.isDead()) {
            return "";
        }

        int damage = randomDamage(enemy.getAttack());
        player.takeDamage(damage);

        String text = enemy.getName() + " menyerang " + player.getName() +
                " dan memberi " + damage + " damage!";
        playerTurn = true;
        return text;
    }

    private int randomDamage(int baseAttack) {
        int min = (int) (baseAttack * 0.8);
        int max = (int) (baseAttack * 1.2);
        if (min < 1) {
            min = 1;
        }
        return random.nextInt(max - min + 1) + min;
    }

    public boolean isPlayerDead() { // Player Kalah Enemy Menang
        return player.isDead();
    }

    public boolean isEnemyDead() { // Player Menang Enemy Kalah
        return enemy.isDead();
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}

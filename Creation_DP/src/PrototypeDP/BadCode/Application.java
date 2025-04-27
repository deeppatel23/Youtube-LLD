package PrototypeDP.BadCode;

public class Application {
    public static void main(String[] args) {
        // Manual copy everytime
        Enemy boss = new Enemy("Boss", 500, 10);
        Enemy bossCopy = new Enemy(boss.type, boss.health, boss.speed);
        Enemy bossCopy2 = new Enemy(boss.type, boss.health, boss.speed);
    }
}

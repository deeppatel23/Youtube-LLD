package PrototypeDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        Enemy boss = new Enemy("Boss", 500, 10);

        Enemy bossClone1 = boss.clone();
        Enemy bossClone2 = boss.clone();

        System.out.println(bossClone1 == bossClone2 ? "Both clones are same" : "Both clones are different");
    }
}

package PrototypeDP.BadCode;

public class Enemy {
    String type;
    int health;
    int speed;

    Enemy(String type, int health, int speed) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        System.out.println("Created enemy of type " + type + " with health " + health + " and speed " + speed);
    }
}


package app;

public class Entity {
    private int health;
    boolean Shield = false;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void Attack() {
        if(this.Shield == false) {
            int damage = (int) (Math.random() * (40 - 10 + 1)) + 10;
            this.health = health - damage;
        } else if (this.Shield == true) {
            System.out.println("Урон не прошёл. Был задействован щит.");
            this.Shield = false;
        }
    }

    public void useShield(){
        this.Shield = true;
    }

    public void Heal() {
        this.health = this.health + 20;
        System.out.println("К здоровью было добавлено +20 единиц. Теперь: " + this.getHealth());
    }

    public static void botLogic(Entity bot, Entity player) {
        int botState = (int)(Math.random() * (2 - 1 + 1)) + 1;

        if(bot.health >= 30) {
            player.Attack();
            System.out.println("Противник атакует. Ваше здоровье: " + player.getHealth());
        } else {
            if(botState == 1) {
                bot.Heal();
            } else {
                bot.useShield();
                System.out.println("Противник поднял щит.");
            }
        }
        if(player.getHealth() <= 0) {
            Main.Status = "Loose";
            System.out.println("Вы проиграли!");
        }
    }
}

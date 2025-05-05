package app;

import java.util.Scanner;

public class Main {
    public static String Status = "";
    public static void main(String[] args) {
        System.out.println("MiniRPG by Alast0r V1!!!");


        Entity player = new Entity();
        Entity bot = new Entity();
        Scanner scn = new Scanner(System.in);

        player.setHealth(100);
        bot.setHealth(100);

        while(Status.isEmpty()) {
            System.out.print("Действие за вами! Ваше здоровье: " + player.getHealth() + ". Вы можете сделать \"Attack\", \"Heal\", \"Shield\": ");

            String doit = scn.nextLine();
            if(doit.equals("Attack")) {
                bot.Attack();
                System.out.println("Здоровье противника: " + bot.getHealth());
                if(bot.getHealth() <= 0) {
                    Status = "Win";
                    System.out.println("Вы победили!");
                }
            } else if(doit.equals("Shield")) {
                player.useShield();
            } else if(doit.equals("Heal")) {
                player.Heal();
            }

            System.out.println("Ход противника: ");
            Entity.botLogic(bot, player);
        }
    }
}
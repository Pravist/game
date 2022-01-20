package com.game.util;

import com.game.entity.Player;

public class CalcExp {
    public static void calcExp(Player player) {
        player.setLevel((int) ((Math.sqrt(2500 + 200 * player.getExperience()) - 50) / 100));
        player.setUntilNextLevel(50 * (player.getLevel() + 1) * (player.getLevel() + 2) - player.getExperience());

    }
}

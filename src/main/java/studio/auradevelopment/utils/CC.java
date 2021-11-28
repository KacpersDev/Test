package studio.auradevelopment.utils;

import org.bukkit.ChatColor;

public class CC {

    public static String toColorUtil(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}

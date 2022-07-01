package cn.mcciv.cdk;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public final class CDK extends JavaPlugin {
    public File file = new File(getDataFolder(), "Export.yml");
    public File used = new File(getDataFolder(), "Log.yml");
    public static YamlConfiguration filec,uselog;
    @Override
    public void onEnable() {
        ins = this;
        saveDefaultConfig();
        if (!file.exists()){
            try {
                Boolean resp = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!used.exists()){
            try {
                Boolean usedNewFile = used.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        filec = YamlConfiguration.loadConfiguration(file);
        uselog = YamlConfiguration.loadConfiguration(used);
        Objects.requireNonNull(Bukkit.getPluginCommand("cdk")).setExecutor(new command());
        int pluginId = 14378; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        this.getLogger().info("§4[CDK] §a插件已开启");
        this.getLogger().info("§4[CDK] §a来自于 §2文明游戏");
        this.getLogger().info("§4[CDK] §a作者 §3Yao§7Si§6Qian");
        this.getLogger().info(" \n" +
                "§c███╗   ███╗  ██████╗  ██████╗ ██╗ ██╗   ██╗\n" +
                "§6████╗ ████║ ██╔════╝ ██╔════╝ ██║ ██║   ██║\n" +
                "§e██╔████╔██║ ██║      ██║      ██║ ██║   ██║\n" +
                "§a██║╚██╔╝██║ ██║      ██║      ██║ ╚██╗ ██╔╝\n" +
                "§9██║ ╚═╝ ██║ ╚██████╗ ╚██████╗ ██║  ╚████╔╝ \n" +
                "§5╚═╝     ╚═╝  ╚═════╝  ╚═════╝ ╚═╝   ╚═══╝  ");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("§4[CDK] §a插件已关闭");
    }
    private static CDK ins;
    public static CDK getIns(){
        return ins;
    }
}

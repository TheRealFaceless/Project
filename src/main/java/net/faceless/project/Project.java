package net.faceless.project;

import net.faceless.project.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Project extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {

    }
}

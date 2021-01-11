package de.blockworlds.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import de.blockworlds.listener.ChatListener;
import de.blockworlds.listener.WorldChangeListener;

public class BlockWorlds extends JavaPlugin {
	
	File file = new File("plugins//BlockWorlds//worlds.yml");
	YamlConfiguration worlds = YamlConfiguration.loadConfiguration(file);
	
	public void onEnable() {
		if(!file.exists()) {
			List<String> list = worlds.getStringList("BlockedWorlds");
			list.add("world_nether");
			list.add("world_the_end");
			worlds.set("BlockedWorlds",list);
			try { worlds.save(file); } catch (IOException exception) {}
			
			Bukkit.getPluginManager().registerEvents(new WorldChangeListener(), this);
			Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("========== BlockWorlds ==========");
			System.out.println(" ");
			System.out.println("Author: GibMirRechte");
			System.out.println("Version: " + Bukkit.getPluginManager().getPlugin("BlockWorlds").getDescription().getVersion());
			System.out.println("Discord: yhBX6KT");
			System.out.println(" ");
			System.out.println("========== BlockWorlds ==========");
		}
	}
}

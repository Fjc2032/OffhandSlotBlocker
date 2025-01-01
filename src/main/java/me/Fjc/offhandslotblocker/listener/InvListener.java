package me.fjc.offhandslotblocker.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;


public class InvListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack target = event.getCursor();
        InventoryType type = event.getInventory().getType();

        if (target != null && target.getType() == Material.PIG_SPAWN_EGG && event.getWhoClicked().equals(player) && type == InventoryType.CRAFTING) {
            if (event.getSlot() == 40) {
                event.setCancelled(true);
                player.sendMessage("You are not allowed to put this into your offhand.");
            }
        }
        if (target != null && target.getType() == Material.PIG_SPAWN_EGG && event.getWhoClicked().equals(player) && type == InventoryType.PLAYER) {
            if (event.getSlot() == 40) {
                event.setCancelled(true);
                player.sendMessage("You are not allowed to put this into your offhand.");
            }
        }
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onSwap(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getOffHandItem();

        if (item.getType() == Material.PIG_SPAWN_EGG && item != null) {
            event.setCancelled(true);
            player.sendMessage("Good try! You cannot put this item here.");
        }
    }
}
    /*
    @EventHandler(priority = EventPriority.HIGH)
    public void onSpawn(CreatureSpawnEvent event, InventoryInteractEvent interactEvent) {
        //Declares bukkitEntity
        Entity bukkitEntity = event.getEntity();

        //Checks if the mob is a MythicMob
        boolean isMythicMob = MythicBukkit.inst().getMobManager().isMythicMob(bukkitEntity);
        if(isMythicMob) {

            //Checks if the mob in question was spawned by MythicMobs
            if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.EGG) && event.getEntityType().equals(EntityType.PIG)) {
                event.setCancelled(true);

                //Send a warning message to the player (this might not work since getEntityType() will never equal PLAYER)
                if (event.getEntityType().equals(EntityType.PLAYER)) {
                    Player player = Bukkit.getPlayerExact(Bukkit.getName());
                    assert player != null;
                    player.sendMessage("Don't spawn this with your offhand!");
                }
            }

        }
    }
    */





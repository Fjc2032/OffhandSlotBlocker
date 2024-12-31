package me.fjc.offhandslotblocker;

import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;


public class InvListener extends OffhandSlotBlocker implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClickCraftInv(InventoryClickEvent event) {
        if (!event.getInventory().getType().equals(InventoryType.CRAFTING) && event.getRawSlot() == 45) {
            return;
        } else {
            Player player = (Player) event.getWhoClicked();
            ItemStack target = event.getCurrentItem();

            //Checks if the current item is a pig spawn egg and if the target is a player
            if (target != null && target.getType() == (Material.PIG_SPAWN_EGG) && event.getWhoClicked().equals(player)) {
                event.setCancelled(true);
                player.sendMessage("Don't put this into your offhand!");
            }


        }

    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClickPlayerInv(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack target = event.getCurrentItem();

        if (target != null && target.getType() == (Material.PIG_SPAWN_EGG) && event.getWhoClicked().equals(player)) {
            if (event.getSlot() == 40) {
                event.setCancelled(true);
                player.sendMessage("Don't put this into your offhand!");
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



}

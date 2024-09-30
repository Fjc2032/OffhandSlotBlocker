package me.Fjc.PigOffhandBlocker;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.Fjc.PIgOffhandBlocker.PigOffhandBlocker


public class InvListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        //This should set a check for items entering offhand
        if (event.getSlot() == event.getView().getBottomInventory().getSize()) {
            ItemStack item = event.getCurrentItem();


            //Now these lines should run checks for specific pig spawn egg
            if (item != null && item.getType() == Material.PIG_SPAWN_EGG) {
                event.setCancelled(true); //This should just cancel the event
            }
        }
    }
}

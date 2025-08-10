package projectbackroom.jonathanx.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.UseAction;
import net.minecraft.world.World;

public class ContaminatedBottleWaterItem extends Item {

    public ContaminatedBottleWaterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.equipStack(EquipmentSlot.MAINHAND,new ItemStack(Items.GLASS_BOTTLE));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,200,1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300,1));
        return super.finishUsing(stack, world, user);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}

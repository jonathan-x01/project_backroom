package projectbackroom.jonathanx.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import projectbackroom.jonathanx.util.DebugLogger;

@Mixin(BucketItem.class)
public class DebugBucketItemMixin {
    @Shadow @Final private Fluid fluid;

    @Inject(method = "<init>(Lnet/minecraft/fluid/Fluid;Lnet/minecraft/item/Item$Settings;)V", at = @At("TAIL"))
    private void onConstructor(Fluid fluid, Item.Settings settings, CallbackInfo ci){
        DebugLogger.debug(fluid);
    }

    @Inject(method = "use", at = @At("HEAD"))
    private void onUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult> cir){
        DebugLogger.debug(this.fluid.toString());
    }
}
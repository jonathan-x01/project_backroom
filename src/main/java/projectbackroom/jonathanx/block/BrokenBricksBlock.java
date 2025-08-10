package projectbackroom.jonathanx.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BrokenBricksBlock extends Block {
    public static final int VARIETY_MIN = 1;
    public static final int VARIETY_MAX = 4;
    public static final IntProperty VARIETY = IntProperty.of("variety",VARIETY_MIN,VARIETY_MAX);
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public BrokenBricksBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VARIETY).add(FACING);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        int randomVariety = new Random().nextInt((VARIETY_MAX - VARIETY_MIN) + 1) + VARIETY_MIN;
        return this.getDefaultState().with(VARIETY,randomVariety).with(FACING,ctx.getHorizontalPlayerFacing());
    }
}

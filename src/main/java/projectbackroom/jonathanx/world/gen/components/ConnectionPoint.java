package projectbackroom.jonathanx.world.gen.components;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class ConnectionPoint {
    public BlockPos position;
    public Direction direction;  // The facing direction where another component can connect
    public ConnectionPoint(BlockPos pos, Direction dir) {
        this.position = pos;
        this.direction = dir;
    }
}

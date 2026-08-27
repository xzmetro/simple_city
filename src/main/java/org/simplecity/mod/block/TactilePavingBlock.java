package org.simplecity.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TactilePavingBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final VoxelShape SHAPE_X = Shapes.or(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(2, 1, 1, 3, 2, 15),
            Block.box(4, 1, 1, 5, 2, 15),
            Block.box(6, 1, 1, 7, 2, 15),
            Block.box(9, 1, 1, 10, 2, 15),
            Block.box(11, 1, 1, 12, 2, 15),
            Block.box(13, 1, 1, 14, 2, 15)
    );
    private static final VoxelShape SHAPE_Z = Shapes.or(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(1, 1, 2, 15, 2, 3),
            Block.box(1, 1, 4, 15, 2, 5),
            Block.box(1, 1, 6, 15, 2, 7),
            Block.box(1, 1, 9, 15, 2, 10),
            Block.box(1, 1, 11, 15, 2, 12),
            Block.box(1, 1, 13, 15, 2, 14)
    );

    public TactilePavingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return switch (facing) {
            case NORTH, SOUTH -> SHAPE_X;
            case EAST, WEST -> SHAPE_Z;
            default -> Block.box(0, 0, 0, 0, 0, 0);
        };
    }
}
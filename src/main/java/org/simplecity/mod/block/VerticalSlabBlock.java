package org.simplecity.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class VerticalSlabBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty DOUBLE = BooleanProperty.create("double");

    private static final VoxelShape NORTH_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);
    private static final VoxelShape EAST_SHAPE = Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape WEST_SHAPE = Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);
    private static final VoxelShape FULL_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

    public VerticalSlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(DOUBLE, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, DOUBLE);
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(DOUBLE)) {
            return FULL_SHAPE;
        }
        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> Block.box(0, 0, 0, 0, 0, 0);
        };
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.getShape(state, level, pos, context);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState currentState = context.getLevel().getBlockState(pos);
        Direction clickedSide = context.getClickedFace();
        Direction newFacing = context.getHorizontalDirection().getOpposite();

        if (currentState.getBlock() == this && !currentState.getValue(DOUBLE)) {
            Direction existingFacing = currentState.getValue(FACING);
            if (clickedSide == existingFacing) {
                return currentState.setValue(DOUBLE, true);
            }
        }

        return this.defaultBlockState().setValue(FACING, newFacing).setValue(DOUBLE, false);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        // 双板不可替换
        if (state.getValue(DOUBLE)) {
            return false;
        }

        // 如果手持的是竖半砖
        if (context.getItemInHand().getItem() == this.asItem()) {
            Direction existingFacing = state.getValue(FACING);
            Direction clickedSide = context.getClickedFace();
            // 只有点击的面是朝向的方向才允许替换（即可以合并）
            if (clickedSide == existingFacing) {
                return true;
            }
        }

        return super.canBeReplaced(state, context);
    }
}
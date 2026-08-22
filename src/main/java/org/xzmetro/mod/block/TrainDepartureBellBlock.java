package org.xzmetro.mod.block;

import org.xzmetro.mod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class TrainDepartureBellBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    private static final VoxelShape SHAPE_NORTH = Block.box(3.0, 0.0, 9.0, 13.0, 16.0, 16.0);
    private static final VoxelShape SHAPE_SOUTH = Block.box(3.0, 0.0, 0.0, 13.0, 16.0, 7.0);
    private static final VoxelShape SHAPE_WEST = Block.box(9.0, 0.0, 3.0, 16.0, 16.0, 13.0);
    private static final VoxelShape SHAPE_EAST = Block.box(0.0, 0.0, 3.0, 7.0, 16.0, 13.0);

    public TrainDepartureBellBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED);
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
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> Block.box(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        };
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && !state.getValue(POWERED)) {
            level.playSound(null, pos, ModSounds.TRAIN_DEPARTURE_BELL_SOUND, net.minecraft.sounds.SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlock(pos, state.setValue(POWERED, true), 3);
            level.scheduleTick(pos, this, 160);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if (!level.isClientSide) {
            boolean hasSignal = level.hasNeighborSignal(pos);
            boolean isPowered = state.getValue(POWERED);
            if (hasSignal && !isPowered) {
                level.playSound(null, pos, ModSounds.TRAIN_DEPARTURE_BELL_SOUND, net.minecraft.sounds.SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlock(pos, state.setValue(POWERED, true), 3);
                level.scheduleTick(pos, this, 20);
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, state.setValue(POWERED, false), 3);
    }
}
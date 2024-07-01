package com.awsdkl.periodictableofelements.block.blocks;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.block.entities.Copper_cable_Entity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.listener.GameEventListener;
import org.jetbrains.annotations.Nullable;

public class Copper_cable extends BlockWithEntity
{
    //状态
    public static final BooleanProperty
            TOP = BooleanProperty.of("top"),
            BOTTOM = BooleanProperty.of("bottom"),
            NORTH = BooleanProperty.of("north"),
            SOUTH = BooleanProperty.of("south"),
            WEST = BooleanProperty.of("west"),
            EAST = BooleanProperty.of("east");

    public Copper_cable(Settings settings)
    {
        super(settings);
        //初始化状态
        setDefaultState(getDefaultState()
                .with(TOP, false)
                .with(BOTTOM, false)
                .with(NORTH, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(EAST, false)
        );
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return checkType(type, PeriodicTableOfElements.COPPER_CABLE_ENTITY, Copper_cable_Entity::tick);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getGameEventListener(ServerWorld world, T blockEntity)
    {
        return super.getGameEventListener(world, blockEntity);
    }

    /**
     * 注册方块状态
     */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(TOP);
        builder.add(BOTTOM);
        builder.add(NORTH);
        builder.add(SOUTH);
        builder.add(WEST);
        builder.add(EAST);
    }

    private static final VoxelShape SHAPE_MID = Block.createCuboidShape(6.0,6.0,6.0,10.0,10.0,10.0);
    private static final VoxelShape SHAPE_TOP = Block.createCuboidShape(6.0,10.0,6.0,10.0,16.0,10.0);
    private static final VoxelShape SHAPE_BOTTOM = Block.createCuboidShape(6.0,0.0,6.0,10.0,6.0,10.0);
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(6.0,6.0,0.0,10.0,10.0,6.0);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(6.0,6.0,10.0,10.0,10.0,16.0);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(0.0,6.0,6.0,6.0,10.0,10.0);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(10.0,6.0,6.0,16.0,10.0,10.0);

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return SHAPE_MID;
    }
    /**
     * 方块的描边模型。<br/>
     */
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        VoxelShape shape_re = SHAPE_MID;
        if(state.get(TOP)) shape_re = VoxelShapes.union(shape_re,SHAPE_TOP);
        if(state.get(BOTTOM)) shape_re = VoxelShapes.union(shape_re,SHAPE_BOTTOM);
        if(state.get(NORTH)) shape_re = VoxelShapes.union(shape_re,SHAPE_NORTH);
        if(state.get(SOUTH)) shape_re = VoxelShapes.union(shape_re,SHAPE_SOUTH);
        if(state.get(WEST)) shape_re = VoxelShapes.union(shape_re,SHAPE_WEST);
        if(state.get(EAST)) shape_re = VoxelShapes.union(shape_re,SHAPE_EAST);
        return shape_re;
    }
}

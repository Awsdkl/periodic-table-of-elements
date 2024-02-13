package com.awsdkl.periodictableofelements.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Stripped_rubber_wood extends Block
{
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
    public Stripped_rubber_wood(Settings settings)
    {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(AXIS, Direction.Axis.X));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack)
    {

    }

    //类似与注册
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(AXIS);
    }
}

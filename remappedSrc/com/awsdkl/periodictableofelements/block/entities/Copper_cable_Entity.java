package com.awsdkl.periodictableofelements.block.entities;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Copper_cable_Entity extends BlockEntity
{
    private int U = 0,I = 0,T = 0;

    public Copper_cable_Entity(BlockPos pos, BlockState state)
    {
        super(PeriodicTableOfElements.COPPER_CABLE_ENTITY, pos, state);
    }

    /**
     * 实体tick
     * @param world World
     * @param pos BlockPos
     * @param state BlockState
     * @param blockEntity Copper_cable_Entity
     */
    public static void tick(World world, BlockPos pos, BlockState state, Copper_cable_Entity blockEntity)
    {

    }

    @Override
    protected void writeNbt(NbtCompound nbt)
    {
        super.writeNbt(nbt);

        nbt.putInt("U",U);
        nbt.putInt("I",I);
        nbt.putInt("T",T);
    }

    @Override
    public void readNbt(NbtCompound nbt)
    {
        super.readNbt(nbt);

        U = nbt.getInt("U");
        I = nbt.getInt("I");
        T = nbt.getInt("T");
    }

    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}

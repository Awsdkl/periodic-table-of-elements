package com.awsdkl.periodictableofelements.block.models.models;

import com.awsdkl.periodictableofelements.block.blocks.Copper_cable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.*;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Copper_cable 的 model <br/>
 * copper_cable: {@link Copper_cable}
 */
@Environment(EnvType.CLIENT)
public class Copper_cable_Model implements UnbakedModel, BakedModel, FabricBakedModel
{
    private static final SpriteIdentifier[] SPRITE_IDS = new SpriteIdentifier[]{
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("periodic-table-of-elements:block/cables/cables_front")),
        new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("periodic-table-of-elements:block/cables/copper_cable/copper_cable_side"))
    };

    private Sprite[] SPRITES = new Sprite[2];
    public Mesh mesh_mid;


    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random)
    {
        return Collections.emptyList();
    }

    @Override
    public boolean useAmbientOcclusion()
    {
        return true;
    }

    @Override
    public boolean hasDepth()
    {
        return false;
    }

    @Override
    public boolean isSideLit()
    {
        return false;
    }

    @Override
    public boolean isBuiltin()
    {
        return false;
    }

    @Override
    public boolean isVanillaAdapter()
    {
        return false; // false 以触发 FabricBakedModel 渲染
    }

    @Override
    public Sprite getParticleSprite()
    {
        return SPRITES[1];
    }

    @Override
    public ModelTransformation getTransformation()
    {
        return null;
    }

    @Override
    public ModelOverrideList getOverrides()
    {
        return null;
    }

    @Override
    public Collection<Identifier> getModelDependencies()
    {
        return Collections.emptyList();
    }

    @Override
    public void setParents(Function<Identifier, UnbakedModel> modelLoader)
    {
    }

    @Nullable
    @Override
    public BakedModel bake(Baker baker, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId)
    {
        // 获得sprites
        for(int i = 0; i < 2; i++) {
            SPRITES[i] = textureGetter.apply(SPRITE_IDS[i]);
        }
        // 用Renderer API构建mesh
        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = renderer.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        for(Direction direction : Direction.values()) {
            int spriteIdx = 1;
            // 将新的面（face）添加到mesh
            emitter.square(direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f);
            // 设置面的sprite，必须在.square()之后调用
            // 我们还没有指定任何uv坐标，所以我们使用整个纹理，BAKE_LOCK_UV恰好就这么做。
            emitter.spriteBake(0, SPRITES[spriteIdx], MutableQuadView.BAKE_LOCK_UV);
            // 启用纹理使用
            emitter.spriteColor(0, -1, -1, -1, -1);
            // 将quad添加到mesh
            emitter.emit();
        }

        this.mesh_mid = builder.build();

        return this;
    }

    /**
     * 渲染函数
     * @param blockView Access to world state. Cast to {@code RenderAttachedBlockView} to
     * retrieve block entity data unless thread safety can be guaranteed.
     * @param state Block state for model being rendered.
     * @param pos Position of block for model being rendered.
     * @param randomSupplier  Random object seeded per vanilla conventions. Call multiple times to re-seed.
     * Will not be thread-safe. Do not cache or retain a reference.
     * @param context Accepts model output.
     */
    @Override
    public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context)
    {
        mesh_mid.outputTo(context.getEmitter());
    }
}

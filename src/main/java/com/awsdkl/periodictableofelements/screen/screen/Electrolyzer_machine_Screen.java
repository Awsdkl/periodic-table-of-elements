package com.awsdkl.periodictableofelements.screen.screen;

import com.awsdkl.periodictableofelements.screen.handler.Electrolyzer_machine_ScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import javax.swing.plaf.TextUI;

import static com.awsdkl.periodictableofelements.PeriodicTableOfElements.NAMESPACE;

public class Electrolyzer_machine_Screen extends HandledScreen<Electrolyzer_machine_ScreenHandler>
{
    private static final Identifier TEXTURE = new Identifier(NAMESPACE, "textures/gui/electrolyzer_machine_gui.png");

    public Electrolyzer_machine_Screen(Electrolyzer_machine_ScreenHandler handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
        // this.passEvents = false;
        this.backgroundHeight = 167;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,TEXTURE);
        context.drawTexture(
                TEXTURE,
                this.x,
                this.y,
                0,
                0,
                this.backgroundWidth,
                this.backgroundHeight
        );
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta)
    {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }
}

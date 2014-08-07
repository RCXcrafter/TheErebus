package erebus.client.render.tileentity;

import erebus.client.model.block.ModelOfferingAltar;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class TileEntityOfferingAltarRenderer extends TileEntitySpecialRenderer
{
    public ModelOfferingAltar model = new ModelOfferingAltar();

    public void renderTileEntityAt(TileEntity t, double x, double y, double z, float m)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
        GL11.glScalef(0.5F, -0.5F, -0.5F);
        model.render();
        GL11.glPopMatrix();
    }
}

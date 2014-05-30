package erebus.network.client;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.network.AbstractClientPacket;

// @formatter:off
public class C00EntityParticle extends AbstractClientPacket{
	public static enum ParticleType{
		BEETLE_LARVA_SQUISH;
		
		static final ParticleType[] values = values();
	}
	
	private int entityId;
	private byte particleType;
	
	public C00EntityParticle(){}
	
	public C00EntityParticle(Entity entity, ParticleType particleType){
		this.entityId = entity.getEntityId();
		this.particleType = (byte)particleType.ordinal();
	}
	
	@Override
	public void write(ChannelHandlerContext ctx, ByteBuf buffer){
		buffer.writeInt(entityId).writeByte(particleType);
	}

	@Override
	public void read(ChannelHandlerContext ctx, ByteBuf buffer){
		entityId = buffer.readInt();
		particleType = buffer.readByte();
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected void handle(EntityClientPlayerMP player){
		if (particleType < 0 || particleType >= ParticleType.values.length)return;
		
		EffectRenderer eff = Minecraft.getMinecraft().effectRenderer;
		Entity e = player.worldObj.getEntityByID(entityId);

		switch(ParticleType.values[particleType]){
			case BEETLE_LARVA_SQUISH:
				for(int count = 0; count <= 200; ++count){
					eff.addEffect(new EntityBreakingFX(player.worldObj,e.posX+(rand.nextDouble()-0.5D)*e.width,e.posY+rand.nextDouble()*e.height-e.yOffset,e.posZ+(rand.nextDouble()-0.5D)*e.width,Items.slime_ball));
				}
				break;
				
			default:;
		}
	}
}
//@formatter:on
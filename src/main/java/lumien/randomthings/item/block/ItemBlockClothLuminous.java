package lumien.randomthings.item.block;

import lumien.randomthings.RandomThings;
import lumien.randomthings.lib.ILuminous;
import lumien.randomthings.lib.IRTBlockColor;
import lumien.randomthings.lib.IRTItemColor;
import net.minecraft.block.Block;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;

public class ItemBlockClothLuminous extends ItemCloth implements ILuminous, IRTItemColor
{

	public ItemBlockClothLuminous(Block block)
	{
		super(block);
		
		RandomThings.proxy.scheduleColor(this);
	}

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex)
	{
		return ((IRTBlockColor)this.block).colorMultiplier(null, null, null, tintIndex);
	}
}
package lumien.randomthings.block.redstoneinterface;

import java.util.HashSet;

import lumien.randomthings.RandomThings;
import lumien.randomthings.block.BlockRedstoneInterface;
import lumien.randomthings.item.ModItems;
import lumien.randomthings.lib.GuiIds;
import lumien.randomthings.tileentity.redstoneinterface.TileEntityBasicRedstoneInterface;
import lumien.randomthings.tileentity.redstoneinterface.TileEntityRedstoneInterface;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockBasicRedstoneInterface extends BlockRedstoneInterface
{
	public BlockBasicRedstoneInterface()
	{
		super("basicRedstoneInterface", Material.rock);

		this.setHardness(2);
	}

	@Override
	public TileEntity createTileEntity(World world,IBlockState state)
	{
		return new TileEntityBasicRedstoneInterface();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
		{
			ItemStack equipped = playerIn.getCurrentEquippedItem();
			if (equipped != null && equipped.getItem() == ModItems.redstoneTool)
			{
				return false;
			}

			playerIn.openGui(RandomThings.instance, GuiIds.BASIC_REDSTONE_INTERFACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		return true;
	}
}
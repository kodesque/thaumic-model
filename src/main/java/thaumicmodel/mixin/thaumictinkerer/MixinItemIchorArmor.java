package thaumicmodel.mixin.thaumictinkerer;

import com.nekokittygames.thaumictinkerer.common.items.Kami.ItemIchorArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import thaumicmodel.client.models.ModelIchorArmor;

@Mixin({ItemIchorArmor.class})
public class MixinItemIchorArmor extends ItemArmor {
    ModelBiped model1 = null;
    ModelBiped model2 = null;

    public MixinItemIchorArmor(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
    }

    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "thaumicmodel:textures/models/ichorarmor_new.png";
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (this.model1 == null) {
            this.model1 = new ModelIchorArmor(false);
        }

        if (this.model2 == null) {
            this.model2 = new ModelIchorArmor(true);
        }

        return armorSlot == EntityEquipmentSlot.LEGS ? this.model2 : this.model1;
    }
}
package thaumicmodel.mixin.thaumicbases;

import com.rumaruka.thaumicbases.common.item.ItemBloodyArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import thaumicmodel.client.models.ModelBloodArmor;

@Mixin({ItemBloodyArmor.class})
public class MixinItemBloodArmor extends ItemArmor {
    ModelBiped model1 = null;
    ModelBiped model2 = null;

    public MixinItemBloodArmor(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
    }

    @Inject(
            method = {"getArmorTexture"},
            at = {@At("HEAD")},
            remap = false,
            cancellable = true
    )
    public void mixinGetArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type, CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("thaumicmodel:textures/models/bloodarmor_new.png");
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (this.model1 == null) {
            this.model1 = new ModelBloodArmor(false);
        }

        if (this.model2 == null) {
            this.model2 = new ModelBloodArmor(true);
        }

        return armorSlot == EntityEquipmentSlot.LEGS ? this.model2 : this.model1;
    }
}

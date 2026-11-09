package thaumicmodel.mixin.thaumcraft;

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
import thaumcraft.common.items.armor.ItemRobeArmor;
import thaumicmodel.client.models.ModelRobeArmor;

@Mixin({ItemRobeArmor.class})
public class MixinItemRobeArmor extends ItemArmor {
    ModelBiped model1 = null;
    ModelBiped model2 = null;

    public MixinItemRobeArmor(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
    }

    @Inject(
            method = {"getArmorTexture"},
            at = {@At("HEAD")},
            remap = false,
            cancellable = true
    )
    public void mixinGetArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type, CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("thaumicmodel:textures/models/clotharmor_new.png");
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (this.model1 == null) {
            this.model1 = new ModelRobeArmor(false);
        }

        if (this.model2 == null) {
            this.model2 = new ModelRobeArmor(true);
        }

        return armorSlot == EntityEquipmentSlot.LEGS ? this.model2 : this.model1;
    }
}
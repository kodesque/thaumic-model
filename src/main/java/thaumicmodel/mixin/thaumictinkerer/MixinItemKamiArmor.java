package thaumicmodel.mixin.thaumictinkerer;

import com.nekokittygames.thaumictinkerer.common.items.Kami.ItemKamiArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import thaumicmodel.client.models.ModelKamiArmor;

@Mixin({ItemKamiArmor.class})
public class MixinItemKamiArmor extends ItemArmor {
    ModelBiped model1 = null;
    ModelBiped model2 = null;

    public MixinItemKamiArmor(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
    }

    @Inject(
            method = {"getArmorTexture"},
            at = {@At("HEAD")},
            remap = false,
            cancellable = true
    )
    public void mixinGetArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type, CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("thaumicmodel:textures/models/kamiarmor_new.png");
    }

    @Inject(
            method = {"getArmorModel"},
            at = {@At("HEAD")},
            remap = false,
            cancellable = true
    )
    public void getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default, CallbackInfoReturnable<ModelBiped> cir) {
        if (this.model1 == null) {
            this.model1 = new ModelKamiArmor(false);
        }

        if (this.model2 == null) {
            this.model2 = new ModelKamiArmor(true);
        }

        cir.setReturnValue(armorSlot == EntityEquipmentSlot.LEGS ? this.model2 : this.model1);
    }
}

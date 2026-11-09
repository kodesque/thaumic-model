package thaumicmodel.mixin.thaumicconcilium;

import com.keletu.thaumicconcilium.items.ItemPontifexRobe;
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
import thaumicmodel.models.ModelPontifexArmorNew;

@Mixin({ItemPontifexRobe.class})
public class MixinItemPontifexArmor extends ItemArmor {
    ModelBiped model1 = null;
    ModelBiped model2 = null;

    public MixinItemPontifexArmor(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
    }

    @Inject(
            method = {"getArmorTexture"},
            at = {@At("HEAD")},
            remap = false,
            cancellable = true
    )
    public void mixinGetArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type, CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("thaumicmodel:textures/models/pontifexrobe_new.png");
    }

    @Inject(
            method = {"getArmorModel"},
            at = {@At("HEAD")},
            remap = false,
            cancellable = true
    )
    public void getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default, CallbackInfoReturnable<ModelBiped> cir) {
        if (this.model1 == null) {
            this.model1 = new ModelPontifexArmorNew(false);
        }

        if (this.model2 == null) {
            this.model2 = new ModelPontifexArmorNew(true);
        }

        cir.setReturnValue(armorSlot == EntityEquipmentSlot.LEGS ? this.model2 : this.model1);
    }
}

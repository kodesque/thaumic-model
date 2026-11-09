package thaumicmodel.client.models;

import com.nekokittygames.thaumictinkerer.common.items.Kami.ItemIchorArmor;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class ModelIchorArmor extends ModelArmorStandFixed {
    private final ModelRenderer Head;
    private final ModelRenderer Head_Chest;
    private final ModelRenderer BodyLayer_r1;
    private final ModelRenderer Body;
    private final ModelRenderer BodyLayer_r2;
    private final ModelRenderer BodyLayer_r3;
    private final ModelRenderer BodyLayer_r4;
    private final ModelRenderer BodyLayer_r5;
    private final ModelRenderer BodyLayer_r6;
    private final ModelRenderer RightArm;
    private final ModelRenderer RightArmLayer_r1;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftArmLayer_r1;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer Chest_Legs;
    private final ModelRenderer LeftArm_Legs;
    private final ModelRenderer RightArm_Legs;
    private final ModelRenderer LeftBoot;
    private final ModelRenderer LeftLegLayer_r1;
    private final ModelRenderer RightBoot;
    private final ModelRenderer RightLegLayer_r1;
    public boolean isLegs;
    private static final HashMap<Integer, Integer> hasSet = new HashMap();

    public ModelIchorArmor(boolean legs) {
        this.isLegs = legs;
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.cubeList.add(new ModelBox(this.Head, 40, 13, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.6F, false));
        this.Head_Chest = new ModelRenderer(this);
        this.Head_Chest.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.BodyLayer_r1 = new ModelRenderer(this);
        this.BodyLayer_r1.setRotationPoint(0.0F, -2.0F, 1.9454F);
        this.Head_Chest.addChild(this.BodyLayer_r1);
        this.setRotationAngle(this.BodyLayer_r1, 0.1309F, 0.0F, 0.0F);
        this.BodyLayer_r1.cubeList.add(new ModelBox(this.BodyLayer_r1, 0, 0, -5.0F, -24.0F, -4.0F, 10, 3, 10, 0.25F, false));
        this.Body = new ModelRenderer(this);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.cubeList.add(new ModelBox(this.Body, 96, 39, -5.0F, -0.1F, -2.4F, 10, 11, 6, 0.25F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 13, -5.0F, 11.2F, -2.0F, 10, 9, 5, 0.5F, false));
        this.BodyLayer_r2 = new ModelRenderer(this);
        this.BodyLayer_r2.setRotationPoint(0.0F, 24.4F, 2.4299F);
        this.Body.addChild(this.BodyLayer_r2);
        this.setRotationAngle(this.BodyLayer_r2, 0.1745F, 0.0F, 0.0F);
        this.BodyLayer_r2.cubeList.add(new ModelBox(this.BodyLayer_r2, 40, 0, -4.0F, -25.0F, -3.0F, 8, 4, 9, 0.26F, false));
        this.BodyLayer_r3 = new ModelRenderer(this);
        this.BodyLayer_r3.setRotationPoint(0.0F, 40.7695F, -6.9465F);
        this.Body.addChild(this.BodyLayer_r3);
        this.setRotationAngle(this.BodyLayer_r3, -0.2618F, 0.0F, 0.0F);
        this.BodyLayer_r3.cubeList.add(new ModelBox(this.BodyLayer_r3, 26, 29, -4.0F, -24.0F, -3.0F, 8, 6, 1, 0.0F, false));
        this.BodyLayer_r4 = new ModelRenderer(this);
        this.BodyLayer_r4.setRotationPoint(0.0F, 36.2F, -2.3F);
        this.Body.addChild(this.BodyLayer_r4);
        this.setRotationAngle(this.BodyLayer_r4, -0.0873F, 0.0F, 0.0F);
        this.BodyLayer_r4.cubeList.add(new ModelBox(this.BodyLayer_r4, 30, 13, -4.0F, -24.0F, -3.0F, 8, 5, 1, 0.0F, false));
        this.BodyLayer_r5 = new ModelRenderer(this);
        this.BodyLayer_r5.setRotationPoint(0.0F, 24.3F, 0.5F);
        this.Body.addChild(this.BodyLayer_r5);
        this.setRotationAngle(this.BodyLayer_r5, 0.0436F, 0.0F, 0.0F);
        this.BodyLayer_r5.cubeList.add(new ModelBox(this.BodyLayer_r5, 72, 20, -4.0F, -20.0F, -3.0F, 8, 8, 1, 0.25F, false));
        this.BodyLayer_r6 = new ModelRenderer(this);
        this.BodyLayer_r6.setRotationPoint(-1.0F, 35.7409F, 7.0768F);
        this.Body.addChild(this.BodyLayer_r6);
        this.setRotationAngle(this.BodyLayer_r6, 0.1745F, 0.0F, 0.0F);
        this.BodyLayer_r6.cubeList.add(new ModelBox(this.BodyLayer_r6, 0, 27, -4.0F, -25.0F, -2.0F, 10, 11, 3, 0.0F, false));
        this.RightArm = new ModelRenderer(this);
        this.RightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightArmLayer_r1 = new ModelRenderer(this);
        this.RightArmLayer_r1.setRotationPoint(-0.5F, 22.6F, -0.5F);
        this.RightArm.addChild(this.RightArmLayer_r1);
        this.setRotationAngle(this.RightArmLayer_r1, 0.0F, 0.0F, 0.2618F);
        this.RightArmLayer_r1.cubeList.add(new ModelBox(this.RightArmLayer_r1, 106, 0, -9.0F, -24.0F, -2.0F, 6, 12, 5, 0.25F, false));
        this.LeftArm = new ModelRenderer(this);
        this.LeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftArmLayer_r1 = new ModelRenderer(this);
        this.LeftArmLayer_r1.setRotationPoint(0.6F, 22.6F, -0.5F);
        this.LeftArm.addChild(this.LeftArmLayer_r1);
        this.setRotationAngle(this.LeftArmLayer_r1, 0.0F, 0.0F, -0.2618F);
        this.LeftArmLayer_r1.cubeList.add(new ModelBox(this.LeftArmLayer_r1, 106, 18, 3.0F, -24.0F, -2.0F, 6, 12, 5, 0.25F, false));
        this.RightLeg = new ModelRenderer(this);
        this.RightLeg.setRotationPoint(0.1F, 0.0F, 0.0F);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 85, 31, -2.1F, 0.7F, -2.0F, 4, 8, 4, 0.35F, false));
        this.LeftLeg = new ModelRenderer(this);
        this.LeftLeg.setRotationPoint(-0.1F, 0.0F, 0.0F);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 85, 31, -1.8F, 0.7F, -2.0F, 4, 8, 4, 0.35F, false));
        this.Chest_Legs = new ModelRenderer(this);
        this.Chest_Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Chest_Legs.cubeList.add(new ModelBox(this.Chest_Legs, 21, 44, -4.0F, -24.0F, -2.0F, 8, 12, 4, 0.35F, false));
        this.LeftArm_Legs = new ModelRenderer(this);
        this.LeftArm_Legs.setRotationPoint(-5.0F, 22.0F, 0.0F);
        this.LeftArm_Legs.cubeList.add(new ModelBox(this.LeftArm_Legs, 46, 33, 4.1F, -24.0F, -2.0F, 4, 13, 4, 0.35F, false));
        this.LeftArm_Legs.cubeList.add(new ModelBox(this.LeftArm_Legs, 90, 0, 4.1F, -16.0F, -2.0F, 4, 2, 4, 0.5F, false));
        this.RightArm_Legs = new ModelRenderer(this);
        this.RightArm_Legs.setRotationPoint(5.0F, 22.0F, 0.0F);
        this.RightArm_Legs.cubeList.add(new ModelBox(this.RightArm_Legs, 46, 33, -8.0F, -24.0F, -2.0F, 4, 13, 4, 0.35F, false));
        this.RightArm_Legs.cubeList.add(new ModelBox(this.RightArm_Legs, 90, 0, -8.0F, -16.0F, -2.0F, 4, 2, 4, 0.5F, false));
        this.LeftBoot = new ModelRenderer(this);
        this.LeftBoot.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.LeftBoot.cubeList.add(new ModelBox(this.LeftBoot, 74, 0, 0.4F, -6.3F, -2.0F, 4, 6, 4, 0.6F, false));
        this.LeftLegLayer_r1 = new ModelRenderer(this);
        this.LeftLegLayer_r1.setRotationPoint(0.3F, 0.0F, -1.2F);
        this.LeftBoot.addChild(this.LeftLegLayer_r1);
        this.setRotationAngle(this.LeftLegLayer_r1, -0.2182F, 0.0F, 0.0F);
        this.LeftLegLayer_r1.cubeList.add(new ModelBox(this.LeftLegLayer_r1, 77, 5, -0.1F, -4.0F, -2.0F, 4, 4, 1, 0.4F, false));
        this.RightBoot = new ModelRenderer(this);
        this.RightBoot.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.RightBoot.cubeList.add(new ModelBox(this.RightBoot, 74, 0, -4.4F, -6.3F, -2.0F, 4, 6, 4, 0.6F, false));
        this.RightLegLayer_r1 = new ModelRenderer(this);
        this.RightLegLayer_r1.setRotationPoint(-4.1F, 0.0F, -1.2F);
        this.RightBoot.addChild(this.RightLegLayer_r1);
        this.setRotationAngle(this.RightLegLayer_r1, -0.2182F, 0.0F, 0.0F);
        this.RightLegLayer_r1.cubeList.add(new ModelBox(this.RightLegLayer_r1, 77, 5, -0.1F, -4.0F, -2.0F, 4, 4, 1, 0.4F, false));
        this.bipedHeadwear.cubeList.clear();
        this.bipedHead.cubeList.clear();
        this.bipedLeftArm.cubeList.clear();
        this.bipedRightArm.cubeList.clear();
        this.bipedBody.cubeList.clear();
        this.bipedLeftLeg.cubeList.clear();
        this.bipedRightLeg.cubeList.clear();
        if (legs) {
            this.bipedBody.addChild(this.Chest_Legs);
            this.bipedLeftArm.addChild(this.LeftArm_Legs);
            this.bipedRightArm.addChild(this.RightArm_Legs);
            this.bipedLeftLeg.addChild(this.LeftLeg);
            this.bipedRightLeg.addChild(this.RightLeg);
        } else {
            this.bipedHead.addChild(this.Head);
            this.bipedBody.addChild(this.Head_Chest);
            this.bipedBody.addChild(this.Body);
            this.bipedLeftArm.addChild(this.LeftArm);
            this.bipedRightArm.addChild(this.RightArm);
            this.bipedLeftLeg.addChild(this.LeftBoot);
            this.bipedRightLeg.addChild(this.RightBoot);
        }

    }

    private void checkSet(Entity entity) {
        if (entity instanceof EntityLivingBase && entity.ticksExisted % 20 == 0) {
            ItemStack head = ((EntityLivingBase)entity).getItemStackFromSlot(EntityEquipmentSlot.HEAD);
            ItemStack chest = ((EntityLivingBase)entity).getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            this.Head_Chest.isHidden = !(head.getItem() instanceof ItemIchorArmor) || !(chest.getItem() instanceof ItemIchorArmor);
        }

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.checkSet(entity);
        super.render(entity, f, f1, f2, f3, f4, f5);
    }

    public void setVisible(boolean visible) {
        this.bipedHead.showModel = visible;
        this.bipedHeadwear.showModel = visible;
        this.bipedBody.showModel = visible;
        this.bipedRightArm.showModel = visible || this.isLegs;
        this.bipedLeftArm.showModel = visible || this.isLegs;
        this.bipedRightLeg.showModel = visible;
        this.bipedLeftLeg.showModel = visible;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

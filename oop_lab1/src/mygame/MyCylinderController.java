package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Cylinder;
import com.jme3.texture.Texture;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCylinderController {

    private static final Cylinder CYLINDER = new Cylinder(32, 32, 1, 4, true);
    
    private Node rootNode;
    private BulletAppState bulletAppState;
    private Material material;
    private List<MyCylinder> cylinders = new ArrayList<MyCylinder>();


    MyCylinderController() {

    }

    MyCylinderController(AssetManager assetManager, Node rootNode, BulletAppState bulletAppState) {
        this.rootNode = rootNode;
        this.bulletAppState = bulletAppState;

        initMaterials(assetManager);
    }

    private void initMaterials(AssetManager assetManager) {
        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key2 = new TextureKey("Textures/cylinder.jpg");
        key2.setGenerateMips(true);
        Texture tex2 = assetManager.loadTexture(key2);
        material.setTexture("ColorMap", tex2);
    }

    protected void createCylinder(Camera cam) {
        cylinders.add(new MyCylinder(cam, bulletAppState, material, rootNode));
    }

    protected void move() {
        for (MyCylinder cylinder : cylinders)
            cylinder.move();
    }

}



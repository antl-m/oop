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
import java.util.Random;

public class MyCylinder {

    private Node rootNode;
    private BulletAppState bulletAppState;
    private Material material;
    private ArrayList<RigidBodyControl> phys = new ArrayList<>();
    private static final Cylinder CYLINDER;

    static {
        CYLINDER = new Cylinder(32, 32, 1, 4, true);
    }

    MyCylinder() {

    }

    MyCylinder(AssetManager assetManager, Node rootNode, BulletAppState bulletAppState) {
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

    private void initCylinders(Vector3f position) {
        RigidBodyControl phy;
        Geometry geo = new Geometry("my cylinder", CYLINDER);
        geo.setMaterial(material);
        rootNode.attachChild(geo);

        phy = new RigidBodyControl(2);
        geo.addControl(phy);

        bulletAppState.getPhysicsSpace().add(phy);
        phy.setPhysicsLocation(position);
    }

    protected void createCylinder(Camera cam) {
        RigidBodyControl phy;
        Geometry geo = new Geometry("my cylinder", CYLINDER);
        geo.setMaterial(material);
        rootNode.attachChild(geo);

        phy = new RigidBodyControl(2);
        geo.addControl(phy);

        bulletAppState.getPhysicsSpace().add(phy);
        phy.setPhysicsLocation(Physics.calcPosition(cam));

        phys.add(phy);
    }

    protected void move(Camera cam) {
        Random rand = new Random();
        for (RigidBodyControl ball_phy : phys) {
            ball_phy.setLinearVelocity(Physics.calcDirection(cam, ball_phy).mult(2 + rand.nextInt(1)));
        }
    }

}



package mygame;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Cylinder;
import java.util.Random;

public class MyCylinder extends RigidBodyControl {

    private static final Cylinder CYLINDER = new Cylinder(32, 32, 1, 4, true);
    
    private Geometry geo;
    private Physics phy;

    MyCylinder(Camera cam, BulletAppState bulletAppState, Material material, Node rootNode) {
        super(2);
        phy = new Physics(cam, this);
        geo = new Geometry("my cylinder", CYLINDER);
        geo.addControl(this);
        geo.setMaterial(material);
        rootNode.attachChild(geo);
        bulletAppState.getPhysicsSpace().add(this);
        setPhysicsLocation(phy.calcPosition());
    }


    protected void move() {
        Random rand = new Random();
        setLinearVelocity(phy.calcDirection().mult(2 + rand.nextInt(1)));
    }

}



package mygame;

import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import java.util.Random;

public class Physics {
    
    private final Camera cam;
    private final RigidBodyControl cylinder;
    
    public Physics(Camera cam, RigidBodyControl cylinder) {
        this.cam = cam;
        this.cylinder = cylinder;
    }
    
    public Vector3f calcPosition() {
        Vector3f v = cam.getDirection();
        Vector3f p = cam.getLocation();

        return new Vector3f((v.x * (0.5f - p.y) / v.y) + p.x, 0.5f, (v.z * (0.5f - p.y) / v.y) + p.z);
    }

    public Vector3f calcDirection() {
        Vector3f v = cam.getDirection();
        Vector3f p = cam.getLocation();
        Random rand = new Random();

        return new Vector3f((v.x * (0.5f - p.y) / v.y) + p.x - cylinder.getPhysicsLocation().x, 0.5f,
                (v.z * (0.5f - p.y) / v.y) + p.z - cylinder.getPhysicsLocation().z + rand.nextFloat() % 3f);
    }
    
}

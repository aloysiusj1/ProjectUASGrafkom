import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class DummyTest {
    private Window window = new Window(800, 800, "Dummy Main");
    Camera camera = new Camera();
    float rotation = (float)Math.toRadians(1f);
    boolean tpp = false, fpp = false;

    Projection projection = new Projection(window.getWidth(), window.getHeight());

    ArrayList<Circle3D> importX = new ArrayList<Circle3D>();
    List<ShaderProgram.ShaderModuleData> shaderModuleDataList = Arrays.asList(
            new ShaderProgram.ShaderModuleData(
                    "Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/resources/shaders/scene.vert", GL_VERTEX_SHADER),
            new ShaderProgram.ShaderModuleData(
                    "Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
    );
    Model m = null;
    Model m1 = null;
    Model m2 = null;
    Model m3 = null;
    Model m4 = null;
    Model m5 = null;
    Model m6 = null;
    Model m7 = null;
    Model m8 = null;
    Model m9 = null;
    Model m10 = null;
    Model m11 = null;
    Model m12 = null;
    Model m13 = null;
    Model m14 = null;
    Model w1 = null;
    Model w2 = null;
    Model w3 = null;
    Model w4 = null;
    Model w5 = null;
    Model y0 = null;
    Model y1 = null;
    Model y2 = null;
    Model y3 = null;
    Model y4 = null;
    Model y5 = null;
    Model y6 = null;



    public void run() {
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glDepthMask(true);
        glDepthFunc(GL_LEQUAL);
        glDepthRange(0.0f, 1.0f);

        camera.setPosition(2.64f, 2.78f, 28f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));

        try{
            m  = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/kepalaeva.obj"));
            m1 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/mataeva.obj"));
            m2 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/untitled.obj"));
            m3 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/lorong.obj"));
            m4 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/mukahitameve.obj"));
            m5 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/desert.obj"));
            m6 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/sun.obj"));
            m7 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/lampulorong.obj"));
            m8 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/kota.obj"));
            m9 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/bangunanskyscraper.obj"));
            m10 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/tiangskyscraper.obj"));
            m11 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/rock.obj"));
            m12 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/building.obj"));
            m13= ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/bangunan2.obj"));
            m14= ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/barrier.obj"));
            w1 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/walle_mata.obj"));
            w2 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/walle_kepala.obj"));
            w3 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/walle_badan.obj"));
            w4 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/walle_tangan3.obj"));
            w5 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/walle_ban.obj"));
            y0 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/badan.obj"));
            y1 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/kepala.obj"));
            y2 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/bahu.obj"));
            y3 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/lengan.obj"));
            y4 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/jari.obj"));
            y5 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/mata.obj"));
            y6 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/propeler.obj"));

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        //badan dan tangan eve
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(1f, 1f, 1f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m2));
        importX.get(0).translateObject(2f,0.2f,0f);
        //kepala eve
        importX.get(0).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m));
        importX.get(0).getChildObject().get(0).scaleObject(0.8f,0.8f,0.8f);
        importX.get(0).getChildObject().get(0).translateObject(2f,2.5f,0f);

        //muka hitam eve
        importX.get(0).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m4));
        importX.get(0).getChildObject().get(1).scaleObject(0.8f,0.8f,0.85f);
        importX.get(0).getChildObject().get(1).translateObject(2f,2.5f,0f);
        //mata eve
        importX.get(0).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(153/255f, 255/255f, 255/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m1));
        importX.get(0).getChildObject().get(2).translateObject(2.88f,2.05f,0.02f);
        importX.get(0).getChildObject().get(2).scaleObject(0.9f,0.9f,0.9f);


        //desert
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(248/255f, 177/255f, 10/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(2f, 2f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m5));
        importX.get(1).scaleObject(9f,9f,9f);

        //lorong
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m3));
        importX.get(2).translateObject(0f,0f,-1f);

        //matahari
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(253/255f, 184/255f, 19/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m6));
        importX.get(3).translateObject(0f,25f,0f);
        importX.get(3).scaleObject(3f,3f,3f);
        //lampu lorong
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 255/255f, 255/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m7));
        importX.get(4).translateObject(1.852f,3.95f,4.0f);
        //lampu lorong
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 255/255f, 255/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m7));
        importX.get(5).translateObject(4.354f,3.95f,4.0f);
        //badan walle
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 128/255f, 0/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(3f,-2f,12.5f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                w3));
        importX.get(6).translateObject(3f,-2f,12.5f);
        importX.get(6).scaleObject(0.3f,0.3f,0.3f);

        //kepala walle
        importX.get(6).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(224/255f, 224/255f, 224/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                w2));
        importX.get(6).getChildObject().get(0).translateObject(1.45f,-2f,10f);
        importX.get(6).getChildObject().get(0).scaleObject(0.4f,0.4f,0.4f);
        // mata walle
        importX.get(6).getChildObject().get(0).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                w1));
        importX.get(6).getChildObject().get(0).getChildObject().get(0).translateObject(2.78f,1.3f,5.65f);
        importX.get(6).getChildObject().get(0).getChildObject().get(0).scaleObject(0.8f,0.8f,0.8f);
        //tangan walle
        importX.get(6).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 178/255f, 152/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                w4));
        importX.get(6).getChildObject().get(1).translateObject(14f,-2f,12f);
        importX.get(6).getChildObject().get(1).scaleObject(0.3f,0.3f,0.3f);
        //ban walle
        importX.get(6).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                w5));
        importX.get(6).getChildObject().get(2).translateObject(2f,-2.5f,20f);
        importX.get(6).getChildObject().get(2).scaleObject(0.3f,0.3f,0.3f);

        //YOEL BADAN
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(130/255f, 10/255f, 15/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                y0));
        importX.get(7).translateObject(0f,5.0f,0f);
        //YOEL KEPALA
        importX.get(7).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(1f, 1f, 1f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                y1));
        importX.get(7).getChildObject().get(0).translateObject(0.27f,6.6f,-0.5f);
        //YOEL BAHU
        importX.get(7).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(120/255f, 95/255f, 10/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                y2));
        importX.get(7).getChildObject().get(1).translateObject(-0.13f,5.6f,0f);
        //YOEL LENGAN
        importX.get(7).getChildObject().get(1).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(130/255f, 10/255f, 15/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                y3));
        importX.get(7).getChildObject().get(1).getChildObject().get(0).translateObject(0.045f,4.47f,0.5f);
        //YOEL JARI
        importX.get(7).getChildObject().get(1).getChildObject().get(0).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(120/255f, 95/255f, 10/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                y4));
        importX.get(7).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-0.384f,3.35f,0.75f);
        //YOEL MATA
        importX.get(7).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(120/255f, 95/255f, 10/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                y5));
        importX.get(7).getChildObject().get(2).translateObject(-1.9f,4.1f,-0.12f);
        //YOEL PROPELLER
        importX.get(7).getChildObject().get(2).getChildObject().add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(200/255f, 195/255f, 180/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                y6));
        importX.get(7).getChildObject().get(2).getChildObject().get(0).translateObject(-1.66f,4.1f,-0.01f);
        //bangunan
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(128/255f, 128/255f, 128/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m8));
        importX.get(8).translateObject(-19f,0f,10f);
        //bangunan skyscraper
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(128/255f, 128/255f, 128/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m9));
        importX.get(9).translateObject(24f,0f,-20f);
        importX.get(9).scaleObject(0.4f,0.4f,0.4f);

        //tiang skyscraper
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(183/255f, 65/255f, 14/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m10));
        importX.get(10).translateObject(12f,0f,-20f);
        importX.get(10).scaleObject(0.3f,0.3f,0.3f);

        //batu sampah
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(64/255f, 64/255f, 64/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m11));
        importX.get(11).translateObject(60f,0f,80f);
        importX.get(11).scaleObject(0.3f,0.3f,0.3f);
        //batu sampah2
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(196/255f, 164/255f, 132/255f,1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m11));
        importX.get(12).translateObject(-20f,0f,-80f);
        importX.get(12).scaleObject(0.3f,0.3f,0.3f);
        //bangunan 3
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(90/255f, 77/255f, 65/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m12));
        importX.get(13).translateObject(-15f,0f,-20f);
        importX.get(13).scaleObject(2f,2f,2f);
        //bangunan 4
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(90/255f, 77/255f, 65/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m13));
        importX.get(14).translateObject(7.5f,0f,-9f);
        importX.get(14).scaleObject(5f,5f,5f);

        //barrier
        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(210/255f, 209/255f, 205/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m14));
        importX.get(15).translateObject(-7.5f,0f,10f);
        importX.get(15).scaleObject(5f,5f,5f);

    }

    public void tpsMode(){
        Vector3f pos = importX.get(0).getModel().transformPosition(new Vector3f());

        ArrayList<Vector3f> tpsPos = new ArrayList<>(List.of());

        for(double i=0;i<360;i+=360/360){
            float x = (float)(pos.x + 110f*Math.sin(Math.toRadians(i)));
            float z = (float)(pos.z + 110f*Math.cos(Math.toRadians(i)));
            tpsPos.add(new Vector3f(x, pos.y+13f, z));
        }
        camera.setPosition(tpsPos.get((int)rotation).x,tpsPos.get((int)rotation).y, tpsPos.get((int)rotation).z);
    }
    public void tpsMode1(){
        Vector3f pos = importX.get(7).getModel().transformPosition(new Vector3f());

        ArrayList<Vector3f> tpsPos = new ArrayList<>(List.of());

        for(double i=0;i<360;i+=360/360){
            float x = (float)(pos.x + 110f*Math.sin(Math.toRadians(i)));
            float z = (float)(pos.z + 110f*Math.cos(Math.toRadians(i)));
            tpsPos.add(new Vector3f(x, pos.y+13f, z));
        }
        camera.setPosition(tpsPos.get((int)rotation).x,tpsPos.get((int)rotation).y, tpsPos.get((int)rotation).z);
    }
    public void tpsMode2(){
        Vector3f pos = importX.get(6).getModel().transformPosition(new Vector3f());

        ArrayList<Vector3f> tpsPos = new ArrayList<>(List.of());

        for(double i=0;i<360;i+=360/360){
            float x = (float)(pos.x + 110f*Math.sin(Math.toRadians(i)));
            float z = (float)(pos.z + 110f*Math.cos(Math.toRadians(i)));
            tpsPos.add(new Vector3f(x, pos.y+13f, z));
        }
        camera.setPosition(tpsPos.get((int)rotation).x,tpsPos.get((int)rotation).y, tpsPos.get((int)rotation).z);
    }

    public void fpsMode() {
        Vector3f pos = importX.get(0).getModel().transformPosition(new Vector3f());

        ArrayList<Vector3f> fpsPos = new ArrayList<>(List.of());

        for (double i = 0; i < 360; i += 360 / 360) {
            float x = (float) (pos.x + 1f * Math.sin(Math.toRadians(i)));
            float z = (float) (pos.z + 1f * Math.cos(Math.toRadians(i)));
            fpsPos.add(new Vector3f(x, pos.y + 4f, z));
        }
        camera.setPosition(-fpsPos.get((int)rotation).x,-fpsPos.get((int)rotation).y,-fpsPos.get((int)rotation).z);
        camera.setRotation(0, (float)Math.toRadians(180f));
        camera.setPosition(fpsPos.get((int)rotation).x,fpsPos.get((int)rotation).y, fpsPos.get((int)rotation).z);
    }
    public void fpsMode1() {
        Vector3f pos = importX.get(7).getModel().transformPosition(new Vector3f());

        ArrayList<Vector3f> fpsPos = new ArrayList<>(List.of());

        for (double i = 0; i < 360; i += 360 / 360) {
            float x = (float) (pos.x + 1f * Math.sin(Math.toRadians(i)));
            float z = (float) (pos.z + 1f * Math.cos(Math.toRadians(i)));
            fpsPos.add(new Vector3f(x, pos.y + 4f, z));
        }
        camera.setPosition(-fpsPos.get((int)rotation).x,-fpsPos.get((int)rotation).y,-fpsPos.get((int)rotation).z);
        camera.setRotation(0, (float)Math.toRadians(180f));
        camera.setPosition(fpsPos.get((int)rotation).x,fpsPos.get((int)rotation).y, fpsPos.get((int)rotation).z);
    }
    public void fpsMode2() {
        Vector3f pos = importX.get(6).getModel().transformPosition(new Vector3f());

        ArrayList<Vector3f> fpsPos = new ArrayList<>(List.of());

        for (double i = 0; i < 360; i += 360 / 360) {
            float x = (float) (pos.x + 1f * Math.sin(Math.toRadians(i)));
            float z = (float) (pos.z + 1f * Math.cos(Math.toRadians(i)));
            fpsPos.add(new Vector3f(x, pos.y + 4f, z));
        }
        camera.setPosition(-fpsPos.get((int)rotation).x,-fpsPos.get((int)rotation).y,-fpsPos.get((int)rotation).z);
        camera.setRotation(0, (float)Math.toRadians(180f));
        camera.setPosition(fpsPos.get((int)rotation).x,fpsPos.get((int)rotation).y, fpsPos.get((int)rotation).z);
    }

    public void input() {

        if (window.isKeyPressed(GLFW_KEY_I)) {
            camera.moveForward(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            camera.moveBackwards(0.12f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT_ALT)) {
            camera.moveDown(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveUp(0.12f);
        }
        if (window.isKeyPressed(GLFW_KEY_J)) {
            camera.moveLeft(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            camera.moveRight(0.12f);
        }

        if (window.getMouseInput().isLeftButtonPressed()){
            Vector2f displayVec = window.getMouseInput().getDisplVec();
            camera.addRotation((float)Math.toRadians(displayVec.x * 0.1f), (float) Math.toRadians(displayVec.y * 0.1f));
        }

        if (window.getMouseInput().getScroll().y != 0){
            projection.setFOV(projection.getFOV()-(window.getMouseInput().getScroll().y*0.01f));
            window.getMouseInput().setScroll(new Vector2f());
        }

        if(window.isKeyPressed(GLFW_KEY_Z)){
            camera.rotateObjectCamera(0f,(float)(Math.toRadians(1)));
        }
        if(window.isKeyPressed(GLFW_KEY_X)){
            camera.rotateObjectCamera(0f,(float)(Math.toRadians(-1)));
        }
        if(window.isKeyPressed(GLFW_KEY_C)){
            camera.rotateObjectCamera((float)(Math.toRadians(1)),0);
        }
        if(window.isKeyPressed(GLFW_KEY_V)){
            camera.rotateObjectCamera((float)(Math.toRadians(-1)),0);
        }
        if(window.isKeyPressed(GLFW_KEY_COMMA))
        {
            camera.addRotation((float) Math.toRadians(0f), (float) Math.toRadians(-1f));
        }
        if(window.isKeyPressed(GLFW_KEY_SLASH))
        {
            camera.addRotation((float) Math.toRadians(0f), (float) Math.toRadians(1f));
        }
        if(window.isKeyPressed(GLFW_KEY_CAPS_LOCK))
        {
            camera.addRotation((float) Math.toRadians(1f), (float) Math.toRadians(0f));
        }
        if(window.isKeyPressed(GLFW_KEY_TAB))
        {
            camera.addRotation((float) Math.toRadians(-1f), (float) Math.toRadians(0f));
        }
        if(window.isKeyPressed(GLFW_KEY_Q)){
            importX.get(7).translateObject(0.0f, -0.04f, 0.0f);
        }
        if(window.isKeyPressed(GLFW_KEY_E)){
            importX.get(7).translateObject(0.0f, 0.04f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_LEFT_ALT)){
            importX.get(7).rotateObject((float)Math.toRadians(1f), 0f, 0.1f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_P)){
            camera.setPosition(2.6f, 2f, 6f);
            camera.setRotation(0, (float)Math.toRadians(180));
        }
        float x = importX.get(6).getCenterPoint().get(0);
        float y = importX.get(6).getCenterPoint().get(1);
        float z = importX.get(6).getCenterPoint().get(2);
        if(window.isKeyPressed(GLFW_KEY_O)){
            camera.setPosition(x, y, z);
            camera.setRotation(0, (float)Math.toRadians(180));
        }
        if(window.isKeyPressed(GLFW_KEY_R)){
            importX.get(6).rotateObject((float)Math.toRadians(1f),0f, 0.3f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_Y)){
            importX.get(6).translateObject(0f, 0.2f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_U)){
            importX.get(6).translateObject(0f, -0.2f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_1)){
            importX.get(0).translateObject(0.0f, 0f, 0.04f);
        }
        if(window.isKeyPressed(GLFW_KEY_2)){
            importX.get(0).translateObject(0.0f, 0.04f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_3)){
            importX.get(0).translateObject(0.04f, 0f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_0)){
            camera.setPosition(2.64f, 2.78f, 28f);
            camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
            tpp = false;
        }
        if(window.isKeyPressed(GLFW_KEY_4)){
            importX.get(0).rotateObject(0.002f, 0f, 1f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_5)){
            importX.get(0).translateObject(0.0f, 0f, -0.04f);
        }
        if(window.isKeyPressed(GLFW_KEY_6)){
            importX.get(0).translateObject(0.0f, -0.04f, 0f);
        }
        if(window.isKeyPressed(GLFW_KEY_7)){
            importX.get(0).translateObject(-0.04f, 0f, 0f);
        }
        // FPS triggering
        if (window.isKeyPressed(GLFW_KEY_BACKSLASH) && !fpp) {
            Vector3f pos = camera.getPosition();
            if (!fpp) {
                camera.setPosition(pos.x, pos.y, pos.z);
                camera.setRotation(0f, (float) Math.toRadians(0));
                camera.setPosition(-pos.x, -pos.y, -pos.z);
            }
            fpp = true;
            tpp = false;
            fpsMode();
        }
        /* FPS Camera
        if (window.isKeyPressed(GLFW_KEY_LEFT) && fpp){
            importX.get(0).translateObject(-0.1f, 0.0f, 0.0f);
            fpsMode();
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT) && fpp){
            importX.get(0).translateObject(0.1f, 0.0f, 0.0f);
            fpsMode();
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT_SHIFT) && fpp){
            importX.get(0).translateObject(0.0f, 0.0f, -1f);
            fpsMode();
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT_CONTROL) && fpp){
            importX.get(0).translateObject(0.0f, 0.0f, 1f);
            fpsMode();
        }*/
        // TPS triggering
        if (window.isKeyPressed(GLFW_KEY_RIGHT_BRACKET) && !tpp){
            Vector3f pos = camera.getPosition();
            if (!tpp) {
                camera.setPosition(-pos.x, -pos.y, -pos.z);
                camera.setRotation(0f, (float) Math.toRadians(0));
                camera.setPosition(pos.x, pos.y, pos.z);
            }
            fpp = false;
            tpp = true;
            tpsMode();
        }

        // TPS Camera eva
        if (window.isKeyPressed(GLFW_KEY_LEFT)){
            importX.get(0).translateObject(-0.1f, 0.0f, 0.0f);
            if(tpp){
                tpsMode();
            }
            if(fpp){
                fpsMode();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)){
            importX.get(0).translateObject(0.1f, 0.0f, 0.0f);
            if(tpp){
                tpsMode();
            }
            if(fpp){
                fpsMode();
            }

        }
        if (window.isKeyPressed(GLFW_KEY_UP)){
            importX.get(0).translateObject(0f, 0.0f, -0.1f);
            if(tpp){
                tpsMode();
            }
            if(fpp){
                fpsMode();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)){
            importX.get(0).translateObject(0f, 0.0f, 0.1f);
            if(tpp){
                tpsMode();
            }
            if(fpp){
                fpsMode();
            }
        }
        // TPS Camera robotYoel
        if (window.isKeyPressed(GLFW_KEY_A)){
            importX.get(7).translateObject(-0.1f, 0.0f, 0.0f);
            if(tpp){
                tpsMode1();
            }
            if(fpp){
                fpsMode1();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)){
            importX.get(7).translateObject(0.1f, 0.0f, 0.0f);
            if(tpp){
                tpsMode1();
            }
            if(fpp){
                fpsMode1();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)){
            importX.get(7).translateObject(0f, 0.0f, -0.1f);
            if(tpp){
                tpsMode1();
            }
            if(fpp){
                fpsMode1();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)){
            importX.get(7).translateObject(0f, 0.0f, 0.1f);
            if(tpp){
                tpsMode1();
            }
            if(fpp){
                fpsMode1();
            }
        }
        // TPS Camera wall e
        if (window.isKeyPressed(GLFW_KEY_F)){
            importX.get(6).translateObject(-0.1f, 0.0f, 0.0f);
            if(tpp){
                tpsMode2();
            }
            if(fpp){
                fpsMode2();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_H)){
            importX.get(6).translateObject(0.1f, 0.0f, 0.0f);
            if(tpp){
                tpsMode2();
            }
            if(fpp){
                fpsMode2();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_T)){
            importX.get(6).translateObject(0f, 0.0f, -0.1f);
            if(tpp){
                tpsMode2();
            }
            if(fpp){
                fpsMode2();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_G)){
            importX.get(6).translateObject(0f, 0.0f, 0.1f);
            if(tpp){
                tpsMode2();
            }
            if(fpp){
                fpsMode2();
            }
        }

    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(255/255f,255/255f,242/255f, 1.0f);
            GL.createCapabilities();
            glClearDepth(1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            input();


            for (Object obj3D : importX) {
                obj3D.draw(camera, projection);
            }

            System.out.println("X"+camera.getPosition().get(0));
            System.out.println("Y"+camera.getPosition().get(1));
            System.out.println("Z"+camera.getPosition().get(2));


            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }


    public static void main (String[]args){
        new DummyTest().run();
    }
}


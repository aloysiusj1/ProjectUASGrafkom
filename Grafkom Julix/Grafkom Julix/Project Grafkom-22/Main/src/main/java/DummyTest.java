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
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    ArrayList<Object> importX = new ArrayList<Object>();
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
            m = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/kepalaeva.obj"));
            m1 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/mataeva.obj"));
            m2 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/untitled.obj"));
            m3 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/lorong.obj"));
            m4 = ObjLoader.loadModel(new File("Grafkom Julix/Grafkom Julix/Project Grafkom-22/Main/src/blenderAssets/mukahitameve.obj"));


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        importX.add(new Sphere(
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
        importX.get(0).scaleObject(0.8f,0.8f,0.8f);
        importX.get(0).translateObject(2f,2.5f,0f);
        importX.add(new Sphere(
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
        importX.get(1).scaleObject(0.8f,0.8f,0.85f);
        importX.get(1).translateObject(2f,2.5f,0f);
        importX.add(new Sphere(
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
        importX.get(2).translateObject(2.88f,2.05f,0.02f);
        importX.get(2).scaleObject(0.9f,0.9f,0.9f);
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
        importX.get(3).translateObject(2f,0.2f,0f);

        importX.add(new Sphere(
                shaderModuleDataList,
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                0.0,
                new ArrayList<>(List.of(2f, 2f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15,
                30,
                m3));



    }

    public void input() {

        if (window.isKeyPressed(GLFW_KEY_I)) {
            camera.moveForward(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            camera.moveBackwards(0.12f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
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
    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(255/255f,229/225f,204/255f, 1.0f);
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


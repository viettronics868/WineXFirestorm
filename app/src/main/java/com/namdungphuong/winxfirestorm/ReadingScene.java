package com.namdungphuong.winxfirestorm;

/**
 * Created by khidot on 3/5/2016.
 */

import android.content.Intent;

import com.namdungphuong.winxfirestorm.SceneManager.SceneType;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

public class ReadingScene extends BaseScene implements IOnMenuItemClickListener
{
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------

    private MenuScene readingChildScene;

    private final int MENU_INTRO = 0;
    private final int MENU_README = 1;
    private final int MENU_TRAILER = 2;
    private static int CAMERA_WIDTH=1280;
    private static int CAMERA_HEIGHT=720;

    //---------------------------------------------
    // METHODS FROM SUPERCLASS
    //---------------------------------------------

    @Override
    public void createScene()
    {
        createBackground();
        createMenuChildScene();
    }

    @Override
    public void onBackKeyPressed()
    {
        //System.exit(0);
        disposeScene();
        SceneManager.getInstance().loadMenuScene(engine);
    }

    @Override
    public SceneType getSceneType()
    {
        return SceneType.SCENE_READING;
    }


    @Override
    public void disposeScene()
    {
        // TODO Auto-generated method stub
    }

    public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
    {
        switch(pMenuItem.getID())
        {
            case MENU_INTRO:
                //Load PICTURE!
                final Intent displayIntent = new Intent(this.activity, DisplayActivity.class);
                this.activity.startActivity(displayIntent);
                return true;
            case MENU_README:

                final Intent readmeIntent = new Intent(this.activity, ReadmeActivity.class);
                this.activity.startActivity(readmeIntent);
                return true;
            case MENU_TRAILER:

                final Intent controlsIntent = new Intent(this.activity, TrailerActivity.class);
                this.activity.startActivity(controlsIntent);

                return true;
            default:
                return false;
        }
    }

    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------

    private void createBackground()
    {
        attachChild(new Sprite(CAMERA_WIDTH/2, CAMERA_HEIGHT/2, resourcesManager.read_background_region, vbom)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        });
    }

    private void createMenuChildScene()
    {
        readingChildScene = new MenuScene(camera);
        readingChildScene.setPosition(0, 0);

        final IMenuItem introItem =new ScaleMenuItemDecorator(
                        new SpriteMenuItem(
                                MENU_INTRO,
                                resourcesManager.intro_region,
                                vbom),
                        1.2f, 1);
        final IMenuItem readItem =new ScaleMenuItemDecorator(
                        new SpriteMenuItem(
                                MENU_README,
                                resourcesManager.read_region,
                                vbom),
                        1.2f, 1);
        final IMenuItem trailerItem =new ScaleMenuItemDecorator(
                        new SpriteMenuItem(
                                MENU_TRAILER,
                                resourcesManager.trailer_region,
                                vbom),
                        1.2f, 1);

        readingChildScene.addMenuItem(introItem);
        readingChildScene.addMenuItem(readItem);
        readingChildScene.addMenuItem(trailerItem);

        readingChildScene.buildAnimations();
        readingChildScene.setBackgroundEnabled(false);

        introItem.setPosition(CAMERA_WIDTH / 4 - 30, (CAMERA_HEIGHT) /4-20);
        readItem.setPosition(CAMERA_WIDTH / 4 + 80, CAMERA_HEIGHT / 2);
        trailerItem.setPosition(CAMERA_WIDTH/4-150, (CAMERA_HEIGHT)*3/4+80);

        readingChildScene.setOnMenuItemClickListener(this);

        setChildScene(readingChildScene);
    }
}
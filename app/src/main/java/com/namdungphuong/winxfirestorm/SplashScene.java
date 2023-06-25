package com.namdungphuong.winxfirestorm;

/**
 * Created by khidot on 1/12/2016.
 */

import android.opengl.GLES20;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.util.modifier.IModifier;


import com.namdungphuong.winxfirestorm.SceneManager.SceneType;

public class SplashScene extends BaseScene
{
    private Sprite splash;

    @Override
    public void createScene()
    {
        splash = new Sprite(0, 0, resourcesManager.splash_region, vbom)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };

        splash.setScale(1.0f);
        splash.setPosition(640, 360);
//**********************my code
        splash.setBlendFunction(
                GLES20.GL_SRC_ALPHA,
                GLES20.GL_ONE_MINUS_SRC_ALPHA);
        splash.setAlpha(0);

        attachChild(splash);//original code

        splash.registerEntityModifier(new SequenceEntityModifier(
                new DelayModifier(1f),
                new AlphaModifier(1f,0f,1f),
                new DelayModifier(1f),
                new AlphaModifier(1f, 1f, 0f, new IEntityModifierListener() {
                    @Override
                    public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {

                    }

                    @Override
                    public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
                        SceneManager.getInstance().createMenuScene();
                    }
                })
        ));
    }

    @Override
    public void onBackKeyPressed()
    {
        return;
    }

    @Override
    public SceneType getSceneType()
    {
        return SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene()
    {
        splash.detachSelf();
        splash.dispose();
        this.detachSelf();
        this.dispose();
    }
}
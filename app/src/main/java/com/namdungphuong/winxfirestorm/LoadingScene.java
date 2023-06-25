package com.namdungphuong.winxfirestorm;

/**
 * Created by khidot on 1/12/2016.
 */

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;


import com.namdungphuong.winxfirestorm.SceneManager.SceneType;

public class LoadingScene extends BaseScene
{
    @Override
    public void createScene()
    {
        setBackground(new Background(Color.BLUE));
        attachChild(new Text(640, 360, resourcesManager.font, "Loading...", vbom));
    }

    @Override
    public void onBackKeyPressed()
    {
        return;
    }

    @Override
    public SceneType getSceneType()
    {
        return SceneType.SCENE_LOADING;
    }

    @Override
    public void disposeScene()
    {

    }
}
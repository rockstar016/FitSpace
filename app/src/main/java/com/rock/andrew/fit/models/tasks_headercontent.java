package com.rock.andrew.fit.models;

/**
 * Created by RockStar-0116 on 2016.07.20.
 */
public class tasks_headercontent extends base_tasks{
    private String ImagePath, TitleTask;
    public tasks_headercontent() {
        super.setType(0);
    }
    public String getImagePath() {
        return ImagePath;
    }
    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getTitleTask() {
        return TitleTask;
    }

    public void setTitleTask(String titleTask) {
        TitleTask = titleTask;
    }
}

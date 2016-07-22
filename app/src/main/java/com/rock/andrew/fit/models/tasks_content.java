package com.rock.andrew.fit.models;

/**
 * Created by RockStar-0116 on 2016.07.20.
 */
public class tasks_content extends base_tasks{

    private String content;
    private int unit_type;//0:day, 1:hour
    private int unit_amount;

    public tasks_content() {
        super.setType(1);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(int unit_type) {
        this.unit_type = unit_type;
    }

    public int getUnit_amount() {
        return unit_amount;
    }

    public void setUnit_amount(int unit_amount) {
        this.unit_amount = unit_amount;
    }
}

package org.zju.vipa.aix.web.container.api.vo;

import org.zju.vipa.aix.container.common.db.entity.aix.FinishedTask;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * @Date: 2021/1/24 13:48
 * @Author: EricMa
 * @Description: :
 */
public class FinishedTaskVO implements Serializable {
    private int id;

    /**执行该任务的设备id**/
    private int deviceId;

    /**执行任务的id,一个任务可能被多次执行**/
    private String taskId;

    /**任务状态(SUCCESS,FAILED,ENV_FAILED,CANCEL)**/
    private String status;

    /**开始时间**/
    private String begin;

    /**结束时间**/
    private String end;

    /**持续时长,单位分钟**/
    private int durationMin;

    /**任务日志,json数组**/
    private String logs;

    public FinishedTaskVO() {
    }

    public FinishedTaskVO(FinishedTask finishedTask) {
        this.id=finishedTask.getId();
        this.deviceId = finishedTask.getDeviceId();
        this.taskId = String.valueOf(finishedTask.getTaskId());
        this.status = finishedTask.getStatus();
        this.begin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(finishedTask.getBegin());
        this.end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(finishedTask.getEnd());
        this.durationMin = finishedTask.getDurationMin();

        this.logs=finishedTask.getLogs();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }


    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }
}

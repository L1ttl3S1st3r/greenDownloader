package model;

import java.net.URL;
import java.util.Collection;
import java.time.LocalDateTime;
import java.nio.file.*;

/*
* Task container. Main content of TasksQueue, TasksDataBaseConnection and ect
* **/
public class DownloadTask {
    private final int _id;
    private final URL[] _urls;
    private final Path[] _paths;
    private final LocalDateTime _time;
    private final boolean _isScheduled;
    private double _downloadProgress = 0;

    public int getId() {return _id;}

    public URL[] getUrls() {return _urls;}
    
    public Path[] getPaths() {return _paths;}

    public LocalDateTime getTime() {return _time;}

    public boolean isScheduled() {return _isScheduled;}

    public double getDownloadingProgress() {return _downloadProgress;}

    public void setDownloadingProgress(double value) throws IllegalArgumentException {
        if (value > 100 || value < 0)
            throw  new IllegalArgumentException("Expected value in range (0, 100), got " + Double.toString(value));

        _downloadProgress = value;
    }


    /**
     * @param id unique id for task
     * @param urls array of urls of files, which will be downloaded
     * @param paths array of paths of files**/
    public DownloadTask(int id, URL[] urls, Path[] paths) {
        _id = id;
        _urls = urls;
        _paths = paths;
        _time = null;
        _isScheduled = false;
    }

    /**
     * @param id unique id for task
     * @param urls array of urls, which will be downloaded
     * @param paths array of paths of files
     * @param time the time for which the task was scheduled**/
    public DownloadTask(int id, URL[] urls, Path[] paths, LocalDateTime time) {
        _id = id;
        _urls = urls;
        _paths = paths;
        _time = time;
        _isScheduled = true;
    }
}

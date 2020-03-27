package example.ru.dao;

import example.ru.model.Track;

public interface TrackRepository {

    void addTrack(Track track);
    void updateTrack(Track track);
}

package example.ru.dao;

import example.ru.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Objects;

@Repository
public class TrackRepositoryImpl implements TrackRepository {

    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void addTrack(Track track) {
        em.merge(track);
    }

    @Override
    @Transactional
    public void updateTrack(Track track) {
        Track track_inner = em.find(Track.class, track.getId());
        track_inner.update(track);
        em.persist(track_inner);
    }
}

package example.ru.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.ru.dao.TrackRepository;
import example.ru.model.Car;
import example.ru.model.Length;
import example.ru.model.MaxSpeed;
import example.ru.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CreateEntity {

    private TrackRepository repository;

    @Autowired
    public void setRepository(TrackRepository repository) {
        this.repository = repository;
    }

    public List<Track> create(String json) {
        List<Track> trackList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode tree = objectMapper.readTree(json);
            Iterator<JsonNode> tracks = tree.findValue("tracks").elements();

            while(tracks.hasNext()) {
                JsonNode next = tracks.next();
                Track track = new Track();
                track.setId(next.findValue("id").asInt());
                track.setName(next.findValue("name").toString());
                track.setDescription(next.findValue("description").toString());
                Length length = new Length();
                System.out.println(next.findValue("length").toString());
                length.setUnit(next.findPath("length.unit").toString());
                length.setValue(next.findPath("$.length.value").doubleValue());
                track.setLength(length);
                Iterator<JsonNode> cars = next.findValue("cars").iterator();
                while(cars.hasNext()) {
                    JsonNode carNode = cars.next();
                    MaxSpeed speed = new MaxSpeed();
                    speed.setUnit(carNode.findPath("max-speed.unit").toString());
                    speed.setValue(carNode.findPath("max-speed.value").doubleValue());
                    Car car = new Car();
                    car.setAi(carNode.findValue("ai").toString());
                    car.setCode(carNode.findValue("code").toString());
                    car.setId(carNode.findValue("id").asInt());
                    car.setTransmission(carNode.findValue("transmission").toString());
                    car.setMaxSpeed(speed);
                    track.addCar(car);
                }
                trackList.add(track);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trackList;
    }

    public void add(List<Track> tracks) {
        for (Track track : tracks) {
            repository.addTrack(track);
        }
    }

    public void update(List<Track> tracks) {
        for (Track track : tracks) {
            repository.updateTrack(track);
        }
    }
}

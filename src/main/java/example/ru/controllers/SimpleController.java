package example.ru.controllers;

import example.ru.model.Track;
import example.ru.services.CreateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tracks")
public class SimpleController {

    private CreateEntity createEntityService;

    @Autowired
    public void setCreateEntityService(CreateEntity createEntityService) {
        this.createEntityService = createEntityService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody String json) {
        List<Track> tracks = createEntityService.create(json);
        createEntityService.add(tracks);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody String json) {
        List<Track> tracks = createEntityService.create(json);
        createEntityService.update(tracks);
    }
}

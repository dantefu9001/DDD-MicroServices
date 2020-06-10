package domain.contexts.panoramacontext.panorama;

import domain.contexts.panoramacontext.scene.Scene;
import domain.core.concepts.AggregateRoot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Panorama implements AggregateRoot {

    private String id;
    private String name;
    private String createTime;
    private String updateTime;
    private List<Scene> scenes;
    private boolean isDeleted = false;

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Panorama(String name, List<Scene> scenes) {
        this.name = name;
        this.scenes = scenes;
    }

    private static Panorama createPanorama(String name, List<Scene> scenes) {
        Panorama panorama = new Panorama(name, scenes);
        panorama.id = UUID.randomUUID().toString();
        panorama.createTime = LocalDate.now().format(formatter);
        panorama.updateTime = panorama.createTime;
        return panorama;
    }

    void editPanorama(String name, List<Scene> scenes) {
        this.name = name;
        this.scenes = scenes;
        this.updateTime = LocalDate.now().format(formatter);
    }

    boolean deletePanorama() {
        this.updateTime = LocalDate.now().format(formatter);
        this.scenes.forEach(Scene::deleteScene);
        this.isDeleted = true;
        return true;
    }

    static class PanoramaFactory{
        static Panorama createPanorama(String name, List<Scene> scenes){
            return Panorama.createPanorama(name,scenes);
        }
    }
}

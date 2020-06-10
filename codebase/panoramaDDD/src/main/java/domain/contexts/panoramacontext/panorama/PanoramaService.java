package domain.contexts.panoramacontext.panorama;

import domain.contexts.panoramacontext.scene.Scene;
import domain.core.concepts.Service;

import java.util.List;

public class PanoramaService implements Service {

    private PanoramaRepository panoramaRepository;

    public Panorama createPanorama(String name, List<Scene> scenes) {
        Panorama panorama = Panorama.PanoramaFactory.createPanorama(name, scenes);
        panoramaRepository.save(panorama);
        return panorama;
    }

    public void editPanorama(String id, String name, List<Scene> scenes) {
        Panorama panorama = panoramaRepository.findById(id);
        panorama.editPanorama(name, scenes);
    }

    public Panorama getPanorama(String id) {
        return panoramaRepository.findById(id);
    }

    public boolean deletePanorama(String id) {
        try {
            Panorama panorama = panoramaRepository.findById(id);
            panorama.deletePanorama();
            panoramaRepository.save(panorama);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

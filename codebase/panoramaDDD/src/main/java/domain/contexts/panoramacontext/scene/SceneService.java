package domain.contexts.panoramacontext.scene;

import domain.contexts.panoramacontext.photo.Photo;
import domain.core.common.TypeEnum;
import domain.core.concepts.Service;

import java.util.List;

public class SceneService implements Service {
    private SceneRepository sceneRepository;

    public Scene createScene(String name, TypeEnum type, boolean isDefault, List<Photo> photos) {
        Scene scene = Scene.SceneFactory.createScene(name, type, isDefault, photos);
        sceneRepository.save(scene);
        return scene;
    }

    public Scene getScene(String id) {
        return sceneRepository.findById(id);
    }

    public void editScene(String id, String name, TypeEnum type, boolean isDefault, List<Photo> photos) {
        Scene scene = sceneRepository.findById(id);
        scene.editScene(name, type, isDefault, photos);
        sceneRepository.save(scene);
    }

    public void deleteScene(String id) {
        Scene scene = sceneRepository.findById(id);
        scene.deleteScene();
        sceneRepository.save(scene);
    }
}

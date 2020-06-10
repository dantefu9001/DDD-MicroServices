package domain.contexts.panoramacontext.scene;

import domain.contexts.panoramacontext.photo.Photo;
import domain.core.common.TypeEnum;
import domain.core.concepts.Entity;

import java.util.List;
import java.util.UUID;

public class Scene implements Entity {

    private String id;
    private String name;
    private boolean isDefault;
    private boolean isDeleted = false;
    private TypeEnum type;
    private List<Photo> photoList;

    private Scene (String name, TypeEnum type, List<Photo> PhotoList){
        this.name = name;
        this.type = type;
        this.photoList = PhotoList;
    }

    private static Scene createScene(String name, TypeEnum type, boolean isDefault, List<Photo> photos) {
        Scene scene = new Scene(name, type, photos);
        scene.id = UUID.randomUUID().toString();
        scene.isDefault = isDefault;
        return scene;
    }

    void editScene(String name, TypeEnum type, boolean isDefault, List<Photo> photos) {
        this.name = name;
        this.type = type;
        this.isDefault = isDefault;
        this.photoList = photos;
    }

    public boolean deleteScene(){
        this.isDeleted = true;
        this.photoList.forEach(Photo::deletePhoto);
        return true;
    }

    static class SceneFactory{
        static Scene createScene(String name, TypeEnum type, boolean isDefault, List<Photo> photos) {
            return Scene.createScene(name, type, isDefault, photos);
        }
    }
}

package domain.contexts.panoramacontext.photo;

import domain.core.concepts.Entity;

import java.util.UUID;

public class Photo implements Entity {

    private String id;
    private Object content;
    private boolean isDefault;
    private boolean isDeleted = false;

    private Photo(Object content, boolean isDefault) {
        this.content = content;
        this.isDefault = isDefault;
    }

    private static Photo createPhoto(Object content, boolean isDefault) {
        Photo photo = new Photo(content, isDefault);
        photo.id = UUID.randomUUID().toString();
        return photo;
    }

    public boolean deletePhoto(){
        this.isDeleted = true;
        return true;
    }

    static class PhotoFactory{
        static Photo createPhoto(Object content, boolean isDefault) {
            return Photo.createPhoto(content, isDefault);
        }
    }
}

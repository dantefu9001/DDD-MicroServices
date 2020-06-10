package domain.contexts.panoramacontext.photo;

import domain.core.concepts.Service;

public class PhotoService implements Service {

    private PhotoRepository photoRepository;

    public Photo createPhoto(Object content, boolean isDefault) {
        Photo photo = Photo.PhotoFactory.createPhoto(content, isDefault);
        photoRepository.save(photo);
        return photo;
    }

    public Photo getPhoto(String id) {
        return photoRepository.findById(id);
    }

    public void deletePhoto(String id){
        Photo photo = photoRepository.findById(id);
        photo.deletePhoto();
        photoRepository.save(photo);
    }

}

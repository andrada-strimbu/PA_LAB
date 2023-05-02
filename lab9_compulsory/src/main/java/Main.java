import entity.Albums;
import repository.AlbumsRepository;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        AlbumsRepository repository=new AlbumsRepository();
        Albums album1=new Albums(501,2016,"Anti","Rihanna","pop");
        repository.create(album1);
        Albums album2=repository.findById(1L);
        System.out.println(album2.getTitle());

    }
}
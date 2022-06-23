package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Key extends ParentObject {
    public Key(){
        name = "Key";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/obj/key.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

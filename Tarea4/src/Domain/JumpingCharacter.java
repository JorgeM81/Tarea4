package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {
     
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping"+imgNum+".png")));
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int y2=365;
        boolean up=true;
        while (true) {
            try {
                if(this.imgNum>2){
                    this.imgNum=-1;
                }else{
                    if(up){
                        y2=y2-1;
                        this.imgNum=0;
                        setImage(new Image(new FileInputStream("src/Assets/Jumping"+imgNum+".png")));
                        if(y2==270){
                            up=false;
                        }
                    }else{
                        y2=y2+1;
                        this.imgNum=1;
                        setImage(new Image(new FileInputStream("src/Assets/Jumping"+imgNum+".png")));
                        if(y2==365){
                            up=true;
                            this.imgNum=2;
                            setImage(new Image(new FileInputStream("src/Assets/Jumping"+imgNum+".png")));
                            Thread.sleep(800);
                        }
                    }
                    this.setY(y2);
                    Thread.sleep(4);
                }
            } 
            catch (InterruptedException ex) {} catch (FileNotFoundException ex) { 
                Logger.getLogger(JumpingCharacter.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
}

package daos;

import javabeans.ItemImage;
import java.util.ArrayList;


/**
 * @author Fadi Findakly
 */


public interface ItemImagesDAO {
        public ArrayList<ItemImage> getAllImages();
        public void createItemImage(ItemImage image);
        public void deleteItemImage();
        public void updateItemImage();
        public String getItemImage();
}

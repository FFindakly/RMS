package javabeans;

/**
 * @author Fadi Findakly
 */

public class ItemImage {

    private int imageId;
    private String imageName;


    //Create constructors
    public ItemImage(int imageId, String imageName) {
        this.imageId = imageId;
        this.imageName = imageName;
    }

    public ItemImage(String imageName) {
        this.imageName = imageName;
    }


    //Create getters and setters
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}

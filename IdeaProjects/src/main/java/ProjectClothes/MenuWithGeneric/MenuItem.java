package ProjectClothes.MenuWithGeneric;

public interface MenuItem  <T>{
    int getOrder();

    String getTitle();

    void execute();
}



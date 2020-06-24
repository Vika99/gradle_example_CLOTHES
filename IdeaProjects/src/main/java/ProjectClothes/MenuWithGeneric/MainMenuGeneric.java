package ProjectClothes.MenuWithGeneric;

import ProjectClothes.Clothes;
import ProjectClothes.ClothesFactory;
import ProjectClothes.Factory;
import ProjectClothes.NetWork.NetworkClientContainer;
import ProjectClothes.NotSimpleMenu.Container;

import java.io.IOException;

public class MainMenuGeneric  {
    public static void main(String[] args) throws IOException {
    Factory<Clothes<?>> factory= new ClothesFactory();
    Container<Clothes<?>> container = new NetworkClientContainer<Clothes<?>>("localhost",8080);


    // Создаем верхнеуровн. меню!
    MenuItem<Clothes<?>>[] items= new MenuItem[3];
    items[0]=  new AddMenuItem<Clothes<?>>(container, factory);
    items[1] = new DeleteMenuItem<Clothes<?>>(container);

    items[2] = new PrintAll<Clothes<?>>(container);
    TopLevelMenu<Clothes<?>> clothesMenu = new TopLevelMenu<>(items, "clothes menu", 0);
    clothesMenu.execute();
}
}

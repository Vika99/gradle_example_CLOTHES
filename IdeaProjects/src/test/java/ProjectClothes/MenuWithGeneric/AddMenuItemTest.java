package ProjectClothes.MenuWithGeneric;

import ProjectClothes.Factory;
import ProjectClothes.NotSimpleMenu.Container;
import ProjectClothes.NotSimpleMenu.LocalContainer;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AddMenuItemTest {


    private Container<String> container = new LocalContainer<>();
   // private Factory<String> factory = ()->"hello"; ----it's a stub object
    private Factory factory= mock(Factory.class);
    private AddMenuItem<String> testObject = new AddMenuItem<>(container, factory);

    @BeforeEach
    void init(){
     when(factory.create()).thenReturn("hello");
    }

    @Test
    void testGetOrder(){
        int  order = testObject.getOrder();
        assertEquals(1,order);
    }

    @Test
    void testGetTitle(){
        String title = testObject.getTitle();
        assertEquals("Add element", title);
    }
    @Test

    void TestExecute(){
        testObject.execute();

        //постараемся убедиться,что там есть элемент:
        String values = container.getAll().iterator().next();
        //потом смотрим,что размер контейнера стал единица
        assertEquals(1, container.size());
        //и убеждаемся, что конкретно hello сложилось к нам в фабрику
        assertEquals("hello", values);

        verify(factory,times(1)).create();
        verifyNoMoreInteractions(factory);
    }

}
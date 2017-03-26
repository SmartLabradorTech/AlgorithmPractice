package play;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created on 2/1/17.
 */
public class FieldRelated {

    public String first;
    private String second;

    public static void main(String[] args) {

        Class aClass = FieldRelated.class;

        Field[] fields = aClass.getFields();

        int a = 1;

        try {
//            Field modifiersField = Field.class.getDeclaredField("modifiers");

            Field field = fields[0];


            int modifiers = field.getModifiers();


            int b = 1;


            Field modifiersField = Field.class.getDeclaredField("modifiers");

            modifiersField.setAccessible(true);

            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            System.out.println(Modifier.FINAL);

            int c = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

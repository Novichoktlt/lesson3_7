package lesson3_7.online;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainTest {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        start(ClassTest.class);

    }



    public static void start(Class c) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new  ArrayList();
        for (Method m: methods){
            if (m.isAnnotationPresent(Test.class)){
                int priority = m.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) throw new RuntimeException("Exception priority");
                list.add(m);
            }
        }
        list.sort((m1, m2) -> m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority());

        for (Method m: methods){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if(list.get(0).isAnnotationPresent(BeforeSuite.class)) throw new RuntimeException("Exception BeforeSuite");
                list.add(0, m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                if(list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class)) throw new RuntimeException("Exception AfterSuite");
                list.add(m);


            }
        }
        for (Method m: list)
            m.invoke(null);



    }
}

package reflect;

public class Factory {

    public <T> T create(Class clazz) {
        Object object = null;
        try {
            object = Class.forName(clazz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) object;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Object o = factory.create(Object.class);
    }
}

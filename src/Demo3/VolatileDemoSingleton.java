package Demo3;

/**
 * Demo : Volatile demo : 单例模式的双重检测
 * @author  JaneW.
 *
 */

public class VolatileDemoSingleton {

    private volatile static VolatileDemoSingleton instance = null;

    private VolatileDemoSingleton() {

    }

    public static VolatileDemoSingleton getInstance() {

        if ( instance == null ) {

            synchronized (VolatileDemoSingleton.class) {
                if (instance == null )
                    instance = new VolatileDemoSingleton();
            }
        }

        return instance;
    }

}

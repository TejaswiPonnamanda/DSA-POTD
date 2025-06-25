package lld.design.designPatterns;

public class SingleTon {
    /*
      steps to create singleton DP
      1.private constructor : prevents external Instantiation
      2.private static variable : holds the single instance of the class
      3.public static method : provides global access to the instance
     */
    private static SingleTon instance;
    private SingleTon()
    {

    }
    public static SingleTon getInstance()
    {
        if(instance==null)
        {
            instance=new SingleTon();
        }
        return instance;
    }

    public static SingleTon getInstanceForMultiThreadedEnv()
    {
        if(instance==null)
        {
            synchronized (SingleTon.class)
            {
                if(instance==null)
                {
                    instance=new SingleTon();
                }
            }

        }
        return instance;
    }

    public void connect()
    {
        System.out.println(" connected 1");
    }

    public static void main(String[] args) {
       // SingleTon db=new SingleTon()
        SingleTon db1=SingleTon.getInstance() ;
        db1.connect();

        SingleTon db2=SingleTon.getInstance() ;
        db2.connect();

        SingleTon db3=SingleTon.getInstanceForMultiThreadedEnv() ;
        db3.connect();

        SingleTon db4=SingleTon.getInstanceForMultiThreadedEnv() ;
        db4.connect();

    }
}

import com.isoft.bean.BoilThread;
import com.isoft.bean.WashThread;
import org.junit.Test;

public class TestThread {
    public static void main(String[] args) {
        BoilThread boilThread;//新建状态
        boilThread=new BoilThread();//就绪状态
        WashThread washThread=new WashThread();
        Thread washThread1=new Thread(washThread);
        boilThread.start();//运行状态
        washThread1.start();


    }
}

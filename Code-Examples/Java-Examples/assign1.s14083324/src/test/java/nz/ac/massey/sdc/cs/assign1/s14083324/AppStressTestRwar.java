package nz.ac.massey.sdc.cs.assign1.s14083324;

import java.io.IOException;

public class AppStressTestRwar {

	private static AppStressTest st;
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		int maxSize = 100;
		int logAmount = 10000;
		int waitTime = 10000;
		
		
		st = new AppStressTest();
		st.Sleep(waitTime);
		st.stressMemAppenderWithLinkedList(maxSize,logAmount);
		st.Sleep(waitTime);
		st.stressMemAppenderArrayList(maxSize,logAmount);
		st.Sleep(waitTime);
		st.stressConsoleAppenderSimpleLayout(maxSize,logAmount);
		st.Sleep(waitTime);
		st.stressConsoleAppenderMVELLayout(logAmount);
		st.Sleep(waitTime);
		st.stressFileAppenderSimpleLayout(logAmount);
		st.Sleep(waitTime);
		st.stressFileAppenderMVELLayout(logAmount);

	}

}

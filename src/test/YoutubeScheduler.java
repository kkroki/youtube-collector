package test;

public class YoutubeScheduler {
	public static void main(String[] args) {
		Thread th = new Thread() {
			@Override
			public void run() {
				int videoIndex = 0;
				try {
					while(true) {
						if (videoIndex > 20) {
							break;
						}
						Thread.sleep(3000);
						System.out.println(videoIndex++);						
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		th.start();
	}
}

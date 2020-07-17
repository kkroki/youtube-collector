package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class YoutubeDownloader {
	public static void downloadById(String id) {
		File f = new File(id + ".mp3");
		if (!f.exists()) {
			System.out.println("skip");
		} else {
			System.out.println("download!!!!!");
			ProcessBuilder pb = null;
			BufferedReader br = null;
			try {
				pb = new ProcessBuilder();
				pb.directory(new File("C:\\JSP\\commaaaa\\WebContent\\top100\\entries"));
				pb.command("youtube-dl.exe", id, "dir");
				Process process = pb.start();
				br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String ln = null;
				while ((ln = br.readLine()) != null) {
					System.out.println(ln);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static void main(String[] args) {
		downloadById("");
	}
}

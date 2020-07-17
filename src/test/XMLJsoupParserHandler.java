package test;

import java.io.IOException;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class XMLJsoupParserHandler {
	public static void main(String[] args) {
		Document doc = null;

		try {
		
			doc = Jsoup.connect(
					"https://www.youtube.com/feeds/videos.xml?playlist_id=RDCLAK5uy_l7wbVbkC-dG5fyEQQsBfjm_z3dLAhYyvo")
					.postDataCharset("utf-8").get();

			getYoutubeTop100(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getYoutubeTop100(Document doc) {
		Elements elements = doc.select("entry>id");
		// mgr new
		TopMgr
		for (int i = 0; i < elements.size() && i < 2; i++) {
			String videoId = elements.get(i).text().replace("yt:video:", "");

			System.out.println(videoId);
			System.out.println("DownloadStart");

			YoutubeDownloader.downloadById(videoId);
			
		// mgr insert
		}
		return elements.html();

	}
}
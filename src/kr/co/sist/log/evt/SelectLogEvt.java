package kr.co.sist.log.evt;

import java.awt.FileDialog;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.co.sist.log.view.Result;
import kr.co.sist.log.view.SelectLog;

public class SelectLogEvt implements ActionListener {

	// 1~6�쓣 泥섎━�븳 �궡�슜�쓣 instance 蹂��닔�뿉 ���옣�빐�빞 �븿
	private SelectLog sl;
	private String filePath;
	private Map<String, Integer> mapKey;
	private Map<String, Integer> mapBrowser;
	private Map<String, Integer> mapHour;
	private int code200, code404, code403;
	private int requestNum;
	private int start, end;
	private String code403Share;
	private Map<String, String> mapBrowserShare;
	private String mostFrequentHour;
	private String mostFrequentKey;
	private boolean reportFlag;

	public SelectLogEvt(SelectLog sl) {
		this.sl = sl;
		mapKey = new HashMap<String, Integer>();
		mapBrowser = new HashMap<String, Integer>();
		mapHour = new HashMap<String, Integer>();
		mapBrowserShare = new HashMap<String, String>();
		reportFlag = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sl.getJbView()) {

			selectLog();

			try {
				readLog();

				// readLog로 읽어들인 log의 내용을 가공, instance변수에 저장
				calMostFrequentKey();
				calBrowserShare();
				calCode403Share();

				// 결과창
				new Result(this);
				System.out.println("결과창 생성자 호출");

			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}

		// jbView가 한번 이상 눌렸다면 JOptionPane.showMessageDialog에 붙여 결과 출력
		if (e.getSource() == sl.getJbReport()) {
			if (reportFlag == true) {
				// "report 출력"을 Component로 대체해야 함, Component를 반환하는 method 만들 것

				// 파일 출력 FileDialog 구현
				try {
					mkLogReport();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(sl, "Log View瑜� 癒쇱� �닔�뻾�븯�뿬 二쇱꽭�슂.");
			}
		}

		if (e.getSource() == sl.getJbLineView()) {
			// �떆�옉,�걹 �씪�씤�씠 �엯�젰�릱�쓣 �븣 �빐�떦 �씪�씤 �닔瑜� 媛��졇�삩�떎
			start = Integer.parseInt(sl.getJtStartLine().getText());
			end = Integer.parseInt(sl.getJtEndLine().getText());

			selectLog();

			System.out.println(start + " " + end);
			try {
				readLog();
				calMostFrequentKey();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void mkLogReport() throws IOException {
<<<<<<< HEAD
		// report, FileDialog SAVE, 출력하는 method

=======

		// report, FileDialog SAVE, 異쒕젰�븯�뒗 method
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
	}

	public void calMostFrequentKey() {
		// 媛��옣 鍮덈룄�닔 �넂�� key(mostFrequentKey) 援ы븯�뒗 method
	}

	public void calMostFrequentHour() {
<<<<<<< HEAD
		// 가장 빈도수 높은 시간을 구하는 method
	}

=======
		// 媛��옣 鍮덈룄�닔 �넂�� �떆媛�(mostFrequentHour) 援ы븯�뒗 method 
	}
	
/////////////////////12.22 �꽑�쓽 肄붾뱶 異붽� (釉뚮씪�슦���쓽 鍮꾩쑉援ы빐�꽌 諛섑솚) �떆�옉//////////////////////////////
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
	public void calBrowserShare() {
		ArrayList<String> al = new ArrayList<String>();
		Set<String> set = mapBrowser.keySet();
		Iterator<String> ita = set.iterator();
		Iterator<String> ita2 = set.iterator();

//		System.out.println("紐⑤뱺�꽆踰�: " + requestNum);
//		System.out.println(mapBrowser);
		for (int i = 0; i < browser.length; i++) {
			mapBrowserShare.put(ita2.next(), String.format("%4.2f", ((mapBrowser.get(ita.next()) / (double) requestNum) * 100)));
		}
//		System.out.println(al);
//		System.out.println(mapBrowserShare);
	}
<<<<<<< HEAD
=======
/////////////////////12.22 �꽑�쓽 肄붾뱶 異붽� (釉뚮씪�슦���쓽 鍮꾩쑉援ы빐�꽌 諛섑솚) �걹//////////////////////////////

>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b

	public void calCode403Share() {
		code403Share = String.format("%3.2f", (code403 / (double) requestNum) * 100);
	}

	public void selectLog() {
<<<<<<< HEAD
		// 읽어들인 log파일의 경로를 저장하는 method
		FileDialog fd = new FileDialog(sl, "log 파일 선택", FileDialog.LOAD);
=======
		// �씫�뼱�뱾�씤 log�뙆�씪�쓽 寃쎈줈瑜� ���옣�븯�뒗 method
		FileDialog fd = new FileDialog(sl, "log 占쎈솁占쎌뵬 占쎄퐨占쎄문", FileDialog.LOAD);
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
		fd.setVisible(true);

		String dirPath = fd.getDirectory();
		String fName = fd.getFile();
		filePath = dirPath + fName;
	}

	public void readLog() throws IOException, FileNotFoundException {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));

			String temp = "";
			while ((temp = br.readLine()) != null) {

				requestNum++;
				// �꽑�깮�맂 �뙆�씪�쓽 �궡�슜�쓣 �븳 以꾩뵫 �씫�뼱�뱾�엫
				// �씫�뼱�뱾�씠�뒗 �궡�슜�쓣 泥섎━�븯�뒗嫄� �뵲濡� method 留뚮뱾�뼱�꽌 泥섎━�븷 寃�
				if (start == 0 && end == 0) {
					countKey(temp);
					countBrowser(temp);
					countHttpStatusCode(temp);
					countRequestHour(temp);

				} else if (requestNum >= start && requestNum <= end) {
					countKey(temp);

				}

			}

			reportFlag = true;
		} finally {
			if (br != null)
				br.close();
		}
	}

<<<<<<< HEAD
	/////////////////////////// 12-22-2018 키값 카운트 메소드 구현(건하)
	/////////////////////////// ///////////////////////////////
	public void countKey(String temp) {
		// 1. 최다 사용 Key의 이름과 횟수를 구하는 method
//		String[] str=null;
//		Integer[] intValue=null;
		Set<String>setKey=new HashSet<>();

		if (temp.contains("key")) {
//			for(int i=0;i<requestNum;i++) {
			String str = temp.substring(temp.indexOf("=") + 1, temp.indexOf("&")); // 반환형이 int형이라서 반환형을 맞춰줘야 한다.
			
			for(int i=0; i<str.length(); i++) {
				setKey.add(String.valueOf(str));
			}
			System.out.println(setKey); // 키값 구하기
			
			
//		for(int i=0; i<str.length(); i++) {
//			int ct=0;
//			mapKey.put(String.valueOf(str), ct++);
//		}//end if
//		System.out.println(mapKey);

//			for(int i=0; i<str.length(); i++) {
//				mapKey.put(String.valueOf(i),i);	
//						}//end for
//			System.out.println(mapKey);
	
		
			
			
			
		}// end if

		
		
	// System.out.println(str);
	// 구한 키값으로 값 할당하기.

//		Set<String>allkeys=mapKey.keySet();	//모든 키 얻기
//		System.out.println(allkeys);
//		Iterator<String>ita=allkeys.iterator();	//모든 값 얻기
//		Integer count=0;
//		while(ita.hasNext()) {
//			count=mapKey.get(ita.next());
//			count++;
//		}

	}// countKey
		/////////////////////////// 12-22-2018 키값 카운트 메소드 끝
		// ///////////////////////////////

	public void countBrowser(String temp) {

		// 2. 브라우저별 접속 횟수 구하는 method, 비율 구하기(아직)
	}
=======
	public void countKey(String temp) {
		// 1. 理쒕떎 �궗�슜 Key�쓽 �씠由꾧낵 �슏�닔瑜� 援ы븯�뒗 method
	}

//////////////////////12.22 �꽑�쓽 異붽� 肄붾뱶(釉뚮씪�슦��,移댁슫�꽣 mapBrowser�뿉 �꽔湲�) �떆�옉 ////////////////////////////
	private String[] browser = { "opera", "ie", "firefox", "Chrome", "Safari" };
	private int[] browserCnt = new int[browser.length];

	public void countBrowser(String temp) {
		// 2. 釉뚮씪�슦��蹂� �젒�냽 �슏�닔 援ы븯�뒗 method, 鍮꾩쑉 援ы븯湲�(�븘吏�)
//		System.out.println(temp);
		int count = 0;
//		System.out.println("temp :"+temp  );
		for (int i = 0; i < browser.length; i++) {
			if (temp.contains(browser[i])) {
				browserCnt[i]++;
			} // end for
//			count=0;
			mapBrowser.put(browser[i], browserCnt[i]);
		} // end for
//		System.out.println("requestNum = " +requestNum+", "+mapBrowser);
	}// countBrowser
/////////////////////12.22 �꽑�쓽 異붽� 肄붾뱶(釉뚮씪�슦��,移댁슫�꽣 mapBrowser�뿉 �꽔湲�) �걹////////////////////////////
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b

	public void countHttpStatusCode(String temp) {
		// 3. �꽌鍮꾩뒪瑜� �꽦怨듭쟻�쑝濡� �닔�뻾�븳 �슏�닔, �떎�뙣(404) �슏�닔
		// 6. 鍮꾩젙�긽�쟻�씤 �슂泥�(403)�씠 諛쒖깮�븳 �슏�닔 援ы븯�뒗 method, 鍮꾩쑉 援ы븯湲� method�뒗 calBrowserShare()濡� 援ы쁽
	}
<<<<<<< HEAD

	public void countRequestHour(String temp) {
		// 4. 요청 시간별 횟수를 구하는 method.

		Map<String, Integer> map = new HashMap<String, Integer>();

=======

	public void countRequestHour(String temp) {
		// 4. �슂泥� �떆媛꾨퀎 �슏�닔瑜� 援ы븯�뒗 method.
		Map<String, Integer>map=new HashMap<String,Integer>();
		
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
		// String key=
	}

	public SelectLog getSl() {
		return sl;
	}

	public String getFilePath() {
		return filePath;
	}

	public Map<String, Integer> getMapKey() {
		return mapKey;
	}

	public Map<String, Integer> getMapBrowser() {
		return mapBrowser;
	}

	public Map<String, Integer> getMapHour() {
		return mapHour;
	}

	public int getCode200() {
		return code200;
	}

	public int getCode404() {
		return code404;
	}

	public int getCode403() {
		return code403;
	}

	public int getRequestNum() {
		return requestNum;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public String getCode403Share() {
		return code403Share;
	}

	public Map<String, String> getMapBrowserShare() {
		return mapBrowserShare;
	}

	public String getMostFrequentKey() {
		return mostFrequentKey;
	}

	public boolean isReportFlag() {
		return reportFlag;
	}
}

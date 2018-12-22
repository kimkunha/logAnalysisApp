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

	// 1~6ì„ ì²˜ë¦¬í•œ ë‚´ìš©ì„ instance ë³€ìˆ˜ì— ì €ì¥í•´ì•¼ í•¨
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

<<<<<<< HEAD
				// readLog·Î ÀĞ¾îµéÀÎ logÀÇ ³»¿ëÀ» °¡°ø, instanceº¯¼ö¿¡ ÀúÀå
				calMostFrequentKey();
				calBrowserShare();
				calCode403Share();

				// °á°úÃ¢
				new Result(this);
				System.out.println("°á°úÃ¢ »ı¼ºÀÚ È£Ãâ");
=======
				// readLogë¡œ ì½ì–´ë“¤ì¸ logì˜ ë‚´ìš©ì„ ê°€ê³µ, instanceë³€ìˆ˜ì— ì €ì¥
				calMostFrequentKey();
				calBrowserShare();
				calCode403Share();
			
				// ê²°ê³¼ì°½
				new Result(this, sl);
				System.out.println("ê²°ê³¼ì°½ ìƒì„±ì í˜¸ì¶œ");
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b

			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}

<<<<<<< HEAD
		// jbView°¡ ÇÑ¹ø ÀÌ»ó ´­·È´Ù¸é JOptionPane.showMessageDialog¿¡ ºÙ¿© °á°ú Ãâ·Â
=======
		// jbViewê°€ í•œë²ˆ ì´ìƒ ëˆŒë ¸ë‹¤ë©´ JOptionPane.showMessageDialogì— ë¶™ì—¬ ê²°ê³¼ ì¶œë ¥
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
		if (e.getSource() == sl.getJbReport()) {
			// jbViewê°€ í•œë²ˆì´ìƒ ëˆŒë ¸ì„ ë•Œ ìˆ˜í–‰ë˜ë„ë¡ êµ¬í˜„(boolean flagë¡œ êµ¬í˜„)
			if (reportFlag == true) {
<<<<<<< HEAD
				// "report Ãâ·Â"À» Component·Î ´ëÃ¼ÇØ¾ß ÇÔ, Component¸¦ ¹İÈ¯ÇÏ´Â method ¸¸µé °Í

				// ÆÄÀÏ Ãâ·Â FileDialog ±¸Çö
=======
				// "report ì¶œë ¥"ì„ Componentë¡œ ëŒ€ì²´í•´ì•¼ í•¨, Componentë¥¼ ë°˜í™˜í•˜ëŠ” method ë§Œë“¤ ê²ƒ

				// íŒŒì¼ ì¶œë ¥ FileDialog êµ¬í˜„
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
				try {
					mkLogReport();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(sl, "Log Viewë¥¼ ë¨¼ì € ìˆ˜í–‰í•˜ì—¬ ì£¼ì„¸ìš”.");
			}
		}

		if (e.getSource() == sl.getJbLineView()) {
			// ì‹œì‘,ë ë¼ì¸ì´ ì…ë ¥ëì„ ë•Œ í•´ë‹¹ ë¼ì¸ ìˆ˜ë¥¼ ê°€ì ¸ì˜¨ë‹¤
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
		// report, FileDialog SAVE, Ãâ·ÂÇÏ´Â method

=======

		// report, FileDialog SAVE, ì¶œë ¥í•˜ëŠ” method
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
	}

	public void calMostFrequentKey() {
		// ê°€ì¥ ë¹ˆë„ìˆ˜ ë†’ì€ key(mostFrequentKey) êµ¬í•˜ëŠ” method
	}

	public void calMostFrequentHour() {
<<<<<<< HEAD
		// °¡Àå ºóµµ¼ö ³ôÀº ½Ã°£À» ±¸ÇÏ´Â method
	}

=======
		// ê°€ì¥ ë¹ˆë„ìˆ˜ ë†’ì€ ì‹œê°„(mostFrequentHour) êµ¬í•˜ëŠ” method 
	}
	
/////////////////////12.22 ì„ ì˜ ì½”ë“œ ì¶”ê°€ (ë¸Œë¼ìš°ì €ì˜ ë¹„ìœ¨êµ¬í•´ì„œ ë°˜í™˜) ì‹œì‘//////////////////////////////
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b
	public void calBrowserShare() {
		ArrayList<String> al = new ArrayList<String>();
		Set<String> set = mapBrowser.keySet();
		Iterator<String> ita = set.iterator();
		Iterator<String> ita2 = set.iterator();

//		System.out.println("ëª¨ë“ ë„˜ë²„: " + requestNum);
//		System.out.println(mapBrowser);
		for (int i = 0; i < browser.length; i++) {
			mapBrowserShare.put(ita2.next(), String.format("%4.2f", ((mapBrowser.get(ita.next()) / (double) requestNum) * 100)));
		}
//		System.out.println(al);
//		System.out.println(mapBrowserShare);
	}
<<<<<<< HEAD
=======
/////////////////////12.22 ì„ ì˜ ì½”ë“œ ì¶”ê°€ (ë¸Œë¼ìš°ì €ì˜ ë¹„ìœ¨êµ¬í•´ì„œ ë°˜í™˜) ë//////////////////////////////

>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b

	public void calCode403Share() {
		code403Share = String.format("%3.2f", (code403 / (double) requestNum) * 100);
	}

	public void selectLog() {
<<<<<<< HEAD
		// ÀĞ¾îµéÀÎ logÆÄÀÏÀÇ °æ·Î¸¦ ÀúÀåÇÏ´Â method
		FileDialog fd = new FileDialog(sl, "log ÆÄÀÏ ¼±ÅÃ", FileDialog.LOAD);
=======
		// ì½ì–´ë“¤ì¸ logíŒŒì¼ì˜ ê²½ë¡œë¥¼ ì €ì¥í•˜ëŠ” method
		FileDialog fd = new FileDialog(sl, "log ï¿½ë™†ï¿½ì”ª ï¿½ê½‘ï¿½ê¹®", FileDialog.LOAD);
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
				// ì„ íƒëœ íŒŒì¼ì˜ ë‚´ìš©ì„ í•œ ì¤„ì”© ì½ì–´ë“¤ì„
				// ì½ì–´ë“¤ì´ëŠ” ë‚´ìš©ì„ ì²˜ë¦¬í•˜ëŠ”ê±´ ë”°ë¡œ method ë§Œë“¤ì–´ì„œ ì²˜ë¦¬í•  ê²ƒ
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
	/////////////////////////// 12-22-2018 Å°°ª Ä«¿îÆ® ¸Ş¼Òµå ±¸Çö(°ÇÇÏ)
	/////////////////////////// ///////////////////////////////
	public void countKey(String temp) {
		// 1. ÃÖ´Ù »ç¿ë KeyÀÇ ÀÌ¸§°ú È½¼ö¸¦ ±¸ÇÏ´Â method
//		String[] str=null;
//		Integer[] intValue=null;
		Set<String>setKey=new HashSet<>();

		if (temp.contains("key")) {
//			for(int i=0;i<requestNum;i++) {
			String str = temp.substring(temp.indexOf("=") + 1, temp.indexOf("&")); // ¹İÈ¯ÇüÀÌ intÇüÀÌ¶ó¼­ ¹İÈ¯ÇüÀ» ¸ÂÃçÁà¾ß ÇÑ´Ù.
			
			for(int i=0; i<str.length(); i++) {
				setKey.add(String.valueOf(str));
			}
			System.out.println(setKey); // Å°°ª ±¸ÇÏ±â
			
			
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
	// ±¸ÇÑ Å°°ªÀ¸·Î °ª ÇÒ´çÇÏ±â.

//		Set<String>allkeys=mapKey.keySet();	//¸ğµç Å° ¾ò±â
//		System.out.println(allkeys);
//		Iterator<String>ita=allkeys.iterator();	//¸ğµç °ª ¾ò±â
//		Integer count=0;
//		while(ita.hasNext()) {
//			count=mapKey.get(ita.next());
//			count++;
//		}

	}// countKey
		/////////////////////////// 12-22-2018 Å°°ª Ä«¿îÆ® ¸Ş¼Òµå ³¡
		// ///////////////////////////////

	public void countBrowser(String temp) {

		// 2. ºê¶ó¿ìÀúº° Á¢¼Ó È½¼ö ±¸ÇÏ´Â method, ºñÀ² ±¸ÇÏ±â(¾ÆÁ÷)
	}
=======
	public void countKey(String temp) {
		// 1. ìµœë‹¤ ì‚¬ìš© Keyì˜ ì´ë¦„ê³¼ íšŸìˆ˜ë¥¼ êµ¬í•˜ëŠ” method
	}

//////////////////////12.22 ì„ ì˜ ì¶”ê°€ ì½”ë“œ(ë¸Œë¼ìš°ì €,ì¹´ìš´í„° mapBrowserì— ë„£ê¸°) ì‹œì‘ ////////////////////////////
	private String[] browser = { "opera", "ie", "firefox", "Chrome", "Safari" };
	private int[] browserCnt = new int[browser.length];

	public void countBrowser(String temp) {
		// 2. ë¸Œë¼ìš°ì €ë³„ ì ‘ì† íšŸìˆ˜ êµ¬í•˜ëŠ” method, ë¹„ìœ¨ êµ¬í•˜ê¸°(ì•„ì§)
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
/////////////////////12.22 ì„ ì˜ ì¶”ê°€ ì½”ë“œ(ë¸Œë¼ìš°ì €,ì¹´ìš´í„° mapBrowserì— ë„£ê¸°) ë////////////////////////////
>>>>>>> 7be9663ac978f11716dac0ca5a7f93cc982a5f3b

	public void countHttpStatusCode(String temp) {
		// 3. ì„œë¹„ìŠ¤ë¥¼ ì„±ê³µì ìœ¼ë¡œ ìˆ˜í–‰í•œ íšŸìˆ˜, ì‹¤íŒ¨(404) íšŸìˆ˜
		// 6. ë¹„ì •ìƒì ì¸ ìš”ì²­(403)ì´ ë°œìƒí•œ íšŸìˆ˜ êµ¬í•˜ëŠ” method, ë¹„ìœ¨ êµ¬í•˜ê¸° methodëŠ” calBrowserShare()ë¡œ êµ¬í˜„
	}
<<<<<<< HEAD

	public void countRequestHour(String temp) {
		// 4. ¿äÃ» ½Ã°£º° È½¼ö¸¦ ±¸ÇÏ´Â method.

		Map<String, Integer> map = new HashMap<String, Integer>();

=======

	public void countRequestHour(String temp) {
		// 4. ìš”ì²­ ì‹œê°„ë³„ íšŸìˆ˜ë¥¼ êµ¬í•˜ëŠ” method.
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

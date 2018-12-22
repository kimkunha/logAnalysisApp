package kr.co.sist.log.evt;

import java.awt.FileDialog;
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

	// 1~6�� ó���� ������ instance ������ �����ؾ� ��
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

				// readLog�� �о���� log�� ������ ����, instance������ ����
				calMostFrequentKey();
				calBrowserShare();
				calCode403Share();

				// ���â
				new Result(this);
				System.out.println("���â ������ ȣ��");

			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}

		// jbView�� �ѹ� �̻� ���ȴٸ� JOptionPane.showMessageDialog�� �ٿ� ��� ���
		if (e.getSource() == sl.getJbReport()) {
			// jbView�� �ѹ��̻� ������ �� ����ǵ��� ����(boolean flag�� ����)
			if (reportFlag == true) {
				// "report ���"�� Component�� ��ü�ؾ� ��, Component�� ��ȯ�ϴ� method ���� ��

				// ���� ��� FileDialog ����
				try {
					mkLogReport();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(sl, "Log View�� ���� �����Ͽ� �ּ���.");
			}
		}

		if (e.getSource() == sl.getJbLineView()) {
			// ����,�� ������ �Էµ��� �� �ش� ���� ���� �����´�
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
		// report, FileDialog SAVE, ����ϴ� method

	}

	public void calMostFrequentKey() {
		// ���� �󵵼� ���� key(mostFrequentKey) ���ϴ� method
	}

	public void calMostFrequentHour() {
		// ���� �󵵼� ���� �ð��� ���ϴ� method
	}

	public void calBrowserShare() {
		// Browser ���� ���ϴ� method
	}

	public void calCode403Share() {
		code403Share = String.format("%3.2f", (code403 / (double) requestNum) * 100);
	}

	public void selectLog() {
		// �о���� log������ ��θ� �����ϴ� method
		FileDialog fd = new FileDialog(sl, "log ���� ����", FileDialog.LOAD);
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
				// ���õ� ������ ������ �� �پ� �о����
				// �о���̴� ������ ó���ϴ°� ���� method ���� ó���� ��
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

	/////////////////////////// 12-22-2018 Ű�� ī��Ʈ �޼ҵ� ����(����)
	/////////////////////////// ///////////////////////////////
	public void countKey(String temp) {
		// 1. �ִ� ��� Key�� �̸��� Ƚ���� ���ϴ� method
//		String[] str=null;
//		Integer[] intValue=null;
		Set<String>setKey=new HashSet<>();

		if (temp.contains("key")) {
//			for(int i=0;i<requestNum;i++) {
			String str = temp.substring(temp.indexOf("=") + 1, temp.indexOf("&")); // ��ȯ���� int���̶� ��ȯ���� ������� �Ѵ�.
			
			for(int i=0; i<str.length(); i++) {
				setKey.add(String.valueOf(str));
			}
			System.out.println(setKey); // Ű�� ���ϱ�
			
			
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
	// ���� Ű������ �� �Ҵ��ϱ�.

//		Set<String>allkeys=mapKey.keySet();	//��� Ű ���
//		System.out.println(allkeys);
//		Iterator<String>ita=allkeys.iterator();	//��� �� ���
//		Integer count=0;
//		while(ita.hasNext()) {
//			count=mapKey.get(ita.next());
//			count++;
//		}

	}// countKey
		/////////////////////////// 12-22-2018 Ű�� ī��Ʈ �޼ҵ� ��
		// ///////////////////////////////

	public void countBrowser(String temp) {

		// 2. �������� ���� Ƚ�� ���ϴ� method, ���� ���ϱ�(����)
	}

	public void countHttpStatusCode(String temp) {
		// 3. ���񽺸� ���������� ������ Ƚ��, ����(404) Ƚ��
		// 6. ���������� ��û(403)�� �߻��� Ƚ�� ���ϴ� method, ���� ���ϱ� method�� calBrowserShare()�� ����
	}

	public void countRequestHour(String temp) {
		// 4. ��û �ð��� Ƚ���� ���ϴ� method.

		Map<String, Integer> map = new HashMap<String, Integer>();

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

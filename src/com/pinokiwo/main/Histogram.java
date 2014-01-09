package com.pinokiwo.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

import au.com.bytecode.opencsv.CSVReader;

import com.pinokiwo.statistics.HistogramUtil;
import com.pinokiwo.statistics.InvalidHistogramException;

public class Histogram {

	private static CSVReader reader;
	public Histogram() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) throws IOException {

		String course_id="4662";
		// TODO 自動生成されたメソッド・スタブ
		InputStream input=new FileInputStream(new File("/Users/yasikoba/Downloads/discussion-"+course_id+".csv"));
		InputStreamReader ireader=new InputStreamReader(input, "MS932");
		reader = new CSVReader(ireader,',','"',7);
		String [] nextLine;
		List<Double> list_oya = new ArrayList<Double>();
		List<Double> list_ko = new ArrayList<Double>();
		List<Double> list_total = new ArrayList<Double>();
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			// System.out.println(nextLine[0] + nextLine[1] + nextLine[2]+ nextLine[3]);
			list_oya.add(Double.valueOf(nextLine[3]));
			list_ko.add(Double.valueOf(nextLine[4]));
			list_total.add(Double.valueOf(nextLine[5]));
		}


		try {

			createHistogram(course_id,"oya", list_oya);
			createHistogram(course_id,"ko", list_ko);
			createHistogram(course_id,"total", list_total);

		} catch (InvalidHistogramException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private static void createHistogram(String course_id, String type, List<Double> list_oya)
			throws InvalidHistogramException, FileNotFoundException,
			UnsupportedEncodingException {
		Map<Double, Map<String, Object>> result;
		DescriptiveStatistics ds = HistogramUtil.createStat(list_oya);
		StringBuffer sb= new StringBuffer();				
		sb.append("max="+ds.getMax()+",mean="+ds.getMean()+",n="+ds.getN()+"\n\n");
		//result = HistogramUtil.createHistgramLogMap(list);
		result = HistogramUtil.createHistgramMap(list_oya);
		Set<Double> keys =result.keySet();
		//System.out.println("\"階級\",\"度数\",\"累積相対度数\"");
		sb.append("度数\n");
		for(Double key:keys){
			if((Double)result.get(key).get("heights")==0d){
				continue;
			}
			sb.append(result.get(key).get("interval"));
			sb.append(",");
			sb.append(key.toString());
			sb.append(",");
			sb.append(result.get(key).get("heights"));
			sb.append("\n");
		}
		sb.append("\n");
		sb.append("相対度数\n");
		for(Double key:keys){
			if((Double)result.get(key).get("density")==0d){
				continue;
			}
			sb.append(result.get(key).get("interval"));
			sb.append(",");
			sb.append(key.toString());
			sb.append(",");
			sb.append(result.get(key).get("density"));
			sb.append("\n");
		}
		sb.append("\n");

		sb.append("累積相対度数\n");
		for(Double key:keys){
			sb.append(result.get(key).get("interval"));
			sb.append(",");
			sb.append(key.toString());
			sb.append(",");
			sb.append(result.get(key).get("sumDensity"));
			sb.append("\n");
		}

		PrintWriter writer = new PrintWriter(
				"/Users/yasikoba/Downloads/histogram-"+course_id+"-"+type+".csv", "MS932");
		writer.println(sb);
		writer.close();
	}
}

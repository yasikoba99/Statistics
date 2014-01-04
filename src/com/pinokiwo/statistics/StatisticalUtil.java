package com.pinokiwo.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

/**
 * @author hikobayashi
 * 統計量を算出するユーティリティクラスです
 */
public class StatisticalUtil {

	/**
	 * staticメソッドの集まりなのでインスタンス化はしない
	 */
	private StatisticalUtil() {
		super();
		throw new AssertionError();
	}

	/**
	 * @param key 統計量を出すカラム
	 * @param list DBから抽出したMapリスト
	 * @return
	 */
	public static Map<String,Double> createSummary(String key, List<Map<String,Object>> list){

		HashMap<String,Double> smap = new HashMap<String, Double>();

		if(list==null || list.size()==0)
			return smap;

		List<Double> doubles = createDoubleList(key,list);
		DescriptiveStatistics stats = HistogramUtil.createStat(doubles);

		smap.put("min",stats.getMin());
		smap.put("max", stats.getMax());
		smap.put("mean", stats.getMean());
		smap.put("stdev", stats.getStandardDeviation()); //標準偏差
		smap.put("number", new Double(stats.getN()));
		smap.put("kurtosis",stats.getKurtosis());  //尖度
		smap.put("skewness", stats.getSkewness()); //歪度
		smap.put("sum", stats.getSum());

		//中央値の算出
		double[] sorted = stats.getSortedValues();

		Double median = getMedian(sorted);

		smap.put("median",median);

		return smap;
	}

	/**
	 * 中央値の算出
	 * http://ja.wikipedia.org/wiki/%E4%B8%AD%E5%A4%AE%E5%80%A4
	 * @param sorted
	 * @return
	 */
	public static Double getMedian(double[] sorted) {

		Double median = null;

		if(sorted.length % 2 ==0 ){

			int m = sorted.length/2;
			median = (sorted[m-1] + sorted[m])/2.0d;

		} else if(sorted.length % 2 == 1){

			if (sorted.length==1 ){
				median = sorted[0];
			} else {
				int m = sorted.length/2+1;
				median = sorted[m-1];
			}
		}
		return median;
	}

	/**
	 * @param key
	 * @param list
	 * @return
	 * @throws InvalidHistogramException
	 */
	public static HistogramBeans createHistogramBeans(String key, List<Map<String,Object>> list)
	throws InvalidHistogramException{

		if(list==null || list.size()==0)
			return new HistogramBeans();
		List<Double> doubles = createDoubleList(key,list);
		HistogramBeans hb = HistogramUtil.createHistogramBeans(doubles);

		return hb;

	}

	/**
	 * カラム名を指定してDouble型のリストを作成
	 * @param key カラム名
	 * @param list DBから抽出したMapList型のデータ
	 * @return
	 */
	public static List<Double> createDoubleList(String key, List<Map<String,Object>> list){
		ArrayList<Double> doubles = new ArrayList<Double>();


		if(list==null || list.size()==0)
			return doubles;

		for (int i = 0; i<list.size();i++){
			Map<String,Object> map = (Map<String,Object>)list.get(i);
			doubles.add(new Double(map.get(key).toString()));
		}
		return doubles;
	}

	/**
	 * @param key
	 * @param list
	 * @return
	 * @throws InvalidHistogramException
	 */
	public static Map<Double,Map<String,Object>> createHistogramMap(
			String key, List<Map<String,Object>> list) throws InvalidHistogramException{

		List<Double> doubles = createDoubleList(key,list);

		return HistogramUtil.createHistgramMap(doubles);

	}
}

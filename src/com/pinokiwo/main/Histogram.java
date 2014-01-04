package com.pinokiwo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

import com.pinokiwo.statistics.HistogramUtil;
import com.pinokiwo.statistics.InvalidHistogramException;

public class Histogram {

	public Histogram() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map<Double,Map<String,Object>> result = null;
		//List<Double> list = createRawList_gulokei1(); 
		List<Double> list = createRawList_monketsukiso1();
		
		DescriptiveStatistics ds = HistogramUtil.createStat(list);
		System.out.println(ds.getMax()+","+ds.getMean());


		try {
			result = HistogramUtil.createHistgramLogMap(list);
			Set<Double> keys =result.keySet();
			//System.out.println("\"階級\",\"度数\",\"累積相対度数\"");
			for(Double key:keys){
				StringBuffer sb= new StringBuffer();				
				sb.append(key.toString());
				sb.append(",");
				sb.append(result.get(key).get("heights"));
				System.out.println(sb);
			}
			System.out.println("");
			for(Double key:keys){
				StringBuffer sb= new StringBuffer();				
				sb.append(key.toString());
				sb.append(",");
				sb.append(result.get(key).get("density"));
				System.out.println(sb);
			}
			
		} catch (InvalidHistogramException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
	private static List<Double> createRawList_gulokei1(){
		List<Double> list =  new ArrayList<Double>();
		list.add(118d);
		list.add(184d);
		list.add(0d);
		list.add(53d);
		list.add(9d);
		list.add(85d);
		list.add(0d);
		list.add(122d);
		list.add(2d);
		list.add(105d);
		list.add(47d);
		list.add(11d);
		list.add(3d);
		list.add(1d);
		list.add(80d);
		list.add(0d);
		list.add(0d);
		list.add(52d);
		list.add(5d);
		list.add(36d);
		list.add(10d);
		list.add(280d);
		list.add(5d);
		list.add(279d);
		list.add(58d);
		list.add(31d);
		list.add(136d);
		list.add(57d);
		list.add(0d);
		list.add(22d);
		list.add(212d);
		list.add(100d);
		list.add(2d);
		list.add(106d);
		list.add(23d);
		list.add(0d);
		list.add(2d);
		list.add(71d);
		list.add(19d);
		list.add(2d);
		list.add(0d);
		list.add(0d);
		list.add(139d);
		list.add(11d);
		list.add(317d);
		list.add(0d);
		list.add(458d);
		list.add(159d);
		list.add(39d);
		list.add(113d);
		list.add(90d);
		list.add(50d);
		list.add(46d);
		list.add(66d);
		list.add(33d);
		list.add(21d);
		list.add(17d);
		list.add(241d);
		list.add(15d);
		list.add(4d);
		list.add(20d);
		list.add(64d);
		list.add(265d);
		list.add(55d);
		list.add(136d);
		list.add(367d);
		list.add(32d);
		list.add(29d);
		list.add(89d);
		list.add(87d);
		list.add(55d);
		list.add(276d);
		list.add(7d);
		list.add(8d);
		list.add(193d);
		list.add(230d);
		list.add(24d);
		list.add(25d);
		list.add(456d);
		list.add(1d);
		list.add(158d);
		list.add(151d);
		list.add(0d);
		list.add(132d);
		list.add(179d);
		list.add(73d);
		list.add(81d);
		list.add(10d);
		list.add(109d);
		list.add(280d);
		list.add(56d);
		list.add(387d);
		list.add(0d);
		list.add(11d);
		list.add(352d);
		list.add(285d);
		list.add(13d);
		list.add(29d);
		list.add(0d);
		list.add(47d);
		list.add(14d);
		list.add(145d);
		list.add(73d);
		list.add(47d);
		list.add(56d);
		list.add(43d);
		list.add(126d);
		list.add(402d);
		list.add(72d);
		list.add(115d);
		list.add(40d);
		list.add(368d);
		list.add(87d);
		list.add(0d);
		list.add(178d);
		list.add(2d);
		list.add(0d);
		list.add(63d);
		list.add(283d);
		list.add(43d);
		list.add(1d);
		list.add(16d);
		list.add(102d);
		list.add(57d);
		list.add(448d);
		list.add(95d);
		list.add(28d);
		list.add(166d);
		list.add(54d);
		list.add(252d);
		list.add(93d);
		list.add(7d);
		list.add(122d);
		list.add(146d);
		list.add(69d);
		list.add(142d);
		list.add(371d);
		list.add(1d);
		list.add(192d);
		list.add(2d);
		list.add(4d);
		list.add(33d);
		list.add(44d);
		list.add(29d);
		list.add(58d);
		list.add(238d);
		list.add(111d);
		list.add(91d);
		list.add(35d);
		list.add(390d);
		list.add(89d);
		list.add(259d);
		list.add(36d);
		list.add(3d);
		list.add(49d);
		list.add(284d);
		list.add(69d);
		list.add(190d);
		list.add(4d);
		list.add(82d);
		list.add(43d);
		list.add(1d);
		list.add(193d);
		list.add(53d);
		list.add(0d);
		list.add(212d);
		list.add(369d);
		list.add(50d);
		list.add(3d);
		list.add(280d);
		list.add(0d);
		list.add(121d);
		list.add(158d);
		list.add(262d);
		list.add(244d);
		list.add(116d);
		list.add(5d);
		list.add(113d);
		list.add(12d);
		list.add(28d);
		list.add(26d);
		list.add(76d);
		list.add(15d);
		list.add(20d);
		list.add(17d);
		list.add(0d);
		list.add(2d);
		list.add(105d);
		list.add(14d);
		list.add(33d);
		list.add(35d);
		list.add(229d);
		list.add(0d);
		list.add(68d);
		list.add(158d);
		list.add(330d);
		list.add(51d);
		list.add(5d);
		list.add(160d);
		list.add(22d);
		list.add(146d);
		list.add(170d);
		list.add(169d);
		list.add(3d);
		list.add(5d);
		list.add(12d);
		list.add(194d);
		list.add(32d);
		list.add(15d);
		list.add(33d);
		list.add(127d);
		list.add(21d);
		list.add(8d);
		list.add(7d);
		list.add(0d);
		list.add(3d);
		list.add(15d);
		list.add(358d);
		list.add(210d);
		list.add(153d);
		list.add(31d);
		list.add(13d);
		list.add(95d);
		list.add(41d);
		list.add(48d);
		list.add(38d);
		list.add(119d);
		list.add(42d);
		list.add(18d);
		list.add(262d);
		list.add(123d); // course-code 422

		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(26d);
		list.add(35d);
		list.add(12d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(29d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(3d);
		list.add(0d);
		list.add(0d);
		list.add(4d);
		list.add(0d);
		list.add(4d);
		list.add(1d);
		list.add(0d);
		list.add(0d);
		list.add(83d);
		list.add(2d);
		list.add(0d);
		list.add(38d);
		list.add(6d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(18d);
		list.add(11d);
		list.add(3d);
		list.add(22d);
		list.add(25d);
		list.add(40d);
		list.add(70d);
		list.add(99d);
		list.add(15d);
		list.add(0d);
		list.add(121d);
		list.add(19d);
		list.add(64d);
		list.add(57d);
		list.add(198d);
		list.add(0d);
		list.add(14d);
		list.add(8d);
		list.add(122d);
		list.add(8d);
		list.add(21d);
		list.add(78d);
		list.add(59d);
		list.add(41d);
		list.add(74d);
		list.add(10d);
		list.add(120d);
		list.add(135d);
		list.add(33d);
		list.add(56d);
		list.add(1d);
		list.add(163d);
		list.add(0d);
		list.add(141d);
		list.add(97d);
		list.add(322d);
		list.add(112d);
		list.add(295d);
		list.add(212d);
		list.add(6d);
		list.add(30d);
		list.add(78d);
		list.add(23d);
		list.add(56d);
		list.add(16d);
		list.add(29d);
		list.add(214d);
		list.add(177d);
		list.add(66d);
		list.add(112d);
		list.add(127d);
		list.add(5d);
		list.add(3d);
		list.add(93d);
		list.add(193d);
		list.add(21d);
		list.add(18d);
		list.add(71d);
		list.add(0d);
		list.add(199d);
		list.add(1d);
		list.add(285d);
		list.add(47d);
		list.add(294d);
		list.add(95d);
		list.add(24d);
		list.add(200d);
		list.add(4d);
		list.add(94d);
		list.add(125d);
		list.add(8d);
		list.add(22d);
		list.add(104d);
		list.add(47d);
		list.add(2d);
		list.add(3d);
		list.add(191d);
		list.add(70d);
		list.add(27d);
		list.add(76d);
		list.add(40d);
		list.add(306d);
		list.add(93d);
		list.add(285d);
		list.add(39d);
		list.add(127d);
		list.add(93d);
		list.add(10d);
		list.add(17d);
		list.add(5d);
		list.add(150d);
		list.add(198d);
		list.add(14d);
		list.add(70d);
		list.add(89d);
		list.add(37d);
		list.add(22d);
		list.add(29d);
		list.add(171d);
		list.add(137d);
		list.add(7d);
		list.add(48d);
		list.add(103d);
		list.add(132d);
		list.add(25d);
		list.add(1d);
		list.add(10d);
		list.add(0d);
		list.add(21d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(111d);
		list.add(69d);
		list.add(83d);
		list.add(0d);
		list.add(6d);
		list.add(63d);
		list.add(5d);
		list.add(109d);
		list.add(4d);
		list.add(69d);
		list.add(52d);
		list.add(10d);
		list.add(19d);
		list.add(4d);
		list.add(210d);
		list.add(1d);
		list.add(0d);
		list.add(78d);
		list.add(10d);
		list.add(181d);
		list.add(70d);
		list.add(3d);
		list.add(360d);
		list.add(87d);
		list.add(26d);
		list.add(34d);
		list.add(9d);
		list.add(124d);
		list.add(112d);
		list.add(6d);
		list.add(35d);
		list.add(204d);
		list.add(7d);
		list.add(1d);
		list.add(169d);
		list.add(99d);
		list.add(35d);
		list.add(10d);
		list.add(448d);
		list.add(141d);
		list.add(24d);
		list.add(50d);
		list.add(130d);
		list.add(2d);
		list.add(164d);
		list.add(39d);
		list.add(186d);			//1472
		
		list.add(0d);
		list.add(0d);
		list.add(65d);
		list.add(45d);
		list.add(1d);
		list.add(0d);
		list.add(29d);
		list.add(4d);
		list.add(64d);
		list.add(0d);
		list.add(189d);
		list.add(11d);
		list.add(0d);
		list.add(34d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(48d);
		list.add(0d);
		list.add(25d);
		list.add(3d);
		list.add(2d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(34d);
		list.add(5d);
		list.add(47d);
		list.add(0d);
		list.add(30d);
		list.add(0d);
		list.add(0d);
		list.add(24d);
		list.add(24d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(0d);
		list.add(58d);
		list.add(156d);
		list.add(57d);
		list.add(58d);
		list.add(26d);
		list.add(331d);
		list.add(91d);
		list.add(8d);
		list.add(61d);
		list.add(153d);
		list.add(171d);
		list.add(173d);
		list.add(76d);
		list.add(40d);
		list.add(32d);
		list.add(184d);
		list.add(71d);
		list.add(57d);
		list.add(37d);
		list.add(70d);
		list.add(200d);
		list.add(81d);
		list.add(71d);
		list.add(58d);
		list.add(54d);
		list.add(104d);
		list.add(60d);
		list.add(57d);
		list.add(138d);
		list.add(6d);
		list.add(29d);
		list.add(41d);
		list.add(59d);
		list.add(25d);
		list.add(94d);
		list.add(0d);
		list.add(91d);
		list.add(58d);
		list.add(55d);
		list.add(66d);
		list.add(18d);
		list.add(32d);
		list.add(171d);
		list.add(11d);
		list.add(65d);
		list.add(23d);
		list.add(80d);
		list.add(0d);
		list.add(17d);
		list.add(70d);
		list.add(71d);
		list.add(211d);
		list.add(40d);
		list.add(42d);
		list.add(19d);
		list.add(254d);
		list.add(38d);
		list.add(136d);
		list.add(50d);
		list.add(46d);
		list.add(95d);
		list.add(30d);
		list.add(88d);
		list.add(21d);
		list.add(7d);
		list.add(43d);
		list.add(144d);
		list.add(21d);
		list.add(8d);
		list.add(43d);
		list.add(32d);
		list.add(84d);
		list.add(63d);
		list.add(330d);
		list.add(162d);
		list.add(67d);
		list.add(102d);
		list.add(119d);
		list.add(54d);
		list.add(68d);
		list.add(71d);
		list.add(88d);
		list.add(59d);
		list.add(8d);
		list.add(13d);
		list.add(226d);
		list.add(82d);
		list.add(279d);
		list.add(152d);
		list.add(129d);
		list.add(98d);
		list.add(68d);
		list.add(181d);
		list.add(75d);
		list.add(39d);
		list.add(91d);
		list.add(0d);
		list.add(57d);
		list.add(20d);
		list.add(16d);
		list.add(142d);
		list.add(128d);
		list.add(33d);
		list.add(4d);
		list.add(81d);
		list.add(56d);
		list.add(110d);
		list.add(113d);
		list.add(31d);
		list.add(1d);
		list.add(54d);
		list.add(153d);
		list.add(74d);
		list.add(15d);
		list.add(96d);
		list.add(29d);
		list.add(15d);
		list.add(42d);
		list.add(162d);
		list.add(213d);
		list.add(94d);
		list.add(12d);
		list.add(184d);
		list.add(101d);
		list.add(97d);
		list.add(104d);
		list.add(241d);
		list.add(50d);
		list.add(68d);
		list.add(158d);
		list.add(35d);
		list.add(114d);
		list.add(11d);
		list.add(15d);
		list.add(51d);
		list.add(156d);
		list.add(27d);
		list.add(479d);
		list.add(76d);
		list.add(12d);
		list.add(0d);
		list.add(52d);
		list.add(115d);
		list.add(70d);
		list.add(0d);
		list.add(71d);  //2323
		return list;
	}
	private static List<Double> createRawList_monketsukiso1(){
		List<Double> list =  new ArrayList<Double>();
			list.add(0d);
			list.add(0d);
			list.add(5d);
			list.add(8d);
			list.add(25d);
			list.add(0d);
			list.add(2d);
			list.add(16d);
			list.add(1d);
			list.add(26d);
			list.add(0d);
			list.add(2d);
			list.add(15d);
			list.add(7d);
			list.add(11d);
			list.add(5d);
			list.add(53d);
			list.add(52d);
			list.add(34d);
			list.add(52d);
			list.add(11d);
			list.add(2d);
			list.add(43d);
			list.add(52d);
			list.add(2d);
			list.add(9d);
			list.add(20d);
			list.add(0d);
			list.add(60d);
			list.add(72d);
			list.add(18d);
			list.add(40d);
			list.add(15d);
			list.add(0d);
			list.add(19d);
			list.add(0d);
			list.add(3d);
			list.add(1d);
			list.add(23d);
			list.add(30d);
			list.add(20d);
			list.add(23d);
			list.add(90d);
			list.add(1d);
			list.add(4d);
			list.add(12d);
			list.add(1d);
			list.add(41d);
			list.add(2d);
			list.add(35d);
			list.add(2d);
			list.add(59d);
			list.add(30d);
			list.add(65d);
			list.add(15d);
			list.add(23d);
			list.add(4d);
			list.add(79d);
			list.add(80d);
			list.add(3d);
			list.add(25d);
			list.add(0d);
			list.add(1d);
			list.add(2d);
			list.add(1d);
			list.add(0d);
			list.add(18d);
			list.add(0d);
			list.add(9d);
			list.add(24d);
			list.add(19d);
			list.add(20d);
			list.add(0d);
			list.add(6d);
			list.add(0d);
			list.add(9d);
			list.add(105d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(1d);
			list.add(0d);
			list.add(1d);
			list.add(111d);
			list.add(4d);
			list.add(1d);
			list.add(1d);
			list.add(1d);
			list.add(0d);
			list.add(8d);
			list.add(0d);
			list.add(0d);
			list.add(2d);
			list.add(0d);
			list.add(14d);
			list.add(2d);
			list.add(0d);
			list.add(3d);
			list.add(1d);
			list.add(9d);
			list.add(10d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(5d);
			list.add(17d);
			list.add(18d);
			list.add(0d);
			list.add(2d);
			list.add(1d);
			list.add(34d);
			list.add(0d);
			list.add(8d);
			list.add(0d);
			list.add(15d);
			list.add(8d);
			list.add(1d);
			list.add(0d);
			list.add(0d);
			list.add(11d);
			list.add(0d);
			list.add(0d);
			list.add(15d);
			list.add(0d);
			list.add(8d);
			list.add(8d);
			list.add(15d);
			list.add(0d);
			list.add(66d);
			list.add(2d);
			list.add(0d);
			list.add(39d);
			list.add(4d);
			list.add(1d);
			list.add(5d);
			list.add(7d);
			list.add(2d);
			list.add(3d);
			list.add(20d);
			list.add(8d);
			list.add(0d);
			list.add(4d);
			list.add(27d);
			list.add(8d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(17d);
			list.add(14d);
			list.add(27d);
			list.add(0d);
			list.add(34d);
			list.add(71d);
			list.add(11d);
			list.add(18d);
			list.add(18d);
			list.add(18d);
			list.add(8d);
			list.add(7d);
			list.add(19d);
			list.add(19d);
			list.add(3d);
			list.add(26d);
			list.add(9d);
			list.add(0d);
			list.add(2d);
			list.add(12d);
			list.add(15d);
			list.add(22d);
			list.add(6d);
			list.add(45d);
			list.add(27d);
			list.add(3d);
			list.add(16d);
			list.add(0d);
			list.add(38d);
			list.add(51d);
			list.add(0d);
			list.add(0d);
			list.add(22d);
			list.add(11d);
			list.add(0d);
			list.add(0d);
			list.add(78d);
			list.add(0d);
			list.add(26d);
			list.add(6d);
			list.add(0d);
			list.add(25d);
			list.add(44d);
			list.add(22d);
			list.add(11d);
			list.add(0d);
			list.add(3d);
			list.add(22d);
			list.add(13d);
			list.add(7d);
			list.add(0d);
			list.add(0d);
			list.add(27d);
			list.add(45d);
			list.add(0d);
			list.add(7d);
			list.add(0d);
			list.add(2d);
			list.add(9d);
			list.add(18d);
			list.add(3d);
			list.add(4d);
			list.add(11d);
			list.add(16d);
			list.add(1d);
			list.add(69d);
			list.add(28d);
			list.add(18d);
			list.add(7d);
			list.add(71d);
			list.add(16d);
			list.add(8d);
			list.add(55d);
			list.add(0d);
			list.add(1d);
			list.add(27d);
			list.add(23d);
			list.add(25d);
			list.add(0d);
			list.add(0d);
			list.add(11d);
			list.add(12d);
			list.add(34d);
			list.add(15d);
			list.add(0d);
			list.add(26d);
			list.add(1d);
			list.add(28d);
			list.add(23d);
			list.add(1d);
			list.add(38d);
			list.add(15d);
			list.add(0d);
			list.add(29d);
			list.add(33d);
			list.add(0d);
			list.add(10d);
			list.add(1d);
			list.add(5d);
			list.add(2d);
			list.add(6d);
			list.add(20d);
			list.add(11d);
			list.add(49d);
			list.add(3d);
			list.add(13d);
			list.add(19d);
			list.add(30d);
			list.add(0d);
			list.add(11d);
			list.add(13d);
			list.add(0d);
			list.add(19d);
			list.add(29d);
			list.add(3d);
			list.add(54d);
			list.add(0d);
			list.add(49d);
			list.add(3d);
			list.add(10d);
			list.add(11d);
			list.add(10d);
			list.add(0d);
			list.add(72d);
			list.add(45d);
			list.add(14d);
			list.add(0d);
			list.add(44d);
			list.add(0d);
			list.add(15d);
			list.add(12d);
			list.add(56d);
			list.add(9d);
			list.add(0d);
			list.add(0d);
			list.add(20d);
			list.add(1d);
			list.add(6d);
			list.add(10d);
			list.add(12d);
			list.add(1d);
			list.add(1d);
			list.add(2d);
			list.add(1d);
			list.add(0d);
			list.add(13d);
			list.add(1d);
			list.add(3d);
			list.add(11d);
			list.add(9d);
			list.add(0d);
			list.add(18d);
			list.add(19d);
			list.add(79d);
			list.add(0d);
			list.add(5d);
			list.add(20d);
			list.add(2d);
			list.add(25d);
			list.add(14d);
			list.add(43d);
			list.add(3d);
			list.add(0d);
			list.add(0d);
			list.add(69d);
			list.add(2d);
			list.add(1d);
			list.add(9d);
			list.add(3d);
			list.add(0d);
			list.add(3d);
			list.add(0d);
			list.add(0d);
			list.add(4d);
			list.add(0d);
			list.add(6d);
			list.add(4d);
			list.add(29d);
			list.add(0d);
			list.add(11d);
			list.add(45d);
			list.add(11d);
			list.add(45d);
			list.add(4d);
			list.add(24d);
			list.add(10d);
			list.add(2d);
			list.add(41d);
			list.add(37d);
			list.add(0d);
			list.add(0d);
			list.add(5d);
			list.add(8d);
			list.add(25d);
			list.add(0d);
			list.add(2d);
			list.add(16d);
			list.add(1d);
			list.add(26d);
			list.add(0d);
			list.add(2d);
			list.add(15d);
			list.add(7d);
			list.add(11d);
			list.add(5d);
			list.add(53d);
			list.add(52d);
			list.add(34d);
			list.add(52d);
			list.add(11d);
			list.add(2d);
			list.add(43d);
			list.add(52d);
			list.add(2d);
			list.add(9d);
			list.add(20d);
			list.add(0d);
			list.add(60d);
			list.add(72d);
			list.add(18d);
			list.add(40d);
			list.add(15d);
			list.add(0d);
			list.add(19d);
			list.add(0d);
			list.add(3d);
			list.add(1d);
			list.add(23d);
			list.add(30d);
			list.add(20d);
			list.add(23d);
			list.add(90d);
			list.add(1d);
			list.add(4d);
			list.add(12d);
			list.add(1d);
			list.add(41d);
			list.add(2d);
			list.add(35d);
			list.add(2d);
			list.add(59d);
			list.add(30d);
			list.add(65d);
			list.add(15d);
			list.add(23d);
			list.add(4d);
			list.add(79d);
			list.add(80d);
			list.add(3d);
			list.add(25d);
			list.add(0d);
			list.add(1d);
			list.add(2d);
			list.add(1d);
			list.add(0d);
			list.add(18d);
			list.add(0d);
			list.add(9d);
			list.add(24d);
			list.add(19d);
			list.add(20d);
			list.add(0d);
			list.add(6d);
			list.add(0d);
			list.add(9d);
			list.add(105d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(1d);
			list.add(0d);
			list.add(1d);
			list.add(111d);
			list.add(4d);
			list.add(1d);
			list.add(1d);
			list.add(1d);
			list.add(0d);
			list.add(8d);
			list.add(0d);
			list.add(0d);
			list.add(2d);
			list.add(0d);
			list.add(14d);
			list.add(2d);
			list.add(0d);
			list.add(3d);
			list.add(1d);
			list.add(9d);
			list.add(10d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(5d);
			list.add(0d);
			list.add(0d);
			list.add(33d);
			list.add(0d);
			list.add(2d);
			list.add(0d);
			list.add(0d);
			list.add(10d);
			list.add(5d);
			list.add(3d);
			list.add(1d);
			list.add(0d);
			list.add(1d);
			list.add(4d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(1d);
			list.add(0d);
			list.add(0d);
			list.add(4d);
			list.add(0d);
			list.add(0d);
			list.add(11d);
			list.add(0d);
			list.add(0d);
			list.add(0d);
			list.add(1d);
			list.add(10d);
			list.add(10d);
			list.add(11d);
			list.add(5d);
			list.add(11d);
			list.add(17d);
			list.add(1d);
			list.add(8d);
			list.add(6d);
			list.add(17d);
			list.add(4d);
			list.add(1d);
			list.add(14d);
			list.add(0d);
			list.add(15d);
			list.add(10d);
			list.add(19d);
			list.add(19d);
			list.add(11d);
			list.add(8d);
			list.add(11d);
			list.add(0d);
			list.add(1d);
			list.add(9d);
			list.add(7d);
			list.add(6d);
			list.add(4d);
			list.add(6d);
			list.add(3d);
			list.add(12d);
			list.add(3d);
			list.add(19d);
			list.add(11d);
			list.add(0d);
			list.add(11d);
			list.add(15d);
			list.add(14d);
			list.add(14d);
			list.add(18d);
			list.add(4d);
			list.add(9d);
			list.add(9d);
			list.add(7d);
			list.add(1d);
			list.add(6d);
			list.add(16d);
			list.add(20d);
			list.add(6d);
			list.add(0d);
			list.add(17d);
			list.add(9d);
			list.add(2d);
			list.add(2d);
			list.add(24d);
			list.add(9d);
			list.add(0d);
			list.add(5d);
			list.add(1d);
			list.add(21d);
			list.add(5d);
			list.add(12d);
			list.add(0d);
			list.add(8d);
			list.add(8d);
			list.add(3d);
			list.add(8d);
			list.add(3d);
			list.add(3d);
			list.add(12d);
			list.add(1d);
			list.add(5d);
			list.add(7d);
			list.add(15d);
			list.add(0d);
			list.add(3d);
			list.add(15d);
			list.add(14d);
			list.add(22d);
			list.add(8d);
			list.add(3d);
			list.add(0d);
			list.add(6d);
			list.add(6d);
			list.add(6d);
			list.add(6d);
			list.add(5d);
			list.add(6d);
			list.add(2d);
			list.add(7d);
			list.add(6d);
			list.add(0d);
			list.add(4d);
			list.add(15d);
			list.add(2d);
			list.add(1d);
			list.add(7d);
			list.add(12d);
			list.add(15d);
			list.add(1d);
			list.add(15d);
			list.add(8d);
			list.add(3d);
			list.add(12d);
			list.add(11d);
			list.add(1d);
			list.add(7d);
			list.add(2d);
			list.add(7d);
			list.add(3d);
			list.add(3d);
			list.add(7d);
			list.add(15d);
			list.add(2d);
			list.add(15d);
			list.add(7d);
			list.add(11d);
			list.add(13d);
			list.add(5d);
			list.add(20d);
			list.add(3d);
			list.add(4d);
			list.add(9d);
			list.add(0d);
			list.add(5d);
			list.add(10d);
			list.add(2d);
			list.add(18d);
			list.add(10d);
			list.add(1d);
			list.add(2d);
			list.add(1d);
			list.add(13d);
			list.add(16d);
			list.add(14d);
			list.add(1d);
			list.add(1d);
			list.add(0d);
			list.add(7d);
			list.add(8d);
			list.add(6d);
			list.add(13d);
			list.add(3d);
			list.add(1d);
			list.add(12d);
			list.add(8d);
			list.add(16d);
			list.add(6d);
			list.add(2d);
			list.add(16d);
			list.add(6d);
			list.add(4d);
			list.add(6d);
			list.add(28d);
			list.add(0d);
			list.add(8d);
			list.add(14d);
			list.add(4d);
			list.add(3d);
			list.add(1d);
			list.add(2d);
			list.add(3d);
			list.add(5d);
			list.add(3d);
			list.add(25d);
			list.add(2d);
			list.add(1d);
			list.add(0d);
			list.add(5d);
			list.add(22d);
			list.add(1d);
			list.add(0d);
			list.add(6d);
			return list;
	}
}

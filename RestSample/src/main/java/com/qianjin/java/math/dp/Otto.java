package com.qianjin.java.math.dp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Otto {

	public static class Point {
		public int x;
		public int y;
		public int score;

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", score=" + score + "]";
		}

		public Point() {

		}

		private double instanceWithAnother(Point p2) {
			return Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y));
		}

		public double timeToAnother(Point p2) {
			double ret = 0.0;
			ret = instanceWithAnother(p2) / 2;
			ret = ret + 10;
			return ret;
		}
	}

	public static void printGoodTime(ArrayList<Point> pointList) {

		
		try {
			String str=FileUtils.readFileToString(new File("d:/work/access_log"));
			List list=FileUtils.readLines(new File("d:/access_log"));
			for(int i=0;i<list.size();i++){
				String line=(String)list.get(i);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Point startPoint = new Point();
		startPoint.x = 0;
		startPoint.y = 0;
		startPoint.score = 0;

		Point endPoint = new Point();
		endPoint.x = 100;
		endPoint.y = 100;
		endPoint.score = 0;
		double totalTime = 0;
		double previousMinRow = 0;
		int numbers = pointList.size();
		double[] steps=new double[numbers];
		System.out.println("numbers=" + numbers);
		for (int i = numbers + 1; i >= 0; i--) {
			double minRow = 0;
			Point currentPoint;

			if (i == numbers + 1) {
				minRow = 0;
				totalTime =  minRow;
			} else if (i == numbers) {
				currentPoint = (Point) pointList.get(i - 1);
				minRow = endPoint.timeToAnother(currentPoint);
				totalTime =  minRow;
				steps[numbers-1]=minRow;
			} else if (i == 0) {
				currentPoint = (Point) pointList.get(i);
				minRow = startPoint.timeToAnother(currentPoint);
				totalTime = totalTime+ minRow;
			} else {
				currentPoint = (Point) pointList.get(i - 1);
				int sum = 0;
				for (int j = i; j < numbers; j++) {
					Point pp = (Point) pointList.get(j);
					sum = sum + pp.score;
//					System.out.println("i=" + i + ",j=" + j + ",sum=" + sum);

				}
				// firstly, time from 100,100 to current postiion directly
				double fromEndPointToCurrentPostion = endPoint.timeToAnother(currentPoint);
				fromEndPointToCurrentPostion = fromEndPointToCurrentPostion + sum;

				double[] temp= new double[numbers-i];
				double min=Double.MAX_VALUE;
				for(int j=i;j<numbers;j++){
					Point pp=(Point)pointList.get(j);
					temp[j-i]=currentPoint.timeToAnother(pp);
					double newStep=temp[j-i]+steps[j-i];
					if(newStep<min)
						min=newStep;
					System.out.println("j="+j+",i="+i+",min="+min+",newStep="+newStep);
				}
				System.out.println("current min="+min);
				
				// secondly, from previous position to current position
//				double fromPreivousToCurrentPosition = currentPoint.timeToAnother((Point) pointList.get(i));
//				fromPreivousToCurrentPosition = previousMinRow + fromPreivousToCurrentPosition;

				if (fromEndPointToCurrentPostion > min)
					minRow = min;
				else
					minRow = fromEndPointToCurrentPostion;
				totalTime =  minRow;
				System.out.println("i=" + i + ",sum=" + sum + ",minRow=" + minRow + ",min="
						+ min + ",fromEndPointToCurrentPostion=" + fromEndPointToCurrentPostion);

			}
//			System.out.println("i=" + i + ",minRow=" + minRow);
			previousMinRow = minRow;
			
		}

		System.out.println("totalTime=" + String.format("%.3f", totalTime));
	}

	public static void printTime(ArrayList<Point> pointList) {
		Point startPoint = new Point();
		startPoint.x = 0;
		startPoint.y = 0;
		startPoint.score = 0;

		Point endPoint = new Point();
		endPoint.x = 100;
		endPoint.y = 100;
		endPoint.score = 0;
		double totalTime = 0;
		double previousMinRow = 0;
		for (int i = 0; i < pointList.size() + 2; i++) {
			double minRow = 0;
			if (i == 0) {
				minRow = 0;
			} else {

				Point currentPoint;
				if (i == (pointList.size() + 1))
					currentPoint = endPoint;
				else
					currentPoint = (Point) pointList.get(i - 1);
				if (i == 1) {
					minRow = currentPoint.timeToAnother(startPoint);
					// System.out.println("i=" + i + ",minRow=" + minRow);
				} else {
					int sum = 0;
					for (int j = 0; j <= i - 2; j++) {
						Point pp = (Point) pointList.get(j);
						sum = sum + pp.score;
						// System.out.println("i=" + i + ",j=" + j + ",sum=" +
						// sum);

					}
					// firstly, time from 0,0 to current postiion directly
					double fromZeroToCurrentPostion = currentPoint.timeToAnother(startPoint);
					fromZeroToCurrentPostion = fromZeroToCurrentPostion + sum;

					// secondly, from previous position to current position
					double fromPreivousToCurrentPosition = currentPoint.timeToAnother((Point) pointList.get(i - 2));
					fromPreivousToCurrentPosition = previousMinRow + fromPreivousToCurrentPosition;

					if (fromZeroToCurrentPostion > fromPreivousToCurrentPosition)
						minRow = fromPreivousToCurrentPosition;
					else
						minRow = fromZeroToCurrentPostion;
					System.out.println("i=" + i + ",sum=" + sum + ",minRow=" + minRow
							+ ",fromPreivousToCurrentPosition=" + fromPreivousToCurrentPosition
							+ ",fromZeroToCurrentPostion=" + fromZeroToCurrentPostion);
				}

			}

			previousMinRow = minRow;
			totalTime = minRow;
			// System.out.println("totalTime=" + totalTime);
		}

		System.out.println(String.format("%.3f", totalTime));
	}

	public static ArrayList<Point> generateList(ArrayList list) {
		ArrayList<Point> pointList = new ArrayList<Point>();
		for (int i = 0; i < list.size(); i++) {
			Point p = new Otto.Point();
			String line = (String) list.get(i);
			String[] strs = line.split(" ");
			int x = Integer.valueOf(strs[0]);
			int y = Integer.valueOf(strs[1]);
			int z = Integer.valueOf(strs[2]);
			p.x = x;
			p.y = y;
			p.score = z;
			pointList.add(p);
		}

		return pointList;

	}

	public static ArrayList getData(File file) {
		ArrayList ret = new ArrayList();
		try {
			List list = FileUtils.readLines(file);
			int firstCount = 1;
			int currentRow = 0;
			while (true) {

				String firstRow = (String) list.get(currentRow);
				// System.out.println("firstRow="+firstRow);
				firstCount = Integer.valueOf(firstRow);
				if (firstCount == 0)
					break;
				ArrayList data = new ArrayList();
				for (int i = 0; i < firstCount; i++) {
					String ss = (String) list.get(currentRow + 1);
					data.add(ss);
					currentRow++;
					// System.out.println("firstCount="+firstCount+",i="+i+",ss="+ss+",currentRow="+currentRow);
				}
				currentRow++;
				ret.add(data);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File file = new File("C:/Users/danxun.jiao/Downloads/otto_challenge/sample_input_small.txt");
			ArrayList list = getData(file);
			System.out.println(file.getName());
			for (int i = 0; i < list.size(); i++) {
				ArrayList ll = (ArrayList) list.get(i);
				// System.out.println("i=" + i + ",ll size is:" + ll.size());
				ArrayList<Point> pointList = generateList(ll);
				printGoodTime(pointList);
			}

//			file = new File("C:/Users/danxun.jiao/Downloads/otto_challenge/sample_input_medium.txt");
//			list = getData(file);
//			System.out.println(file.getName());
//			for (int i = 0; i < list.size(); i++) {
//				ArrayList ll = (ArrayList) list.get(i);
//				// System.out.println("i=" + i + ",ll size is:" + ll.size());
//				ArrayList<Point> pointList = generateList(ll);
//				printGoodTime(pointList);
//			}
//
//			file = new File("C:/Users/danxun.jiao/Downloads/otto_challenge/sample_input_large.txt");
//			list = getData(file);
//			System.out.println(file.getName());
//			for (int i = 0; i < list.size(); i++) {
//				ArrayList ll = (ArrayList) list.get(i);
//				// System.out.println("i=" + i + ",ll size is:" + ll.size());
//				ArrayList<Point> pointList = generateList(ll);
//				printGoodTime(pointList);
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

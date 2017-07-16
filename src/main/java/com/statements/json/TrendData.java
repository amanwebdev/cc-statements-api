package com.statements.json;

import java.util.ArrayList;
import java.util.List;

public class TrendData {
	private int id =1;
	
	private static final String[] categories = { "Apr", "May", "Jun", "Jul", "Aug", "Sep" };
	private List<Series> series;
	private List<LineSeries> lineSeries;
	

	public void addSeries(String name, Integer[] data){
		if(series==null){
			 series = new ArrayList<Series>();
		}
		this.series.add(new Series(name, data));
	}
	
	public void addLineSeries(String name, Object[] data){
		if(lineSeries==null){
			lineSeries = new ArrayList<LineSeries>();
		}
		this.lineSeries.add(new LineSeries(name, data));
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	public String[] getCategories() {
		return categories;
	}

	public List<LineSeries> getLineSeries() {
		return lineSeries;
	}

	public void setLineSeries(List<LineSeries> lineSeries) {
		this.lineSeries = lineSeries;
	}
	
	
	
	
}
class Series{
	private String name;
	private Integer[] data;
	private String[] colors =  {"#7cb5ec", "#434348", "#90ed7d", "#f7a35c", "#8085e9", "#f15c80", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1"};

	public Series(String name, Integer[] data) {
		super();
		this.name = name;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer[] getData() {
		return data;
	}
	public void setData(Integer[] data) {
		this.data = data;
	}
	public String[] getColors(){
		return this.colors;
	}

}
class LineSeries{
	private String name;
	private Object[] data;
	private String[] colors =  {"#7cb5ec", "#434348", "#90ed7d", "#f7a35c", "#8085e9", "#f15c80", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1"};

	public LineSeries(String name, Object[] data) {
		super();
		this.name = name;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object[] getData() {
		return data;
	}
	public void setData(Object[] data) {
		this.data = data;
	}
	public String[] getColors(){
		return this.colors;
	}

}
package com.test.ec.exploreCalifornia.domain;

public enum Region {
	Central_Coast("Central Coast"), Southern_California("Southern California"), Northern_California("Northern California"), Varies("Varies");
	private String lable;
	private Region(String lable) {
		this.lable=lable;
	}
	public Region findByLabel(String label) {
		for(Region r: Region.values()) {
			if(r.lable.equalsIgnoreCase(label)) {
				return r;
			}
		}
		return null;
	}
}
  
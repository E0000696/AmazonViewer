package com.capgemini.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	Date startToSee(Date date);
	void stopToSee(Date dateI, Date dateF);
	
}

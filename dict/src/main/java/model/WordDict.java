package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordDict implements Serializable{
	private String wordName;
	private List<Item> wordExplain =new LinkedList<Item>();
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public List<Item> getWordExplain() {
		return wordExplain;
	}
	public void setWordExplain(List<Item> wordExplain) {
		this.wordExplain = wordExplain;
	}

}


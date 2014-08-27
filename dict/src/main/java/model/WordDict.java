package model;

import java.util.ArrayList;
import java.util.List;

class WordDict{
	private String wordName;
	private List<String> wordExplain =new ArrayList<String>();
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public List<String> getWordExplain() {
		return wordExplain;
	}
	public void setWordExplain(List<String> wordExplain) {
		this.wordExplain = wordExplain;
	}
}
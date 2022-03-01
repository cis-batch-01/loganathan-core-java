package com.Chapter;

import java.util.ArrayList;
import java.util.List;



public class ChapterBo {
	public Chapter findById(List<Chapter> chapterList, int id) {
		Chapter chapter1 = null;
		for (Chapter chapter : chapterList) {

			if (chapter.getChapterId() == id) {
				chapter1 = chapter;
			}

		}

		return chapter1;
	}

	public List<Chapter> filterByChapterName(List<Chapter> chapterList, String chapterName) {
		List<Chapter> resList = new ArrayList<Chapter>();
		for (Chapter chapter : chapterList) {

			if (chapter.getChapterName().contains(chapterName)) {
				resList.add(chapter);
			}

		}
		return resList;
	}
}

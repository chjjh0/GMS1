package domain;

public class ExamBean {
	private String examSeq, recordSeq, subSeq, memId, month, score;
	
	@Override
	public String toString() {
		return "정보 [examSeq = " + examSeq + 
				" recordSeq = " + recordSeq + 
				" subSeq = " + subSeq + 
				" memId = " + memId	+
				" month = " + month + 
				" score = " + score + "]";
	}
	
	public String getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(String examSeq) {
		this.examSeq = examSeq;
	}

	public String getRecordSeq() {
		return recordSeq;
	}

	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}

	public String getSubSeq() {
		return subSeq;
	}

	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	
	
}

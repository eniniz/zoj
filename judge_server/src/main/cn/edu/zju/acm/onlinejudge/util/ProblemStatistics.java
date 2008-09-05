package cn.edu.zju.acm.onlinejudge.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zju.acm.onlinejudge.bean.Submission;
import cn.edu.zju.acm.onlinejudge.bean.enumeration.JudgeReply;

public class ProblemStatistics {
	Map<Long, Integer> counts = new HashMap<Long, Integer>();
	private final long problemId;
	private final String orderBy;
	private int total = 0;
	private List<Submission> bestRuns = null;
	
	public ProblemStatistics(long problemId, String orderBy) {
		this.problemId = problemId;
		this.orderBy = orderBy;
	}
	
	public long getProblemId() {
		return problemId;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getCount(JudgeReply judgeReply) {
		return getCount(judgeReply.getId());
	}
	
	public double getPercentage(JudgeReply judgeReply) {
		return getPercentage(judgeReply.getId());
	}
	
	public double getPercentage(long judgeReplyId) {
		return total == 0 ? 0 : 1.0 * getCount(judgeReplyId) / total;
	}
	
	public int getPercentageInt(JudgeReply judgeReply) {
		return getPercentageInt(judgeReply.getId());
	}
	
	public int getPercentageInt(long judgeReplyId) {
		return total == 0 ? 0 : getCount(judgeReplyId) * 100 / total;
	}
	
	public int getCount(long judgeReplyId) {
		return counts.containsKey(judgeReplyId) ? counts.get(judgeReplyId) : 0;
	}
	
	public void setCount(JudgeReply judgeReply, int value) {
		setCount(judgeReply.getId(), value);
	}
	
	public void setCount(long judgeReplyId, int value) {
		total -= getCount(judgeReplyId);
		counts.put(judgeReplyId, value);
		total += value;
	}

	public List<Submission> getBestRuns() {
		return bestRuns;
	}

	public void setBestRuns(List<Submission> bestRuns) {
		this.bestRuns = bestRuns;
	}
	
}

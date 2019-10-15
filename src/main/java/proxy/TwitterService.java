package proxy;

public interface TwitterService {
	public String getTimeline(String screenName);
	public void postToTimeLine(String screenMane, String message);
}

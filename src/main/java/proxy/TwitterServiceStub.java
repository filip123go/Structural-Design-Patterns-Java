package proxy;

public class TwitterServiceStub implements TwitterService {
	@Override
	public String getTimeline(String screenName) {
		return "My timeline";
	}

	@Override
	public void postToTimeLine(String screenMane, String message) {

	}
}
